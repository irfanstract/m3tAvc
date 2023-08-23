package avcframewrk.forms

package templating













trait AcsfLabelledCallbackTranslator[+M]
extends
AnyRef
with AcsfTitleIndependentCodings1
with AcsfReadinessIndCodings1
with AcsfDispatchTimeCtxIndependentCodings1
with AcsfReturnIndependentCodings1
{

   //

   def apply
      [
         //
         AcModelState ,
         IsReady : CReadinessCoding ,
         Title : TitleCoding ,
         P : CallbackCtxCoding ,
         R : ReturnCoding ,

      ]
      (
         //
         internalStateOption : avcframewrk.evm.AsyncAlgebraicMonad[AcModelState]
         = { monix.reactive.Observable(true ) }
         ,
         isReadyState : AcModelState => IsReady
         = identity[Any => Unit ](_ => {} )
         ,
         baseTitle: Title
         ,
         updatedTitle: (baseTitle: Title, internalState: AcModelState ) => Title
         = (baseTitle: Title, s: AcModelState ) => baseTitle
         ,
      )
      (doTheMainThing: PartialFunction[P, R] )
      : M

} // AcsfLabelledCallbackTranslator

object AcsfLabelledCallbackTranslator
{

   //

   private[AcsfLabelledCallbackTranslator]
   trait XAllApcGivens extends
   AnyRef
   with AcsfTitleIndependentCodings1
   with AcsfReadinessIndCodings1
   with AcsfDispatchTimeCtxIndependentCodings1
   with AcsfReturnIndependentCodings1
   {
      //

      // TODO
      override
      opaque type TitleCoding[-Value]
         /* made a refinement of `Tuple2` introducing dependent-typing (eg the adapter's param-type is set to `this._1.CAP` ) */
         /* the keyword `CAP` was inspired by the (internal) API `scala.runtime.TypeBox`, which Scala 3 relied on */
         <: ({ type CAP >: Value    }, Nothing => String ) { val _2 : (value: _1.CAP) => (value.type & String ) }
         =  ({ type CAP >: Value    }, Nothing => String ) { val _2 : (value: _1.CAP) => (value.type & String ) }
      override
      implicit
      def stringAcTitling[Value <: String]
      = {
         val tb1 = new AnyRef().asInstanceOf[{ type CAP >: Value <: Value }]
         identity[(tb1.type, (value: tb1.CAP) => (value.type & String ) )]((
            tb1 ,
            (e) => e ,
         ))
      }

      export AcsfReadinessIndCodings1.whichTranslatesToHalfs.{*, given}

      export AcCallbackCtxIndependentCodings1.ofOpcev.{*, given}

      export AcReturnIndependentCodings1.whichTranslatesToEitheres.{*, given}

      case class Puv[+R](src: avcframewrk.evm.AsyncAlgebraicMonad[R] )

   }

   given AcsfLabelledCallbackTranslator[(XAllApcGivens#Puv[String], () => Either[Unit | Throwable, Unit] ) ]
   with XAllApcGivens
   with {
      //

      ;

      ;

      override
      def apply
         [
            //
            AcModelState ,
            IsReady : CReadinessCoding ,
            Title : TitleCoding ,
            P : CallbackCtxCoding ,
            R : ReturnCoding ,

         ]
         (
            //
            internalStateOption : avcframewrk.evm.AsyncAlgebraicMonad[AcModelState]
            ,
            isReadyState : AcModelState => IsReady
            ,
            baseTitle: Title
            ,
            updatedTitle: (baseTitle: Title, internalState: AcModelState ) => Title
            ,
         )
         (doTheMainThing: PartialFunction[P, R] )
      = {
         // TODO
         {
            ;

            def tryDoTheMainThing()
            : Either[Unit | Throwable, Unit]
            = {
               //

               val evtInfo
               = (summon[CallbackCtxCoding[P] ] ).apply()

               val returnValue
               = {
                  doTheMainThing
                  .lift
                  .andThen[Either[MatchError, R] ](o => o.toRight(new MatchError(s"rejected event") ) )
                  .andThen(o => o.flatMap((r: R) => (summon[ReturnCoding[R] ] ).translate(r ) ) )
                  .apply(evtInfo )
               }

               returnValue
            }

            val updatedLabelOption
            = {
               internalStateOption
               .map(state => updatedTitle(baseTitle, state ) )
               .map((summon[TitleCoding[Title] ] )._2 )
            }

            (Puv(updatedLabelOption) , () => tryDoTheMainThing() )
         }
      }

   } // given AcsfLabelledCallbackTranslator[() => Either[Unit | Throwable, Unit] ]

} // AcsfLabelledCallbackTranslator$

type AcsfTitleIndependentCodings1
= AcTitleIndependentCodings1

trait AcsfReadinessIndCodings1
extends
AnyRef
{

   //

   type CReadinessCoding[-R]

   /** one states, always "totally ready" */
   given cRdnssu
   : CReadinessCoding[Unit]

   /** two states -- "not ready" and "totally ready" */
   given cRdnsBi
   : CReadinessCoding[Boolean]

   /** three states -- "not ready" and "partially ready" and "totally ready" */
   given cRdnsFrc
   : CReadinessCoding[0 | 0.5d | 1 ]

} // AcsfReadinessIndCodings1

object AcsfReadinessIndCodings1
{

   //

   /**
    * 
    * a default implementation which coerces into enum of three FP values `0`, `0.5`, `1`
    * 
    * your code can simply `export` everything from here:
    * ```
    * trait Action .........
    * 
    * object Action extends AcsfReadinessIndCodings1 {
    *    export AcsfReadinessIndCodings1.ReturnCoding
    *    export AcsfReadinessIndCodings1.{given }
    * }
    * ```
    * 
    */
   object whichTranslatesToHalfs
   extends
   AcsfReadinessIndCodings1
   {

      //

      trait CReadinessCoding[-P ]
      { def translate(value0: P ): 0 | 0.5 | 1 }

      /** one states, always "totally ready" */
      override
      given cRdnssu
      : CReadinessCoding[Unit]
      with { override def translate(value: Unit ): 1 = 1 }

      /** two states -- "not ready" and "totally ready" */
      override
      given cRdnsBi
      : CReadinessCoding[Boolean]
      with {

         type Translated[V <: Boolean]
            <: 0 | 1
            = V match { case true => 1 case false => 0 }

         override
         def translate(value: Boolean )
         : Translated[value.type]
         = {
            (value match { case true => 1 ; case false => 0 } )
            .asInstanceOf[Translated[value.type] ] // TODO remove this LOC if possible
         }

      }

      /** three states -- "not ready" and "partially ready" and "totally ready" */
      override
      given cRdnsFrc
      : CReadinessCoding[0 | 0.5 | 1 ]
      with { override def translate(value: 0 | 0.5 | 1 ): value.type = value }

   }

} // AcsfReadinessIndCodings1$

// trait AcsfReadinessListenability1
// extends
// AnyRef
// {
//    this : (
//       AnyRef
//       & AcsfTitleIndependentCodings1
//    ) =>

//    //

//    extension [Title : TitleCoding](key: Title)
//       def readinessOption
//       : avcframewrk.evm.AsyncAlgebraicMonad[0 | 0.5d | 1 ]

// }

type AcsfDispatchTimeCtxIndependentCodings1
= AcCallbackCtxIndependentCodings1

type AcsfReturnIndependentCodings1
= AcReturnIndependentCodings1















