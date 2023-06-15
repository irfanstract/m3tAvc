package cbsq.riffmt.ebmls.schemafiles



















object getEbmlSchema
{

   import cbsq.riffmt.*

   import cbsq.riffmt.ebmls

   object standardSchemeTypes
   {

      import EBmlPrimitivesIo.* 
      import EBml.{CodeSchemeOps, FramePayloadScheme, CodeUnitScheme}
      import EBml.CodeSchemeOps.{Lazy}
      
      import byteManipImplicits.*

      lazy val rawBytesScheme = ({

         CodeUnitScheme.OfStr(

            encodedLength = CodeSchemeOps.cHasVariableLength,
            enc = EBmlCharset.RawOctetString,

            defaultEncodedValue = {
               // TODO
               ""
            } ,

         )

      })
      
      lazy val utfScheme = ({

         CodeUnitScheme.OfStr(

            encodedLength = CodeSchemeOps.cHasVariableLength,
            enc = EBmlCharset.Utf8,

            defaultEncodedValue = {
               // TODO
               ""
            } ,

         )

      })
      
      // TODO
      /**
       * 
       * the built-in elements
       * - `VOID   (0x00EC )`
       * - `CRC32  (0x00BF )`
       * 
       */
      lazy val intrinsicElems1 = {
         Map[Int, (
            FramePayloadScheme & CodeUnitScheme.XLengthOverrideable { 
               // type Instance <: Seq[FramePayloadScheme.OfMulti[?, ?]#Instance ]
            }
         )](

            /* VOID */
            0xEC -> (
               CodeUnitScheme.OfStr(encodedLength = (0x4).B.nn, enc = EBmlCharset.RawOctetString, defaultEncodedValue = {
                  // TODO
                  ""
               })
            ) ,

            /* CRC-32 */
            0xBF -> (
               CodeUnitScheme.OfStr(encodedLength = (0x4).B.nn, enc = EBmlCharset.RawOctetString, defaultEncodedValue = {
                  // TODO
                  ""
               })
            ) ,

         )
         .map({
            case (k, v) =>
               (k: BigInt, v)
         })
      }
      
   }

   /**
    * 
    * traverses the given `org.w3c.dom.Document` to
    * translate into an `XSc`.
    * mutating the `Document` `doc` afterwards
    * will not affect the already-returned `XSc` -
    * the translation is essentially a "snapshot"
    * 
    */
   def apply(doc: org.w3c.dom.Document) = {

         import ebmls.{totalDtdAnalyse, elementDtdAnalyse}

         val analysis1 = (
            ebmls.totalDtdAnalyse(doc )
         )
         
         lazy val s : (
            EBml.FramePayloadScheme.XSc {

               val schemeMap : Map[BigInt, (
                  EBml.FramePayloadScheme { 
                     // type Instance <: Seq[EBml.FramePayloadScheme.OfMulti[?, ?]#Instance ]
                  }
               )]
               
            }
         ) = {
            
            import EBmlPrimitivesIo.* 
            import EBml.{CodeSchemeOps, FramePayloadScheme, CodeUnitScheme}
            import EBml.CodeSchemeOps.{Lazy}
            
            lazy val genericFramePayloadScheme = {
               FramePayloadScheme.ofOneOrMoreOfAnyOf1C(c = Lazy(s.schemeMap ) )
            }

            import standardSchemeTypes.*
            
            def appropriateScheme1(elementDtd1: ebmls.elementDtdAnalyse ) = {
               // TODO
               elementDtd1.mValueTypeSimpleName match {

                  case "master" =>
                     genericFramePayloadScheme
                     
                  case "utf-8" =>
                     utfScheme

                  case "string" =>
                     rawBytesScheme

                  case "binary" =>
                     rawBytesScheme

                  case "uinteger" | "integer" =>
                     rawBytesScheme

                  case "date" =>
                     rawBytesScheme

                  case "float" =>
                     rawBytesScheme

               }
               match {
                  case e @ (_ : CodeUnitScheme.OfStr[?, ?, ?]) =>
                     import cbsq.bytemanip.FileSize.boxingImplicits.*
                     elementDtd1.mLengthInBytesOption
                     .fold(e)(mLengthInBytes => { e withSpecificLength { mLengthInBytes.B } } )
                  case e =>
                     e
               } /* mLengthInBytesOption */
            }

            new FramePayloadScheme.XSc {

               val schemeMap = {

                  Map[BigInt, (
                     FramePayloadScheme & CodeUnitScheme.XLengthOverrideable { 
                        // type Instance <: Seq[FramePayloadScheme.OfMulti[?, ?]#Instance ]
                     }
                  )]()
                  .concat({
                     intrinsicElems1
                  })
                  .concat[(
                     FramePayloadScheme & CodeUnitScheme.XLengthOverrideable { 
                        // type Instance <: Seq[FramePayloadScheme.OfMulti[?, ?]#Instance ]
                     }
                  )]({
                     // TODO
                     analysis1.elemDecls1
                     .map((e: ebmls.elementDtdAnalyse) => {
                        (e.clsId : BigInt, appropriateScheme1(e) )
                     } )
                     .toMap
                  })

               }

            }

         }

         s
   }

}





























