














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
  avcframewrk.forms.templating.ext.kslinkysliders.slinkyAngularSlider
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
            ({
              ;

              val s0
              = 16 : BigDecimal

              val prec
              = 10 : BigDecimal

              svg.g(
                  //
                  svg.style :=
                    js.Dynamic.literal(transform = (
                        (Nil
                        :++ (
                          (( ) => (
                              ((scale: BigDecimal) => Nil :+ s"scale($scale, $scale)" )(1.0 / s0 )
                          ) )(  )
                        )
                        )
                        .mkString(" ")
                    ) )
                  ,
                  svg.g(
                    //

                    svg.style :=
                      js.Dynamic.literal(transform = (
                          (Nil
                          :++ (
                            (( ) => (
                              Nil
                                :+ s"translate(${s0 / 2 }px, ${s0}px ) "
                                :+ ((s: BigDecimal) => s"scale($s, $s)" )(1.0 / prec )
                            ) )(  )
                          )
                          )
                          .mkString(" ")
                      ) )
                    ,

                    // svg.text(
                    //   svg.fill := "white" ,
                    //   svg.fontSize := s"${2 * prec }px" ,
                    //   svg.fontFamily := "\"Inter\", system-ui" ,
                    //   svg.fontWeight := "550" ,
                    //   svg.textAnchor := "middle" ,
                    //   // svg.hor,
                    //   "IMAGZ" ,
                    // )
                    // ,
                  ) ,
                  svg.g(
                    //

                    svg.style :=
                      js.Dynamic.literal(transform = (
                          (Nil
                          :++ (
                            (( ) => (
                              Nil
                                :+ ((s: BigDecimal) => s"scale($s, $s)" )(1.0 / prec )
                            ) )(  )
                          )
                          )
                          .mkString(" ")
                      ) )
                    ,

                    svg.foreignObject(
                      //
                      svg.x := 0 ,
                      svg.y := 0 ,
                      svg.width := s"${s0 * prec }" ,
                      svg.height := s"${s0 * prec }" ,
                      html.div(
                        //
                        html.style := (
                          js.Dynamic.literal(
                            //
                            fontSize = s"${2 * prec }px"
                            ,
                            fontFamily = s"\"Inter\", system-ui"
                            ,
                            fontWeight = 550 ,
                            textAligh = "center" ,
                          )
                        ) ,
                        html.p(
                          //
                          "IMAGZ" ,
                        ) ,
                      )
                    ) ,
                  ) ,
              )
            })
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

