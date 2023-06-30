package avcframewrk.forms.impl.javaswing

















;

import avcframewrk.util.forms.pure.*

import avcframewrk.forms.javaswing.*

;

trait ReExportsDoRenderAbstractAction
{
   
   export raa.{apply as renderAbstractAction }

   private[ReExportsDoRenderAbstractAction]
   object raa {

      import abstractActionFactory.lcafP.{renderButton as renderAbstractActionImpl }

      import avcframewrk.forms.impl.javaswing.abstractActionFactory.XLabel 

      import avcframewrk.forms.impl.javaswing.abstractActionFactory.getNameAndIcon 

      import avcframewrk.util.EventIterator
      
      import avcframewrk.util.forms.controls.KValueChangeEvent

      def apply(label: XLabel, callback: PartialFunction[Any, Unit] ) = {
         renderAbstractActionImpl(label = label, callback = callback )
      }

      /**
       * 
       * an implementation which
       * will constantly refresh in sync with update-events delivered via `stateChgEvtItr`
       * 
       * we suppose `callback` be *stateless*, relying only on the passed args
       * 
       *
       * @param renderLabel
       * @param callback
       * @param stateChgEvtItr
       * 
       */
      def apply[State](
         //
         renderLabel: State => XLabel,
         callback: PartialFunction[AsceiInvocationEvtByExtractedState[State] , Unit] ,
         stateChgEvtItr : EventIterator[KValueChangeEvent.ForValue[State] ] ,
         
      ) = {

         val preImpl = {
            new AnyRef with StateUpdatedAcImpl.For1[State]()
         }
         import  preImpl.*

         case class renderNameLabelAndIcon(value: State) {

            val label = {
               
               renderLabel(value )
            }
         
            val (name, icon) = {
               
               getNameAndIcon(label )
            }
  
         }
         
         val pch = {
            
            new AnyRef with XPackedCallbackManagmtOps with %%! 
            {

               var callbackImplOption : Option[LowerLevelClickEvt => Unit] = {

                  None
               }
               
            }
         }

         import pch.tryRunCallbackImpl

         import pch.{main => a }

         stateChgEvtItr
         .foreach((evt : KValueChangeEvent.ForValue[State] ) => {

            import evt.{newValue => value }

            val rnl = renderNameLabelAndIcon(value = value )

            import rnl.label         
            import rnl.{name, icon }
  
            def newInvocEvent(originalEvt: LowerLevelClickEvt) : InvocEvent = {

               AsceiInvocationEvtImpl(originalEvt = originalEvt, presentlyMdlState = value , actualLabel = label  )
            }
            
            val dummyInvocEvt = {

               val nieArgOriginalEvt = {
                  new AnyRef
               }
               
               newInvocEvent(originalEvt = nieArgOriginalEvt )
            }

            /**
             * 
             * update `a: javax.swing.Action`'s display properties
             * 
             */
            { 
               
               import language.unsafeNulls

               a putValue(javax.swing.Action.NAME, name )
               a putValue(javax.swing.Action.SMALL_ICON, icon )
               a setEnabled(callback isDefinedAt dummyInvocEvt ) 
            }

            pch.callbackImplOption = {
               
               Some({
                  identity[LowerLevelClickEvt => Unit] ((
                     lowerLevelEvtRepr => {

                        val evt = {
                           newInvocEvent(lowerLevelEvtRepr )
                        }

                        /**
                         * leniently `apply` `callback` (a `PartialFunction`), passing `evt`
                         */
                        callback applyOrElse(evt, { case _ => } ) 
                     } 
                  ))
               })
            }
         })

         a
      }

      private[raa]
      object StateUpdatedAcImpl {

         trait For1[State]() {

            //

            type InvocEvent
               >: AsceiInvocationEvtByExtractedState[State]
               <: AsceiInvocationEvtByExtractedState[State]

            type LowerLevelClickEvt
               >: AnyRef
               <: AnyRef
            
            trait %%!() 
            extends AnyRef
            {
               this : (
                  AnyRef
                  & XPackedCallbackManagmtOps
               ) =>

               //

               val main = {
                  
                  renderAbstractActionImpl(
                     //

                     /** 
                      * we don't have one at this point ;
                      * let's just assign it `"???"`
                      */
                     label = "???",

                     callback = { case lowerLevelEvt: LowerLevelClickEvt => tryRunCallbackImpl(lowerLevelEvt) } ,

                  )
               }
               
            }
            
            trait XPackedCallbackManagmtOps {

               //
               
               def callbackImplOption : Option[LowerLevelClickEvt => Unit]
               def callbackImplOption_=(newValue: Option[LowerLevelClickEvt => Unit] ) : Unit /* can't make it specific `Some` huhu -___- */

               def callbackImplAsDefaulted = {

                  callbackImplOption
                  .fold[LowerLevelClickEvt => Boolean ](_ => false)(implRun => ( actualE => { implRun(actualE) ; true } ) )
               }

               def tryRunCallbackImpl(e: LowerLevelClickEvt): Boolean = {

                  callbackImplAsDefaulted
                  .apply(e )
               }

            }

         }

         //
         
      }

      type AsceiInvocationEvtByExtractedState[+State] = (
         AsceiInvocationEvtImpl[?, State]
      )
      
      case class AsceiInvocationEvtImpl[+OriginalEvt, +State](
         //

         originalEvt: OriginalEvt ,
         
         presentlyMdlState: State ,
         actualLabel: XLabel ,

      ) extends AnyRef

   }

}

;
























