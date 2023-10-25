package avcframewrk.forms

package templating

package reactjs

package renderfncs













import scalajs.js

import org.scalajs.dom

import dom.console

;

;

;

;

object EffectHook {
   ;

   ;

   enum _When {
      case Synchronously()
      case OnLayout()
      case Deferredly()
   }

   ;
}

/** 
 * 
 * a Hook `ReSubscriptiveHook` -
 * a "side-effecting subscription", and a fnc to close-or-reverse it
 * 
 */
object ReSubscriptiveHook
{
   ;

   ;

   type DisposeFnc
   = typings.react.mod.Destructor

   export typings.react.mod.{useSyncExternalStore as useSynchronouslyScan }

   // def useSynchronouslyScan
   //    [Snapshot]
   //    (subscribe: js.Function1[js.Function0[Unit], js.Function0[Unit]], getSnapshot: js.Function0[Snapshot]): Snapshot

   /** 
    * a Hook `ReSubscriptiveHook`
    * 
    * ```
    * useVoidly(Nil :+ srcUrl :+ userInfo :+ sessionToken , when = EffectHook._When.Deferredly() )(_ => {
    *    // MAKE SUBSCRIPTION
    *    val subscr = doSubscribe ... ...
    *    // RETURN THE 'java.io.Closeable'
    *    subscr
    * })
    * ```
    * 
    * `dependencies` is a-must here .
    * also,
    * `makeSubscription`'s return-value
    * needs to be a "subscriptional handle" which also `extends` `java.io.Closeable`
    * (since `Function0[Unit]` (JVM or JS) is unsemantic )
    * 
    * _note that, for `Synchronously` (hence, `useInsertionEffect`)_,
    * there are some restrictions imposed by React -
    * can't make any `setState` nor `reduce` call
    * 
    */
   implicit
   object uvImplicits {
      ;

      extension [
         //

         /**
          * hopefully, in SJS,
          * `close()` from `java.io.Closeable` erases directly to `close()` without any chg ...
          * we need it to be `?{ def close() }`, because
          * `Function0[Unit]` (JVM or JS) is unsemantic
          */
         SubscrHandleT <: java.io.Closeable
         ,

      ] (builder0: Efb._AsDoneByFunction1[Product, SubscrHandleT] )
         //

         def dependencies
         : AvfwDependenciesArray
         = builder0.dependencies

         def useReSubscriptiveEffectHook
            //
            [
               T1
               ,
            ]
            (
               //
               onEvtDispatchMdWhen: _When
               ,
            )
         : Unit
         = {
            ;

            // import builder0.dependencies

            val makeSubscription
            = builder0.evf

            case class XSubscriptiveRequestInfo()

            val makeSubscriptionAndGetDisposeFnc
            = {
               locally[js.Function0[DisposeFnc ] ] (() => {
                  ;

                  val subscrRequestEvtInf
                  = XSubscriptiveRequestInfo()

                  val subscription
                  = makeSubscription(subscrRequestEvtInf )

                  (subscription.close _ ) : js.Function0[Unit]
               })
            }

            onEvtDispatchMdWhen match
            case _When.Deferredly()      => typings.react.mod.useEffect         (makeSubscriptionAndGetDisposeFnc , dependencies.toNative() )
            case _When.OnLayout()        => typings.react.mod.useLayoutEffect   (makeSubscriptionAndGetDisposeFnc , dependencies.toNative() )
            case _When.Synchronously()   => typings.react.mod.useInsertionEffect(makeSubscriptionAndGetDisposeFnc , dependencies.toNative() )
         }

         def useReSubscriptiveHook
            //
            [
               T1
               ,
            ]
            (
               //
               onEvtDispatchMdWhen: _When
               ,
            )
         : SubscrHandleT | Null
         = {
            ;

            // import builder0.dependencies

            val (refd, updateRefd)
            = {
               RefStateHook.useInitiallyNull[SubscrHandleT]
            }
            
            // TODO
            Efb.doneByFnc1((evtInf : Product) => {
               ;
               val h
               = builder0.evf.apply(evtInf ) : SubscrHandleT
               updateRefd(h)
               h
            } : SubscrHandleT , (
               // TODO
               Nil
               :++ dependencies.toSeq
               :+ updateRefd
            ) )
            .useReSubscriptiveEffectHook(onEvtDispatchMdWhen = onEvtDispatchMdWhen )

            refd
         }

   }

   type _When
   >: EffectHook._When
   <: EffectHook._When
   final
   lazy val _When
   : EffectHook._When.type
   = EffectHook._When

   object _util {
      ;

      ;
   }

   ;
}

;

;

;

;













val _ = {}