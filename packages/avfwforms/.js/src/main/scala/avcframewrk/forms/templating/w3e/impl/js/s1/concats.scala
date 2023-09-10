package avcframewrk.forms

package templating

package w3e.impl.js

package s1

















trait ELaminarQckCoreHtmlConcatImpl
extends
   AnyRef
   with ELaminarQckCoreHtmlConcatImplPre
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Articles
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreABackreferencings
   with ELaminarQckCoreFailsafeReconcilers
{
   this : (
      AnyRef
      with ELaminarQckCore
      with ELaminarQckCoreHtml
      with w3e.pre.PlainTxtContents
      with ELaminarQckCoreABackreferencings
      with ELaminarQckCoreFailsafeReconcilers
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

      ;

      ;

      val cc
      = {
         ;
         new XArticularSeqModeller(
            //
         )
      }
      val spws
      = {
         ;
         new XArticleSpwDefs(
            //
            s = cc ,

            containingElementC = laminar.api.L.div
            ,
         )
      }

      import cc.{*, given}

      import spws.{*, given}

      ;

      object lll {
         org.scalajs.dom.console.log({ class LllError extends Exception ; new LllError } )
      }

      extension (src: laminar.api.L.Signal[ConcatArtDat.XItemSeqOps[Article] ] ) {
         //

         // TODO
         /** 
          * `scanLeft`, where
          * each item is `collection.immutable.Iterable` (rather than single),
          * plus
          * reconciliation
          * 
          */
         def scanLeftReconcilingEachAll()
         // : Signal[Seq[ln.ReactiveHtmlElement[dom.HTMLElement ] ] ]
         = {
            ;

            import laminar.api.L

            import com.raquo.laminar.{nodes as ln}

            import org.scalajs.dom

            import L.{given}

            ;

            src

            .scanLeft[(
               ConcatArtDat.XItemSeqOps[Article]
               ,
               ([A] =>> A )[(Seq[ln.ReactiveHtmlElement[dom.HTMLElement ] ] ) ]
               ,
               L.Signal[Option[Unit] ] /* the return-type of `.toWeakSignal` in Airstream */
               ,

            ) ](arts => {
               ;
               val nds = {
                  ;

                  arts
                  .map({ case ConcatArtDat.XItemSeqRow(item) => item })
                  .map(_.spawn() ) 
               }
               (arts, nds, L.Val(Some(() ) ) )
            } )({
               case ((formerArtLs, nodes0, _), newArtLs) =>
                  ;

                  /* will conditionally reuse the existing LN(s) */
                  ;

                  val ndsRefAnim
                  = {
                     ;

                     /** 
                      * due to potential usage of arrow-fnc(s) in code,
                      * we can no longer rely on simply comparing with `equals`
                      */
                     /* no, we don't wanna migrate to `util.Boundary`, it has that well-known serious pitfall */
                     (util.control.NonLocalReturns.returning[Seq[ln.ReactiveHtmlElement[dom.HTMLElement ] ] ] {r1 ?=> {
                        ;

                        ;

                        if (newArtLs.length == nodes0.length ) then {
                           ;
                           r1.throwReturn({
                              ;
                              newArtLs.indices
                              .map(i => (i, nodes0(i), newArtLs(i) ) )
                              .map({ case (i, nd, newMdl) => {
                                 ;
                                 // TODO
                                 (???)
                              }})
                           })
                        }

                        ;
                        // TODO
                        newArtLs
                        .map({ case ConcatArtDat.XItemSeqRow(v) => v.spawn() } )
                     }})
                  }

                  (newArtLs, ndsRefAnim, L.EventStream.delay(2000 ).toWeakSignal )
            })
            .flatMap({ case (newArtLs, nds, s ) => {
               s.map(o => o.fold(Seq(L.span("loading...") ) )(_ => nds ) ) 
            } })
         }

         //
      }

      /**
       * the core/heart of the _aggregate_ reconciler.
       * (per-item reconciler(s) will be separate impl )
       * 
       * currently will only clear-and-recreate .
       * for true React-style reconciliation,
       * one should
       * consider the semantic list components instead
       * 
       */
      class XAggregateEAndStateBag() extends
            aBackreferencings.XEAndStateBag(ec = { containingElementC })
      {
         ;

         import laminar.api.L

         import com.raquo.laminar.{nodes as ln}

         import org.scalajs.dom

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
         : L.Observer[AsyncStateChangeMonad[ConcatArtDat.XItemSeqOps[Article] ] ]
         = {
            ;
            val stv = L.Var[AsyncStateChangeMonad[ConcatArtDat.XItemSeqOps[Article] ] ](L.Val(Seq() ) )
            ;
            wrappedLaminarElement
            .amend(({
               ;
               import laminar.api.L
               import L.{given}
               ;
               L.children
               .<--({
                  // TODO
                  stv.signal
                  .map(_.toLaminarObservable )
                  .flatten
                  .scanLeftReconcilingEachAll()
                  .map(e => e )
               })
            }))
            ;
            ;
            stv.writer
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
               laminar.api.L.Val(e)
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
               val c = XAggregateEAndStateBag()
               c.model_=(mdl)
               c.wrappedLaminarElement
            }
            ,
            reconcImpl1 = (this1 : SpawnedButton, newModel) => {
               ;
               this1.avfwBackreferent[XAggregateEAndStateBag]
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

}

trait ELaminarQckCoreHtmlConcatImplPre
extends
   AnyRef
   /* otherwise */
   with ELaminarQckCoreABackreferencings
{
   this : (
      AnyRef
      with w3e.pre.Articles
      // with ELaminarQckCore
      // with ELaminarQckCoreHtml
      with w3e.pre.PlainTxtContents
      with ELaminarQckCoreABackreferencings
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom


   ;

   ;

   ;

   ;

   // TODO
   class XArticularSeqModeller
      // []
      (
         //
      )
   {
      ;

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

      ;

      type EModel
      >: ConcatArtDat.XItemSeqOps[Article]
      <: ConcatArtDat.XItemSeqOps[Article]

      ;

      ;

      ;
      ;
   }

   class XArticleSpwDefs(
      private
      val s : XArticularSeqModeller
      ,

      val containingElementC
      : com.raquo.laminar.tags.HtmlTag[org.scalajs.dom.HTMLDivElement | org.scalajs.dom.HTMLSpanElement ]
      ,

      //
   )
   {
      ;

      import s.{*, given}

      ;

      type SpawnedButton
         >: ln.ReactiveHtmlElement[? <: dom.HTMLElement]
         <: ln.ReactiveHtmlElement[? <: dom.HTMLElement]

      type SpawnedChildButton
         >: SpawnedButton
         <: SpawnedButton

      ;
   }

   // private
   // lazy val xHtmlAttr
   // = laminar.api.L.customHtmlTag("my-div")

   ;
}















val _ = {}