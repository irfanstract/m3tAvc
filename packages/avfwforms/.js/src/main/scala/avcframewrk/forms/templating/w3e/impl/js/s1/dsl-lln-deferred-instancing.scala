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
      (s: ExtrOps ?=> AppliedS )
   : AppliedR

   type AppliedS
   >: ln.ReactiveElement[?]
   <: ln.ReactiveElement[?]

   type AppliedR
   <: Any

   protected
   trait ExtrOps
   {
      def render
         (r: AppliedR)
      : AppliedS
   }

   extension (src: Seq[AppliedR])
      def sumLd
         (using ELaminarIndirectionImpl.KTagSumCtx )
      : AppliedR
      = ???

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
         (s: ExtrOps ?=> AppliedS )
      : (AppliedR )
      = s(using ??? )

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
      // >: DlndDummyImplicit ?=> AppliedS
      // <: DlndDummyImplicit ?=> AppliedS
      = (DlndDummyImplicit) ?=> ln.ReactiveElement[?]

      override
      // transparent
      // inline
      def appliedTo
         //
         (s: ExtrOps ?=> AppliedS )
      // : (AppliedR )
      : (DlndDummyImplicit ?=> ln.ReactiveElement[?] )
      = (_: DlndDummyImplicit) ?=> {
         s(using (
            new ExtrOps {
               //
               override
               def render
                  (r: AppliedR)
               = r
            }
         ))
      }

      extension (src: Seq[AppliedR])
         override
         def sumLd
            (using ELaminarIndirectionImpl.KTagSumCtx )
         : AppliedR
         = ((dummyImplicit1 : DlndDummyImplicit) ?=> {
            import laminar.api.L
            import L.{given }

            (
               summon[KTagSumCtx ] ,
               src.map(e => e ) /* eval if not */ ,
            )
            match {
               case (EC(cls : com.raquo.laminar.tags.HtmlTag[ec] ) , ls ) =>
                  cls(ls.map(_.asInstanceOf[ln.ReactiveHtmlElement[?] ] ) : _* )
                  
               case (EC(cls : com.raquo.laminar.tags.SvgTag[ec] ) , ls ) =>
                  cls(ls.map(_.asInstanceOf[ln.ReactiveSvgElement[?] ] ) : _* )

               case e =>
                  throw
                     new IllegalArgumentException(new MatchError(e).getMessage() )
            }
         })

      ;
   } // cloneably.

   case class EC
      [+E <: ln.ReactiveElement.Base]
      (cls: com.raquo.laminar.tags.Tag[E] )

   opaque type KTagSumCtx
   <: EC[?]
   = EC[?]

   final
   lazy
   val KTagSumCtx
   : EC[?] => KTagSumCtx
   = identity[KTagSumCtx] _

   // opaque type KtConcatModeByR
   //    [-RU <: RL, +RL]
   // <: (
   //    ({ type R >: RL <: RU } , Function1[com.raquo.laminar.nodes.ChildNode[?], ?] ) {
   //       val _2
   //       : com.raquo.laminar.nodes.ChildNode[?] => _1.R
   //    }
   // )

   given DlndDummyImplicit(using util.NotGiven[noDlndDPlease.type] )
   : AnyRef with {}

   protected
   implicit object noDlndDPlease

   ;
} // ELaminarIndirectionImpl$
















val _ = {}
