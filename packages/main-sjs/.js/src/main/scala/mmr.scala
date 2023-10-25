













import scalajs.js

import typings.{std as dom }

import cps.monads.jsfuture.{JSFuture, given }






class MspError(cause: js.JavaScriptException) extends
RuntimeException(cause)

lazy val mainAppMountRoot
= {
   ;
   typings.reactDom.clientMod.createRoot({
      dom.global.document.querySelector[dom.Element ]("#app")
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

         dom.global.console.log("[runLocalStorageDemoAsync] starting" )
         cps.await(storageProxy.main )
         locally {}
         locally {}
         locally {}
         cps.await(storageProxy.tryWriteEmptyIndexFile() )
         val fileData = cps.await(storageProxy.tryReadEmptyIndexFile() )
         dom.global.console.log(fileData )
         dom.global.console.log("[runLocalStorageDemoAsync] done" )
      }

   })
)

object storageProxy {
   ;

   // def nsfd
   // = typings.nativeFileSystemAdapter
   import typings.{nativeFileSystemAdapter as nsfd}
   // object nsfd {
   //    object mod {
   //       def getOriginPrivateDirectory() = dom.global.navigator.storage.asInstanceOf[js.Any { def getDirectory() : dom.FileSystemDirectoryHandle }]
   //    }
   // }

   def tryGetDir()
   = nsfd.mod.getOriginPrivateDirectory()

   extension [E](r: E | Null )
      (using util.NotGiven[Null <:< E ] )
      def nn
      : (E & r.type )
      = js.Function("value", "value.__proto__ ; return value ;").asInstanceOf[js.Function1[r.type, E & r.type ] ].apply(r) 

   // (asynchrer : cps.CpsMonad[js.Promise ] ) ?=>
   val main
   = (cps.async[JSFuture ] {
      ;
      val h
      = cps.await(tryGetDir().nn )
      h
   })

   def tryWriteEmptyIndexFile()
   = (cps.async[JSFuture ] {
      ;
      val dir
      = cps.await(main.nn )
      val file1
      = cps.await(dir.getFileHandle("index.txt", nsfd.anon.Create().setCreate(true ) ).nn )
      val fileWriter
      = cps.await(file1.createWritable().nn )
      cps.await(fileWriter.write({
         // new dom.global.Blob(js.Array( ) , dom.BlobPropertyBag().setType("text/plain") )
         "tryWriteEmptyIndexFile"
      } ) )
      cps.await((js.Promise.resolve(fileWriter.asInstanceOf[js.Any { def close(): js.UndefOr[js.Promise[Any] ] } ].close() ) ).nn )
      file1
   })

   def tryReadEmptyIndexFile()
   = (cps.async[JSFuture ] {
      ;
      val dir
      = cps.await(main )
      val file1 = cps.await(dir.getFileHandle("index.txt", nsfd.anon.Create().setCreate(false ) ) )
      val fileData = cps.await(file1.getFile() )
      fileData
   })

   locally {}

   locally {}

   ;
}















