package avcframewrk.evm.xutil









/**
 * 
 * `{ type Main[+E] <: collection.WithFilter[E, Main ] }`
 * 
 * advice:
 * imposing inheritance
 * will significantly limit/restrict implementability.
 * instead of inheritance,
 * consider extension-method(s) or implicit-view(s) instead.
 * 
 */
type CwfMonadTypeAsMain
   = { type Main[+E] <: collection.WithFilter[E, Main ] }
















