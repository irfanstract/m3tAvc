













import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.{std as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageUsageUtil.FsWatch






object FsWatchInReact {
   ;

   import com.raquo.airstream

   ;

   def plainTxtBlob
      //
      (c: String)
   : dom.global.Blob
   = {
      new (dom.global.Blob)(js.Array(c ) , (
         dom.BlobPropertyBag()
         .setType("text/plain")
      ) )
   }

   def useLeafNodePayloadOpt
      //
      (
         tryGetFilePath: () => js.Promise[typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default ] ,
         dependencies: rce.AvfwDependenciesArray ,
         un1: Unit = () ,
         shallLog : Boolean = false ,
      )
      (using ctsps: FsWatch.CtxtualSetterStyle._Any )
   = {
      ;

      val fdPre0 *: imperative *: EmptyTuple
      = useLeafComprehensive(tryGetFilePath = tryGetFilePath , dependencies = dependencies )

      val fdPre
      = fdPre0.value

      val fdContChgTo
      = rce.useEventCallback((fdPre0.chgTo _ ).andThen(e => e ) )

      if shallLog then rce.useValueChangeLogging(fdPre, s"fdPre: $fdPre" )

      val (fdContentsOption, imperative1)
      = {
         ;

         rce.MemoisingHook.useForValue(({
            fdPre match
            case FsWatch.SpecialObsOps.ForFileContents(c) =>
               Some(c)
            case _ =>
               None
         }, {
            fdContChgTo
            .compose(FsWatch.SpecialObsOps.ForFileContents.apply _ )
         }), (
            // TODO
            {
               implicit val p = {
                  rce.AvfwDependenciesArrayItemability.byIdentity[Any]
               }
               Nil :+ fdPre :+ fdContChgTo
            }
         ) )
      }

      if shallLog then rce.useValueChangeLogging(fdContentsOption, s"fdContentsOption: $fdContentsOption" )

      (fdContentsOption, imperative1) *: imperative *: EmptyTuple
   }

   def useLeafComprehensive
      //
      (
         tryGetFilePath: () => js.Promise[typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default ] ,
         dependencies: rce.AvfwDependenciesArray ,
      )
      (using ctsps: FsWatch.CtxtualSetterStyle._Any )
   = {
      ;

      rce.useRaqueFrpState(() => {
         ;

         airstream.core.Signal.fromJsPromise(async[JSFuture] {
            ;
            val fileHandle = {
               await(tryGetFilePath() )
            }
            FsWatch.startFsLeafFrp(fileHandle ) *: EmptyTuple
         } , {
            airstream.state.Val({
               ctsps.fromValueAndSetter({
                  FsWatch.SpecialObsOps.initially
               } , _ => {
                  throw new IllegalStateException
               } )
            })
         } *: EmptyTuple  )

         .debugLog(_.isSuccess)

         .flatMap(_._1 )
      } , (
         dependencies
      ) )
      .->(() )
   }

   ;
}















val _ = {}
