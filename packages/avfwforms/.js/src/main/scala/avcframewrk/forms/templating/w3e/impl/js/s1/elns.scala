package avcframewrk.forms

package templating

package w3e.impl.js

package s1


















/** 
 * 
 * narrows `Article` to the necessary sub-type.
 * 
 */
trait ELaminarQckCore
extends
   AnyRef
   with ELaminarQckCoreABackreferencings
   with w3e.pre.ArticlesViaLspw
   with ELaminarQckCore1
   with ELSRNA
   with ELaminarQckCoreWRE
   with ELF1
   // with w3e.pre.ArticlesViaLspwmt
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Articles
{
   this : (
      AnyRef
      with w3e.pre.Articles
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

   ;

   private[s1]
   def llByCco
      (counter : L.Source[Int])
      (using CCE )
   = {
      ;

      import L.{given}
      L.span((
         //
         L.child <-- (
         for { i <- counter.toObservable }
         yield llByCount(i)
         )
      ) )
   }

   private[s1]
   def llByCount
      (i : Int )
      (using CCE )
   = {
      ;

      import L.{given}
      (
         //

         L.span(s"[update-count: $i]", L.title :=
            s"update count: $i "
            .appendedAll(s". (${summon[CCE].callingMethodName } )")
         )
      )
   }

   inline given given_CCE_1[T0] : CCE = { val cmn = currentMethodName ; CCE(callingMethodName = cmn ) }
   case class CCE(callingMethodName: String)

   ;
}

/** 
 * 
 * narrows `Article` to the necessary sub-type.
 * 
 */
trait ELaminarQckCoreHtml
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with ELaminarQckCore
   /* the mix-ins */
   with ELaminarQckCoreReMppsHtml
{
   this : (
      AnyRef
      with ELaminarQckCore
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   override
   type Article
   >: LaminarSpawnable[ln.ReactiveHtmlElement[? <: dom.HTMLElement] , dom.HTMLElement ] | LaminarSpawnable[ln.ReactiveSvgElement[? <: dom.SVGElement] , dom.SVGElement ]
   <: LaminarSpawnable[ln.ReactiveHtmlElement[? <: dom.HTMLElement] , dom.HTMLElement ] | LaminarSpawnable[ln.ReactiveSvgElement[? <: dom.SVGElement] , dom.SVGElement ]

   ;
}

















val _ = {}
