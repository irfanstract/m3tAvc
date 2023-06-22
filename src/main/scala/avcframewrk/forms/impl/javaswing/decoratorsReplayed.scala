package avcframewrk.forms.impl.javaswing


















/**
 * 
 * a helper to
 * allow later-added decorators
 * to automatically be applied to instances of `C` already passed-in-to `addOperand`
 * 
 * the templates returned by `allInterfacesGivens`
 * are not directly an instantiated `awt.Component`s (since that'd prevent reuse), but instead
 * a "zero-arg factory" (eg `DefinesGetNewInstanceNoArg`) which produces those.
 * the ability to `theTemplate.newInstance()` more-than-once,
 * combined with
 * the imperativity (to make it a drop-in sub of the typical `swing.JYyyComponent`s) of
 * the interface(s) returned by the methods `newYyyPanel(.....)`,
 * this additional complexity becomes essential.
 * 
 */
export avcframewrk.util.syncing.CallbackSequenceReplay.XDecorativeFncQueue

/**
 * 
 * secondary `ensureOped` invoc "with given instance of `C`"
 * will not make the callback run twice (ie the callback will only run once)
 * 
 */
export avcframewrk.util.syncing.CallbackSequenceReplay.XIdempotentInitOperandList

/**
 * 
 * the 2nd itc is
 * an infinite-length `LazyList`
 * whose items are the values submitted onto the *callback* returned as the 1st itc (in order)
 * 
 */
// : avcframewrk.util.errorchecking
export avcframewrk.util.syncing.CallbackSequenceReplay.newXcdfLl
























