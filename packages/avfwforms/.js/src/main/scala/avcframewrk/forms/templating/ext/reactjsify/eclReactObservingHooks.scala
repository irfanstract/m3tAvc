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

   import eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.DependenciesArray

   import eclReactHookingProtocolTopLevel.runSpecialWithBareMinimumProtocol

   import eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.{*, given }

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
          * **do not** call `.killSubscriptions()`.
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

      def allocate
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
            = ahsm.killSubscriptions()

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
      = _Impl[Any]

      implicit
      def ops
         //
         (receiver: _Any)
      : _ROps[receiver.type ]
      = _ROps[receiver.type ](receiver )

      protected
      opaque type _Impl[+T0 ]
      <: %%%*
      =  %%%*

      protected
      case class _ROps[+Receiver <: _Any ](receiver: Receiver )
      {
         ;

         val valueOf = [T] => (_ : DummyImplicit ) ?=> (receiver.persistingPeer.valueOf[T] _ )

         export receiver.{scheduleRedraw as scheduleRefresh}

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

      trait %%%*
      {
         ;

         val persistingPeer
         : PersistingPeer._Any

         def scheduleRedraw
            //
            (fnc: => (
               /* here's `Unit` corresponds to `js`' `void` */
               js.Promise[Unit]
            ) )
         : Unit

         ;
      }

      // TODO
      def implementedBy
         //
         (impl: %%%* )
      : _Any
      = {
         ;
         impl
      }

      def apply1
         //
         (
            //
            persistingPeer
            : PersistingPeer._Any
            ,
            processDeferredRedrawSchedule
            : js.Promise[Unit] => Unit
            ,
         )
      = {
         ;

         implementedBy({
            ;

            /** for those which entity-tracking is mandatory */
            val c
            = (persistingPeer, () ) : (persistingPeer.type, Unit )

            new %%%* with Selectable {
               ;

               export c.{_1 as persistingPeer}

               def scheduleRedraw
                  //
                  (fnc: => (
                     /* here's `Unit` corresponds to `js`' `void` */
                     js.Promise[Unit]
                  ) )
               = processDeferredRedrawSchedule(fnc )

               ;
            }
         })
      }

      ;

      object app {
         ;

         // TODO
         /* TODO switch to clause-interweaved sig */
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

   ;

   // def takeGsgv
   export EOBSM.app.{valueOf as takeGsgv }

   ;

   ;

}


















val _ = {}
