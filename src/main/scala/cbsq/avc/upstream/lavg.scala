package cbsq.avc.upstream













/**
 * 
 * a `Map` which does not contain any item
 * 
 */
type LavfEmptyMap
      >: Map[?, Nothing]
      <: Map[?, Nothing]

val _ = {
   summon[LavfEmptyMap <:< Map[?, Any ] ]
}

val _ = {

   summon[LavfEmptyMap <:< (
      lavfConditionalTyping.IfConforms[true, true, [_] =>> LavfEmptyMap, [_] =>> LavfEmptyMap ]
   ) ]

}



;

trait LavGenericCtxTyper {

   type Ctx

}

;



;

protected
final
lazy val lavfConditionalTyping = {

   avcframewrk.util.lavf.conditionalTyping

}

;








;

trait InMuxChSelectorialTyper {

   type InMuxChSelector

}

;






































