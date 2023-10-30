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
   ImplReadResAndDescribeValueExpr.applyToSrcTreeRooted(
      //
      itemRelativePathExpr = 'itemRelativePath ,
      srcRootPathExpr = 'srcRoot ,
      expectedMimeTypeExpr = '{ "" } ,
   )
}

/** 
 * the main hook of the generated facades.
 * the absolute version of the above one.
 * 
 */
transparent
inline
def `%%Absolutely`(
   //
   itemAbsolPath: String ,
)
: Any
= ${
   // TODO
   ImplReadResAndDescribeValueExpr.applyToFullPath(
      //
      resolvedActualPathStrExpr = 'itemAbsolPath ,
      expectedMimeTypeExpr = '{ "" } ,
   )
}

private
object ImplReadResAndDescribeValueExpr {
   ;

   import quoted.{*, given}

   ;

   ;

   ;

   /** 
    * applied to src-tree-rooted path expr
    * 
    */
   def applyToSrcTreeRooted
      //
      (
         //
         itemRelativePathExpr: Expr[String] ,
         srcRootPathExpr: Expr[String] ,
         expectedMimeTypeExpr: Expr[String] ,
      )
      (using Quotes )
   // : Expr[Any]
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
         identifyMimeTypeAlt1(
            //
            expectedMimeTypeExpr = expectedMimeTypeExpr ,
            srcPathExpr = itemRelativePathExpr  ,
            //
            warnUnrecognisedMimeType = () => {
               ;
               report.warning(s"unsupported expr for 'expectedMimeType' ; resorting to inference instead .\n  ", expr = expectedMimeTypeExpr  )
            } ,
            //
         )
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
      = report.info(
         s"resolved actual path:\n  $resolvedActualPath",
         itemRelativePathExpr,
         )

      applyToFullPathConst(
         //
         finalMimeType = finalMimeType ,
         resolvedActualPath = resolvedActualPath ,
         warnUnsupportedFmtOrMimeType =
         {
            case (finalActionType, mimeType) =>
               ;

               val msg
               = s"unsupported file fmt ($mimeType). ${finalActionType.toLocalePhrasalString() } (path: $itemRelativePath ) "

               report.warning(
                  msg, itemRelativePathExpr )

               (msg, () )
         }
         ,
         logResolvedActualPath = logResolvedActualPath ,
         //
      )
   }

   // TODO
   /** 
    * applied to full-path expr
    * 
    */
   // protected
   def applyToFullPath
      //
      (using Quotes)
      (
         //
         resolvedActualPathStrExpr: Expr[String] ,
         expectedMimeTypeExpr: Expr[String] ,
         //
         //
      )
   = {
      ;

      import quotes.reflect.*

      val Expr(resolvedActualPathStr)
      = resolvedActualPathStrExpr : @unchecked

      lazy val resolvedActualPath
      : java.nio.file.Path
      = {
         ;
         import language.unsafeNulls
         new java.io.File(resolvedActualPathStr ).toPath()
      }

      val finalMimeType
      = {
         identifyMimeTypeAlt1(
            //
            expectedMimeTypeExpr = expectedMimeTypeExpr ,
            srcPathExpr = resolvedActualPathStrExpr  ,
            //
            warnUnrecognisedMimeType = () => {
               ;
               report.warning(s"unsupported expr for 'expectedMimeType' ; resorting to inference instead .\n  ", expectedMimeTypeExpr  )
            } ,
            //
         )
      } : String

      def logResolvedActualPath()
      = report.info(
         s"resolved actual path:\n  $resolvedActualPath",
         resolvedActualPathStrExpr,
         )

      applyToFullPathConst(
         //
         finalMimeType = finalMimeType ,
         resolvedActualPath = resolvedActualPath ,
         warnUnsupportedFmtOrMimeType =
         {
            case (finalActionType, mimeType) =>
               ;

               val msg
               = s"unsupported file fmt ($mimeType). ${finalActionType.toLocalePhrasalString() } (path: $resolvedActualPath ) "

               report.warning(
                  msg, resolvedActualPathStrExpr )

               (msg, () )
         }
         ,
         logResolvedActualPath = logResolvedActualPath ,
         //
      )
   }

   ;

   import StaticAssetLinking.{*, given}

   given defaultBinaryBlobLiftingStyle(using Quotes)
   : BinaryBlobLiftingStyle
   =  BinaryBlobLiftingStyle.toJUri

   ;

   def applyToFullPathConst
      //
      (using Quotes)
      (
         //
         finalMimeType: String ,
         resolvedActualPath: java.nio.file.Path ,
         //
         logResolvedActualPath
         : () => Unit
         = () => {}
         ,
         warnUnsupportedFmtOrMimeType : (
            (finalActionType: OnUnsupportedMimeTypeFallbackType , mimeType: String) =>
               (String, Unit )
         )
         ,
         //
      )
      (using PlainTxtLiftingStyle )
      (using BinaryBlobLiftingStyle )
   : Expr[Any]
   = {
      ;

      import quotes.reflect.*

      ;

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

      /* work-around the incremental comp issues */
      ({
         ;
         locally[Unit] { () }
         StaticAssetLinking.BinaryBlobLiftingStyle
      })

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
            ;
            ;
            '{
               (${e} )
               .handleCssFile(src = {
                  {
                     import language.unsafeNulls
                     ${Expr(resolvedActualPath.toUri() ) }
                  }
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
            // Expr(fullContents )
            implicitly[PlainTxtLiftingStyle ]
            .apply(value = fullContents )
         })

      // case s"application/octet-stream" =>
      //    // TODO
      //    '{ "TODO implement the octet-stream file reading" }

      case mimeType =>
         ;
         val (msg *: _ )
         = warnUnsupportedFmtOrMimeType(finalActionType = INLINE, mimeType = mimeType )

         summon[BinaryBlobLiftingStyle]
         .apply(mimeType, resolvedActualPath )

      case mimeType =>
         ;
         val (msg *: _ )
         = warnUnsupportedFmtOrMimeType(finalActionType = RETURNING_URI, mimeType = mimeType )
         ({
            ;
            import language.unsafeNulls
            ;
            '{
               (${Expr({
                  resolvedActualPath
                  .toUri()
               }) } )
            }
         })

      case _ =>
         ;
         val (msg *: _ )
         = warnUnsupportedFmtOrMimeType(finalActionType = MIMEERROR_FAILING, mimeType = "application/???" )
         '{ throw new UnsupportedOperationException(${Expr(msg ) }) }

      }
   }

   private
   def identifyMimeTypeAlt1
      //
      (using Quotes)
      (
         expectedMimeTypeExpr: Expr[String],
         srcPathExpr: Expr[String] ,
         warnUnrecognisedMimeType: () => Unit ,
      )
   = {
      ;

      import quotes.reflect.*

      ;

      ;

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
            warnUnrecognisedMimeType()
            None

         //
      } : Option[String] )
      .getOrElse[String] ({
         ;

         val G = summon[FileNameMimeTypeInferrer._Any ]

         srcPathExpr match {
         //

         case '{ ${ Expr(G.Instance(mimeType ) ) } } =>
            mimeType : String

         case _ =>
            "application/x"
         }
      })
   } : String

   ;

   ;

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

   ;

}









val _ = {}
