package avcframewrk.forms

package domNavigatorObj.storageUsageUtil













import cps.{async, await }

import scalajs.js

import typings.{std as domItc }
import typings.std.{global as dom }

import cps.monads.jsfuture.{JSFuture, given }

import com.raquo.airstream





;

object FsWatchFrpUtil
{
  ;

  ;

  ;

  def observeMapValues
    //
    [K, V, ObserV]
    (fileKvs : Map[K, V] )
    (observeSpecific: (key: K, value: V) => airstream.core.Signal[ObserV ] )
  : airstream.core.Signal[Map[K, ObserV] ]
  = {
    ;

    import airstream.core.{*, given}
    import airstream.state.{*, given}

    Signal.combineSeq({
      ;
      fileKvs
      .toSeq
      .map({ case (fName, value) => {
        ;

        observeSpecific(key = fName , value = value )

        .map(state => (fName -> state ) )
      } })
    })
    .map((kvs: Seq[(K, ObserV) ] ) => (
      kvs.toMap
    ) )
  }

  def observableFromCloseable
      //
      [MdlState]
      (allocateLoop: (
        (propagateUpdate: (newState: MdlState) => Unit ) =>
          java.io.Closeable
      ) )
  : airstream.core.EventStream[MdlState ]
  = {
    ;

    import airstream.core.{*, given}
    import airstream.state.{*, given}

    ({
      ;

      var lastTaskHandle : java.io.Closeable
      = locally[java.io.Closeable ](() => {} )

      EventStream.fromCustomSource
        [MdlState ]
        (
          //
          shouldStart = _ => true ,
          start = { case (updateTo, _, _, _ ) => lastTaskHandle.close() ; lastTaskHandle = {
            allocateLoop(propagateUpdate = updateTo )
          } } ,
          stop = { case i => lastTaskHandle.close() } ,
        )
    })
  }

  ;

  ;

  /** 
   * this' constructor
   * starts a loop
   * 
   */
  private[storageUsageUtil]
  trait SNCL
  {
    ;

    def trySnaphotAndCallback
      ()
    : JSFuture[Unit]

    export aboc.abort

    val aboc
    = new dom.AbortController

    protected
    object abortException extends
    util.control.ControlThrowable
    def throwIfAborted
      ()
    = {
      if aboc.signal.aborted then
        throw abortException
    }

    (async[JSFuture] {
      ;

      def dpSeconds
        (tInSeconds: Double )
      = {
        js.Promise[Unit] ((resolve, _) => {
          ;
          js.timers.setTimeout(tInSeconds * 1000 )(resolve(() ) )
        } )
      }

      // TODO loop
      while { throwIfAborted() ; true } do {
        ;

        /** wait one or two seconds */
        await (dpSeconds(3) )

        ;

        // TODO
        await(trySnaphotAndCallback() )

        ;

        /** wait a fraction of a minute */
        await (dpSeconds(20 ) )

        ;
      }

      ()
    })
    .mapTry(tr => {
      tr
      .recover({ case _ @ `abortException` => })
      .get
    } )

    ;
  }

  ;

  ;
}












val _ = {}
