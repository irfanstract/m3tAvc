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
            Option[InpfaStatic[Pv] ]
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
            case `given_GivenSpinner_DateTime` =>
               ("2023-09-06" ).asInstanceOf[Value & w3e.pre.StdGsps.DateTime ]
               // (0.25 ).asInstanceOf[Value & w3e.pre.StdGsps.DateTime ]
               // (0.25, 0.5, 0.75, { org.scalajs.dom.console.log("did compare:", typ, given_GivenSpinner_DateTime ) } ).asInstanceOf[Value & w3e.pre.StdGsps.DateTime ]
            case edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_Number[enm] =>
               edType.apply("0")
            case `given_GivenSpinner_Boolean` =>
               (false ).asInstanceOf[Value]
            case `given_GivenSpinner_String` =>
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

   /**
    * `InpfaStatic`, with invariance in place of co-variance
    * 
    */
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

   ;

   extension [Pv, Sp, ReconcOpR] (impl: SpawnabilityAndReconciliabilityNoArg[Option[InpfaStatic[Pv]], Sp, ReconcOpR ] ) {
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

         ) )
      }

      //
   }

   ;

   ;
}






















val _ = {} 