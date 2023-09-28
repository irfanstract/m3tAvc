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

   extension [acv1$] (ed: BInputFunc[acv1$]) {
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

         lControlledRemote(ed.t )(ed.src.toObservable )((
            L.Observer((v: acv1$ ) => {
               val evtInfo
               = newIcrEditEventInfo()
               ed
               .onEditToNewValue(v, evtInfo ) 
            } )

            //
         ) )
      }

      //
   }

   object lValueNat {
      ;
      def <--
         [Value]
         (src: L.Source[Value] )
      = {
         L.value <-- src.toObservable.map(_.toString() )
      }
   }

   /**
    * Laminar `controlled`
    * 
    */
   def lControlled
      [Value]
      (typ: GivenSpinner1[Value])
      (src : L.SignalSource[Value] & L.Sink[Value] )
      (using IvpLogging[Value] )
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
      (using IvpLogging[Value] )
   = {
      ;

      import L.{given}

      lControlledRetypableRemote(src.signal )(src.toObserver )
   }

   /**
    * `lControlledRetypable` -
    * a version allowing separate `Source` and `Sink`
    * 
    */
   def lControlledRetypableRemote
      [Value]
      (src : ([Value] =>> L.StrictSignal[Value] )[(GivenSpinner1[Value] , Value ) ] )
      (dest : ([Value] =>> L.Observer[Value] )[(GivenSpinner1[Value] , Value ) ] )
      // (using Console )
      (using IvpLogging[Value] )
   = {
      ;

      import L.{given}

      L.controlled(
         //
         lValueNat <-- src.map({ case (_, value) => value })
         ,
         (
            L.onInput
            .mapToValue
            .map(newValue => { val (typ, _) = src.now() ; for (newValue1 <- typ.parse.lift.apply(newValue ) ) yield (typ, newValue1 ) } ).collect({ case Some(v) => v })
            .map({ case v @ (typ, vV ) => {
               ivpConsole
               .info("inputed value parsed: ", vV )
               v
            } })
            -->
            dest
         ) ,
      ) 
   }

   /**
    * `lControlled` -
    * a version allowing separate `Source` and `Sink`
    * 
    */
   def lReadonly
      [Value]
      (typ: GivenSpinner1[Value])
      (src : L.Observable[Value] )
      (using IvpLogging[Value] )
   = {
      ;

      import L.{given}

      lValueNat <-- src
   }

   /**
    * `lControlled` -
    * a version allowing separate `Source` and `Sink`
    * 
    */
   def lControlledRemote
      [Value]
      (typ: GivenSpinner1[Value])
      (src : L.Observable[Value] )
      (dest : L.Observer[Value] )
      (using IvpLogging[Value] )
   = {
      ;

      import L.{given}

      L.controlled(
         //
         lValueNat <-- src
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
               ivpConsole
               .info("inputed value parsed: ", v ) 
               v
            } )
            -->
            (dest.onNext _ )
         ) ,
      ) 
   }

   opaque type IvpLogging[-Value]
   = Console

   given Conversion[IvpLogging[Nothing] , Console]
   = identity[Console] _

   def ivpConsole(using impl : IvpLogging[Nothing] )
   : (impl.type & IvpLogging[Nothing] )
   = impl

   implicit
   // transparent
   inline def ivpConsoleNew[Value]
   : IvpLogging[Value]
   = {
      inline compiletime.erasedValue[Value => Value]
      match {
         case _ : (Boolean => Boolean) =>
            given_Console_1
         case _ : ((Nothing => Nothing ) | (Any => Any) ) =>
            compiletime.error("error: type-argument not specified, or set to Any or Nothing")
         case _ =>
            silentConsole
      }
   }

   def newIcrEditEventInfo()
   : org.scalajs.dom.Event
   = {
      ;

      new (org.scalajs.dom.Event)("avfwinputfieldevt", scalajs.js.undefined )
   }

   ;
}




















val _ = {}
