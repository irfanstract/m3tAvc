package avcframewrk.forms

package templating

package w3e.impl.js

package s1

















trait EbAndReconcilability
{
   //

   //

   type ElementBase
      >: org.scalajs.dom.Element /* `class`, not `trait` */
      <: org.scalajs.dom.Element /* `class`, not `trait` */

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

      object ClassInstanceOps
      {

         //

      }

      trait ClassInstanceOps(
         //
      )
      extends
      AnyRef
      with ParentChildRelationship.Cio.ClassInstanceOps[ClassOps, ClassInstanceOps]
      {

         //

         // val given_Pcr
         // : Pcr
         ;

         // val class1
         // : ClassOps

         type ComparableSpawnedElement
            >: class1.ComparableSpawnedElement
            <: class1.ComparableSpawnedElement

         type SpawnedElement
            <: ComparableSpawnedElement

         val reconciler
         : (
            AnyRef
            & (
               PerSampleSpawningAndReconcilingOps[ComparableSpawnedElement]
               & PerSampleSpawningAndReconcilingOps.CtxtualSpawnMethods[ClassInstanceOps.this.SpawnedElement ] 
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
      extends
      AnyRef
      with PerSampleSpawningAndReconcilingOps.CtxtualSpawnMethods[CSE]
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
         = spawn().outerHTML

      }

      object PerSampleSpawningAndReconcilingOps
      {
         //

         trait CtxtualSpawnMethods[+R] {

            def spawn() : R

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

      @deprecated
      type Class

      trait ClassOps
      extends
      AnyRef
      with ParentChildRelationship.Cio.ClassOps[ClassOps, ClassInstanceOps]
      {

         //

         type ComparableSpawnedElement
            <: ElementBase

         given ttComparableSpawnedElement
         : reflect.Typeable[ComparableSpawnedElement ]

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
            SjsEOps.PerSampleSpawningAndReconcilingOps[ComparableSpawnedElement]
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
         : PerSampleSpawningAndReconcilingOps[this.ComparableSpawnedElement]
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
















