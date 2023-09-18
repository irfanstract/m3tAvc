package avcframewrk.forms

package templating

package w3e.impl.js

package s1
















private[w3e]
trait ELaminarQckInputElemsReconcNativesCf
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
      def scanSpawnNewLlE
         ()
         (using givenELaminarIndirectionImpl : ELaminarIndirectionImpl )
         (using subscrAssignee : com.raquo.airstream.ownership.Owner = com.raquo.airstream.ownership.ManualOwner() )
      : givenELaminarIndirectionImpl.AppliedR
      = {
         ;

         import laminar.api.L

         enum ICM {
            case ToSubmitOnBlur()
            @deprecated /* it's collectively broken */
            case ToSubmitImmediately()
         }

         val s
         = s0.observe

         def propagateEditResultValue(value: Value)
         : Unit
         = {
            ;
            val evtInfo
            = newIcrEditEventInfo()
            ;
            for { s <- Some { s.now() } }
            yield {
               s
               .propagate1(evtInfo , value )
            }
         }

         ICM.ToSubmitOnBlur()
         match {
            //

            case _ if false =>
               ;

               val iC = {
                  ;

                  lControlledRemote(summon[GivenSpinner1[Value ] ] )(s.map(_.value ) )({
                     L.Observer((c: Value) => {
                        // propagateEditResultValue(c)
                     } )
                  } )
               }

               // TODO
               givenELaminarIndirectionImpl.appliedTo ({
                  ;

                  import L.{given }

                  L.input(iC , L.typ := nativeTypStrFor(summon[GivenSpinner1[Value ] ] ), {
                     L.onKeyDown --> ((e: org.scalajs.dom.KeyboardEvent ) => {
                        if (e.key matches "." )
                        then e.preventDefault()
                        ;
                     })
                  }, {
                     L.onBeforeInput --> (e => e.preventDefault() )
                  } )
               })

            case ICM.ToSubmitImmediately() =>
               //

               val iC = {
                  ;

                  lControlledRemote(summon[GivenSpinner1[Value ] ] )(s.map(_.value ) )({
                     L.Observer((c: Value) => {
                        propagateEditResultValue(c)
                     } )
                  } )
               }

               // TODO
               givenELaminarIndirectionImpl.appliedTo ({
                  ;

                  import L.{given }

                  L.input(iC , L.typ := nativeTypStrFor(summon[GivenSpinner1[Value ] ] ) )
               })

            case ICM.ToSubmitOnBlur() =>
               ;

               val vctr
               = { new VCTR[Value](s)(propagateEditResultValue = propagateEditResultValue _ ) }

               import vctr.{*, given }

               givenELaminarIndirectionImpl.appliedTo {
                  ;

                  // TODO
                  lazy val e1 : ln.ReactiveHtmlElement[?]
                  = {
                     ;

                     L.input(iC, L.typ := nativeTypStrFor(gsp ), {
                        import L.{given }
                        ;
                        L.eventProp[dom.FocusEvent ]("focusout") --> (e => {
                           processFocusOutEvent(e)
                        })
                     } )
                  }

                  e1
               }

            //
            case e if false =>
               ???

            //
         }

      }

      //
   }

   /** 
    * manages,
    * an independent *state*,
    * to remain uncommited until done so
    * 
    */
   private
   class VCTR
      [Value]
      (using val gsp: GivenSpinner[Value] )
      (s : laminar.api.L.StrictSignal[InpfaStaticInvar[Value] ] )
      (propagateEditResultValue : (newValue: Value ) => Unit )
      (using laminar.api.A.Owner )
   {
      ;

      val vr1 = L.Var[String]("")

      s
      .map(_.value)
      .map(e => vr1.set(e.toString() ) )
      .observe

      val tryParse
      = gsp.parse.lift

      ;

      def tryFlush()
      = {
         ;

         val valueRaw
         = vr1.now()

         given_Console_alt
            .info(
               s"trying parse and submit",
               scalajs.js.JSON.stringify(valueRaw ) ,
               // gsp , /* this quickly filled up the Console */
            )

         for {
            r <- tryParse(valueRaw ).toRight(new RuntimeException(s"cannot translate value '${valueRaw}' with the GSP ${gsp } " ) ).toTry
         }
         yield {
            vr1.set("")
            propagateEditResultValue(r)
            ()
         }
      }

      val iC = {
         ;

         lControlled(summon[GivenSpinner1[String ] ] )(vr1 )
      }

      ;

      def processFocusOutEvent
         (e: dom.FocusEvent)
      : Unit
      = {
         ;

         if false then dom.console.log(e)

         tryFlush()
         .fold[Unit](z => {
            given_Console_alt.info("failed 'tryFlush' ; cancelling the unfocusing ", z.toString() )
            // e.preventDefault()
            domutil.restoreFocusFor(e)
         } , _ => {} )

         ;
      }

      ;
   }

   ;
}
















val _ = {}
