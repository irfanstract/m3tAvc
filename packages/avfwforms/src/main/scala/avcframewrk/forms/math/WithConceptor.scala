package avcframewrk.forms.math










/**
 * 
 * defines `allocator`, in turn conforming to `Impl`
 * 
 */
trait WithAllocator[
   +Impl <: (
      AnyRef
   ) ,

](val allocator : Impl )
extends
AnyRef

/**
 * 
 * defines `conceptor`, in turn conforming to `C`
 * 
 * you probably want 'WithAllocator' instead.
 * 
 */
trait WithConceptor[
   +C <: (
      Singleton &
      AnyRef
   ) ,

](val conceptor : C)
extends
AnyRef









