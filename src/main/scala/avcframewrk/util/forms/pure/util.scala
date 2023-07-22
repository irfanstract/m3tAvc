package avcframewrk.util.forms.pure

val _ = {}
















;

export avcframewrk.util.EventIterator
export avcframewrk.util.EventIteratorByItemAndDesignation
export avcframewrk.util.TsevpEventType

type KeyFrameIterator[+R]
   = EventIteratorByItemAndDesignation[R, TsevpEventType.ofUpdate.type ]
   
object KeyFrameIterator
















