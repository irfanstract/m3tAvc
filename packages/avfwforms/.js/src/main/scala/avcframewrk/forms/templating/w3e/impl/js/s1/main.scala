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

      //

      private[ButtonOrAHrefDesc]
      def updateHeadingElement(ec : headlineDescr.ComparableSpawnedElement )
      : Unit
      = {

         headlineDescr updateAndSelf(ec)
         
      }

      /** manually clear and (re)populate */
      private[ButtonOrAHrefDesc]
      def recreateHeading(e: ComparableSpawnedElement )
      : headlineDescr.SpawnedElement
      = {
         ;

         /** manually clear and (re)populate */
         val newHeadlineSpawnedE = {
            e.innerHTML = ""
            val ec = headlineDescr.spawn()
            e appendChild(ec ) 
            ec
         } : headlineDescr.SpawnedElement

         newHeadlineSpawnedE
      }

      private[ButtonOrAHrefDesc]
      def updateHeadingOf(e: ComparableSpawnedElement )
      : Unit
      = {
         //

         /**
          * 
          * in general `recreateHeading(e)`, but
          * strive for `updateHeadingElement(e.soleChildNode )`
          * 
          */
         locally[Either[Unit, headlineDescr.ComparableSpawnedElement ] ]({

            e.childNodes.toIndexedSeq match {

               case (ec : headlineDescr.ComparableSpawnedElement) +: Seq() =>
                  updateHeadingElement(ec)
                  Right(ec )

               case _ =>
                  Left(() )
            }
         })
         .getOrElse[headlineDescr.ComparableSpawnedElement ]({
            //

            /** manually clear and (re)populate */
            val newHeadlineSpawnedE = {
               ;
               
               recreateHeading(e)
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