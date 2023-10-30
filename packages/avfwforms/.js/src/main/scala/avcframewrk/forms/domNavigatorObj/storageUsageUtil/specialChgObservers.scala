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
      (using ctsps: CtxtualSetterStyle._Any )
   : airstream.core.Signal[ctsps.ReadjustedValueAndSetterPair1[SpecialObsOps.initially.type | SpecialObsOps.ForDirOrFileFullObserv ] ]
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
      ), refreshPeriodInSeconds: Double = 5.5 )
      (using ctsps: CtxtualSetterStyle._Any )
   : airstream.core.Signal[ctsps.ReadjustedValueAndSetterPair1[SpecialObsOps.initially.type | SpecialObsOps.ForFileFullObserv ] ]
   = {
      ;

      import airstream.core.{*, given}
      import airstream.state.{*, given}

      val regularPeriodic
      = {
        ;
        (([R] => (fnc: (tInSeconds: DummyImplicit ?=> Double) => R ) => fnc )(tInSeconds => EventStream.periodic((tInSeconds * 1000 ).toInt ) ) )
        .apply(tInSeconds = refreshPeriodInSeconds + (scala.math.random() * 2 ) )
        .startWith(0 )
      }

      /** 
       * the latest contents `Blob`, asynchronously
       * 
       */
      def contentsAsync
      = cps.async[JSFuture] {
        ;

        val blob
        = {
          cps.await(d.getFile() )
          .asInstanceOf[dom.Blob & domItc.File ]
        }

        blob
      }

      new Selectable {
        ;

        val groupId
        = scala.math.random().pipeLooseSelf(java.lang.Double.doubleToLongBits(_).abs ).toInt.abs

        val groupDbgTitle
        = s"$groupId ; ${d.name } "

        case class Lsc(
          //
          utFetchSpanCount: Int ,
          //
          lastSetCsOpt: Option[SpecialObsOps.ForFileContents] ,
          commitCount: Int ,
        )

        val uue @ (utFetchSpanId *: _ *: lscSrc *: commitCountO *: _ )
        = {
          ;

          val lscImpl = airstream.state.Var[(Lsc )](( Lsc(utFetchSpanCount = 0, lastSetCsOpt = None, commitCount = 0 ) ) )

          val utFetchSpanCountLens = monocle.macros.GenLens[Lsc](_.utFetchSpanCount )
          val commitCountLens = monocle.macros.GenLens[Lsc](_.commitCount )

          val lscAnimImpl
          = lscImpl.signal

          val utFetchSpanCountAnimImpl
          = (lscImpl.signal.map(utFetchSpanCountLens.get _ ) ).map(i => i ).distinct
          val commitCountAnimImpl
          = lscImpl.signal.map(commitCountLens.get _ ).distinct

          (utFetchSpanCountAnimImpl , {
            airstream.core.Observer[(Unit, SpecialObsOps.ForFileContents)]((_: Unit, ct) => {
              ;
              lscImpl.update(st0 => {
                st0
                .copy(lastSetCsOpt = Some(ct) )
                .pipeLooseSelf(utFetchSpanCountLens.modify(_ + 1 ) )
                .pipeLooseSelf(commitCountLens.modify(_ + 1 ) )
              })
            } )
            .debugSpyEvents(s => {
              // ???
              dom.console.log(s"impl receiving a commit ($s ).")
            } )
          } , lscAnimImpl, commitCountAnimImpl )
        }

        val utFetchAsObservable
        = {
          ;

          val commitCountOTempFileOptional
          = {
            ;

            commitCountO
            .debugSpyEvents(i => {
              dom.console.debug(s"[$groupDbgTitle] 'commitCountO' got updated (to $i ).")
            })
            .flatMap(i => {
              airstream.core.EventStream.delay(5 * 1000 )
              .toWeakSignal
              .debugSpyEvents(i1 => {
                dom.console.debug(s"[$groupDbgTitle] 'commitCountO'-change-debnc/clr (at $i ) started with (${i1} ).")
              })
              .map(_.isEmpty)
              .flatMap(shall => {
                if shall then lscSrc.map(_.lastSetCsOpt )
                else airstream.core.Signal.fromValue(None )
              })
            })
            .compose({
              def implTr
                [Value <: Option[?] ](s: airstream.core.Signal[Value])
              = {
                ;
                // s
                // .debugSpyEvents(_ => {
                //   dom.console.debug(s"($i) clearing the 'whileDeferred' as t has passed.")
                // })
                s
                .scanLeft[(Value)] (identity(_) )((s0, s2) => {
                  if (s0.isEmpty && s2.nonEmpty) then {
                    dom.console.debug(s"[$groupDbgTitle] 'whileDeferred'. for t to pass.")
                  }
                  if (s0.nonEmpty && s2.isEmpty) then {
                    dom.console.debug(s"[$groupDbgTitle] cleared the 'whileDeferred'. t has passed.")
                  }
                  s2
                } )
              }
              implTr(_)
            })
          }

          // Val(SpecialObsOps.ForFileContents(null ) )
          (regularPeriodic combineWith utFetchSpanId )
          .flatMap(_ => {
            ;

            EventStream.fromJsPromise({
              contentsAsync
              .`then`(blob => {
                ;

                (SpecialObsOps.ForFileContents(blob ) )
              })
            })

            .startWith((
              (SpecialObsOps.ForFileContents(null ) )
              // lscSrc.now().lastSetCsOpt
              // .getOrElse(SpecialObsOps.ForFileContents(null ) )
            ) : SpecialObsOps.ForFileContents , true )
            .combineWith({
              commitCountOTempFileOptional
            } )

            .map((e01, lsc) => {
              lsc
              .getOrElse[SpecialObsOps.ForFileContents] (e01 )
            })
          } )
          .map(c => (
            (c , (newState: SpecialObsOps.ForFileContents ) => {
              updateTo(newState)
            } )
          ) )
        }

        def processUpdatetoRunAftermathOpt
          //
          (tr: util.Try[(Unit, SpecialObsOps.ForFileContents)] )
        : Unit
        = {
          ;
          uue._2
          .onTry(tr )
        }

        def updateTo
          //
          (newState: SpecialObsOps.ForFileContents )
        = {
          ;
          (async[JSFuture] {
            ;

            val SpecialObsOps.ForFileContents(newContents : js.Any)
            = newState

            ;

            import avcframewrk.forms.domNavigatorObj.storageUsageUtil.gfso.closeAsync

            if {
              true
            } then {
              ;

              val wr
              = await(d.createWritable() )

              await {
                wr.write(newContents )
              }

              await {
                wr.closeAsync()
              }

            }

            ((), newState )
          })
          .pipeLooseSelf(pr => {
            pr
            .mapToUtilTry()
            .`then`(processUpdatetoRunAftermathOpt(_) )
          })
        }

      }
      .pipeLooseSelf(ctx => {
        import ctx.*

        utFetchAsObservable
        .map((c, updateToAsynchronously) => {
          ;
          ctsps.fromValueAndSetter(c, updateToAsynchronously )
        })
      })
   }

   /** 
    * scan for any changes within
    * 
    */
   // TODO
   def startDirFrp
      (d: typings.nativeFileSystemAdapter.typesSrcFileSystemDirectoryHandleMod.default )
      (using ctsps: CtxtualSetterStyle._Any )
   : airstream.core.Signal[ctsps.ReadjustedValueAndSetterPair1[SpecialObsOps.initially.type | SpecialObsOps.ForDirFullObserv ] ]
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

        // TODO
        specialUpdateEvts
        .startWith ({
          ctsps.fromValueAndSetter({
            SpecialObsOps.initially
          } , (_ : SpecialObsOps ) => {
            throw new IllegalStateException
          } )
        } , true )
      }
      //

      specialStateObserv
   }

   private
   def startDirFrpForKeysMentionedIn
      //
      (d: typings.nativeFileSystemAdapter.typesSrcFileSystemDirectoryHandleMod.default )
      (e: SpecialObsOps.ForDirFullObserv )
      (using ctsps: CtxtualSetterStyle._Any )
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

            val fObservable
            = {
              ;
              startNodeFrp(fHandle )
            }

            EmptyTuple :* fObservable
          }
        } , (
          EmptyTuple :* {
            Val({
              ctsps.fromValueAndSetter(SpecialObsOps.initially, (_: SpecialObsOps ) => {
                throw new IllegalStateException
              } )
            })
          }
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
        kvs0 => {
          ;

          // TODO
          ({
            val kvs
            = {
              kvs0
              .mapValues(_.value ).toMap
            }

            val kValueSetters
            = {
              kvs0
              .mapValues(v => (v.chgTo _ ) ).toMap
            }

            /** 
             * 
             * 
             */
            def updateAllTo
              //
              (newAggregateState: SpecialObsOps.ForDirNameAndContentsList )
            = {
              ;

              val SpecialObsOps.ForDirNameAndContentsList(newKvs)
              = newAggregateState

              val allKeys
              = {
                ;
                (newKvs.keySet ) union (kvs.keySet )
              }

              allKeys

              .foreach((k: String ) => {
                ;

                def throwNfAsssertionError
                  ()
                = {
                  throw new AssertionError(s"for key: ${k } ")
                }

                val newValue
                = {
                  ;
                  (newKvs.get(k) orElse kvs.get(k) )
                  .getOrElse(throwNfAsssertionError() )
                }

                kValueSetters.applyOrElse(k, _ => throwNfAsssertionError() )
                .apply(newValue )
              })
            }

            ctsps.fromValueAndSetter({
              SpecialObsOps.ForDirNameAndContentsList(kvs)
            }, (newAggregateState: SpecialObsOps.ForDirNameAndContentsList ) => (
              updateAllTo(newAggregateState)
            ) )
          })
        } )
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
      extends
      SpecialObsOps

      type ForDirOrFileFullObserv
      = ForFileFullObserv | ForDirFullObserv

      sealed trait ForFile
      extends
      SpecialObsOps

      case class  ForFileContents(value: (
        dom.Blob | Null
      ) ) extends
      SpecialObsOps
      with SpecialObsOps.ForFile

      type ForFileFullObserv
      >: ForFileContents
      <: ForFileContents

      sealed trait ForDir
      extends
      SpecialObsOps

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
      {
        override
        def toString(): String
        = {
          import language.unsafeNulls
          (
            Nil
            :+ "ForDirNameAndContentsList :"
            :++ {
              value.toSet
              .map({
                case (k, v) =>
                  "  " + s"$k: " + v.toString().indent(2)
              })
            }
            mkString("\n")
          )
        }
      }

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

   final
   lazy val CtxtualSetterStyle
   : FsWatchFrpTwoWay.CtxtualSetterStyle.type
   = FsWatchFrpTwoWay.CtxtualSetterStyle

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