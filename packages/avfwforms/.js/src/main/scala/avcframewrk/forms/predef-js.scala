package avcframewrk.forms













transparent inline
def typeable[T]
= {
   // summonHereNotInline[reflect.Typeable[T] ]
   summon[reflect.Typeable[T] ]
}















val _ = {}
