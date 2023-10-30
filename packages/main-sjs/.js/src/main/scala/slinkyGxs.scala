














import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.std.{global as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageUsageUtil.FsWatch













lazy val INTER = {
  dom.document.querySelector("head").asInstanceOf[dom.Element]
  .appendChild(dom.document.createElement("style") )
  .textContent_=({
    s"""
      @font-face {
        /* */
        font-family: "Inter" ;
        src: url("${
          val u
          = {
            ;
            avcframewrk.forms.assets.Inter_VariableFont_slnt_wght_ttf
          }
          u
        }") ;
      }  
    """.stripIndent().nn
  })
}

lazy val slinkyAngularSlider
= {
  ;
  ({
    ;
    val _C = {
        ;
        slinky.core.FunctionalComponent[(Unit, avcalculus.trig.Angular._Any ) ] ((props ) => {
          ;

          val () *: value *: _
          = props
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
                            s"rotate(${value.valueInDegrees }deg )"
                          ,
                      )
                    ) ,

                    svg.path(
                      //
                      svg.style.:=((
                          js.Dynamic.literal(
                            //
                            cursor = "pointer" ,
                          )
                      ))
                      ,
                      svg.fill := "#000",
                      svg.d := s"M 0 -0.1 L -1 -0.1 L -1 0.1 L 0 0.1 z " ,
                    ) ,
                ) ,
              )
              ,
          )
        } )
    }
    _C(((), avcalculus.trig.Angular.fromDegrees(value = 90 ) ) )
    .build
  })
  .asStReactElement
}

lazy val slinkyImagz
= {
  ;
  ({
    ;
    val _C = {
      ;
      slinky.core.FunctionalComponent[(Unit, avcalculus.trig.Angular._Any ) ] ((props ) => {
        ;

        val () *: value *: _
        = props
        ;

        import slinky.web.html
        import slinky.web.svg
        ;

        INTER

        val s0 : BigDecimal
        = 300
        svg.svg(
          //
          svg.style.:=((
            js.Dynamic.literal(
                //
                width = "50vw",
                height = "50vh",
                background = "black",
            )
          ))
          ,
          svg.viewBox.:=(s"0 0 ${s0} ${s0}")
          ,
          svg.g(
            //
            svg.style :=
                js.Dynamic.literal(transform = ((r: BigDecimal) => s"scale($r, $r)" )(s0 ) )
            ,
            svg.g(
                //
                svg.style :=
                  js.Dynamic.literal(transform = (
                      (Nil
                      :++ (
                        ((s0: BigDecimal) => (
                            ((scale: BigDecimal) => Nil :+ s"scale($scale, $scale)" )(1.0 / s0 )
                            :+ s"translate(${s0 / 2 }px, ${s0}px ) "
                        ) )(16 )
                      )
                      )
                      .mkString(" ")
                  ) )
                ,
                svg.text(
                  svg.fill := "white" ,
                  svg.fontSize := "2px" ,
                  svg.fontFamily := "\"Inter\", system-ui" ,
                  svg.textAnchor := "middle" ,
                  // svg.hor,
                  "IMAGZ" ,
                )
                ,
            )
            ,
          )
          ,
        )
      } )
    }
    _C(((), avcalculus.trig.Angular.fromDegrees(value = 90 ) ) )
    .build
  })
  .asStReactElement
}














val _ = {}

