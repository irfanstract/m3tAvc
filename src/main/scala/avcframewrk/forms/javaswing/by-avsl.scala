package avcframewrk.forms.javaswing
















;

// protected 
// class byAvslInt(range: (Int, Int) ) {

//    val localEnd : avcframewrk.util.forms.controls.DefinesDoAcquireSliderExclusive1[Int] = ???

//    private[byAvslInt ] 
//    opaque type Sl
//       <: (
//          AnyRef
//          & avcframewrk.util.forms.ReleasableCond[Boolean, Boolean]
//          & avcframewrk.util.forms.controls.AvslReassignableBy[Int]
//       )
//       = Nothing
   
//    var slS : (Sl, Int ) | Null = null
   
//    object swingEnd extends
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

// def asAvslIntImpl(nativeModel: javax.swing.BoundedRangeModel ) : (
//    avcframewrk.util.forms.controls.DefinesDoAcquireSliderExclusive1[Int]
// ) = {

//    class analyseCurrentlyOwnership1[Ow](had0: Ow | Null )(using util.NotGiven[Null <:< Ow ]) {
      
//          val had = {
//             had0
//          }

//          val _ @ (wasNonNull : Boolean) = {
//             had != null
//          }

//    }

//    new AnyRef with avcframewrk.util.forms.controls.DefinesDoAcquireSliderExclusive1[Int]
//    { asAvslIntImplThis =>

//       protected 
//       opaque type AcquiredHandle
//          <: (
//             AnyRef
//             & avcframewrk.util.forms.ReleasableCond[Boolean, Boolean]
//             & avcframewrk.util.forms.controls.AvslReassignableBy[Int]
//          )
//          = (
//             AnyRef
//             & avcframewrk.util.forms.ReleasableCond[Boolean, Boolean]
//             & avcframewrk.util.forms.controls.AvslReassignableBy[Int]
//          )
      
//       protected 
//       case class OwnershipInfo(owner: AcquiredHandle, resetValue: Int )

//       protected 
//       val slSHld = {
//          new java.util.concurrent.atomic.AtomicReference[OwnershipInfo | Null](null )
//       }

//       def synchronouslyAwaitUntilReleased() : Unit = {
         
//             while {
//                //

//                // import language.unsafeNulls

//                val acwo = {
//                   analyseCurrentlyOwnership1(had0 = slSHld.get() )
//                }

//                acwo.wasNonNull
//             } do {
//                Thread.sleep(2) // millis
//             }
//       }

//       def setStateToNull(commit: Boolean) : Unit = {

//          val acwo = {
//             analyseCurrentlyOwnership1(had0 = {
//                slSHld.getAndUpdate(_ => null)
//             })
//          }

//          import acwo.*

//          if wasNonNull then {

//             import language.unsafeNulls

//             if (commit : Boolean) == false then {

//                val oldValue = had.resetValue
               
//                /**
//                 * `swing.BRM.setValue` is lenient
//                 */
//                nativeModel setValue oldValue
               
//             }

//             nativeModel setValueIsAdjusting false

//          }
//          else {
//             nativeModel setValueIsAdjusting false
//          }
//       }
      
//       def release(commit: Boolean) : Unit = {

//          setStateToNull(commit = commit )
//       }
      
//       //

//       override   
//       def acquireSlider(
//          // 

//          forceImmediateReset  : Boolean = false ,
//          forceImmediateAccept : Boolean = false ,
         
//       )(using
//          evidenceOfArgsValidity : (
//             util.NotGiven[{
//                val fir : forceImmediateReset.type
//                val fia : forceImmediateAccept.type
//             } <:< {
//                val fir : true
//                val fia : true
//             } ]
//          ) ,
//       ) : AcquiredHandle = {

//          (forceImmediateReset, forceImmediateAccept) match {

//             case (true, false) =>
//                release(commit = false )

//             case (false, true) =>
//                release(commit = true )
            
//             case (true, true) =>
//                throw new IllegalArgumentException(s"conflicting flags: (forceImmediateReset, forceImmediateAccept)")

//             case _ =>
//                synchronouslyAwaitUntilReleased()

//          }

//          object main extends
//             AnyRef
//             with avcframewrk.util.forms.ReleasableCond[Boolean, Boolean]
//             with ((Int ) => Unit )
//          {

//             //

//             override
//             def close(arg: Boolean): Boolean = {
               
//                asAvslIntImplThis
//                .release(commit = arg )

//                true
//             }

//             override
//             def apply(v1: Int): Unit = {
               
//                /**
//                 * `swing.BRM.setValue` is lenient
//                 */
//                nativeModel setValue(v1)

//             }

//          }
//          main
//       }
      
//    }
// }

val _ = {}

;






















