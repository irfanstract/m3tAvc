













import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.{std as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageUsageUtil.FsWatch

// @js.native
// @JSImport("./kcss.css", JSImport.Namespace )
// val kCss: Any = js.native

final
lazy val xEmusAppDemo
= {
   ;

   {
      ;
      val c0
      = {
         ;

         val cxdi
         = avcframewrk.forms.sMain.d1.rceBasedUiTemplates.cxdByDomFsDirAndJsonIter

         cxdi.apply
            (using avcframewrk.forms.documentstatemgmt.UndoAndRedo.SpecialFpCcOps.gv.forPairOfConstLl )
            (
            //

            tryGetFilePathImpl = () => async[JSFuture] {
               ;

               val parentDirHandle = {
                  val f0 = await(storageProxy.main(using storageProxy.GFC.basicInstance ) )
                  val f1 = await(f0.getDirectoryHandle("dir1", typings.nativeFileSystemAdapter.anon.Create().setCreate(true ) ) )
                  f1
               }
               val fileHandle = {
                  await(parentDirHandle.getFileHandle("emus1.txt", {
                     typings.nativeFileSystemAdapter.anon.Create()
                     .setCreate(true )
                  } ) )
               }

               fileHandle
            } ,
            _Json = {
               cxdi.serScheme
                  //
                  [avcframewrk.forms.documentstatemgmt.UndoAndRedo.SpecialFpCcOps.gv.forPairOfConstLl.OperatedMdlStateSetCc, (
                     avcalculus.musical.Key._Any
                  ) ]
                  ()
            } ,

            initialMdlValue = {
               ;
               avcalculus.musical.Key.byFromCKeyDeviation({
                  avcalculus.musical.InTwelvethKey.D.fromKeyCDeviation
               })
            } ,

            mainEditingUi = (_, s, sEtc) => {
               ;

               import sEtc.pushEditTo

               val pushArbitraryEdit
               = {
                  ;
                  rce.useEventCallback((_: Unit) => {
                     pushEditTo({
                        ;
                        avcalculus.musical.Key.byFromCKeyDeviation({
                           avcalculus.trig.Angular.fromDegrees(180 * math.random() )
                        })
                     })
                  })
               }

               rce.describeElement("div", null, (
                  Nil
                  :+ rce.describeElement("div", null, (
                     Nil
                     :+ rce.describeElement("p", null, s"editor would go here" )
                     :+ rce.describeElement("p", null, s"value: ${s.presentlyState } " )
                  ) : _* )
                  :+ rce.describeElement("details", null, (
                     describeRedoAndUndoList(s)
                  ) )
                  :+ rce.describeElement("div", null, (
                     Nil
                     :+ rce.describeElement("button", (
                        rce.newHtmlButtonAttribs
                        .setOnClick(_ => pushArbitraryEdit(() ) )
                     ), s"make arbitrary edit" )
                  ) : _* )
               ) : _* )
            } ,

            //
            )
      }
      import c0.{_C, given }

      rce.describeElement(_C , null )
   }
}














val _ = {}