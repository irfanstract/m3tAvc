













import scalajs.js

given asSelectable[T <: AnyRef | js.Any ]
: Conversion[T, reflect.Selectable ]
= reflect.Selectable.reflectiveSelectable(_)

import typings.{std as dom }

@main
def runSMain(): Unit
= {
   ;

   println(s"hello!")
   ()

   locally {
      ;
      
      ;

      ({
         val r = {
            ;
            typings.reactDom.clientMod.createRoot({
               dom.global.document.querySelector[dom.Element ]("#app")
               .nn
            } )
         }
         // (typings.react.mod. )
         r
         .render((
            rce.describeElement(rce.example23._C , null )
         ))
      })
   }
}

object rce {
   ;

   import java.util.Locale

   /* don't use `typings.react.global.React` */
   ;

   export avcframewrk.forms.templating.reactjs.ReactComponent1

   export avcframewrk.forms.templating.reactjs.ReactWithinRender

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
         val undoAndRedoImpl = SelfContUndoRedoHook.useForT[String] (initialValue = "this is the field's initial value")
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















