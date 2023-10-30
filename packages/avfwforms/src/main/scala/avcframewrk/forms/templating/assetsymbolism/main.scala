package avcframewrk.forms

package templating

package assetsymbolism













/** 
 * *statically* called by the generated facades.
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
   )
}

private
object ImplReadResAndDescribeValueExpr {
   ;

   import quoted.{*, given}

   ;

   def apply
      //
      (
         //
         itemRelativePathExpr: Expr[String] ,
         srcRootPathExpr: Expr[String] ,
      )
      (using Quotes )
   : Expr[Any]
   = {
      ;
      import quotes.reflect.*
      ;
      val '{ ${Expr(srcRootPath ) } : String } = srcRootPathExpr
      ;
      itemRelativePathExpr match {
      //

      case '{ ${ Expr(itemRelativePath @ TxtPlainFilePath(_* ) ) } } =>
         // TODO
         '{ "TODO implement the file reading" }

      case e @ '{ ${ Expr(itemRelativePath @ CssFilePath(_* ) ) } } =>
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

      case e @ '{ ${Expr(itemRelativePath) } : String } =>
         val msg = s"unsupported file fmt. (path: $itemRelativePath ) "
         report.warning(msg, e )
         '{ throw new UnsupportedOperationException(${Expr(msg ) }) }

      case e =>
         val msg = s"unsupported expression. () "
         report.error(msg, e )
         '{ throw new UnsupportedOperationException(${Expr(msg ) }) }

      }
   }

   val TxtPlainFilePath = ".txt\\z".r.unanchored

   val CssFilePath       =          "\\.css\\z".r.unanchored
   val CssModuleFilePath = "\\.module\\.css\\z".r.unanchored

}









val _ = {}
