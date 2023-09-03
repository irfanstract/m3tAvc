package avcframewrk.forms

package templating

package w3e.pre












trait Buttons
extends
AnyRef
with Articles
{

   type Action

   val Action
   : (
      AnyRef
      & AcsfLabelledCallbackTranslator[Action]
   )

   /** 
    * `URLAction`
    * 
    * needs to be a separate NS since
    * the default-parameterisations prevent overloading `-____-`
    * 
    */
   val URLAction
   : (
      AnyRef
      & AcsfLabelledUrlTranslator[URLAction]

   ) // URLAction$

   type URLAction
   >: Action
   <: Action

   type ButtonArt
      <: Article

   def describeButtonByAction(action: Action)
   : ButtonArt

   extension (mainLineContents: Article) {

      /**
       * with clickability leading to the specified Action
       * 
       */
      def asHavingDirectAction(action: Action)
      : Article
      = {
         (mainLineContents ++ describeButtonByAction(action ) )
      }

   } // (mainLineContents: Article) asHavingDirectAction(action: Action)

}

object VarEditingActionsProv
{
   ;

   ;

} // VarEditingActionsProv$

trait VarEditingActionsProv
extends
AnyRef
with StdGsps
{
   this : (
      AnyRef
      & Buttons
      & StdGsps
   ) =>
   ;

   ;

   import laminar.api.L

   ;

   /**
    * `Action`s which each updates the `Var`.
    * 
    */
   val VarEditingAction
   : (
      AnyRef

      & (
         /** 
          * `[Value given GivenSpinner] -> (varLike : VarLike[Value] ) -> Action`
          * 
          * anticipating some 3rd party libs which provides "mapped var(s)" which `extends` both these `trait`s yet does not `extends` `Var#`.
          * `Var[type A]#` `extends` both `SignalSource[A]#` and `Sink[A]#`
          * 
          */
         [Value] =>
         (baseTitle: String | Article ) =>
         (operand: L.SignalSource[Value] & L.Sink[Value] ) =>
         (GivenSpinner[Value] ) ?=>
            Action
      )

   )
   lazy val _ = {
      val f = VarEditingAction
      f.apply("")(??? : L.Var["5"] )
   }

   ;

   ;
} // VarEditingActionsProv#

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
    * support for editor for `Value#`
    * 
    * `Value#` is contra-variant
    * 
    */
   type GivenSpinner[-Value]

   given given_GivenSpinner_String
   : GivenSpinner[String]

   type GivenSpinnerNumerical[-Value <: AnyVal | java.lang.Number ]
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

      type GivenSpinner[-Value]
      >: GivenSpinner1[? >: Value]
      <: GivenSpinner1[? >: Value]

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

      quoted.Type

      ;

      given given_GivenSpinner_String
      : AnyRef
         with GivenSpinner1[String](parse = { case v => v } )

      ;

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











