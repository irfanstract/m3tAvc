package avcframewrk.nio.avc.streams.internal
















import cps.{async, await}

import scalajs.js
import scalajs.js.annotation.*

import cps.monads.jsfuture.JSFuture

import typings.std.{global as dom }
import typings.{std as domItc }

import com.raquo.airstream





/** 
 * this "linked list" structure
 * "is async" at `tail`.
 * 
 */
enum SPrLl[+R] {
  case empty
  extends
  SPrLl[Nothing]

  case #::
    [R](head: R, tailOpt: js.Promise[SPrLl[R] ] )
  extends
  SPrLl[R]
}
object SPrLl {
  ;

  import SPrLl.#::

  extension [R] (receiver: SPrLl[R] )
    /** 
     * "append"
     * 
     * this is a recursive fnc.
     * 
     */
    def :+
        (newItem: R)
    : SPrLl.#::[R]
    = {
      ;
      receiver match {
      //
      case `empty` =>
        #::(newItem, js.Promise.resolve(empty ) )

      case (l : #::[R] ) =>
        l
        .pipeLooseSelf({
          tailPartLens[R]
          .modify(existingTailPartOpt => {
            existingTailPartOpt
            .`then`(p => p.:+(newItem) )
          })
        } )
      }
    }
  //

  extension [R] (receiver: SPrLl.#::[R] ) {
    //

    def asSignal
    : airstream.state.StrictSignal[R]
    = {
      ;

      airstream.core.EventStream.fromJsPromise({
        //

        receiver.tailOpt

        .`then`(receiver => {
          //
          receiver match {
            //

            case (l : #::[R] ) =>
              l.asSignal
              .now()

              .pipeLooseSelf(value => (
                js.Promise.resolve[R] (value)
              ) )

            case `empty` =>
              ;
              js.Promise[Nothing] ({ case cbs => {
                /* leave it hanging */
              } })

            //
          }
        } : js.Promise[R] ).asInstanceOf[js.Promise[R] ]
      } , emitOnce = false )

      .startWith(receiver.head )

      .pipeLooseSelf(o => {
        util.Using.resource({
          avcframewrk.forms.templating.rendering.functionalreactions.raquoairstream.allocateUrfpsOwnerCloseable()
        })(implicit suggestedOw => {
          o
          .observe(using suggestedOw)
          // TODO consider, safe ???
        } )
      } )
    }
  }

  def tailPartLens[R]
  = {
    monocle.macros.GenLens[SPrLl.#::[R] ](_.tailOpt )
  }

}

;












val _ = {}
