package avcframewrk.forms

package templating

package reactjs

package renderfncs













import scalajs.js

import org.scalajs.dom

import dom.console

;

;

;

;

/** 
 * `useState`
 * 
 */
final
lazy val StateHook
= {
   new AnyRef
   with
   ToUseWithInitialValue._Impl
      [[S] =>> (S, (newState: typings.react.mod.SetStateAction[S] ) => Unit ) ]
      (impl = [S] => (initialValue: DummyImplicit ?=> S ) => {
         ;

         val js.Tuple2(value, reassignValueAsync)
         = {
            typings.react.mod.useState[S ](initialState = () => initialValue )
         }

         (
            value
            ->
            (reassignValueAsync.apply _ )
            .memoisedAcrossRedraw(dependencies = Nil :+ reassignValueAsync )
         )
      } )
}

/** 
 * `useState`-like, for *refs*
 * 
 * the dispatcher returned from here
 * can be guaranteed to not treat `FunctionN`s specially --
 * as specified by the React docs,
 * the `setState` fnc
 * will behave specially for `js.Function`s,
 * but such behaviour is unacceptable here
 * 
 */
object RefStateHook
extends
AnyRef
with ToUseWithInitialValue._Impl[[S] =>> (S, (newRefValue: S | Null ) => Unit ) ](
   //
   impl = [S] => (initialValue: DummyImplicit ?=> S ) => {
      ;

      ReactWithinRender.StateHook.useWithInitialValue[S] (initialValue = initialValue )

      /** 
       * as specified by the React docs,
       * the `setState` fnc
       * will behave specially for `js.Function`s,
       * but such behaviour is unacceptable here,
       * so
       * this indirection becomes necessary
       * 
       */
      .pipeLooseSelf({
         case (existingValue, state_=) =>
            ;

            (existingValue, {
               //
               (((newValue0: S | Null ) =>
                  ;

                  state_=(v0 => newValue0.nnOrElse(initialValue ) )

               ) )
               .memoisedAcrossRedraw(dependencies = Nil :+ state_= )
            } )
      })
   } ,
)

/** 
 * `useState` and `useRefState`
 * define `useInitiallyNull`
 * 
 * a side-trait which defines these set of methods each together with *doc*
 * 
 */
object ToUseInitiallyNull
{
   ;

   type _Any
   = _ByCForSt[? <: [_] =>> AnyRef & Product ]

   trait _ByCForSt[+C[St] <: AnyRef & Product ]
   extends
   AnyRef
   {

      /** 
       * use one at this point, initially `null`
       * 
       */
      def useInitiallyNull
         [S]
      : C[S | Null ]
   }

   ;
}

object ToUseWithInitialValue
{
   ;

   type _Any
   = _ByCForSt[? <: [_] =>> AnyRef & Product ]

   trait _ByCForSt[+C[St] <: AnyRef & Product ]
   extends
   AnyRef
   with ToUseInitiallyNull._ByCForSt[C ]
   {

      def useInitiallyNull[S]
      = useWithInitialValue[S | Null ] (initialValue = null )

      /** 
       * use `useInitially` with `compiletime.erasedValue`
       * 
       * ```
       * import compiletime.erasedValue
       * import reactjs.ReactInRender
       * 
       * ReactInRender.StateHook.useInitially(erasedValue[State] , (initialValue) )
       * ```
       * 
       */
      inline
      def useInitially
         [S](inline s0: S, initialValue: => S )
      = useWithInitialValue[S ] (initialValue = initialValue )

      /** 
       * use one at this point
       * 
       */
      def useWithInitialValue
         [S](initialValue: => S )
      : C[S ]
   }

   trait _Impl
      [+C[St] <: AnyRef & Product ]
      (impl: [S] => (initialValue: DummyImplicit ?=> S ) => C[S] )
   extends
   AnyRef
   with _ByCForSt[C]
   {
      ;

      def useWithInitialValue
         [S](initialValue: => S )
      = impl.apply[S] (initialValue)
   }

   ;
}

implicit
object ssImplImplicits {
   //

   export MemoisingHook.implicits.memoisedAcrossRedraw

   ;

   extension [S0] (value: S0 | Null ) {
      //

      def nnOrElse
         [InitialValI]
         (initialValue: => InitialValI )
         // (using util.NotGiven[S <:< Null ] )
      : ((value.type & S0 ) | InitialValI )
      = {
         ;

         type S
         >: value.type & S0
         <: value.type & S0

         Option[S | Null ] (value : ((value.type & S0 ) | Null ) )
         .collect[S]({ case v : S => v })
         .fold[S | InitialValI ](initialValue )(<:<.refl )
      }
   }

}

;

;

;













val _ = {}
