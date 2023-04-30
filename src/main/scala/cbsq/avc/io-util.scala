package cbsq.avc













/**
 * 
 * utility for dealing with `java.io` or `java.nio`
 * 
 */
export %%!.ioUtil

protected 
object  %%! {

  object ioUtil {
    
    type ReaderFor[B <: java.nio.Buffer | AnyVal] <: (
        AnyRef
        & java.io.Closeable
    ) = 
        B match {
          case (java.nio.ByteBuffer   | Byte  ) => java.io.InputStream
          case (java.nio.CharBuffer   | Char  ) => java.io.Reader
          case (
            Char
            | IArray[Char]
            | String 
            | java.lang.CharSequence 
            | java.lang.StringBuilder | java.lang.StringBuffer 
            | java.nio.CharBuffer 
            | Array[Char]
            | java.io.Reader 
            | java.io.Writer
          ) => 
            java.io.Reader
        }

    type AsBuffered[B <: java.io.Closeable] <: (
        AnyRef
        & java.io.Closeable
    ) = 
        B match {
          case (java.io.InputStream) => java.io.BufferedInputStream
          case (java.io.Reader     ) => java.io.BufferedReader
          case (java.io.OutputStream) => java.io.BufferedOutputStream
          case (java.io.Writer      ) => java.io.BufferedWriter
        }

  }
  
}





















