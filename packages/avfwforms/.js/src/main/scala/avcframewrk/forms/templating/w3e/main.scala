package avcframewrk.forms

package templating

package w3e













export allDefsSjsImpl.*

protected
final
lazy
val allDefsSjsImpl
= {

   object jsWindow {

      // export org.scalajs.dom.{
      //    Element ,
      // }

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
         // <: jsWindow.Element
         <: org.scalajs.dom.Element /* `class`, not `trait` */

      given ttComparableSpawnedElement
      : reflect.TypeTest[org.scalajs.dom.Element, ComparableSpawnedElement ]

      val reconciler
      : AnyRef & ClassReconcilingOps[ComparableSpawnedElement]
      = new AnyRef with ClassReconcilingOps[ComparableSpawnedElement]

      export reconciler.earlyDeinitInstance

      type InstanceOps
      <: SjsEOps

   }

   trait SjsEOps(
      //
   )
   {

      val class1
      : SjsEClassOps

      type ComparableSpawnedElement
         >: class1.ComparableSpawnedElement
         <: class1.ComparableSpawnedElement

      type SpawnedElement
         <: ComparableSpawnedElement

      /**
       * 
       * .
       * 
       */
      def spawn()
      : SpawnedElement

      /**
       * 
       * in-place update of it.
       * 
       */
      def updateAndSelf(e: ComparableSpawnedElement )
      : e.type

      //

   }

   val typeableSde
   = summon[reflect.Typeable[org.scalajs.dom.Element] ]

   {
      //

      object buttonOrAHrefClassOps
      extends
      AnyRef
      with SjsEClassOps
      {

         //

         // HTMLButtonElement | HTMLAElement
         type BHA = org.scalajs.dom.Element

         override
         type ComparableSpawnedElement
            >: BHA <: BHA

         override
         given ttComparableSpawnedElement : reflect.Typeable[BHA]
         = typeableSde

         override
         type InstanceOps
         >: ButtonOrAHrefDesc
         <: ButtonOrAHrefDesc

      }

      case class ButtonOrAHrefDesc(
         headline : SjsEOps ,
      )
      extends 
      AnyRef
      with SjsEOps
      {

         //

         override
         val class1
         : buttonOrAHrefClassOps.type
         = buttonOrAHrefClassOps

         override
         type SpawnedElement
            >: ComparableSpawnedElement
            <: ComparableSpawnedElement

         /**
          * 
          * .
          * 
          */
         override
         def spawn()
         = {
            // TODO
            val e = org.scalajs.dom.document.createElement("button")
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
            // TODO
            e.innerHTML = ""
            e append(headline.spawn() )
            e
         }

      }

      new AnyRef
      with avcframewrk.forms.templating.w3e.pre.Articles
      with avcframewrk.forms.templating.w3e.pre.Buttons
      {

         override
         type Article
         >: SjsEOps
         <: SjsEOps

         val Action
         = ???

         def describeButtonByAction(action: Action)
         = ???

      }
   }
} // allDefsImpl$












val _ = {}
