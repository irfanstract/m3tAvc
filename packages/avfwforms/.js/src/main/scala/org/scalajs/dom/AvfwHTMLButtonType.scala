package org.scalajs.dom












opaque type AvfwHTMLButtonType
<: Matchable & String
= String

object AvfwHTMLButtonType
{
   ;

   def apply(v: String)
   : AvfwHTMLButtonType
   = {
      val e = document.createElement("button").asInstanceOf[HTMLButtonElement]
      e.`type` = v
      v
   }

   ;
}













