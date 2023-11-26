package avcframewrk.mediaStudioForms.ext









import avcalg.plsAndTlsAsImplicit.given_plsAndTls

import reflect.Selectable.reflectiveSelectable

import concurrent.duration.*

import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import cps.monads.jsfuture.JSFuture

import com.raquo.airstream

import avcframewrk.forms.templating.ext.airstreamify

import typings.{std as domItc }
import typings.std.{global as dom }


import avcframewrk.sMainModuleImplHelper.rce

export avcframewrk.forms.templating.reactjs.{
   //
   toConvertSlinkyElemToStReactElem ,
   toConvertSlinkyElemFromStReactElem ,
   toForceBuildSlinkyElem ,
}

import avcframewrk.forms.templating.ext.reactjsify
import avcframewrk.forms.templating.ext.slinkify







object W3SR {
   ;

   ;

   ;

   object MStreamUi {
      ;

      ;

      def describeForNodeCanRec
         //
         (src: domItc.MediaStream )
      = {
         ndCanRComp((), src )
         .build
      }

      lazy val ndCanRComp
      = {
         ;
         slinky.core.FunctionalComponent[(Unit, domItc.MediaStream )] { case (_ *: srcObj *: _ ) => {
            ;
            import slinky.core.facade.Hooks
            import slinky.web.html
            ;
            ;
            html.div(
               //
               html.p("src:", (
                  html.span(s"${srcObj.toLocaleString() } " )
               ) )
               ,
               html.p(s"you can start recording.")
               ,
            )
         } }
      }

      // def describeForNodeRec
      //    //
      //    (src: SrEdRestInspect )
      // = {
      //    ndWhileRComp((), src )
      //    .build
      // }

      lazy val ndWhileRComp
      = {
         ;

         slinkify.publicly.ecl[(Unit, SrEdRestInspect )] ((
            //

            { props => {
               ;
               // val (value3 *: inspector *: _ ) = props
               val inspector = props._2

               import slinky.core.facade.Hooks
               import slinky.web.html

               ;

               val sysTimeMillis
               = System.currentTimeMillis()

               val rStat
               = {
                  ;
                  val isAlive = {
                     ;

                     // airstreamify.ByGetFromO.stubs.pick({
                     //    inspector.alivenessAnim
                     // })
                     // reactjsify.eclFrontEnd.takeGsgv({
                     //    inspector.alivenessAnim
                     // })
                     // compiletime.summonInline[(
                     //    reactjsify.eclReactObservingHooksImpl.EOBSM._Any
                     // )]
                     // false
                     reactjsify.eclFrontEnd.takeGsgv({
                        inspector.alivenessAnim
                     })
                  }
                  (isAlive, () )
               }

               ;

               html.div(
                  //
                  html.p("src:", (
                     html.span(s"${inspector.toString() } " )
                  ) )
                  ,
                  html.p(s"you started recording.")
                  ,
               )
               .build
            } }
         ))
      }

      ;
   }

   /** 
    * start a recording, from given src, activity.
    * 
    */
   def startRecFrom
      //
      (
         src: domItc.MediaStream ,
         backupFilePath: domItc.FileSystemFileHandle ,
      )
   = {
      ;

      /* see also https://github.com/lampepfl/dotty/pull/18958 */
      new SrStarts(src = src , backupFilePath = backupFilePath )
         with SrEdRestInspect
   }

   /* see also https://github.com/lampepfl/dotty/pull/18958 */
   private[avcframewrk]
   class SrStarts
      (
         val src: domItc.MediaStream ,
         val backupFilePath: domItc.FileSystemFileHandle ,
      )
   extends
   AnyRef
   with java.io.Closeable
   {
      ;

      final val peer = {
         given avcframewrk.w3mediastreams.internal.eisr.type
         = avcframewrk.w3mediastreams.internal.eisr

         given avcframewrk.w3mediastreams.internal.eisr.ByConstructedMediaStreamRcCtx.simplePreferredBlobLikeEvtReducer.type
         = avcframewrk.w3mediastreams.internal.eisr.ByConstructedMediaStreamRcCtx.simplePreferredBlobLikeEvtReducer

         src.startRecording()
      }

      override
      def close(): Unit
      = {
         util.Using.resource(peer )({ case _ => })
      }

   }

   trait SrEdRestInspect
      // [+Proc <: Singleton ](protected val impl: Proc )
   extends
   SrStarts
   { this : SrStarts =>
      ;

      // export impl.*

      ;

      override
      def toString(): String
      = {
         s"W3SR_SrEdRestInspect : ${peer } "
      }

      export peer.addEventListenerOnPeer
      export peer.termStateAnim
      export peer.fullLengthBlobAnim

      final
      lazy val alivenessAnim
      = {
         ;
         termStateAnim
         .map(_.unary_! )
      }

   }

   enum SrTriState {
      ;
      case Running()
      case Suspended()
      case Terminated()
   }

   new (() => (String, Any ) ) {
      override
      final
      def apply()
      = ??? : ("", Int )
   }

   ;
}


















