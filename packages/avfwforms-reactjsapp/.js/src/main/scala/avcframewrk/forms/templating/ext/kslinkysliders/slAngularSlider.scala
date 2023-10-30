package avcframewrk.forms.templating.ext.kslinkysliders












import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.std.{global as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageUsageUtil.FsWatch







val slinkyAngularSliderComponent
= {
  ;

  slinky.core.FunctionalComponent[SascWithValue._ForR[avcalculus.trig.Angular._Any ] ] ((props ) => {
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
            SascWithValue(value = value )
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

  slinky.core.FunctionalComponent[SascWithValue._ForR[avcalculus.trig.Angular._Any ] ] ((props ) => {
    ;

    val upstreamValue
    = props.value
    ;

    import slinky.web.html
    import slinky.web.svg
    ;

    val svx @ ((value ) *: _ *: ctrlOfDr *: _ )
    = {
      ;
      import avcalculus.{trig as tr }
      slascCore.useSv(upstreamValue , atanDir = (tr.west, tr.Angular.MomentaryDirection.Clockwise ) )
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
                  )
                ) ,

                /* ang-slider arrow graphics */
                {
                  ;
                  val e
                  = svg.path(
                    //
                    svg.style.:=((
                        js.Dynamic.literal(
                          //
                          cursor = "pointer" ,
                        )
                    ))
                    ,
                    svg.d := s"M 0 -0.1   L 1 -0.1   L 1 0.1   L 0 0.1   z " ,
                  ).build
                  svg.g(
                    //
                    e
                    .pipeLooseSelf(e => svg.g(svg.style := js.Dynamic.literal(fill = "#000" ) , e ) )
                    ,
                    e
                    .pipeLooseSelf(e => svg.g(svg.style := js.Dynamic.literal(fill = "#FFF" ) , e ) )
                    .pipeLooseSelf(e => svg.g(svg.transform := ((s: BigDecimal) => s"scale($s, $s)" )(0.375 ) , e) )
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













