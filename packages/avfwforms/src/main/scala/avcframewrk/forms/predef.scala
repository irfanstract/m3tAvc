package avcframewrk.forms
















/**
 * 
 * `C`, supposed to be a type-lmd.
 * 
 * ```
 * type ItsAllocator
 *    >: LC[ [c &lt;: InstanceOf[Bar] ] =>> (.....) ]
 *    &lt;: LC[ [c &lt;: InstanceOf[Bar] ] =>> (.....) ]
 * ```
 * 
 * didn't work as supposed to
 * 
 */
@deprecated("this didn't work as expected.")
type TL[C <: AnyKind]
   = C

export avcframewrk.forms.math.CSingleton

export avcframewrk.forms.math.InstanceOf

/**
 * 
 * a *safe* factory for imperative-style `TypeTest`(s)
 * 
 */
object ReopaquativeTypeTest
{
   ;

   def apply
      [BaseT <: Matchable : reflect.Typeable ]
      (implConforms: BaseT => Boolean )
   = {
      ;

      object I {
         ;

         opaque type Instance
         <: Matchable
         = BaseT

         def unapply(v: BaseT )
         : Option[v.type & Instance]
         = {
            Some[v.type](v)
            .filter(v => implConforms(v) )
         }

      }

      {
         ;

         new reflect.TypeTest[Any, I.Instance]
         {
            ;

            override
            def unapply(x: Any)
            : Option[x.type & I.Instance ]
            = {
               Some[x.type ](x)
               .collect({ case I(x1: x.type) => x1 })
            }

            ;
         }
      }
   }

   ;
} // ReopaquativeTypeTest$

@deprecated("you should avoid doing it.")
final
lazy val PretendNonExperimental
: PNE.type
= PNE

protected
object PNE {

   def apply[R](c: NoArgCallbackOps[R] )
   : R
   = {
      (c.asInstanceOf[{ def apply(): R }] )
      match { case cb => import reflect.Selectable.reflectiveSelectable ; cb.apply() : R }
   }

   trait NoArgCallbackOps[+R] {

      @annotation.experimental
      def apply()
      : R

   }

}

/**
 * 
 * `summonInlineForAutoBundling`
 * 
 */
private[forms]
transparent inline
def summonInlineForAutoBundling[R]
: R
= {
   compiletime.summonFrom { case op : R => op ; case _ => compiletime.error("failed to resolve ; make sure the 'given' exists in-scope . " + compiletime.codeOf(??? : R ) ) }
}

protected[forms]
type LexicalAsynchronicity
   = avcframewrk.forms.math.LexicalImperativeSynchronicityGiven.ByCcBeingAny

protected[forms]
object LexicalAsynchronicity {

   //

} // LexicalAsynchronicity$

/**
 * 
 * UTF data repr
 * 
 */
opaque type Utf
   <: AnyRef & Matchable
   = String

object Utf
{

   //

   /**
    * 
    * from given String.
    * 
    * to be called automatically when given plain String literals.
    * 
    */
   implicit 
   def apply(value: String )
   : Utf
   = value

   extension (c: Utf )
      /**
       * 
       * the full-length content
       * 
       */
      def toString1
      : String
      = c

} // Utf$


















val _ = {}
