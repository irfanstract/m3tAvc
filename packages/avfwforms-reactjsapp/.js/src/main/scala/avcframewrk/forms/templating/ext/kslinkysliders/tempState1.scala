package avcframewrk.forms

package templating.ext.kslinkysliders












import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.std.{global as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageUsageUtil.FsWatch






;

def useTempState
   //
   [Value ]
   (upstreamValue: => Value )
= {
   ;

   object allOps {
      ;

      val (tempStateOpt, setTempStateOption )
      = useTsh[Value] ()

      val setTempState
         //
      = {
         // TODO useMemo
         slinky.core.facade.Hooks.useMemo(() => {
            ;
            new Selectable {
               ;

               def apply(value: Value )
               = setTempStateOption.apply(Some(value) )

               def apply(digest: Option[Value] => Value )
               = setTempStateOption.apply(s0 => Some(digest(s0 ) ) )

            }
         } , Nil :+ setTempStateOption )
      }

      val effectiveState
      = tempStateOpt.getOrElse[Value] (upstreamValue )

   }
   /* don't wait until it gets called from a Hook callback */
   allOps

   val ops
   = {
      ;
      slinky.core.facade.Hooks.useMemo(() => {
         ;
         new Selectable {

            // export allOps.{setTempStateOption }
            val setTempStateOption = allOps.setTempStateOption : ESetStateHookCallback[Option[Value] ]

            export allOps.{setTempState }

         }
      } , Nil )
   }
   
   (allOps.effectiveState, ops, ops : AnyRef, new Selectable { export allOps.tempStateOpt } )
}

/** 
 * work-around for broken passing/propagation of `AnyVal`s when `Selectable` --
 * avoid passing `SetStateHookCallback` (an `AnyVal` subtype),
 * 
 */
case class ESetStateHookCallback[Value]
   (impl: slinky.core.facade.SetStateHookCallback[Value] )
{
   export impl.apply
}
object ESetStateHookCallback {
   ;

   implicit
   def autoBoxingConv[Value]
   : Conversion[slinky.core.facade.SetStateHookCallback[Value], ESetStateHookCallback[Value] ]
   = (apply[Value] _)

}

implicit class UtsProjectiveOps[Value](f1: slinky.core.facade.SetStateHookCallback[Value] ) {
   ;

   def contramap
      [V2](Some: V2 => Value )
   = {
      ;
      new ProjectionImpl(Some )
   }

   class ProjectionImpl
      [V2](Some: V2 => Value )
   {
      ;

      def apply(value: V2 )
      = f1(Some(value) )

      def apply(digest: Value => V2 )
      = f1(s0 => Some(digest(s0 ) ) )

   }
}

/** 
 * `Option[Value]`
 * 
 */
def useTsh
   //
   [Value ]
   ( )
= {
   ;
   slinky.core.facade.Hooks.useState[Option[Value] ] (() => None )
}















