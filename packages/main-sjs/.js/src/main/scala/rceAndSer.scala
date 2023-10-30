













import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.{std as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageUsageUtil.FsWatch







;

object &&&& {
   ;

   ;

   def apply
      //
      [_M ]
      (using
         //
         serHandler : (AnyRef | js.Any) {
            //
            val tryParseFromString : String => Option[_M]
            val serialiseToString : _M => String
         } ,
      )
      (
         //
         defaultValue : _M ,
         debug: Boolean = false ,
      )
      (using ctsp : FsWatch.CtxtualSetterStyle._Any )
      (tryGetFilePath : () => js.Promise[typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default ] , tgfpDependencies : rce.AvfwDependenciesArray )
   = {
      ;

      import serHandler.tryParseFromString
      import serHandler.serialiseToString

      val (fContentsOption, c) *: cAlt *: EmptyTuple
      = {
         ;
         FsWatchInReact.useLeafNodePayloadOpt(() => {
            tryGetFilePath()
         } , tgfpDependencies )
      }

      if (debug) rce.useValueChangeLogging(fContentsOption, s"fContentsOption: $fContentsOption" )

      val fAsC
      = {
         rce.useJsFuture(() => async[JSFuture] {
            ;

            fContentsOption
            .flatMap(v => Option(v).map(_.nn ) )
            .map({
               case c => await(c.text() )
            })
            .flatMap(tryParseFromString(_) )
            .getOrElse({
               defaultValue
            })
         }, defaultValue, () , {
            implicit val p = rce.AvfwDependenciesArrayItemability.byIdentity
            Nil :+ fContentsOption
         })
      }

      if (debug) rce.useValueChangeLogging(fAsC, s"fAsC: $fAsC" )

      val updateTo
      = {
         c
         .compose((value: _M) => {
            dom.global.console.log("new value: ", s"$value" )
            FsWatchInReact.plainTxtBlob(serialiseToString(value ) )
         } )
      }

      (fAsC, updateTo).->(cAlt)
   }

   ;
}





















val _ = {}