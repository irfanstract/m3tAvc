package avcframewrk.forms

package templating

package ext.givmk


















/**
 * 
 * some fw(s), like Swing,
 * makes distinction between "button component" and "button model" -
 * a "button model" are essentially "callback-function"s, and
 * a single "button model" can be assigned to multiple "button component" at once (but the converse is untrue!!!), and
 * the properties of the receiving "button component" will animate in sync with changes to the assigned "button model" .
 * chances are
 * recent fw(s) are doing the same thing
 * 
 */
object ButtonModel
{
   ;

   ;

   protected
   val ssco
   = ImplDefinedDataType._Def.BasicStaticScopedOps()

   export ssco.{*, given }

   ;
}

/**
 * 
 * some fw(s), like Swing,
 * makes distinction between "button component" and "button model" -
 * a "button model" are essentially "callback-function"s, and
 * a single "button model" can be assigned to multiple "button component" at once (but the converse is untrue!!!), and
 * the properties of the receiving "button component" will animate in sync with changes to the assigned "button model" .
 * chances are
 * recent fw(s) are doing the same thing
 * 
 */
object CallbackButtonModel
{
   ;

   ;

   /**
    * summon a `CallbackButtonModel` with given constraints
    * 
    */
   transparent inline
   def apply
      //
      (using artism : Article._Allocator )
      (label: => artism.CAP )
      (using eventism : Event._Allocator )
      (using fromXDescToArtConv : FromCbConv.ForLabelAndCbArg[artism.CAP, eventism.CAP ] )
      // [F <: fromXDescToArtConv.FMin ] /* wait until `language.clauseInterweaving` no longer `@experimental` */
      (f: fromXDescToArtConv.FMin )
   : artism.CAP
   = {
      fromXDescToArtConv(label = label )(f)
   }
 
   /**
    * implements
    * the conversion from `(R, Function1)` to some `ButtonModelAllocator`'s `.CAP`
    * 
    */
   object FromCbConv
   {
      ;

      ;

      /**
       * for the given `Label` and `CallBackFncArg`
       * 
       */
      opaque
      type ForLabelAndCbArg[Lbl, +CbArg]
      <: PccGeneralisedFactoryImpl[? >: Lbl <: Lbl , PartialFunction[? >: CbArg, Unit | Boolean ] ]
      =  PccGeneralisedFactoryImpl[? >: Lbl <: Lbl , PartialFunction[? >: CbArg, Unit | Boolean ] ]

      ;
   }

   ;

   ;

   ;
}




















val _ = {}