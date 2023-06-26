package avcframewrk.forms.javaswing
















;

// protected 
// class byAvslInt(initialRange: (Int, Int) ) {

//    val localEnd : localEndItcImpl.type = {

//       localEndItcImpl
//    }

//    private[byAvslInt] 
//    object localEndItcImpl extends 
//    AnyRef
//    with avcframewrk.util.forms.controls.DefinesDoAcquireSliderExclusive1[Int]
//    {

//       //

//    }

//    private[byAvslInt ] 
//    opaque type Sl
//       <: (
//          AnyRef
//          & avcframewrk.util.forms.ReleasableCond[Boolean, Boolean]
//          & avcframewrk.util.forms.controls.AvslReassignableBy[Int]
//       )
//       = Nothing
   
//    var slS : (Sl, Int ) | Null = null

//    //
//    private[byAvslInt ] 
//    val peer = {
      
//       new javax.swing.DefaultBoundedRangeModel
//    }
   
//    object javaSwingModeEnd extends
//    AnyRef with javax.swing.BoundedRangeModel
//    {

//       //

//       def getMaximum(): Int = range._2
//       def getMinimum(): Int = range._1

//       /* for `setRangeProperties`, only some args are supported */
      
//       override
//       def setRangeProperties(newValue: Int, x$1: Int, x$2: Int, x$3: Int, newBeingInProgress: Boolean): Unit = {

//          (slS, newBeingInProgress) match {
//             //

//             case (null, false ) =>
//                //

//          }
//       }

//       /* not supported ; no-op */
      
//       override def setExtent(x$0: Int): Unit = {}
//       override def setMaximum(x$0: Int): Unit = {}
//       override def setMinimum(x$0: Int): Unit = {}

//    }
   
// }

protected
class analyseCurrentlyOwnership1[Ow](had0: Ow | Null )(using util.NotGiven[Null <:< Ow ]) {
   
      val had = {
         had0
      }

      val _ @ (wasNonNull : Boolean) = {
         had != null
      }

}

protected 
class asAvslIntImpl(nativeModel: javax.swing.BoundedRangeModel )
{

   override
   def toString(): String = {
      s"asAvslIntImpl(${nativeModel })"
   }

   protected[asAvslIntImpl] 
   opaque type AcquiredSliderCtrl
      <: (
         AnyRef
         & avcframewrk.util.forms.ReleasableCond[Boolean, Boolean]
         & avcframewrk.util.forms.controls.AvslReassignableBy[Int]
      )
      = (
         AnyRef
         & avcframewrk.util.forms.ReleasableCond[Boolean, Boolean]
         & avcframewrk.util.forms.controls.AvslReassignableBy[Int]
      )

   final lazy
   val asAvsl = {
      ddseImpl
   }

   @deprecated
   final lazy
   val main = ddseImpl

   protected[asAvslIntImpl] 
   object ddseImpl extends
   AnyRef
   with avcframewrk.util.forms.controls.DefinesDoAcquireSliderExclusive1[Int]
   { asAvslIntImplThis =>

      private[asAvslIntImpl] 
      val stateHolder = {
         new java.util.concurrent.atomic.AtomicReference[AcqStateInfo | Null](null )
      }

      protected[asAvslIntImpl] 
      case class AcqStateInfo(owner: AcquiredSliderCtrl, resetValue: Int )

      def getIsBeingHold() : Boolean = {
         
         //

         // import language.unsafeNulls

         val acwo = {
            analyseCurrentlyOwnership1(had0 = stateHolder.get() )
         }

         acwo.wasNonNull
      }

      def setStateToNull(commit: Boolean) : Unit = {

         val acwo = {
            analyseCurrentlyOwnership1(had0 = {
               stateHolder.getAndUpdate(_ => null)
            })
         }

         import acwo.*

         if wasNonNull then {

            import language.unsafeNulls

            if (commit : Boolean) == false then {

               val oldValue = had.resetValue
               
               /**
                * `swing.BRM.setValue` is lenient
                */
               nativeModel setValue oldValue
               
            }

            nativeModel setValueIsAdjusting false

         }
         else {
            nativeModel setValueIsAdjusting false
         }
      }
      
      def release(commit: Boolean) : Unit = {

         setStateToNull(commit = commit )
      }
      
      def synchronouslyAwaitUntilReleased() : Unit = {
         
            while {
               
               getIsBeingHold()
            } do {
               Thread.sleep(2) // millis
            }
      }

      //

      override   
      def acquireSlider(
         // 

         forceImmediateReset  : Boolean = false ,
         forceImmediateAccept : Boolean = false ,
         
      )(using
         evidenceOfArgsValidity : (
            util.NotGiven[{
               val fir : forceImmediateReset.type
               val fia : forceImmediateAccept.type
            } <:< {
               val fir : true
               val fia : true
            } ]
         ) ,
      ) : AcquiredSliderCtrl = {

         (forceImmediateReset, forceImmediateAccept) match {

            case (true, false) =>
               release(commit = false )

            case (false, true) =>
               release(commit = true )
            
            case (true, true) =>
               throw new IllegalArgumentException(s"conflicting flags: (forceImmediateReset, forceImmediateAccept)")

            case _ =>
               synchronouslyAwaitUntilReleased()

         }

         object main extends
            AnyRef
            with avcframewrk.util.forms.ReleasableCond[Boolean, Boolean]
            with ((Int ) => Unit )
         {

            //

            override
            def close(arg: Boolean): Boolean = {
               
               asAvslIntImplThis
               .release(commit = arg )

               true
            }

            override
            def apply(v1: Int): Unit = {
               
               /**
                * `swing.BRM.setValue` is lenient
                */
               nativeModel setValue(v1)

            }

         }
         main
      }
      
   }
   
}

