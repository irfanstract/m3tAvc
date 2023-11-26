package avcframewrk.audioStudioForms.spclAnalysers










import avcalg.plsAndTlsAsImplicit.given_plsAndTls

import reflect.Selectable.reflectiveSelectable

import concurrent.duration.*

import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import cps.monads.jsfuture.JSFuture

import com.raquo.airstream

import avcframewrk.forms.templating.ext.airstreamify

import typings.{std as domItc }
import typings.std.{global as dom }


import avcframewrk.sMainModuleImplHelper.rce

import avcframewrk.forms.templating.reactjs.{
   //
   toConvertSlinkyElemToStReactElem ,
   toConvertSlinkyElemFromStReactElem ,
   toForceBuildSlinkyElem ,
}

import avcframewrk.forms.templating.ext.reactjsify
import avcframewrk.forms.templating.ext.slinkify







;

final
lazy val slinkyFrequencyTableAnalyser
= {
  ;

  object spclHooks {
    ;

    import slinky.core.facade.Hooks
    import slinky.web.html

    ;

    ;
  }

  type _Props
  >: (Map[? <: Double, Double ] , Unit)
  <: (Map[? <: Double, Double ] , Unit)

  val _C = {
    slinkify.publicly.ecl[_Props ] (props => {
        ;

        import slinky.core.facade.Hooks
        import slinky.web.html

        import avcframewrk.sMainModuleImplHelper.rce

        ;

        val d1 = {
          props._1
          .toIndexedSeq
          .zipWithIndex.map({
            case ((k, v), i ) =>
              js.Dynamic.literal(x = i, y = v, label = s"value at ${k }" )
          })
        }

        // val mainChartDoc
        // = {
        //   ;
        //   import typings.recharts
        //   ;
        //   rce.describeElement(
        //     rce.describeFunctionComp(recharts.mod.BarChart(_) ) , 
        //     (
        //       recharts.typesChartGenerateCategoricalChartMod.CategoricalChartProps()
        //       .setData(d1.asInstanceOf[js.Array[Any] ] )
        //     ) ,
        //     rce.describeElement(
        //       rce.describeFunctionComp(recharts.mod.Bar(_) ) ,
        //       (
        //         js.Object().asInstanceOf[recharts.typesCartesianBarMod.Props ]
        //       ) )
        //     ,
        //     ) 
        // }
        val mainChartDoc = {
          html.pre((
            //

            avcframewrk.fjsc.eval((
              s"""const date = ${js.Date() } ; console.info("current system time:", date ) ; date """
            ))
            .asInstanceOf[String ]
          ))
          .build
        }

        html.div((
          Nil
          :+ html.p("frequency-domain analysis")
          // :+ (
          //   typings.victory
          // )
          :+ (
            html.div(mainChartDoc )
          )
        )* )
        .build
    })
  }

  _C((Map.empty, () ) )
  .build
}





















