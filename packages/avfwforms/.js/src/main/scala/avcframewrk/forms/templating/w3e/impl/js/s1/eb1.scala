package avcframewrk.forms

package templating

package w3e.impl.js

package s1




















/** 
 * 
 * implementative mix-in `ELaminarQckCore1`
 * 
 */
trait ELaminarQckCore1
extends
   AnyRef
   with w3e.pre.ArticlesViaLspw
   with ELaminarQckCoreLaminarSpawnableAbstract1
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

   // TODO
   /** 
    * given `reconcilerKey`,
    * returns
    * a factory which
    * , given `subArtMdl`, will return a `LaminarSpawnable`
    * 
    * ```
    * // the reconc key for Button comp(s)
    * lazy val buttonCompReconcKey
    * = allocReconciliativeKey(.....)(.....)
    * 
    * // the comp factory "Button"
    * lazy val Button
    * = laminarSpawnableMdlFactory(buttonCompReconcKey )
    * ```
    * 
    * this entry-point
    * is necessary to have, as
    * the `type`-aliasing by `LaminarSpawnable` is `opaque` rather than `transparent` (and so would prevent conformance )
    * 
    */
   def laminarSpawnableMdlFactory
      //
      [
         //

         mdlT
         ,
         SpecificBinaryReconcilerTPre
            <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, mdlT, SpawnedLaminar]
         ,
         SpawnedLaminar <: ln.ReactiveElement[SpawnedDOMNode & dom.Element],
         SpawnedDOMNode <: dom.Node ,
      ]
      (reconcilerKey: (
         //

         LReconciliativeKeyTo1[(
            SpecificBinaryReconcilerTPre
            & LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, mdlT, ?]
         ) ]
      ) )
   : ((subArtMdl: mdlT ) => LaminarSpawnable[SpawnedLaminar, SpawnedDOMNode] )
   = {
      LaminarSpawnableMdlFactoryImpl(reconcilerKey = reconcilerKey )
   }

   /** 
    * to be used in the impl of the above method.
    * a 'curried-form factory' for `LaminarSpawnableReconcTuple`s,
    * made a `case class` to give some good to equality-comparison(s)
    * in case there's multiple calls to that method with same *key*
    * 
    */
   private[s1]
   case class LaminarSpawnableMdlFactoryImpl
      //
      [
         mdlT
         ,
         +SpecificBinaryReconcilerTPre
            <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, mdlT, ?]
         ,
      ]
      (reconcilerKey: (
         //
   
         LReconciliativeKeyTo1[(
            SpecificBinaryReconcilerTPre
         ) ] 
      ) )
   extends
      AnyRef
      with (mdlT => LaminarSpawnableReconcTuple[mdlT, SpecificBinaryReconcilerTPre ] )
   {
      ;

      override
      def apply(mdl: mdlT )
      = LaminarSpawnableReconcTuple[mdlT, SpecificBinaryReconcilerTPre ]((reconcilerKey, mdl ) )

      ;
   }

   /* can't use 'wildcard appl to type args' */
   // protected[s1]
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

   export LaminarSpawnableReconcTuple.{apply => LaminarSpawnableReconcTupleImplBy }

   @deprecated
   private[avcframewrk]
   object LaminarSpawnableReconcFromTuple
   {
      ;

      export LaminarSpawnableReconcTuple.unapply

      val _ = 5
      lazy val _ = 5

      ;
   }

   lazy val _ = {
      ;

      def gt1[SpawnedLaminar <: ln.ReactiveElement[dom.Element] ]
      = ((arg: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?] ) => {} )

      // summon[(LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?]#HLI ) <:< NativeDocNode ]
      ???

      locally(((arg: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?]#HLI ) => {} ))

      locally([SpawnedLaminar <: ln.ReactiveElement[dom.Element] ] => ((arg: () => (1 | 2 | 3 ) ) => {} ))

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

   /** 
    * an offered `Conversion` to retrieve the wrapped `ln.ReactiveElement[?]` from it
    * 
    * made not `implicit`, as
    * the resulting _Laminar Node ops/methods_ would bring these anomalies
    * (eg _`parentNode` returns `ln.ReactiveElement`s rather than `thisW3E.SpawnedArtReconcilerAndStateBagPair` !?_ , _why `removeFromParent()` on `thisW3E.SpawnedArtReconcilerAndStateBagPair`s !?_ )
    * 
    */
   def laminarInSpawneddLL[SpawnedLaminar <: ln.ReactiveElement[?] ]
   = laminarInSpawneddLLImplicits.laminarInSpawneddLL[SpawnedLaminar]

   object laminarInSpawneddLLImplicits {
      ;

      given laminarInSpawneddLL[SpawnedLaminar <: ln.ReactiveElement[?] ]
      : Conversion[SpawnedArtReconcilerAndStateBagPairToLL[SpawnedLaminar] , SpawnedLaminar ]
      = (_: SpawnedArtReconcilerAndStateBagPairToLL[SpawnedLaminar] ).wrappedLaminarElem

      ;
   }

   private[s1]
   override
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
