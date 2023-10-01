package avcframewrk.forms

package templating

package ext.givmk

package impl


















import org.scalajs.dom

import com.raquo.laminar.{nodes as ln }

type AcceptableLE
>: ln.ReactiveHtmlElement[? <: dom.HTMLElement] | ln.ReactiveSvgElement[? <: dom.SVGElement]
<: ln.ReactiveHtmlElement[? <: dom.HTMLElement] | ln.ReactiveSvgElement[? <: dom.SVGElement]

final
lazy
val llBasedArticleAllocator
: (Article._Allocator.ForType[Lspw._Base ] )
=  Article._Allocator.forType[Lspw._Base ]

object Lspw
{
   ;

   ;

   ;

   type _Base
   = Impl[? ]
 
   extension (receiver: Lspw._Base ) {
      //

      private
      def receiverLspwBaseForSpw
      : receiver.type
      = valueOf

      export receiverLspwBaseForSpw.spawn

      export receiverLspwBaseForSpw.reconcile

   }

   private[givmk]
   case class Impl
      [Mdl]
      (protected val impl: (
         ScnAllocAndReconcileAndDistillH[?, Mdl, AcceptableLE ] ,
         Mdl ,
      ) )
   {
      ;
      
      export impl.{_2 as mdl }

      export impl.{_1 as sbReconciler }

      // export sbReconciler.{IntermediateState as CompIntermediateState }
      opaque type CompIntermediateState
      >: sbReconciler.IntermediateState
      <: sbReconciler.IntermediateState
      =  sbReconciler.IntermediateState

      /* work-around to the eager widening of wildcard-types */
      val sbReconciler1
      : ScnAllocAndReconcileAndDistillH[CompIntermediateState, Mdl, AcceptableLE ]
      = {
         ;
         sbReconciler
         .pipeExactSelf({
            implicitly[<:<[sbReconciler.type, ScnAllocAndReconcileAndDistillH[CompIntermediateState, Mdl, AcceptableLE ] ] ]
         })
      }

      export sbReconciler.{given_SpawnabilityAndReconciliabilityNoArg_Md_TIntermediateState as pairwiseReconciler }

      def spawn
         //
         ()
      : CompIntermediateState
      = {
         ;
         ;
         sbReconciler1.spawnMd(mdl )
         .tapLooseSelf(e => {} )
      }

      def reconcile
         //
         (sExisting: CompIntermediateState )
      = {
         ;
         ;
         sbReconciler1.reconcile(sExisting , mdl )
         .tapLooseSelf(e => {} )
      }

   }

   ;
}

object rcKeyingDefiner1
extends
templating.w3e.pre.ArticlesImplByL1
{
   ;
   type NativeDocNode
   >: AcceptableLE
   <: AcceptableLE
}
export rcKeyingDefiner1.{LReconciliativeKey, LReconciliativeKeyTo1, LReconciliativeKeyToMdl }
export rcKeyingDefiner1.LReconciliativeKey.ScnAllocAndReconcileAndDistillH





















val _ = {}