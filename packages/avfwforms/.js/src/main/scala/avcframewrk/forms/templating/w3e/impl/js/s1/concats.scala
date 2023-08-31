package avcframewrk.forms

package templating

package w3e.impl.js

package s1

















trait ELaminarQckCoreHtmlConcatImpl
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Articles
   /* otherwise */
   with ELaminarQckCoreABackreferencings
{
   this : (
      AnyRef
      with ELaminarQckCore
      with ELaminarQckCoreHtml
      with w3e.pre.PlainTxtContents
      with ELaminarQckCoreABackreferencings
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   implicit val articleConcatenability
   : avcalg.CBC[Article]
   = {
      ;

      ;

      type SpawnedButton
         >: ln.ReactiveHtmlElement[? <: dom.HTMLElement]
         <: ln.ReactiveHtmlElement[? <: dom.HTMLElement]

      type SpawnedChildButton
         >: SpawnedButton
         <: SpawnedButton

      ;

      ;

      type EModel
      >: ConcatArtDat.CSqOps[Article]
      <: ConcatArtDat.CSqOps[Article]

      ;

      val aBackreferencings1
      : aBackreferencings.type
      = aBackreferencings

      val containingElementC
      : com.raquo.laminar.tags.HtmlTag[org.scalajs.dom.HTMLDivElement | org.scalajs.dom.HTMLSpanElement ]
      = laminar.api.L.div

      /**
       * the core/heart of the reconciler.
       * 
       * currently will only clear-and-recreate .
       * for true React-style reconciliation,
       * one should
       * consider the semantic list components instead
       * 
       */
      class XEAndStateBag() extends
            aBackreferencings1.XEAndStateBag(ec = { containingElementC })
      {
         ;

         import laminar.api.L

         ;

         override
         def close(): Unit = {
            closeAllOf((
               Seq()
               :+ labelRendPipe1
            ))
         }

         // TODO
         val labelRendPipe1
         = {
            ;
            L.child
            .startChildrenListUpdateNow((_: Any, item: ConcatArtDat.CSqOps[Article] ) => {
               containingElementC(
                  //
                  (
                     //
                     Seq()

                     // :+
                     // { L.styleAttr := s"background: yellow ; " }

                     :++

                     item
                     .map({
                        case ConcatArtDat.CSqItem(art) =>
                           art
                     })
                     .map(a => a.spawn() )

                  )
                  : _*
               )
            })
         }

         def model_=(e: EModel )
         : Unit
         = {
            ;

            // TODO
            // childInstantiatedList
            // = Seq(e.)
            labelRendPipe1
            .onNext({
               monix.reactive.Observable(
                  e,
               )
            })

            ;
         }

         ;
      }

      val reconciliability
      = {

         ;

         SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
            //
            spwImpl1 = (mdl : EModel ) => {
               val c = XEAndStateBag()
               c.model_=(mdl)
               c.wrappedLaminarElement
            }
            ,
            reconcImpl1 = (this1 : SpawnedButton, newModel) => {
               ;
               this1.avfwBackreferent[XEAndStateBag]
               .model_=(newModel )
            }
            ,
         )
         match { case s => {
            new
               SpawnabilityAndReconciliabilityNoArg[EModel, ({ type M[E] = E match { case SpawnabilityAndReconciliabilityNoArg[?, e, ?] => e } })#M[s.type ] , Unit]
               with ConcatArtDat.OperatorM
            { export s.* }
         } }
      }

      given acc
      : cats.Monoid[Article]
      with {

         ;
         def empty = {
            ;

            PlainLocaleStringPlainTxtArticle(
               java.util.Locale.ROOT.nn,
               "\u00A0" )
         }

         ;
         def combine(a1: Article, a2: Article) = {
            ;

            ;
            val s = {
               import ConcatArtDat.{CSqItem, CSqOps}
               (a1, a2) match {
                  case (ConcatArtDat(s1), ConcatArtDat(s2) ) =>
                     s1 ++ s2
                  case (ConcatArtDat(s1), si2 ) =>
                     s1 :+ CSqItem(si2 )
                  case (si1, ConcatArtDat(s2) ) =>
                     CSqItem(si1) +: s2
                  case (si1, si2 ) =>
                     (Seq() :+ si1 :+ si2 )
                     .map(art => CSqItem(art ) )
               }
            } : ConcatArtDat.CSqOps[Article]

            assert(2 <= s.length, s"failed to have (2 <= s.length ) ")

            ;
            (reconciliability, s ) : Article
         }

         ;
      }

      avcalg.given_CBC_C[Article]
   }

   // private
   // lazy val xHtmlAttr
   // = laminar.api.L.customHtmlTag("my-div")

   private[avcframewrk]
   // case class ConcatArtDat(d: ([E] =>> (List[E] | IndexedSeq[E] ) )[Article ] )
   object ConcatArtDat
   {
      ;

      type CSqOps[+E]
         >: Seq[CSqItem[E] ]
         <: Seq[CSqItem[E] ]

      opaque type CSqItem[+E]
         // <: (Unit, E)
         <: Matchable
         = (Unit, E)
      object CSqItem {
         def apply[E](v: E) : CSqItem[v.type] = ((), v )
         def unapply[E](o: CSqItem[E] ): Some[E] = Some(o._2 )
      }

      ;
      def unapply(a: Article)
      : Option[(CSqOps[Article] )]
      = {
         a match {
            case (o: OperatorM, d : CSqOps[Article] ) =>
               Some(d)
            case _ =>
               None
         }
      }

      sealed
      trait OperatorM

   }

}















val _ = {}
