package avcframewrk.util.forms
















;

trait Releasable extends
AnyRef
with java.io.Closeable
{

   /**
    * 
    * invoke the `!Release(this)` semantic.
    * 
    */
   def close() : Unit

}

/**
 * 
 * defines `close(...)` expecting exactly an argument
 * 
 */
trait ReleasableCond[-Arg, +R] extends
AnyRef
{

   /**
    * 
    * invoke the `!Release(this, $Arg)` semantic.
    * 
    */
   def close(arg: Arg) : R

}

;




























