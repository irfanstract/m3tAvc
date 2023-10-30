













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
                  await(parentDirHandle.getFileHandle("emus.txt", {
                     typings.nativeFileSystemAdapter.anon.Create()
                     .setCreate(true )
                  } ) )
               }

               fileHandle
            }

            def useSnapshot
               //
               (un1: Unit = (), debug : Boolean = false )
               (using FsWatch.CtxtualSetterStyle._Any )
            = {
               ;

               val (fContentsOption, c) *: cAlt *: EmptyTuple
               = {
                  ;
                  FsWatchInReact.useLeafNodePayloadOpt(() => {
                     tryGetFilePath()
                  } , Nil :+ "" )
               }

               if (debug) rce.useValueChangeLogging(fContentsOption, s"fContentsOption: $fContentsOption" )

               val fAsCOptAsync
               = {
                  rce.MemoisingHook.useForValue(async[JSFuture] {
                     ;

                     fContentsOption
                     .flatMap(v => Option(v) )
                     .map({
                        case c => await(c.nn.text() )
                        case null => ""
                     })
                     .flatMap(value => _Json.unapply(value) )
                  } , {
                     implicit val p = rce.AvfwDependenciesArrayItemability.byIdentity
                     Nil :+ fContentsOption
                  })
               }

               if (debug) rce.useValueChangeLogging(fAsCOptAsync, s"fAsCOptAsync: $fAsCOptAsync" )

               val fAsC
               = {
                  rce.useJsFuture(() => {
                     if (debug) dom.global.console.log(s"rce.useJsFuture(() => fAsCOptAsync ) ; ")
                     fAsCOptAsync
                  } , None, () , {
                     ;
                     implicit val p = rce.AvfwDependenciesArrayItemability.byIdentity
                     Nil :+ fAsCOptAsync
                  } )
                  .getOrElse({
                     avcalculus.musical.Key.byFromCKeyDeviation({
                        avcalculus.musical.InTwelvethKey.D.fromKeyCDeviation
                     })
                  })
               }

               rce.useValueChangeLogging(fAsC, s"fAsC: $fAsC" )

               (fAsC, {
                  c.compose((value: _Json._M) => {
                     dom.global.console.log("new value: ", s"$value" )
                     FsWatchInReact.plainTxtBlob(jsoniter_scala.core.writeToStringReentrant(value ) )
                  } )
               }).->(cAlt)
            }

            object _Json {
               ;

               type _M
               >: avcalculus.musical.Key._Any
               <: avcalculus.musical.Key._Any

               def unapply
                  (v: String)
               = {
                  ;
                  (util.Try(Some {
                     jsoniter_scala.core.readFromStringReentrant[_M](v )
                  }))
                  .recover({
                     case z : jsoniter_scala.core.JsonReaderException =>
                        None
                  })
                  .get
               }

               dom.global.console.log("emus test", s"${
                  jsoniter_scala.core.readFromStringReentrant[_M] ("{\"fromKeyCDeviation\":{\"valueInDegrees\":165.22973151443315}}")
               }")

               def apply
                  (v: _M)
               = jsoniter_scala.core.writeToStringReentrant(v)
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

            val resetValue
            = {
               ;
               rce.useEventCallback((_: Unit) => {
                  updateSTo({
                     ;
                     avcalculus.musical.Key.byFromCKeyDeviation({
                        avcalculus.trig.Angular.fromDegrees(scala.math.random() * 180 )
                     })
                  })
               })
            }

            rce.describeElement("div", null, (
               Nil
               :+ rce.describeElement("p", null, "main app" )
               :+ rce.describeElement("p", null, s"value: ${s } " )
               :+ rce.describeElement("button", rce.newHtmlButtonAttribs.setOnClick(_ => resetValue(() ) ) , "clear" )
            ) : _* )
         })
      }
      rce.describeElement(_C , null )
   }
}














