package avcframewrk.forms

package templating

package reactjs_s1













import scalajs.js

import org.scalajs.dom

import dom.console

;

/** 
 * `typings.react.mod.FunctionComponent` which is contra-variant
 * 
 */
type AvfwReactFunctionComponent[-P]
=
   typings.react.mod.FunctionComponent[? >: P ]

/** 
 * `typings.react.mod.ExoticComponent` which is contra-variant
 * 
 */
type AvfwReactExoticComponent[-P]
=
   typings.react.mod.ExoticComponent[? >: P ]

object ReactComponentsImplicit {
   ;

   export ReactComponent1.implicits.{*, given }

}

object ReactComponent1
{
   ;

   ;

   ;

   /** 
    * 
    * React LW component
    * 
    * should be possible to use conventional lambda syntax like
    * 
    * ```
    * ReactComponent1.describe((props, ref ) => {
    *    ...
    *    ...
    *    &lt;.div((
    *       Nil
    *       :+ &lt;.button(`type` = "button", "do the simple action" )
    *    ))
    * } )
    * ```
    */
   def describe
      [_Props ]
      (f: (
         js.Function1
         // Function1
            [_Props, ReactNode ]
      ) )
   : AvfwReactFunctionComponent[_Props]
   = {
      ((
         f
         // .pipeLooseSelf({ case f : (t1 => r1) => (f.apply _ ) : js.Function1[t1, r1] })
         .asInstanceOf[AvfwReactFunctionComponent[_Props] ]
      ))
   }

   /** 
    * 
    * React LW component
    * 
    * due to the lack of proper support for `ExoticComponent`s,
    * needs to masquerade it as if were a regular `FC`, via `.asInstanceOf`,
    * 
    * without incurring any RT overhead
    * 
    */
   def fromExoticComponent
      [_Props ]
      (f: typings.react.mod.ExoticComponent[_Props] )
   : AvfwReactFunctionComponent[_Props]
   = {
      f
      .asInstanceOf[AvfwReactFunctionComponent[_Props] ]
   }

   /** 
    * 
    * React LW component ;
    * like `describe`, but may reject-and-throw
    * 
    */
   // TODO
   def describeRejectible
      [_Props ]
      (f: (
         PartialFunction[_Props, ReactNode ]
      ) )
   = {
      ReactComponent1.describe(f.apply _ )
   }

   object implicits {
      ;

      ;

      extension
         [_Props <: Any ]
         (f: typings.react.mod.ExoticComponent[_Props] )

         /** 
          * 
          * React LW component
          * 
          * due to the lack of proper support for `ExoticComponent`s,
          * needs to masquerade it as if were a regular `FC`, via `.asInstanceOf`,
          * 
          * without incurring any RT overhead
          * 
          */
         transparent
         inline
         def asFunctionComp
         = fromExoticComponent(f)

   }

   ;
}

object Fragment {
   ;

   ;

   // def l
   //    (es: ReactNode* )
   // = {
   //    describeElement(typings.react.mod.Fragment , null, es : _* )
   // }

   /** 
    * due to the lack of proper support for `ExoticComponent`s,
    * needs to masquerade it as if were a regular `FC`
    * 
    */
   final
   lazy
   val _C
   : AvfwReactFunctionComponent[typings.react.anon.Children ] 
   = {
      import ReactComponent1.implicits.{*, given }
      typings.react.mod.Fragment
      .asFunctionComp
   }

   ;
}

/** 
 * 
 * React fwd-ref components
 * 
 * ```
 * SelfReferentiableRComponent.describe((props, ref ) => {
 *    ...
 *    ...
 *    IonApp.describe(
 *       //
 *       ref = (c) => ref.propagate(c.nativeAppCompHandle )
 *       ,
 *       ...
 *       ...
 *       ...
 *    )
 * } )
 * ```
 * 
 * note - don't overuse *refs* -
 * only use *refs*-based-passing where necessary, and
 * oftentimes
 * those stuffs are backend-specific facilities being better be abstracted out
 * 
 */
object SelfReferentiableRComponent
{
   ;

   ;

   ;

   /** 
    * 
    * React fwd-ref component
    * 
    * should be possible to use conventional lambda syntax like
    * 
    * ```
    * SelfReferentiableRComponent.describe((props, ref ) => {
    *    ...
    *    ...
    *    &lt;.IonDragHandlingComponent.describe(containmentNativeRef = ref , ... ... ... )
    * } )
    * ```
    */
   def describe
      [_InstantiatedForm, _Props ]
      (f: (
         // typings.react.mod.Ref[_InstantiatedForm] => ReactElement
         // typings.react.mod.ForwardRefRenderFunction[_InstantiatedForm, _Props]
         js.Function2[_Props, typings.react.mod.ForwardedRef[_InstantiatedForm], ReactNode ]
      ) )
   = {
      typings.react.mod.forwardRef[_InstantiatedForm, _Props] ((
         f
         .asInstanceOf[typings.react.mod.ForwardRefRenderFunction[_InstantiatedForm, _Props] ]
      ))
   }

   ;
}

object ReactCtx
{
   ;

   ;

   type _Any
   >: typings.react.mod.Context[?]
   <: typings.react.mod.Context[?]

   /* `Of` deserves to be *invariant* ; we introduce variant, `WhichYields`, a *co-variant* one */

   type _Of[T]
   = _Any & typings.react.mod.Context[T]

   type _WhichYields[+T]
   = _Any & typings.react.mod.Context[? <: T]

   ;

   // TODO
   extension [R] (c: _WhichYields[R] ) {
      //

      /** 
       * a tree/hierarchy making use of ctx value given
       * 
       */
      @annotation.experimental
      def receivingElements
         // (e:  )
      : ReactElement
      = {
         ;
         describeElement(c.ConsumerFC , null, ??? : _* )
      }

      def ConsumerFC
      = {
         import ReactComponent1.implicits.asFunctionComp
         c.Consumer.asFunctionComp
      }
   }

   ;
}

;

;













val _ = {}
