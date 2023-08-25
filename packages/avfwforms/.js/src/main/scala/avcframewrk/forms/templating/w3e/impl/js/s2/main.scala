package avcframewrk.forms

package templating

package w3e.impl.js

package s2

















import s1.{
   ebAll ,
   EbAndReconcilability ,
   EbButtons ,
}



final
lazy
val allDefsSjsImpl
= {

   object jsWindow {

      // export org.scalajs.dom.{
      //    Element ,
      // }

   }

   import ebAll.{*, given}

   {
      //

      new AnyRef
      with avcframewrk.forms.templating.w3e.pre.Articles
      with avcframewrk.forms.templating.w3e.pre.Buttons
      {

         override
         type Article
         >: SjsEOps
         <: SjsEOps

         override
         val Action
         : given_AcsfLabelledCallbackTranslator_Edsb.type
         = given_AcsfLabelledCallbackTranslator_Edsb

         override
         type Action
         >: ButtonOrAHrefDesc1
         <: ButtonOrAHrefDesc1

         ;
         type ButtonArt
            >: ButtonOrAHrefDesc
            <: ButtonOrAHrefDesc

         override
         def describeButtonByAction(action: Action)
         = {
            // TODO
            ButtonOrAHrefDesc(
               //
               desc = action
               ,
            )
         }

      }
   }
} // allDefsImpl$
























