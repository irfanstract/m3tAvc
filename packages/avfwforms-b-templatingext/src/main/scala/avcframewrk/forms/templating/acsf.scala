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
         internalStateOption : AsyncStateChangeMonad[AcModelState]
         = { laminar.api.L.Var(true ).signal }
         ,
         isReadyState : AcModelState => IsReady
         = identity[Any => Unit ](_ => {} )
         ,
         baseTitle: Title
         ,
         updatedTitle: AcsfBaseTitleAndInternalStateCallback[Title, AcModelState, Title ]
         = (baseTitle: Title, s: AcModelState ) => baseTitle
         ,
      )
      (doTheMainThing: PartialFunction[P, R] )
      : M

} // AcsfLabelledCallbackTranslator

object AcsfLabelledCallbackTranslator
{

   //

} // AcsfLabelledCallbackTranslator$

trait AcsfLabelledUrlTranslator[+M]
extends
AnyRef
with AcsfTitleIndependentCodings1
with AcsfReturnIndependentCodings1
{

   //

   def apply
      [
         //
         AcModelState ,
         Title : TitleCoding ,
         R <: java.net.URI ,

      ]
      (
         //
         internalStateOption : AsyncStateChangeMonad[AcModelState]
         = { laminar.api.L.Var(true ).signal }
         ,
         baseTitle: Title
         ,
         updatedTitle: AcsfBaseTitleAndInternalStateCallback[Title, AcModelState, Title ]
         = (baseTitle: Title, s: AcModelState ) => baseTitle
         ,
      )
      (byS: PartialFunction[AcModelState, R] )
      : M

} // AcsfLabelledUrlTranslator

object AcsfLabelledUrlTranslator
{
   ;
} // AcsfLabelledUrlTranslator$

/**
 * 
 * a callback with those two param-val(s) -
 * `baseTitle: Title`, `internalState: AcModelState`
 * 
 */
type AcsfBaseTitleAndInternalStateCallback
   [-Title, -AcModelState, +R ]
= (baseTitle: Title, internalState: AcModelState ) => R

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















