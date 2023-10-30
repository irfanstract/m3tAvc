package avcframewrk.forms.templating.ext.kslinkysliders















export avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given }

// @annotation.experimental
def ??? = scala.Predef.???

import scalajs.js

given asSelectable[T <: AnyRef | js.Any ]
: Conversion[T, reflect.Selectable ]
= reflect.Selectable.reflectiveSelectable(_)

extension (callee: Any) def asJsDynamic = callee.asInstanceOf[js.Dynamic]

extension (callee: js.Function)
   @deprecated("this method is unsafe.")
   def toJsFunctionAll
      //
      [R]
   = callee.asInstanceOf[(
      callee.type
      & js.Function0[R]
      & js.Function1[Any, R]
      & js.Function2[Any, Any, R]
      & js.Function3[Any, Any, Any, R]
      & js.Function4[Any, Any, Any, Any, R]
      & js.Function5[Any, Any, Any, Any, Any, R ]
      & js.Function6[Any, Any, Any, Any, Any, Any, R ]
   )]

import typings.{std as dom }

object sJsDomConvs {
   ;
   val ofE     = (_ : org.scalajs.dom.Element      | typings.std.Element    ).asInstanceOf[org.scalajs.dom.Element     &  typings.std.global.Element ]
   val ofHtmlE = (_ : org.scalajs.dom.HTMLElement | typings.std.HTMLElement ).asInstanceOf[org.scalajs.dom.HTMLElement & typings.std.global.HTMLElement ]
}





export avcframewrk.forms.templating.reactjs.{
   //
   toConvertSlinkyElemToStReactElem ,
   toConvertSlinkyElemFromStReactElem ,
   toForceBuildSlinkyElem ,
}

lazy val _: Unit = {
   summon[toConvertSlinkyElemToStReactElem.type ]
}





extension [GElement, Datum, Subject] (receiver: typings.d3Drag.mod.DragBehavior[GElement, Datum, Subject] )
   transparent
   inline
   def onAvfwEvt
      (name: String, handler: (evt: typings.d3Drag.mod.D3DragEvent[GElement, Datum, Subject]) => Unit )
   : Unit
   = {
      receiver.asJsDynamic.on(name, handler )
   }















val _ = {}
