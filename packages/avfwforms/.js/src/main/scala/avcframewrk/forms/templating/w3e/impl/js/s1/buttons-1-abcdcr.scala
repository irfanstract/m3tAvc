package avcframewrk.forms

package templating

package w3e.impl.js

package s1



















/**
 * 
 * deals with the rendering(s) relevant to `CallbackTypeL`
 * 
 */
private
trait ELaminarQckButtonsReconcAbcdCbRenderability
extends
   AnyRef
   /* */
   with ENativeElementsD1
   with ELaminarQckButtonsReconcNatives
   /* due to the self-types */
   with ELaminarQckInputElemsDataTypesPre
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
   with ELaminarQckButtonsReconcCtls
   with ELaminarQckButtonsActionModelling
   with ELaminarQckButtonsActionModellingTwo
   with w3e.pre.Articles
   with w3e.pre.Buttons
   with avcframewrk.forms.templating.w3e.impl.js.s1.ELaminarQckPlainStringConts
   with ELaminarQckCoreFailsafeReconcilers
   with ELaminarQckCoreFailsafeReconcilersArt
{
   this : (
      AnyRef
      with w3e.pre.Articles
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
      with ENativeElementsD1
      with ELaminarQckCoreFailsafeReconcilers
      with ELaminarQckCoreFailsafeReconcilersArt
   ) =>
   ;

   @deprecated
   protected
   given typeTestEdsbEventInfo
   : reflect.Typeable[EdsbEventInfo ]
   = {
      ReopaquativeTypeTest.apply[org.scalajs.dom.Event ](_ => true)
      .asInstanceOf[reflect.Typeable[EdsbEventInfo ] ]
   }

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

   ;

   ;

   ;

   ;

   // TODO
   private
   inline
   def summonInpfaForPv
      [Value]
      //
      (using GspGoodDefaultValuation[Value ] )
      (using GivenSpinner1[Value ] )
   : SpawnabilityAndReconciliabilityNoArg[Option[BInputFunc[Value]], ? <: ln.ReactiveHtmlElement[dom.HTMLElement], Unit]
   = {
      ;

      /* a conciciety */
      @deprecated
      // private
      def %%%%
         [XModel]
         (f1: () => ln.ReactiveHtmlElement[dom.HTMLElement] )
      = {
         ;

         ({
            import aBackreferencings.{given Conversion[?, ?] }

            summon[Conversion[f1.type, SpawnabilityAndReconciliabilityNoArg[XModel, ? <: ln.ReactiveHtmlElement[dom.HTMLElement] , ? ] ] ]
            .apply(f1 )
         })
      }

      ;
      compiletime.summonFrom({
         //

         case sgv0 : (sgvs.Sgv[Value] ) =>
            ;
            val sgv
            = sgv0
            val describeFieldElem
            = {
               laminarSpawnableMdlFactory
                  [Option[BInputFunc[Value] ], (
                     LReconciliativeKey.ScnAllocAndReconcileAndDistillH[? , Option[BInputFunc[Value] ] , ? <: ln.ReactiveHtmlElement[? <: dom.HTMLElement ] ]
                     //
                  ) , ln.ReactiveHtmlElement[? <: dom.HTMLElement ], dom.HTMLElement ]
                  ( sgv )
            }
            if true then ({
               ;

               type XM
               >: Option[BInputFunc[Value] ]
               <: Option[BInputFunc[Value] ]

               val sp10
               = summon[SpawnabilityAndReconciliabilityNoArg[LaminarSpawnable[ln.ReactiveHtmlElement[? <: dom.HTMLElement], dom.HTMLElement], ?, ? ] ].asTypeTupelified
               import sp10.{_2 as sp1 }

               // TODO
               class XSB extends
                  aBackreferencings.XEAndStateBag(ec = { L.span })
                  with aBackreferencings.XEAndStateBagCm[XM , Unit ]
               {
                  ;
                  override def close(): Unit = {}
                  ;
                  val peer = sp1.spawn(describeFieldElem(None ) )( )
                  ;
                  wrappedLaminarElement
                  .amend({ import L.{given} ; L.span("the newer engine") } , laminarInSpawneddLL(peer) )
                  ;
                  override def model_=(mdl: XM ) = sp1.model_=(peer)(describeFieldElem(mdl ) )
                  // ???
               }

               %%%%[Option[BInputFunc[Value] ] ](() => { new XSB().wrappedLaminarElement } )
            })
            else summonInpfaForPvB[Value]

         case _ =>
            // compiletime.error("no given Sgv.")
            summonInpfaForPvB[Value]

      })
   }

   private
   object sgvs {
      ;

      opaque type Sgv[Value]
      <: LReconciliativeKeyTo1[SgvMinReconcilerOps[Value] ]
      =  LReconciliativeKeyTo1[SgvMinReconcilerOps[Value] ]

      type SgvMinReconcilerOps[Value ]
      >: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[? , Option[BInputFunc[Value] ] , ? <: ln.ReactiveHtmlElement[? <: dom.HTMLElement ] ]
      <: LReconciliativeKey.ScnAllocAndReconcileAndDistillH[? , Option[BInputFunc[Value] ] , ? <: ln.ReactiveHtmlElement[? <: dom.HTMLElement ] ]

      /* for them each, its initialiser shall only run once, so we make it explicitly `val`s (as `implicit val`) */

      implicit
      final
      lazy val sgvForString
      : Sgv[String] & LReconciliativeKeyTo1[ScnAllocAndReconcileAndDistillH[sgvForStringImpl.HigherLevelState, ?, ? ] ]
      = sgvForStringImpl.higherLvlR

      implicit
      final
      lazy val sgvForDateTime
      : Sgv[w3e.pre.StdGsps.DateTime] & LReconciliativeKeyTo1[ScnAllocAndReconcileAndDistillH[sgvForDateTimeImpl.HigherLevelState, ?, ? ] ]
      = sgvForDateTimeImpl.higherLvlR

      ;

      final
      lazy val sgvForStringImpl
      : allocateSpecial[String]
      = allocateSpecial[String]

      final
      lazy val sgvForDateTimeImpl
      : allocateSpecial[w3e.pre.StdGsps.DateTime]
      = allocateSpecial[w3e.pre.StdGsps.DateTime]

      private[s1]
      class allocateSpecial[Value] private[s1]
            (using GspGoodDefaultValuation[Value ] )
            (using GivenSpinner1[Value ] )
            ()
      {
         ;

         val lowerLvlR
         = SRNA.allocateGScanLeftAlt(None )((
            summonInpfaForPvF1[Value]
         ) )(e => e )

         val lowerLvlReconciler0
         = {
            ({
               ;
               lowerLvlR
               .toScnAllocAndReconcileAndDistillH
               .given_SpawnabilityAndReconciliabilityNoArg_Md_TIntermediateState
            })
            match { case s: SpawnabilityAndReconciliabilityNoArg[t1, t2, t3] => s: SpawnabilityAndReconciliabilityNoArg[t1, ? <: t2, t3] }
            match { case s => s.asTypeTupelified }
         }
         /* can't use `import` */
         val lowerLvlReconciler
         : lowerLvlReconciler0._2.type
         = lowerLvlReconciler0._2

         opaque type HigherLevelState
         <: Any
         = (
            //

            (
               ln.ReactiveHtmlElement[?] ,
               L.Var[Option[BInputFunc[Value] ] ]
               ,
            )
         )

         given HigherLevelStateLlElement
         : Conversion[HigherLevelState, ln.ReactiveHtmlElement[?] ]
         = _._1

         val higerLevelImplReconciler
         : (
            //
            SpawnabilityAndReconciliabilityNoArg[
               //
               Option[BInputFunc[Value] ] ,
               HigherLevelState ,
               Unit ,
            ]
         )
         = {
            SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc[
               //
               Option[BInputFunc[Value] ] ,
               HigherLevelState ,
               Unit ,
            ] (
               //
               spwImpl1 = (initialFrame ) => {
                  val s
                  = lowerLvlReconciler.spawn(None )( )
                  val sg = laminar.api.L.Var[Option[BInputFunc[Value] ] ](initialFrame )
                  sg.signal
                  .map(o => (
                     o
                     .map(desc => {
                        // desc.src
                        for {
                           value <- desc.src.toObservable
                        }
                        yield {
                           InpfaStaticInvar[Value] (value = value, propagate1 = (evtInfo, newValue) => desc.onEditToNewValue(newValue, evtInfo ) )
                        }
                     } : InpfaRefreshInvar[Value] )
                  ) )
                  .flatMap({
                     case None =>
                        L.Val(None)
                     case Some(s) =>
                        for { sV <- s } yield Some(sV)
                  })
                  .foreach(e => {
                     ;

                     // TODO
                     lowerLvlReconciler.model_=(s)(e )

                  })(using com.raquo.airstream.ownership.ManualOwner() ) // TODO
                  (s, sg)
               } ,
               reconcImpl1 = {
                  case ((s, sg), newFrame ) =>
                     sg
                     .set(newFrame )
               } ,
            )
         }

         val higherLvlR
         : (
            LReconciliativeKeyTo1[(
               //
               LReconciliativeKey.ScnAllocAndReconcileAndDistillH[
                  //

                  HigherLevelState ,
                  Option[BInputFunc[Value] ] ,
                  ln.ReactiveHtmlElement[?] ,
               ]
            )]
         )
         = {
            SRNA.allocateGScanLeftAlt(None )(higerLevelImplReconciler )(_._1 )
            // (???)
         }

         // TODO
      }

      ;

      // TODO

      ;
   }

   extension [
      Pv
      ,
      Sp
      >: ln.ReactiveHtmlElement[?]
      <: ln.ReactiveHtmlElement[?]
      ,
      ReconcOpR,
   ] (impl: SpawnabilityAndReconciliabilityNoArg[Option[InpfaStaticInvar[Pv]], Sp, ReconcOpR ] ) {
      //

      @annotation.experimental
      // transparent inline
      def composeForSpawn1
         ()
         (using reflect.Typeable[Pv] )
      : SpawnabilityAndReconciliabilityNoArg[Option[BInputFunc[?] ], Sp, ReconcOpR ]
      = {
         ;

         import laminar.api.L

         ;

         ;
         impl
         .compose((eOption : Option[BInputFunc[?] ] ) => ({
            //

            // TODO

            for {
               case eh0 : BInputFunc[Pv] <- eOption
            }
            yield eh0

            ???
         }) )
      }

      //
   }

   object abcdCallbackRenderablility1
   {
      ;

      import laminar.api.L

      ;

      import CallbackTypeL.{A, B, C }

      ;

      case class SkpmTitlePair(skpm: FlowThroughMode, title: Article )

      given Conversion[BfSnaConfig, FlowThroughMode]
      = { c => (((), c.expectInlineHeadline ) match { case ((), true ) => FlowThroughMode.forThroughness ; case ((), false ) => FlowThroughMode.forSkip } ) }

      case class SkpmTitlePairInputSpwOps(config: SkpmTitlePair ) {
         //

         import config.title

         ;
         
         def renderIntrinsic[Pv] (edTypeOption: Option[BInputFunc[Pv] ] )
         : XScanLeftReconciliativeOps[ln.ReactiveHtmlElement[dom.HTMLElement ], ? <: Option[BInputFunc[?] ], Unit ]
         = {
            ;

            import L.{given }

            edTypeOption
            .map(e => (e, e.t, true ) )
            match {

               case Some(ed: BInputFunc[acv1$], edType : ( w3e.pre.StdGsps.ofSnb.given_GivenSpinner_DateTime.type) , enabled ) =>
                  ;

                  summonInpfaForPv[w3e.pre.StdGsps.DateTime ]
                  .spawnAsXsr(edTypeOption)

               case Some(ed: BInputFunc[acv1$], edType : ( w3e.pre.StdGsps.ofSnb.given_GivenSpinner_Number[enm]) , enabled ) =>
                  ;

                  // 5 : enm

                  ({ given edType.type = edType ; summonInpfaForPv })
                  .spawnAsXsr(edTypeOption)

               case Some(ed: BInputFunc[acv1$], edType : ( given_GivenSpinner_String.type), enabled ) =>
                  ;

                  summonInpfaForPv[String]
                  .spawnAsXsr(edTypeOption)

                  // ???

               case _ =>
                  ;

                  spawnDisabledInputElem()
            }

            match { case e => {
               ;

               e.wrappedLaminarElemLst
               .ref
               .parentNode
               e
            } }
         }

         def spawnDisabledInputElem()
         = {
            ;

            import L.{given }

            ;

            L.input(L.disabled := true )

            match {
               case e =>

                  val xNothing = None

                  /* can't use anon-classes, when subclassing, in Sc JS */
                  ({
                     ;

                     object emn extends
                        AnyRef
                        with XScanLeftReconciliativeOps[e.type, xNothing.type, Unit ](lE = e )
                     {

                        override
                        def updateTo(m: xNothing.type )
                        : Unit
                        = {
                           // no-op
                        }

                     }
                     emn
                  })
            }
         }

         def renderHeadline(edTypeOption: Option[BInputFunc[?] ] )
         : ln.ReactiveHtmlElement[dom.HTMLElement ]
         = {
            ;

            import L.{given }

            ;

            (
               //

               L.span(L.child <-- L.Val(title.spawn() match { case e => laminarInSpawneddLL.apply(e) } ) )
               .amend(":" )
               .amend((
                  L.span()
                  .amend(L.styleAttr := (
                     ""
                     + s"display: inline-block ; position: relative ; inline-size: 11em ; vertical-align: text-top ;"
                     + s"background: rgba(255, 255, 0, 0.15 ) ; "
                  ) )
                  .amend(edTypeOption.fold(Seq() )(e => Seq[com.raquo.laminar.modifiers.Inserter.Base ](L.span(L.child <-- e.src.toObservable.map(_.toString() ) ) ) ) : _* )
               ))
            )
         }

         //
      }

      def spawnAndGetOptReconciler
         (urlOption : A | B | C, title: Article )
         (using BfSnaConfig )
      : (
         //

         XScanLeftReconciliativeOps[
            //
            ? <: ln.ReactiveHtmlElement[dom.HTMLElement]
            ,
            ? <: (A | B | C )
            ,
            Unit
            ,
         ]
      )
      = {
         ;

         // import L.{given }

         ;

         ;
         urlOption
         match {
            case md @ C(_ ) =>
            ;

            // edTypeOption

            // import spawnabilityOfInputDataActionsImpl.{*, given }

            val anSkpmTitlePairInputSpwOps
            = SkpmTitlePair(skpm = summon[BfSnaConfig], title = title ) match { case p => SkpmTitlePairInputSpwOps(p) }

            import anSkpmTitlePairInputSpwOps.{*, given}

            llrConv(L.span )((mdl: Option[BInputFunc[?] ] ) => {
               mdl
               /** needs to extract type `t`, as a work-around to avoid the spurious type-mismatch */
               match { case (e : Option[BInputFunc[t]] ) => renderIntrinsic[t](e) }
               match { case e => e }
            } )
            .compose((md: C) => md.edTypeOption )
            .spawnAsXsr(md )

            // TODO remove this test LOC
            match { case e => {
               e.wrappedLaminarElem
               .ref
               .parentNode
               e
            } }

            //
            case md @ B(_) =>
               ;

               given_SpawnabilityAndReconciliability_Btna[BtnaStaticWithoutHeadline]
               .compose({
                  ({
                     ;
                     (summon[BfSnaConfig] match { case config => ((), config.expectInlineHeadline ) } )
                     match {
                        case ((), true) => BtnaStaticInline
                        case ((), false) => BtnaStaticAside
                     }
                  })
                  match { case f => { f } }
                  match { case f => { f } }
                  match { case f => { f.tupled } }
               } )
               .compose((
                  //

                  (m : B ) =>
                     (title, {
                        for { callback <- m.callbackOption }
                        yield BtnaStaticWithoutHeadline(onClick = callback.compose((_: org.scalajs.dom.Event ).asInstanceOf[EdsbEventInfo ] ) )
                     } )

               ) )
               .spawnAsXsr(md )

            case md @ A(_) =>
               ;

               given_SpawnabilityAndReconciliability_Laspa[LaspaStaticWithoutHeadline]
               .compose(laspaStaticAFromAcTuple2.apply _ )
               .compose((
                  //

                  (m : A ) =>
                     (title, {
                        for { href <- m.hrefOption }
                        yield LaspaStaticWithoutHeadline(href = Some(href) )
                     } )

               ) )
               .spawnAsXsr(md )

         }
         match { case e => {
            e
         } }
      }

      ;
   }

   ;
}



















val _ = {}
