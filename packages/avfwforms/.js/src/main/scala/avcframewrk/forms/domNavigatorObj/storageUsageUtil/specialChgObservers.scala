package avcframewrk.forms

package domNavigatorObj.storageUsageUtil













import cps.{async, await }

import scalajs.js

import typings.{std as domItc }
import typings.std.{global as dom }

import cps.monads.jsfuture.{JSFuture, given }

import com.raquo.airstream





;





object FsWatch {
   ;

   import FsWatchFrpUtil.observeMapValues

   import FsWatchFrpUtil.observableFromCloseable

   ;

   def startNodeFrp
      (d: (
        typings.nativeFileSystemAdapter.typesSrcFileSystemDirectoryHandleMod.default
        | typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default
      ) )
   : airstream.core.Signal[SpecialObsOps.initially.type | SpecialObsOps.ForDirOrFileFullObserv ]
   = {
      ;
      d.kind.toString() match {
      //
      case "directory" =>
        startDirFrp(
          d.asInstanceOf[typings.nativeFileSystemAdapter.typesSrcFileSystemDirectoryHandleMod.default] )
      case "file" =>
        startFsLeafFrp(
          d.asInstanceOf[typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default] )
      //
      }
   }

   // TODO
   def startFsLeafFrp
      (d: (
        typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default
      ) )
   : airstream.core.Signal[SpecialObsOps.initially.type | SpecialObsOps.ForFileFullObserv ]
   = {
      ;

      import airstream.core.{*, given}
      import airstream.state.{*, given}

      // Val(SpecialObsOps.ForFileContents(null ) )
      EventStream.fromJsPromise({
        cps.async[JSFuture] {
          val blob
          = cps.await(d.getFile() )
          SpecialObsOps.ForFileContents(blob.asInstanceOf[dom.Blob ] )
        }
      })
      .startWith(SpecialObsOps.ForFileContents(null ) , true )
   }

   /** 
    * scan for any changes within
    * 
    */
   // TODO
   def startDirFrp
      (d: typings.nativeFileSystemAdapter.typesSrcFileSystemDirectoryHandleMod.default )
   : airstream.core.Signal[SpecialObsOps.initially.type | SpecialObsOps.ForDirFullObserv ]
   = {
      ;

      def startNewSpecialScanCallbackLoop
        (callback : SpecialObsOps.ForDirFullObserv => Unit )
      : java.io.Closeable
      = {
        ;

        object snapshotCallbackLoopHandle extends
        AnyRef
        with java.io.Closeable
        with SNCL
        {
          ;

          override
          def close(): Unit
          = abort()

          def trySnaphotAndCallback
              ()
          = cps.async[JSFuture] {
            ;

            val dirNameList
            = await(fromAsyncIterator(d.keys().asInstanceOf[js.Any] ).asInstanceOf[js.Promise[Seq[String] ] ] )

            // TODO
            val summary = {
              SpecialObsOps.ForDirNameAndContentsList({
                (Nil :++ dirNameList ).toSet
                .map(k => (k, SpecialObsOps.ForFileContents(null ) ) )
                .toMap
              } )
            }

            dom.console.log(js.Dictionary("summary" -> summary ) )

            callback(summary)

            ()
          }

        }

        snapshotCallbackLoopHandle
      }

      val specialUpdateEvts
      = {
        ;

        import airstream.core.{*, given}
        import airstream.state.{*, given}

        observableFromCloseable((updateTo : SpecialObsOps.ForDirFullObserv => Unit ) => {
          ;

          startNewSpecialScanCallbackLoop(callback = newState => {
            updateTo((newState ) )
          } )
        } )
        .distinct
        .startWith[SpecialObsOps.ForDirFullObserv ] (SpecialObsOps.ForDirNameAndContentsList(Map() ) , true )
        .flatMap({ case e @ SpecialObsOps.ForDirNameAndContentsList(_) => {
          ;

          startDirFrpForKeysMentionedIn(d)(e)
        }})

        .distinct

        .changes
      }

      val specialStateObserv
      = {
        ;

        specialUpdateEvts
        .startWith[SpecialObsOps.initially.type | SpecialObsOps.ForDirFullObserv ] (SpecialObsOps.initially , true )
      }
      //

      specialStateObserv
   }

