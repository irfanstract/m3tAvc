package avcframewrk.forms

package templating

package w3e.impl.js

package s1





















private[w3e]
trait ELaminarQckInputElemsReconcNativesModels
extends
   AnyRef
   /* */
   with ENativeElementsD1
   with ELaminarQckInputElemsLcs
   with ELaminarQckInputElemsReconcModels
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
   with ELaminarQckButtonsReconcCtls
   with w3e.pre.Articles
   with ELaminarQckCore
{
   this : (
      AnyRef
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
      with ELaminarQckButtonsReconcCtls
      with ENativeElementsD1
      with w3e.pre.Articles
      with ELaminarQckCore
      with ELaminarQckCoreHtml
      // with  avcframewrk.forms.templating.w3e.pre.Buttons
      with ELaminarQckInputElemsDataTypesPre
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

   ;

   ;

   ;

   ;

   extension [Value] (s0 : laminar.api.L.Signal[InpfaStaticInvar[Value] ] )
      (using GivenSpinner1[Value ] )
   {
      //

      //

      /** 
       * spawns a new `ln.ReactiveHtmlElement[dom.HTMLInputElement]`, animated by the `L.Signal[InpfaOf[Value] ]`.
       * 
       * the `&lt;input>` will be *controlled*.
       * in case of parse-error (eg "not in a valid numeric fmt", "not in a valid date-time fmt"),
       * nothing will be `propagate`ed, so what the input-field is gon' to would be misleading
       * 
       */
      def scanSpawnNewLlE()
      : ln.ReactiveHtmlElement[dom.HTMLInputElement ]
      = {
         ;

         import laminar.api.L

         val s1 = L.Var[Option[InpfaStaticInvar[Value] ] ](None)

         def propagateEditResultValue(value: Value)
         : Unit
         = {
            ;
            val evtInfo
            = newIcrEditEventInfo()
            ;
            for { s <- s1.now() }
            yield {
               s
               .propagate1(evtInfo , value )
            }
         }

         val s
         = s0.map(value => { s1.set(Some(value) ) ; value } )

         // TODO
         L.input({
            lControlledRemote(summon[GivenSpinner1[Value ] ] )(s.map(_.value ) )({
               L.Observer((c: Value) => {
                  propagateEditResultValue(c)
               } )
            } )
         } , L.typ := nativeTypStrFor(summon[GivenSpinner1[Value ] ] ) )
      }

      //
   }

   extension [
      Value ,
      Spw ,
      ReconcOpR ,

      //
   ] (impl: SpawnabilityAndReconciliabilityNoArg[Option[laminar.api.L.Signal[InpfaStaticInvar[Value] ] ], Spw, ReconcOpR ] )
   {
      //

      def unliftSwitching()
      : (
         SpawnabilityAndReconciliabilityNoArg[Option[BInputFunc[Value] ] , Spw, ReconcOpR ]
      )
      = {
         ;

         impl

         .compose((s0: Option[BInputFunc[Value] ] ) => {
            ;

            ;

            (for {
               s <- s0
            } yield {
               ;
               val s1
               = {
                  for {
                     value <- s.src.toObservable
                  }
                  yield {
                     //
                     InpfaStaticInvar(
                        //
                        value = value
                        ,
                        propagate1 = (
                           { case (evtInfo, newValue) => {
                              ;

                              s
                              // .src.toObserver
                              // .onNext(newValue)
                              .onEditToNewValue(newValue, evtInfo )
                           } }
                        )
                        ,
                     )
                  }
               }
               ;
               s1
            } )
         } )
      }

      //
   }

   ;
}


private[w3e]
trait ELaminarQckInputElemsReconcModels
extends
   AnyRef
   /* */
   with ELaminarQckInputElemsLcs
   with ELaminarQckInputElemsDataTypes
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
   with ELaminarQckButtonsReconcCtls
   with w3e.pre.Articles
{
   this : (
      AnyRef
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
      with ELaminarQckButtonsReconcCtls
      with w3e.pre.Articles
      // with  avcframewrk.forms.templating.w3e.pre.Buttons
      with ELaminarQckInputElemsDataTypesPre
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

   ;

   lazy val inpfaDemoAutoIncrement
   = {
      import laminar.api.L

      ;

      ;

      val vr = L.Var[String]("")

      new {
         reschedule()
         def reschedule()
         : Unit
         = {
            scalajs.js.timers.setTimeout(970)({
               vr.set(scalajs.js.Date.apply() )
               reschedule()
            })
         }
      }

      vr.signal
   }

   /**
    * 
    * `input`s where setting the attrib-or-prop `value` will do what the name suggests
    * (as it's not the case when `type` were `button` or `submit` or `checkbox` or `file` )
    * 
    */
   @deprecated("this is a co-variant (re)export of the latter.")
   type InpfaStatic[+Value ]
   = InpfaStaticCovar[Value ]

   type InpfaStaticCovar[+Value ]
   = InpfaStaticInvar[? <: Value ]

   /**
    * 
    * `input`s where setting the attrib-or-prop `value` will do what the name suggests
    * (as it's not the case when `type` were `button` or `submit` or `checkbox` or `file` )
    * 
    */
   case class InpfaStaticInvar
      [Value ]
      (
         //
         value: Value
         ,
         propagate1 : (evtInfo: dom.Event, newValue: Value ) => Unit
         ,
      )
   {
      ;

      ;
   }

   type InpfaRefreshInvar[Value]
   >: laminar.api.L.Signal[InpfaStaticInvar[Value] ]
   <: laminar.api.L.Signal[InpfaStaticInvar[Value] ]

   object InpfaRefreshInvar

   ;

   ;

   ;

}

private[w3e]
trait ELaminarQckInputElemsDataTypes
extends
AnyRef
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging or crashing */
   with ELaminarQckButtonsActionModellingTwo
{
   this : (
      AnyRef
      & ELaminarQckButtonsActionModelling
      & ELaminarQckButtonsActionModellingTwo
      // &  avcframewrk.forms.templating.w3e.impl.js.s1.ELaminarQckButtonsActionModelling
      // &  avcframewrk.forms.templating.w3e.pre.Articles
      // &  avcframewrk.forms.templating.w3e.pre.Buttons
      // &  avcframewrk.forms.templating.w3e.pre.PlainTxtContents
      // &  avcframewrk.forms.templating.w3e.pre.PlainTxtContents
      with ELaminarQckInputElemsDataTypesPre
   ) =>
   ;

   inline given given_GspGoodDefaultValuation_Value
      [Value]
      (using GivenSpinner1[Value] )
   : GspGoodDefaultValuation[Value]
   = summonGspGoodDefaultValue[Value]

   opaque type GspGoodDefaultValuation
      [+Value] /* without making it 'co-variant' we're wasting a chance */
   = Value
   extension [Value](c: GspGoodDefaultValuation[Value] ) def value: Value = c

   // private[avcframewrk]
   // transparent
   // inline
   def summonGspGoodDefaultValue
      [Value]
      (using reflect.Typeable[Value] )
      (using GivenSpinner1[Value] )
   : Value
   = {
      ;

      summon[GivenSpinner1[Value] ]
      match {
         case `given_GivenSpinner_DateTime` =>
            ("2023-09-06" )
            // (0.25 )
            // (0.25, 0.5, 0.75, { org.scalajs.dom.console.log("did compare:", typ, given_GivenSpinner_DateTime ) } )
         case edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_Number[enm] =>
            edType.apply("0")
         case `given_GivenSpinner_Boolean` =>
            (false )
         case `given_GivenSpinner_String` =>
            ("" )
         // case _ : DateTime =>
         //    ("" )
      }
      match {
         case e : Value =>
            e
      }
   }

   lazy val _ = {
      val _ = summonGspGoodDefaultValue[Boolean] match { case v => v }
      val _ = summonGspGoodDefaultValue[String ] match { case v => v }
   }

   ;

   ;
}

/** 
 * 
 * we need this `trait` here for these reason
 * 
 * if the above `trait` didn't `extends` `ELaminarQckButtonsActionModellingTwo`,
 * the compiler
 * would crash with
 * `AssertionError` attributable to the desugared tree `this.asInstanceOf[(.......)].given_GivenSpinner_DateTime`
 * 
 */
private[s1]
trait ELaminarQckInputElemsDataTypesPre
extends
AnyRef
   //
   with ELaminarQckButtonsActionModellingTwo
   with  avcframewrk.forms.templating.w3e.impl.js.s1.ELaminarQckButtonsActionModelling
   with  avcframewrk.forms.templating.w3e.pre.Articles
   with  avcframewrk.forms.templating.w3e.pre.Buttons
   with  avcframewrk.forms.templating.w3e.pre.PlainTxtContents
{

   this : (
      AnyRef
      // & ELaminarQckButtonsActionModelling
      // & ELaminarQckButtonsActionModellingTwo
      &  avcframewrk.forms.templating.w3e.impl.js.s1.ELaminarQckButtonsActionModelling
      &  avcframewrk.forms.templating.w3e.pre.Articles
      &  avcframewrk.forms.templating.w3e.pre.Buttons
      &  avcframewrk.forms.templating.w3e.pre.PlainTxtContents
      // &  avcframewrk.forms.templating.w3e.pre.PlainTxtContents
   ) =>

}























val _ = {}