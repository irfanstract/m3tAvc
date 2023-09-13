package avcframewrk.forms

package templating

package w3e.impl.js

package s1




















trait ELaminarQckCore1
extends
   AnyRef
   with w3e.pre.ArticlesViaLspw
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
      +HL <: ln.ReactiveElement[HD & dom.Element],
      +HD <: dom.Node ,
   ]
   = (LaminarSpawnableReconcTuple[?, ? ] )

   case class LAsReconciliativeKeyPair
      [
         +K <: Singleton & LReconciliativeKeyTo1[ClsI ] 
         ,
         +ClsI <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?]
         ,
      ]
      (reconcKey0 : K )
   {
      ;

      val xsclhReconciler
      = reconcKey0.toScnAllocAndReconcileAndDistillH
      // = ???

      val reconcKey
      : reconcKey0.type & LReconciliativeKeyTo1[xsclhReconciler.type]
      = xsclhReconciler.LReconciliativeKeyed

      export xsclhReconciler.{IntermediateState as CompIntermediateState}

      ;
   }

   /* can't use 'wildcard appl to type args' */
   protected[s1]
   case class LaminarSpawnableReconcTuple
      [
         M
         ,
         +ClsIPre <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?]
         ,
      ]
      (impl: (LReconciliativeKeyTo1[ClsIPre & LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, M, ?] ] , M ) )
   {
      ;

      export impl.{_2 => mdl }

      export impl.{_1 => reconcKey0 }

      val asrcp = LAsReconciliativeKeyPair(reconcKey0 )

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

   locally {
      ;

      def gt[HL <: ln.ReactiveElement[dom.Element] ]
      = summon[HL <:< NativeDocNode ]

      def gt1[HL <: ln.ReactiveElement[dom.Element] ]
      = ((arg: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?] ) => {} )

      // summon[(LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?]#HLI ) <:< NativeDocNode ]

      locally(((arg: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?]#HLI ) => {} ))

      locally([HL <: ln.ReactiveElement[dom.Element] ] => ((arg: () => (1 | 2 | 3 ) ) => {} ))

      // summon[NativeDocNode =:= LReconciliativeKey.ScnAllocAndReconcileAndDistillH.ENativeDocNode ]

      summon[NativeDocNode <:< ln.ReactiveElement[?] ]

      // ((a: LReconciliativeKey.ScnAllocAndReconcileAndDistillH.ENativeDocNode ) => identity(a) )

      // summon[LReconciliativeKey.ScnAllocAndReconcileAndDistillH.ENativeDocNode <:< ln.ReactiveElement[?] ]

      // locally(((arg: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, LReconciliativeKey.ScnAllocAndReconcileAndDistillH.ENativeDocNode ] ) => {} ))

      // locally([HL <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH.ENativeDocNode ] => ((arg: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, HL ]#HLI ) => {} ))

      // locally([HL <: NativeDocNode ] => ((arg: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, HL ]#HLI ) => {} ))

      // locally([HL <: ln.ReactiveElement[dom.Element] ] => ((arg: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, HL ]#HLI ) => {} ))

   }

   given lspwmHomognSpawnability
      [
         Art <: LaminarSpawnableReconcTuple[?, LReconciliativeKey.ScnAllocAndReconcileAndDistillH[S, ?, HL] ] ,
         S ,
         HL <: ln.ReactiveElement[dom.Element],
         // T0 ,
         ReconcOpR ,
      ]
      (using given_ValueOf_ReconcOpR : ValueOf[ReconcOpR] = summon[ValueOf[Unit] ] )
   : SpawnabilityAndReconciliabilityNoArg[Art, S, ReconcOpR ]
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

   def given_LaminarSpawnable_reconCls
      [
         // HL <: ln.ReactiveElement[HD & dom.Element],
         // HD <: dom.Node ,
         T0 ,
      ]
   : (art: Article ) => (LReconciliativeKey & LReconciliativeKeyOfArt[art.type ] )
   = {
      identity[LaminarSpawnable[ln.ReactiveElement[dom.Element], dom.Element ] => LReconciliativeKey ](_.reconcKey )
   }

   opaque type LReconciliativeKeyOfArt[+A <: Article ]
   = Any

   type LaminarSpawnedNoTParam
   = LaminarSpawnedImpl[Nothing, dom.Element ]

   protected
   opaque type LaminarSpawnedImpl[+T0, +HD <: dom.Element ]
   <: AnyRef
   = ELaminarQckCore1SpwTwosL[?, ?]

   private[s1]
   case class ELaminarQckCore1SpwTwosL
      [
         //
         +Sp
         <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[S, ?, ?]
         ,
         S
         ,
      ]
      (impl: (LReconciliativeKeyTo1[Sp], S ) )
   {
      ;

      export impl.{_1 => reconcilerKey }
      private[w3e]
      val reconcilerKey1
      : LReconciliativeKeyTo1[Sp]
      = reconcilerKey

      export impl.{_2 => stateBag }
      type SB = S

      ;

      ;
   }

   @annotation.experimental
   given lspwmUnconditionalSpawnability
      [
         //
         Art <: LaminarSpawnableReconcTuple[?, LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, HL] ] ,
         M <: LaminarSpawnable[HL, HD] ,
         // m ,
         HL <: ln.ReactiveElement[HD],
         HD <: dom.Element ,
         ReconcOpR >: Boolean <: Boolean ,
      ]
   : SpawnabilityAndReconciliabilityNoArg[Art , LaminarSpawnedNoTParam, ReconcOpR ]
   = {
      ;
      SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
         //
         spwImpl1 =
            (mdl: Art) =>
               mdl match { case mdl : (Art & LaminarSpawnableReconcTuple[m, reconciler ] ) => {
                  ;

                  val spawned
                  = mdl.spawnImpl() : mdl.xsclhReconciler.IntermediateState
                  ; 
                  locally[(mdl.reconcKey.type, spawned.type )](
                     (mdl.reconcKey, spawned )
                  )
                  match { case p => p }
                  match { case p => ELaminarQckCore1SpwTwosL[mdl.xsclhReconciler.type , mdl.xsclhReconciler.IntermediateState ] (p ) }
                  match { case p => p : ELaminarQckCore1SpwTwosL[?, ?] }
               } }
         ,
         reconcImpl1 =
            (thisSpawned: ELaminarQckCore1SpwTwosL[?, ?] , newMdl ) =>
               (for {
                  commonReconcKey <- {
                     isOfSameReconcClass(
                        //
                        thisSpawned.reconcilerKey : LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[thisSpawned.SB, ?, ? ] ] ,
                        newMdl.reconcKey : LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, newMdl.mdl.type, ? ] ] ,
                     )
                  }
                  commonReconciler <- {
                     commonReconcKey
                     match { case e => e }
                     match { case e => e.asInstanceOf[LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[thisSpawned.SB, newMdl.mdl.type, ? ] ] ] } /* there's a spurious (ie for no reason) need for this LOC */
                     match { case e => commonReconcKey.toScnAllocAndReconcileAndDistillH }
                     match { case e => e.asInstanceOf[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[thisSpawned.SB, newMdl.mdl.type, ? ] ] } /* there's a spurious (ie for no reason) need for this LOC */
                     match { case e => Some[e.type](e ) }
                     match { case e => e }
                  }
               }
               yield {
                  commonReconciler.reconcile(thisSpawned.stateBag , newMdl.mdl )
               } )
               .nonEmpty
         ,
      )
   }
   // = {
   //    ;
   //    (lspwmHomognSpawnability[M & LaminarSpawnableReconcTuple[m, LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, m, HL] ] , m, HL] )
   //    match { case s => s }
   //    match { case s => s }
   // }

   // 

   ;
}

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



























val _ = {}
