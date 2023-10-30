













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

@main
def runSMain(): Unit
= {
   ;

   println(s"hello!")
   ()

   locally {
      ;
      
      ;

      // s"$kCss"
      // .intern().nn

      locally({ })

      ({
         // (typings.react.mod. )
         mainAppMountRoot
         .render((
            xAppDemo
         ))
      })

      dom.global.console.log("[main] starting those little things...ePercentPercentE1 " )

      ({
         ;

         dom.global.console.log("[main] starting 'runLocalStorageDemoAsync' " )

         ( 
            runLocalStorageDemoAsync()
            // js.Promise.resolve({ dom.global.console.warn("[main] not a real impl of'runLocalStorageDemoAsync' " ) })
         )
         .`catch`({
               //

               case z : js.JavaScriptException =>
                  dom.global.console.warn(z.exception )
                  // throw new MspError(z)

               case util.control.NonFatal(z : Exception) =>
                  throw z
               case z =>
                  throw js.JavaScriptException(z)
         })
         .`then`(_ => {
            ;

            dom.global.console.log("[main] done done with 'runLocalStorageDemoAsync' " )
         })
      })



   }
}

val _ = {
   js.eval(s"File.prototype.toString = function () { return ${"`[object File (${this.name} (${this.type}, ${this.size}) - last modified at ${new Date(this.lastModified)} )]`"} } ;")
}

lazy val xAppDemo
: xRwAppDemo.type | xEmusAppDemo.type
= xEmusAppDemo

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

            def useSnapshot
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

               XData.useSnapshot()
            }

            val dataContents1 *: fileName *: EmptyTuple
            = {
               ;

               rce.useJsFuture(() => (
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
               ), "???" *: "(???)" *: EmptyTuple, (), { type ST >: s.type <: s.type ; implicit val p = { ??? ; rce.AvfwDependenciesArrayItemability.byIdentity[ST] } ; Nil :+ (s: ST) } )
            }

            val resetValue
            = {
               ;
               rce.useEventCallback((_: Unit) => {
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














