package avcframewrk.beepSoundForms.examples










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







;

final
lazy val e1
= {
   ;

   object spclHooks {
      ;

      import slinky.core.facade.Hooks
      import slinky.web.html

      ;

      def takeBeepEngineHook
         //
         ()
      = {
         Hooks.useMemo(() => {
            val c = new dom.AudioContext()

            new Selectable {
               ;

               def startCtx()
               : Unit
               = { c.resume() }

               def beep()
               : Unit
               = {
                  ;

                  startCtx()

                  val g1 = c.createGain()

                  val o1 = c.createOscillator()

                  g1.connect(c.destination )
                  o1.connect(g1)

                  g1.gain.value = math.pow(2, -3 )

                  o1.frequency.value = 440

                  o1.start()

                  js.timers.setTimeout(2 * 1000 ) {
                     o1.stop()
                  }
               }

               //
            }
         } , Nil )
      }

      ;
   }

   val _C = {
      slinkify.publicly.ecl[(Unit, Unit)] (props => {
         ;

         import slinky.core.facade.Hooks
         import slinky.web.html

         ;

         val ctx
         = {
            reactjsify.eclFrontEnd.eclAsm({
               spclHooks.takeBeepEngineHook()
            })
         }

         html.div((
            Nil
            :+ html.p("you can", "choose to", (
               html.button(html.`type` := "button" , "beep now" , html.onClick := (() => { ctx.beep() })) 
            ))
         )* )
         .build
      })
   }

   _C(((), () ) )
   .build
}





















