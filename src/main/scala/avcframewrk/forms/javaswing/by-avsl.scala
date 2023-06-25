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

def asAvslIntImpl(c: javax.swing.BoundedRangeModel ) : (
   avcframewrk.util.forms.controls.DefinesDoAcquireSliderExclusive1[Int]
) = {

   class analyseCurrentlyOwnership1[SlS](had0: SlS | Null )(using util.NotGiven[Null <:< SlS ]) {
      
         val had = {
            had0
         }

         val _ @ (wasNonNull : Boolean) = {
            had != null
         }

   }

   new AnyRef with avcframewrk.util.forms.controls.DefinesDoAcquireSliderExclusive1[Int]
   { asAvslIntImplThis =>

      protected 
      opaque type Sl
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
      
      protected 
      case class SlS(owner: Sl, resetValue: Int )

      protected 
      val slSHld = {
         new java.util.concurrent.atomic.AtomicReference[SlS | Null](null )
      }

      def release(commit: Boolean) : Unit = {

         val acwo = {
            analyseCurrentlyOwnership1(had0 = {
               slSHld.getAndUpdate(_ => null)
            })
         }

         import acwo.*

         if wasNonNull then {

            import language.unsafeNulls

            if (commit : Boolean) == false then {
               val oldValue = had.resetValue
               c setValue oldValue
            }
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
      ) : Sl = {

         (forceImmediateReset, forceImmediateAccept) match {

            case (true, false) =>
               asAvslIntImplThis
               .release(commit = false )

            case (false, true) =>
               asAvslIntImplThis
               .release(commit = true )
            
            case (false, false) =>
               while {
                  //

                  // import language.unsafeNulls

                  val acwo = {
                     analyseCurrentlyOwnership1(had0 = slSHld.get() )
                  }

                  acwo.wasNonNull
               } do {
                  Thread.sleep(2) // millis
               }

            case (true, true) =>
               throw new IllegalArgumentException(s"conflicting flags: (forceImmediateReset, forceImmediateAccept)")

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
               c setValue(v1)
            }

         }
         main
      }
      
   }
}

;






















