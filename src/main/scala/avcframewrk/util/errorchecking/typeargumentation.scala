package avcframewrk.util.errorchecking
















type EvidenceOfBeingExactlyAnyOrNothing[R]
   >: (R =:= R) <:< ((Any =:= Any ) | (Nothing =:= Nothing ) )
   <: (R =:= R) <:< ((Any =:= Any ) | (Nothing =:= Nothing ) )

type EvidenceOfBeingNeitherExactlyAnyNorNothing[R]
   = util.NotGiven[EvidenceOfBeingExactlyAnyOrNothing[R] ]






















