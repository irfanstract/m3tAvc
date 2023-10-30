package avcframewrk.forms

package domNavigatorObj.storageUsageUtil













import cps.{async, await }

import scalajs.js

import typings.{std as domItc }
import typings.std.{global as dom }

import cps.monads.jsfuture.{JSFuture, given }

import com.raquo.airstream





;

implicit
object nsToGetDirectoryOrFileHandle {
  ;

  ;

  ;

  extension (d: typings.nativeFileSystemAdapter.typesSrcFileSystemDirectoryHandleMod.default )
  {
    //

    /** 
    * `getDirectoryOrFileHandles`
    * 
    */
    def getDirectoryOrFileHandles
      //
      ()
    = async[JSFuture] {
      ;

      await(fromAsyncIterator[js.Any /* [] */ ] (d.entries().asInstanceOf[js.Any ] ) )
      .map(e => e.asInstanceOf[js.Tuple2[?, ?] ] match { case js.Tuple2(v1, v2 ) => {
        (v1.asInstanceOf[String] -> v2.asInstanceOf[(
          //
          typings.nativeFileSystemAdapter.typesSrcFileSystemDirectoryHandleMod.default
          | typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default
        )] )
      } })
      .toMap
    }

    /** 
    * `getDirectoryOrFileHandle`
    * 
    */
    def getDirectoryOrFileHandle
      //
      (fName: String)
    : (
      js.Promise[(
        //
        typings.nativeFileSystemAdapter.typesSrcFileSystemDirectoryHandleMod.default
        | typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default
      )]
    )
    = {
      // TODO
      async[JSFuture] {
        val fRes
        = {
          ;
          ({
            ;
            await(d.getDirectoryOrFileHandles() )
          })
          .apply(fName )
        }
        fRes
      }
    }

  }

  ;

  ;
}













val _ = {}
