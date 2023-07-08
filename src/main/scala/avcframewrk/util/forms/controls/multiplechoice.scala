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

   }
   
   object XDescriptor {

      sealed
      trait Ops[ItemImpl]
      {

         type Item = ItemImpl

         val supposedAllOptions: collection.immutable.Iterable[Item]

         val defaultOption: collection.immutable.Iterable[Item]

         val enforcedArity: Arity

      }

      //
      
   }

   case class XDescriptor[Item](

      val supposedAllOptions: collection.immutable.Iterable[Item] ,

      val defaultOption: collection.immutable.Iterable[Item] = Seq() ,

      val enforcedArity: Arity ,

   )
   extends
   AnyRef with XDescriptor.Ops[Item]
   {

      require(enforcedArity.copy(min = 0                      ) containsValue(defaultOption.size      ), s"'defaultOption.size' exceeds `enforcedArity.max` " )
      require(enforcedArity.copy(max = Double.PositiveInfinity) containsValue(supposedAllOptions.size ), s"'supposedAllOptions' does not provide enough cardinality for the enforced arity " )

   }
   
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
      
   }

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
            >: MultipleChoiceProblem.OptionsIterable[Item]
            <: MultipleChoiceProblem.OptionsIterable[Item]

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

         given sharedOps : (
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

         // import reflect.Selectable.reflectiveSelectable

         //

         export collection.immutable.{Iterable => CcIi }

         // opaque type ClientSideCallbackCtxOps
         //    <: Reslv.ByItemAndCc[? >: Item, ? >: [E] =>> CC[E] <: [_] =>> Any ]
         //    = Reslv.ByItemAndCc[? >: Item, ? >: [E] =>> CC[E] <: [_] =>> Any ]

         trait **@[CC[+Item0] ]
            {
               val SpawningImpl : {
                  type CtxOps[Item]
                     >: Reslv.ByItemAndCc[? >: Item, ? >: [E] =>> CC[E] <: [_] =>> Any ]
                     <: Reslv.ByItemAndCc[? >: Item, ? >: [E] =>> CC[E] <: [_] =>> Any ]
               }
            }
         given `given_**@_CC`[CC[+_] ] : **@[CC ] with {
            object SpawningImpl {
                  type CtxOps[Item]
                     >: Reslv.ByItemAndCc[? >: Item, ? >: [E] =>> CC[E] <: [_] =>> Any ]
                     <: Reslv.ByItemAndCc[? >: Item, ? >: [E] =>> CC[E] <: [_] =>> Any ]
            }
         }

         def apply[
            CC[+Item]
               >: CcIi[Item]
               <: CcIi[Item]
            ,
         ](using typer : **@[CC] )(
            //
            implSpawn: (
               [Item]
               =>
               (ctx: typer.SpawningImpl.CtxOps[Item] )
               =>
               (
                  AnyRef
                  & DefinesDoReassignSelectedItems.ByCcE[CC, Item]
               )
            ) ,

         )(using ValueOf[Tuple1.type ] )
         = {

            applyImpl[
               CC ,
            ](
               //
               usrImplSpawn = (
                  [Item]
                  =>
                  (allOptions: CC[Item], assertedArity: Arity, ctx: Reslv.ByItemAndCc[? >: Item, ? >: [E] =>> CC[E] <: [_] =>> Any ] )
                  =>
                  {
                     implSpawn[Item](ctx)
                  }
               ) ,
            )
         }
         
         def apply[
            CC[+Item]
               >: CcIi[Item]
               <: CcIi[Item]
            ,
         ](using typer : **@[CC] )(
            //
            implSpawn: (
               [Item]
               =>
               (allOptions: CC[Item], assertedArity: Arity, ctx: typer.SpawningImpl.CtxOps[Item] )
               =>
               (
                  AnyRef
                  & DefinesDoReassignSelectedItems.ByCcE[CC, Item]
               )
            ) ,

         )(using ValueOf[Tuple3.type ] )
         = {

            applyImpl[
               CC ,
            ](
               //
               usrImplSpawn = implSpawn ,
            )
         }
         
         protected 
         type Reslv[V]
            // = Reslv.ByValue[V]
         protected 
         object Reslv {

            // /**
            //  * 
            //  *
            //  * @param f
            //  */
            // type ByValue[V] = ByItemAndCc[]
            
            /**
             * 
             *
             * @param f
             */
            case class ByItemAndCc[Item, CC[+E] ](
               //

               private[Reslv]
               val f: avcframewrk.util.LateBoundValue.NhwCompleteWith[CC[Item] ] ,

               private[Reslv]
               val peerSpwOptionsArgOps : XPeerSpawnOptionsArgOps[Item ]
               
            )
            {

               export f.{success, complete, tryComplete }

               val setDescriptor : XDescriptor[Item] = {

                  peerSpwOptionsArgOps
               }

               export setDescriptor.enforcedArity
               export setDescriptor.supposedAllOptions

            }

         }

         protected 
         type XPeerSpawnOptionsArgOps[Item]
            >: MultipleChoiceProblem.XDescriptor[Item]
            <: MultipleChoiceProblem.XDescriptor[Item]
         
         protected 
         final lazy
         val XPeerSpawnOptionsArgOps
            : MultipleChoiceProblem.XDescriptor.type
            = MultipleChoiceProblem.XDescriptor

         summon[(
            (Any => String )
            <:<
            (Seq[?] => String )
         )]
         
         summon[(
            ([T] => Any => 5 => String )
            <:<
            Any
         )]

         private 
         def applyImpl[
            CC[+Item]
               >: CcIi[Item]
               <: CcIi[Item]
            ,
         ](
            //
            usrImplSpawn: [Item] => (allOptions: CC[Item], assertedArity: Arity, r: Reslv.ByItemAndCc[? >: Item, ? >: [E] =>> CC[E] <: [_] =>> Any ] ) => (
               AnyRef
               & DefinesDoReassignSelectedItems.ByCcE[CC, Item]
            ) ,

         )
         = {
            
            /**
             * 
             * a backing `DefinesDoPrompt`
             * 
             */
            def promptor[Item] = {
               avcframewrk.util.forms.controls.DefinesDoPrompt.ByTitleAndOptionsCallback[
                  CC[Item],
                  String,
                  XPeerSpawnOptionsArgOps[Item] ,
               ](
                  
                  implStart = (title, nativeCtx) => {

                     import nativeCtx.{options as opao }

                     import nativeCtx.{success, complete, tryComplete}

                     /**
                      * truly run `usrImplSpawn`
                      */
                     val uispReturnValue = {
                        ;
                        
                        usrImplSpawn[Item](
                           //
                           
                           allOptions    = opao.supposedAllOptions  ,
                           assertedArity = opao.enforcedArity       ,
                           
                           r = {
                              new Reslv.ByItemAndCc[Item, CC ](
                                 //
                                 f = {
                                    avcframewrk.util.LateBoundValue.forTrialCallback({
                                       case tr =>
                                          complete(tr) 
                                    })
                                 } ,
                                 peerSpwOptionsArgOps = opao ,
                                 
                              )
                           } ,

                        )
                     }

                     /**
                      * default the selection, to the requested set of items
                      */
                     uispReturnValue
                     .setSelectedItems(opao.defaultOption )

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
                  allOptions   : MultipleChoiceProblem.OptionsIterable[Item]   ,
                  arity        : Arity               ,
                  defaultItem  : Item | Null         ,

               ) : avcframewrk.util.forms.controls.DefinesDoPrompt.ByTitleAndOptionsCallback.givenNonRepacking.UnpackedFormByValueAsIs[CC[Item] ]
               = {

                  val promptCaption = {

                     arity.toLocaleXImperativeString()
                  } : String

                  val setDescriptor = {
                     
                     new MultipleChoiceProblem.XDescriptor[Item](
                        //
                        supposedAllOptions = allOptions.to(CcIi ) ,
                        defaultOption = Set(defaultItem).asInstanceOf[Set[Item] ],
                        enforcedArity = arity ,
                     )
                  }

                  promptor[Item]
                  .prompt(title = promptCaption , options = setDescriptor )
               }
               
            }

            main
         }

      }

   }

}

;
















