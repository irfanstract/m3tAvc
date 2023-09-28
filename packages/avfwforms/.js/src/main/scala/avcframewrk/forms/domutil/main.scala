package avcframewrk.forms

package domutil













import org.scalajs.dom.*

extension (e: FocusEvent )
   def restoreFocus()
   = restoreFocusFor(e)

def restoreFocusFor(e: FocusEvent)
: Unit
= {
   e.target
   match {
      case e: HTMLElement =>
         e.focus()
      // case e: SVGElement =>
      //    e
   }
}













