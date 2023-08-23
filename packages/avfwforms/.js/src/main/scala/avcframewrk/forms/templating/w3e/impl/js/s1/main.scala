package avcframewrk.forms

package templating

package w3e.impl.js.s1
















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

   // TODO
   trait ToHtml {

      def apply() : String

   }

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
         : AnyRef & (PerSampleSpawningAndReconcilingOps[ComparableSpawnedElement] { def spawn() : ClassInstanceOps.this.SpawnedElement } )

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

      /**
       * 
       * in practice,
       * `spawn()`
       * tends to behave as the sequence `val e = document.createElement("some-element") ; updateAndSelf(e) ;`,
       * and
       * the similar case happens for `toHTML()`
       * 
       */
      trait PerSampleSpawningAndReconcilingOps[
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

      object PerSampleSpawningAndReconcilingOps
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

      @deprecated
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

         extension [E](c: PerSampleSpawningAndReconcilingOps[ComparableSpawnedElement] ) {

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

      /**
       * 
       * this mixin
       * requires pre-constructed impl for `ttComparableSpawnedElement.` and
       * narrows `ComparableSpawnedElement#` to `BHA`
       * 
       */
      trait ClassOpsTFixation[
         BHA <: ElementBase ,
      ](
         //
      )
      (using override val ttComparableSpawnedElement : reflect.Typeable[BHA] )
      extends
      ClassOps
      {

         //

         //

         override
         type ComparableSpawnedElement
            >: BHA <: BHA

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

   // HTMLButtonElement | HTMLAElement
   type BHA
   =
      org.scalajs.dom.html.Button
      | org.scalajs.dom.html.Button
      | org.scalajs.dom.html.Anchor
      | org.scalajs.dom.html.Input
      | org.scalajs.dom.html.Select

   object buttonOrAHrefClassOps
   extends
   AnyRef
   with ClassOps
   with ClassOpsTFixation[BHA]
   {

      //

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

      private[ButtonOrAHrefDesc] 
      object bteReconclerImpl extends PerSampleSpawningAndReconcilingOps[ComparableSpawnedElement] {
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

         updateHeadingOf(e)

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

      private[ButtonOrAHrefDesc]
      def updateHeadingOf(e: ComparableSpawnedElement )
      : Unit
      = {
         //

         /**
          *
          * `tryUpdateAndSelf`
          *
          */
         (locally[Either[Unit, headlineDescr.ComparableSpawnedElement ] ] {

            e.children.toIndexedSeq match {

               case Seq(ec : headlineDescr.ComparableSpawnedElement ) =>
                  headlineDescr updateAndSelf(ec)
                  Right(ec )

               case _ =>
                  Left(() )
            }
         } )
         .getOrElse[headlineDescr.ComparableSpawnedElement ]({
            //

            /** manually clear and (re)populate */
            val newHeadlineSpawnedE = {
               e.innerHTML = ""
               val ec = headlineDescr.spawn()
               e appendChild(ec ) 
               ec
            } : headlineDescr.SpawnedElement

            newHeadlineSpawnedE
         })

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