













import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.{std as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageObj.watcher.ext.toStartSomeNodeFrp.FsWatch

final
lazy val xRwAppDemo
= {
   ;

   {
      val _C = {
         ;

         object XData {
            ;

            def tryGetFilePath
               //
               ()
            = async[JSFuture] {
               ;

               val parentDirHandle = {
                  val f0 = await(storageProxy.main(using storageProxy.GFC.basicInstance ) )
                  val f1 = await(f0.getDirectoryHandle("dir1", typings.nativeFileSystemAdapter.anon.Create().setCreate(true ) ) )
                  f1
               }
               val fileHandle = {
                  await(parentDirHandle.getFileHandle("otherIndex.txt", {
                     typings.nativeFileSystemAdapter.anon.Create()
                     .setCreate(true )
                  } ) )
               }

               fileHandle
            }

            def useUpstreamSnapshot
               //
               ()
               (using FsWatch.CtxtualSetterStyle._Any )
            = {
               ;
               FsWatchInReact.useLeafComprehensive(() => {
                  tryGetFilePath()
               } , Nil :+ "" )
            }

            ;
         }

         rce.ReactComponent1.describe((_: Any ) => {
            ;

            val ((s, updateSTo ), () )
            = {
               ;

               implicit
               val gsp
               = FsWatch.CtxtualSetterStyle.valueAndSetterInstance

               XData.useUpstreamSnapshot()
            }

            val dataContents1 *: fileName *: EmptyTuple
            = {
               ;

               reactHooks1.useJsFuture(() => (
                  //
                  async[JSFuture] {
                     s match {
                     //
                     case FsWatch.SpecialObsOps.ForFileContents(dataBlob : dom.global.Blob ) =>
                        ;
                        ;
                        val dataStr = await(dataBlob.text() )
                        s"[txt: '$dataStr' ; ]" *: s"${dataBlob.asInstanceOf[dom.global.File].name }" *: EmptyTuple
                     case _ =>
                        "(loading)" *: "(???)" *: EmptyTuple
                     }
                  }
               ), "???" *: "(???)" *: EmptyTuple, (), { type ST >: s.type <: s.type ; implicit val p = { ??? ; reactHooks1.AvfwDependenciesArrayItemability.byIdentity[ST] } ; Nil :+ (s: ST) } )
            }

            val resetValue
            = {
               ;
               reactHooks1.useEventCallback((_: Unit) => {
                  updateSTo({
                     FsWatch.SpecialObsOps.ForFileContents({
                        FsWatchInReact.plainTxtBlob("cleared on user-request")
                     })
                  })
               })
            }

            rce.describeElement("div", null, (
               Nil
               :+ rce.describeElement("p", null, "main app" )
               :+ rce.describeElement("p", null, s"value: ${dataContents1 }, fName: ${fileName } " )
               :+ rce.describeElement("button", rce.newHtmlButtonAttribs.setOnClick(_ => resetValue(() ) ) , "clear" )
            ) : _* )
         })
      }
      rce.describeElement(_C , null )
   }
}

def describeRedoAndUndoList
   //
   (using ctx: avcframewrk.forms.documentstatemgmt.UndoAndRedo.SpecialFpCcOps._FiniteModeInstance )
   (s: ctx.OperatedMdlStateSetCc[Any] )
= (
   //
   rce.describeElement("div", null, (
      Nil
      :+ rce.describeElement("p", null, s"editor state: " )
      :+ rce.describeElement("p", null, s"presently: " )
      :+ rce.describeElement("p", null, s"${s.presentlyState } " )
      :+ rce.describeElement("p", null, s"redo: " )
      :+ (
         rce.describeMappedItmListByKv((
            s.successiveStateHist
            .zipWithIndex.map(_.swap)
            .tapEach(<:<.refl)
         )) (value => {
            rce.describeElement("p", null, s"${value }" )
         })
      )
      :+ rce.describeElement("p", null, s"undo: " )
      :+ (
         rce.describeMappedItmListByKv((
            s.precedingStateHist
            .zipWithIndex.map(_.swap)
            .tapEach(<:<.refl)
         )) (value => {
            rce.describeElement("p", null, s"${value }" )
         })
      )
   ) : _* )
)



















val _ = {}
