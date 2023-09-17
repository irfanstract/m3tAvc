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
      def scanSpawnNewLlE()
      : ln.ReactiveHtmlElement[? ]
      = {
         ;

         import laminar.api.L

         enum ICM {
            case ToSubmitOnBlur()
            @deprecated /* it's collectively broken */
            case ToSubmitImmediately()
         }

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
               ({
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
               ({
                  ;

                  import L.{given }

                  L.input(iC , L.typ := nativeTypStrFor(summon[GivenSpinner1[Value ] ] ) )
               })

            case ICM.ToSubmitOnBlur() =>
               ;

               val vr1 = L.Var[String]("")

               s
               .map(_.value)
               .map(e => vr1.set(e.toString() ) )
               .observe(using com.raquo.airstream.ownership.ManualOwner() )

               def flush()
               : Unit
               = {
                  ;

                  val valueRaw = vr1.now()
                  org.scalajs.dom.console.log(s"trying parse and submit", valueRaw, summon[GivenSpinner1[Value ] ] )
                  for { r <- (summon[GivenSpinner1[Value ] ].parse.lift ).apply(valueRaw ) }
                  yield {
                     vr1.set("")
                     propagateEditResultValue(r)
                  }
               }

               val iC = {
                  ;

                  lControlled(summon[GivenSpinner1[String ] ] )(vr1 )
               }

               // TODO
               lazy val e1 : ln.ReactiveHtmlElement[?]
               = {
                  ;

                  L.input(iC, L.typ := nativeTypStrFor(summon[GivenSpinner1[Value ] ] ), {
                     import L.{given }
                     ;
                     L.onBlur --> (e => {
                        if false then org.scalajs.dom.console.log(e)
                        flush()
                     })
                  } )
               }
               e1

            //
            case e if false =>
               ???

            //
         }

      }

      //
   }

   ;
}
















val _ = {}
