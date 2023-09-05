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

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   given given_SpawnabilityAndReconciliability_Laspa[XModel <: Laspa]
   : SpawnabilityAndReconciliabilityNoArg[XModel, ?, Unit ]
   = {
      ;

      ;

      class XEAndStateBag1() extends
      aBackreferencings.XEAndStateBag(ec = { laminar.api.L.a })
      with aBackreferencings.XEAndStateBagCm[XModel, Unit]
      {
         //

         import laminar.api.L

         override
         def close(): Unit
         = {
            closeAllOf((
               Seq()
               :+ forHref
               :+ forEnabledness
            ))
         }

         val forHref
         = {
            (L.href).startAttribNow(initialValue = "" )
         }

         val forEnabledness
         = {
            (L.disabled).startAttribNow(initialValue = false )
            .contramap((v: AsyncStateChangeMonad[Boolean]) => v.map(_.unary_! ) )
         }

         override
         def model_=(newMdl: XModel): Unit
         = {
            forEnabledness.onNext((newMdl.enablednessAnim ) )
            forHref.onNext((newMdl.hrefStringAnim ) )
         }

         // def

         ;

      }

      ({
         import aBackreferencings.{given Conversion[?, ?] }

         summon[Conversion[() => XEAndStateBag1 , ? ] ]
         .apply(() => new XEAndStateBag1() )
      })
   }

   case class Laspa(
      //
      private val
      destOptionAnim : AsyncStateChangeMonad[Option[java.net.URI] ]
      ,
   )
   {
      ;

      def enablednessAnim
      = hrefOptionAnim.map(_.nonEmpty )

      def hrefOptionAnim
      : AsyncStateChangeMonad[Option[java.net.URI] ]
      = destOptionAnim

      def hrefStringOptionAnim
      = {
         hrefOptionAnim
         .map(o => o.map(_.toASCIIString().nn ) )
      }

      def hrefStringAnim
      = {
         hrefStringOptionAnim
         .map(o => o.getOrElse[String ]("") )
      }

      ;
   }

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
   : SpawnabilityAndReconciliabilityNoArg[XModel, ?, Unit ]
   = {
      ;

      class XEAndStateBag1() extends
      aBackreferencings.XEAndStateBag(ec = { laminar.api.L.a })
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

                  (f.apply(??? ) )
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

         summon[Conversion[() => XEAndStateBag1 , ? ] ]
         .apply(() => new XEAndStateBag1() )
      })
   }

   type SrcLensAndDestAttrPairRawFunc[-XModel]
   = SrcLensAndDestAttrPairRawFuncInvar[XModel @annotation.unchecked.uncheckedVariance ]
   type SrcLensAndDestAttrPairRawFuncInvar[XModel]
   = (
      (f: (
         [V] =>
         ((mdl: XModel) => V, V ) =>
         (targetedAttr: com.raquo.laminar.keys.HtmlAttr[V] | com.raquo.laminar.keys.HtmlProp[V, V] ) =>
            SrcLensAndDestAttrPair[XModel, V ] 
      ) ) =>
         SrcLensAndDestAttrPair[XModel, ? ] 
   )

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
         cf => cf((_ )._2, "(unknown)" )(laminar.api.L.idAttr )
         ,
         cf => cf((_ )._1, false )(laminar.api.L.checked )
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
         cf => cf((_ )._2.toASCIIString().nn , "(unknown)" )(laminar.api.L.href  )
         ,
         cf => cf((_ )._1, false )(laminar.api.L.hidden )
         ,

      )(nativeElemLCtor = laminar.api.L.a )
   }

} // "actually test the type-ing"













val _ = {}
