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

   type ElementBase
      >: org.scalajs.dom.Element /* `class`, not `trait` */
      <: org.scalajs.dom.Element /* `class`, not `trait` */

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

      export reconciler.earlyDeinitInstance

      type InstanceOps
      <: SjsEOps

   }

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

      //

   }

   extension (c: SjsEOps ) {

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

   val typeableSde
   = summon[reflect.Typeable[ElementBase ] ]
   
   def newClickEvent()
   : AnyRef & Product
   = {

      case object clickEvent extends
         AnyRef
      clickEvent
   }

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
