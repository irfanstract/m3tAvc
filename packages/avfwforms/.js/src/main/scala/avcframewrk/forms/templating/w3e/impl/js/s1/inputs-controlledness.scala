package avcframewrk.forms

package templating

package w3e.impl.js

package s1
















/**
 * 
 * `BInputFunc`s and `lControlled`
 * 
 */
private[w3e]
trait ELaminarQckInputElemsLcs
extends
   AnyRef
   /* */
   with ENativeElementsD1
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

      lControlledRemote(typ)(src.toObservable )(dest = src.toObserver )
   }

   /**
    * Laminar `controlled` ;
    * same as `lControlled` except for the added `flatten` step (effectively SwitchMap-ing )
    * 
    */
   def lControlledRetypable
      [Value]
      (src : ([Value] =>> ((L.SignalSource[Value] & L.Var[Value ] ) & L.Sink[Value] ) )[(GivenSpinner1[Value] , Value ) ] )
   = {
      ;

      import L.{given}

      lControlledRetypableRemote(src.signal )(src.toObserver )
   }

   def lControlledRemote
      [Value]
      (typ: GivenSpinner1[Value])
      (src : L.Observable[Value] )
      (dest : L.Observer[Value] )
   = {
      ;

      import L.{given}

      L.controlled(
         //
         L.value <-- src.map(_.toString() )
         ,
         (
            L.onInput
            .mapToValue
            // .map(v => {
            //    org.scalajs.dom.console.log("inputed value raw: ", v )
            //    v
            // } )
            .map((
               typ.parse.lift
               match { case f => {
                  (v: String) => {
                     f(v)
                  }
               } }
            ) )
            .collect({ case Some(v) => v })
            .map(v => {
               if v.isInstanceOf[Boolean] then {
                  given Console = topLevelJsConsole
                  given_Console.info("inputed value parsed: ", v )
               }
               else {
                  given_Console.info("inputed value parsed: ", 
                     v ,
                  )
               }
               v
            } )
            // -->
            // (dest.onNext _ )
            .map(value => dest.onNext(value) )
            --> L.Observer.empty
         ) ,
      ) 
   }

   def lControlledRetypableRemote
      [Value]
      (src : ([Value] =>> L.StrictSignal[Value] )[(GivenSpinner1[Value] , Value ) ] )
      (dest : ([Value] =>> L.Observer[Value] )[(GivenSpinner1[Value] , Value ) ] )
      // (using Console )
   = {
      ;

      import L.{given}

      L.controlled(
         //
         L.value <-- src.map({ case (_, value) => value }).map(_.toString() )
         ,
         (
            L.onInput
            .mapToValue
            .map(newValue => { val (typ, _) = src.now() ; for (newValue1 <- typ.parse.lift.apply(newValue ) ) yield (typ, newValue1 ) } ).collect({ case Some(v) => v })
            .map({ case v @ (typ, vV ) => {
               if vV.isInstanceOf[Boolean] then {
                  given_Console.info("inputed value parsed: ", v )
               }
               v
            } })
            -->
            dest
         ) ,
      ) 
   }

   ;
}




















val _ = {}
