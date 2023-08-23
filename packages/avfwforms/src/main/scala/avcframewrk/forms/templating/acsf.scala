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

}

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

}

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















