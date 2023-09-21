package avcframewrk.forms

package templating

package w3e.impl.js

package s1















/** 
 * 
 * narrows `Article` to the necessary sub-type.
 * 
 */
trait ELaminarQckCoreReMppsHtml
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with ELaminarQckCore
{
   this : (
      AnyRef
      with ELaminarQckCore
      with ELaminarQckCoreHtml
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

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














val _ = {}
