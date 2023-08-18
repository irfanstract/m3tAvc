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


















val _ = {}
