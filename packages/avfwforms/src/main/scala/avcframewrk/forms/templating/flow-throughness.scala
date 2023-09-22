package avcframewrk.forms

package templating












/** 
 * 
 * across the practical examples of HTML/JSX templates,
 * applic(s) of the `&lt;a>` elem class
 * can be taken as "annotation" (ie assigning a URL-clickability to the designated sec of text ),
 * while
 * the contents of `&lt;button>`s tend to not be in-line with the surrounding content(s)
 * 
 * it'd be necessary to define whether 'the children of the element' shall be "through" or "skip"
 * - `through` : `I just got my sweater &lt;a> from the ... ... ... there &lt;/a> and it's ... ... . `
 * - `skip`    : `I just got my sweater from the ... ... ... there &lt;button> Check It Out &lt;/button> and it's ... ... . `
 * 
 */
opaque type FlowThroughMode
<: Matchable
= String

object FlowThroughMode
{
   ;

   /** 
    * expects nonlinearity
    * 
    */
   final
   lazy
   val forSkip
   = FlowThroughMode("skip")

   /** 
    * expects linearity
    * 
    */
   final
   lazy
   val forThroughness
   = FlowThroughMode("through")

   /** 
    * factory
    * 
    */
   @deprecated
   def apply
      (v: String)
   = fromStringCaseBoxing.apply(v)

   /** 
    * conv
    * 
    */
   @deprecated
   given fromStringCaseBoxing
   : Conversion[String, FlowThroughMode ]
   = identity[String] _

   ;

   ;
}











