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
         given gcce1 : CCE = given_CCE_1
         ;
         {
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

         ICM.ToSubmitImmediately()
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

                  L.span((
                     L.input(iC , L.typ := nativeTypStrFor(summon[GivenSpinner1[Value ] ] ) )
                  ), llByCco(s.map({ var c : Int = 0 ; _ => { c += 1 ; c } }) ) )
               })

            case ICM.ToSubmitOnBlur() =>
               ;

               val vctr
               = { new VCTR[Value](s)(propagateEditResultValue = propagateEditResultValue _ ) }

               import vctr.{*, given }

               givenELaminarIndirectionImpl.appliedTo {
                  ;

                  import L.{given }

                  new Selectable {
                  ;

                  /**
                   * the main input-element
                   * 
                   */
                  // TODO
                  lazy val e1 : ln.ReactiveHtmlElement[?]
                  = {
                     ;

                     L.input(iC, L.typ := nativeTypStrFor(gsp ), {
                        import L.{given }
                        ;
                        L.eventProp[dom.FocusEvent ]("focusout") --> (e => {
                           // processFocusOutEvent(e)
                        })
                     } )
                  }

                  /**
                   * the complete elements
                   * 
                   */
                  lazy val e2 : ln.ReactiveHtmlElement[?]
                  = {
                     ;

                     L.span(L.styleAttr := s"display: inline-block ;" , (
                        //

                        L.span(L.styleAttr := s"display: flex ; flex-direction: column ;" , (
                           //

                           e1
                        ), (
                           //

                           L.span(
                           //
                           L.transition := "all 0.33s ease-out" ,
                           L.fontSize.percent <-- (vrForPretendCleanStateS.map({ case true => 5 ; case _ => 66 }) ) ,
                           L.opacity <-- (vrForPretendCleanStateS.map({ case true => 0 ; case _ => 1 }).map(_.toString() ) ) ,
                           (
                              L.button("✘ cancel", L.onClick --> (e => resetWithoutSubmit() ) )
                              .amend(L.disabled <-- vrForPretendCleanStateS )
                           ) ,
                           )
                        ) , {
                           // ;

                           // import L.{given }
                           // ;
                           // L.eventProp[dom.FocusEvent ]("focusin") --> (e => {
                           //    ;
                           //    reRegisterWfcl()
                           // })

                           import avcframewrk.forms.templating.ll_util.llOnElementTreeFocusOutIvn

                           llOnElementTreeFocusOutIvn(processFocusOutEvent _)
                        } )
                     ))
                  }

                  def processFocusOutEvent
                     (e: dom.FocusEvent)
                  : Unit
                  = {
                     ;

                     if false then dom.console.log(e)

                     tryFlush()
                     .fold[Unit](z => {
                        given_Console_alt.info("failed 'tryFlush' ; cancelling the unfocusing ", z.toString() )
                        e1.ref
                        .focus()
                     } , _ => {} )

                     ;
                  }

                  }.e2
               }

            //
            case e if false =>
               ???

            //
         }

         }
         match { case e => {
            e
         } }
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
      (srcObservab : laminar.api.L.StrictSignal[InpfaStaticInvar[Value] ] )
      (propagateEditResultValue : (newValue: Value ) => Unit )
      (using laminar.api.A.Owner )
   {
      ;

      import org.scalajs.dom

      import laminar.api.L

      ;

      private[VCTR]
      val vr1 = L.Var[Option[String] ](None )

      // export vr1.{signal => vr1R, writer => vr1W }
      val vr1R
      = {
         (vr1.signal combineWith srcObservab.map(_.value ) )
         .map({ case e => e._1.getOrElse[String](e._2.toString() ) })
         .observe
      }
      private[VCTR]
      val vr1W
      = {
         vr1.writer
         .contramapSome
      }

      private[VCTR]
      def vrReset1() : Unit
      = {
         vr1.set(None )
      }

      private[VCTR]
      def vrSetTo(v: Value ) : Unit
      = vr1W.onNext(v.toString() )

      vrReset()

      srcObservab
      .map(_.value)
      .map(e => vrReset1() )
      .observe

      val tryParse
      = gsp.parse.lift

      ;

      val sgForIsInpValuePresentlyInSyncWithSrc
      = {
         (srcObservab.map(_.value).map(_.toString() ) combineWith vr1R )
         .map({ case v => v._1 == v._2 })
         .observe
      }

      def isInpValuePresentlyInSyncWithSrc()
      : Boolean
      = {
         sgForIsInpValuePresentlyInSyncWithSrc.now()
      }

      /* note: `vrForPretendCleanState` being defined later */
      ((vr1.signal combineWith sgForIsInpValuePresentlyInSyncWithSrc) )
      .map({
         case (o, b) =>
            o.isEmpty || b
      } )
      .foreach({ case isNowSo => vrForPretendCleanState.update(_ && isNowSo ) } )

      private[VCTR]
      final
      lazy val vrForPretendCleanState
      = L.Var[Boolean](true )

      export vrForPretendCleanState.{signal as vrForPretendCleanStateS }

      private[VCTR]
      def vrReset() : Unit
      = {
         vrReset1()
         vrForPretendCleanState.set(true )
      }

      def resetWithoutSubmit()
      : Unit
      = {
         ;

         vrReset()
      }

      def tryFlush()
      = {
         ;

         val valueRaw
         = vr1R.now()

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
            vrReset()
            propagateEditResultValue(r)
            ()
         }
      }

      val iC = {
         ;

         lControlledRemote(summon[GivenSpinner1[String ] ] )(vr1R )(vr1W )
      }

      ;

      ;
   }

   ;
}
















val _ = {}
