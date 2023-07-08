package avcframewrk.util.forms.controls


















;

@deprecated("a misnomer for 'MultipleChoiceProblem'.")
final
lazy val MultipleChoice
   : MultipleChoiceProblem.type
   = MultipleChoiceProblem  

object MultipleChoiceProblem {

   /**
    * 
    * instances of the main `trait`
    * defines
    * `apply(....)` with
    * the minimum set of parameters necessary to (re)construct a *multiple-choice*'s *options*
    * 
    */
   type OptionsTranslativeFnc
   object OptionsTranslativeFnc
   {

      // sealed
      trait SharedExtensionalDefs[
         //
         C[R, -V] ,

      ]
      {

         extension [R](prov : C[R, Boolean ] ) {
            
            /**
             * 
             * for a prompt for opt-in(s) -
             * are Boolean prompt, defaulting to `false`
             * 
             */
            def applyIOptIn() : R
            
            /**
             * 
             * for a prompt for Boolean choice -
             * are Boolean prompt, without default-value
             * 
             */
            def applyIBoolean() : R
            
         }
         
      }

      //

   } /* `OptionsTranslativeFnc` */
   
   /**
    * 
    * list arity
    * 
    */
   type Arity
      >: ArityPrecisely[?, ? ]
      <: ArityPrecisely[?, ? ]

   /**
    * 
    * note that `min` and `max` are both each *inclusive*
    * 
    */
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

      def containsValue(v: Int): Boolean = {

         (min <= v ) && (v <= maxValueD )
      }
      
   } /* `ArityPrecisely` */

   /**
    * 
    * must be left `implicit` and
    * defines these important `extension def`s
    * 
    */
   implicit
   object apx extends
   AnyRef
   {

      extension (arity : ArityPrecisely[?, ?] ) {

         def toLocaleXImperativeString(): String = {

            (arity.min, arity.maxValueD)
            match {
               case (0, 1) =>
                  s"choose one if u want"
               case (0, n) if (1 <= n) =>
                  s"choose up to $n"
               case (1, 1) =>
                  s"choose one"
               case (1, n) if (1 < n) =>
                  s"choose one up to $n"
               case (min, Double.PositiveInfinity ) =>
                  s"choose $min or more"
               case (min, max) =>
                  s"choose (from $min to $max)" 
            }
         }

      }

   } /* `apx` */

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

   object DefinesDoReassignSelectedItems
   {

      trait ByCcE[-CC[+Item0], -Item1 ]
      {

         def setSelectedItems(v: CC[Item1] ): Unit
         
      }

      /**
       * 
       * be `ByCcE[collection.immutable.Iterable, Item ]`
       * 
       */
      type ByE[-Item]
         = ByCcE[collection.immutable.Iterable, Item ]
      
   } /* `DefinesDoReassignSelectedItems` */

}

;
















