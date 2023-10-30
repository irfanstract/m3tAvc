package avcframewrk.forms

package templating

package assetsymbolism













/** 
 * `StaticAssetLinking`
 * 
 */
object StaticAssetLinking
{
   ;

   ;

}

object DataUri {
   ;

   type _Any
   = _ByMimeTypeAndDataInBase64[String, String]

   type _ByMimeType
      [+S <: String ]
   = _ByMimeTypeAndDataInBase64[S, String ]

   type _ByDataInBase64
      [+DataBase64 <: String ]
   = _ByMimeTypeAndDataInBase64[String, DataBase64 ]

   opaque type _ByMimeTypeAndDataInBase64
      [+MimeType <: String, +DataBase64 <: String ]
   <: java.net.URI
   = java.net.URI

   ;

   def byMimeTypeAndDataInBase64
      (mimeType: String, dataInBase64: String)
   : _ByMimeTypeAndDataInBase64[mimeType.type, dataInBase64.type ]
   = {
      ;
      new java.net.URI({
         s"data:$mimeType;base64,$dataInBase64"
      })
   }

   ;
}

object FileNameMimeTypeInferrer
{
   ;

   type _Any
   = _Impl[Product | Unit ]

   protected
   opaque type _Impl
      [+R <: Product | Unit ]
   <: AnyRef
   = PartialFunction[String, String ]

   implicit class ApplyOps(val impl: _Any ) {
      export impl.{applyOrElse }
      val Instance: PartialFunction[String, String ] = impl
   }

   def fromPartialFunction
      //
      (run: PartialFunction[String, String ] )
   : _Any
   = run

   ;

   ;

   implicit
   var defaultInstance
   : _Any
   = basicInstance

   final
   lazy val basicInstance
   = {
      fromPartialFunction {
         //

         case (_ @ s"${f}.txt" ) =>
            "text/plain"

         case (_ @ s"${f}.json" ) =>
            "application/json"

         case (_ @ s"${f}.xml" ) =>
            "application/xml"

         case (_ @ s"${f}.css" ) =>
            "text/css"

         case (_ @ s"${f}.bin" ) =>
            "application/octet-stream"

      }
   }

   ;
}













val _ = {}