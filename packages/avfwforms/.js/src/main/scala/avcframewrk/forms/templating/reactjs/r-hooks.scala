package avcframewrk.forms

package templating

package reactjs













import scalajs.js

import org.scalajs.dom

import dom.console

;

object ReactWithinRender {
   ;

   ;

   /** 
    * `useState`
    * 
    */
   object StateHook
   extends
   AnyRef
   with ToUseWithInitialValue._ByCForSt[[S] =>> (S, (newState: typings.react.mod.SetStateAction[S] ) => Unit ) ]
   {
      ;

      def useWithInitialValue
         [S](initialValue: => S )
      = {
         ;
         typings.react.mod.useState[S ](initialState = () => initialValue )
         .pipeLooseSelf({
            case js.Tuple2(value, value_=) =>
               (value, value_=)
         })
      }

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
   with ToUseWithInitialValue._ByCForSt[[S] =>> (S, (newRefValue: S | Null ) => Unit ) ]
   {
      ;

      def useWithInitialValue
         [S](initialValue: => S )
      = {
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
               (existingValue, {
                  (newValue0: S | Null ) =>
                     val newValue
                     = Option(newValue0 ).collect[S]({ case v : S => v }).fold[S](initialValue )(<:<.refl )
                     state_=(v0 => newValue )
               } )
         })
      }

      ;
   }

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

      ;
   }

   // TODO
   object MemoisingHook {
      //

      //

      export typings.react.mod.{
         useMemo as useForValue ,
         useCallback as useForCallback ,
      }

   }

   export typings.react.mod.{useRef as useRefHolder }

   /** 
    * a hook to handle diffing across consecutive redraws
    * 
    * you might actually not need to use this at all.
    * 
    */
   object ConsecutiveRedrawDigestiveHook {
      ;

      ;

      /** 
       * `ConsecutiveRedrawDigestiveHook`
       * 
       * *synchronously*
       * 
       */
      def useByFnc
         [Value]
         (
            digestAppropriately: js.Function1[Value, Value],
            initialValue: => Value
            = null
            ,
            // whenToRun : ReSubscriptiveHook._When
            // ,
         )
         (using util.NotGiven[Any <:< Value ] )
      : Value
      = {
         ;

         val holder
         = useRefHolder[Value ] (initialValue = initialValue )

         digestAppropriately(holder.current)
         .pipeLooseSelf(newValue => { holder.current = newValue } )

         holder.current
      }

      ;
   }

   /** 
    * you meant `ConsecutiveRedrawDigestiveHook`
    * 
    */
   final
   lazy val CrossRedrawDigestiveHook
   : ConsecutiveRedrawDigestiveHook.type
   = ConsecutiveRedrawDigestiveHook

   object ReSubscriptiveHook
   {
      ;

      ;

      type DisposeFnc
      = typings.react.mod.Destructor

      export typings.react.mod.{useSyncExternalStore as useSynchronouslyScan }

      // def useSynchronouslyScan
      //    [Snapshot]
      //    (subscribe: js.Function1[js.Function0[Unit], js.Function0[Unit]], getSnapshot: js.Function0[Snapshot]): Snapshot

      /** 
       * a Hook `ReSubscriptiveHook`
       * 
       * ```
       * useVoidly(Nil :+ srcUrl :+ userInfo :+ sessionToken )(() => {
       *    // MAKE SUBSCRIPTION
       *    val subscr = doSubscribe ... ...
       *    // RETURN THE 'java.io.Closeable'
       *    subscr
       * })
       * ```
       * 
       * `dependencies` is a-must here .
       * also,
       * `makeSubscription`'s return-value
       * needs to be a "subscriptional handle" which also `extends` `java.io.Closeable`
       * (since `Function0[Unit]` (JVM or JS) is unsemantic )
       * 
       * the default for `when` would be `_When.OnLayout()` -
       * hence, `useLayoutEffect`
       * 
       * _note that, for `Synchronously` (hence, `useInsertionEffect`)_,
       * there are some restrictions imposed by React -
       * can't make any `setState` nor `reduce` call
       * 
       */
      def useVoidly
         //
         /**
          * hopefully, in SJS,
          * `close()` from `java.io.Closeable` erases directly to `close()` without any chg ...
          * we need it to be `?{ def close() }`, because
          * `Function0[Unit]` (JVM or JS) is unsemantic
          */
         [SubscrHandleT <: java.io.Closeable ]
         (
            //
            dependencies: Seq[Any]
            ,
            when: _When = _When.OnLayout()
            ,
         )
         (makeSubscription: (
            /* still not sure if this should be `js.FunctionN`, rather than regular `std.FunctionN` */
            js.Function0[java.io.Closeable ]
         ) )
      : Unit
      = {
         ;

         val makeSubscriptionAndGetDisposeFnc
         = {
            locally[js.Function0[DisposeFnc ] ] (() => {
               val subscription
               = makeSubscription()
               (subscription.close _ ) : js.Function0[Unit]
            })
         }

         when match
         case _When.Deferredly()      => typings.react.mod.useEffect         (makeSubscriptionAndGetDisposeFnc , js.Array(dependencies : _* ) )
         case _When.OnLayout()        => typings.react.mod.useLayoutEffect   (makeSubscriptionAndGetDisposeFnc , js.Array(dependencies : _* ) )
         case _When.Synchronously()   => typings.react.mod.useInsertionEffect(makeSubscriptionAndGetDisposeFnc , js.Array(dependencies : _* ) )
      }

      enum _When {
         case Synchronously()
         case OnLayout()
         case Deferredly()
      }

      ;
   }

   /** 
    * `RjsImperativeHandlePropagativeHook`
    * 
    * note - you might not need this
    * 
    */
   object RjsImperativeHandlePropagativeHook {
      ;

      export typings.react.mod.{useImperativeHandle as use1 }

   }

   ;
}

export typings.react.mod.{
   useState as useStateHook0 ,
   useReducer as useDigestHook0 ,
}

export typings.react.mod.{
   useMemo as useMemoisingHook ,
   useCallback as useCallback ,
}

;













val _ = {}