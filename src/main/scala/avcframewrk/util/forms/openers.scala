package avcframewrk.util.forms















/**
 * 
 * defines exactly `open(c: C): R`.
 * 
 */
type Opener[-C, +R]
   >: DefinesDoOpenGiven[C, R]
   <: DefinesDoOpenGiven[C, R]

/**
 * 
 * .
 * 
 */
trait DefinesDoOpenGiven[-C, +R] {

   def open(c: C) : R

}


















