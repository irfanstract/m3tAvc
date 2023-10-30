package avcframewrk.forms

package templating

package reactjs_s1













import scalajs.js

// export typings.react.mod.{createElement as describeElement }
export ceImpl.{apply as describeElement }
private
object ceImpl {
   ;
   import typings.react.mod.{*, given }
   inline def apply[P /* <: js.Object */](`type`: String                             , props: Attributes & P, children: ReactNode* ): ReactElement = createElement[P] (`type` = `type`, props = props, children = children : _* )
   inline def apply[P /* <: js.Object */](`type`: String                             , props: Null          , children: ReactNode* ): ReactElement = createElement[P] (`type` = `type`, props = props, children = children : _* )
   inline def apply[P /* <: js.Object */](`type`: ComponentClass[P, ComponentState ] , props: Attributes & P, children: ReactNode* ): ReactElement = createElement[P] (`type` = `type`, props = props, children = children : _* )
   inline def apply[P /* <: js.Object */](`type`: ComponentClass[P, ComponentState ] , props: Null          , children: ReactNode* ): ReactElement = createElement[P] (`type` = `type`, props = props, children = children : _* )
   inline def apply[P /* <: js.Object */](`type`: FunctionComponent[P]               , props: Attributes & P, children: ReactNode* ): ReactElement = createElement[P] (`type` = `type`, props = props, children = children : _* )
   inline def apply[P /* <: js.Object */](`type`: FunctionComponent[P]               , props: Null          , children: ReactNode* ): ReactElement = createElement[P] (`type` = `type`, props = props, children = children : _* )
}

type ReactChildren
= typings.react.mod.ReactNode

type ReactNode
= typings.react.mod.ReactNode

type ReactElement
= typings.react.mod.ReactElement

object ReactElement {
   ;

   ;

   opaque type FromCls[+C]
   <: ReactElement
   =  ReactElement

   ;
}

type ReactPropValueAny
>: Any
<: Any













val _ = {}