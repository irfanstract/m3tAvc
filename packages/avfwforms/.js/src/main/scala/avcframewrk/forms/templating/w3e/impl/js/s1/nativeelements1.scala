package avcframewrk.forms

package templating

package w3e.impl.js

package s1













private[avcframewrk]
trait ENativeElementsD1
extends
   AnyRef
   with ELaminarQckCoreABackreferencings
{
   this : (
      AnyRef
      with ELaminarQckCoreABackreferencings
   ) =>
   ;

   import org.scalajs.dom

   import com.raquo.laminar.{nodes as ln}

   import laminar.api.L

   ;

   ;

   given given_SpawnabilityAndReconciliability_Laspa[XModel <: LaspaStatic]
   : SpawnabilityAndReconciliabilityNoArg[Option[LaspaStatic], ln.ReactiveHtmlElement[dom.HTMLAnchorElement], Unit ]
   = {
      ;

      ;

      given_SpawnabilityAndReconciliability_CaseClassGeneralised1[
         Option[LaspaStatic]
         ,
         dom.HTMLAnchorElement
         ,
      ](
         //
         prov => prov(laminar.api.L.href )((_ ).flatMap(_.href ).map(_.toASCIIString().nn ).getOrElse("") , "" )
         ,
         prov => prov(laminar.api.L.disabled )((_ ).isEmpty, false )
         ,

      )(nativeElemLCtor = L.a )
   }

   case class LaspaStatic(
      //
      href : ([A] =>> A )[Option[java.net.URI] ]
      ,
   )

   ;

   ;

   ;
} // ENativeElementsD1

;

/**
 * 
 * generalisation of `SpawnabilityAndReconciliabilityNoArg` to arbitrary 'element's
 * 
 */
object given_SpawnabilityAndReconciliability_CaseClassGeneralised1
extends
AnyRef
with ELaminarQckCoreABackreferencings
{
   ;

   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   type SrcLensAndDestAttrPairRaw[-XModel, V] =  (
      (
         (mdl: XModel) => V
         ,
         V
         ,
         (com.raquo.laminar.keys.HtmlAttr[V] | com.raquo.laminar.keys.HtmlProp[V, V] )
         ,
      )
   )

   type SrcLensAndDestAttrPairRawFunc[-XModel]
   = SrcLensAndDestAttrPairRawFuncInvar[XModel @annotation.unchecked.uncheckedVariance ]
   type SrcLensAndDestAttrPairRawFuncInvar[XModel]
   = (
      (f: (
         [V] =>
         (targetedAttr: com.raquo.laminar.keys.HtmlAttr[V] | com.raquo.laminar.keys.HtmlProp[V, V] ) =>
         (distill: (mdl: XModel) => V, defaultValue: V ) =>
            SrcLensAndDestAttrPair[XModel, V ] 
      ) ) =>
         SrcLensAndDestAttrPair[XModel, ? ] 
   )

   def apply
      [
         XModel <: Matchable & Product ,
         NativeE <: dom.HTMLElement ,
      ]
      (srcToSetterPairs: SrcLensAndDestAttrPairRawFunc[XModel] * )
      (
         nativeElemLCtor : com.raquo.laminar.tags.HtmlTag[NativeE]
         ,
      )
   : SpawnabilityAndReconciliabilityNoArg[XModel, ln.ReactiveHtmlElement[NativeE], Unit ]
   = {
      ;

      class XEAndStateBag1() extends
      aBackreferencings.XEAndStateBag(ec = { nativeElemLCtor })
      with aBackreferencings.XEAndStateBagCm[XModel, Unit]
      {
         //

         import laminar.api.L

         override
         def close(): Unit
         = {
            closeAllOf[laminar.api.L.Observer[?] ]((
               srcToSetterDispatchers

            ))
         }

         val srcToSetterDispatchers
         = {
            for ((f ) <- srcToSetterPairs )
            yield {
               ;
               ({
                  ;

                  (f.apply((
                     //

                     [V] =>
                     (targetedAttr: com.raquo.laminar.keys.HtmlAttr[V] | com.raquo.laminar.keys.HtmlProp[V, V] ) =>
                     (distill: (mdl: XModel) => V, defaultValue: V ) =>
                     {
                        ;
                        ((distill, defaultValue, targetedAttr ) )
                        match { case p => p : SrcLensAndDestAttrPairRaw[XModel, V ] }
                        match { case p => SrcLensAndDestAttrPair(p) }
                     }
                  ) ) )
                  match { case f1 => (f1 : SrcLensAndDestAttrPair[XModel, ? ] ) }
               })
               match { case f: SrcLensAndDestAttrPair[md, v ] => {
               ;
               
               ;
               val aPiper
               = (f.dest ).startAttribNow(initialValue = f.initialValue )
               ;
               ({
                  ;

                  aPiper
                  .contramap((src: md ) => L.Val(f.distillMdl(src) ) )
               } )
               } }
            }
         } : Seq[L.Observer[XModel ] ]

         override
         def model_=(newMdl: XModel): Unit
         = {
            for (o <- srcToSetterDispatchers )
            do { o.onNext(newMdl ) }
         }

         // def

         ;

      }

      ({
         import aBackreferencings.{given Conversion[?, ?] }

         val f1
         = () => new XEAndStateBag1().wrappedLaminarElement

         summon[Conversion[f1.type, SpawnabilityAndReconciliabilityNoArg[XModel, ? <: ln.ReactiveHtmlElement[dom.HTMLElement] , ? ] ] ]
         .apply(f1 )
      })
   }

   case class SrcLensAndDestAttrPair[-XModel, V](impl : (
      SrcLensAndDestAttrPairRaw[XModel, V ]
   ) )
   {
      ;

      export impl.{_3 as dest }

      export impl.{_2 as initialValue }
      export impl._1.{apply as distillMdl }

      private[w3e]
      type ImplG
      = impl.type

      ;
   }

   /**
    * automatic conv from `Tuple3` to `SrcLensAndDestAttrPair[XModel, V]`
    * 
    */
   given asSrcLensAndDestAttrPair[XModel, V]
   : (
      Conversion[
         //
         SrcLensAndDestAttrPairRaw[XModel, V ]
         ,
         SrcLensAndDestAttrPair[XModel, ? ]
         ,
      ]
   )
   = {
      c => SrcLensAndDestAttrPair(c)
   }

   identity(() )
   identity(() )

   ;

   ;
} // given_SpawnabilityAndReconciliability_CaseClassGeneralised1.

;

/**
 * actually test the type-ing
 * 
 */
val _ = {
   ;

   import org.scalajs.dom

   locally {
      ;

      given_SpawnabilityAndReconciliability_CaseClassGeneralised1[
         Tuple3[Boolean, String, BigInt] ,
         dom.HTMLDivElement ,
      ] (
         //
         cf => cf(laminar.api.L.idAttr )((_ )._2, "(unknown)" )
         ,
         cf => cf(laminar.api.L.checked )((_ )._1, false )
         ,

      )(nativeElemLCtor = laminar.api.L.div )
   }

   locally {
      ;

      given_SpawnabilityAndReconciliability_CaseClassGeneralised1[
         Tuple3[Boolean, java.net.URI, BigInt] ,
         dom.HTMLAnchorElement ,
      ] (
         //
         cf => cf(laminar.api.L.href  )((_ )._2.toASCIIString().nn , "(unknown)" )
         ,
         cf => cf(laminar.api.L.hidden )((_ )._1, false )
         ,

      )(nativeElemLCtor = laminar.api.L.a )
   }

} // "actually test the type-ing"













val _ = {}
