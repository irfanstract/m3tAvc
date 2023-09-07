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
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
   with ELaminarQckButtonsReconcCtls
   with ELaminarQckButtonsActionModelling
   with ELaminarQckButtonsActionModellingTwo
   with w3e.pre.Articles
   with w3e.pre.Buttons
   with avcframewrk.forms.templating.w3e.impl.js.s1.ELaminarQckPlainStringConts
{
   this : (
      AnyRef
      with w3e.pre.Articles
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
      with ENativeElementsD1
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   ;

   ;

   /**
    * 
    * a locally-adjusted itc for scan-left (see `IterableOnceOps`) reconciliation
    * 
    */
   private[ELaminarQckButtonsReconcAbcdCbRenderability]
   trait XScanLeftReconciliativeOps
      [
         +HL ,
         ContentModel1,
         +UOpR ,
      ]
      (using val given_TypeTest_ContentModel1 : reflect.Typeable[ContentModel1 ] )
   {
      ;

      type ContentModel
      = ContentModel1

      private[ELaminarQckButtonsReconcAbcdCbRenderability]
      val lE
      : HL

      def updateTo
         (m : ContentModel )
      : UOpR

   }

   extension [HL, Md, UOpR] (this1: SpawnabilityAndReconciliabilityNoArg[Md, HL, UOpR ] ) {
      //

      def spawnAsXsr
         (v: Md)
         (using reflect.Typeable[Md] )
      : XScanLeftReconciliativeOps[HL, Md, UOpR ]
      = {
         val e = this1.spawn(v)()
         ;
         ;
         new XScanLeftReconciliativeOps[HL, Md, UOpR ] { val lE: e.type = e ; def updateTo(m: Md) = this1.model_=(lE)(m) }
      }

      //
   }

   extension [HL] (this1: XScanLeftReconciliativeOps[HL, ?, ?] ) {
      //

      transparent
      inline def wrappedLaminarElem
      : HL
      = this1.lE

      //
   }

   def llrConv1
      [
         ContentModelBase
         : reflect.Typeable
         ,
         ContainerNative <: org.scalajs.dom.HTMLElement ,
         UOpR ,
      ]
      (container : com.raquo.laminar.tags.HtmlTag[ContainerNative] )
      (spwAndReconc: SpawnabilityAndReconciliabilityNoArg[ContentModelBase, ? <: ln.ReactiveHtmlElement[?] , UOpR ] )
   = {
      ;

      llrConv
         (container )
         (spawnAsScReconciler = (c: ContentModelBase ) => spwAndReconc.spawnAsXsr(c) )
   }

   def llrConv
      [
         SpawnedAsScReconciler <: XScanLeftReconciliativeOps[? <: ln.ReactiveHtmlElement[?], ? <: ContentModelBase, UOpR ]
         ,
         ContentModelBase
         ,
         ContainerNative <: org.scalajs.dom.HTMLElement ,
         UOpR ,
      ]
      (container : com.raquo.laminar.tags.HtmlTag[ContainerNative] )
      (spawnAsScReconciler: (mdl: ContentModelBase ) => SpawnedAsScReconciler)
   : SpawnabilityAndReconciliabilityNoArg[ContentModelBase, ? <: ln.ReactiveHtmlElement[ContainerNative], UOpR]
   = {
      ;

      import laminar.api.L

      ;

      ;

      def reconcileOrRecreate(scMaybe : Option[SpawnedAsScReconciler], newMdl: ContentModelBase)
      : SpawnedAsScReconciler
      = {
         ;

         ;

         /**
          * at the first turn `scMaybe` would be `None`, and
          * even then
          * it's possible `sc.TypeTest` point(ed) to a `type` which `newMdl` doesn't conform to
          * 
          */
         (for {

            /** at the first turn `scMaybe` would be `None` */
            sc <- scMaybe

            /** it's possible `sc.TypeTest` point(ed) to a `type` which `newMdl` doesn't conform to */
            case sc.given_TypeTest_ContentModel1(newMdl) <- Some(newMdl)
         }
         yield {
            sc.updateTo(newMdl)
            sc
         } )

         .getOrElse[SpawnedAsScReconciler ] ({
            spawnAsScReconciler(newMdl )
         })
      }

      def newContentModelLmVar()
      = {
         ;

         L.Var[Option[(ContentModelBase) ] ](None)

         match { case v => {
            (
               v.writer.contramap((e: ContentModelBase ) => Some(e) ) ,
               v.signal ,
            )
         } }
      }

      class XEAndStateBag1() extends
      aBackreferencings.XEAndStateBag(ec = { container })
      with aBackreferencings.XEAndStateBagCm[ContentModelBase, Unit ]
      {
         ;

         ;

         override
         def close(): Unit
         = {
            closeAllOf(Seq() :+ cL )
         }

         val cL
         = {
            ;

            val (mdlSetter, mdlOptionAnim)
            = {

               newContentModelLmVar()
            }
            ;

            wrappedLaminarElement
            .amend((

               L.child

               .<--({

                  mdlOptionAnim
                  .changes
                  .collect({ case Some(v) => v })
                  .scanLeft[Option[SpawnedAsScReconciler] ](None)({
                     //

                     case (scMaybe, newMdl) =>
                        ;

                        reconcileOrRecreate(scMaybe, newMdl )
                        match { case r => Some(r) }

                     //
                  })
                  .map(o => (o.map(_.wrappedLaminarElem) getOrElse L.span() ) )
                  .map(e => e )
               })

            ))

            mdlSetter
         }

         override
         def model_=(newMdl: ContentModelBase)
         : Unit
         = {
            cL
            .onNext(newMdl )
         }

         ;
      }

      ({
         ;

         aBackreferencings.given_Conversion_C_SpawnabilityAndReconciliabilityNoArg_1[ContentModelBase, UOpR, ln.ReactiveHtmlElement[ContainerNative], ContainerNative ]
         .apply(() => new XEAndStateBag1().wrappedLaminarElement )
      })
   }

   object abcdCallbackRenderablility1
   {
      ;

      import laminar.api.L

      ;

      import CallbackTypeL.{A, B, C }

      ;

      ;
      // import L.{
      //    href as _,
      //    input as _,
      //    a as _ ,
      //    button ,
      //    disabled ,
      //    given ,
      // }

      extension [DT] (ed: BInputFunc[DT] ) {
         //

         // @annotation.experimental
         def scanL
            [T0]
            (using reflect.Typeable[DT])
            (using SpawnabilityAndReconciliabilityNoArg[Option[InpfaStatic[DT ] ], ? <: ln.ReactiveHtmlElement[?], Unit ] )
         = {
            ;

            ed.scanLImpl(using summon[reflect.Typeable[DT] ] )
         }

         // private
         def scanLImpl
            [H <: ln.ReactiveHtmlElement[?] ]
            (using reflect.Typeable[DT])
            (using SpawnabilityAndReconciliabilityNoArg[Option[InpfaStatic[DT ] ], H, Unit ] )
         : laminar.api.L.Signal[H]
         = {
            ;

            def r(c: DT ) = {
               ;

               Some((
                  InpfaStaticInvar(value = c.asInstanceOf[DT], propagate1 = { case _ => } )
               ))
            }

            ;
            ;
            ed.src
            .toObservable
            .scanLeft(newValue => {
               ;

               r(newValue )
               .spawn()
            })((s0, newValue) => {
               // TODO
               // r(newValue).spawn()
               // ({ s0.model_=(r(newValue ) ) ; s0 })
               ({ summon[SpawnabilityAndReconciliabilityNoArg[?, ?, ?] ].model_=(s0)(r(newValue ) ) ; s0 })
            } )
         }

         //
      }

      def renderFromScratch
         (urlOption : A | B | C, title: Article )
         (using BfSnaConfig )
      : ln.ReactiveHtmlElement[dom.HTMLElement]
      = ???

      def reconcilerFor
         (urlOption : A | B | C, title: Article )
         (using BfSnaConfig )
      : (
         //

         // SpawnabilityAndReconciliabilityNoArg[
         //    ? <: Option[InpfaStatic[Any] ]
         //    ,
         //    // ln.ReactiveHtmlElement[dom.HTMLInputElement]
         //    // ,
         //    // Unit ,
         //    ?,
         //    ?,
         // ]
         XScanLeftReconciliativeOps[
            //
            ? <: ln.ReactiveHtmlElement[dom.HTMLInputElement]
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
            // case C(edTypeOption ) =>
            //    ;
            //    edTypeOption
            //    .map(e => (e, e.t, true ) )
            //    match {

            //       case Some(ed: BInputFunc[acv1$], edType : given_GivenSpinner_Boolean.type, enabled ) =>
            //          // L.input( L.typ := "checkbox" )
            //          // .amend(disabled := !enabled  )
            //          // // .amend(L.value <-- ed.valueAnim.map(_.toString() ) )
            //          // .amend(
            //          //    //
            //          //    L.checked <-- ed.valueAnim.map(_.asInstanceOf[Boolean ] ) 
            //          //    ,
            //          //    L.onChange.mapToChecked.map(_.asInstanceOf[acv1$] ) --> (ed.src.toObserver.onNext _ )
            //          //    ,
            //          // )
            //          ???

            //       case Some(ed: BInputFunc[acv1$], edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_DateTime.type , enabled ) =>
            //          // L.input( L.typ := "date" )
            //          // .amend(disabled := !enabled  )
            //          // .amend((
            //          //    ed.llc()
            //          // ))

            //          summon[(
            //             //

            //             SpawnabilityAndReconciliabilityNoArg[
            //                Option[InpfaStatic[w3e.pre.StdGsps.DateTime ] ]
            //                ,
            //                // ln.ReactiveHtmlElement[dom.HTMLInputElement]
            //                // ,
            //                // Unit ,
            //                ?,
            //                ?,
            //             ]
            //          )]

            //       case Some(ed: BInputFunc[acv1$], edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_Number[enm] , enabled ) =>
            //          // L.input( L.typ := "number" )
            //          // .amend(disabled := !enabled  )
            //          // .amend((
            //          //    ed.llc()
            //          // ))

            //          ;

            //          ;

            //          summon[(
            //             //

            //             SpawnabilityAndReconciliabilityNoArg[
            //                Option[InpfaStatic[BigDecimal] ]
            //                ,
            //                // ln.ReactiveHtmlElement[dom.HTMLInputElement]
            //                // ,
            //                // Unit ,
            //                ?,
            //                ?,
            //             ]
            //          )]

            //       case Some(ed: BInputFunc[acv1$], edType : given_GivenSpinner_String.type, enabled ) =>
            //          // L.input( )
            //          // .amend(disabled := !enabled  )
            //          // .amend((
            //          //    ed.llc()
            //          // ))

            //          summon[(
            //             //

            //             SpawnabilityAndReconciliabilityNoArg[
            //                Option[InpfaStatic[String] ]
            //                ,
            //                // ln.ReactiveHtmlElement[dom.HTMLInputElement]
            //                // ,
            //                // Unit ,
            //                ?,
            //                ?,
            //             ]
            //          )]

            //       case _ =>
            //          L.input(disabled := true )
            //    }
            //    match {
            //       case e =>

            //          // L.label(e, (
            //          //    L.span(L.child <-- L.Val(title.spawn() ) )
            //          //    .amend(":" )
            //          //    .amend((
            //          //       L.span()
            //          //       .amend(L.styleAttr := (
            //          //          ""
            //          //          + s"display: inline-block ; position: relative ; inline-size: 11em ; vertical-align: text-top ;"
            //          //          + s"background: rgba(255, 255, 0, 0.15 ) ; "
            //          //       ) )
            //          //       .amend(edTypeOption.fold(Seq() )(e => Seq[com.raquo.laminar.modifiers.Inserter.Base ](L.span(L.child <-- e.src.toObservable.map(_.toString() ) ) ) ) : _* )
            //          //    ))
            //          // ) )

            //          ???
            //    }
            case B(callbackOption) =>
               // button() /* never, never use `<a>` for call-back buttons */
               // .amend(L.typ := "button" ) /* necessary, as `<form>`s set the default to `submit` */
               // .amend((
               //    callbackOption match {
               //       //

               //       case Some(run : Function1[evt$, rv$] ) =>
               //          (L.onClick --> run )
               //       case None =>
               //          (disabled := true )
               //    }
               // ))
               // .amend(L.child <-- L.Val(title.spawn() ) )
               ; ???

            // case A(urlOption) =>
            //    // L.a()
            //    // .amend((
            //    //    urlOption match {
            //    //       //

            //    //       case Some(href : java.net.URI ) =>
            //    //          (L.href := href.toASCIIString().nn )
            //    //       case None =>
            //    //          (disabled := true )
            //    //    }
            //    // ))
            //    // .amend(L.child <-- L.Val(title.spawn() ) )
            //    ; ???
         }
         match { case e => {
            ebAvfwInlineBtnCssInit
            // e
            // .amend(L.className := (if (summon[BfSnaConfig] ).expectInlineHeadline then ("avfw-inline" ) else ("avfw-offtopic") ) )
            ; ???
         } }
      }

      ;
   }

   ;
}



















val _ = {}
