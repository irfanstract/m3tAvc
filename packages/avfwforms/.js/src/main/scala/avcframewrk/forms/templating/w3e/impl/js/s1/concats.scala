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

      import articleConcatenabilityNs.{*, given }

      ;

      ;

      avcalg.given_CBC_C[Article]
   }

   private[s1]
   object articleConcatenabilityNs
   {
      ;

      ;

      // final
      // lazy
      val cc
      = {
         ;
         new XArticularSeqModeller(
            //
         )
      }
      // final
      // lazy
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

      // export cc.ConcatArtDat

      import XAspwPredefs.{*, given}

      import spws.{*, given}

      import thematicLaminarUtil.{*, given }

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
            >: Seq[XItemSeqRowWithValue[E] ]
            <: Seq[XItemSeqRowWithValue[E] ]

         opaque type XItemSeqRow[+E]
         <: Matchable
         = (Unit, E)

         object XItemSeqRow

         opaque type XItemSeqRowWithValue[+E]
            <: Matchable & XItemSeqRow[E]
            = (Unit, E)

         object XItemSeqRowWithValue
         {
            @deprecated
            def apply[E](v: E) : XItemSeqRowWithValue[v.type] = ((), v )
            def unapply[E](o: XItemSeqRowWithValue[E] ): Some[E] = Some(o._2 )
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
               case LaminarSpawnableReconcFromTuple((`reconciliabilityKey`, d : XItemSeqOps[Article] )) =>
                  Some(d)
               case _ =>
                  None
            }
         }

      } // ConcatArtDat$

      type EModel
      >: ConcatArtDat.XItemSeqOps[Article]
      <: ConcatArtDat.XItemSeqOps[Article]

      ;

      val artSpwCrosReconcOption1
      = {
         summon[SpawnabilityAndReconciliabilityNoArg[Article, ?, ? ] ]
         match { case e => e.asTypeTupelified }
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

            extension [R] (src: ConcatArtDat.XItemSeqOps[R] ) {
               def convR()
               = {
                  src
                  .map({ case ConcatArtDat.XItemSeqRowWithValue(item) => item })
               }
            }

            type UnitValuedWeakSignal
            >: L.Signal[Option[Unit] ] /* the return-type of `.toWeakSignal` in Airstream */
            <: L.Signal[Option[Unit] ] /* the return-type of `.toWeakSignal` in Airstream */

            type XScanStateBag
            >: (
               ConcatArtDat.XItemSeqOps[Article]
               ,
               ([A] =>> A )[(
                  Seq[(
                     // SpawnedArtReconcilerAndStateBagPairToLL[ln.ReactiveElement[dom.Element ] ]
                     artSpwCrosReconcOption1._1.Reconcilee
                  )] 
               ) ]
               ,
               UnitValuedWeakSignal
               ,
            )
            <: (
               ConcatArtDat.XItemSeqOps[Article]
               ,
               ([A] =>> A )[(
                  Seq[(
                     // SpawnedArtReconcilerAndStateBagPairToLL[ln.ReactiveElement[dom.Element ] ]
                     artSpwCrosReconcOption1._1.Reconcilee
                  )] 
               ) ]
               ,
               UnitValuedWeakSignal
               ,
            )

            extension (e: Article )
               def spawnArtFromScratch() = { artSpwCrosReconcOption1._2.spawn(e )( ) match { case e => e } }

            def tryReconcile
               (nd: artSpwCrosReconcOption1._1.Reconcilee )
               (newMdl : Article )
            = {
               ;

               def test1()
               = {
                  util.Try {}
               }

               (for {
                  tr <- {
                     test1()
                     /** note: `util.Try` only catches 'the non-fatal ones', including all these */
                     util.Try({
                        if { artSpwCrosReconcOption1._2.model_=(nd)(newMdl ) } then {}
                        else { throw new ReconciliativeClassMismatchException(s"not matching: ${nd } vs ${newMdl } " ) }
                     })
                     match {
                        case util.Failure(z : (ClassCastException | MatchError | ReconciliativeClassMismatchException ) ) =>
                           None
                        case util.Failure(z ) =>
                           throw z
                        case util.Success(() ) =>
                           Some(() )
                     }
                  }
               } yield {
                  nd
               })
            }

            src

            .scanLeft[XScanStateBag ](arts => {
               ;
               ;
               val nds = {
                  ;

                  arts
                  .convR()
                  .map(e => { e.spawnArtFromScratch() } ) 
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
                     (util.control.NonLocalReturns.returning[Seq[artSpwCrosReconcOption1._1.Reconcilee ] ] {r1 ?=> {
                        ;

                        ;

                        if (newArtLs.length == nodes0.length ) then {
                           ;
                           ({
                              ;

                              /** 
                               * for all `i` in the range,
                               * try reconcile for the `i`-th Node,
                               * falling back to re-spawn-ing
                               * 
                               */
                              newArtLs.indices
                              .map(i => (i, nodes0(i), formerArtLs.convR().apply(i), newArtLs.convR().apply(i) ) )
                              .map({ case (i, nd, formerMdl, newMdl) => {
                                 ;

                                 (for { nd <- tryReconcile(nd )(newMdl ) } yield nd )
                                 .getOrElse[artSpwCrosReconcOption1._1.Reconcilee ] ({
                                    // TODO
                                    newMdl
                                    match { case e => e.spawnArtFromScratch() }
                                 })
                              }})

                              //
                           })
                           match { case result => r1.throwReturn(result) }
                        }

                        ;
                        // TODO
                        newArtLs
                        .map({ case ConcatArtDat.XItemSeqRowWithValue(v) => v.spawnArtFromScratch() } )
                     }})
                  }

                  (newArtLs, ndsRefAnim, L.EventStream.delay(100 ).toWeakSignal )
            })
            .flatMap({ case (newArtLs, nds, s ) => {
               s
               .map(o => {
                  o
                  .fold(Seq {
                     L.span("loading...")
                  } )(_ => {
                     nds
                     .map(e => laminarInSpawneddLL(e) )
                  } )
               } ) 
            } })
            .map(s => {
               s
               .map(e => {
                  /** add spacing if possible and necessary */
                  e
                  .withProactiveSpacingFix()
               })
               // TODO remove this LOC
               .map(_.asInstanceOf[ln.ReactiveHtmlElement[dom.HTMLElement ] | ln.ReactiveSvgElement[dom.SVGElement ] ] )
            })
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

      // final
      // lazy
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
      }

      // final
      lazy
      val reconciliabilityKey
      = SRNA.allocateGScanLeft(Seq() )(reconciliability )

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

               import ConcatArtDat.{XItemSeqRowWithValue, XItemSeqOps}

               (a1, a2) match {
                  //

                  case (ConcatArtDat(s1), ConcatArtDat(s2) ) =>
                     s1 ++ s2

                  case (ConcatArtDat(s1), si2 ) =>
                     s1 :+ XItemSeqRowWithValue(si2 )

                  case (si1, ConcatArtDat(s2) ) =>
                     XItemSeqRowWithValue(si1) +: s2

                  case (si1, si2 ) =>
                     (Seq() :+ si1 :+ si2 )
                     .map(art => XItemSeqRowWithValue(art ) )

               }
            } : ConcatArtDat.XItemSeqOps[Article]

            assert(2 <= finalSeq.length, s"failed to have (2 <= s.length ) ")

            ;
            // (reconciliability, finalSeq ) : Article
            laminarSpawnableMdlFactory(reconciliabilityKey )
            .apply(finalSeq )
         }

         ;
      }

      ;
   }

   private
   object thematicLaminarUtil
   {
      ;

      val chtSeparator
      = laminar.api.L.htmlTag[dom.HTMLElement ]("c-per-item")

      extension (e: ln.ReactiveElement[?] ) {
         //

         /** 
          * proactively
          * add spacing if possible and necessary ;
          * without this,
          * nothing else will keep two adjacent elements from collapsing without spacing
          * 
          */
         transparent inline
         def withProactiveSpacingFix()
         : ln.ReactiveElement[?]
         = {
            ;

            /** add spacing if possible and necessary */
            e match {
               //

               //
               case e: ln.ReactiveHtmlElement[?] =>
                  import laminar.api.L.{given }
                  chtSeparator(" ", e, " ")

               //

               //
               case e: ln.ReactiveSvgElement[?] =>
                  import laminar.api.L.{svg, given }
                  svg.g(" ", e, " ")

               case e =>
                  e

                  //
            }
         }

         //
      }

      ;

      ;
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
      with ELaminarQckCore
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

      ;

      ;

      ;

      ;
      ;
   }

   /** 
    * `ReconciliativeClassMismatchError`, and the relevant stuffs
    * 
    */
   object XAspwPredefs
   {
      ;

      /* note: we need a rename here ; shame on u, Chr DevTools! */
      class ReconciliativeClassMismatchError(msg: String)
      extends
         RuntimeException(msg)
      /** 
       * to be `thrown` whenever
       * finding mismatch in the reconciliative-class between two reconcilee from both sides.
       * 
       */
      type ReconciliativeClassMismatchException
         = ReconciliativeClassMismatchError

      object lll {
         org.scalajs.dom.console.log({ class LllError extends Exception ; new LllError } )
      }

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