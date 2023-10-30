package avcframewrk.forms.inio


import language.implicitConversions
















/**
 * 
 * on-demand
 * `PrintWriter(_1, autoFlush = true )` methods on plain `Writer`
 * 
 */
@deprecated("the resulting implicit-view is prone to corrupting.")
given generalisedPrintlnOperator : Conversion[java.io.Writer, java.io.PrintWriter]
= {
   c => new java.io.PrintWriter(c, true )
}

/**
 * 
 * on-demand
 * adaptation/treatment of `java.io.OutputStream` as `java.io.Writer`
 * 
 */
@deprecated("the implementation of this auto-conv uses assumptions in choosing which CharSet to stick to.")
given `given_Conversion_|_Writer` : Conversion[java.io.OutputStream | java.io.Writer, java.io.Writer]
= {
   case c: java.io.Writer =>
      c
   case c: java.io.OutputStream =>
      new java.io.OutputStreamWriter(c )
}


















val _ = {}
