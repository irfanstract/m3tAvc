package avcframewrk.util.forms.controls
















;

type DefinesDoAcquireSliderExclusive1[Value] = (
   DefinesDoAcquireSliderExclusive[Value]
)

protected
trait DefinesDoAcquireSliderExclusive[Value] extends
AnyRef
{

   /**
    * 
    * optionally, depending on the args, block until the resource (ie *the slider*) gets relinquished, and then
      return an itc *proxying the slider*
    * 
    * - will, unless `forceRelease == true`,
    *   block until the previously-acquired mutex gets released
    *   ,
    * - implements `avcframewrk.util.forms.ReleasableCond[Boolean, Boolean]`.
    *   pass `true` to maintain, or pass `false` to reset ;
    *   may return `true` or `false` indicating whether the release succeeded
    * 
    * 
    */
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
   ) : (
      AnyRef
      & avcframewrk.util.forms.ReleasableCond[Boolean, Boolean]
      & AvslReassignableBy[Value]
   )

   if false then {
      acquireSlider()
      // acquireSlider(forceImmediateReset = true, forceImmediateAccept = true )
   }

}

type AvslReassignableBy[-Value]
   >: AvslApplyWithExactNewValue[Value, Unit ]
   <: AvslApplyWithExactNewValue[Value, Unit ]

type AvslApplyWithExactNewValue[-Value, +R ]
   = (newValue: Value ) => R

;































