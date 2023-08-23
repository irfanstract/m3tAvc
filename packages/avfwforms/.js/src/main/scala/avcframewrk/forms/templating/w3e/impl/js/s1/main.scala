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

   // HTMLButtonElement | HTMLAElement
   private[avcframewrk] 
   type BHA
   =
      org.scalajs.dom.html.Button
      | org.scalajs.dom.html.Button
      | org.scalajs.dom.html.Anchor
      | org.scalajs.dom.html.Input
      | org.scalajs.dom.html.Select

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

               /** manually clear and (re)populate */
               val newHeadlineSpawnedE = {
                  ;
                  
                  recreateHeading(e)
               } : headlineDescr.SpawnedElement

               newHeadlineSpawnedE
            })

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

            /**
             * 
             * reassign its `onClick`
             * 
             */
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
                  org.scalajs.dom.document.createElement("button")
                  .asInstanceOf[ComparableSpawnedElement]
               }

               /**
                * 
                * TODO --
                * init automatic s
                * 
                */
               edsb.stateCheckedOption
               .map((vl) => {
                  e.setAttribute("disabled", vl match { case 0 => "disabled" ; case _ => "" } )
               } )
               .countL

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