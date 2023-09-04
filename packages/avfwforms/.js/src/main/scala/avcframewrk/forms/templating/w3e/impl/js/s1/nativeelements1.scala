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













val _ = {}
