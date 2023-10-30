













import scalajs.js

import typings.{std as dom }

import com.raquo.airstream

import java.util.Locale

;

;

;
object rce
extends
AnyRef
with RceEssentials
with RceUndoAndRedoEssentials
{
   ;

   ;

   ;
}

trait RceEssentials
{
   rce =>
   ;

   import java.util.Locale

   /* don't use `typings.react.global.React` */
   ;

   export avcframewrk.forms.templating.reactjs.ReactComponent1

   export avcframewrk.forms.templating.reactjs.ReactWithinRender

   export avcframewrk.forms.templating.reactjs.renderfncs.AvfwDependenciesArray

   export typings.react.mod.{
      createContext ,
   }

   export avcframewrk.forms.templating.reactjs.describeElement
   export avcframewrk.forms.templating.reactjs.{describeElement as createElement }

   inline def newHtmlAttributes[T] = typings.react.mod.HTMLProps.apply[T]()

   lazy val example1 = (
      rce.createElement("div", null, (
         Seq()
         :+ rce.createElement("p", null, "hello!" )
         // :+ rce.createElement("a", scalajs.js.Dictionary(("href", "javascript:console.log(\"opening the tutorial...\")" )), "consider reading the tutorial for more abt it." )
         :+ (
            rce.createElement(
               "a",
               rce.newHtmlAttributes[dom.HTMLAnchorElement ].setHref("javascript:console.log(\"opening the tutorial...\")" ) ,
               "consider reading the tutorial for more abt it." ,
            )
         )
      ) : _* )
   )

   def newHtmlButtonAttribs
   = newHtmlAttributes[dom.HTMLButtonElement].setType("button")

   object example2 {
      ;

      lazy val _C
      = ReactComponent1.describe((_: Any ) => {
         ;
         val (value, updateValue ) = ReactWithinRender.StateHook.useInitially(??? : Int, 5 )
         (
            describeElement("div", null, (
               Seq()
               :+ describeElement("p", null, "redo!" )
               :+ describeElement("p", null, s"value: $value " )
            ) : _* )
         )
      })

   }

   def useJsFuture
      //
      [Value ]
      (getSrc: js.Function0[js.Promise[Value] ], initialValue: Value, unit1: Unit, dependencies1: AvfwDependenciesArray )
   : Value
   = {
      ;

      useRaqueFrpState[Value] (() => {
         ;

         val pr
         = getSrc()

         airstream.core.EventStream.fromJsPromise(pr )
         .startWith[Value] (initialValue)
      } , dependencies1 )
   }

   def useRaqueFrpState
      //
      [Value ]
      (getSrc: js.Function0[airstream.core.Signal[Value] ], dependencies1: AvfwDependenciesArray )
   : Value
   = {
      val Tuple2(s, updateS)
      = ReactWithinRender.StateHook.useWithInitialValue[Value] ({
         // TODO
         getSrc()
         .observe(using airstream.ownership.ManualOwner() )
         .now()
      })
      useRaqueFrpStateUpdateEvents
         [Value]
         (getSrc, dependencies1 )
         (computeNextState => updateS((v) => computeNextState(v) ) )
      s
   }

   def useRaqueFrpStateUpdateEvents
      //
      [Value ]
      (getSrc: js.Function0[airstream.core.Signal[Value] ], dependencies1: AvfwDependenciesArray )
      (updateS : (computeNextState: (priorState: Value) => Value) => Unit )
   : Unit
   = {
      import ReactWithinRender.implicits.{*, given}
      ReactWithinRender.Efb.doneByFnc1((_: Product) => {
         ;
         val o
         = airstream.ownership.ManualOwner()
         val s
         = {
            getSrc()
            .map(newValue => {
               updateS(computeNextState = (_: Value) => newValue )
            } : Unit)
            .observe(using o)
         }
         locally[java.io.Closeable](() => o.killSubscriptions() )
      }, dependencies = dependencies1 )
      // .useReSubscriptiveEffectHook(onEvtDispatchMdWhen = {
      //    // ReactWithinRender.EffectHook._When.Deferredly()
      //    ???
      // } )
      .pipeLooseSelf(b => {
         ReactWithinRender.implicits.useReSubscriptiveEffectHook(b)(onEvtDispatchMdWhen = {
            ReactWithinRender.EffectHook._When.Deferredly()
            // ???
         } )
      })
   }

   ;
}

trait RceUndoAndRedoEssentials
{
   rce : (
      RceEssentials
   ) =>
   ;

   ;

   object SelfContUndoRedoHook {
      ;

      import avcframewrk.forms.documentstatemgmt.UndoAndRedo

      ;

      def useForT
         [T <: Matchable ]
         (initialValue: T )
         (using em: (
            UndoAndRedo.SpecialFpCcOps._FiniteModeInstance
         ) )
      = {
         new AnyRef with Selectable {
            ;

            ;

            // val em
            // = UndoAndRedo.SpecialFpOps.forPairOfConstLl[T]

            ;

            val (evs, updateEVs )
            = ReactWithinRender.StateHook.useInitially(??? : em.OperatedMdlStateSetCc[String ], em.initiallyWith(initialHeadState = initialValue ) )

            ;

            val redoBtn = (
               //

               describeElement(
                  "button", newHtmlButtonAttribs.setOnClick(evt => { updateEVs(s => s.afterRedoBy() ) } ) ,
                  s"redo (${evs.successiveStateHist.length })" )
            )

            val undoBtn = (
               //

               describeElement(
                  "button", newHtmlButtonAttribs.setOnClick(evt => { updateEVs(s => s.afterUndoBy() ) } ) ,
                  s"undo (${evs.precedingStateHist.length })" )
            )

            def presentlyState
            = evs.presentlyState

            ;
         }
      }

   }

   object example23 {
      ;

      given avcframewrk.forms.documentstatemgmt.UndoAndRedo.SpecialFpCcOps._FiniteModeInstance
      = avcframewrk.forms.documentstatemgmt.UndoAndRedo.SpecialFpCcOps.gv.forPairOfConstLl

      lazy val _C
      = ReactComponent1.describe((_: Any ) => {
         ;
         import avcframewrk.forms.documentstatemgmt.UndoAndRedo
         val undoAndRedoImpl = SelfContUndoRedoHook.useForT[String] (initialValue = "this is the field's initial value, and then")
         import undoAndRedoImpl.{evs, updateEVs }
         import undoAndRedoImpl.{presentlyState }
         import undoAndRedoImpl.{undoBtn, redoBtn }
         (
            describeElement("div", null, (
               Seq()
               :+
               describeElement(
                  "p", null, s"value: ${presentlyState } " )
               :+
               describeElement(
                  "nav", null, (
                     Seq()
                     :+
                     undoBtn
                     :+
                     redoBtn
                  ) : _* )
               :+
               describeElement(
                  "button",
                  newHtmlButtonAttribs
                  .setOnClick(evt => {
                     val dateTimeStr
                     = dom.global.Date.apply()
                     updateEVs(s => {
                        s
                        .withClearedRedoStateSeq(Seq(s"date-time: $dateTimeStr ") )
                        .afterRedoBy()
                     } )
                  } )
                  ,
                  s"edit" )
            ) : _* )
         )
      })

   }

   ;
}

;















val _ = {}
