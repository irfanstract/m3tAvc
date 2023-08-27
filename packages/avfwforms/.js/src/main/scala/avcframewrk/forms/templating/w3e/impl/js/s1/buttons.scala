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

   implicit 
   object buttonlikeElemAutoDiffingOps1 {
      ;

      extension (operand: org.scalajs.dom.Element ) {
         //

         /**
          * unconditionally 
          * manually clear and (re)populate,
          * ignoring possible conformance to `headlineDescr.ComparableSpawnedElement`
          * 
          */
         def clearAndRecreateContents(headlineDescr : SjsEOps )
         : headlineDescr.SpawnedElement
         = {
            ;

            operand.innerHTML = ""

            val newPeer = headlineDescr.spawn()

            newPeer match {
               case newPeer : org.scalajs.dom.Node =>
                  operand appendChild(newPeer )
            }

            newPeer
         }

      } // (operand: org.scalajs.dom.Element ) clearAndRecreateContents

      extension (e: org.scalajs.dom.Element ) {

         def tryUpdateContentsFast1(headlineDescr : SjsEOps )
         : Either[Unit, headlineDescr.ComparableSpawnedElement ]
         = {
            //

            e.childNodes.toIndexedSeq match {

               case (ec : headlineDescr.ComparableSpawnedElement) +: Seq() =>
                  import SjsEOps.templateApplicativeImplicits.*
                  ec.model_=(headlineDescr )
                  Right(ec )

               case _ =>
                  Left(() )
            }
         }

      } // (operand: org.scalajs.dom.Element ) tryUpdateContentsFast1

   } // buttonlikeElemAutoDiffingOps1$

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
   : ClassInstanceSpecificReconcilingOps[ComparableSpawnedElement]
   = {
      //

      import desc.{*}

      import edsb.{
         *,
      }

      object impl1 extends
      AnyRef
      with ClassInstanceSpecificReconcilingOps[ComparableSpawnedElement]
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
            e.tryUpdateContentsFast1(headlineDescr )

            .getOrElse[headlineDescr.ComparableSpawnedElement ]({
               //

               e.clearAndRecreateContents(headlineDescr)
            })

         }

         /**
          *
          * reassign its *enabled*ness anim
          *
          */
         private[impl1]
         def updateEnabledness(e: ComparableSpawnedElement )
         : Unit
         = {
            ;

            import laminar.api.L

            e
               .bindAfw
               (key = L.disabled, valueSrc = {
                  ;
               
                  AirstreamFromMonix({
                     stateCheckedOption
                     .map({ case v : java.lang.Number => (0.33 < v.doubleValue() ) } )
                  })
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
                  import laminar.api.L
                  ((L.button() ).setupBackreferenceAndGetReferent() )
                  .asInstanceOf[ComparableSpawnedElement]
               }

               /**
                * `scheduleLoopedUpdateOfEnabledness`
                * 
                */
               (0 : Int) match {
                  // case 1 =>
                  //    ;

                  //    new `&@@!`(e = e, key = "scheduleNextUpdateOfEnabledness", dSrc = stateCheckedOption )((e, vl) => {

                  //       e.enabledness_=(vl)

                  //       ()
                  //    } )

                  case _ =>
                     import laminar.api.L
                     e
                     .bindAfw(L.disabled, stateCheckedOption.map({ case v : java.lang.Number => 0.33 < v.doubleValue() }).toLaminarObservable() )
               }

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






















