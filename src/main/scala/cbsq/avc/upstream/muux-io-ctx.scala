package cbsq.avc.upstream

















/**
 * 
 * `PerMuuxIoCtxOps` ;
 * rewrite of `AVIOCtx` (`av*.h`)
 * 
 * every property
 * is represented as
 * `thePropertyQuestion: Question[ThePropertyValue]` which needs to be `resolve`d.
 * for convenience,
 * for some commonly-used properties
 * we define
 * the convenience aliases
 * allowing the simple `thePropertyValue` or (reassignment) `thePropertyValue = &lt;value>` syntax.
 * 
 * one don't explicitly deallocate `PerMuuxCtxOps` like C programs needs to do explicitly ;
 * OO languages (except C) manages all those automatically, where
 * the library
 * will rely on `CleanupThread` or `FinalizationRegistry` to schedule the "finalize" impl
 * 
 */
trait PerMuuxIoCtxOps
{

   var checksums : Map[PerMuuxCheckSumFncs, BigInt ] = {
      Map[PerMuuxCheckSumFncs, Nothing]()
   }

}

object PerMuuxIoCtxOps
{

   // export AvProbeCtx.probeInputBuffer2
   
}

enum PerMuuxCheckSumFncs {

   case ofCrc32

}









































































































































