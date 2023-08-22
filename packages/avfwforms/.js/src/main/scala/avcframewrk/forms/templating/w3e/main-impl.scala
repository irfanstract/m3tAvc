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

   trait SjsEOps(
      //
   )
   {

      //

      val class1
      : SjsEClassOps

      type ComparableSpawnedElement
         >: class1.ComparableSpawnedElement
         <: class1.ComparableSpawnedElement

      type SpawnedElement
         <: ComparableSpawnedElement

      val reconciler
      : AnyRef & (PerSampleReconcilingOps[ComparableSpawnedElement] { def spawn() : SjsEOps.this.SpawnedElement } )

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

   object SjsEOps {

      //

   }

   trait PerSampleReconcilingOps[
      CSE  <: SjsEClassOps#ComparableSpawnedElement
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

      extension [E <: SjsEClassOps#ComparableSpawnedElement](c: PerSampleReconcilingOps[E] ) {

         def tryUpdateAndSelf(e: ElementBase )
         : Either[Unit, e.type]
         = {

            e match {

               case e1 : c.ComparableSpawnedElement =>
                  c updateAndSelf(e1)
                  Right(e )

               case _ =>
                  Left(() )

            }
         }

      }

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

   trait SjsEClassOps
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
      <: SjsEOps

      export reconciler.earlyDeinitInstance

   }

}

trait EbButtons
{
   this : (
      AnyRef
      & EbAndReconcilability
   ) =>
   //

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
   with SjsEClassOps
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
