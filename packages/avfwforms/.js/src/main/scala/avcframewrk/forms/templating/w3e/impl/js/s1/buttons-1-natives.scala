package avcframewrk.forms

package templating

package w3e.impl.js

package s1



















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
