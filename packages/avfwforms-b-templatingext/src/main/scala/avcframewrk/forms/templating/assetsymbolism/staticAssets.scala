package avcframewrk.forms

package templating

package assetsymbolism













import quoted.*

/** 
 * `StaticAssetLinking`
 * 
 */
object StaticAssetLinking
{
   ;

   ;

   type BinaryBlobLiftingStyle
   = BinaryBlobLiftingStyle._Any
   ;
   object BinaryBlobLiftingStyle {
      ;

      ;

      type _Any
      = _Impl[Any]

      type ByFinalDescribingTermType
         [+R]
      = _Impl[R]

      opaque type _Impl[+R]
      <: (mimeType: String, sSrc: java.nio.file.Path ) => Expr[R]
      =  (mimeType: String, sSrc: java.nio.file.Path ) => Expr[R]

      def apply
         //
         [R]
         (impl: (mimeType: String, sSrc: java.nio.file.Path ) => Expr[R] )
      : ByFinalDescribingTermType[R]
      = impl

      ;

      /** 
       * this implementation
       * strives for `java.net.URI`.
       * 
       */
      def toJUri
         //
         (using Quotes )
      = {
         // toJDataUri
         toJBlobUriInSt
      }

      /** 
       * this implementation
       * strives to inline/embed the palyload, as `data:`-ic `java.net.URI`.
       * 
       * despite this apparently simple translation,
       * the relevant spec
       * refuses to oblige support for extended-length examples, and
       * in practice
       * browsers reject ones with sufficient lengths
       * 
       */
      // def toJDataUri
      //    //
      //    (using Quotes )
      // = {
      //    apply((mimeType, resolvedActualPath) => {
      //       ;

      //       import language.unsafeNulls

      //       ;

      //       val dataInBase64
      //       = {
      //          ;
      //          resolvedActualPath
      //          .loadAllAndGetAsW3Base64()
      //       }

      //       '{
      //          DataUri.byMimeTypeAndDataInBase64(
      //             //
      //             mimeType = ${Expr(mimeType) } ,
      //             dataInBase64 = identity[String](${dataInBase64.toExprForSjs() }) ,
      //          )
      //       }
      //    }.nn )
      // }

      /** 
       * this implementation
       * strives to inline/embed the palyload, as `blob:`-ic `java.net.URI`, with setup based on ScalablyTyped-generated itcs.
       * 
       */
      def toJBlobUriInSt
         //
         (using Quotes )
      = {
         ;

         import quotes.reflect.*

         apply((mimeType, resolvedActualPath) => {
            ;

            import language.unsafeNulls

            ;

            '{
               //
               ((mimeType: String, dataInBase64: String ) => {
                  ;

                  import scalajs.js

                  import typings.{std as domItc }
                  import typings.std.{global as dom}

                  dom.console.debug("'dataInBase64' first 200 chars:", (
                     dataInBase64
                     .replaceFirst("\\A([\\S\\s]{200})[\\S\\s]*\\z", "$1...")
                  ))

                  val urlStr
                  = dom.URL.createObjectURL({
                     new dom.Blob(js.Array((
                        dataInBase64
                        .toJsByteArray()
                        .tapLooseSelf(d => {
                           ;
                           dom.console.debug("'d' first few chars:", (
                              d
                              .slice(0, 200 )
                           ))

                        })
                        .asInstanceOf[domItc.BufferSource ]
                     )) , (
                        domItc.BlobPropertyBag()
                        .setType(mimeType )
                     ) )
                  })

                  new java.net.URI(urlStr )
               })
               .apply(
                  ${Expr(mimeType) }
                  ,
                  ${
                     resolvedActualPath
                     .loadAllAndGetAsW3Base64()
                     .toExprForSjs()
                     .tapLooseSelf(e => {
                        assert(!(e.asTerm.tpe.<:<(TypeRepr.of[scala.Singleton] ) ) , "'toExprForSjs' not behaving as we want" )
                     })
                  }
                  ,
               )
            }
         }.nn )
      }

      ;

      extension (dataInBase64: String ) {
         //

         /* needs to be static -- called from some quoted codes */
         def toJsByteArray
            ()
         = {
            ;

            import scalajs.js

            import typings.{std as domItc }
            import typings.std.{global as dom}

            dataInBase64
            .pipeLooseSelf(dom.atob(_) )
            .pipeLooseSelf((chars ) => {
               js.Array()
               .appendAll(chars.map(_.toByte ) )
            } : js.Array[Byte] )
            .pipeLooseSelf((buf ) => {
               new dom.Uint8Array(buf.asInstanceOf[js.Array[Double] ] )
            })
            .tapLooseSelf(d => {
               dom.console.debug("d:", d )
            })
         }
      }
      //

      extension (resolvedActualPath : java.nio.file.Path ) {
         //

         def loadAllAndGetAsW3Base64
            //
            ( )
         : String
         = {
            ;

            import language.unsafeNulls

            util.Try({
               java.nio.file.Files.readAllBytes(resolvedActualPath )
               .pipeLooseSelf(b => {
                  ({
                     /* see https://developer.mozilla.org/en-US/docs/Glossary/Base64 - hence, the primary one, not the "URL-safe" one */
                     java.util.Base64.getEncoder()
                  })
                  .encodeToString(b )
               })
            })
            .get
         }
      }
      //

      ;
   }

   opaque type PlainTxtLiftingStyle
   <: (value: String) => Expr[Any]
   =  (value: String) => Expr[Any]

   transparent inline
   given defaultPlainTxtLiftingStyle
      (using Quotes)
   : PlainTxtLiftingStyle
   = unliftingPlainTxtLiftingStyle

   def unliftingPlainTxtLiftingStyle
      (using Quotes)
   : PlainTxtLiftingStyle
   = ((_: String ).toExprForSjs() ).nn

   ;

   type OnUnsupportedMimeTypeFallbackType
   >: (INLINE.type | RETURNING_URI.type) | MIMEERROR_FAILING.type
   <: (INLINE.type | RETURNING_URI.type) | MIMEERROR_FAILING.type

   case object INLINE
   case object RETURNING_URI
   case object MIMEERROR_FAILING

   extension (finalActionType: OnUnsupportedMimeTypeFallbackType ) {
      //

      def toLocalePhrasalString()
      : String
      = {
         ;

         finalActionType match {
         //
         case INLINE =>
            s"inlining as Data-URI (java.net.URI) instead."
         case RETURNING_URI =>
            s"returning URI instead."
         case MIMEERROR_FAILING =>
            s"FAILING (MIME ERROR)!"
         case _ =>
            s"we '${finalActionType }'-ed instead."
         }
      }
   }

   ;

   ;
}













val _ = {}