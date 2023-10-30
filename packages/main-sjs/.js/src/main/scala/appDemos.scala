













import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.{std as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageObj.watcher.ext.toStartSomeNodeFrp.FsWatch

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
         = avcframewrk.sMainModuleImplHelper.rceBasedUiTemplates.cxdByDomFsDirAndJsonIter

         val undoAndRedoOperator
         = {
            avcframewrk.forms.documentstatemgmt.UndoAndRedo.SpecialFpCcOps.gv.forPairOfConstLl
         }

         cxdi.apply
            (using undoAndRedoOperator )
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
            _PayloadedHistJsonSer = {
               cxdi.serScheme
                  //
                  [undoAndRedoOperator.OperatedMdlStateSetCc, (
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

               import sEtc.{pushEditTo as pushEditToMatchMVal}

               val pushEditToMatchAngVal
               = {
                  pushEditToMatchMVal
                  .compose((e: avcalculus.trig.Angular._Any ) => {
                     ;
                     avcalculus.musical.Key.byFromCKeyDeviation({
                        e
                     })
                  })
               }

               val pushArbitraryEdit
               = {
                  ;
                  reactHooks1.useEventCallback((_: Unit) => {
                     pushEditToMatchAngVal({
                        ;
                        avcalculus.trig.Angular.fromDegrees(180 * math.random() )
                     })
                  })
               }

               val value
               = s.presentlyState

               rce.describeElement("div", null, (
                  Nil

                  :+ rce.describeElement("div", null, (
                     Nil

                     :+ rce.describeElement("p", null, s"editor would go here" )

                     :+ rce.describeElement("p", null, s"value:", (
                        rce.describeElement("span", null, s"${value }", ({
                           import avcframewrk.forms.templating.ext.kslinkysliders
                           kslinkysliders.slinkyAngularSliderComponent.apply({
                              kslinkysliders.SascWithValueAndOnChange(
                                 value = value.fromKeyCDeviation ,
                                 onChange = evt => {
                                    pushEditToMatchAngVal(evt.value )
                                 } )
                           })
                           .build
                           .asStReactElement
                        }) )
                     ) )

                  )* )

                  :+ rce.describeElement("details", null, (
                     describeRedoAndUndoList(s)
                  ) )

                  :+ rce.describeElement("div", null, (
                     Nil
                     :+ rce.describeElement("button", (
                        rce.newHtmlButtonAttribs
                        .setOnClick(_ => pushArbitraryEdit(() ) )
                     ), s"make arbitrary edit" )
                  )* )

               )* )
            } ,

            //
            )
      }
      import c0.{_C, given }

      rce.describeElement(_C , null )
   }
}














val _ = {}
