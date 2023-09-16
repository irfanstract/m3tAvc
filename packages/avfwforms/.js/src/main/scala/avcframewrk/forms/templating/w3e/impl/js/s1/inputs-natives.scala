package avcframewrk.forms

package templating

package w3e.impl.js

package s1




















/**
 * 
 * a rather minimal wrapper over the Laminar's 'builder pattern' for native comp(s)
 * 
 */
private[w3e]
trait ELaminarQckInputElemsReconcNatives
extends
   AnyRef
   /* */
   with ENativeElementsD1
   with ELaminarQckInputElemsLcs
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
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

   ;

   ;

   ;

   // private[avcframewrk]
   transparent
   inline def summonGspGoodDefaultValue
      [Value]
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

   /**
    * a `SpawnabilityAndReconciliabilityNoArg` for
    * `&lt;input>`s whose setting `value` will do what the name says
    * (there are some who don't, eg when `type` is `button` or `submit`, or `checkbox`, or `file` )
    * 
    * 
    */
   def summonInpfaForPv
      [Pv]
      (using impl : (
         //

         SpawnabilityAndReconciliabilityNoArg[
            Option[BInputFunc[Pv] ]
            ,
            ?,
            ?,
         ]
      ))
   : impl.type
   = impl

   /**
    * a `SpawnabilityAndReconciliabilityNoArg` for
    * `&lt;input>`s whose setting `value` will do what the name says
    * (there are some who don't, eg when `type` is `button` or `submit`, or `checkbox`, or `file` )
    * 
    * 
    */
   inline given given_SpawnabilityAndReconciliability_Inpfa
      [Value ]
      (using typ: GivenSpinner1[Value ] )
   : (
      //
      SpawnabilityAndReconciliabilityNoArg[
         Option[BInputFunc[Value] ]
         ,
         ln.ReactiveHtmlElement[dom.HTMLElement]
         ,
         Unit ,
      ]
   )
   = {
      ;

      ;

      val initialVal
      : Value
      = summonGspGoodDefaultValue[Value]
      ;

      given_SpawnabilityAndReconciliability_Inpfa_impl
         [Value]
         (initialVal = initialVal)
   }

   private[s1]
   def given_SpawnabilityAndReconciliability_Inpfa_impl
      [Value ]
      (initialVal: Value )
      (using typ: GivenSpinner1[Value ] )
   : (
      //
      SpawnabilityAndReconciliabilityNoArg[
         Option[BInputFunc[Value] ]
         ,
         ln.ReactiveHtmlElement[dom.HTMLElement]
         ,
         Unit ,
      ]
   )
   = {
      ;

      ;

      ;

      type XModel
         >: Option[BInputFunc[Value] ]
         <: Option[BInputFunc[Value] ]

      import laminar.api.L

      ;

      class XEAndStateBag1() extends
      aBackreferencings.XEAndStateBag(ec = { L.span })
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

         // val valueControlled1
         // = {
         //    ;

         //    val s = L.Var[( GivenSpinner1[Value ] , Value ) ]((typ, initialVal ))

         //    val c = lControlledRetypable(src = s )

         //    wrappedLaminarElement
         //    .amend(c )

         //    s.writer
         // }

         val valueControlled11
         = {
            ;

            val s
            = L.Var[Option[L.Signal[InpfaStaticInvar[Value] ] ] ](None )

            val sS
            = {
               s.signal
               .changes
               .collect({ case Some(v) => v })
            }

            wrappedLaminarElement
            .amend({
               L.child <-- {
                  sS
                  .map(s => s.scanSpawnNewLlE() )
               }
            })

            s.writer
         }

         val valueControlled1
         = {
            valueControlled11
            .contramap((s0: Option[BInputFunc[Value] ] ) => {
               org.scalajs.dom.window.isSecureContext
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

                                 s.src.toObserver
                                 .onNext(newValue)
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

         val srcToSetterDispatchers
         = {
            (
               Seq()

               :+(L.disabled.startAttribNow((_: XModel).fold(false)(_ => true ) , initialValue = None ).contraconst() )

               :+(valueControlled1 )

               // :+ (valueControlled11 )

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
         = {
            () => {
               new XEAndStateBag1()
               .wrappedLaminarElement
            }
         }

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
            = new (org.scalajs.dom.Event)("avfwinputfieldevt", scalajs.js.undefined )
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

   locally {
      ;

      //
      summonInpfaForPv[Boolean]
      match { case s => s }

      //
      summonInpfaForPv[Int]
      match { case s => s }

      ;
   }

   ;

   extension [
      Pv
      ,
      Sp
      >: ln.ReactiveHtmlElement[?]
      <: ln.ReactiveHtmlElement[?]
      ,
      ReconcOpR,
   ] (impl: SpawnabilityAndReconciliabilityNoArg[Option[BInputFunc[Pv]], Sp, ReconcOpR ] ) {
      //

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
         .compose((eOption : Option[BInputFunc[?] ] ) => (
            //

            // TODO

            for {
               case eh0 : BInputFunc[Pv] <- eOption
            }
            yield eh0

         ) )
      }

      //
   }

   ;

   ;
}






















val _ = {} 