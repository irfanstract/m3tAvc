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

   /* can't use 'wildcard appl to type args' */
   protected[s1]
   case class LSPM
      [
         M
         ,
         +ClsIPre <: LReconciliativeKey.XScanLeftHPreSMH[?, ?, ?]
         ,
      ]
      (impl: (LReconciliativeKeyTo1[ClsIPre & LReconciliativeKey.XScanLeftHPreSMH[?, M, ?] ] , M ) )
   {
      ;

      export impl.{_2 => mdl }

      export impl.{_1 => reconcKey0 }

      val xsclhReconciler
      // : ClsIPre & LReconciliativeKey.XScanLeftHPreSMH[?, M, ?] & LReconcilerForKey[reconcKey.type]
      = reconcKey0.XScanLeftHPreSMH
      // = ???

      val reconcKey
      : reconcKey0.type & LReconciliativeKeyTo1[xsclhReconciler.type]
      = xsclhReconciler.LReconciliativeKeyed

      // val rckPair
      // = reconcKey0.asWithXScanLeftHPreSMH  
      // export rckPair.{_1 => reconcKey , _2 => xsclhReconciler }

      export xsclhReconciler.{IntermediateState as CompIntermediateState}

      def spawnImpl()
      : xsclhReconciler.IntermediateState
      = {
         val xsclhReconciler1
         : LReconciliativeKey.XScanLeftHPreSMH[xsclhReconciler.IntermediateState, M, ? ]
         = xsclhReconciler
         xsclhReconciler1
         .spawnMd(mdl )
      }

      def reconcile1(d: CompIntermediateState )
      : Unit
      = xsclhReconciler.reconcile(d, mdl )

      def getHL(src: CompIntermediateState )
      = xsclhReconciler.distillLHandle(src)

   }

   protected
   opaque
   type LaminarSpawnable[
      +HL <: ln.ReactiveElement[HD & dom.Element],
      +HD <: dom.Node ,
   ]
   = (LSPM[?, ? ] )

   given lspwmHomognSpawnability
      [
         Art <: LSPM[?, LReconciliativeKey.XScanLeftHPreSMH[S, ?, HL] ] ,
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
               newMdl.reconcile1(thisSpawned )
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


   private[w3e]
   case class ELaminarQckCore1SpwTwosL
      [
         //
         +Sp
         <: LReconciliativeKey.XScanLeftHPreSMH[S, ?, ?]
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
         Art <: LSPM[?, LReconciliativeKey.XScanLeftHPreSMH[?, ?, HL] ] ,
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
               mdl match { case mdl : (Art & LSPM[m, reconciler ] ) => {
                  ;

                  val spawned
                  = mdl.spawnImpl() : mdl.xsclhReconciler.IntermediateState
                  ; 
                  locally[(mdl.reconcKey.type, spawned.type )](
                     (mdl.reconcKey, spawned )
                  )
                  match { case p => p }
                  match { case p => ELaminarQckCore1SpwTwosL[mdl.xsclhReconciler.type , mdl.xsclhReconciler.IntermediateState ] (p ) }
                  match { case p => p }
               } }
         ,
         reconcImpl1 =
            (thisSpawned: ELaminarQckCore1SpwTwosL[?, ?] , newMdl ) =>
               (for {
                  commonReconcKey <- {
                     isOfSameReconcClass(
                        //
                        thisSpawned.reconcilerKey : LReconciliativeKeyTo1[LReconciliativeKey.XScanLeftHPreSMH[thisSpawned.SB, ?, ? ] ] ,
                        newMdl.reconcKey : LReconciliativeKeyTo1[LReconciliativeKey.XScanLeftHPreSMH[?, newMdl.mdl.type, ? ] ] ,
                     )
                  }
                  commonReconciler <- {
                     commonReconcKey
                     match { case e => e }
                     match { case e => e.asInstanceOf[LReconciliativeKeyTo1[LReconciliativeKey.XScanLeftHPreSMH[thisSpawned.SB, newMdl.mdl.type, ? ] ] ] } /* there's a spurious (ie for no reason) need for this LOC */
                     match { case e => commonReconcKey.XScanLeftHPreSMH }
                     match { case e => e.asInstanceOf[LReconciliativeKey.XScanLeftHPreSMH[thisSpawned.SB, newMdl.mdl.type, ? ] ] } /* there's a spurious (ie for no reason) need for this LOC */
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
   //    (lspwmHomognSpawnability[M & LSPM[m, LReconciliativeKey.XScanLeftHPreSMH[?, m, HL] ] , m, HL] )
   //    match { case s => s }
   //    match { case s => s }
   // }

   // 

   ;
}

trait ELaminarQckCoreLrks
{
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   opaque type LReconciliativeKey
   <: Any & Matchable
   = (
      // LReconciliativeKey.impl.Id ,
      LReconciliativeKey.XScanLeftHPreSMH[?, ?, ?] ,
   )

   object LReconciliativeKey
   {
      ;

      def allocate
         (desc: XScanLeftHPreSMH[?, ?, ? ] )
      : LReconciliativeKey
      = al { desc }

      private [LReconciliativeKey]
      def al
         (desc: LReconciliativeKey.XScanLeftHPreSMH[?, ?, ?] )
      : LReconciliativeKey & LReconciliativeKey.WithId[impl.Id ]
      = { desc }

      opaque type WithId[+Id <: impl.Id ]
      = Any

      ;

      /* can't use 'wildcard appl to type args' */
      case class XScanLeftHPreSMH[
         TIntermediateState,
         -Md,
         +HL <: ln.ReactiveElement[?] ,
      ](
         //
         alloc: () => TIntermediateState
         ,
         reconcile: (TIntermediateState, Md) => Unit // TODO
         ,
         distillLHandle: TIntermediateState => HL
         ,
      )
      {
         ;

         type IntermediateState = TIntermediateState

         type Mdl = Md @annotation.unchecked.uncheckedVariance

         type HLI = HL @annotation.unchecked.uncheckedVariance

         val given_SpawnabilityAndReconciliabilityNoArg_Md_TIntermediateState
         : SpawnabilityAndReconciliabilityNoArg[Mdl, IntermediateState, Unit]
         = {
            SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
               //
               spwImpl1 = (v: Mdl) => { val c = alloc() ; reconcile(c, v) ; c }
               ,
               reconcImpl1 = reconcile
               ,
            )
         }

         ;
      }

      object XScanLeftHPreSMH {
         ;

         extension [
            //

            TIntermediateState,
            Md,
            HL <: ln.ReactiveElement[?] ,

            //
         ](impl: XScanLeftHPreSMH[TIntermediateState, Md, HL ] ) {
            //

            //

            def spawnMd
               (v: impl.Mdl )
            : impl.IntermediateState
            = { val c = impl.alloc() ; impl.reconcile(c, v) ; c }

            def spawnMdAsL
               (v: impl.Mdl )
            : impl.HLI
            = impl.spawnMd(v) match { case h => h : impl.IntermediateState } match { case h => impl.distillLHandle(h) }

            //
         }

         ;
      } // XScanLeftHPreSMH

      private[s1]
      object impl {
         ;

         type Id
         >: reg1.Id
         <: reg1.Id

         export reg1.addReg

         export reg1.idOf

         val reg1
         = ValueToUidAssociator[XScanLeftHPreSMH[?, ?, ? ] ]

         ;
      }

      ;
   }

   /** 
    * a `K` which would lead to a 'reconciler impl' conforming to the given `type`
    * 
    * co-variant - a retrieval
    * 
    */
   opaque type LReconciliativeKeyTo1[+T <: LReconciliativeKey.XScanLeftHPreSMH[?, ?, ?] ]
   <: LReconciliativeKey
   = (
      // LReconciliativeKey.impl.Id ,
      T ,
   )

   type LReconciliativeKey1
   = LReconciliativeKeyTo1[LReconciliativeKey.XScanLeftHPreSMH[?, ?, ?] ]

   /** 
    * a `K` whose `m` is uppoer-bounded to it
    * 
    * contra-variant - an input
    * 
    */
   type LReconciliativeKeyToMdl[-m]
   = LReconciliativeKeyTo1[LReconciliativeKey.XScanLeftHPreSMH[?, m, ?] ]

   /** 
    * a reconciler for the given `K`
    * 
    * co-variant - a retrieval
    * 
    */
   opaque type LReconcilerForKey[+K <: LReconciliativeKey ]
   = K @annotation.unchecked.uncheckedVariance

   extension [
      //

      // S,
      // m,
      // HL <: ln.ReactiveElement[?] ,

      AssocqueddReconcilerOps <: (
         // LReconciliativeKey.XScanLeftHPreSMH[S, m, HL]
         LReconciliativeKey.XScanLeftHPreSMH[?, ?, ?]
      )
      ,

      //
   ] (s: LReconciliativeKeyTo1[AssocqueddReconcilerOps] ) {
      //

      /** 
       * conversion `K -> AssocqueddReconcilerOps`
       * 
       */
      def XScanLeftHPreSMH
      : (
         AssocqueddReconcilerOps & LReconcilerForKey[s.type]
         // &
         // LReconciliativeKey.XScanLeftHPreSMH[s.IntermediateState, s.Mdl, s.HLI ]
      )
      = s

      /** 
       * to pair `(K, R)`
       * 
       */
      // @annotation.experimental
      def asWithXScanLeftHPreSMH
      : (
         ((LReconciliativeKey, AssocqueddReconcilerOps) { val _2 : LReconcilerForKey[_1.type] } )
         &
         ((LReconciliativeKey, AssocqueddReconcilerOps) { val _1 : LReconciliativeKeyTo1[_2.type] } )

         // ((LReconciliativeKey, AssocqueddReconcilerOps) { val _2 : LReconcilerForKey[_1.type] ; val _1 : LReconciliativeKeyTo1[_2.type] } )
      )
      = identity[(s.type, s.type )]((s, s ) )

      //
   }

   extension [K <: LReconciliativeKey](o: LReconcilerForKey[K]) {
      //

      /** 
       * conversion `R -> K`
       * 
       */
      def LReconciliativeKeyed
      : K & LReconciliativeKeyTo1[o.type]
      = o

      //
   }

   extension (s: LReconciliativeKey ) {
      //

      /** 
       * a side-utility to convert it to UID int
       * 
       */
      def uid
      = LReconciliativeKey.impl.idOf(s )

      //
   }

   /** 
    * a utility `Conversion` for
    * reconstructing the type-arg
    * 
    */
   given lrecTReconstr
   : Conversion[LReconciliativeKey, LReconciliativeKeyTo1[LReconciliativeKey.XScanLeftHPreSMH[?,?,? ] ] ]
   = identity[LReconciliativeKeyTo1[LReconciliativeKey.XScanLeftHPreSMH[?,?,? ] ] ] _

   /** 
    * returns non-empty if-and-only-if the two "are mutually-compatible".
    * 
    * that would mean `a1 == a2`
    * 
    */
   def isOfSameReconcClass(a1: LReconciliativeKey1 , a2: LReconciliativeKey1 )
   : Option[a1.type & a2.type]
   = {
      Some[a1.type ](a1)
      .collect[a1.type & a2.type ]({ case e : (a1.type & a2.type ) => e })
      .filter(e => { assert(e == a1 && e == a2 ) ; true } )
      .filter(e => true )
   }

   lazy val _ = {
      ;

      val fx
      = {
         (summon[reflect.TypeTest[String | Product, String] ].unapply _ )
         match { case f => f }
         match { case f => {
            (c: String | Product ) => {
               val mySeq = Seq() :+ f(c)
               Seq() :+ mySeq
               if true then {}
            } 
         } }
      }

      ;
   }

   ;
}



























val _ = {}
