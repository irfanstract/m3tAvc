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

;

/** 
 * React's new `use()` hook ;
 * __requires `<Suspense>` boundary__
 * 
 */
object CommonValueofHook
{
   ;

   ;

   def useReturnValueOf
      [R]
      (
         //
         run: () => R
         ,
         dependencies: AvfwDependenciesArray
         ,
      )
   : R
   = {
      useValue(run() , dependencies )
   }

   def useValue
      [R]
      (
         //
         code: => R
         ,
         dependencies: AvfwDependenciesArray
         ,
      )
   : R
   = {
      MemoisingHook.useForValue(code, dependencies )
   }

   implicit
   object efbSearchImplicits
   {

      extension [R] (builder : Efb._AsDoneByFunction0[R ] ) {
         //

         /** 
          * memoised JS `async` run,
          * effectively `useValue(c, dependencies )`
          * 
          */
         def useReturnValue
            (
               //
            )
         : R
         = useValue(builder.evf.apply() , builder.dependencies )

         //
      }

      extension [R] (builder : Efb._AsDoneByFunction0[js.Promise[R] ] ) {
         //

         /** 
          * memoised JS `async` run,
          * effectively `useValue(c, dependencies )`
          * 
          */
         def useSearch
            (
               //
            )
         : js.Promise[R]
         = useValue(builder.evf.apply() , builder.dependencies )

         //
      }

   }

   def useAsyncFncCall
      [R]
      (
         //
         start: js.Function0[js.Promise[R] ]
         ,
         dependencies: AvfwDependenciesArray
         ,
      )
   : js.Promise[R]
   = {
      useValue(start() , dependencies )
   }

   // def describeSuspenseEnabledComponent
   //    [P <: typings.react.mod.Attributes ]
   //    (
   //       mainComponent: %%&& ?=> AvfwReactFunctionComponent[P],
   //       awComponent: AvfwReactFunctionComponent[P] ,
   //    )
   // : AvfwReactFunctionComponent[P]
   // = {
   //    ;

   //    mainComponent(using %%&&() )

   //    .pipeLooseSelf(c0 => {
   //       ;

   //       ReactComponent1.describe[P] (props => {
   //          ;

   //          val e
   //          = <+.apply(
   //             //
   //             suspenseEnabledFragmentComponent,
   //             key = "no-key" ,
   //             /** the sole child */
   //             describeElement(c0, props )
   //             ,
   //          )
   //          e
   //       })
   //    })

   //    .pipeLooseSelf(<:<.refl[AvfwReactFunctionComponent[P] ] )
   // }

   // trait %%&& {
   //    ;
   //    export typings.react.canaryMod.reactAugmentingMod.use
   // }
   // final
   // lazy val %%&&
   // = () => (new AnyRef with %%&& )

   // // TEST-ONLY
   // if false then {
   //    describeSuspenseEnabledComponent (ctx ?=> {
   //       ReactComponent1.describe((e: AnyRef ) => {
   //          // val value = ctx.use(??? : js.Promise[5] )
   //          ???
   //       })
   //    } , awComponent = ??? )
   // }

   export typings.react.mod.{useTransition as useTransition0 }

   ;

   ;
}

/** 
 * React requires `<Suspense>` boundary for that ;
 * here's one to do that
 * 
 */
final
lazy val suspenseEnabledFragmentComponent
= {
   ;
   import ReactComponentsImplicit.asFunctionComp
   typings.react.mod.Suspense
   .asFunctionComp
}

;

;

;

;

;













val _ = {}
