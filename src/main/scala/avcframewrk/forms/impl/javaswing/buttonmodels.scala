package avcframewrk.forms.impl.javaswing

















;

import avcframewrk.util.forms.pure.*

import avcframewrk.forms.javaswing.*

;

trait ReExportsDoRenderAbstractAction
{
   
   export raa.{apply as renderAbstractAction }

}

export raa.{apply as renderAbstractAction }

protected 
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

      import preImpl.{*}

      val payreturnImpl = {
         
         new MainPassiveSideProv(
            //
            renderLabel = renderLabel,
            callback = callback ,
         )
      }
      
      import payreturnImpl.{*}

      stateChgEvtItr
      .foreach((evt : KValueChangeEvent.ForValue[State] ) => {

         applyUpdate(evt)
      })

      a
   }
   
   // def apply[State](
   //    //
   //    renderLabel: State => XLabel,
   //    callback: PartialFunction[AsceiInvocationEvtByExtractedState[State] , Unit] ,
   //    stateItr : EventIterator[State ] ,
      
   // ) = {

   //    val preImpl = {
   //       new AnyRef with StateUpdatedAcImpl.For1[State]()
   //    }

   //    import preImpl.{*}

   //    val payreturnImpl = {
         
   //       new MainPassiveSideProv(
   //          //
   //          renderLabel = renderLabel,
   //          callback = callback ,
   //       )
   //    }
      
   //    import payreturnImpl.{*}

   //    stateItr
   //    .foreach((newState) => {

   //       applyUpdateImpl(newState = newState)
   //    })

   //    a
   // }

   private[raa]
   object StateUpdatedAcImpl {
      
      trait For1[State]() {

         //

         // def start1[
         //    StPck[_],
         //    StateUpdateEvt >: StPck[State] <: StPck[State] ,
         // ](
         //    //
         //    payreturnImpl : MainPassiveSideProv ,

         //    stateChgEvtItr : EventIterator[StateUpdateEvt ] ,

         //    applyUpdatePre : (evt : StateUpdateEvt) => Unit ,
            
         // ) = {

         //    import payreturnImpl.{*}

         //    stateChgEvtItr
         //    .foreach((evt : StateUpdateEvt ) => {

         //       applyUpdatePre(evt)
         //    })

         //    a
         // }

         //

         /**
          * 
          * namespace for
          * the passive side of the machinery
          * 
          */
         class MainPassiveSideProv(
            //
            renderLabel: State => XLabel,
            callback: PartialFunction[AsceiInvocationEvtByExtractedState[State] , Unit] ,
            
         )
         {

            //
            
            case class renderNameLabelAndIcon(value: State) {

               val label = {
                  
                  renderLabel(value )
               }
            
               val (name, icon) = {
                  
                  getNameAndIcon(label )
               }
   
            }
            
            private 
            val pch = {
               
               new AnyRef with XPackedCallbackManagmtOps with %%! 
               {

                  var callbackImplOption : Option[CallbackImpl ] = {

                     None
                  }
                  
               }
            }

            export pch.tryRunCallbackImpl

            export pch.{main => a }

            def applyUpdate(evt : KValueChangeEvent.ForValue[State] ) = {
               
               import evt.{newValue }

               applyUpdateImpl(
                  //
                  newValue = newValue ,
               )
            }

            def applyUpdateImpl(newValue : State ): Unit = {

               val value : newValue.type = newValue

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
                     (callback.andThen(_ => true ) orElse { case _ => false } )
                     .compose((e: LowerLevelClickEvt ) => newInvocEvent(originalEvt = e ) )
                     .nn
                  })
               }
               
            }

         }

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
            
            def callbackImplOption : Option[CallbackImpl ]
            def callbackImplOption_=(newValue: Option[CallbackImpl ] ) : Unit /* can't make it specific `Some` huhu -___- */

            type CallbackImpl
               >: ([C[R] ] =>> (C[Unit] | C[Boolean] ) )[[R] =>> (LowerLevelClickEvt => R ) ]
               <: ([C[R] ] =>> (C[Unit] | C[Boolean] ) )[[R] =>> (LowerLevelClickEvt => R ) ]

            def callbackImplAsDefaulted = {

               callbackImplOption
               .fold[LowerLevelClickEvt => Boolean ](_ => false)(implRun => ( actualE => { implRun(actualE) match { case r => r.isPositive } } ) )
            }

            def tryRunCallbackImpl(e: LowerLevelClickEvt): Boolean = {

               callbackImplAsDefaulted
               .apply(e )
            }

         }

      }

      //
      
      extension [
         Value <: Unit | Boolean ,
         
      ](v: Value) def isPositive: Boolean = {

         v match {
            case e @ (() | true) =>
               true
            case false =>
               false 
         }
      }

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

;
























