package avcframewrk.util.forms.controls
















;

type AvslReassignableBy[-Value]
   >: AvslApplyWithExactNewValue[Value, Unit ]
   <: AvslApplyWithExactNewValue[Value, Unit ]

type AvslApplyWithExactNewValue[-Value, +R ]
   = (newValue: Value ) => R

;































