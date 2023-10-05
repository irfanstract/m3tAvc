package avcframewrk.forms

package templating

package ext.givmk

package impl
















private
trait LlEaKoT
{
   ;

   ;

   type KeyObjTrait

   ;

   ;

   protected[givmk]
   lazy val sc
   = {
      ;
      given_Console_alt
      // .subConsole("avcframewrk.forms.templating.ext.givmk.impl.<--?%")
   }

   protected[givmk]
   def scForLlAttr
      (key: KeyObjTrait )
   = {
      ;
      sc
      .subConsole(s"[for ${key }]")
   }

   ;
}

/** 
 * 
 * a 'cache', lazy, permitting CTXB(s)-dependent initialiser/CFN(s) .
 * to be generic in-terms-of the exact set of the CTXB(s) the CFN can expect/require,
 * there needs to be these customisability in the CTXB(ing)
 * 
 */
protected
class LlEaKoTMap
   //
   [
      BaseKT ,
      BaseVBoxT ,
      SpcK   [-VL <: VU, +VU ] <: BaseKT ,
      +SpcVBox[-VL <: VU, +VU ] <: BaseVBoxT ,
      FVIO[V] <: LlEaKoTMap.ForVInitOpsImpl[V] ,
   ]
   // (
   // )
extends
AnyRef
   with LlEaKoT
{
   ;

   ;

   override
   type KeyObjTrait
   >: BaseK
   <: BaseK

   protected
   val cache
   = {
      newJsWeakMap[KeyObjTrait , BaseVBox ]
   }

   protected
   final
   lazy
   val ts: (
      typeBoxProvider.ForExactly[BaseKT] ,
      typeBoxProvider.ForExactly[BaseVBoxT] ,
      typeBoxProvider.ForExactly[SpcK] ,
      typeBoxProvider.ForExactly[SpcVBox] ,
      typeBoxProvider.ForExactly[FVIO] ,
   ) @annotation.unchecked.uncheckedVariance
   = {
      ???
   }

   export ts._1.{CAP as BaseK }
   export ts._2.{CAP as BaseVBox }

   // type SpecificKeyObjTraitLU[VL <: VU, VU]
   // = SpcK[VL, VU]
   export ts._3.{CAP as SpecificKeyObjTraitLU }

   type SpecificKeyObjTrait[V]
   = SpecificKeyObjTraitLU[V, V]

   type SpecificVBoxObjTrait[V]
   = SpcVBox[V, V] @annotation.unchecked.uncheckedVariance

   // inline
   def apply
      [
         V
         ,
      ]
      (key: SpcK[V, V] )
      (using FVIO[V] )
   : SpecificVBoxObjTrait[V]
   = {
      ;

      given givenThis
      : (
         LlEaKoTMap.this.type
         & LlEaKoTMap.ByBaseKVT[BaseKT, BaseVBoxT]
      )
      // = this
      = ([E] => () => LlEaKoTMap.this.asInstanceOf[E] ).apply()

      cache.updateWith(key )(o => {
         o
         .orElse({
            ;

            {
               ;

               smr.allocate(key )
            }
            .pipeLooseSelf(Some(_) )
         } )
      } )
      .get
      .pipeLooseSelf(e => {
         smr.reconvImpl(e )
      } )
   }

   /** 
    * summon the `given` instance.
    * 
    */
   protected
   def smr
      [V]
      (using ctx : FVIO[V] )
   : ctx.type
   = ctx

   private
   implicit
   inline
   def summonTypeableInline[V]
   : reflect.Typeable[V]
   = compiletime.summonInline[reflect.Typeable[V] ]

   ;
}

object LlEaKoTMap {
   ;

   // // @deprecated
   // type _Any
   // = ByBaseKVT[?, ? ]

   type ByBaseKVT
      [BaseKT, BaseVBoxT]
   = LlEaKoTMap[
      //
      BaseKT,
      BaseVBoxT,
      ? <: [_, _] =>> BaseKT ,
      ? <: [_, _] =>> BaseVBoxT ,
      ? <: [v] =>> ForVInitOpsImpl[v] ,
   ]

   trait ForVInitOpsImpl[V]
   {
      ;

      def allocate
         [BaseKT, BaseVBoxT]
         (using ctx: ByBaseKVT[BaseKT, BaseVBoxT] )
         (k: ctx.SpecificKeyObjTrait[V] )
      : ctx.SpecificVBoxObjTrait[V]

      def reconvImpl
         [BaseKT, BaseVBoxT]
         (using ctx: ByBaseKVT[BaseKT, BaseVBoxT] )
         (k: ctx.BaseVBox )
      : ctx.SpecificVBoxObjTrait[V]

      ;
   }

   ;
}















val _ = {}
