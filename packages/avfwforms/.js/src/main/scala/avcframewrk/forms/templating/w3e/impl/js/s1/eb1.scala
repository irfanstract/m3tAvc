package avcframewrk.forms

package templating

package w3e.impl.js

package s1




















/** 
 * 
 * implementative mix-in `ELaminarQckCoreLrksBased`
 * 
 */
trait ELaminarQckCoreLrksBased
extends
   AnyRef
   //
   with ELaminarQckCoreLrks
   with w3e.pre.ArticlesImplLReconciliativeKeyFoundPairs
{
   thisELaminarQckCoreLrks : (
      AnyRef
      & ELaminarQckCoreLrks
      // & w3e.pre.ArticlesViaLspw
   ) =>
   ;

   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;
}

/** 
 * 
 * implementative mix-in `ELaminarQckCoreLrks`
 * 
 */
trait ELaminarQckCoreLrks
extends
   AnyRef
   // with w3e.pre.ArticlesViaLspwmt
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.ArticlesImplByL
{
   thisELaminarQckCoreLrks : (
      AnyRef
      & w3e.pre.ArticlesImplByL
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   /** 
    * supposed to be the main/primary data-type (or repr) in the targeted backend/fw -
    * this could be `React.Element`, `DOM.Element`, `Laminar.Element`, etc
    * 
    */
   override
   type NativeDocNode
   >: ln.ReactiveElement[?]
   <: ln.ReactiveElement[?]

   ;
}

/** 
 * 
 * implementative mix-in `ELaminarQckCore1`
 * 
 */
trait ELaminarQckCore1
extends
   AnyRef
   with w3e.pre.ArticlesViaLspw
   with ELaminarQckCoreLrksBased
   with ELaminarQckCoreLrks
   // with w3e.pre.ArticlesViaLspwmt
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Articles
   /* with these items item merely listed in the self-type,  (.....) */
   with w3e.pre.ADefinesNativeDocNodeType0
{
   this : (
      AnyRef
      with w3e.pre.Articles
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   /** 
    * note -
    * avoid summon-ing `T1 =:= T2` directly as it places execssive assumptions ;
    * split it into the two `T1 <:< T2` and `T2 <:< T1` ; 
    * 
    */
   summon[NativeDocNode <:< ln.ReactiveElement[?] ]
   summon[ln.ReactiveElement[?] <:< NativeDocNode ]

   // // protected
   // class given_Conversion_SpiwmTwos_LaminarSpawnable_TypeKey

   protected
   opaque
   type LaminarSpawnable[
      +SpawnedLaminar <: ln.ReactiveElement[SpawnedDOMNode & dom.Element],
      +SpawnedDOMNode <: dom.Node ,
   ]
   // <: AnyRef
   = (
      // LaminarSpawnableReconcTuple[?, ? ]
      LaminarSpawnableReconcTuple[?, LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, SpawnedLaminar] ]
   )

   /* can't use 'wildcard appl to type args' */
   protected[s1]
   case class LaminarSpawnableReconcTuple
      [
         M
         ,
         +SpecificBinaryReconcilerTPre
            <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?]
         ,
      ]
      (impl: (
         LReconciliativeKeyTo1[(
            SpecificBinaryReconcilerTPre
            & LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, M, ?]
         ) ]
         ,
         M ,
      ) )
   {
      ;

      export impl.{_2 => mdl }

      export impl.{_1 => reconcKey0 }

      val asrcp
      = LReconciliativeKeyFoundImplPair(reconcKey0 )

      export asrcp.xsclhReconciler

      export asrcp.reconcKey

      export asrcp.CompIntermediateState

      def spawnImpl()
      : xsclhReconciler.IntermediateState
      = {
         val xsclhReconciler1
         : LReconciliativeKey.ScnAllocAndReconcileAndDistillH[xsclhReconciler.IntermediateState, M, ? ]
         = xsclhReconciler
         ;
         // summon[xsclhReconciler1.HLI <:< ln.ReactiveElement[?] ]
         // // TODO
         xsclhReconciler1
         /* tries to `spawnMd` directly, but can't, due to the resulting (spurious) type-mismatch complaint (see also the associable in-compiler `AssertionError`s) */
         match { case xsclhRecnc11 : (xsclhReconciler1.type & LReconciliativeKey.ScnAllocAndReconcileAndDistillH[t1, t2, t3] ) => {
            ;
            xsclhRecnc11.spawnMd(mdl )
            ;
         } }
      }

      def reconcileImpl(d: CompIntermediateState )
      : Unit
      = xsclhReconciler.reconcile(d, mdl )

      def getHLImpl(src: CompIntermediateState )
      : xsclhReconciler.HLI
      = xsclhReconciler.distillLHandle(src)

   }

   lazy val _ = {
      ;

      def gt[SpawnedLaminar <: ln.ReactiveElement[dom.Element] ]
      = summon[SpawnedLaminar <:< NativeDocNode ]

      def gt1[SpawnedLaminar <: ln.ReactiveElement[dom.Element] ]
      = ((arg: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?] ) => {} )

      // summon[(LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?]#HLI ) <:< NativeDocNode ]
      ???

      locally(((arg: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?]#HLI ) => {} ))

      locally([SpawnedLaminar <: ln.ReactiveElement[dom.Element] ] => ((arg: () => (1 | 2 | 3 ) ) => {} ))

      summon[NativeDocNode <:< ln.ReactiveElement[?] ]

   }

   /** 
    * reconciliability between two with shared (sub)reconciler
    * 
    */
   given lspwmHomognSpawnability
      [
         Art <: LaminarSpawnableReconcTuple[?, LReconciliativeKey.ScnAllocAndReconcileAndDistillH[S, ?, SpawnedLaminar] ] ,
         S ,
         SpawnedLaminar <: ln.ReactiveElement[dom.Element],
         // T0 ,
         ReconcOpR ,
      ]
      (using given_ValueOf_ReconcOpR : ValueOf[ReconcOpR] = summon[ValueOf[Unit] ] )
   : (
      //

      SpawnabilityAndReconciliabilityNoArg[
         //
         Art,
         S,
         ReconcOpR ,
      ]
   )
   = {
      ;
      SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
         //
         spwImpl1 =
            (mdl: Art) =>
               mdl.spawnImpl()
         ,
         reconcImpl1 =
            (thisSpawned: S , newMdl ) =>
               newMdl.reconcileImpl(thisSpawned )
               valueOf[ReconcOpR]
         ,
      )
   }

   /** 
    * query, by an `Article`, for its `LReconciliativeKey`
    * 
    */
   def given_LaminarSpawnable_reconCls
      [
         // SpawnedLaminar <: ln.ReactiveElement[SpawnedDOMNode & dom.Element],
         // SpawnedDOMNode <: dom.Node ,
         T0 ,
      ]
   : (art: Article ) => (LReconciliativeKey & LReconciliativeKeyOfArt[art.type ] )
   = {
      identity[LaminarSpawnable[ln.ReactiveElement[dom.Element], dom.Element ] => LReconciliativeKey ](_.reconcKey )
   }

   opaque type LReconciliativeKeyOfArt[+A <: Article ]
   = Any

   // TODO move this up in/on/to extracted new super-class
   /** 
    * spawned instance
    * 
    */
   type SpawnedArtReconcilerAndStateBagPair
   = SpawnedArtReconcilerAndStateBagPairToLD[dom.Element ]

   /** 
    * spawned instance,
    * from which the returned `ln.ReactiveElement` would conform to the given sub-type `SpawnedLaminar`
    * 
    */
   type SpawnedArtReconcilerAndStateBagPairToLL[+SpawnedLaminar <: ln.ReactiveElement[?] ]
   = SpawnedArtReconcilerAndStateBagPairImpl[Nothing, dom.Element, SpawnedLaminar ]

   /** 
    * spawned instance,
    * from which the returned `ln.ReactiveElement`'s `.ref : dom.Element` would conform to the given sub-type `SpawnedDOMNode`
    * 
    */
   type SpawnedArtReconcilerAndStateBagPairToLD[+SpawnedDOMNode <: dom.Element ]
   = SpawnedArtReconcilerAndStateBagPairImpl[Nothing, SpawnedDOMNode, ln.ReactiveElement[SpawnedDOMNode] ]

   /** 
    * an offered `Conversion` to retrieve the wrapped `ln.ReactiveElement[?]` from it
    * 
    * made not `implicit`, as
    * the resulting _Laminar Node ops/methods_ would bring these anomalies
    * (eg _`parentNode` returns `ln.ReactiveElement`s rather than `thisW3E.SpawnedArtReconcilerAndStateBagPair` !?_ , _why `removeFromParent()` on `thisW3E.SpawnedArtReconcilerAndStateBagPair`s !?_ )
    * 
    */
   def laminarInSpawneddLL[SpawnedLaminar <: ln.ReactiveElement[?] ]
   : Conversion[SpawnedArtReconcilerAndStateBagPairToLL[SpawnedLaminar] , SpawnedLaminar ]
   = (_: SpawnedArtReconcilerAndStateBagPairToLL[SpawnedLaminar] ).wrappedLaminarElem

   private[s1]
   opaque type SpawnedArtReconcilerAndStateBagPairImpl
      [
         +T0,
         +SpawnedDOMNode <: dom.Element ,
         +SpawnedLaminar <: ln.ReactiveElement[SpawnedDOMNode] ,
      ]
   <: AnyRef
   = ELaminarQckCore1SpwTwosL[?, ?, SpawnedLaminar ]

   private[s1]
   case class ELaminarQckCore1SpwTwosL
      [
         //
         +Sp
            <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[S, ?, SpawnedLaminar ]
         ,
         S
         ,
         +SpawnedLaminar <: ln.ReactiveElement[?]
         ,
      ]
      (impl: (LReconciliativeKeyTo1[Sp], S ) )
   {
      ;

      export impl.{_1 => reconcilerKey }

      /** a type-widened alias to `reconcilerKey`, to assist type-inference */
      private[w3e]
      val reconcilerKey1
      : LReconciliativeKeyTo1[Sp]
      = reconcilerKey

      export impl.{_2 => stateBag }
      type ActualStateBag
      = stateBag.type

      private[s1]
      type SB = S

      def wrappedLaminarElem
      : SpawnedLaminar
      = {
         ;

         reconcilerKey.toScnAllocAndReconcileAndDistillH
         .distillLHandle(stateBag )
      }

      ;

      ;
   }

   /** 
    * reconciliability between two `Art`s
    * 
    */
   given lspwmHeterognSpawnability
      [
         //

         Art <: LaminarSpawnable[SpawnedLaminar, SpawnedDOMNode] ,
         // m ,

         SpawnedLaminar <: ln.ReactiveElement[SpawnedDOMNode],
         SpawnedDOMNode <: dom.Element ,

         ReconcOpR ,

      ]
      (using fromBoolReconcOpR : Conversion[Boolean, ReconcOpR] = identity[Conversion[Boolean, Boolean] ](v => v ) )
   : (
      //

      SpawnabilityAndReconciliabilityNoArg[
         Art
         ,
         ? <: (
            SpawnedArtReconcilerAndStateBagPairToLL[SpawnedLaminar]
            & SpawnedArtReconcilerAndStateBagPairToLD[SpawnedDOMNode]
         )
         ,
         ReconcOpR,
      ]
   )
   = {
      ;

      def spawnImpl
         (mdl: Art)
      : ELaminarQckCore1SpwTwosL[?, ?, SpawnedLaminar]
      = {
         ;

         mdl

         match { case mdl : (Art & LaminarSpawnableReconcTuple[m, reconciler ] ) => {
            ;

            val spawned
            = mdl.spawnImpl() : mdl.xsclhReconciler.IntermediateState
            ; 
            locally[(mdl.reconcKey.type, spawned.type )](
               (mdl.reconcKey, spawned )
            )
            match { case p => p }
            match { case p => {
               ELaminarQckCore1SpwTwosL
                  [
                     mdl.xsclhReconciler.type ,
                     mdl.xsclhReconciler.IntermediateState,
                     SpawnedLaminar ,
                  ]
                  (p )
            } }
            match { case p => p : ELaminarQckCore1SpwTwosL[?, ?, SpawnedLaminar] }
         } }
      }

      def isOfSameReconcClassForHere
         (thisSpawned: ELaminarQckCore1SpwTwosL[?, ?, SpawnedLaminar] , newMdl: Art )
      = {
         ;

         isOfSameReconcClass(
            //
            thisSpawned.reconcilerKey
            : LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[thisSpawned.SB, ?, ? ] ]
            ,
            newMdl.reconcKey
            : LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, newMdl.mdl.type, ? ] ]
            ,
         )

         .map({ case e => {
            /* there's a spurious (ie for no reason) need for this `.asInstanceOf[T]` step */
            e
            .asInstanceOf[(
               LReconciliativeKeyTo1[(
                  LReconciliativeKey.ScnAllocAndReconcileAndDistillH[thisSpawned.SB, newMdl.mdl.type, ? ]
               ) ]
            ) ]
         } })

         .filter(_ => true )
      }

      def reconcileImplBetween
         (thisSpawned: ELaminarQckCore1SpwTwosL[?, ?, SpawnedLaminar] , newMdl: Art )
      : ReconcOpR
      = {
         ;

         (for {
            //

            commonReconcKey <- {
               isOfSameReconcClassForHere(thisSpawned, newMdl )
            }

            commonReconciler <- {
               //

               commonReconcKey

               //
               match { case e => commonReconcKey.toScnAllocAndReconcileAndDistillH }

               match { case e => Some[e.type](e ) }
               match { case e => e }
            }

            //
         }
         yield {
            commonReconciler
            .reconcile(thisSpawned.stateBag , newMdl.mdl )
         } )
         .nonEmpty
      }

      ;
      SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
         //
         spwImpl1 =
            (mdl: Art) =>
               spawnImpl(mdl)
         ,
         reconcImpl1 =
            reconcileImplBetween _
         ,
      )
   }

   // 

   ;
}



























val _ = {}
