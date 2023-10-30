













import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import cps.monads.jsfuture.JSFuture

import typings.{std as dom }

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

lazy val xAppDemo
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
                  await(storageProxy.main(using storageProxy.GFC.basicInstance ) )
               }
               val fileHandle = {
                  await(parentDirHandle.getFileHandle("otherIndexAlt.txt", {
                     typings.nativeFileSystemAdapter.anon.Create()
                     .setCreate(true )
                  } ) )
               }

               fileHandle
            }

            def useSnapshot
               //
               ()
            = {
               ;
               FsWatchInReact.useContentsFrom(() => tryGetFilePath() , Nil :+ "" )
            }

            ;
         }

         rce.ReactComponent1.describe((_: Any ) => {
            ;

            val (s, () ) = {
               XData.useSnapshot()
            }
            rce.describeElement("div", null, (
               Nil
               :+ rce.describeElement("p", null, "main app" )
               :+ rce.describeElement("p", null, s"value: ${s } " )
            ) : _* )
         })
      }
      rce.describeElement(_C , null )
   }
}

object FsWatchInReact {
   ;

   import com.raquo.airstream

   ;

   def useContentsFrom
      //
      (
         tryGetFilePath: () => js.Promise[typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default ] ,
         dependencies: rce.AvfwDependenciesArray ,
      )
   = {
      ;

      import com.raquo.airstream

      rce.useRaqueFrpState(() => {
         ;

         airstream.core.EventStream.fromJsPromise(async[JSFuture] {
            ;
            val fileHandle = {
               await(tryGetFilePath() )
            }
            FsWatch.startFsLeafFrp(fileHandle ) *: EmptyTuple
         } , true )

         .startWith({
            airstream.state.Val({
               FsWatch.SpecialObsOps.initially
            })
         } *: EmptyTuple )

         .flatMap(_._1 )

         .map(<:<.refl[(FsWatch.SpecialObsOps.initially.type | FsWatch.SpecialObsOps.ForFileFullObserv )] )
      } , (
         dependencies
      ) )
      .->(() )
   }

   ;
}














