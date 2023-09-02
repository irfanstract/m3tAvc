package avcframewrk.forms

















opaque type CSS
= String

extension (v: CSS )
   def toCSSString()
   : String
   = v

@deprecated("this Conversion does not run any validation.")
given Conversion[String, CSS ]
= identity[String] _

def addGlobalCss
  (addend: CSS )
: Unit
= {

   import org.scalajs.dom

   val c = dom.document.createElement("style")
   dom.document.head
   .appendChild(c )

   c.textContent = addend.toCSSString()

   ;
}











val _ = {}
