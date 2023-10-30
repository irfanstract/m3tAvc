package avcframewrk.forms.templating.ext.kslinkysliders












import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.std.{global as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageObj.watcher.ext.toStartSomeNodeFrp.FsWatch







val slinkyAngularSliderComponent
= {
  ;

  slinky.core.FunctionalComponent[SascWithValueAndOnChange._ForR[avcalculus.trig.Angular._Any ] ] ((props ) => {
    ;

    val value
    = props.value
    ;

    import slinky.web.html
    import slinky.web.svg
    ;

    val s0 : BigDecimal
    = 100
    svg.svg(
        //
        svg.style.:=((
          js.Dynamic.literal(
              //
              width = "2em",
              height = "2em",
              // background = "black",
          )
        ))
        ,
        svg.viewBox.:=(s"-$s0 -$s0 ${2 * s0} ${2 * s0}")
        ,
        svg.g(
          //
          svg.style.:=((
              js.Dynamic.literal(
                //
                transform =
                    ((r: BigDecimal) => s"scale($r, $r)" )(s0 )
                ,
              )
          ))
          ,
          slinkyAngularSliderRadComponent((
            props
          ))
          .build
          ,
        )
        ,
    )
  } )
}

val slinkyAngularSliderRadComponent
= {
  ;

  slinky.core.FunctionalComponent[SascWithValueAndOnChange._ForR[avcalculus.trig.Angular._Any ] ] ((props ) => {
    ;

    val upstreamValue
    = props.value
    ;

    val propagateNewValueEvt
    = props.onChange

    import slinky.web.html
    import slinky.web.svg
    ;

    val svx @ ((value ) *: _ *: ctrlOfDr *: _ )
    = {
      ;
      import avcalculus.{trig as tr }
      slascCore.useSv(
        //
        upstreamValue ,
        atanDir = (tr.west, tr.Angular.MomentaryDirection.Clockwise ) ,
        onChange = e => {
          propagateNewValueEvt(e)
        } ,
      )
    }

    ;

    svg.g(
        //
        svg.g(
          //
          svg.circle(
              //
              svg.style.:=((
                js.Dynamic.literal(
                    //
                )
              ))
              ,
              svg.fill := "#202020",
              svg.cx :=(0) ,
              svg.cy :=(0) ,
              svg.r :=(1) ,
          ) ,
          svg.circle(
              //
              svg.style.:=((
                js.Dynamic.literal(
                    //
                )
              ))
              ,
              svg.fill := "#808080",
              svg.cx :=(0) ,
              svg.cy :=(0) ,
              svg.r :=(0.9) ,
          ) ,
          svg.g(
              //
              svg.style := (
                js.Dynamic.literal(
                    //
                    transform =
                      s"rotate(${
                        value
                        .pipeLooseSelf(svx._4.specifiedAtanDir.forwardTransformToIeeeSpace(_) )
                        .valueInDegrees
                      }deg )"
                    ,
                )
              ) ,

              svg.g(
                //
                svg.style := (
                  js.Dynamic.literal(
                      //
                      transform =
                        s"translate(-1px, 0px)"
                      ,
                      cursor = "pointer" ,
                  )
                ) ,

                svg.circle(
                  //
                  svg.style := (
                    js.Dynamic.literal(
                      //
                      fill = "rgba(0, 0, 0, 0.03 )"
                      ,
                      r = 0.7 ,
                      cy = 0 ,
                      cx = 0.5 ,
                    )
                  ) ,
                )
                ,

                /* ang-slider arrow graphics */
                {
                  ;

                  val unitSizedNeedleRect
                  = svg.path(
                    //
                    svg.style.:=((
                        js.Dynamic.literal(
                          //
                        )
                    ))
                    ,
                    svg.d := s"M 0 -0.1   L 1 -0.1   L 1 0.1   L 0 0.1   z " ,
                  ).build

                  // def scaledNeedleRect
                  // = locally[(scl: BigDecimal) => (slinky.core.facade.ReactElement) ] ((scl) => (
                  //   svg.g(svg.transform := ((s: BigDecimal) => s"scale($s, $s)" )(scl ) , e )
                  // ))

                  ;

                  svg.g(
                    //
                    unitSizedNeedleRect
                    .pipeLooseSelf(e => svg.g(svg.style := js.Dynamic.literal(fill = "#000" ) , e ) )
                    ,
                    unitSizedNeedleRect
                    .pipeLooseSelf(e => svg.g(svg.transform := ((s: BigDecimal) => s"scale($s, $s)" )(0.575 ) , e) )
                    .pipeLooseSelf(e => svg.g(svg.style := js.Dynamic.literal(fill = "rgba(0, 192, 255, 0.5)" ) , e ) )
                    ,
                    unitSizedNeedleRect
                    .pipeLooseSelf(e => svg.g(svg.transform := ((s: BigDecimal) => s"scale($s, $s)" )(0.475 ) , e) )
                    .pipeLooseSelf(e => svg.g(svg.style := js.Dynamic.literal(fill = "rgba(0, 192, 255, 1)" ) , e ) )
                    ,
                    unitSizedNeedleRect
                    .pipeLooseSelf(e => svg.g(svg.transform := ((s: BigDecimal) => s"scale($s, $s)" )(0.375 ) , e) )
                    .pipeLooseSelf(e => svg.g(svg.style := js.Dynamic.literal(fill = "#FFF" ) , e ) )
                    ,
                  )
                  .build
                }
                ,
              ),

          )
          .pipeLooseSelf(e => {
            svg.g(svg.ref.:=[svg.g.tag.type ] (ctrlOfDr.motionSubjectRefCb) , e )
          })
          .pipeLooseSelf(e => {
            svg.g(svg.ref.:=[svg.g.tag.type ] (ctrlOfDr.motionHostRefCb) , e )
          })
          .build
          ,
        )
        ,
    )
  } )
}

@deprecated
lazy val slinkyAngularSlider
= {
  ;
  ({
    ;
    val _C = {
        ;
        slinkyAngularSliderComponent
    }
    _C(((), avcalculus.trig.Angular.fromDegrees(value = 90 ) ) )
    .build
  })
  .asStReactElement
}













