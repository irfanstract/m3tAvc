













import scalajs.js

given asSelectable[T <: AnyRef | js.Any ]
: Conversion[T, reflect.Selectable ]
= reflect.Selectable.reflectiveSelectable(_)

import typings.{std as dom }















val _ = {}