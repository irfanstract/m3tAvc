package org.scalajs.dom












opaque type AvfwHTMLButtonType
<: Matchable & String
= String

object AvfwHTMLButtonType
{
   ;

   @annotation.targetName("BUTTON")
   final val ofCallbackButton = "button"

   @annotation.targetName("SUBMIT")
   final val ofSubmitButton = "submit"

   def apply(v: String)
   : AvfwHTMLButtonType
   = {
      val e = document.createElement("button").asInstanceOf[HTMLButtonElement]
      e.`type` = v
      v
   }

   ;
}

opaque type AvfwHTMLInputType
<: Matchable & String
= String

object AvfwHTMLInputType
{
   ;

   @annotation.targetName("CHECKBOX")
   final val ofCheckbox = "checkbox"

   @annotation.targetName("NUMBER")
   final val forNumbers = "number"

   @annotation.targetName("DATE")
   final val forDateInMonth = "date"

   def apply(v: String)
   : AvfwHTMLInputType
   = {
      val e = document.createElement("input").asInstanceOf[HTMLInputElement]
      e.`type` = v
      v
   }

   ;
}












