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
   type OptionsTranslativeFnc
   object OptionsTranslativeFnc
   {

      // sealed
      trait SharedExtensionalDefs[
         //
         C[R, V] ,

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

   }
   
   object BasicOptionsTranslativeFnc {

      type ByPackedForm[+R]
         = ByOptionUpperBoundAndPackedForm[Any, R ]

      type ByOptionUpperBoundAndPackedForm[-Option, +R]
         = Impl[R, Option ]

      import OptionsTranslativeFnc.SharedExtensionalDefs

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

      object Impl extends
      AnyRef
      {

         given (
            SharedExtensionalDefs[
               //
               [R, V] =>> Impl[R, ? >: V ] ,
               
            ]
         ) with {
            ;
            
            extension [R](prov : Impl[R, ? >: Boolean ] ) {
               
               def applyIOptIn() : R = {

                  prov
                  .apply[Boolean](allOptions = falseAndTrue, defaultItem = false )
               }
               
               def applyIBoolean() : R = {

                  prov
                  .apply(allOptions = falseAndTrue )
               }
               
            }
            
         }

      }

      object ByIsolatedResolver
      {

         //
         
         def apply[
            CC[+Item] >: collection.immutable.Iterable[Item] <: collection.immutable.Iterable[Item] ,
         ](
            //
            implSpawn: [Item] => (allOptions: CC[Item], assertedArity: Arity, r: Reslv[? >: CC[Item] ]) => (
               AnyRef
               & DefinesDoReassignSelectedItems.ByCcE[CC, Item]
            ) ,

         )
         = {
            val usrImplSpawn = implSpawn
            
            def impl[Item] = {
               avcframewrk.util.forms.controls.DefinesDoPrompt.ByTitleAndOptionsCallback[
                  CC[Item],
                  String,
                  XOptions[Item] ,
               ](
                  
                  implStart = (title, lowerOptions) => {

                     val options = {
                        lowerOptions.options
                     }

                     val i = {
                        ;
                        usrImplSpawn
                        .apply[Item](allOptions = options.options, assertedArity = options.enforcedArity, r = {
                           //
                           new Reslv[CC[Item] ](f = avcframewrk.util.LateBoundValue.byFuture(lowerOptions.asFuture ) )
                        } )
                     }

                     ()
                  } ,
               )(using avcframewrk.util.forms.controls.DefinesDoPrompt.ByTitleAndOptionsCallback.givenNonRepacking )
            }
            
            object main extends 
            BasicOptionsTranslativeFnc.ByOptionUpperBoundAndPackedForm[Any, (
               avcframewrk.util.forms.controls.DefinesDoPrompt.ByTitleAndOptionsCallback.givenNonRepacking.UnpackedFormByValueAsIs[CC[Any] ]
            )]
            {

               def apply[Item](
                  //
                  allOptions   : OptionsList[Item]   ,
                  arity        : Arity               ,
                  defaultItem  : Item | Null         ,

               ) : avcframewrk.util.forms.controls.DefinesDoPrompt.ByTitleAndOptionsCallback.givenNonRepacking.UnpackedFormByValueAsIs[CC[Item] ]
               = {

                  impl[Item]
                  .prompt(title = { (arity.min, arity.max) match { case (1, 1) => s"choose one" ; case (min, max) => s"choose (from $min to $max)" } } , options = {

                     new XOptions[Item](
                        //
                        options = allOptions.to(collection.immutable.Iterable ) ,
                        enforcedArity = arity ,
                     )
                  } )
               }
               
            }

            main
         }

         protected 
         class XOptions[V](
            // private[XOptions]
            val options: collection.immutable.Iterable[V] ,
            val enforcedArity: Arity ,
         )

         protected 
         class Reslv[V](
            private[Reslv]
            val f: avcframewrk.util.LateBoundValue.NhwCompleteWith[V] ,
         )
         {

            export f.{success, complete, tryComplete }

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
      
   }

   export Double.{PositiveInfinity as positiveInfinity }

}

;
















