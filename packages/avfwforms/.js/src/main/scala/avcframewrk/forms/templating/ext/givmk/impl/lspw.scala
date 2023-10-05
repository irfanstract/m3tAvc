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
=  Article._Allocator.forType[Lspw._Base ]

object Lspw
{
   ;

   ;

   ;

   type _Base
   = Impl[Nothing, Any ]

   def byReconcilerAndModelPair
      [Mdl, CompStateBag ]
      (impl: (
         //
         LReconciliativeKeyTo1[ScnAllocAndReconcileAndDistillH[CompStateBag, Mdl, AcceptableLE ] ]
         ,
         Mdl ,
      ) )
   : Impl[Mdl, Mdl ]
   = ImplReconcilerAndMdlPair[Mdl](impl )

   opaque type Impl
      [
         -MdlL <: MdlU, +MdlU ,
      ]
   <: AnyRef
   =  ImplReconcilerAndMdlPair[? >: MdlL <: MdlU ]
 
   extension (receiver: Lspw._Base ) {
      //

      private
      def receiverLspwBaseForSpw
      : receiver.type & ImplReconcilerAndMdlPair[? ]
      = valueOf

      export receiverLspwBaseForSpw.spawn

      export receiverLspwBaseForSpw.reconcile

   }

   ;
}

private[givmk]
case class ImplReconcilerAndMdlPair
   [Mdl]
   (protected val impl: (
      LReconciliativeKeyTo1[ScnAllocAndReconcileAndDistillH[?, Mdl, AcceptableLE ] ]
      ,
      Mdl ,
   ) )
{
   ;

   export impl.{_2 as mdl }

   export impl.{_1 as reconciliativeKey }

   val sbReconciler
   = reconciliativeKey.toScnAllocAndReconcileAndDistillH

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
export rcKeyingDefiner1.toScnAllocAndReconcileAndDistillH





















val _ = {}