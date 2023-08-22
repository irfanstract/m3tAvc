package avcframewrk.forms

package templating

package w3e
















final
lazy val ebAll
= {
   new AnyRef
   with EbAndReconcilability
   with EbButtons
}

trait EbAndReconcilability
{
   //

   //

   type ElementBase
      >: org.scalajs.dom.Element /* `class`, not `trait` */
      <: org.scalajs.dom.Element /* `class`, not `trait` */

   object SjsEOps {
      //

      //

      ;

      object ClassInstanceOps
      {

         //

      }

      trait ClassInstanceOps(
         //
      )
      {

         //

         val class1
         : ClassOps

         type ComparableSpawnedElement
            >: class1.ComparableSpawnedElement
            <: class1.ComparableSpawnedElement

         type SpawnedElement
            <: ComparableSpawnedElement

         val reconciler
         : AnyRef & (PerSampleReconcilingOps[ComparableSpawnedElement] { def spawn() : ClassInstanceOps.this.SpawnedElement } )

         /**
          *
          * .
          *
          */
         export reconciler.spawn

         /**
          *
          * in-place update of it.
          *
          */
         export reconciler.updateAndSelf

         /**
          *
          * try to generate HTML (it's not always possibly).
          *
          * defaults to `spawn().outerHTML`.
          *
          */
         // @deprecated
         export reconciler.toHTML

         //

      }

      trait PerSampleReconcilingOps[
         CSE  <: ClassOps#ComparableSpawnedElement
         ,
      ]
      {

         //

         type ComparableSpawnedElement = CSE

         /**
          *
          * .
          *
          */
         def spawn()
         : ComparableSpawnedElement

         /**
          *
          * in-place update of it.
          *
          */
         def updateAndSelf(e: ComparableSpawnedElement )
         : e.type

         /**
          *
          * try to generate HTML (it's not always possibly).
          *
          * defaults to `spawn().outerHTML`.
          *
          */
         @deprecated
         def toHTML()
         : String
         = spawn().outerHTML

      }

      object PerSampleReconcilingOps
      {
         //

      }

      trait ClassReconcilingOps[ComparableSpawnedElement](
         //
      )
      {

         //

         def earlyDeinitInstance(e: ComparableSpawnedElement )
         : Unit
         = {}

      }

      type Class

      trait ClassOps
      {

         //

         type ComparableSpawnedElement
            <: ElementBase

         given ttComparableSpawnedElement
         : reflect.TypeTest[ElementBase, ComparableSpawnedElement ]

         val reconciler
         : AnyRef & ClassReconcilingOps[ComparableSpawnedElement]
         = new AnyRef with ClassReconcilingOps[ComparableSpawnedElement]

         type InstanceOps
         <: ClassInstanceOps

         export reconciler.earlyDeinitInstance

         /* on-topic utility for implementers */

         extension [E](c: PerSampleReconcilingOps[ComparableSpawnedElement] ) {

            /**
             *
             * `updateAndSelf` --
             * in-place update of it.
             *
             */
            // transparent inline
            def tryUpdateAndSelf(e: ElementBase )
            : Either[Unit, e.type]
            = {

               e match {

                  case e1 : ComparableSpawnedElement =>
                     c updateAndSelf(e1)
                     Right(e )

                  case _ =>
                     Left(() )

               }
            }

         }

      }

   }

   type SjsEOps
   = SjsEOps.ClassInstanceOps

   // /**
   //  *
   //  * Sjs Child Element Class Ops Parent Children Relationship
   //  *
   //  */
   // trait ScePcr {

   //    //

   // }

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

   def newClickEvent()
   : AnyRef & Product
   = {

      case object clickEvent extends
         AnyRef
      clickEvent
   }

   //

   object buttonOrAHrefClassOps
   extends
   AnyRef
   with ClassOps
   {

      //

      // HTMLButtonElement | HTMLAElement
      type BHA
      =
         org.scalajs.dom.html.Button
         | org.scalajs.dom.html.Button
         | org.scalajs.dom.html.Anchor
         | org.scalajs.dom.html.Input
         | org.scalajs.dom.html.Select

      override
      type ComparableSpawnedElement
         >: BHA <: BHA

      override
      given ttComparableSpawnedElement : reflect.Typeable[BHA]
      = typeable[BHA]

      override
      type InstanceOps
      >: ButtonOrAHrefDesc
      <: ButtonOrAHrefDesc

   }

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

   case class ButtonOrAHrefDesc(
      edsb: Edsb[?, SjsEOps] ,
      callback: (evt: AnyRef & Product) => util.Try[Unit] ,
   )
   extends
   AnyRef
   with SjsEOps
   {

      //

      val headlineDescr
      = edsb.baseTitle

      override
      val class1
      : buttonOrAHrefClassOps.type
      = buttonOrAHrefClassOps

      override
      type SpawnedElement
         >: ComparableSpawnedElement
         <: ComparableSpawnedElement

      val reconciler
      : bteReconclerImpl.type
      = bteReconclerImpl

      protected
      object bteReconclerImpl extends PerSampleReconcilingOps[ComparableSpawnedElement] {
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
         val e = {
            org.scalajs.dom.document.createElement("button")
            .asInstanceOf[ComparableSpawnedElement]
         }
         edsb.stateCheckedOption
         .map((vl) => {
            e.setAttribute("disabled", vl match { case 0 => "disabled" ; case _ => "" } )
         } )
         .countL
         updateAndSelf(e)
         e
      }

      /**
       *
       * in-place update of it.
       *
       */
      override
      def updateAndSelf(e: ComparableSpawnedElement )
      : e.type
      = {

         /**
          *
          * `tryUpdateAndSelf`
          *
          */
         this.tryUpdateAndSelf(e)
         .getOrElse[e.type ]({
            //

            /** manually clear and (re)populate */
            {
               e.innerHTML = ""
               e append(headlineDescr.spawn() )
            }

            e
         })
         //
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

         e
      }

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

   }

}
















val _ = {}
