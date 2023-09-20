package avcframewrk.forms

package templating

package w3e.impl.js

package s1


















/** 
 * 
 * sometimes,
 * you'll need the instantiation to be immediate,
 * but
 * some other times,
 * you'll need to defer it into being a 'template'
 * 
 * usage
 * ```
 * def implCreateMainNode
 *    (using ... ... )
 *    (... ... ... ... )
 *    (using givenELaminarIndirectionImpl : ELaminarIndirectionImpl )
 *    (using ... ... )
 * : givenELaminarIndirectionImpl.AppliedR
 * &eq; {
 *   ...
 *   ...
 *   givenELaminarIndirectionImpl.appliedTo {
 *     import laminar.api.L
 *     import L.{given }
 *     ;
 *     L.p("my paragraph about", ..., ..., ... ... )
 *   }
 * }
 * ```
 * 
 */
private[w3e]
opaque type ELaminarIndirection
<: AnyRef & ELaminarIndirectionImpl
= ELaminarIndirectionImpl

private[s1]
trait ELaminarIndirectionImpl
{
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   def appliedTo
      (s: => AppliedS )
   : AppliedR

   type AppliedS
   >: ln.ReactiveElement[?]
   <: ln.ReactiveElement[?]

   type AppliedR
   <: Any

   extension (lhs: AppliedR )
      def ++(rhs: AppliedR)
         (using ELaminarIndirectionImpl.KTag )
      : AppliedR

   ;
}

private[s1]
object ELaminarIndirectionImpl
{
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   @annotation.experimental
   object directly extends
   ELaminarIndirectionImpl
   {
      ;

      type AppliedS
      >: ln.ReactiveElement[?]
      <: ln.ReactiveElement[?]

      opaque type AppliedR
      <: AppliedS
      = AppliedS

      override
      // transparent
      // inline
      def appliedTo
         (s: => AppliedS )
      : (AppliedR )
      = s

      extension (lhs: AppliedR )
         def ++(rhs: AppliedR)
            (using ELaminarIndirectionImpl.KTag )
         : AppliedR
         = throw new UnsupportedOperationException

      ;
   }

   object cloneably extends
   ELaminarIndirectionImpl
   {
      ;

      type AppliedS
      >: ln.ReactiveElement[?]
      <: ln.ReactiveElement[?]

      type AppliedR
      // >: DummyImplicit ?=> AppliedS
      // <: DummyImplicit ?=> AppliedS
      = DummyImplicit ?=> ln.ReactiveElement[?]

      override
      // transparent
      // inline
      def appliedTo
         (s: => AppliedS )
      // : (AppliedR )
      : (DummyImplicit ?=> ln.ReactiveElement[?] )
      = s

      extension (lhs: AppliedR )
         def ++(rhs: AppliedR)
            (using tg: ELaminarIndirectionImpl.KTag )
         : AppliedR
         = {
            import laminar.api.L
            import L.{given }
            ???
         }

      ;
   } // cloneably.

   type KTag
   >: com.raquo.laminar.tags.HtmlTag[?]
   <: com.raquo.laminar.tags.HtmlTag[?]

   // opaque type KtConcatModeByR
   //    [-RU <: RL, +RL]
   // <: (
   //    ({ type R >: RL <: RU } , Function1[com.raquo.laminar.nodes.ChildNode[?], ?] ) {
   //       val _2
   //       : com.raquo.laminar.nodes.ChildNode[?] => _1.R
   //    }
   // )

   ;
} // ELaminarIndirectionImpl$
















val _ = {}
