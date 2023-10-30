package avcframewrk.forms.sMain.d1















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
extends
AnyRef
with RceCoreHooks
with RceAsyncAndFrpHooks
{
   rce =>
   ;

   import java.util.Locale

   /* don't use `typings.react.global.React` */
   ;

   export avcframewrk.forms.templating.reactjs_s1.ReactComponent1

   export avcframewrk.forms.templating.reactjs_s1.ReactProductEditComponent

   export avcframewrk.forms.templating.reactjs_s1.describeElement
   export avcframewrk.forms.templating.reactjs_s1.{describeElement as createElement }

   export avcframewrk.forms.templating.reactjs_s1.ReactElement

   export avcframewrk.forms.templating.reactjs_s1.ReactCtx

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

   def newHtmlGenericAttribs
   = newHtmlAttributes[dom.global.HTMLElement ]

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

   def newInlineCssProperties
   = typings.react.mod.CSSProperties()

   /** 
    * `<ul>` or `<ol>`, map each item
    * 
    * this method will automatically add boundary `<li>`s so
    * please avoid doing so within `renderItemContent`
    * 
    * whether ordered or unordered
    * will depend on whether `d` were `Seq` or `Set`
    * 
    */
   transparent inline
   def describeMappedItmListByKey
      //
      [
         K <: String | (Int | Long | Double )
         : Ordering
         ,
      ]
      (keys: collection.immutable.Iterable[K] )
      (renderItemContent: (key: K) => ReactElement )
   : ReactElement
   = {
      ;
      describeMappedItmListByKv({
         for (key <- keys )
         yield (key -> key )
      }) (renderItemContent )
   }

   /** 
    * `<ul>` or `<ol>`, map each item
    * 
    * this method will automatically add boundary `<li>`s so
    * please avoid doing so within `renderItemContent`
    * 
    * whether ordered or unordered
    * will depend on whether `d` were `Seq` or `Set`
    * 
    */
   def describeMappedItmListByKv
      //
      [
         K <: String | (Int | Long | Double )
         : Ordering
         ,
         V ,
      ]
      (d: collection.immutable.Iterable[(K, V)] )
      (renderItemContent: (value: V) => ReactElement )
   : ReactElement
   = {
      ;

      def describeChildLiElems
         //
         (children: Seq[(K, ReactElement)] )
      = {
         ;

         for {
            (childKey, child) <- children
         }
         yield {
            ;

            describeElement("li", (
               //
               newHtmlGenericAttribs
               .setKey({
                  childKey match
                  /* please ignore the "unreachable case" warnings -- they're false ones */
                  case v : String =>
                     v
                  case v : Double =>
                     v
                  case v : java.lang.Number =>
                     v.doubleValue()
               } : typings.react.mod.Key )
            ) , child )
         }
      }

      val knd
      = locally[Seq[(K, ReactElement)] => ReactElement ] {
         ;

         d match {
         //

         /** UNORDERED */
         case kvs @ (_ : collection.Set[e] ) =>
            ;

            children =>
               ;
               describeElement("ul", null, (
                  describeChildLiElems(children )
               ) : _* )
               
         /** ORDERED */
         case kvs @ (_ @ collection.Seq(_ @ _* ) ) =>
            ;

            children =>
               ;
               describeElement("ol", null, (
                  describeChildLiElems(children )
               ) : _* )

         /** playing safe by making it 'ordered', yet making it appear like 'unordered' one */
         case _ =>
            ;

            children =>
               ;
               describeElement("ol", (
                  //
                  newHtmlGenericAttribs
                  .setStyle({
                     newInlineCssProperties
                     .setListStyleType("disc" )
                  })
               ), (
                  describeChildLiElems(children )
               ) : _* )

         }
      }

      knd.apply((
         d
         .toSeq
         .sortBy((k, _) => k )
         .map((k, v) => {
            ;
            (k, renderItemContent(v) )
         })
      ))
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
