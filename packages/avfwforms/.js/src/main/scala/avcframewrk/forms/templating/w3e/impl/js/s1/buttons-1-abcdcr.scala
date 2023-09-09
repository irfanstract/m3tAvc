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

      ;
      // import L.{
      //    href as _,
      //    input as _,
      //    a as _ ,
      //    button ,
      //    disabled ,
      //    given ,
      // }

      given given_SpawnabilityAndReconciliabilityNoArg_B_ReactiveHtmlElement_Unit
      : SpawnabilityAndReconciliabilityNoArg[B, ln.ReactiveHtmlElement[?], Unit ]
      = {
         ;

         // SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
         //    //
         //    spwImpl1 = (mdl: B) => {  } ,
         // )

         ???
      }

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
      = {
         reconcilerFor(urlOption = urlOption, title = title )
         .wrappedLaminarElem
      }

      def reconcilerFor
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

         def summonInpfaForPv
            [Pv]
            (using impl : (
               //

               SpawnabilityAndReconciliabilityNoArg[
                  Option[InpfaStatic[Pv] ]
                  ,
                  ?,
                  ?,
               ]
            ))
         : impl.type
         = impl

         ;
         urlOption
         match {
            case md @ C(_ ) =>
            ;

            // edTypeOption

            def renderIntrinsic(edTypeOption: Option[BInputFunc[?] ] )
            : XScanLeftReconciliativeOps[ln.ReactiveHtmlElement[dom.HTMLElement ], ? <: Option[BInputFunc[?] ], Unit ]
            = {
               ;

               import L.{given }

               edTypeOption
               .map(e => (e, e.t, true ) )
               match {

                  // case Some(ed: BInputFunc[acv1$], edType : given_GivenSpinner_Boolean.type, enabled ) =>
                  //    // L.input( L.typ := "checkbox" )
                  //    // .amend(disabled := !enabled  )
                  //    // // .amend(L.value <-- ed.valueAnim.map(_.toString() ) )
                  //    // .amend(
                  //    //    //
                  //    //    L.checked <-- ed.valueAnim.map(_.asInstanceOf[Boolean ] ) 
                  //    //    ,
                  //    //    L.onChange.mapToChecked.map(_.asInstanceOf[acv1$] ) --> (ed.src.toObserver.onNext _ )
                  //    //    ,
                  //    // )
                  //    ???

                  case Some(ed: BInputFunc[acv1$], edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_DateTime.type , enabled ) =>
                     ;

                     type Pv
                        >: w3e.pre.StdGsps.DateTime
                        <: w3e.pre.StdGsps.DateTime

                     summonInpfaForPv[Pv]
                     .compose((eOption : Option[BInputFunc[?] ] ) => {
                        // TODO

                        ({
                           for {
                              e <- eOption
                              case src : L.Var[t] <- Some(e.src )
                           }
                           yield {
                              InpfaStaticInvar(
                                 //
                                 value = src.now() match { case e => e.asInstanceOf[Pv] } ,
                                 propagate1 = { case _ => } ,
                              )
                           }
                        })

                     } )
                     .spawnAsXsr(edTypeOption)

                  // case Some(ed: BInputFunc[acv1$], edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_Number[enm] , enabled ) =>
                  //    // L.input( L.typ := "number" )
                  //    // .amend(disabled := !enabled  )
                  //    // .amend((
                  //    //    ed.llc()
                  //    // ))

                  //    ;

                  //    ;

                  //    summon[(
                  //       //

                  //       SpawnabilityAndReconciliabilityNoArg[
                  //          Option[InpfaStatic[BigDecimal] ]
                  //          ,
                  //          // ln.ReactiveHtmlElement[dom.HTMLInputElement]
                  //          // ,
                  //          // Unit ,
                  //          ?,
                  //          ?,
                  //       ]
                  //    )]

                  case Some(ed: BInputFunc[acv1$], edType : given_GivenSpinner_String.type, enabled ) =>
                     ;

                     type Pv
                        >: String
                        <: String
                        
                     summonInpfaForPv[Pv]
                     .compose((eOption : Option[BInputFunc[?] ] ) => {
                        // TODO

                        ({
                           for {
                              e <- eOption
                              case src : L.Var[t] <- Some(e.src )
                           }
                           yield {
                              InpfaStaticInvar(
                                 //
                                 value = src.now() match { case e => e.asInstanceOf[Pv] } ,
                                 propagate1 = { case _ => } ,
                              )
                           }
                        })
                        
                     } )
                     .spawnAsXsr(edTypeOption)

                     // ???

                  case _ =>
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

               // TODO remove this test LOC
               // match { case e => {
               //    // assert((e : XScanLeftReconciliativeOps[?, ?, ?] ).wrappedLaminarElem.nn match { case e => e != scalajs.js.undefined && e != null }, (
               //    //    s"assertion failed: ain't ('e.wrappedLaminarElem' non-null ) for ${e} "
               //    // ) )
               //    try {
               //       ;

               //       e.wrappedLaminarElem
               //       .ref
               //       .parentNode
               //    }
               //    catch { case z : ClassCastException => {
               //       ;

               //       e.wrappedLaminarElemLst
               //       .ref
               //       .parentNode
               //    } }
               //    e
               // } }
               match { case e => {
                  ;

                  e.wrappedLaminarElemLst
                  .ref
                  .parentNode
                  e
               } }
            }
            def renderHeadline(edTypeOption: Option[BInputFunc[?] ] )
            : ln.ReactiveHtmlElement[dom.HTMLElement ]
            = {
               ;

               import L.{given }

               ;

               (
                  //

                  L.span(L.child <-- L.Val(title.spawn() ) )
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

            // ???

            lazy val _ = llrConvToArt(L.span )((mdl: Option[BInputFunc[?] ] ) => renderIntrinsic(mdl ) )(md.edTypeOption )

            llrConv(L.span )((mdl: Option[BInputFunc[?] ] ) => renderIntrinsic(mdl ) )
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

               summon[SpawnabilityAndReconciliabilityNoArg[(Article, Option[BtnaStatic] ), ?, ? ] ]
               .compose((
                  //

                  (m : B ) =>
                     (title, {
                        for { callback <- m.callbackOption }
                        yield BtnaStatic(onClick = callback.compose((_: org.scalajs.dom.Event ).asInstanceOf[EdsbEventInfo ] ) )
                     } )

               ) )
               .spawnAsXsr(md )

            case md @ A(_) =>
               ;

               summon[SpawnabilityAndReconciliabilityNoArg[(Article, Option[LaspaStatic] ), ?, ? ] ]
               .compose((
                  //

                  (m : A ) =>
                     (title, {
                        for { href <- m.hrefOption }
                        yield LaspaStatic(href = Some(href) )
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
