package avcframewrk.forms

package templating

package w3e.impl.js

package s1


















/** 
 * 
 * narrows `Article` to the necessary sub-type.
 * 
 */
trait ELaminarQckCore
extends
   AnyRef
   with ELaminarQckCoreABackreferencings
   with w3e.pre.ArticlesViaLspw
   with ELaminarQckCore1
   with ELSRNA
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

   /** 
    * warning - this's add a reg into the registry (with)in the NS `LReconciliativeKey`, leading to "memory leak"!
    * 
    */
   def allocateFactory
      //
      [
         mdlT,
         SpawnedLaminar <: ln.ReactiveElement[SpawnedDOMNode] ,
         SpawnedDOMNode <: dom.Element ,
         ReconcOpR,
         UOpR ,
      ]
      (initialValue : => mdlT )
      (using c : SpawnabilityAndReconciliabilityNoArg[mdlT, SpawnedLaminar, ReconcOpR] )
      (using toUOpR : Conversion[Boolean, UOpR] = (identity[Boolean] _ ) : Conversion[Boolean, Boolean] )
   : ((mdl: mdlT ) => LaminarSpawnable[SpawnedLaminar, SpawnedDOMNode] )
   = {
      ;

      val lR
      = SRNA.allocateGScanLeft(initialMdl = initialValue )(c )
      
      locally {
         ;

         lR
         match { case lR => laminarSpawnableMdlFactory(lR ) }
         match { case f => f }
      }
   }

   ;
}

/** 
 * 
 * narrows `Article` to the necessary sub-type.
 * 
 */
trait ELaminarQckCoreHtml
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with ELaminarQckCore
{
   this : (
      AnyRef
      with ELaminarQckCore
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   override
   type Article
   >: LaminarSpawnable[ln.ReactiveHtmlElement[? <: dom.HTMLElement] , dom.HTMLElement ] | LaminarSpawnable[ln.ReactiveSvgElement[? <: dom.SVGElement] , dom.SVGElement ]
   <: LaminarSpawnable[ln.ReactiveHtmlElement[? <: dom.HTMLElement] , dom.HTMLElement ] | LaminarSpawnable[ln.ReactiveSvgElement[? <: dom.SVGElement] , dom.SVGElement ]

   /** 
    * (pre)allocate
    * am RCK which applies the given fnc .
    * returns
    * a RCK
    * whose `Model#` is an REMPM[MdlHighLevel] (a Tuple2 `forSome [ M ] (CompForMdl[M] , M )` )
    * (needs explicit import of `given_REMPM_CONV` which's not `implicit` as it's )
    * 
    */
   // TODO
   def allocateRemappingComp
      [
         MdlHighLevel,
         ModelAtLowerLvlT ,
         SPL <: ln.ReactiveElement[SPD ],
         SPD <: dom.Element ,
      ]
      (f: MdlHighLevel => ModelAtLowerLvlT )
      (initialMdl : => (
         //

         REMPM[?, [_] =>> (
            //
            LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ModelAtLowerLvlT, SPL] ] ,
            MdlHighLevel ,
         )]
      ) )
   // : (
   //    //
   //    LReconciliativeKeyTo1[(
   //       //
   //       LReconciliativeKey.ScnAllocAndReconcileAndDistillH[
   //          //
   //          ? <: (
   //             SpawnedArtReconcilerAndStateBagPairToLL[SPL ]
   //             & SpawnedArtReconcilerAndStateBagPairToLD[SPD ]
   //          ),
   //          REMPM[? <: MdlHighLevel, SPL],
   //          SPL,
   //       ]
   //    )]
   // )
   = {
      ;
      val sp = {
         lspwmHeterognSpawnability[Article & LaminarSpawnable[SPL, SPD], SPL, SPD, Boolean ]
         .compose((m0: (
            REMPM[?, [_] =>> (
               //
               LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ModelAtLowerLvlT, SPL] ] ,
               MdlHighLevel ,
            )]
         ) ) => {
            val m = m0.impl
            LaminarSpawnableReconcFromTuple ((m._1, m._2 match { case mdl => f(mdl) }) )
         } ) 
      }
      val spK
      = {
         SRNA.allocateGScanLeftAlt(initialMdl )(sp)(e => laminarInSpawneddLL(e) )
      }
      spK
   }

   @deprecated
   private[s1]
   case class REMPM
      [
         K ,
         +C[k]
         <: 
         (
            //
            LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ? ] ] ,
            Any ,
         )
         ,
      ]
   (impl: C[K] )

   /* offered, but not implied, adapter */
   def given_REMPM_CONV
      //
      [
         //
         C
         <: 
         (
            //
            LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, ?, ? ] ] ,
            Any ,
         )
         ,
      ]
   : Conversion[C , REMPM[?, [_] =>> C] ]
   = REMPM.apply[Any, [_] =>> C ] _

   ;
}

