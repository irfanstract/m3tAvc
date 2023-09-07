package avcframewrk.forms

package templating

package w3e.impl.js

package s1



















/**
 * 
 * solely the infrastructure for 'model'-ing
 * 
 */
private
trait ELaminarQckButtonsReconcCtls
extends
   AnyRef
   /* */
   with ENativeElementsD1
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
{
   this : (
      AnyRef
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
      with ENativeElementsD1
   ) =>
   ;

   ;

   object CallbackTypeL {
      ;

      /** `anchor` */
      case class A(hrefOption: Option[java.net.URI] )

      /** `button` */
      case class B(callbackOption: Option[org.scalajs.dom.Event => Unit ] )

      /** following `A` and `B`, is `C` . `BInputFunc` */
      case class C(edTypeOption: Option[BInputFunc[?] ] ) { export edTypeOption.{get => edType } }

   }

   extension (src : AsyncStateChangeMonad[Option[(org.scalajs.dom.Event => Unit ) | java.net.URI ] ] ) {
      //

      /** 
       * 
       * unlifts the `Signal[Option[Function1 | URI ] ]` into being `Signal[A | B | C ]`
       * 
       */
      def unlifted
      = {
         ;

         // /* only for the Observables (from Airstream) */
         import laminar.api.L

         ;

         import CallbackTypeL.{A, B, C }

         src

         .map({
            case (Some(s) ) =>
               Some {
                  //

                  /** 
                   * NOTE -
                   * there's some overlap between these case(s)
                   * (eg `BInputFunc` `extends` `Function0` as well )
                   * , so
                   * case-ordering is significant here
                   * 
                   */
                  s match {

                     //
                     case (edType : BInputFunc[t1] ) =>
                        C(edTypeOption = Some(edType ) )

                     //
                     case (run : Function1[evt$, rv$] ) =>
                        B(Some(run) )

                     //
                     case (href: java.net.URI ) =>
                        A(Some(href) )

                     //
                  }
               }
            case None =>
               None
         })
         .scanLeftAdapted0[([T] =>> T )[A | B | C ] ](e => e.getOrElse(A(None) ) )({
            case (_, Some(v)) =>
               v
            case (v0, None ) =>
               v0 match {
                  case _ : A => A(None)
                  case _ : B => B(None)
                  case _ : C => C(None)
               }
         })
      }

      //
   }

   ;

   ;

   ;

   private[avcframewrk]
   case class BfSnaConfig(
      //
      expectInlineHeadline : Boolean
      ,
   )

   ;
}

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
         ContentModel1 : reflect.Typeable,
         +UOpR ,
      ]
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

      // def reRenderFromScratch
      //    (m : ContentModel )
      // : XScanLeftReconciliativeOps[ContentModel, UOpR]

      // def tryUpdateTo
      //    [M >: ContentModel <: Matchable ]
      //    (m : M )
      // : Either[XScanLeftReconciliativeOps[ContentModel, UOpR] , UOpR]
      // = {
      //    m
      //    match {
      //       // case
      //       case m: ContentModel =>
      //          updateTo(m)
      //          match { case r => Right(r) }
      //       case _ =>
      //          reRenderFromScratch(m )
      //          match { case r => Left(r) }
      //    }
      // }

   }

   extension [HL] (this1: XScanLeftReconciliativeOps[HL, ?, ?] ) {
      //

      transparent
      inline def wrappedLaminarElem
      : HL
      = this1.lE

      //
   }

   def llrConv
      [
         HL ,
         ContentModelBase,
         ContentModel1 <: ContentModelBase : reflect.Typeable,
         UOpR ,
      ]
      (impl: XScanLeftReconciliativeOps[? <: HL, ContentModel1, UOpR ] )
   = {
      // (src: Option[HL] )
      ???
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

      extension [acv1$] (ed: BInputFunc[acv1$] ) {
         //

         // @annotation.experimental
         def scanL
            [DT]
            (using reflect.Typeable[DT])
            (using SpawnabilityAndReconciliabilityNoArg[Option[InpfaStatic[DT ] ], ? <: ln.ReactiveHtmlElement[?], Unit ] )
         = {
            ;

            ed.scanLImpl(using summon[reflect.Typeable[DT] ] )
         }

         // private
         def scanLImpl
            [DT, H <: ln.ReactiveHtmlElement[?] ]
            (using reflect.Typeable[DT])
            (using SpawnabilityAndReconciliabilityNoArg[Option[InpfaStatic[DT ] ], H, Unit ] )
         = {
            ;

            def r(c: acv1$ ) = {
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

/**
 * 
 * a rather minimal wrapper over the Laminar's 'builder pattern' for native comp(s)
 * 
 */
private
trait ELaminarQckButtonsReconcNatives
extends
   AnyRef
   /* */
   with ENativeElementsD1
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
   with ELaminarQckButtonsReconcCtls
{
   this : (
      AnyRef
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
      with ELaminarQckButtonsReconcCtls
      with ENativeElementsD1
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

   ;

   ;

   extension [acv1$] (ed: BInputFunc[?]) {
      //

      def valueAnim
      = ed.src.toObservable

      /**
       * Laminar `controlled`
       * 
       */
      def llc[ExpectedValue1]()
      = {
         ;

         lControlled(ed.t )(ed.src )
      }

      //
   }

   /**
    * Laminar `controlled`
    * 
    */
   def lControlled
      [Value]
      (typ: GivenSpinner1[Value])
      (src : L.SignalSource[Value] & L.Sink[Value] )
   = {
      ;

      import L.{given}

      L.controlled(
         //
         L.value <-- src.toObservable.map(_.toString() )
         ,
         (
            L.onInput
            .mapToValue
            // .map(v => {
            //    org.scalajs.dom.console.log("inputed value raw: ", v )
            //    v
            // } )
            .map(typ.parse.lift ).collect({ case Some(v) => v })
            .map(v => {
               if v.isInstanceOf[Boolean] then {
                  org.scalajs.dom.console.log("inputed value parsed: ", v )
               }
               v
            } )
            -->
            (src.toObserver.onNext _ )
         ) ,
      ) 
   }

   def lControlledRetypable
      [Value]
      (src : ([Value] =>> ((L.SignalSource[Value] & L.Var[Value ] ) & L.Sink[Value] ) )[(GivenSpinner1[Value] , Value ) ] )
   = {
      ;

      import L.{given}

      L.controlled(
         //
         L.value <-- src.toObservable.map({ case (_, value) => value }).map(_.toString() )
         ,
         (
            L.onInput
            .mapToValue
            .map(newValue => { val (typ, _) = src.signal.now() ; for (newValue1 <- typ.parse.lift.apply(newValue ) ) yield (typ, newValue1 ) } ).collect({ case Some(v) => v })
            .map({ case v @ (typ, vV ) => {
               if vV.isInstanceOf[Boolean] then {
                  org.scalajs.dom.console.log("inputed value parsed: ", v )
               }
               v
            } })
            -->
            (src.toObserver.onNext _ )
         ) ,
      ) 
   }

   inline given given_SpawnabilityAndReconciliability_Inpfa
      [Value ]
      (using typ: GivenSpinner1[Value ] )
   : (
      //
      SpawnabilityAndReconciliabilityNoArg[
         Option[InpfaStatic[Value] ]
         ,
         ln.ReactiveHtmlElement[dom.HTMLInputElement]
         ,
         Unit ,
      ]
   )
   = {
      ;

      ;

      val initialVal
      : Value
      = {
         typ
         match {
            case given_GivenSpinner_DateTime =>
               ("2023-09-06" ).asInstanceOf[Value & w3e.pre.StdGsps.DateTime ]
            case edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_Number[enm] =>
               edType.apply("0")
            case given_GivenSpinner_Boolean =>
               (false ).asInstanceOf[Value]
            case given_GivenSpinner_String =>
               ("" ).asInstanceOf[Value]
            // case _ : DateTime =>
            //    ("" ).asInstanceOf[Value]
         }
      }
      ;

      ;

      type XModel
         >: Option[InpfaStatic[Value] ]
         <: Option[InpfaStatic[Value] ]

      import laminar.api.L

      ;

      class XEAndStateBag1() extends
      aBackreferencings.XEAndStateBag(ec = { L.input })
      with aBackreferencings.XEAndStateBagCm[XModel, Unit]
      {
         //

         import laminar.api.L

         override
         def close(): Unit
         = {
            closeAllOf[laminar.api.L.Observer[?] ]((
               srcToSetterDispatchers

            ))
         }

         wrappedLaminarElement
         .amend(L.typ := nativeTypStrFor(typ) )

         val valueControlled1
         = {
            ;

            val s = L.Var[( GivenSpinner1[Value ] , Value ) ]((typ, initialVal ))

            val c = lControlledRetypable(src = s )

            wrappedLaminarElement
            .amend(c )

            s.writer
         }

         val srcToSetterDispatchers
         = {
            (
               Seq()

               :+(L.disabled.startAttribNow((_: XModel).fold(false)(_ => true ) , initialValue = None ).contraconst() )

               :+(valueControlled1.contramap((c: Option[InpfaStatic[Value] ] ) => c match { case Some(c) => (typ, c.value) ; case None => (typ, initialVal) } ) )

               // TODO

            )
         } : Seq[L.Observer[XModel ] ]

         override
         def model_=(newMdl: XModel): Unit
         = {
            for (o <- srcToSetterDispatchers )
            do { o.onNext(newMdl ) }
         }

         // def

         ;

      }

      ({
         import aBackreferencings.{given Conversion[?, ?] }

         val f1
         = () => new XEAndStateBag1().wrappedLaminarElement

         summon[Conversion[f1.type, SpawnabilityAndReconciliabilityNoArg[XModel, ? <: ln.ReactiveHtmlElement[dom.HTMLElement] , ? ] ] ]
         .apply(f1 )
      })
   }

   /**
    * 
    * `input`s where setting the attrib-or-prop `value` will do what the name suggests
    * (as it's not the case when `type` were `button` or `submit` or `checkbox` or `file` )
    * 
    */
   type InpfaStatic[+Value]
   = InpfaStaticInvar[? <: Value ]

   case class InpfaStaticInvar
      [Value ]
      (
         //
         value: Value
         ,
         propagate1 : (evtInfo: dom.Event, newValue: String ) => Unit
         ,
      )
   {
      ;

      ;
   }

   locally {
      ;

      //
      locally({
         ;

         summon[(
            //

            SpawnabilityAndReconciliabilityNoArg[
               Option[InpfaStatic[Boolean] ]
               ,
               // ln.ReactiveHtmlElement[dom.HTMLInputElement]
               // ,
               // Unit ,
               ?,
               ?,
            ]
         )]
      })
      match { case s => s }

      //
      locally({
         ;

         summon[(
            //

            SpawnabilityAndReconciliabilityNoArg[
               Option[InpfaStatic[Int] ]
               ,
               ?,
               ?,
            ]
         )]
      })
      match { case s => s }

      ;
   }

   transparent inline
   def nativeTypStrFor(edType: GivenSpinner1[?] )
   : String
   = {
      ;

      edType

      match {
         //
         case edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_DateTime.type =>
            "date"
         case edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_Number[?] =>
            "number"
         case _ =>
            ""
         //
      }
   }

   ;

   extension [Item] (dest: laminar.api.L.Observer[? >: AsyncStateChangeMonad[Item] ] ) {
      //

      def contraconst()
      = dest.contramap((v: Item) => laminar.api.L.Val(v) )

      //
   }

   ;

   ;


   ;
}

given ebAvfwInlineBtnCssInit
: AnyRef
with {
   ;

   org.scalajs.dom.console.log(s"[ebAvfwInlineBtnCssInit]")

   avcframewrk.forms.addGlobalCss({
      ;

      enum Hoverffect {
         case OnBorder()
         case ToIncreaseUnderline()
      }

      val hoverEffect
      = Hoverffect.OnBorder()

      (
         //

         Seq()

         :+ s"button, input { padding-block: 0.75ex ; } "

         :+ s"button.avfw-inline, a.avfw-inline, input.avfw-inline { display: inline ; } "

         :+ s"button.avfw-inline, a.avfw-inline, input.avfw-inline { padding-block: 0.7ex ; padding-block-end: 1.5ex ; margin-block: -0.4ex ; } "
         :+ s"button.avfw-inline, input.avfw-inline { margin-block-end: -1ex ; } "

         :+ s"button.avfw-inline { padding-inline: 1ex ; } "

         :+ s"button.avfw-inline { background: transparent ; background: rgba(0, 0, 0, 0.02) ; } "

         :+ s"button.avfw-inline { margin-inline: -1ex ; } "

         // :+ s"button.avfw-inline { font-weight: bolder ; } "

         :++ (hoverEffect match {

            case Hoverffect.OnBorder() => 

               (Seq()

               :+ s"button { border: 0.1ex solid transparent ; } "

               :+ { def sel(sc: String ) = s"#app${sc } button " ; s"${sel(":hover") }, ${sel(":focus-within") } { border-color: currentColor ; } " }

               )

            case _ =>
               Seq()

         } )

         :+ s"button, a { text-decoration: underline ; } "

         :++ (hoverEffect match {

            case Hoverffect.ToIncreaseUnderline() => 

               (Seq()

         :+ { def sel(sc: String ) = s"#app${sc } button.avfw-inline " ; s"${sel(":hover") }, ${sel(":focus-within") } { text-decoration-style: double ; } " }

               )

            case _ =>
               Seq()

         } )

         :+ s"button.avfw-offtopic { user-select: none !important ; } "

      )
      .mkString("\r\n\r\n")
   })

} // ebAvfwInlineBtnCssInit$

















val _ = {} 