protected
class asAvslEventEmitterImpl(nativeModel: javax.swing.BoundedRangeModel )
extends 
AnyRef
with java.io.Closeable
{

   override
   def toString(): String = {
      s"asAvslEventEmitterImpl(${nativeModel })"
   }

   //

   export nativeModel.getMinimum
   
   export nativeModel.getMaximum
   
   export nativeModel.{getExtent => getSlidingWindowExtent }

   lazy
   val clientSideEvtItr : (
      avcframewrk.util.EventIterator[ValueChgEvent]
   ) = {

      vceImpl._2
   }

   /**
    * registers it
    */
   locally {

      import language.unsafeNulls 
      
      nativeModel addChangeListener lowerUpwardsListenerObj
   }

   /**
    * the Listener obj to pass on/to `nativeModel`
    */
   private[asAvslEventEmitterImpl]
   lazy
   val lowerUpwardsListenerObj = {

      import language.unsafeNulls 
      
      identity[javax.swing.event.ChangeListener] {

         case eNatively =>
            //

            val e = {
               ValueChgEvent(newValue = nativeModel.getValue() )
            }
            
            fireValueChgEvent(e)

            {}
            
      }
   }

   // protected
   export vceImpl._1.{apply => fireValueChgEvent }

   private[asAvslEventEmitterImpl] 
   final 
   lazy
   val vceImpl = {
      avcframewrk.util.newEventEmitter[ValueChgEvent]()
   }

   private[asAvslEventEmitterImpl] 
   case class ValueChgEvent(newValue: Int )

   /**
    * 
    * retracts
    * all listeners this constructor registered
    * 
    */
   def retractAllListeners(): Unit = {

      import language.unsafeNulls 
      
      nativeModel removeChangeListener lowerUpwardsListenerObj
   }
   
   override
   def close(): Unit = {

      retractAllListeners()
   }
   
}

def asAvSliderAcquirable(src: javax.swing.BoundedRangeModel) = {

   import language.unsafeNulls

   {
      
         asAvslIntImpl(src )
         .asAvsl
   }
}

def asAvslValueChangeEventItr(src: javax.swing.BoundedRangeModel) = {

   import language.unsafeNulls

   {
      
         asAvslEventEmitterImpl(src )
         .clientSideEvtItr
   }
}

def asAvslDisplayTxt(s: avcframewrk.util.EventIterator[Some[Int] ] ): javax.swing.text.Document = {

   import language.unsafeNulls
   
   import avcframewrk.forms.javaswing.swingTextDocUtils.setText1

   val d = new javax.swing.text.PlainDocument

   for (Some(value) <- s ) do {
      
      d setText1 s"value: $value; "
   }

   d
}

val _ = {}

/* `=====@===!` */
@main
def runBavslDemo() : Unit = {

   val xSwing = summon[avcframewrk.forms.impl.generic.XAllComponentsList.defaultInstance.type]

   val c = {
      import javax.swing
      import language.unsafeNulls
      val model = new swing.DefaultBoundedRangeModel(0, 25, -1000, 1000)
      val modelValueChgEvtItr = {
         asAvslValueChangeEventItr(model)
      }
      val p = xSwing.newAggregatingPanel()
      p add {
         ;
         val p = xSwing.newParagraphicPanel()
         p add { xSwing getCustomComponent1 { new swing.JSlider(model) } }
         p add { xSwing getCustomComponent1 { new swing.JSlider(model) } }
         p
      }
      p add {
         ;
         val p = xSwing.newAggregatingPanel()
         p add { xSwing renderTextDocDisplay { asAvslDisplayTxt(modelValueChgEvtItr.map(e => Some(e.newValue) ) ) } }
         p add { xSwing getCustomComponent1 { new swing.JSlider(model) } }
         p
      }
      p
   }

   xSwing.`open`({
      c
   })
}

;






















