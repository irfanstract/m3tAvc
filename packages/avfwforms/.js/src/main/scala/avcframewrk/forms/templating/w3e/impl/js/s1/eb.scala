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

   // TODO
   trait ToHtml {

      def apply() : String

   }

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

   // TODO
   private[avcframewrk]
   class SbBcd
      [
         BHA
         <: ElementBase
         : reflect.Typeable
         ,
         Mdl
         <: scala.Product
         ,
      ]
      ()
   {
      //

      object classOpsImpl extends
      AnyRef
      with SjsEOps.ClassOps
      with SjsEOps.ClassOpsTFixation[BHA]

      type ClassInstanceOpsImpl
      // <: SjsEOps.ClassInstanceOps
      
   }

}
















