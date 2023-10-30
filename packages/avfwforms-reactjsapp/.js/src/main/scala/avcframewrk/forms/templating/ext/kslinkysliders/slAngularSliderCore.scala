package avcframewrk.forms.templating.ext.kslinkysliders













import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.std.{global as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageUsageUtil.FsWatch








object SascWithValue {
  ;

  type _ForR[+Value]
  >: (Unit, Value)
  <: (Unit, Value)

  def apply
    //
    (value: Any )
  : _ForR[value.type]
  = ((), value )

  extension [Value] (c: _ForR[Value])
    def value
    = c._2
  ;

  ;
}

object slascCore {
  ;

  import avcalculus.{trig as tr }

  ;

  // TODO
  def atanXY
    //
    (dir: AtanDir )
    (xy: (Double, Double) )
  = {
    ;

    val (x, y)
    = xy

    tr.Angular.fromDegrees({
      (scala.math.atan2(y, x ) / (2 * scala.math.Pi) ) *
        360
    })
    .pipeLooseSelf(dir.inverseTransformFromIeeeSpace(_) )
  }

  type AtanDir
  >: (tr.NeWsPolarQuad, tr.Angular.MomentaryDirection)
  <: (tr.NeWsPolarQuad, tr.Angular.MomentaryDirection)

  extension (dir: AtanDir) {
    //

    def forwardTransformToIeeeSpace
      //
      (a: tr.Angular._Any)
    = {
      (
        <:<.refl[tr.Angular._Any ]
        compose
        ((a: tr.Angular._Any) => a.unary_- )
        compose
        ((a: tr.Angular._Any) => (
          dir._1.fromWestClockwiseDevn + a
        ))
        compose
        ((a: tr.Angular._Any) => a multipliedBy(dir.dcw ) )
      )
      .apply(a )
    }

    def inverseTransformFromIeeeSpace
      //
      (a: tr.Angular._Any)
    = {
      (
        <:<.refl[tr.Angular._Any ]
        compose
        ((a: tr.Angular._Any) => a multipliedBy(dir.dcw ) )
        compose
        ((a: tr.Angular._Any) => (
          a + -dir._1.fromWestClockwiseDevn
        ))
        compose
        ((a: tr.Angular._Any) => a.unary_- )
      )
      .apply(a )
    }

    protected
    def dcw
    = {
      ;

      import tr.Angular.MomentaryDirection
      import MomentaryDirection.*
      dir._2 match {
        case Clockwise => 1
        case CounterClockwise => -1
      }
    }

    //
  }

  ;

  import typings.{d3, d3Selection, d3Drag}

  def useSv
    //
    (
      upstreamValue: tr.Angular._Any
      ,
      atanDir: AtanDir
      = (tr.west, tr.Angular.MomentaryDirection.Clockwise )
      ,
    )
  = {
    ;

    val (effectiveValue, dragStartPointerPointedValue) *: efvCtr *: _ *: ec *: _
    = useTempState[(tr.Angular._Any, tr.Angular._Any )] (
      //
      upstreamValue = (upstreamValue, upstreamValue )
      ,
    )

    val processDragStartEvt
    = {
      ;

      avcframewrk.forms.templating.reactjs_s1.useEventCallback((evt: d3Drag.mod.D3DragEvent[?, ?, ?] ) => {
        ;

        val newPtrPointedAng
        = slascCore.atanXY(atanDir)((evt.x, evt.y ) )
        
        dom.console.debug(s"upstreamValue: $upstreamValue, newPtrPointedAng: $newPtrPointedAng ")

        ;
        efvCtr
        .setTempStateOption(_ => Some((upstreamValue, newPtrPointedAng) ) )
      })
    }

    val processDragMotionEvt
    = {
      ;

      avcframewrk.forms.templating.reactjs_s1.useEventCallback((evt: d3Drag.mod.D3DragEvent[?, ?, ?] ) => {
        ;

        val newPtrPointedAng
        = slascCore.atanXY(atanDir)((evt.x, evt.y ) )

        efvCtr
        .setTempStateOption(s0 => {
          ;
          ({
            ;

            val (efv0, dragStartPointerPointedValue)
            = {
              s0
              // .getOrElse((effectiveValue, dragStartPointerPointedValue) )
              .unzip.pipeLooseSelf({ case (efv0Opt, dspvOpt) => (efv0Opt.get, dspvOpt.getOrElse(newPtrPointedAng) ) } )
            }

            ({
              ;

              Some {
                (upstreamValue + (newPtrPointedAng - dragStartPointerPointedValue ) , dragStartPointerPointedValue )
              }
            })
            .pipeLooseSelf(e => e )
          })
        })
      })
    }

    val processDragReleaseEvt
    = {
      ;

      avcframewrk.forms.templating.reactjs_s1.useEventCallback((evt: d3Drag.mod.D3DragEvent[?, ?, ?] ) => {
        ;
        efvCtr
        .setTempStateOption(_ => None )
      })
    }

    val dr = {
      ;

      slinky.core.facade.Hooks.useMemo(() => {
        val peer = d3Drag.mod.drag[dom.SVGElement , Any ]()

        peer
        .onAvfwEvt("start", evt => {
          dom.console.debug(s"dragging started")
          processDragStartEvt(evt)
        } )
        peer
        .onAvfwEvt("drag", processDragMotionEvt )
        peer
        .onAvfwEvt("end", processDragReleaseEvt )

        new Selectable {
          ;

          val motionHostRefCb
          = ((receiver: d3Drag.mod.DragContainerElement ) => {
            peer.container(receiver)
          }).compose(sJsDomConvs.ofE andThen(_.asInstanceOf[d3Drag.mod.DragContainerElement] ) ).andThen(_ => {} )

          val motionSubjectRefCb
          = ((receiver: d3Drag.mod.DraggedElementBaseType ) => {
            d3Selection.mod.select(receiver) call(peer.toJsFunctionAll, js.undefined )
          }).compose(sJsDomConvs.ofE andThen(_.asInstanceOf[d3Drag.mod.DraggedElementBaseType] ) ).andThen(_ => {} )

          //
        }
      } , Nil )
    }

    (effectiveValue, (), dr, {
      new Selectable {
        val specifiedAtanDir = atanDir
      }
    } )
  }

  ;
}












