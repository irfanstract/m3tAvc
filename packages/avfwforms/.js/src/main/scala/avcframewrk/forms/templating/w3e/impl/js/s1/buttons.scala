package avcframewrk.forms

package templating

package w3e.impl.js

package s1















object SEnablednessDefs {
   ;

   trait OfHalfUnitScales
   {

      this : (
         AnyRef
         // & EbAndReconcilability
      ) =>

      ;

      // import SjsEOps.{*, given}

      ;

      extension (e: ({ type Main[E] = E & LaminarBasedNativeElementRef.LlNessAs[E] })#Main[org.scalajs.dom.html.Element ] ) {

         def enabledness_=(vl: 0 | 0.5 | 1 )
         : Unit
         = {
            e.devLaminarWrapperEH
            .amend(enablednessL := vl )
            // e
            // .bindAfw(enablednessL, Some[vl.type](vl) )
         }

         @deprecated
         def enabledD_=(vl: 0 | 0.5 | 1 )
         : Unit
         = {
            enabledness_=(vl)
         }

      }

      object enablednessL {
         import laminar.api.L
         import org.scalajs.dom

         def :=(vl: 0 | 0.5 | 1 )
         : L.Setter[com.raquo.laminar.nodes.ReactiveHtmlElement[dom.html.Element] ]
         = {
            L.Setter[com.raquo.laminar.nodes.ReactiveHtmlElement[dom.html.Element] ]({
               case e => { e.amend(L.disabled := (vl match { case 0 => false ; case 0.5 | 1 => true } ) ) }
            })
         }

      }

   }

}

trait EbButtons
extends
AnyRef
with SEnablednessDefs.OfHalfUnitScales
{
   this : (
      AnyRef
      & EbAndReconcilability
      & SEnablednessDefs.OfHalfUnitScales
   ) =>
   //

   //

   ;

   ;

   private[avcframewrk]
   def newClickEvent()
   : AnyRef & Product
   = {

      case object clickEvent extends
         AnyRef
      clickEvent
   }

   //

   private[avcframewrk]
   // erased
   val bhATyper
   : (
      ([T] =>> ([T] =>> { type CAP >: T <: T } )[([A] =>> (A & LaminarBasedNativeElementRef.LlNessAs[A] ) )[T] ] )
      [(
         //
         org.scalajs.dom.html.Button
         | org.scalajs.dom.html.Button
         | org.scalajs.dom.html.Anchor
         | org.scalajs.dom.html.Input
         | org.scalajs.dom.html.Select
      )]
   )
   = ([A] => () => new AnyRef().asInstanceOf[A] ).apply()

   private[avcframewrk]
   type BHA
   = bhATyper.CAP

   given given_AcsfLabelledCallbackTranslator_Edsb[SjsEOps]
   : AcsfLabelledCallbackTranslator[ButtonOrAHrefDesc1[?, SjsEOps ] ]
   with {
      ;

      // TODO
      opaque type TitleCoding[-Title ]
         <: (value: Title @annotation.unchecked.uncheckedVariance ) => (value.type & String )
         =  (value: Title @annotation.unchecked.uncheckedVariance ) => (value.type & String )

      implicit def stringAcTitling[Title <: String]
      = identity[(value: Title) => (value.type & String ) ](vl => vl )

      export AcsfReadinessIndCodings1.whichTranslatesToHalfs.{*, given}

      export AcCallbackCtxIndependentCodings1.ofOpcev.{*, given}

      export AcReturnIndependentCodings1.whichTranslatesToEitheres.{*, given}

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
            def elementFromString(v: String): SjsEOps = ???
            val elementFromTitle = {
               (summon[TitleCoding[Title] ].apply _ ) andThen (elementFromString _ )
            }
            def elementAsT(v: SjsEOps): Title = ???
            // TODO
            ButtonOrAHrefDesc1[AcModelState, SjsEOps ](
               //
               edsb = 
               Edsb[AcModelState, SjsEOps ](
                  stateOption = internalStateOption ,
                  stateCheck = isReadyState.andThen(summon[CReadinessCoding[IsReady ] ].translate _ ) ,
                  baseTitle = elementFromTitle(baseTitle) ,
                  stateTitle = { case (e, newState) => elementFromTitle(updatedTitle(elementAsT(e), newState) ) } ,
               )
               ,
               callback = 
                  // TODO
                  (outerEvt : AnyRef & Product ) => util.Try({ val evtInfo = summon[CallbackCtxCoding[P] ].apply() : P ; doTheMainThing(evtInfo) })
               ,
            )
         }

   }

   private[avcframewrk]
   case class Edsb[S, +T]
   (
      //
      stateOption: avcframewrk.evm.AsyncAlgebraicMonad[S]
      ,
      protected val
      stateCheck: S => (0 | 0.5 | 1)
      ,
      baseTitle: T
      ,
      private val
      stateTitle: (baseTitle: T @annotation.unchecked.uncheckedVariance, state: S ) => T
      ,
   )
   {

      val stateCheckedOption
      = {
         stateOption
         .map[0 | 0.5 | 1 ](stateCheck )
      }

      val stateTitleOption
      = {
         stateOption
         .map(s => stateTitle(baseTitle, s) )
      }

   }

   case class ButtonOrAHrefDesc1[S, +T](
      edsb: Edsb[S, T] ,
      callback: (evt: AnyRef & Product) => util.Try[Unit] ,
   )
   extends
   AnyRef
   {
      //

      val headlineDescr
      = edsb.baseTitle

   }

}






















