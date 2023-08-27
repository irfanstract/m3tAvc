package avcframewrk.forms

package templating

package w3e.impl.js

package s1

















trait EbInit
extends
AnyRef
{
   //

   type ElementBase

}

trait EbAndReconcilability
extends
AnyRef
with EbInit
{
   //

   //

   override
   type ElementBase
      >: ([E <: org.scalajs.dom.Element] =>> (E | com.raquo.laminar.nodes.ReactiveElement[E] ) )[org.scalajs.dom.Element ]
      <: ([E <: org.scalajs.dom.Element] =>> (E | com.raquo.laminar.nodes.ReactiveElement[E] ) )[org.scalajs.dom.Element ]

   //   trait ToHtml {
   //
   //      def apply() : String
   //
   //   }

   object SjsEOps
   {
      //

      //

      ;

      // /**
      //  *
      //  * Sjs Child Element Class Ops Parent Children Relationship
      //  *
      //  */
      // trait Pcr {

      //    val parent
      //    : ClassOps
         
      //    type parent$
      //    = parent.type

      //    type Child
      //    <: ClassInstanceOps
 
      // }

      final
      lazy val parentChildSchemator
      = ParentChildRelationship.Cio

      object csco
      {
         ;

         trait OfClass
         extends
         AnyRef
         with Cse
         with parentChildSchemator.ClassOps[OfClass, OfClassInstance] /* a work-around against the resulting compiler hangs */
         {
            this : parentChildSchemator.ClassOps[?, ?] =>

            ;

            // protected
            type SpawnedElement

            /**
             * comparable peer(s)
             * 
             */
            type ComparableSpawnedElement
               >: SpawnedElement
               <: SpawnedElement

         } // OfClass

         trait OfClassInstance
         extends
         AnyRef
         with Cse
         with parentChildSchemator.ClassInstanceOps[OfClass, OfClassInstance] /* a work-around against the resulting compiler hangs */
         {
            this : parentChildSchemator.ClassInstanceOps[?, ?] =>

            ;

            /**
             * comparable peer(s)
             * 
             */
            type ComparableSpawnedElement
               >: class1.ComparableSpawnedElement
               <: class1.ComparableSpawnedElement

            type SpawnedElement
               <: ComparableSpawnedElement

         } // OfClassInstance

         @deprecatedInheritance
         trait Cse
         {
            ;

            /**
             * spawned peer(s)
             * 
             */
            type SpawnedElement
               <: Any

            /**
             * comparable peer(s)
             * 
             */
            type ComparableSpawnedElement
               <: Any
            
         } // Cse

      } // csco$

      object ClassInstanceOps
      {

         //

      }

      @deprecatedInheritance
      trait ClassInstanceOps(
         //
      )
      extends
      AnyRef
      with parentChildSchemator.ClassInstanceOps[ClassOps, ClassInstanceOps]
      with csco.OfClassInstance
      {

         ;

         /**
          * comparable native elem(s)
          * 
          */
         override
         type ComparableSpawnedElement
            >: class1.ComparableSpawnedElement
            <: class1.ComparableSpawnedElement

         type SpawnedElement
            <: ComparableSpawnedElement

         val reconciler
         : (
            AnyRef
            & (
               ClassInstanceSpecificReconcilingOps[ComparableSpawnedElement]
               & ClassInstanceSpecificReconcilingOps.CtxtualSpawnMethods[ClassInstanceOps.this.SpawnedElement ] 
            )
         )

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

      } // ClassInstanceOps

      /**
       * 
       * in practice,
       * `spawn()`
       * tends to behave as the sequence `val e = document.createElement("some-element") ; updateAndSelf(e) ;`,
       * and
       * the similar case happens for `toHTML()`
       * 
       */
      trait ClassInstanceSpecificReconcilingOps[
         CSE 
         // <: ClassOps#ComparableSpawnedElement
         ,
      ]
      extends
      AnyRef
      with ClassInstanceSpecificReconcilingOps.CtxtualSpawnMethods[CSE]
      {

         //

         type ComparableSpawnedElement = CSE

         /**
          *
          * .
          *
          */
         override
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
         = {
            spawn()
            match {
               case e : org.scalajs.dom.Element =>
                  e.outerHTML
               case e : com.raquo.laminar.nodes.ReactiveElement[et] =>
                  e.ref.outerHTML
               case e =>
                  throw new UnsupportedOperationException(s"${e}")
            }
         }

      } // ClassInstanceSpecificReconcilingOps

      object ClassInstanceSpecificReconcilingOps
      {
         //

         trait CtxtualSpawnMethods[+R] {

            def spawn() : R

         }

      } // ClassInstanceSpecificReconcilingOps$

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

      object ClassOps

      @deprecatedInheritance
      trait ClassOps
      extends
      AnyRef
      with parentChildSchemator.ClassOps[ClassOps, ClassInstanceOps]
      with csco.OfClass
      {

         //

         given ttComparableSpawnedElement
         : reflect.Typeable[ComparableSpawnedElement ]

         override
         type SpawnedElement
            <: ElementBase

         val reconciler
         : AnyRef & ClassReconcilingOps[ComparableSpawnedElement]
         = new AnyRef with ClassReconcilingOps[ComparableSpawnedElement]

         // type InstanceOps
         // <: (
         //    ClassInstanceOps {
         //       val class1
         //       : ClassOps.this.type
         //    }
         // )

         export reconciler.earlyDeinitInstance

         /* on-topic utility for implementers */

         extension [E](c: ClassInstanceSpecificReconcilingOps[ComparableSpawnedElement] ) {

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

      } // ClassOps

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
         type SpawnedElement
            >: BHA <: BHA

      }

      given templateApplicativeImplicits
      : AnyRef
      with {
         ;

         extension [CSE  <: ClassOps#ComparableSpawnedElement] (receiver: CSE) {

            def model_=(newModel: ClassInstanceOps )
            (using CSE <:< newModel.ComparableSpawnedElement )
            : Unit
            = {
               ;

               newModel.updateAndSelf(receiver )

            }

         }

      } // templateApplicativeImplicits$

   }

   type SjsEOps
   = SjsEOps.ClassInstanceOps

   ;

   /**
    * 
    * rather than
    * trying to manually subclass the classes there, which are still not fixed yet,
    * code
    * should instead invoke this constructor and then stick on the resulting ns' two exported class(es)
    * 
    */
   // protected[avcframewrk]
   class SbBcd
      [
         ComparableSpawnedElement
         <: SjsEOps.ClassOps#ComparableSpawnedElement
         : reflect.Typeable
         ,
         Mdl
         <: AnyRef & scala.Product
         ,
         T1 /* unused */
         ,
      ]
      (
         // TODO
         buttonReconciler : (
            //
            // (desc : Mdl )
            (Mdl)
            =>
            (reflect.Typeable[ComparableSpawnedElement] )
            ?=>
            SjsEOps.ClassInstanceSpecificReconcilingOps[ComparableSpawnedElement]
         ) ,
      )
   {
      //
      ;

      import SjsEOps.{*, given}
      
      ;

      private[SbBcd]
      type ComparableSpawnedElement1
      = ComparableSpawnedElement

      object classOpsImpl extends
      AnyRef
      with SjsEOps.ClassOps
      with SjsEOps.ClassOpsTFixation[ComparableSpawnedElement]
      {

         //

         type InstanceOps
            >: ClassInstanceOpsImpl
            <: ClassInstanceOpsImpl
         
      }

      case class ClassInstanceOpsImpl(
         //
         desc : Mdl
         ,
      )
      extends
      AnyRef
      with SjsEOps  
      {

         //

         export desc.*

         //

         override
         val class1
         : classOpsImpl.type
         = classOpsImpl

         override
         type SpawnedElement
            >: this.ComparableSpawnedElement
            <: this.ComparableSpawnedElement

         val reconciler
         : ClassInstanceSpecificReconcilingOps[this.ComparableSpawnedElement]
         = {
            buttonReconciler(desc)
            match { case r => r }
         }

      }

   }

}

class &@@!
   [
      +Receiver ,
      Src <: avcframewrk.evm.AsyncAlgebraicMonad[Any] ,
   ]
   (val e: Receiver, key: String, val dSrc : Src )
   (runPerRefreshCalls: (receiver: Receiver, state: ({ type Main[T <: Src ] = T match { case avcframewrk.evm.AsyncAlgebraicMonad[t] => t } })#Main[Src ] ) => Unit )
{

   ;

   e.asJsDynamic.updateDynamic(key )(( ) => {
      dSrc
      /*
       * to avoid infinite-looping, a latency will be necessary
       *
       */
      .delayOnNext({ import concurrent.duration.* ; 500.milliseconds })
      /*
       * "subscribe for only the first next item"
       *
       */
      .firstL
      /*
       * run the main callback
       *
       */
      .map((vl) => {
         runPerRefreshCalls(e, vl )
      } )
      /*
       * reschedule
       *
       */
      .map(v => {
         ;

         e.asJsDynamic.applyDynamic(key)( )

         ()
      })
   })
   e.asJsDynamic.applyDynamic(key)( )

}
















