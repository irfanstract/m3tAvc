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

;

// TODO
object MemoisingHook {
   //

   //

   /** 
    * `React.useCalllback()`
    * 
    */
   def useForCallback
      [C](f: C, dependencies: AvfwDependenciesArray)
   = useForValue(f, dependencies = dependencies )

   /** 
    * `React.useMemo()` .
    * for convenience, and to be consistent with the rest of Scala,
    * we unlifted it to be by-name, `value : => Value`
    * 
    */
   def useForValue
      [Value]
      (value: => Value, dependencies: AvfwDependenciesArray )
   = {
      typings.react.mod.useMemo(() => value , dependencies.toNative() )
   }

   implicit
   object implicits
   {
      ;

      //

      extension [R] (fAndDependencies: Efb._AsDoneByFunction0[R] )
         def applyMemoisingHook
            //
            ()
         : R
         = MemoisingHook.useForValue(fAndDependencies.evf.apply() , fAndDependencies.dependencies )

      //

      extension [C](f: C)
         @deprecated
         def memoisedAcrossRedraw
            (dependencies: (
               AvfwDependenciesArray
            ) )
         : C
         = {
            Efb.ofValueDoneByByNameEv(f, dependencies )
            .applyMemoisingHook()
         }

   }

}

;

export MemoisingHook.implicits.applyMemoisingHook

;

;

;

;













val _ = {}
