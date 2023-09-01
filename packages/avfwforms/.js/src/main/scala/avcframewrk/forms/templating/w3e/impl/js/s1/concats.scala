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
      >: ConcatArtDat.XItemSeqOps[Article]
      <: ConcatArtDat.XItemSeqOps[Article]

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
            .startChildrenListUpdateNow((_: Any, item: ConcatArtDat.XItemSeqOps[Article] ) => {
               containingElementC(
                  //
                  (
                     //
                     Seq()

                     // :+
                     // { L.styleAttr := s"background: yellow ; " }

                     :++

                     item
                        /* for now this discards any possible ordering-or-key info, but it's possible a future version will take it into the game  */
                        .map({
                           //

                           case ConcatArtDat.XItemSeqRow(art) =>
                              art

                        })

                        /* what's in hand is the 'template', not the ready-to-insert Laminar Node/Fragment. still, this should remain here around the end of the chain, however  */
                        .map((a: Article) => {
                           ;

                           a
                           .spawn()
                        } )

                        /* otherwise, adjacent components would take place without any space in-between, messing with legibility (eg "to get her" would collapse becoming "together" )  */
                        .flatMap(e => (Seq() :+ e :+ L.textToTextNode(" ") ) )

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
               (this1.avfwBackreferent1 : Any )
               match {
                  case s: XEAndStateBag =>
                     s model_=(newModel )
               }
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
            val finalSeq = {
               ;

               import ConcatArtDat.{XItemSeqRow, XItemSeqOps}

               (a1, a2) match {
                  //

                  case (ConcatArtDat(s1), ConcatArtDat(s2) ) =>
                     s1 ++ s2

                  case (ConcatArtDat(s1), si2 ) =>
                     s1 :+ XItemSeqRow(si2 )

                  case (si1, ConcatArtDat(s2) ) =>
                     XItemSeqRow(si1) +: s2

                  case (si1, si2 ) =>
                     (Seq() :+ si1 :+ si2 )
                     .map(art => XItemSeqRow(art ) )

               }
            } : ConcatArtDat.XItemSeqOps[Article]

            assert(2 <= finalSeq.length, s"failed to have (2 <= s.length ) ")

            ;
            (reconciliability, finalSeq ) : Article
         }

         ;
      }

      avcalg.given_CBC_C[Article]
   }

   // private
   // lazy val xHtmlAttr
   // = laminar.api.L.customHtmlTag("my-div")

   /**
    * 
    * an infrastructure to
    * impl the proper data-structures for these purposes
    * 
    */
   private[avcframewrk]
   object ConcatArtDat
   {
      ;

      type XItemSeqOps[+E]
         >: Seq[XItemSeqRow[E] ]
         <: Seq[XItemSeqRow[E] ]

      opaque type XItemSeqRow[+E]
         <: Matchable
         = (Unit, E)

      object XItemSeqRow {
         def apply[E](v: E) : XItemSeqRow[v.type] = ((), v )
         def unapply[E](o: XItemSeqRow[E] ): Some[E] = Some(o._2 )
      }

      ;

      /**
       * this
       * is intended to do the inverse of the implicit conv to `Article`
       * 
       */
      def unapply(a: Article)
      : Option[(XItemSeqOps[Article] )]
      = {
         a match {
            case (o: OperatorM, d : XItemSeqOps[Article] ) =>
               Some(d)
            case _ =>
               None
         }
      }

      /**
        * 
        */
      sealed
      trait OperatorM

   } // ConcatArtDat$

}















val _ = {}
