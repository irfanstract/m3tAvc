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
   with ELaminarQckInputElemsReconcNativesModels
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
      with ELaminarQckInputElemsReconcNativesModels
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
      (using GivenSpinner1[Value ] )
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

      given_SpawnabilityAndReconciliability_Inpfa_impl1
         [Value](initialVal = initialVal )
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

   private[s1]
   def given_SpawnabilityAndReconciliability_Inpfa_impl1
      [Value ]
      (initialVal: Value )
      (using typ: GivenSpinner1[Value ] )
   : (
      //
      SpawnabilityAndReconciliabilityNoArg[
         Option[laminar.api.L.Signal[InpfaStaticInvar[Value] ] ]
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

      import laminar.api.L

      type XModel
         >: Option[L.Signal[InpfaStaticInvar[Value] ] ]
         <: Option[L.Signal[InpfaStaticInvar[Value] ] ]

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