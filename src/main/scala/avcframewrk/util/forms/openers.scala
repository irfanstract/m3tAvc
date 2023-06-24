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

/**
 * 
 * .
 * 
 */
trait DefinesDoOpenTopicGiven[-Title, -Body, +R] {

   def open(title: Title, body: Body) : R

}


