   private
   def startDirFrpForKeysMentionedIn
      //
      (d: typings.nativeFileSystemAdapter.typesSrcFileSystemDirectoryHandleMod.default )
      (e: SpecialObsOps.ForDirFullObserv )
   // : 
   = {
      ;

      import airstream.core.{*, given}
      import airstream.state.{*, given}

      ;

      val SpecialObsOps.ForDirNameAndContentsList(fileKvs)
      = e

      observeMapValues(fileKvs )((fName, _) => {
        ;

        Signal.fromJsPromise({
          cps.async[JSFuture] {
            ;

            val fHandle
            = cps.await(d.getDirectoryOrFileHandle(fName) )

            EmptyTuple :* startNodeFrp(fHandle )
          }
        } , (
          EmptyTuple :* Val(SpecialObsOps.initially )
        ) )
        .flatMap({
          //
          case stateAnim *: EmptyTuple => {
            for {
              state <- stateAnim
            }
            yield state
          }
        })
      })

      .map(
        kvs => SpecialObsOps.ForDirNameAndContentsList(kvs) )
   }

   /** 
    * continuously repeat
    * list the dir's directimmediate children, and then run the cb
    * 
    */
   def startDirLsCbLoop
      (d: typings.nativeFileSystemAdapter.typesSrcFileSystemDirectoryHandleMod.default )
      (callback: (SpecialObsOps.ForDirNameList) => Unit )
   = {
      ;

      object %%% extends
      AnyRef
      with java.io.Closeable
      {
        ;

        override
        def close(): Unit
        = abort()

        snapshotCallbackLoopHandle

        object snapshotCallbackLoopHandle extends
        AnyRef
        with SNCL
        {
          ;

          def trySnaphotAndCallback
              ()
          = cps.async[JSFuture] {
            ;

            val dirNameList
            = cps.await({
              fromAsyncIterator(d.keys().asInstanceOf[js.Any] )
              .asInstanceOf[js.Promise[Seq[String] ] ]
            } )

            // TODO
            val dirNameListingEvtInfo
            = SpecialObsOps.ForDirNameList(dirNameList.toSet )
            dom.console.log(js.Dictionary("dirNameListingEvtInfo" -> dirNameListingEvtInfo ) )

            callback(dirNameListingEvtInfo )

            ()
          }

        }

        export snapshotCallbackLoopHandle.abort
        export snapshotCallbackLoopHandle.trySnaphotAndCallback

        // val operatedDir
        // : d.type
        // = d

      }
      %%%
   }

   object SpecialObsOps {
      ;

      case object initially

      type ForDirOrFileFullObserv
      = ForFileFullObserv | ForDirFullObserv

      sealed trait ForFile extends SpecialObsOps

      case class  ForFileContents(value: (
        dom.Blob | Null
      ) ) extends
      SpecialObsOps
      with SpecialObsOps.ForFile

      type ForFileFullObserv
      >: ForFileContents
      <: ForFileContents

      sealed trait ForDir  extends SpecialObsOps

      case class   ForDirNameList(value: (
        collection.immutable.Iterable[String]
      ))
      extends
      SpecialObsOps
      with SpecialObsOps.ForDir

      case class   ForDirNameAndContentsList(value: (
        collection.immutable.Map[String, initially.type | ForDirOrFileFullObserv ]
      ) )
      extends
      SpecialObsOps
      with SpecialObsOps.ForDir

      type ForDirFullObserv
      >: ForDirNameAndContentsList
      <: ForDirNameAndContentsList

      implicit
      object forDirFullObservOps {
        ;

        extension (receiver: ForDirFullObserv )
          /** 
           * the names of all the child entries in the proxied "directory".
           * 
           */
          def childNames
          : collection.immutable.Iterable[String]
          = {
            receiver.value.keySet
            .toSeq
            .sorted(using avcframewrk.forms.xModifiedPhoneticalOrdering )
          }

      }
   }
   abstract class SpecialObsOps {
      ;

      ;
   }

   ;

   object CtxtualSetterStyle {
      ;

      ;

      type _Any
      = _Impl

      protected
      trait _Impl {
        ;

        type Value

        type Setter

        type ReadjustedValueAndSetterPair

        type SetterSynchronousReturnValue

        def fromValueAndSetter
          //
          (value: Value, updateTo: Value => SetterSynchronousReturnValue )
        : ReadjustedValueAndSetterPair

        extension (pair: ReadjustedValueAndSetterPair ) {
          //

          def value
          : Value

          def chgTo(value: Value)
          : SetterSynchronousReturnValue
        }

        ;
      }

      ;
   }

   ;

   /** 
    * this' constructor
    * starts a loop
    * 
    */
   private[FsWatch]
   type SNCL
   = FsWatchFrpUtil.SNCL

}


















val _ = {}