package avcframewrk.forms

package templating

package w3e.pre
















/**
 * 
 * defs specifically for properly implementing `VarEditingAction` in `VarEditingActionsProv`
 * 
 * every instance of `GivenSpinner[type Value]#`
 * shall serve the minimums to spin/edit values each an instance of `Value#`
 * 
 */
trait StdGsps
extends
AnyRef
{
   this : (
      AnyRef
   ) =>
   ;

   ;

   /**
    * support for editor for any of these data-types
    * - phrase
    * - passphrase
    * - CSS Color(s)
    * - date
    * - numerical
    * - boolean
    * 
    * `Value#` is contra-variant
    * 
    */
   type GivenSpinner[Value]

   given given_GivenSpinner_String
   : GivenSpinner[String]

   given given_GivenSpinner_CSSColorValue
   : GivenSpinner[StdGsps.CSSColorValue ]

   given given_GivenSpinner_DateTime
   : GivenSpinner[StdGsps.DateTime ]

   type GivenSpinnerNumerical[Value <: AnyVal | java.lang.Number ]
   = GivenSpinner[Value]

   given given_GivenSpinner_Number
      [Value <: (
         java.lang.Number
         | BigDecimal
         | (Double | Float )
         | (java.math.BigInteger | BigInt | Long | Int | Short | Byte )
      )]
      (using Numeric[Value ] )
   : GivenSpinnerNumerical[Value ]

   given given_GivenSpinner_Boolean
   : GivenSpinner[Boolean]

   ;
} // StdGsps#

/**
 * 
 * `StdGsps`
 * 
 * there's an impl, `ofSnb` ;
 * simply `export StdGsps.ofSnb.{*, given }` in a sub-class
 * 
 */
object StdGsps
{
   ;

   ;

   type CSSColorValue
   >: ({ type Main[T] = T match { case reflect.TypeTest[?, t] => t } })#Main[given_TypeTest_CSSColorValue.type ]
   <: ({ type Main[T] = T match { case reflect.TypeTest[?, t] => t } })#Main[given_TypeTest_CSSColorValue.type ]

   given given_TypeTest_CSSColorValue
   : reflect.TypeTest[Any, ? <: Matchable]
   = {
      ;
      ReopaquativeTypeTest.apply((v: String) => { v.matches("(?:\\w+\\(.*)|\\#\\w+") } )
   }

   type DateTime
   >: ({ type Main[T] = T match { case reflect.TypeTest[?, t] => t } })#Main[given_TypeTest_DateTime.type ]
   <: ({ type Main[T] = T match { case reflect.TypeTest[?, t] => t } })#Main[given_TypeTest_DateTime.type ]

   given given_TypeTest_DateTime
   : reflect.TypeTest[Any, ? <: Matchable]
   = {
      ;
      ReopaquativeTypeTest.apply((v: String) => { v.matches("\\w+(\\-\\w+)*") } )
   }

   ;

   /**
    * 
    * an impl of `StdGsps` based on `Numeric#parseString` and `PartialFunction`
    * 
    */
   final
   lazy val ofSnb
   : ofSnbImpl.type
   = {
      ofSnbImpl
   }

   private[StdGsps]
   given ofSnbImpl
   : StdGsps
   with {
      ;

      ;

      type GivenSpinner[Value]
      >: GivenSpinner1[Value]
      <: GivenSpinner1[Value]

      trait GivenSpinner1
         [Value]
         (val parse: PartialFunction[String, Value] )
      extends
      AnyRef
      with PartialFunction[String, Value]
      {

         export parse.isDefinedAt
         export parse.apply

         ;
      }
      object GivenSpinner1
      {
         ;

         ;
      }

      ;

      given given_GivenSpinner_String
      : GivenSpinner1[String](parse = { case v => v } )

      ;

      given given_GivenSpinner_CSSColorValue
      : GivenSpinner1[StdGsps.CSSColorValue ](parse = { case v: StdGsps.CSSColorValue => v } )

      given given_GivenSpinner_DateTime
      : AnyRef
      with GivenSpinner1[StdGsps.DateTime ](parse = { case v: StdGsps.DateTime => v } )

      // override
      given given_GivenSpinner_Number
         [Value <: (
            java.lang.Number
            | BigDecimal
            | (Double | Float )
            | (java.math.BigInteger | BigInt | Long | Int | Short | Byte )
         )]
         (using Numeric[Value ] )
      : AnyRef
         with GivenSpinner1(
            parse = (
               //

               // TODO
               (summon[Numeric[Value ] ].parseString _ )
               match { case f => f.unlift }
               match { case f => new AnyRef with GivenSpinner1(parse = f ) }

            ) ,
         )

      ;

      given given_GivenSpinner_Boolean
      : AnyRef
      with GivenSpinner1[Boolean](
         parse = {
            case "tru"  |  "true" | "True"  |  "TRUE" | "1" =>  true
            case "fals" | "false" | "False" | "FALSE" | "0" => false
         } ,
      )

      ;
   }

   ;

   ;
} // StdGsps.















val _ = {}
