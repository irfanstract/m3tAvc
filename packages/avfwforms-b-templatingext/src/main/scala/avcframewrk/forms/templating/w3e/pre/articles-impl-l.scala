package avcframewrk.forms

package templating

package w3e.pre

















trait ADefinesNativeDocNodeType0
extends
   AnyRef
{
   ;

   /** 
    * supposed to be the main/primary data-type (or repr) in the targeted backend/fw -
    * this could be `React.Element`, `DOM.Element`, `Laminar.Element`, etc
    * 
    */
   type NativeDocNode

   ;

   ;
}

trait ArticlesImplScn
extends
   AnyRef
   with ADefinesNativeDocNodeType0
{
   thisArticlesImplByL : (
      AnyRef
      & ADefinesNativeDocNodeType0
   ) =>
   ;

   import avcframewrk.forms.templating.rendering.reconciliabilityC.{*}

   import org.scalajs.dom

   ;

   ;

   /* can't use 'wildcard appl to type args' */
   final
   case class ScnAllocAndReconcileAndDistillH[
      TIntermediateState,
      -Md,
      +HL <: NativeDocNode ,
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

   object ScnAllocAndReconcileAndDistillH {
      ;

      extension [
         //

         TIntermediateState,
         Md,
         HL <: NativeDocNode ,

         //
      ](impl: ScnAllocAndReconcileAndDistillH[TIntermediateState, Md, HL ] ) {
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
   } // ScnAllocAndReconcileAndDistillH

   summon[ScnAllocAndReconcileAndDistillH[?, ?, NativeDocNode] <:< Any ]

   ;

}

/** 
 * 
 * implementative mix-in `ELaminarQckCoreLrksBased`
 * 
 */
trait ArticlesImplLReconciliativeKeyFoundPairs
extends
   AnyRef
   //
   // with ArticlesImplByL
{
   thisELaminarQckCoreLrks : (
      AnyRef
      & ArticlesImplByL
      // & w3e.pre.ArticlesViaLspw
   ) =>
   ;

   ;

   import org.scalajs.dom

   ;

   protected[avcframewrk]
   case class LReconciliativeKeyFoundImplPair
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

   ;
}

// @deprecated
trait ArticlesImplByL
extends
   AnyRef
   with ADefinesNativeDocNodeType0
{
   thisArticlesImplByL : (
      AnyRef
   ) =>
   ;

   import avcframewrk.forms.templating.rendering.reconciliabilityC.{*}

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
      // // TODO remove all these bounds
      // >: com.raquo.laminar.nodes.ReactiveElement[?]
      // <: com.raquo.laminar.nodes.ReactiveElement[?]

   ;

   private[avcframewrk]
   given given_ArticlesImplByL1
   : ArticlesImplByL1
   with {
      ;

      ;

      /** 
       * supposed to be the main/primary data-type (or repr) in the targeted backend/fw -
       * this could be `React.Element`, `DOM.Element`, `Laminar.Element`, etc
       * 
       */
      override
      type NativeDocNode
         >: thisArticlesImplByL.NativeDocNode
         <: thisArticlesImplByL.NativeDocNode

      ;

      ;
   }

   // export given_ArticlesImplByL1.{given }

   /* `LReconciliativeKey` and sub-types */
   export given_ArticlesImplByL1.{
      LReconciliativeKey ,
      lrecTReconstr ,
      LReconciliativeKey1 ,
      LReconciliativeKeyTo1 ,
      LReconciliativeKeyToMdl ,
      // LReconciliativeKeyOfArt ,
   }

   /* the key-assoc-ed Reconciler */
   export given_ArticlesImplByL1.{
      toScnAllocAndReconcileAndDistillH ,
      asWithXScanLeftHPreSMH ,
      LReconcilerForKey ,
   }

   export given_ArticlesImplByL1.{
      /* given a Reconciler, get back the key */
      LReconciliativeKeyed ,
   }

   export given_ArticlesImplByL1.{
      uid ,
   }

   export given_ArticlesImplByL1.{
      isOfSameReconcClass ,
   }

   ;

   ;

   ;
}

// @deprecated
private[avcframewrk] 
trait ArticlesImplByL1
extends
   AnyRef
   with ADefinesNativeDocNodeType0
   with ArticlesImplScn
{
   thisArticlesImplByL : (
      AnyRef
   ) =>
   ;

   import avcframewrk.forms.templating.rendering.reconciliabilityC.{*}

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
      // // TODO remove all these bounds
      // >: com.raquo.laminar.nodes.ReactiveElement[?]
      // <: com.raquo.laminar.nodes.ReactiveElement[?]

   opaque type LReconciliativeKey
   <: Any & Matchable
   = (
      // LReconciliativeKey.impl.Id ,
      LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?] ,
   )

   object LReconciliativeKey
   {
      ;

      def allocate
         [T0 <: ScnAllocAndReconcileAndDistillH.type ] /* necessary to avoid the 'misbehaving' ovld-resolution */
         (desc: ScnAllocAndReconcileAndDistillH[?, ?, ? ] )
      : (
         LReconciliativeKeyTo1[desc.type ]
      )
      = al { desc }

      def allocate
         [
            mdlT ,
            SpecificStateBag
            ,
            NativeNode1
               <: thisArticlesImplByL.NativeDocNode
            ,
            ReconcOpR
            ,
         ]
         (
            //
            impl
               : SpawnabilityAndReconciliabilityNoArg[mdlT, SpecificStateBag, ReconcOpR ]
            ,
            getWrappedNativeNode
               : SpecificStateBag => NativeNode1
            ,
            initialMdl
               : => mdlT
            ,
         )
      : (
         LReconciliativeKeyTo1[(
            ScnAllocAndReconcileAndDistillH[SpecificStateBag, mdlT, NativeNode1]
         ) ]
      )
      = allocate[ScnAllocAndReconcileAndDistillH.type ] {
         ;

         ScnAllocAndReconcileAndDistillH[SpecificStateBag, mdlT, NativeNode1 ] (
            //
            alloc =
               () =>
                  impl.spawn(initialMdl )( )
            ,
            reconcile =
               (s: SpecificStateBag, newMdl: mdlT ) => { impl.model_=(s )(newMdl ) ; }
            ,
            distillLHandle =
               getWrappedNativeNode
            ,
            //
         )
      }

      private [LReconciliativeKey]
      def al
         (desc: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?] )
      : LReconciliativeKey & LReconciliativeKeyTo1[desc.type ] & LReconciliativeKey.WithId[impl.Id ]
      = { desc }

      opaque type WithId[+Id <: impl.Id ]
      = Any

      ;

      // export thisArticlesImplByL.ScnAllocAndReconcileAndDistillH
      /* `export` like above for some reason caused unexpected failures ; manually desugared it to these */

      type ScnAllocAndReconcileAndDistillH
         //
         [
            TIntermediateState,
            -Md,
            +HL <: thisArticlesImplByL.NativeDocNode ,
         ]
      = thisArticlesImplByL.ScnAllocAndReconcileAndDistillH[TIntermediateState, Md, HL]

      final
      lazy val ScnAllocAndReconcileAndDistillH
      : thisArticlesImplByL.ScnAllocAndReconcileAndDistillH.type
      = thisArticlesImplByL.ScnAllocAndReconcileAndDistillH

      private[avcframewrk]
      object impl {
         ;

         import avcframewrk.forms.localutil.ValueToUidAssociator

         type Id
         >: reg1.Id
         <: reg1.Id

         export reg1.addReg

         export reg1.idOf

         val reg1
         = ValueToUidAssociator[ScnAllocAndReconcileAndDistillH[?, ?, ? ] ]

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
   opaque type LReconciliativeKeyTo1[+T <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?] ]
   <: LReconciliativeKey
   = (
      // LReconciliativeKey.impl.Id ,
      T ,
   )

   type LReconciliativeKey1
   = LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?] ]

   /** 
    * a `K` whose `m` is uppoer-bounded to it
    * 
    * contra-variant - an input
    * 
    */
   type LReconciliativeKeyToMdl[-m]
   = LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, m, ?] ]

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
         // LReconciliativeKey.ScnAllocAndReconcileAndDistillH[S, m, HL]
         LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ?]
      )
      ,

      //
   ] (s: LReconciliativeKeyTo1[AssocqueddReconcilerOps] ) {
      //

      /** 
       * conversion `K -> AssocqueddReconcilerOps`
       * 
       */
      def toScnAllocAndReconcileAndDistillH
      : (
         AssocqueddReconcilerOps & LReconcilerForKey[s.type]
         // &
         // LReconciliativeKey.ScnAllocAndReconcileAndDistillH[s.IntermediateState, s.Mdl, s.HLI ]
      )
      = s

      /** 
       * to pair `(K, R)`
       * 
       */
      // @annotation.experimental
      def asWithXScanLeftHPreSMH
      : (
         /* needs to be split into conjunction of two ; to ensure compilative finicy */

         ((LReconciliativeKey, AssocqueddReconcilerOps) { val _2 : LReconcilerForKey[_1.type] } )
         &
         ((LReconciliativeKey, AssocqueddReconcilerOps) { val _1 : LReconciliativeKeyTo1[_2.type] } )

      )
      = identity[(s.type, s.type )]((s, s ) )

      //
   }

   extension [
      K <: LReconciliativeKeyTo1[RC] ,
      RC <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ? ] ,

      //
   ](o: LReconcilerForKey[K] & RC ) {
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
   : Conversion[LReconciliativeKey, LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?,?,? ] ] ]
   = identity[LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?,?,? ] ] ] _

   // ; summon[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[xsclhReconciler.IntermediateState, M, ? ]#HLI <:< Any ]
   // ; summon[NativeDocNode <:< Any ]
   // ; summon[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[xsclhReconciler.IntermediateState, M, ? ]#HLI <:< AnyRef ]
   // ; summon[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[xsclhReconciler.IntermediateState, M, ? ]#HLI <:< ln.ReactiveElement[?] ]

   summon[ScnAllocAndReconcileAndDistillH[?, ?, NativeDocNode] <:< Any ]

   summon[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, NativeDocNode] <:< Any ]

   locally {}

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
