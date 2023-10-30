package avcframewrk.forms

package templating

package assetsymbolism













/** 
 * the main hook of the generated facades.
 * 
 */
transparent
inline
def `%%`(
   //
   symbolisedName: String ,
   itemRelativePath: String ,
   srcRoot: String ,
)
: Any
= ${
   // TODO
   ImplReadResAndDescribeValueExpr(
      //
      itemRelativePathExpr = 'itemRelativePath ,
      srcRootPathExpr = 'srcRoot ,
      expectedMimeTypeExpr = '{ "" } ,
   )
}

private
object ImplReadResAndDescribeValueExpr {
   ;

   import quoted.{*, given}

   ;

   private
   class SpecialQuotesUtil
      //
      (using Quotes )
      ( )
   {
      ;

      import quotes.reflect.*

      def parseStaticExpr
         //
         [T : Type : FromExpr ]
         (expr: Expr[T ])
      : T
      = {
         ;
         Some(expr )
         .collect({ case '{ ${Expr(value ) } : T } => value })
         .getOrElse({
            report.errorAndAbort(s"unsupported expression. only supports static string literal.", expr )
         })
      }

   }

   def apply
      //
      (
         //
         itemRelativePathExpr: Expr[String] ,
         srcRootPathExpr: Expr[String] ,
         expectedMimeTypeExpr: Expr[String]
      )
      (using Quotes )
   : Expr[Any]
   = {
      ;

      import quotes.reflect.*

      ;

      val srcRootPath
      = {
         SpecialQuotesUtil()
         .parseStaticExpr(srcRootPathExpr )
      }
      val itemRelativePath
      = {
         SpecialQuotesUtil()
         .parseStaticExpr(itemRelativePathExpr )
      }

      val finalMimeType
      = {
         /** 
          * note that
          * a non-null valid `expectedMimeType`
          * shall always take precedence
          * 
          */
         ({
            ;

            expectedMimeTypeExpr match

            case '{ ${Expr(expectedMimeType) } } =>
               Some(expectedMimeType)
               .filter(_ != "" )

            case _ =>
               report.warning(s"unsupported expr for 'expectedMimeType' ; resorting to inference instead .\n  ", expr = expectedMimeTypeExpr  )
               None

            //
         } : Option[String] )
         .getOrElse[String] ({
            ;

            val G = summon[FileNameMimeTypeInferrer._Any ]

            itemRelativePathExpr match {
            //

            case '{ ${ Expr(G.Instance(mimeType ) ) } } =>
               mimeType : String

            // case '{ ${ Expr(_ @ s"${f}.txt" ) } } =>
            //    "text/plain"

            // case '{ ${ Expr(_ @ s"${f}.json" ) } } =>
            //    "application/json"

            // case '{ ${ Expr(_ @ s"${f}.xml" ) } } =>
            //    "application/xml"

            // case e @ '{ ${ Expr(_ @ s"${f}.css" ) } } =>
            //    "text/css"

            // case e @ '{ ${ Expr(_ @ s"${f}.bin" ) } } =>
            //    "application/octet-stream"

            case _ =>
               "application/x"
            }
         })
      } : String

      lazy val resolvedActualPath
      : java.nio.file.Path
      = {
         ;
         import language.unsafeNulls
         new java.io.File(srcRootPath ).toPath()
         .resolve(new java.io.File(itemRelativePath ).toPath() )
      }
      def logResolvedActualPath()
      = report.info(s"resolved actual path:\n  $resolvedActualPath", itemRelativePathExpr )

      def fetchStringValue
         ()
      : String
      = {
         ;
         import language.unsafeNulls
         logResolvedActualPath()
         val fullContents
         = {
            java.nio.file.Files.readString({
               resolvedActualPath
            })
         } : String
         fullContents
      }

      ;

      finalMimeType match {
      //

      case s"text/css" =>
         ;
         CssFileLinking.CustomHandlerSummon.inQuotesOptional
         .orElse[Expr[CssFileLinking.CustomHandler._Any ] ] (Some {
            report.warning((
               s"no-op CSS import - no instance of `CssFileLinking.CustomHandlerSummon` was found."
            ))
            '{ CssFileLinking.CustomHandler.noOpInstance }
         })
         .map(e => {
            '{
               (${e} )
               .handleCssFile(src = {
                  import language.unsafeNulls
                  new java.io.File(${Expr(srcRootPath ) } )
                  .toPath()
                  .resolve(${Expr(itemRelativePath ) } )
                  .toUri()
               } )
            }
         })
         .getOrElse(throw new AssertionError )
         
      case s"text/${_}" | s"application/${"xml" | "xhtml" | "svg" }" | s"application/${"json" | "jsonc" }" =>
         // TODO
         // '{ "TODO implement the file reading" }
         ({
            val fullContents
            = fetchStringValue()
            Expr(fullContents )
         })

      case s"application/octet-stream" =>
         // TODO
         '{ "TODO implement the octet-stream file reading" }

      case mimeType =>
         val msg = s"unsupported file fmt ($mimeType). inlining as Data-URI (java.net.URI) instead. (path: $itemRelativePath ) "
         report.warning(msg, itemRelativePathExpr )
         ({
            ;
            import language.unsafeNulls
            ;
            val dataInBase64
            = {
               ;
               util.Try({
                  java.nio.file.Files.readAllBytes(resolvedActualPath )
                  match { case b => java.util.Base64.getUrlEncoder().encodeToString(b ) }
               })
               .get
            }
            '{
               DataUri.byMimeTypeAndDataInBase64(
                  //
                  mimeType = ${Expr(mimeType) } ,
                  dataInBase64 = identity[String](${Expr(dataInBase64) }) ,
               )
            }
         })

      case mimeType =>
         val msg = s"unsupported file fmt ($mimeType). returning URI instead. (path: $itemRelativePath ) "
         report.warning(msg, itemRelativePathExpr )
         ({
            ;
            import language.unsafeNulls
            ;
            val dataInBase64
            = {
               ;
               util.Try({
                  java.nio.file.Files.readAllBytes(resolvedActualPath )
                  match { case b => java.util.Base64.getUrlEncoder().encodeToString(b ) }
               })
               .get
            }
            '{
               new java.net.URI(${Expr({
                  resolvedActualPath
                  .toUri()
                  .toASCIIString()
               }) } : String )
            }
         })

      case _ =>
         val msg = s"unsupported file fmt. (path: $itemRelativePath ) "
         report.warning(msg, itemRelativePathExpr )
         '{ throw new UnsupportedOperationException(${Expr(msg ) }) }

      }
   }

}









val _ = {}