trait ELSRNA
extends
   AnyRef
   // with w3e.pre.ArticlesViaLspwmt
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   // that's all
   /* a temporary repetition here (of below) necessary to prevent the compiler from "crashing" or serious 100%-CPU hanging */
   // with w3e.pre.ArticlesViaLspw
   // with w3e.pre.Articles
   // with w3e.pre.ArticlesViaLspw
   with w3e.pre.ArticlesImplByL
   with ELaminarQckCoreLrks
{
   this : (
      AnyRef
      with w3e.pre.Articles
      with w3e.pre.ArticlesViaLspw
      with w3e.pre.ArticlesImplByL
      // with ELaminarQckCore1
      with ELaminarQckCoreLrks
      // with ELaminarQckCoreABackreferencings
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   /** 
    * warning - this's add a reg into the registry (with)in the NS `LReconciliativeKey`, leading to "memory leak"!
    * 
    */
   protected[avcframewrk]
   object SRNA
   {
      ;

      export LReconciliativeKey.allocate

      def allocateGScanLeft
         //
         [
            mdlT,
            SpawnedLaminar <: ln.ReactiveElement[?],
            ReconcOpR,
         ]
         (initialMdl: => mdlT )
         (impl : SpawnabilityAndReconciliabilityNoArg[mdlT, SpawnedLaminar, ReconcOpR] )
      : (
         SRNA
         [
            mdlT,
            SpawnedLaminar,
            ReconcOpR,
         ]
      )
      = {
         allocateGScanLeftAlt
            (initialMdl )
            (impl )
            (identity[SpawnedLaminar] _ )
      }

      /* generalisation where `SpawnedCompStateBag`s doesn't need to be `ANativeNode`s */
      def allocateGScanLeftAlt
         //
         [
            mdlT,
            SpawnedLaminar <: ln.ReactiveElement[?],
            S ,
            ReconcOpR,
         ]
         (initialMdl: => mdlT )
         (impl : SpawnabilityAndReconciliabilityNoArg[mdlT, S, ReconcOpR] )
         (getNativeNode: S => SpawnedLaminar )
      : (
         LReconciliativeKeyTo1[(
            LReconciliativeKey.ScnAllocAndReconcileAndDistillH[S , mdlT, SpawnedLaminar ]
         ) ]
      )
      = {
         ;
         allocate[mdlT, S, SpawnedLaminar, ReconcOpR ](
            //
            impl = impl,
            getWrappedNativeNode = getNativeNode ,
            initialMdl = initialMdl ,
            //
         )
      }

      ;

      ;
   }

   protected[avcframewrk]
   opaque type SRNA
      [
         -mdlT,
         +SpawnedLaminar <: ln.ReactiveElement[?] ,
         +ReconcOpR,
      ]
   <: LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, mdlT, SpawnedLaminar ] ]
   =  LReconciliativeKeyTo1[LReconciliativeKey.ScnAllocAndReconcileAndDistillH[?, mdlT, SpawnedLaminar ] ]

   ;

   ;

}

/** 
 * 
 * sometimes,
 * you'll need the instantiation to be immediate,
 * but
 * some other times,
 * you'll need to defer it into being a 'template'
 * 
 * usage
 * ```
 * def implCreateMainNode
 *    (using ... ... )
 *    (... ... ... ... )
 *    (using givenELaminarIndirectionImpl : ELaminarIndirectionImpl )
 *    (using ... ... )
 * : givenELaminarIndirectionImpl.AppliedR
 * &eq; {
 *   ...
 *   ...
 *   givenELaminarIndirectionImpl.appliedTo {
 *     import laminar.api.L
 *     import L.{given }
 *     ;
 *     L.p("my paragraph about", ..., ..., ... ... )
 *   }
 * }
 * ```
 * 
 */
private[w3e]
opaque type ELaminarIndirection
<: AnyRef & ELaminarIndirectionImpl
= ELaminarIndirectionImpl

private[s1]
trait ELaminarIndirectionImpl
{
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   def appliedTo
      (s: => AppliedS )
   : AppliedR

   type AppliedS
   >: ln.ReactiveElement[?]
   <: ln.ReactiveElement[?]

   type AppliedR
   <: Any

   ;
}

private[s1]
object ELaminarIndirectionImpl
{
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   object directly extends
   ELaminarIndirectionImpl
   {
      ;

      type AppliedS
      >: ln.ReactiveElement[?]
      <: ln.ReactiveElement[?]

      opaque type AppliedR
      <: AppliedS
      = AppliedS

      override
      // transparent
      // inline
      def appliedTo
         (s: => AppliedS )
      : (AppliedR )
      = s

      ;
   }

   ;
}

















val _ = {}
