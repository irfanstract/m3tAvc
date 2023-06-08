package cbsq.avc



















type HttpHeaders
   <: HttpHeadersTr

/**
 * 
 * the headers
 * 
 */
trait HttpHeadersTr
{

   /**
    * 
    * the headers, each as `(key, value)`,
    * with the original ordering and duplication
    * 
    */
   val headersAsTuples : Seq[(String, String)]

   /**
    * 
    * the headers, as Map.
    * 
    * the spec
    * enforces different rules for different fields ;
    * concat for some, and last-set-value for some
    * 
    */
   val headersAsMap : Map[String, String]

   /**
    * 
    * if present, `content-length` value
    * 
    */
   @`throws`[java.util.NoSuchElementException]
   lazy val contentLength : cbsq.FileSize

   /**
    * 
    * if present, `content-type` value
    * 
    */
   @`throws`[java.util.NoSuchElementException]
   lazy val contentTypeHeaderValue : String

}





























