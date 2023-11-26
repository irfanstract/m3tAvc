package avcframewrk.forms.templating.ext














import scalajs.js

import typings.{std as dom }

import com.raquo.airstream

import java.util.Locale















trait RcePkgPreMixinCreateElement
extends
AnyRef
{
   rce =>
   ;

   import avcframewrk.forms.templating.reactjs_s1.AvfwReactFunctionComponent

   export avcframewrk.forms.templating.reactjs_s1.ReactComponent1.implicits.asFunctionComp

   def describeFunctionComp
      [Props](f: js.Function1[Props, ReactElement | typings.react.mod.Component[?, ?, ?] ] )(using ValueOf[Unit] )
   = {
      f
      .asInstanceOf[AvfwReactFunctionComponent[Props ] ]
   }

   export avcframewrk.forms.templating.reactjs_s1.describeElement
   export avcframewrk.forms.templating.reactjs_s1.{describeElement as createElement }

   export avcframewrk.forms.templating.reactjs_s1.ReactElement

   ;
}

trait RcePkgPreMixinCreateHtmlNativeElementConvenience
extends
AnyRef
with RcePkgPreMixinCreateElement
{
   rce =>
   ;

   ;

   inline def newHtmlAttributes[T] = typings.react.mod.HTMLProps.apply[T]()

   def newHtmlGenericAttribs
   = newHtmlAttributes[dom.global.HTMLElement ]

   def newHtmlButtonAttribs
   = newHtmlAttributes[dom.HTMLButtonElement].setType("button")

   def newInlineCssProperties
   = typings.react.mod.CSSProperties()

   ;
}


















// val _ = {}
