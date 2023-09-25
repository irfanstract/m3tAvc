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
   with ELaminarQckInputElemsReconcNativesExt
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

   ;

   ;

   ;

   ;

   object abcdCallbackRenderablility1
   {
      ;

      import laminar.api.L

      ;

      import CallbackTypeL.{A, B, C }

      ;

      def ftm
         (using BfSnaConfig)
      : FlowThroughMode
      = {
         if summon[BfSnaConfig].expectInlineHeadline
         then FlowThroughMode.forThroughness
         else FlowThroughMode.forSkip
      }

      case class SkpmTitlePair(skpm: FlowThroughMode, title: Article )

      given Conversion[BfSnaConfig, FlowThroughMode]
      = { c => (((), c.expectInlineHeadline ) match { case ((), true ) => FlowThroughMode.forThroughness ; case ((), false ) => FlowThroughMode.forSkip } ) }

      object skpmCoreR {
         ;

         ;

         def renderInpfa[Pv] (edTypeOption: Option[BInputFunc[Pv] ] )
         : XScanLeftReconciliativeOps[ln.ReactiveHtmlElement[dom.HTMLElement ], ? <: Option[BInputFunc[?] ], Unit ]
         = {
            ;

            import ffRcKeying1.{*, given}

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

         ;
      }

      //
      case class SkpmTitlePairInputSpwOps(config: SkpmTitlePair ) {
         //

         import config.title

         ;
         
         def renderIntrinsic[Pv] (edTypeOption: Option[BInputFunc[Pv] ] )
         : XScanLeftReconciliativeOps[ln.ReactiveHtmlElement[dom.HTMLElement ], ? <: Option[BInputFunc[?] ], Unit ]
         = {
            ;

            skpmCoreR.renderInpfa(edTypeOption = edTypeOption )
         }

         def spawnDisabledInputElem()
         : XScanLeftReconciliativeOps[ln.ReactiveHtmlElement[dom.HTMLElement ], ? <: Option[BInputFunc[?] ], Unit ]
         = {
            ;

            skpmCoreR.spawnDisabledInputElem()
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
      = {
         ;
         spawnAndGetOptReconciler1(
            //
            urlOption = urlOption ,
            ftm = ftm ,
            title = title ,
         )
      }

      final
      lazy val spawnabilityOfAbc
      : SpawnabilityAndReconciliabilityNoArg[(A | B | C, FlowThroughMode, Article), ? <: ln.ReactiveHtmlElement[dom.HTMLElement], Unit]
      = {
         ;

         llrConv(L.span )((spawnAndGetOptReconciler1 _ ).tupled )
      }

      def spawnAndGetOptReconciler1
         (urlOption : A | B | C, ftm: FlowThroughMode , title: Article )
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

               spawnInpfaAndGetOptReconciler(title = title, urlOption = md )

            //
            case md @ B(_) =>
               ;

               spawnabilityOfB
               .compose({
                  (desc: (Article, B ) ) =>
                     ftm *: desc
               } )
               .compose((
                  //

                  (m : B ) =>
                     (title, m )

               ) )
               .spawnAsXsr(md )

            case md @ A(_) =>
               ;

               spawnabilityOfA
               .compose({
                  (desc: (Article, A ) ) =>
                     ftm *: desc
               } )
               .compose((
                  //

                  (m : A ) =>
                     (title, m )

               ) )
               .spawnAsXsr(md )

         }
         match { case e => {
            e
         } }
      }

      def spawnInpfaAndGetOptReconciler
         (urlOption : C, title: Article )
         // (using BfSnaConfig )
      : (
         //

         XScanLeftReconciliativeOps[
            //
            ? <: ln.ReactiveHtmlElement[dom.HTMLElement]
            ,
            ? <: C
            ,
            Unit
            ,
         ]
      )
      = {
         ;

         val md : urlOption.type
         = valueOf

         ;

         // edTypeOption

         // import spawnabilityOfInputDataActionsImpl.{*, given }

         import skpmCoreR.{*, given}

         spawnabilityOfC
         .spawnAsXsr(md )

         // TODO remove this test LOC
         match { case e => {
            e.wrappedLaminarElem
            .ref
            .parentNode
            e
         } }
      }

      final
      lazy val spawnabilityOfA
      = {
         ;

         spawnabilityOfLaspa1
         .compose(LaspaStaticByHeadline.tupled )
         // TODO
         .compose((desc: (FlowThroughMode, Article, A ) ) => {
            ;

            import desc._3.hrefOption

            desc
            .copy(_3 = {
               ;
               for { href <- hrefOption }
               yield LaspaStaticWithoutHeadline(href = Some(href) )
            })
         } )
      }

      final
      lazy val spawnabilityOfB
         //
      = {
         ;

         spawnabilityOfBtna
         .compose(BtnaStaticByHeadline.tupled )
         .compose((desc: (FlowThroughMode, Article, B ) ) => {
            ;

            import desc._3.callbackOption
            
            desc
            .copy(_3 = {
               for { callback <- callbackOption }
               yield BtnaStaticWithoutHeadline(onClick = callback.compose((_: org.scalajs.dom.Event ).asInstanceOf[EdsbEventInfo ] ) )
            })
         } )
      }

      final
      lazy val spawnabilityOfC
      = {
         ;
         spawnabilityOfInpfa
      }

      final
      lazy val spawnabilityOfLaspa1
      = {
         ;
         spawnabilityOfLaspa
      }

      final
      lazy val spawnabilityOfLaspa
      : SpawnabilityAndReconciliabilityNoArg[LaspaStaticA, ? <: ln.ReactiveHtmlElement[dom.HTMLElement], Unit]
      = {
         ;
         given_SpawnabilityAndReconciliability_Laspa[LaspaStaticWithoutHeadline]
      }

      final
      lazy val spawnabilityOfBtna
      : SpawnabilityAndReconciliabilityNoArg[BtnaStaticA, ? <: ln.ReactiveHtmlElement[dom.HTMLElement], Unit]
      = {
         ;
         given_SpawnabilityAndReconciliability_Btna[BtnaStaticWithoutHeadline]
      }

      final
      lazy val spawnabilityOfInpfa
      : SpawnabilityAndReconciliabilityNoArg[C, ? <: ln.ReactiveHtmlElement[dom.HTMLElement], Unit]
      = {
         ;

         ;

         import skpmCoreR.{*, given}

         llrConv(L.span )((mdl: Option[BInputFunc[?] ] ) => {
            mdl
            /** needs to extract type `t`, as a work-around to avoid the spurious type-mismatch */
            match { case (e : Option[BInputFunc[t]] ) => renderInpfa[t](e) }
            match { case e => e }
         } )
         .compose((md: C) => md.edTypeOption )
      }

      ;
   }

   ;
}



















val _ = {}
