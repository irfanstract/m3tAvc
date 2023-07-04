package avcframewrk.util.forms.controls


















;

object MultipleChoice {
   
   /**
    * 
    * instances of the main `trait`
    * defines
    * the minimum set of parameters necessary to (re)construct a *multiple-choice*'s *options*
    * 
    */
   object BasicOptionsTranslativeFnc {

      type ByPackedForm[+R]
         = ByOptionUpperBoundAndPackedForm[Any, R ]

      type ByOptionUpperBoundAndPackedForm[-Option, +R]
         = Impl[R, Option ]

      private[BasicOptionsTranslativeFnc]
      trait Impl[+R, -SharedItemOps] {

         /**
          * 
          * generic
          * options-list
          * 
          */
         type OptionsList[+Item]
            >: MultipleChoice.OptionsIterable[Item]
            <: MultipleChoice.OptionsIterable[Item]

         /**
          * 
          * for a prompt for selecting one of the items in `options`
          * 
          * @param allOptions    - the set of all the selectible item(s)
          * @param arity         - a `Arity { step: 1 }` defining the acceptable number of selections. defaults to `(1, 1)`
          * @param defaultItem   - defaults to `null`
          * 
          */
         def apply[Item](
            //
            allOptions   : OptionsList[Item]   ,
            arity        : Arity               = ArityPrecisely(1, 1) ,
            defaultItem  : Item | Null         = null ,

         ) : R

      }

      object Impl {

         extension [R](prov : Impl[R, ? >: Boolean ] ) {
            
            /**
             * 
             * for a prompt for opt-in(s) -
             * are Boolean prompt, defaulting to `false`
             * 
             */
            def applyIOptIn() : R = {

               prov
               .apply[Boolean](allOptions = falseAndTrue, defaultItem = false )
            }
            
            /**
             * 
             * for a prompt for Boolean choice -
             * are Boolean prompt, without default-value
             * 
             */
            def applyIBoolean() : R = {

               prov
               .apply(allOptions = falseAndTrue )
            }
            
         }
         
      }

   }

   /**
    * 
    * list arity
    * 
    */
   type Arity
      >: ArityPrecisely[?, ? ]
      <: ArityPrecisely[?, ? ]

   case class ArityPrecisely[
      +Min <: Int,
      +Max <: Int | positiveInfinity.type ,
   ](
      min : Min ,
      max : Max ,
   )
   { 

      val maxValueD = { max.asInstanceOf[java.lang.Number].doubleValue() }

      require((
         true
         && (0 <= min && min <= maxValueD )
         
      ) , s"invalid spec: ($min, $max)" ) 
      
   }

   /**
    * 
    * the upper-bound of *options-list* when describing *options*
    * 
    * this should be *immutable* ones, in which case
    * the immutability of the list means, no need for specially treating it .
    * for flexibility
    * we widened this to general `collection.Iterable[Item]`, where
    * if the *coll* subsequently mutates, the display module shall animate/refresh/update to reflect the changes;
    * there are obvious limitations when it doesn't provide any *on-change* notif point, use periodic refresh instead.
    * (for JS, this will necessitate using libraries like Polymer, Vue, Angular, ReactDOM, JQuery, etc.
    * for Swing, this will effectively render `JOptionPane` incompatible as they only supports *plain array*s )
    * 
    */
   type OptionsIterable[+Item]
      >: collection.Iterable[Item]
      <: collection.Iterable[Item]
   
   /**
    * 
    * `OptionsIterable(false, true)`
    * 
    */
   final
   lazy val falseAndTrue : OptionsIterable[Boolean] = {

      Set(false, true )
   }

   export Double.{PositiveInfinity as positiveInfinity }

}

;
















