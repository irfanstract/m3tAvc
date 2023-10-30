package avcframewrk.forms

package domNavigatorObj.storageUsageUtil




import cps.{async, await }

import scalajs.js

import typings.{std as domItc }
import typings.std.{global as dom }

import cps.monads.jsfuture.{JSFuture, given }

import com.raquo.airstream



import FsWatchFrpTwoWay.{ctxtualSetterStyle, CtxtualSetterStyle}



// import avcframewrk.forms.predef231119.{*, given }



given ctwNamedness[T]
: AnyRef with {
  // TODO
  extension (r: T)
    def name1: String
    = {
      ;
      r.toString()
      r match {
        case r : dom.File =>
          r.name
        case r =>
          // throw new IllegalArgumentException(s"${r}")
          s"(???: ${r } )"
      }
    }
}

type CtwOptionalSetterNessStyle
>: CtxtualSetterStyle._Any
<: CtxtualSetterStyle._Any

def controlledTwoWayFrp
   //
   [SrcPath, Value0, Value1 ]
   (
     d: SrcPath,
     upstreamContentsAsync: => js.Promise[Value0] ,
     convFromValue0ToValue1: (Value0 | Null ) => Value1 ,
     commit1: Value1 => js.Promise[Unit] ,
     refreshPeriodInSeconds: Double,
     // nameDbg: ctwNamedness[SrcPath] ,
   )
   (using nameDbg: ctwNamedness[SrcPath] )
   // (using value0FromNull : <:<[Null, Value0] )
   (using ctsps: CtwOptionalSetterNessStyle )
: airstream.core.Signal[(
  ctxtualSetterStyle.ReadjustedValueAndSetterPair1[Value1]
) ]
= {
  ;

  given nameDbg.type
  = nameDbg

  import airstream.core.{*, given}
  import airstream.state.{*, given}

  val regularPeriodic
  = {
    ;
    (([R] => (fnc: (tInSeconds: DummyImplicit ?=> Double) => R ) => fnc )(tInSeconds => EventStream.periodic((tInSeconds * 1000 ).toInt ) ) )
    .apply(tInSeconds = refreshPeriodInSeconds + (scala.math.random() * 2 ) )
    .startWith(0 )
  }

  new Selectable {
    ;

    val groupId
    = scala.math.random().pipeLooseSelf(java.lang.Double.doubleToLongBits(_).abs ).toInt.abs

    val groupDbgTitle
    = s"$groupId ; ${d.name1 } "

    case class Lsc(
      //
      utFetchSpanCount: Int ,
      //
      lastSetCsOpt: Option[Value1] ,
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
      =
        (lscImpl.signal.map(utFetchSpanCountLens.get _ ) ).map(i => i )
        .distinct
        .debugSpyEvents({
          ;
          object startedBar {
            dom.console.debug(s"[$groupDbgTitle] 'utFetchSpanCountAnimImpl' started.")
          }
          ;
          e => { startedBar ; e }
        })

      val commitCountAnimImpl
      = {
        lscImpl.signal.map(commitCountLens.get _ )
        .distinct
      }

      (utFetchSpanCountAnimImpl , {
        airstream.core.Observer[(Unit, Value1)]((_: Unit, ct) => {
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

      (regularPeriodic combineWith utFetchSpanId )
      .pipeLooseSelf(ss => {
        ;

        extension [V0] (s: airstream.core.Signal[V0] )
          def scanLeftAltSameC
            //
            (f: (V0, V0) => V0 )
          = {
            s
            .scanLeft[V0] (v => v )(f )
          }
          def scanLeftAlt
            //
            [V2, V21 >: V2 <: V2 ]
            (f: (Option[V21], V0) => V2 )
          = {
            s
            .scanLeft[V2 ] (v => f(None, v) )((lastState, v2) => {
              f(Some(lastState), v2 )
            } )
          }
          def flatScanLeftAlt
            //
            [V2Item ]
            (f: (
              ([C[value] ] =>> ((Option[C[V2Item] ], V0) => C[V2Item] ) )
              [airstream.core.Signal ]
            ) )
          = {
            s
            .scanLeftAlt(f)
            .flatten
          }
        extension [V0] (s: airstream.core.EventStream[V0] )
          def startWithLastValueOf
            //
            (rhS: airstream.core.Signal[V0] , ifNotLoaded: => Unit )
          : airstream.core.Signal[V0]
          = {
            ;
            s.toWeakSignal
            .combineWith({
              rhS
              /* necessary for the GC-ability */
              .composeChanges(_ => airstream.core.EventStream.empty )
            })
            .map({ case e => e._1.getOrElse[V0] { ifNotLoaded ; e._2 } })
          }
        
        ss
        .flatScanLeftAlt ((lastChildSegmtOpt: Option[airstream.core.Signal[Value1] ], _) => {
          ;

          EventStream.fromJsPromise({
            upstreamContentsAsync
            .`then`(blob => {
              ;

              (convFromValue0ToValue1(blob ) )
            })
          })

          // .startWith((
          //   (convFromValue0ToValue1(null ) )
          //   // lscSrc.now().lastSetCsOpt
          //   // .getOrElse(convFromValue0ToValue1(null ) )
          // ) : Value1 , true )
          .startWithLastValueOf({
            ;
            ;
            lastChildSegmtOpt
            .getOrElse({
              airstream.core.Signal.fromValue({
                dom.console.debug(s"[$groupDbgTitle] not started before yet")
                convFromValue0ToValue1(null )
              })
            })
          } , ifNotLoaded = { dom.console.debug(s"[$groupDbgTitle] not loaded yet") } )
          .combineWith({
            commitCountOTempFileOptional
          } )

          .map((e01, lsc) => {
            lsc
            .getOrElse[Value1] (e01 )
          })

          .map(<:<.refl )
        } )
        .map(<:<.refl[Value1 ] )
      } )
      .map(c => (
        (c , (newState: Value1 ) => {
          updateTo(newState)
        } )
      ) )
      .composeChanges(chgs => {
        chgs
        .debounce(125 )
      } )
    }

    def processUpdatetoRunAftermathOpt
      //
      (tr: util.Try[(Unit, Value1)] )
    : Unit
    = {
      ;
      uue._2
      .onTry(tr )
    }

    def updateTo
      //
      (newState: Value1 )
    = {
      ;
      (async[JSFuture] {
        ;

        ;

        if {
          true
        } then {
          ;

          await { commit1(newState) }

        }

        ((), newState )
      })
      .pipeLooseSelf(pr => {
        pr
        .mapToUtilTry()
        .`then`(processUpdatetoRunAftermathOpt(_) )
      })
    }

    ;
  }
  .pipeLooseSelf(ctx => {
    import ctx.*

    utFetchAsObservable
    .map((c, updateToAsynchronously) => {
      ;
      ctxtualSetterStyle.fromValueAndSetter(c, updateToAsynchronously )
    })
  })
}
