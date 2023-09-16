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
      with ELaminarQckInputElemsDataTypesPre
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
   def summonInpfaForPvB
      [Value]
      //
      (using GspGoodDefaultValuation[Value ] )
      (using GivenSpinner1[Value ] )
   = given_SpawnabilityAndReconciliability_Inpfa_impl[Value]

   def summonInpfaForPvF
      [Value]
      //
      (using GspGoodDefaultValuation[Value ] )
      (using GivenSpinner1[Value ] )
   = given_SpawnabilityAndReconciliability_Inpfa_impl1[Value]

   def summonInpfaForPvAlt
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
   // private[s1]
   def given_SpawnabilityAndReconciliability_Inpfa_impl
      [Value ]
      (using GspGoodDefaultValuation[Value ] )
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

      given_SpawnabilityAndReconciliability_Inpfa_impl1
         [Value]
      .unliftSwitching()
   }

   // private[s1]
   def given_SpawnabilityAndReconciliability_Inpfa_impl1
      [Value ]
      (using GspGoodDefaultValuation[Value ] )
      (using typ: GivenSpinner1[Value ] )
   : (
      //
      SpawnabilityAndReconciliabilityNoArg[
         Option[InpfaRefreshInvar[Value] ]
         ,
         ln.ReactiveHtmlElement[dom.HTMLElement]
         ,
         Unit ,
      ]
   )
   = {
      ;

      val initialVal: Value
      = summon[GspGoodDefaultValuation[Value] ].value

      ;

      ;

      ;

      import laminar.api.L

      type XModel
         >: Option[InpfaRefreshInvar[Value] ]
         <: Option[InpfaRefreshInvar[Value] ]

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
            = L.Var[Option[InpfaRefreshInvar[Value] ] ](None )

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

   ;

   locally {
      ;

      //
      // summonInpfaForPv[Boolean]
      // match { case s => s }

      // //
      // summonInpfaForPv[Int]
      // match { case s => s }

      // given_SpawnabilityAndReconciliability_Inpfa_impl[Int]

      summonInpfaForPvAlt(using (
         given_SpawnabilityAndReconciliability_Inpfa_impl[Int]
      ))

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