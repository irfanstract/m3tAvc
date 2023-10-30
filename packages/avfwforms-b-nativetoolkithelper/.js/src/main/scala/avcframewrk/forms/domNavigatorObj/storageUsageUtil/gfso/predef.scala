package avcframewrk.forms

package domNavigatorObj.storageUsageUtil

package gfso













import cps.{async, await }

import scalajs.js

import typings.{std as domItc }
import typings.std.{global as dom }

import cps.monads.jsfuture.{JSFuture, given }

import com.raquo.airstream

/* can't `export` `package`s `:(` */
import typings.{nativeFileSystemAdapter as nsfd}






extension [E](r: E | Null )
   (using util.NotGiven[Null <:< E ] )
   def nn
   : (E & r.type )
   = js.Function("value", "value.__proto__ ; return value ;").asInstanceOf[js.Function1[r.type, E & r.type ] ].apply(r) 






;

extension (receiver : domItc.ReadableStream[?] | domItc.WritableStream[?] )
   /* TODO generalise this to `BaseAudioContext`s as well */
   /* TODO generalise this to `EventSource`s as well */
   def closeAsync()
   = async[JSFuture] {
      ;

      await(({
         ;
         js.eval("async (writer) => (await (writer.close() || Promise.resolve() ) ) ")
         .asInstanceOf[js.Function1[receiver.type, js.Promise[?] ] ]
         .apply(receiver )
      }) )

      ()
   }

object GFC
{
   ;

   ;

   type _Any = _Impl

   ;

   protected
   opaque type _Impl
   <: AnyRef | js.Any
   = JSFuture[nsfd.typesSrcFileSystemDirectoryHandleMod.default ]

   def unboxingConv
   : =:=[_Any, JSFuture[nsfd.typesSrcFileSystemDirectoryHandleMod.default ] ]
   = <:<.refl

   ;

   def apply
      (value: JSFuture[nsfd.typesSrcFileSystemDirectoryHandleMod.default ] )
   = unboxingConv.flip.apply(value )

   ;

   extension (receiver: _Any )
      def tryGetHandle
      : JSFuture[nsfd.typesSrcFileSystemDirectoryHandleMod.default ]
      = unboxingConv.apply(receiver )

   ;

   lazy val basicInstance
   = {
      ;
      GFC((
         //
         async[JSFuture ] {
            ;

            val handle
            = await((nsfd.mod.getOriginPrivateDirectory() ).nn )

            handle
         }
      ))
   }

   ;

   ;

}

/** 
 * `tryWriteOver`
 * 
 * `newContent` needs to be something it understands.
 * 
 */
def tryWriteOver
   //
   (using backingCookiesStoreCtx : GFC._Any )
   (fName: String )
   (newContent: Any )
= (cps.async[JSFuture ] {
   ;

   val dir
   = await((backingCookiesStoreCtx.tryGetHandle).nn )

   val file1
   = await(dir.getFileHandle(fName, nsfd.anon.Create().setCreate(true ) ).nn )

   val fileWriter
   = await(file1.createWritable().nn )

   dom.console.log("[tryWriteOver] writing " )

   await(fileWriter.write(newContent ) )

   await(fileWriter.closeAsync() )

   dom.console.log("[tryWriteOver] done " )

   file1
})

def tryReadFile
   //
   (using backingCookiesStoreCtx : GFC._Any )
   (fName: String )
= (cps.async[JSFuture ] {
   ;

   val dir
   = await((backingCookiesStoreCtx.tryGetHandle).nn )

   val file1
   = await(dir.getFileHandle(fName, nsfd.anon.Create().setCreate(false ) ) )

   val fileData
   = await(file1.getFile() )

   fileData
})

















val _ = {}
