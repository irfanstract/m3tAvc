package avcframewrk.forms

package templating

package w3e













export allDefsSjsImpl.*

protected
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

         val Action
         = ???

         def describeButtonByAction(action: Action)
         = ???

      }
   }
} // allDefsImpl$

transparent inline
def typeable[T]
= {
   // summonHereNotInline[reflect.Typeable[T] ]
   summon[reflect.Typeable[T] ]
}












val _ = {}
