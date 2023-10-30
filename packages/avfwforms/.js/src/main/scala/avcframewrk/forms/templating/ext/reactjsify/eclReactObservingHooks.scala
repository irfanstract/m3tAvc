// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*





import scalajs.js

import com.raquo.airstream



import typings.{std as domItc }
import typings.std.{global as dom }
import typings.std.{global as window }



;

object eclReactObservingHooksImpl {
   ;

   import eclReactHookingProtocolTopLevel.ByRQueryAndDependenciesArrayThenDoAndReturnR

   import eclReactHooking.DependenciesArray

   import eclReactHookingProtocolTopLevel.runSpecialWithBareMinimumProtocol

   import eclReactHooking.{*, given }

   import eclReactHookGsr.{*, given }

   ;

   ;

   protected
   object EOBSMPP
   {
      ;

      ;

      type _Any
      = _Impl[?]

      implicit
      def ops
         //
         (receiver: _Any)
      : _ROps[receiver.type ]
      = _ROps[receiver.type ](receiver )

      protected
      trait _Impl[T0 ] {
         ;

         /** 
          * essential for ad-hoc `.observe`s.
          * 
          * __do not__ call `.killSubscriptions()`.
          * 
          * for implementers --
          * 
          * `airstream.ownership.Owner`
          * 
          */
         val adHocSubscriptionalManager
         : airstream.ownership.Owner

         ;
      }

      protected
      case class _ROps[+Receiver <: _Any ](receiver: Receiver )
      {
         ;

         export receiver.adHocSubscriptionalManager

         def valueOf
            //
            [T]
            (s: airstream.core.Signal[T] )
         : T
         = {
            ;
            // TODO
            s
            .observe(using adHocSubscriptionalManager )
            .now()
         }

      }

      def newInstance
         //
         ()
      = {
         ;
         new _Impl["Any"]
         with java.io.Closeable
         {
            ;

            val ahsm
            = new airstream.ownership.ManualOwner()

            override
            def close(): Unit
            = adHocSubscriptionalManager

            val adHocSubscriptionalManager
            = ahsm

         }
      }

      ;
   }

   object EOBSM
   {
      ;

      final
      lazy val PersistingPeer
      : EOBSMPP.type
      = EOBSMPP

      type _Any
      = _Impl[?]

      implicit
      def ops
         //
         (receiver: _Any)
      : _ROps[receiver.type ]
      = _ROps[receiver.type ](receiver )

      protected
      trait _Impl[T0 ] {
         ;

         val persistingPeer
         : PersistingPeer._Any

         @deprecated
         def scheduleRefresh
            //
            (fnc: => (
               /* here's `Unit` corresponds to `js`' `void` */
               js.Promise[Unit]
            ) )
         : Unit

         ;
      }

      protected
      case class _ROps[+Receiver <: _Any ](receiver: Receiver )
      {
         ;

         val valueOf = [T] => (_ : DummyImplicit ) ?=> (receiver.persistingPeer.valueOf[T] _ )

         export receiver.scheduleRefresh

         def scheduleRefreshByCb
            //
            (fnc: (
               ([ResolverSynchronousR] =>> ((complete: () => ResolverSynchronousR ) => ResolverSynchronousR ) )
               [Unit ]
            ) )
         : Unit
         = {
            ;
            scheduleRefresh({
               js.Promise[Unit]((resolve, _) => scheduleRefreshByCb(c => {
                  resolve(() )
               } ) )
            })
         }

         ;
      }

      trait %%%* extends
      _Impl[Nothing]

      // TODO
      def implementedBy
         //
         (impl: %%%* )
      : _Any
      = {
         ;
         impl
      }

      ;

      object app {
         ;

         /* TODO RESOURCE LEAKING CAVEAT */
         /* TODO switch to clause-interweaved sig */
         @deprecated
         def valueOf
            [S]
            (using EOBSM._Any )
            (src: airstream.core.Signal[S] )
         : S
         = {
            // TODO
            summon[EOBSM._Any ].valueOf(src )
         }

         def newJsTimeout
            //
            (duration: concurrent.duration.FiniteDuration )
         : js.Promise[Unit]
         = {
            newJsVoidCallbackPromise(cont => js.timers.setTimeout(duration )(cont() ) )
         }

         def newJsVoidCallbackPromise
            //
            (doResolve: (
               ([ResolverSynchronousR] =>> ((complete: () => ResolverSynchronousR ) => ResolverSynchronousR ) )
               [Unit ]
            ) )
         = js.Promise[Unit] ((cb, _) => doResolve(complete = () => cb(() ) ) )

      }

      ;
   }

   // /** `GetSignalValue` */
   // object GsgHookSummonable {
   //    ;

   //    opaque type _ForR[R]
   //    <: ByRQueryAndDependenciesArrayThenDoAndReturnR[R]
   //    =  ByRQueryAndDependenciesArrayThenDoAndReturnR[R]

   //    inline given [R]
   //    : _ForR[R]
   //    = ${gsgHookLambda[R] }

   // }

   // def gsgHookLambda
   //    //
   //    [R : Type]
   //    (using Quotes)
   // //
   // = {
   //    ;
   //    import quotes.reflect.*

   //    '{
   //       ;

   //       "by gsgHookLambda"

   //       locally((_eop : EOBSM._Any) ?=> {
   //          ;

   //          locally[ByRQueryAndDependenciesArrayThenDoAndReturnR[R] ] {
   //             ;

   //             (value, dependencies) =>
   //                ???
   //          }
   //       })(using compiletime.summonInline )
   //    }
   // }

   ;

}


















val _ = {}
