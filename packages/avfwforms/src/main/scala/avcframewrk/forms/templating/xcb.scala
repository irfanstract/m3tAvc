package avcframewrk.forms

package templating

















object Xcb {

   /**
    * 
    * a TC
    * providing
    * impl(s) of
    * the factory-method(s) and infix-op(s)
    * forming part of an algebraic, immutable-only templating fw
    * 
    * the constituent(s)
    * - `CBC`, "monoid" -- defines `emptyInstance` and `plus`
    * - "concatenability", "semigroup" -- defines `plus`
    * 
    */
   given ProsingOpsImpl[
      E
      ,
   ](using DummyImplicit )
   (using concatenability :  avcalg.CBC[E] )
   (using quotes :  PlainTextQuotability[E] )
   (using nnq : ProperNounQuotability[E] )
   : AnyRef
   with {

      export concatenability.{empty as emptyExample }

      export concatenability.++
      export concatenability.plus

      locally {

         emptyExample ++ emptyExample ++ emptyExample

      }

      export quotes.*

      export nnq.*

   } // ProsingOpsImpl

} // Xcb$



















