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
      .unliftSwitchingInpfa()
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

      ;

      %%%%((
         () => {
            ;
            inpfaXesbs.forRefresh[Value]()
            .wrappedLaminarElement
         }
      ))
   }

   // private[s1]
   def given_SpawnabilityAndReconciliability_Inpfa_impl11
      [Value ]
      (using GspGoodDefaultValuation[Value ] )
      (using typ: GivenSpinner1[Value ] )
   : (
      //
      SpawnabilityAndReconciliabilityNoArg[
         Option[InpfaStaticInvar[Value] ]
         ,
         ln.ReactiveHtmlElement[dom.HTMLElement]
         ,
         Unit ,
      ]
   )
   = {
      ;

      ;

      %%%%((
         () => {
            ;
            inpfaXesbs.forStatic[Value]()
            .wrappedLaminarElement
         }
      ))
   }

   private
   object inpfaXesbs
   {
      ;

      // val initialVal: Value
      // = summon[GspGoodDefaultValuation[Value] ].value

      ;

      ;

      ;

      import laminar.api.L

      ;

      ;

      given ELaminarIndirectionImpl.directly.type
      = ELaminarIndirectionImpl.directly

      ;

      ;

      def forStatic
         //
         [Value]
         ()
         (using GspGoodDefaultValuation[Value ] )
         (using typ: GivenSpinner1[Value ] )
      : (
         aBackreferencings.XEAndStateBag[? <: dom.HTMLElement]
         & aBackreferencings.XEAndStateBagCm[Option[InpfaStaticInvar[Value] ] , Unit]
      )
      = {
         ;

         ;

         type XModel
         >: Option[InpfaStaticInvar[Value] ]
         <: Option[InpfaStaticInvar[Value] ]

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
               s
               .onError(new RuntimeException("regular closedown") )
            }

            val s
            = {
               ;

               val vr
               = {
                  ;

                  val p0
                  = L.Var[Option[InpfaStaticInvar[Value] ] ](None)

                  (p0.writer, {
                     ;

                     p0.signal
                     .changes

                     .scanLeft[Option[L.Var[InpfaStaticInvar[Value] ] ] ]((None ) )({
                        case (_, None) =>
                           None
                        case (None, Some(newS) ) =>
                           Some { L.Var[InpfaStaticInvar[Value] ](newS ) }
                        case (Some(var0), Some(newS) ) =>
                           var0.set(newS )
                           Some { var0 }
                     })
                     .map(o => {
                        o
                        .map(vr => (
                           //
                           vr.signal
                           match { case e => e : InpfaRefreshInvar[Value] } 
                        ) )
                     } )
                  })
               }

               val peer
               = { forRefresh[Value]() }

               vr._2
               .foreach(e => {
                  peer
                  .model_=(e )
               })(using com.raquo.airstream.ownership.ManualOwner() ) // TODO which right Owner to use as

               vr
               ._1
            }

            override
            def model_=(newMdl: XModel): Unit
            = {
               s
               .onNext(newMdl )
            }

            // def

            ;

         }

         new XEAndStateBag1
      }

      def forRefresh
         //
         [Value]
         ()
         (using GspGoodDefaultValuation[Value ] )
         (using typ: GivenSpinner1[Value ] )
      : (
         aBackreferencings.XEAndStateBag[? <: dom.HTMLElement]
         & aBackreferencings.XEAndStateBagCm[Option[InpfaRefreshInvar[Value] ] , Unit]
      )
      = {
         ;

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

         new XEAndStateBag1
      }

      ;

      ;
   }

   /* a conciciety */
   @deprecated
   private[s1]
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