package avcframewrk.forms.templating.ext.reactjsifyDemos









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

import avcframewrk.forms.templating.reactjs.{
   //
   toConvertSlinkyElemToStReactElem ,
   toConvertSlinkyElemFromStReactElem ,
   toForceBuildSlinkyElem ,
}

import avcframewrk.forms.templating.ext.reactjsify
import avcframewrk.forms.templating.ext.slinkify







@deprecated
object W3SR {
   ;
   export EOBS1.MStreamUi
   ;
}

object EOBS1 {
   ;

   ;

   ;

   object MStreamUi {
      ;

      ;

      def describeForNodeRec
         //
         ( )
      = {
         ndWhileRComp(((), MStreamUi ) )
         .build
      }

      lazy val ndWhileRComp
      = {
         ;

         val cEvs
         = {
            airstream.core.EventStream.periodic((1.5 * 1000 ).toInt )
            .startWith[Int] (0 )
            .observe(using airstream.ownership.ManualOwner() )
         }

         slinkify.publicly.ecl[(Unit, AnyRef )] ((
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

               val s = {
                  ;

                  reactjsify.eclFrontEnd.takeGsgv({
                     cEvs
                  })
               }

               val dateTimeStr = {
                  js.Date()
               }

               ;

               html.div(
                  //
                  html.p("src:", (
                     html.span(s"${inspector.toString() } " )
                  ) )
                  ,
                  html.p(s"state:", html.code(s.toString() ) )
                  ,
                  html.p(s"time:", html.i(dateTimeStr ) )
                  ,
               )
               .build
            } }
         ))
      }

      ;
   }

   ;
}


















