













extension [E](r: E | Null )
   (using util.NotGiven[Null <:< E ] )
   def nn
   : (E & r.type )
   = js.Function("value", "value.__proto__ ; return value ;").asInstanceOf[js.Function1[r.type, E & r.type ] ].apply(r) 

import scalajs.js

import typings.{std as domItc }
import typings.std.{global as dom }

import cps.monads.jsfuture.{JSFuture, given }






class MspError(cause: js.JavaScriptException) extends
RuntimeException(cause)

lazy val mainAppMountRoot
= {
   ;
   typings.reactDom.clientMod.createRoot({
      dom.document.querySelector[dom.Element ]("#app")
      .nn
   } )
}

def runLocalStorageDemoAsync()
= (
   //

   (cps.async[JSFuture ] {
      ;
      {
         ;

         dom.console.log("[runLocalStorageDemoAsync] starting" )

         given backingCookiesStoreCtx
         : storageProxy.GFC._Any
         = {
            ;
            // storageProxy.GFC.basicInstance
            ({
               ;

               import cps.{async, await}

               async[JSFuture] { await( {
                  js.eval("Promise.resolve(navigator.storage.getDirectory() ).then(d => d.getDirectoryHandle(\"dir1\", { create: true , }) )")
                  .asInstanceOf[js.Promise[?] ]
               } ) }
               .asInstanceOf[storageProxy.GFC._Any ]
            })
         }

         cps.await(storageProxy.main )

         locally {}
         locally {}
         locally {}

         cps.await(storageProxy.tryWriteEmptyIndexFile() )

         ({
            ;

            val fileData = cps.await(storageProxy.tryReadEmptyIndexFile() )

            dom.console.log(fileData )
         })

         cps.await(storageProxy.tryWriteOver("otherIndex.txt")("other index file") )

         ({
            ;

            val fileData = cps.await(storageProxy.tryReadFile("otherIndex.txt") )

            dom.console.log(fileData )
         })

         dom.console.log("[runLocalStorageDemoAsync] done" )

         if true then {
            ;

            dom.console.log("[runLocalStorageDemoAsync] starting the watch loop" )

            val fHandle
            = (cps.await(summon[storageProxy.GFC._Any].tryGetHandle ) )

            implicit val sdfpGspStyle
            = avcframewrk.forms.domNavigatorObj.storageUsageUtil.FsWatch.CtxtualSetterStyle.defaultInstance[Nothing]

            avcframewrk.forms.domNavigatorObj.storageUsageUtil.FsWatch.startDirFrp({
               ;

               //
               fHandle
            })
            .foreach(e => {
               dom.console.log("updated dir state:", e.toString() )
            } )(using com.raquo.airstream.ownership.ManualOwner() )

            ()
         }
      }

   })
)

object storageProxy {
   ;

   import cps.{async, await}

   ;

   export avcframewrk.forms.domNavigatorObj.storageUsageUtil.gfso.closeAsync

   // def nsfd
   // = typings.nativeFileSystemAdapter
   import typings.{nativeFileSystemAdapter as nsfd}

   extension (parentDir : nsfd.typesSrcFileSystemDirectoryHandleMod.default )
      def tryGetFileHandle
         (name: String )
         (options: nsfd.anon.Create )
      = (cps.async[JSFuture] {
         ;

         ;

         val file1
         = cps.await(parentDir.getFileHandle(name, options ).nn )

         file1

         ;
      } )

   def main
      (using backingCookiesStoreCtx : GFC._Any )
   = summon[GFC._Any ].tryGetHandle

   // export avcframewrk.forms.domNavigatorObj.storageUsageUtil.gfso.GFC
   final lazy val GFC
   : avcframewrk.forms.domNavigatorObj.storageUsageUtil.gfso.GFC.type
   = avcframewrk.forms.domNavigatorObj.storageUsageUtil.gfso.GFC

   def tryWriteEmptyIndexFile
      //
      (using backingCookiesStoreCtx : GFC._Any )
      ()
   = (cps.async[JSFuture ] {
      ;

      dom.console.log("[tryWriteEmptyIndexFile] writing " )

      val fl
      = cps.await(tryWriteOver("index.txt")("Try Write Empty Index File") )

      dom.console.log("[tryWriteEmptyIndexFile] done " )

      fl
   })

   export avcframewrk.forms.domNavigatorObj.storageUsageUtil.gfso.tryWriteOver

   def tryReadEmptyIndexFile
      //
      (using backingCookiesStoreCtx : GFC._Any )
      ()
   = (cps.async[JSFuture ] {
      ;

      cps.await(tryReadFile("index.txt" ) )
   })

   export avcframewrk.forms.domNavigatorObj.storageUsageUtil.gfso.tryReadFile

   locally {}

   locally {}

   ;
}















