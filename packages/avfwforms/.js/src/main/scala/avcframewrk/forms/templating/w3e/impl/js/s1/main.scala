package avcframewrk.forms

package templating

package w3e.impl.js

package s1
















final
lazy val ebAll
= {
   new AnyRef
   with EbAndReconcilability
   with EbButtons
}

trait EbButtons
{
   this : (
      AnyRef
      & EbAndReconcilability
   ) =>
   //

   //

   import SjsEOps.{*, given}

   //

   private[avcframewrk]
   def newClickEvent()
   : AnyRef & Product
   = {

      case object clickEvent extends
         AnyRef
      clickEvent
   }

   //

   extension (e: org.scalajs.dom.html.Element & LaminarBasedNativeElementRef.LlNessAs[org.scalajs.dom.html.Element] ) {

      def enabledness_=(vl: 0 | 0.5 | 1 )
      : Unit
      = {
         (laminar.api.L.disabled ).:=(vl match { case 0 => false ; case 0.5 | 1 => true } )
         .apply(e.devLaminarWrapperEH )
      }

      @deprecated
      def enabledD_=(vl: 0 | 0.5 | 1 )
      : Unit
      = {
         enabledness_=(vl)
      }

   }

   // HTMLButtonElement | HTMLAElement
   private[avcframewrk]
   type BHA0
   =
      org.scalajs.dom.html.Button
      | org.scalajs.dom.html.Button
      | org.scalajs.dom.html.Anchor
      | org.scalajs.dom.html.Input
      | org.scalajs.dom.html.Select

   private[avcframewrk]
   type BHA
   = ([A] =>> (A & LaminarBasedNativeElementRef.LlNessAs[A] ) )[BHA0]

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

   given given_AcsfLabelledCallbackTranslator_Edsb
   : AcsfLabelledCallbackTranslator[ButtonOrAHrefDesc1 ]
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
            ButtonOrAHrefDesc1(
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

   case class ButtonOrAHrefDesc1(
      edsb: Edsb[?, SjsEOps] ,
      callback: (evt: AnyRef & Product) => util.Try[Unit] ,
   )
   extends
   AnyRef
   {
      //

      val headlineDescr
      = edsb.baseTitle

   }

   private[EbButtons]
   def buttonReconciler
      [
         ComparableSpawnedElement
         >: ClassOps#ComparableSpawnedElement & BHA
         <: ClassOps#ComparableSpawnedElement & BHA
         : reflect.Typeable
         ,
      ]
      (desc : ButtonOrAHrefDesc1)
   : PerSampleSpawningAndReconcilingOps[ComparableSpawnedElement]
   = {
      //

      import desc.*

      object impl1 extends
      AnyRef
      with PerSampleSpawningAndReconcilingOps[ComparableSpawnedElement]
      {
         ;

         //

         /**
          *
          * in-place update of it.
          *
          */
         override
         def updateAndSelf(e: ComparableSpawnedElement )
         : e.type
         = {

            updateHeadingOf(e)

            updateOnclickHandler(e)

            e
         }

         /** manually clear and (re)populate */
         private[impl1]
         def recreateHeading(operand: ComparableSpawnedElement )
         : headlineDescr.SpawnedElement
         = {
            ;

            operand.innerHTML = ""

            val newPeer = headlineDescr.spawn()

            operand appendChild(newPeer )

            newPeer
         }

         private[impl1]
         def tryUpdateHeadingOfGivenElemFast(e: ComparableSpawnedElement )
         : Either[Unit, headlineDescr.ComparableSpawnedElement ]
         = {
            //

            e.childNodes.toIndexedSeq match {

               case (ec : headlineDescr.ComparableSpawnedElement) +: Seq() =>
                  headlineDescr updateAndSelf(ec)
                  Right(ec )

               case _ =>
                  Left(() )
            }
         }

         private[impl1]
         def updateHeadingOf(e: ComparableSpawnedElement )
         : Unit
         = {
            //

            /**
             *
             * in general `recreateHeading(e)`, but
             * strive for `tryUpdateHeadingOfGivenElemFast(e )`
             *
             */
            tryUpdateHeadingOfGivenElemFast(e)

            .getOrElse[headlineDescr.ComparableSpawnedElement ]({
               //

               recreateHeading(e)
            })

         }

         /**
          *
          * reassign its `onClick`
          *
          */
         private[impl1]
         def updateOnclickHandler(e: ComparableSpawnedElement )
         : Unit
         = {
            ;

            e.onclick = (
               (evt) => {
                  // TODO
                  callback({ case object clickEvent {} ; clickEvent })
                  .recover[Unit]({ case scala.util.control.NonFatal(z : Exception) => {
                     // Thread.sleep(1 * 1000 ) /* not supported in ScJS */
                     z.printStackTrace()
                  } })
                  .get
               }
            )

         }

         //

         /**
          *
          * .
          *
          */
         override
         def spawn()
         = {
            // TODO
            {
               ;

               val e = {
                  (laminar.api.L.button() )
                  .setupBackreferenceAndGetReferent()
                  .asInstanceOf[ComparableSpawnedElement]
               }

               /**
                * `scheduleLoopedUpdateOfEnabledness`
                * 
                */
               new `&@@!`(e = e, key = "scheduleNextUpdateOfEnabledness", dSrc = edsb.stateCheckedOption )((e, vl) => {

                  e.enabledness_=(vl)

                  ()
               } )

               // TODO
               updateAndSelf(e)

               e
            }
         }

         //

         @deprecated
         override
         def toHTML()
         : String
         = {

            import language.unsafeNulls

            spawn().outerHTML
            .replaceAll("\\A[<](?:button|a|anchor|input)\\b", "$0 onclick=\"[native code]\" ")
         }

      }
      impl1
   }

   private[avcframewrk]
   final
   lazy
   val buttonOrAHrefTImpl
   = {
      ;

      SbBcd[ClassOps#ComparableSpawnedElement & BHA, ButtonOrAHrefDesc1, scala.Product](
         buttonReconciler = (
            (mdl: ButtonOrAHrefDesc1) =>
            (givenBhaCseTypeable: reflect.Typeable[ClassOps#ComparableSpawnedElement & BHA] ) ?=>
            { buttonReconciler[ClassOps#ComparableSpawnedElement & BHA ](desc = mdl ) }
         ) ,
      )
   }

   export buttonOrAHrefTImpl.{classOpsImpl as buttonOrAHrefClassOps }

   export buttonOrAHrefTImpl.{ClassInstanceOpsImpl as ButtonOrAHrefDesc }

}
















val _ = {}