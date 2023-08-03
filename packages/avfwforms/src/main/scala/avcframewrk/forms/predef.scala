package avcframewrk.forms
















/**
 * 
 * `C`, supposed to be a type-lmd.
 * 
 * ```
 * type ItsAllocator
 *    >: LC[ [c &lt;: InstanceOf[Bar] ] =>> (.....) ]
 *    &lt;: LC[ [c &lt;: InstanceOf[Bar] ] =>> (.....) ]
 * ```
 * 
 * didn't work as supposed to
 * 
 */
@deprecated("this didn't work as expected.")
type TL[C <: AnyKind]
   = C


















val _ = {}
