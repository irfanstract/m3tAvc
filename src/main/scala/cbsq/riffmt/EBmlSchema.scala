package cbsq.riffmt



















/**
 * 
 * https://datatracker.ietf.org/doc/rfc8794/ 
 * https://github.com/Matroska-Org/jebml 
 * 
 * to maintain the maintainability,
 * we group the types as appropriate ;
 * for example, `utf8` and `ascii string` and `raw octet stting`
 * are effectively each a *string encoding with distinctive charset*, and
 * we group the numeric-types 
 * leaving the difference in the denotative `ClassTag`-valued attrib
 * 
 */
trait EBsdOpsDefs extends 
   AnyRef 
   // with EBmlByteManipIoReExports
   // with EBmlPrimitivesIoReExports
{}

trait EBsd extends 
   AnyRef 
   // with EBmlByteManipIoReExports
   // with EBmlPrimitivesIoReExports
   with EBsdSpecificUtilDefs
{ EBml: (
   AnyRef 
   with EBmlByteManipIoReExports
   with EBmlPrimitivesIoReExports
) =>

   /**
    * 
    * there are two `CodeSchemeOps` subclasses, 
    * `CodeUnitScheme` and `FramePayloadScheme` (check them out below).
    * this `trait` is to define the common interfaces for both.
    * 
    */
   sealed trait CodeSchemeOps extends 
   AnyRef
   with CodeSchemeOps.Rpia
   {
      
      type Instance

      /**
       * 
       * implements the sole heart of the `readAndParse` methods.
       * `r` maintains
       * reference to the sole `RnpSpurce` and
       * `eagerness` .
       * 
       * unless the implementation supports *the lazy read mode*,
       * it *shall* `throw` `UnsupportedLazyReadingException` *without dequeueing anything from the `RnpSource`*.
       * 
       */
      def readAndParseImpl(r: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique): Instance

      type RnpSource
        <: java.io.InputStream | java.io.DataInput

      @annotation.experimental
      def writeBnr(d: Instance, dest: RnpDest): WbnrR

      type RnpDest
        <: java.io.DataOutput

      type WbnrR >: Unit <: Unit

   }
   object CodeSchemeOps extends 
   AnyRef
   with chvl
   {

      extension (this1 : CodeSchemeOps) {

         // transparent inline
         def readAndParse(
            src: this1.RnpSource ,

            eagerness : ebmsGenericUtils.Eagerness = {
               
               ebmsGenericUtils.Eagerness.toBeEager
            } ,

         )(using td : CodeSchemeOps.TraversalDiagnostique )(using util.NotGiven[Enct]) = {
            
            this1.readAndParseImpl(r = {

               CodeSchemeOps.RpiaImpl(
                  src = src ,
                  eagerness = eagerness ,

                  reoc = xNewReoc() ,
               )

            } )(using td )

         }
         
         // transparent inline
         def readAndParseIteratively(r: this1.RnpSource)(using td : CodeSchemeOps.TraversalDiagnostique )(using util.NotGiven[Enct]) = {
            
            this1.readAndParseImpl(r = {

               CodeSchemeOps.RpiaImpl(
                  src = r ,
                  eagerness = ebmsGenericUtils.Eagerness.toBeLazy ,
                  
                  reoc = xNewReoc() ,
               )

            } )(using td )

         }
         
         def readAndParseAlt(
            //

            src: this1.RnpSource,

            eagerness : ebmsGenericUtils.Eagerness ,

            reoc : reocImpl.Reoc ,

         )(using td : CodeSchemeOps.TraversalDiagnostique) = {
            
            this1.readAndParseImpl(r = {

               CodeSchemeOps.RpiaImpl(
                  src = src ,
                  eagerness = eagerness ,
                  
                  reoc = reoc ,
               )

            } )(using td )

         }
         
      }

      trait UnsupportedLazyReadingException extends java.io.IOException
      { this : Exception => }

      export `% % & @`.TraversalDiagnostique
      
      abstract class XStringifCtx
      {

         val elementSimpleNames1: PartialFunction[BigInt, String]

      }

      object XStringifCtx
      {

         lazy val defaultInstance = {
            new XStringifCtx {

               val elementSimpleNames1 = {
                  PartialFunction.empty
               }
               
            }
         }

      }
      
      /**
       * 
       * ```
       * val encodedLength: cHasVariableLength.type | cbsq.FileSize
       * ```
       * 
       */
      sealed trait OfFixedLengthStrv0 extends 
      CodeSchemeOps 
      {

         val encodedLength: cHasVariableLength.type | cbsq.FileSize

      }

      private[EBsd]
      // implicit
      def getRnpSourceRpiaImpl(ctx : CodeSchemeOps )(s: ctx.ReadingParsingImplArg ): ctx.RnpSource = {
         (s : RpiaImpl)
         .src
         .asInstanceOf[ctx.RnpSource]
      }

      private[EBsd]
      sealed
      trait Rpia extends 
      AnyRef
      {
         this : (
            AnyRef
            with CodeSchemeOps
         ) =>

         protected[EBsd] 
         type ReadingParsingImplArg
            >: RpiaImpl
            <: RpiaImpl
         
         protected[EBsd] 
         given Conversion[ReadingParsingImplArg, RnpSource] = {
            getRnpSourceRpiaImpl(this) _
         }
         
      }

      // was here

      private[EBsd]
      case class RpiaImpl(
         src : CodeSchemeOps#RnpSource ,
         eagerness : ebmsGenericUtils.Eagerness ,

         reoc : reocImpl.Reoc ,
         
      )
      {

         @throws[java.io.IOException & UnsupportedLazyReadingException]
         @throws[java.io.IOException]
         def checkDemandingEagerParsing()(using TraversalDiagnostique): Unit = {

            if !(eagerness == ebmsGenericUtils.Eagerness.toBeEager ) then {

               val newMsg = {

                  import language.unsafeNulls
                  
                  summon[TraversalDiagnostique]
                  .formatCtxtualMessage(msg = s"unsupported lazy mode $eagerness ; try 'toBeEager' instead ")
               }

               throw new java.io.IOException(newMsg) with UnsupportedLazyReadingException
            }
         }

      }

      def xNewReoc() : reocImpl.Reoc = {

         reocImpl.newReoc()
      }

   }

   /**
    * 
    * there are multiple variants of `readAndParse` ;
    * implementations of `readAndParseImpl`
    * shall only call `readAndParseAlt`, not the other ones
    * 
    */
   // private[EBsd]
   protected 
   implicit
   lazy val enct: Enct = {
      new Enct
   }
   
   /**
    * 
    * there are multiple variants of `readAndParse` ;
    * implementations of `readAndParseImpl`
    * shall only call `readAndParseAlt`, not the other ones
    * 
    */
   private[EBsd]
   class Enct private[EBsd]()

   import `! EBmlSch iCommon1` as common1
   object `! EBmlSch iCommon1` {
 
      export CodeSchemeOps.*

      def getLengthOfDataType[C](c: reflect.ClassTag[C]): cHasVariableLength.type | cbsq.FileSize = {
         cStdDataTypeSizingUtil.getLengthOfDataType(c = c )
      }

      extension(this1: FramePayloadScheme | CodeUnitScheme) {

         @annotation.experimental
         def binarise(d: this1.Instance) = {
            val o = (
               new java.io.ByteArrayOutputStream()
            )
            /* actually do the marshalling */
            this1.writeBnr(d, dest = new java.io.DataOutputStream(o) )
            /* extract the resulting byte-array */
            cbsq.ByteBlob.copyOf(o)
         }
         
      }

   }

   /**
    * 
    * *scheme* for an *element*.
    * either 
    * a *numeric data*, or a *string*, or a *frame* possibly of specific *class*
    * 
    */
   abstract class CodeUnitScheme extends 
   AnyRef 
   with CodeSchemeOps
   with FramePayloadScheme
   {
      
      override
      def readAndParseImpl(r: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique): Instance

      override
      type RnpSource
        >: UnpickleInputStream
        <: java.io.InputStream

   }
   object CodeUnitScheme
   {

      import common1.*

      def alwaysFailingInstance(h: () => String) = {
         new CodeUnitScheme
         {
            
            def readAndParseImpl(r: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique): Instance = {
               throw summon[CodeSchemeOps.TraversalDiagnostique].newLexerException(msg = h() )
            }

         // // TODO
         //    override
         //    def withSpecificLength(l: cbsq.FileSize): this.type = {
         //       this
         //    }
            
            def writeBnr(d: Instance, dest: RnpDest): WbnrR = {
               ???
            }

         }
      }

      sealed trait OfFixedLengthStrv extends 
      CodeUnitScheme 
      with OfFixedLengthStrv0
      with FramePayloadScheme.OfFixedLengthStrv
      {

         val encodedLength: (
            cHasVariableLength.type
            // | cbsq.FileSize
         )

      }

      // TODO

      // OfNumber, OfStr, OfSelectFrame, OfClassId, etc

      // @annotation.experimental
      type OfPrm[
         +K <: Singleton & ("|" ) ,
      ] = OfPrmOf[K, ?, ?]
      
      // @annotation.experimental
      def ofAnyOf[
         Instance1 ,
         ChildSchema <: (FramePayloadScheme) { type Instance <: Instance1 } ,
      ](c: Set[? <: ChildSchema]) = {
         CodeUnitScheme.OfPrmOf(
            combinMode = "|", 
            s = c ,
            fixup1 = (identity _) : (Instance1 => Instance1) ,
         )
      }

      // @annotation.experimental
      sealed 
      case class OfPrmOf[
         +K <: Singleton & ("|" ) ,
         Instance1 ,
         ChildScheme <: (FramePayloadScheme) { type Instance <: Instance1 } ,
      ]( 
         combinMode: K, 
         fixup1: ([V] =>> (V => V ) )[Instance1] ,
         s: ([I] =>> (Set[? <: I] | Seq[I] ) )[ChildScheme ] ,
      ) extends 
      FramePayloadScheme
      with FramePayloadScheme.OfFixedLengthStrv 
      with CodeUnitScheme.XLengthOverrideable
      {

         // TODO
         val encodedLength: cHasVariableLength.type | cbsq.FileSize = (
            CodeSchemeOps.cHasVariableLength
         )
         
         type Instance = Instance1
         
         override
         type RnpSource
            >: UnpickleInputStream
            <: UnpickleInputStream

         def readAndParseImpl(r: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique): Instance = {
            schemeAlternativeImpl.demarsh[
               Instance1 ,
               ChildScheme ,
            ](s)(using summon[CodeSchemeOps.TraversalDiagnostique].ofChild(divName = "alts"))(ec = r , r = r )
         }

         // TODO
         override
         def withSpecificLength(l: cbsq.FileSize) = {
            copy(s = (
               s
               .toSeq
               .collect({
                  case schm: CodeUnitScheme.XLengthOverrideable =>
                     schm withSpecificLength(l) 
               })
            ))
         }
         
         def writeBnr(d: Instance, dest: RnpDest): WbnrR = ???

      }

      /* THE PRIMITIVE DATA-TYPES */

      // @annotation.experimental
      sealed 
      case class OfDate  [C <: Unit | Long ]( c: reflect.ClassTag[C ] , defaultValue: Null | concurrent.duration.Deadline ) 
      extends 
      CodeUnitScheme 
      with OfFixedLengthStrv0
      with FramePayloadScheme.OfFixedLengthStrv
      { 

         type Instance 
            >: concurrent.duration.Deadline
            <: concurrent.duration.Deadline

         val encodedLength = getLengthOfDataType(c) 

         private[OfDate]
         lazy val supposedReadingLength = (
            (encodedLength match
               case v: cbsq.FileSize => 
                  v.inBytes
               case `cHasVariableLength` =>
                  ???
            ) : Long
         )

         def readAndParseImpl(r: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique) = {
            r.checkDemandingEagerParsing()
            r.readEbmlDateBytes(supposedReadingLength = supposedReadingLength )
         }
         
         @annotation.experimental
         def writeBnr(d: Instance, dest: RnpDest): WbnrR = {
            util.control.NonLocalReturns.returning[WbnrR](resolve ?=> {
               // @annotation.experimental
               val e = {
                  resolve.throwReturn(??)
               }
            })
         }

         // TODO
         // override
         // def withSpecificLength(l: cbsq.FileSize) = {
         //    throw UnsupportedOperationException()
         // }
         
      }
      
      sealed
      abstract
      class OfNumber[
         
         /* specialisability is quite limited, including due-to opaque-type usages */
         C : reflect.ClassTag : OctetReadingOp : OctetWritedownOp ,

      ]( 
         // val defaultValue: Null | C ,
         // mPoll: MPoll[C] ,
      ) 
      extends 
      CodeUnitScheme 
      with OfFixedLengthStrv0
      with FramePayloadScheme.OfFixedLengthStrv
      { 

         type Instance 
            >: C
            <: C

         // inline
         val encodedLength = getLengthOfDataType(summon[reflect.ClassTag[C] ] )

         val defaultValue: Null | C
         
         def readAndParseImpl(src: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique): Instance = {
            src.checkDemandingEagerParsing()
            (summon[OctetReadingOp[C] ] )((
               new java.io.DataInputStream(src)
            ))
         }
         
         def writeBnr(d: Instance, dest: RnpDest): WbnrR = {
            (summon[OctetWritedownOp[C] ] )(dest, d)
         }

      }
      // @annotation.experimental
      object OfNumber {

         protected 
         sealed 
         case class :![C](

            /* specialisability is quite limited, including due-to opaque-type usages */
            
            c: reflect.ClassTag[C] ,
            mPoll: OctetReadingOp[C] ,
            mPush: OctetWritedownOp[C] ,
            
            defaultValue: Null | C ,

         ) extends OfNumber[C]( )(using c, mPoll, mPush)
         {
            
            // TODO
            // override
            // def withSpecificLength(l: cbsq.FileSize) = {
            //    throw UnsupportedOperationException()
            // }
            
         }

         // protected 
         def of[C : reflect.ClassTag : OctetReadingOp : OctetWritedownOp](
            defaultValue: Null | C ,
         )(using util.NotGiven[C <:< Nothing] ) = {
            :!(

               c = summon[reflect.ClassTag[C] ] ,
               mPoll = summon[OctetReadingOp[C]   ] ,
               mPush = summon[OctetWritedownOp[C] ] ,

               defaultValue = defaultValue ,
               
            )
         }

         {
            of[Int](defaultValue = null )
            of[Long](defaultValue = 3 )
            of[Double](defaultValue = 3 )

            /**
             * ensure proper equality-semantics
             */
            assert((
                  of[Long](defaultValue = 3 )
               == of[Long](defaultValue = 3 )
            ))

            sys.process.stderr
            .println("EBml$$FramePayloadScheme$$OfNumber$$ - done")
         }

      }

      // @annotation.experimental
      sealed 
      case class OfStr[
         +Len             <: S[cHasVariableLength.type | cbsq.FileSize], 
         +ActualCharset   <: S[EBmlCharset ] ,
         +DEcv            <: S[Null | String   ] ,
      ](  
         encodedLength   : Len , 
         enc      : ActualCharset ,
         defaultEncodedValue : DEcv ,
      ) 
      extends 
      CodeUnitScheme 
      with OfFixedLengthStrv0
      with FramePayloadScheme.OfFixedLengthStrv
      with XLengthOverrideableAs[OfStr[?, ActualCharset, DEcv] ]
      {
         
         if true then {
            ;
            for (l <- Some(encodedLength).collect({ case l : cbsq.FileSize => l }) ) {
               (l.inBytes : BigDecimal)
               .toIntExact
            }
         }
         
         type Instance 
            >: cbsq.ByteBlob | java.net.URI
            <: cbsq.ByteBlob | java.net.URI

         def readAndParseImpl(r: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique) = {
            r.checkDemandingEagerParsing()
            import language.unsafeNulls /* due to the extended usage of non-Scala API(s) */
            
            encodedLength match {
               case _ =>

                  val byteSeq = {

                     implReadBytes1(r)
                  }

                  val l = {
                     import cbsq.bytemanip.FileSize.boxingImplicits.*
                     byteSeq.length
                  }

                  val b = {
                     cbsq.ByteBlob.from(byteSeq )
                  }

                  b encodedAs(enc = enc )
                  
            }
         }

         private
         def implReadBytes1(r: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique) : IndexedSeq[Byte] = {
            import language.unsafeNulls /* due to the extended usage of non-Scala API(s) */
            
            encodedLength match {
               case encodedLength : cbsq.FileSize =>

                  val l = {
                     encodedLength.inBytes.toInt
                  }

                  val byteSeq = {

                     import EBml.readNBytesEbmSc
                     
                     ({

                        try { r readNBytesEbmSc(1) }

                        catch {

                           case z : java.io.IOException => 
                              
                              val newMessage = (
                                 summon[CodeSchemeOps.TraversalDiagnostique ]
                                 .formatCtxtualMessage(msg = s"zero-byte EOF exception" )
                              )
                              throw (
                                 new java.io.IOException(newMessage , z ) with EBmlPrimitivesMalformationException.IDueToZeroByteEofException
                              )
                        } 
                     })
                     .++({

                        try { r readNBytesEbmSc(-1 + l ) }
                        
                        catch {
                           
                           case z : java.io.IOException => 
                              val newMessage = (
                                 summon[CodeSchemeOps.TraversalDiagnostique ]
                                 .formatCtxtualMessage(msg = s"half-payload EOF exception" )
                              )
                              throw (
                                 new java.io.IOException(newMessage , z ) with EBmlPrimitivesMalformationException.IDueToPayloadEofException
                              )
                        } 
                     }) 
                  }

                  byteSeq

               case CodeSchemeOps.cHasVariableLength =>
                  //

                  r
                  .readAllBytes().toIndexedSeq

            }

         }

         @annotation.experimental
         def writeBnr(d: Instance, dest: RnpDest): WbnrR = ??

         // TODO
         override
         def withSpecificLength(l: cbsq.FileSize): OfStr[l.type, ActualCharset, DEcv] = {
            copy(encodedLength = l)
         }
         
      }

      type XLengthOverrideable = (
         XLengthOverrideableAs[FramePayloadScheme ]
      )

      /**
       * 
       * some schemes like `OfNumber` and `OfString`
       * does not itself contraint/dictate the length in-advance, and
       * instead leave it to the enclosing frame's *payload-size* .
       * since the `readAndParse` method sig does not provide parameter to specify the lengths,
       * (and the length-variability is specific to some types anyway ),
       * it becomes necessary to defer it to a separate deriving method like this
       * 
       * @tparam DerivedInstanceBaseOps
       *    in Scala 3, type inference of `override`ing methods will widen it to the overriden method's, so
       *    this definition (en)forces the return-type to conform to this `type`
       * 
       */
      trait XLengthOverrideableAs[+DerivedInstanceBaseOps <: FramePayloadScheme] extends 
      AnyRef 
      { thisScheme : FramePayloadScheme & DerivedInstanceBaseOps =>

         /**
          * 
          * some schemes like `OfNumber` and `OfString`
          * does not itself contraint/dictate the length in-advance, and
          * instead leave it to the enclosing frame's *payload-size* .
          * since the `readAndParse` method sig does not provide parameter to specify the lengths,
          * (and the length-variability is specific to some types anyway ),
          * it becomes necessary to defer it to a separate deriving method like this
          * 
          */
         def withSpecificLength(l: cbsq.FileSize) : (
            FramePayloadScheme {
               type Instance 
                  >: thisScheme.Instance
                  <: thisScheme.Instance
            }
         ) & DerivedInstanceBaseOps

      }

   }

   /**
    * 
    * *scheme* for a *frame element*'s *payload*.
    * zero-or-more *element*s, each, see `CodeUnitScheme`
    * 
    */
   sealed trait FramePayloadScheme extends 
   AnyRef 
   with CodeSchemeOps
   { thisScheme =>

      type Instance

      def readAndParseImpl(r: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique): Instance

      /**
       * 
       * the input source itc.
       * 
       * needs to be `BufferedInputStream` or `ByteArrayInputStream`
       * due to occasional usages of *mark-and-reset* (eg for "try one-by-one" ) ;
       * *can't simply create `BufferedInputStream` wrapper* as
       * *buffering* would generally take excessive number-of-bytes hence *corruption*
       * 
       */
      type RnpSource
        >: UnpickleInputStream
        <: java.io.InputStream

      @annotation.experimental
      def writeBnr(d: Instance, dest: RnpDest): WbnrR

      type RnpDest
        >: java.io.OutputStream & java.io.DataOutput
        <: java.io.DataOutput

      type WbnrR >: Unit <: Unit

   }
   object FramePayloadScheme
   {

      import common1.*

      import byteManipImplicits.{OctetReadingOp as MPoll }

      sealed trait OfFixedLengthStrv extends 
      FramePayloadScheme 
      with OfFixedLengthStrv0
      {

         val encodedLength: cHasVariableLength.type | cbsq.FileSize

      }

      export CodeUnitScheme.OfDate

      export CodeUnitScheme.OfNumber

      // export CodeUnitScheme.OfStr

      /* ad-hoc */
      // @deprecated("experimental")
      // private[FramePayloadScheme ]
      export EBml.`elements_@&%!`

      export EBml.ebmlClassNameFmatted
      
      import EBml.`elements_@&%!` as @!
      
      import EBml.`E S`

      // @annotation.experimental
      opaque type OfFrame
         <: (
         CodeUnitScheme & OfFixedLengthStrv0 & FramePayloadScheme.OfFixedLengthStrv {
            
            type Instance 
               >: @!.Element
               <: @!.Element

         }
         )
         = Offr[?, ?]      
      
      // @annotation.experimental
      protected 
      sealed 
      case class Offr[
         +Len               <: S[cHasVariableLength.type | cbsq.FileSize], 
         // +Children          <: XSc ,
         +Children          <: CodeUnitScheme.OfPrm["|"] ,
      ](  
         encodedLength: Len , 
         classPayloadsTable: (
            //  FramePayloadScheme.OfMulti[?, ?]
            PartialFunction[BigInt, (
               FScOps
            ) ]
         ) ,
      ) 
      extends 
      CodeUnitScheme 
      with OfFixedLengthStrv0
      with FramePayloadScheme.OfFixedLengthStrv
      with CodeUnitScheme.XLengthOverrideable
      { thisScheme =>

         type Instance 
            // >: Rbeiop
            // <: Rbeiop
            >: @!.Element
            <: @!.Element

         override
         type RnpSource
            >: UnpickleInputStream
            <: UnpickleInputStream

         def readAndParseImpl(r: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique): Instance = {
               // TODO
               val efpr = {
                  import trvdFramesIoExcs.*
                  try ({

                     r.checkDemandingEagerParsing()
                     
                     try {
                        r.checkNotAtEof()

                     } catch {
                        
                        case z : (java.io.EOFException ) =>
                           
                           throw (
                              newFirstPlaceEofException(z = z, r = r)
                           )

                     }

                     //
                     /**
                      * 
                      * take the next chunk of bytes, and
                      * get the raw/as-is payload
                      * 
                      */
                     locally({
                     ;
                     def getCurrentPosInBytes() = {
                        r.getCurrentPos().inBytes
                        .toInt
                     }
                     val r1 = r
                     (new java.io.DataInputStream(r1) )
                     // .lazilyReadEbmlFrameOfPayloadRaw()
                     .lazilyReadEbmlFrameOfPayloadRaw()
                     // .readEbmlFrameOfPayloadRaw()
                     match {

                        case rbe =>
                           //

                           if (rbe.typeInt == (0x387B27 : BigInt ) ) then {
                              val msg = (
                                 summon[CodeSchemeOps.TraversalDiagnostique]
                                 .formatCtxtualMessage(msg = s"apparent stream corruption ; <${rbe.typeInt } l=??? /> " )
                              )
                              throw new java.io.IOException(msg )
                           }
                           
                           // rbe.payloadLength

                           val l = {
                              util.Try({
                                 ;
                                 identity[BigDecimal](rbe.payloadLength.inBytes )
                                 .toIntExact
                              })
                              .recover({
                                 case z : RuntimeException =>
                                    val msg = (
                                       summon[CodeSchemeOps.TraversalDiagnostique]
                                       .formatCtxtualMessage(msg = s"($z) ; check the stream not corrupted!!! ; <${rbe.typeInt } l=??? /> " )
                                    )
                                    throw new java.io.IOException(msg )
                              })
                              .get
                           }
                           
                           // if true then {
                           //    util.Using.resource({
                           //       newMarkResetTurn(r : RnpSource, l )
                           //    })(_ => {
                           //       rbe.payload
                           //    })
                           // }
                           
                           locally { rbe.payloadLength }
                           
                           val prePayloadReadingPos = {
                              getCurrentPosInBytes()
                           }

                           if false then {
                           ;
                           
                           /**
                            * 
                            * ensure evaluated
                            * 
                            */
                           locally { rbe.payload }

                           val finalPos = {
                              getCurrentPosInBytes()
                           }

                           /**
                            * 
                            * if it took away more bytes than necessary,
                            * this would `throw` `IOException : resetting to invalid frame`
                            * 
                            */
                           locally {
                              if prePayloadReadingPos + l == finalPos then {}
                              else {
                                 throw new java.io.IOException(s"corruption. (pprp: $prePayloadReadingPos ; pl: $l ; finalPos: $finalPos ) ")
                              }
                           }

                           }

                           rbe

                     }
                     })

                  })
                  catch {

                     case z : CodeSchemeOps.UnsupportedLazyReadingException =>

                        throw z

                     case z : (java.io.EOFException ) =>

                        throw (
                           summon[CodeSchemeOps.TraversalDiagnostique]
                           
                           .newLexerException(
                              msg = (
                                 s"EOF while pulling the raw, unprocessed $notEBml frame repr."
                                 + " " + z.getMessage()
                              ),

                              r = r,
                              
                           )
                           
                        )

                     case z : ( EBmlPrimitivesMalformationException) =>

                        val msg = (
                           summon[CodeSchemeOps.TraversalDiagnostique]

                           .formatCtxtualMessage(
                              msg = (
                                 s"malformed raw, unprocessed $notEBml frame repr."
                                 + " " + (z.getMessage())
                              ),

                           )

                        )

                        throw z.rewrapped1(msg)
                        
                     case z : (java.io.IOException ) =>
                        
                        throw (
                           summon[CodeSchemeOps.TraversalDiagnostique]

                           .newLexerException(
                              msg = (
                                 s"IOException rwhile pulling the raw, unprocessed $notEBml frame repr."
                                 + " " + (z match { case z : java.io.EOFException => s"EOF: $z" ; case _ => z.getLocalizedMessage() })
                              ),

                              r = r ,

                           )

                        )

                  }
               }
               /**
                * 
                * the high-level repr
                * 
                */
               ernp(using (
                  {
                     val currentPath = summon[CodeSchemeOps.TraversalDiagnostique ]
                     currentPath
                     .ofChild(divName = {

                        val typeNm = {

                           getXElementEfprSimpleName(using currentPath )(efpr = efpr )

                        }
                        
                        s"<${typeNm } (${efpr.payloadLength })>"

                     })
                  }
               ) )(
                  efpr = efpr, 
                  rpia = r ,
               )
         }

         def getXElementEfprSimpleName(using currentPath : CodeSchemeOps.TraversalDiagnostique)(
            efpr: Rbeiop ,
         ): String = {

                           Option(currentPath.fullScheme).map(_.nn)
                           
                           .flatMap(s => {
                              
                              s
                              
                              .collectFirst({
                                 case e if (e.clsId == efpr.typeInt ) =>
                                    e.mName
                              })
                              
                           })
                           .fold[String]({

                              efpr.typeInt

                              .toString(0x10).prependedAll("0x")
                              
                           } )(s => s )

         }

         // TODO
         override
         def withSpecificLength(l: cbsq.FileSize) = {
            ???
         }
         
         /**
          * 
          * transform a `EbmRawFrameElement` into the high-level repr (an `Element`)
          * 
          */
         private 
         def ernp(using CodeSchemeOps.TraversalDiagnostique)(
            efpr: Rbeiop ,
            rpia : ReadingParsingImplArg ,
         ) = {
               ;

               import rpia.reoc

               // val es = reoc.mark()

               efpr.payloadLength.inBytes
               match { case v if (v.toInt.toLong == v ) => }

               // efpr.payload

               inferred
               object inferred {
                  
                  final
                  lazy val classSimpleName: String = {

                     getXElementEfprSimpleName(using {
                        summon[CodeSchemeOps.TraversalDiagnostique ]

                     } )(efpr = efpr )
                     
                  }

                  val classIntName = {
                     efpr.typeInt
                  }

                  if false then {
                     appropriateSchemeDef
                  }
                  lazy
                  val appropriateSchemeDef = (

                     classPayloadsTable
                     .applyOrElse(classIntName : BigInt, classIntName => {
                        val newMessage = (
                           summon[CodeSchemeOps.TraversalDiagnostique]
                           // .formatCtxtualMessage(msg = (
                           //    s"no scheme for cls ${classIntName.ebmlClassNameFmatted } "
                           // ))
                           .formatCtxtualMessage(msg = (
                              s"no scheme for cls ${classIntName.ebmlClassNameFmatted } (it's possible the stream has been corrupted!!!) . (<${classIntName.ebmlClassNameFmatted } (length)=${efpr.payloadLength } >) "
                           ))
                        )
                        throw (
                           new
                           java.io.IOException(newMessage )
                           with EBmlPrimitivesMalformationException.%%!
                           with FramePayloadScheme.trvdFramesIoExcs.IOfSchemeLookupFailure
                        )
                     } )
                     
                     match {
                        
                        /**
                         * 
                         * some schemes like `OfNumber` and `OfString`
                         * does not itself contraint/dictate the length in-advance, and
                         * instead leave it to the enclosing frame's *payload-size*, so
                         * here 
                         * this needs to explicitly switch to a derived instance as specified
                         * 
                         */
                        case scheme =>
                           scheme withSpecificLength(efpr.payloadLength )

                     }
                  )

                  if true then {
                     efpr.payload
                  }

                  val childrenAsLazyList = {
                     
                     val r = (
                        ((
                           // new MarkableInputStreamImpl((
                           //    efpr.getPaystringItr()
                           // ))
                           // efpr.getPaystringItr()
                           // .asMarkableStream()
                           new MarkableInputStreamImpl((
                              efpr.getPaystringItr()
                           ))
                        ))
                     )

                     val cp = ({
                        /**
                         * 
                         * new `LazyList` running `readAndParseImpl`
                         * 
                         */
                        LazyList().lazyAppendedAll({
                           ((using : CodeSchemeOps.TraversalDiagnostique) ?=> {

                              locally {
                                 // withShallDebugThrownReocIfNecessary { es._1.checkCompleted() }
                                 // es._2.markCompleted()
                              }

                              extension (scheme : FramePayloadScheme ) {
                              
                                 // transparent inline
                                 def sub1 = {
                                    ;
                                    scheme
                                    .readAndParseAlt(src = r, eagerness = rpia.eagerness, reoc = rpia.reoc )
                                 }
                                 
                              }
                              
                              (appropriateSchemeDef match {

                                 case scheme : VariadicImpl[?, ?] =>
                                    scheme.sub1

                                 case scheme =>
                                    Seq(scheme.sub1 )
                                    
                              }): Seq[FramePayloadScheme#Instance]

                           })(using (
                              
                              summon[CodeSchemeOps.TraversalDiagnostique ]
                              .ofChild(divName = s"contents")

                           ))
                        })
                        match {
                           case s =>
                              import avcframewrk.util.lazylists.asTerminatingCollOnException
                              s.asTerminatingCollOnException()
                        }

                     })

                     cp
                  }
                  
               }

               trait CrossReprCommonOpsTrait
               extends
               `E S` with @!.Element
               {

                  /* these will each be typed as `path.to.value.type` */

                  override
                  lazy val classSimpleName: inferred.classSimpleName.type = {
                     inferred.classSimpleName
                  }

                  export inferred.{classIntName as className }

               }
               
               (new CrossReprCommonOpsTrait {

                  import inferred.appropriateSchemeDef

                  override
                  def toString(): String = {
                     
                     import language.unsafeNulls /* for this `toString` impl */
                     
                     super.toString()
                     .replaceFirst("\\s*(?=\\>)", s" (length)=${efpr.payloadLength }")
                  }

                  override
                  val children = {

                     import inferred.{childrenAsLazyList => cp }

                     /**
                      * 
                      * if appropriate,
                      * instruct for eager eval of the `LazyList`
                      * 
                      */
                     try {
                        cp
                        .to(rpia.eagerness.characteristicSeqFactory )
                        .toSeq
                        
                     } catch {

                        case z : Exception =>
                           if false then {
                           ;
                           sys.process.stderr.println(s"failed parsing ${efpr.toString() }")
                           sys.process.stderr.println(s"failing with ($z) ; payload-length: ${efpr.payloadLength } ; parsed children LL: $cp")
                           }
                           throw z

                     }

                  }

               }) : @!.Element
               // {
               //    // TODO
               //    r.readEbmlElements11(validator = null)
               // }
         }

         // @deprecated("experimental")
         @annotation.experimental
         def writeBnr(d: Instance, dest: RnpDest): WbnrR = {
            // dest writeEbmlFrame (({
            //    import d.{typeInt, payloadLength, payload }
            //    Wrbeiop(typeInt = typeInt, payload = payload )
            // }))
            ??
         }

      }

      protected[FramePayloadScheme]
      def xEnsureFullyEvaluated(e : @!.Element ): Unit = {

         {
                                 e.children
                                 .to(ebmsGenericUtils.Eagerness.toBeEager.characteristicSeqFactory )
                                 .map({
                                    case e : @!.Element =>
                                       xEnsureFullyEvaluated(e)
                                    case _ =>
                                 })
         }
      }

      // @annotation.experimental
      opaque type OfMulti
         <: (
         FramePayloadScheme & FramePayloadScheme.OfFixedLengthStrv {
            
            type Instance 
               >: Seq[FramePayloadScheme#Instance]
               <: Seq[FramePayloadScheme#Instance]

         }
         )
         = VariadicImpl[?, ?]
      
      // @annotation.experimental
      // protected 
      sealed 
      case class VariadicImpl[
         +Len               <: S[cHasVariableLength.type | cbsq.FileSize], 
         // +Child             <: FramePayloadScheme ,
         // +ChildrenLsPattern <: () => XSc ,
         +ChildrenLsPattern <: () => FramePayloadScheme ,
      ](  
         encodedLength: Len , 
         childSchemeM1: ChildrenLsPattern ,
      ) 
      extends 
      FramePayloadScheme
      with (FramePayloadScheme.OfFixedLengthStrv)
      with (CodeUnitScheme.XLengthOverrideableAs[VariadicImpl[?, ChildrenLsPattern ] ] )
      {

         type Instance 
            >: Seq[FramePayloadScheme#Instance]
            <: Seq[FramePayloadScheme#Instance]

         // TODO
         override
         def withSpecificLength(l: cbsq.FileSize) = {
            // throw UnsupportedOperationException()
            this
         }
         
         override
         type RnpSource
            >: UnpickleInputStream
            <: UnpickleInputStream

         override
         def readAndParseImpl(r: ReadingParsingImplArg)(using allItemsCst : CodeSchemeOps.TraversalDiagnostique) = {
                  ;
                  
                  import r.reoc

                  extension (es : reocImpl.ReocReturn ) {

                     def checkPrecedentAndMarkAntecedent(): Unit = {

                        es._1.checkCompleted()
                        es._2.markCompleted()
                     }

                  }

                  // val esAll = reoc.mark()

                  val scheme = (
                     (
                        childSchemeM1()
                     )
                  ) : FramePayloadScheme

                  var c : Int = 0

                  val synch = new AnyRef
                  
                  import synch.{synchronized => synchronizedIfNecessary }

                  def readNextChild()(using CodeSchemeOps.TraversalDiagnostique): scheme.Instance = synchronizedIfNecessary ({
                        ;
                        
                        // withConvertingReocExceptionIntoStreamRaceCondCorruptiveEbmalformationException ({
                           
                        //    lazy
                        //    val esEach = reoc.mark()

                        //    esEach._1.checkCompleted()
                        //    esEach._2.markCompleted()

                        // })
                        
                        ({
                           import scheme.{readAndParseImpl => specificReadAndParseImpl}

                           util.Try({
                              specificReadAndParseImpl(r ) 
                           })
                           .recover({ case _ : CodeSchemeOps.UnsupportedLazyReadingException => {
                              specificReadAndParseImpl(r.copy(eagerness = ebmsGenericUtils.Eagerness.toBeEager ) )
                           } })
                           .get
                           
                        } : scheme.Instance )
                        match { case v => c += 1 ; v }
                  })

                  // private
                  val checkChildrenLlNotEvaluatedTwice: () => Unit = {
                     val c = new java.util.concurrent.atomic.AtomicBoolean
                     () => {
                        if c.getAndSet(true) then {
                           throw (
                              summon[CodeSchemeOps.TraversalDiagnostique]
                              .newLexerException(msg = s"double childrenLl init")
                           )
                        }
                     } : Unit
                  }

                  lazy val childrenLl : LazyList[FramePayloadScheme#Instance] = {

                     import avcframewrk.util.lazylists.asTerminatingCollOnException

                     //
                     LazyList.unfold[FramePayloadScheme#Instance, (Unit, (() => reocImpl.ReocReturn ) | Null )]({
                        // TODO
                        ;
                        
                        /**
                         * 
                         * the one for the first turn
                         * needs to be `lazy`, as
                         * the resulting `LazyList`
                         * might remain unevaluated indefinitely
                         * 
                         */
                        lazy 
                        val esEach = {
                           reoc.mark()
                        }

                        // EmptyTuple :* () :* ""
                        ((), () => esEach )
                     })({ case (() , esEach0Get ) => {
                     ;
                      
                     val i = c

                     implicit val itemCst : CodeSchemeOps.TraversalDiagnostique = (
                        (allItemsCst)
                        .ofChild(divName = s"$i")
                     )

                     util.Using.resource({

                        withConvertingReocExceptionIntoStreamRaceCondCorruptiveEbmalformationException ({
                           
                           // lazy
                           // val esEach = esEach0Get()

                           // esEach.checkPrecedentAndMarkAntecedent()

                        })
                        
                        new java.io.Closeable {
                           override
                           def close(): Unit = {
                              // esEach._2.markCompleted()
                           }
                        }
                     })(_ => {

                        val noMore = {
                           r.isAtEofRelevantly
                        } : Boolean
                        
                        if (noMore) {
                           
                           sys.process.stderr.println((
                              summon[CodeSchemeOps.TraversalDiagnostique]
                              .formatCtxtualMessage(msg = "no more child to parse, ceasing" )
                              
                           ))

                           None
                        }
                        else { 
                           def forThrownEofException(z: java.io.EOFException ) = {
                              
                                 // sys.process.stderr.println(z)
                                 // None
                                 
                                 java.lang.ref.Reference.reachabilityFence(BigInt )
                                 throw (
                                    summon[CodeSchemeOps.TraversalDiagnostique]
                                    .newLexerException(msg = s"encountering EOF during (rather than right-before) parsing of a child. (collected: ${childrenLl })" , r = r )
                                 )

                           }
                           def forThrownChildMalformednessException(z: java.io.IOException & EBmlPrimitivesMalformationException ) = {
                              
                                 import language.unsafeNulls

                                 // sys.process.stderr.println(z)
                                 // None

                                 val presentlyIndex = c

                                 val priorChildContent = {
                                    // TODO
                                    childrenLl
                                    .applyOrElse(presentlyIndex + -1, _ => null )
                                 }
                                 
                                 val priorChildToString = {
                                    priorChildContent
                                    .tryConvertToString()
                                 }
                                 
                                 java.lang.ref.Reference.reachabilityFence(BigInt )
                                 val msg = (
                                    summon[CodeSchemeOps.TraversalDiagnostique]
                                    .formatCtxtualMessage(msg = s"encountered EBmlPrimitivesMalformationException during child #$presentlyIndex -- (prior child: $priorChildToString ) -- $z " )

                                 )
                                 z match {

                                    case z : EBmlPrimitivesMalformationException.IDueToZeroByteEofException =>
                                       /** very normal, meaning that we're supposed to stop and return */
                                       None
                                       
                                    case _ =>
                                       throw z.rewrapped1(msg)

                                 }
                              
                           }
                           try

                              assert(summon[CodeSchemeOps.TraversalDiagnostique] == itemCst )

                              // esEach._2.markCompleted()
                              withConvertingReocExceptionIntoStreamRaceCondCorruptiveEbmalformationException {
                                 // val esEach = reoc.mark()
                                 // esEach.checkPrecedentAndMarkAntecedent()
                              }

                              val s1 = (
                                 readNextChild()(using itemCst)
                              )
                              
                              withConvertingReocExceptionIntoStreamRaceCondCorruptiveEbmalformationException {
                                 // val esEach = reoc.mark()
                                 // esEach.checkPrecedentAndMarkAntecedent()
                              }

                              Some(s1 , (() , ({
                                 null
                              })))

                           catch {
                              
                              case z @ CodeSchemeOps.TraversalDiagnostique.PSO(v @ _*) =>

                                 sys.process.stderr.println((
                                    summon[CodeSchemeOps.TraversalDiagnostique]
                                    .formatCtxtualMessage(msg = s"tolerated exception, ($z) $v " )
                                 ))

                                 None

                              case z : java.io.EOFException =>
                                 
                                 forThrownEofException(z)

                              case z : EBmlPrimitivesMalformationException =>
                                 
                                 forThrownChildMalformednessException(z)
 
                           }
                        }
                     })
                     }})
                     .match { case ll => {
                        LazyList() lazyAppendedAll {
                           ;

                           checkChildrenLlNotEvaluatedTwice()

                           withConvertingReocExceptionIntoStreamRaceCondCorruptiveEbmalformationException {
                              // val esEach = reoc.mark()
                              // esEach.checkPrecedentAndMarkAntecedent()
                           }

                           Seq()
                        } lazyAppendedAll ll
                     } }
                     .match { case ll => {
                        ll
                        .asTerminatingCollOnException()
                     } }
                     .match { case ll => {
                        ll
                        .zipWithIndex
                        .tapEach({ case (_, i) => {
                           ll.take(i ).lastOption match {
                        
                              case Some(e : @!.Element) =>
                                 xEnsureFullyEvaluated(e )
                        
                              case _ =>
                        
                           }
                        } })
                        .map(_._1) 
                     } }
                  }
                  
                  /**
                   * 
                   * if appropriate ,
                   * instruct for eager eval of the `LazyList`, and
                   * return the resulting Seq
                   * 
                   */
                  childrenLl
                  .to(r.eagerness.characteristicSeqFactory )
         }

         extension (r: RnpSource) {
            def isAtEofRelevantly: Boolean = {
               // TODO
               r.isAtEof(tipSize = (0x2).B )
               // ??
            }
         }

         @annotation.experimental
         def writeBnr(d: Instance, dest: RnpDest): WbnrR = ??
         
      }
      
      export CodeUnitScheme.ofAnyOf

      /**
       * 
       * *one-or-more items, each satisfying any of the listed schemae *,
       * 
       */
      // @annotation.experimental
      def ofOneOrMoreOfAnyOf[ChildSchema <: FScOps](c: Set[? <: ChildSchema]): (
         FramePayloadScheme & FramePayloadScheme.OfFixedLengthStrv
      ) = {
         ofOneOrMoreOfAnyOf1(c = c)
      }
      /**
       * 
       * *one-or-more items, each satisfying any of the listed schemae *,
       * 
       */
      // @annotation.experimental
      def ofOneOrMoreOfAnyOf1[ChildSchema <: FScOps](c: Set[? <: ChildSchema]) = {
         ofOneOrMoreOfAnyOf1A(c = Lazy(c) )
      }
      /**
       * 
       * *one-or-more items, each satisfying any of the listed schemaë *,
       * 
       */
      // @annotation.experimental
      def ofOneOrMoreOfAnyOf1A[ChildSchema <: FScOps](c: Lazy[Set[? <: ChildSchema] ]) = {
         lazy val cCached = c.value
         VariadicImpl(encodedLength = cHasVariableLength, childSchemeM1 = () => {
               ofAnyOf(c = cCached )
         } )
      }
      /**
       * 
       * *one-or-more items, each satisfying any of the listed schemaë *,
       * 
       */
      // @annotation.experimental
      def ofOneOrMoreOfAnyOf1C[
         ChildSchema <: (
            FScOps {   
            }
         ) ,
      ](c: Lazy[Map[BigInt, ? <: ChildSchema] ]) = {
         lazy val cCached = {
            c.value match {
               case m =>
                  ofFrame(scheme = m)
            }
         }
         VariadicImpl(encodedLength = cHasVariableLength, childSchemeM1 = () => {
               cCached
         } )
      }
      
      // @deprecated("experimental")
      // @annotation.experimental
      trait XSc {

         val schemeMap : Map[BigInt, FScOps ]
         
      }

      /**
       * 
       * the type which every Scheme listed in a scheme-table shall `extends`
       * 
       */
      type FScOps
         >: FramePayloadScheme & CodeUnitScheme.XLengthOverrideable
         <: FramePayloadScheme & CodeUnitScheme.XLengthOverrideable

      /**
       * 
       * matches *a single node, which must be a frame*
       * 
       */
      // @annotation.experimental
      // @deprecated("experimental")
      def ofFrame(scheme : (
         PartialFunction[BigInt, (
            FramePayloadScheme & CodeUnitScheme.XLengthOverrideable { 
               // type Instance <: Seq[FramePayloadScheme.OfMulti#Instance ]
            }
         ) ]
      )): OfFrame = {
         // TODO
         Offr(encodedLength = cHasVariableLength, classPayloadsTable = (
            scheme
         ) )
      }

      /**
       * 
       * *frame*
       * containing exactly one child
       * in-turn
       * conforming to any of these schemes
       * 
       */
      // @annotation.experimental
      // @deprecated("experimental")
      def ofFrameOfExactlyOneOccurInSch(schemeLzy : Lazy[XSc ]) = {
         // TODO
         lazy val sch1 = {
            val scheme = schemeLzy.value
            scheme match {
               case s =>
                  val s1 = (
                     s.schemeMap
                     .values
                     .toSet[FramePayloadScheme]
                  )
                  ofAnyOf(c = s1)
            }
         }
         Offr(encodedLength = cHasVariableLength, classPayloadsTable = (cls1) => (
            sch1
         ) )
      }

      /**
       * 
       * *frame* 
       * containing one-or-more child
       * each in-turn
       * conforming to any of these schemes
       * 
       */
      // @annotation.experimental
      // @deprecated("experimental")
      def ofFrameOfOneOrMoreOfAnyInSch(schemeLzy : Lazy[XSc ]) = {
         // TODO
         lazy val sch1 = {
            val scheme = schemeLzy.value
            scheme match {
               case s =>
                  val s1 = (
                     s.schemeMap
                     .values
                     .toSet[FScOps]
                  )
                  ofOneOrMoreOfAnyOf1A(Lazy(s1) )
            }
         }
         Offr(encodedLength = cHasVariableLength, classPayloadsTable = (cls1) => (
            sch1
         ) )
      }

      object trvdFramesIoExcs {
         
         final val notEBml = (
            "E\u0336B\u0336M\u0336L\u0336MalformedEBml"
         )
         
         def newFirstPlaceEofException(using CodeSchemeOps.TraversalDiagnostique)(z: java.io.EOFException, r: java.io.Closeable) = {
            
            import language.unsafeNulls
            
            val msg = (
               summon[CodeSchemeOps.TraversalDiagnostique]
               .formatCtxtualMessage(msg = (
                  s"EOF in the first place - wanted to pull unprocessed EBML frame."
                  + " " + z.getMessage()
               ) )
            )

            (
               new
               java.io.IOException(msg, z)
               with EBmlPrimitivesMalformationException.IDueToZeroByteEofException
               with EBmlPrimitivesMalformationException.%%!
            )
         }

         // type M = ({ val main1 : EBsd ; type Main <: main1.FramePayloadScheme.trvdFramesIoExcs.IOfSchemeLookupFailure })#Main

         // summon[IOfSchemeLookupFailure <:< M ]

         export EBmlPrimitivesMalformationException.IDueToEofException

         export EBmlPrimitivesMalformationException.IOfSchemeLookupFailure

      }
   
      // @annotation.experimental
      def newSchema(
         initSchemeMap: (this1: FramePayloadScheme.XSc) => Map[BigInt, FScOps] ,
      ) = {
         lazy val this1C : FramePayloadScheme.XSc = {
            new FramePayloadScheme.XSc 
            { this1 =>

               // TODO fix the obvious "spurious" nulls
               val schemeMap = {
                  initSchemeMap(this1 )
               }

            }
         }
      }

   }

   extension (r: UnpickleInputStream) {
      
      def readEbmlByScheme(s: FramePayloadScheme)(using CodeSchemeOps.TraversalDiagnostique) = {
         s readAndParseAlt(src = r, eagerness = ebmsGenericUtils.Eagerness.toBeEager, reoc = CodeSchemeOps.xNewReoc() )
      }

   }

   extension (className: BigInt) {

      private[EBsd ]
      def ebmlClassNameFmatted: String = {
         "!e:" + className.toString(0x10)
      }
   }
   
   /* ad-hoc */
   @deprecated("experimental")
   // private[EBsd ]
   object `elements_@&%!` {

      // sealed 
      trait Element {
         
         val className: BigInt

         lazy val classSimpleName: String = {
            className.ebmlClassNameFmatted
         }

         val children: Seq[FramePayloadScheme#Instance] 

      } 

      // sealed 
      // case class Element1(
      //    val className: BigInt ,
      //    val children: Seq[Element] ,
      // )

   }

   private[EBsd]
   abstract class `E S` 
   extends
   AnyRef 
   with `elements_@&%!`.Element
   {
            ;

            // import FramePayloadScheme.*

            override
            def toString(): String = {

               try {
                  toStringImpl()
               }
               catch {
                  case z: Exception =>
                     s"[failed stringify: $z ]"
               }
            }

            private
            def toStringImpl(): String = {
               import language.unsafeNulls /* for this `toString` impl */

               (
                  Seq()
                  :+ s"<${classSimpleName } >"
                  :++ (
                     children
                     .to(Vector) /* not essential, but may be necessary to avoid stack-overflowing and improve perfmce, especially as laziness is of no use here (this is for `toString`) */
                     .map[String]({
                        
                        case e: collection.immutable.ArraySeq.ofByte if (2 <= e.length) =>
                           
                           ({
                              import java.util.HexFormat
                              HexFormat.of()
                              .formatHex(e.unsafeArray )
                           })
                           
                           .trimToJustFiveHundred()
                           .replaceFirst("[\\S\\s]+", "<?RAWBYTES: $0 />")

                        case e : (java.net.URI) =>

                           e.toASCIIString()
                           
                           match {

                              case s"data:text/plain,${v0 }" =>
                                 new java.net.URI(s"txt:$v0").toString()
                                 match {
                                    case s"txt:${value}" =>
                                       value
                                 }

                              case _ =>
                                 s"<?EMB: ${e.toASCIIString().trimToJustFiveHundred() } />"

                           }

                        case e =>
                           e.toString()

                     })
                     .map(s => s.indent(0x2 ) )
                  )
                  :+ "</>"
               ).mkString("\r\n")
            }

   }

   // def getLengthOfDataType[C](c: reflect.ClassTag[C]): cHasVariableLength.type | cbsq.FileSize
   private[riffmt] 
   final
   lazy val cStdDataTypeSizingUtil = {
      CodeSchemeOps.cStdDataTypeSizingUtil
   }

   private 
   object schemeAlternativeImpl {

      def demarsh[
         Instance1 ,
         ChildScheme <: (FramePayloadScheme) { type Instance <: Instance1 } ,
      ](
         s: ([I] =>> (Set[? <: I] | Seq[I] ) )[ChildScheme ] ,
      )(using CodeSchemeOps.TraversalDiagnostique)(ec: CodeUnitScheme#ReadingParsingImplArg, r: UnpickleInputStream ): Instance1 = {
            type Instance = Instance1
            /**
             * 
             * making use the fact that it's a `BufferedInputStream`,
             * the right thing to do
             * is to 
             * try parsing with the first scheme (in the options) or, if failing,
             * try the next ones until finding a match,
             * on each failing case rewinding back to the original pos and yet
             * on the successful case leaving the reader at its current position,
             * 
             */
            ebsr.breakablyGet[Instance1](resolve => {
               for (c <- s) {
                  util.Using.resource((
                     /**
                      * 
                      * call `newMarkResetTurn`,
                      * calling `r.mark(...)` and then returning with a (...)
                      * 
                      * must keep reference to the returned (...)
                      * as later-on
                      * the successful case will need to
                      * call `emr.setShallReset(false)` 
                      * (to prevent the reader from rolling back, leaving the reader at its current position)
                      * 
                      */
                     newMarkResetTurn(r, 0x400) 
                  ))(emr => {
                     (try {
                        ((
                           // s readAndParseAlt(src = r, eagerness = ebmsGenericUtils.Eagerness.toBeEager )
                           c readAndParseAlt(src = r, eagerness = ec.eagerness, reoc = ec.reoc )
                        ), {
                           import reflect.Selectable.reflectiveSelectable
                           /**
                            * 
                            * otherwise, the reader would roll back
                            * 
                            */
                           emr.setShallReset(false)
                        } )._1
                     } catch {
                        case z : EBmlPrimitivesMalformationException =>
                           throw z
                        case z : java.io.EOFException =>
                           throw z
                     }) match {
                        case v =>
                           /**
                            * 
                            * short-circuit the whole loop
                            * 
                            */
                           resolve(v)
                     }
                  })
               }
               // TODO
               // throw new java.io.IOException(s"none match. ${s }") with EBmlPrimitivesMalformationException.%%!
               throw summon[CodeSchemeOps.TraversalDiagnostique].newLexerException(msg = s"none match. ${s }")
            })
      }

   }

   // export ebmsGenericUtils.checkNotAtEof

   private
   def withConvertingReocExceptionIntoStreamRaceCondCorruptiveEbmalformationException[R](c : => R)(using CodeSchemeOps.TraversalDiagnostique) = {

      try c

      catch {

         case z : EBmlPrimitivesMalformationException =>
            throw z

         case z : Exception =>
            import language.unsafeNulls
            val msg = {
               summon[CodeSchemeOps.TraversalDiagnostique]
               .formatCtxtualMessage(msg = s"reoc exception. check for race-condition or stream pipeline corruption !! $z" )
            }
            throw (
               new
               java.io.IOException(msg, z)
               with EBmlPrimitivesMalformationException.%%!
            )

      }
   }

   private
   def withShallDebugThrownReocIfNecessary[R](c : => R) = {
      try c
      catch {
         case z : Exception =>
            throw z
      }
   }

   private 
   class PF extends Throwable

   @annotation.experimental
   protected 
   def ?? = ???
   
}

trait EBsdSpecificUtilDefs extends 
   AnyRef 
   // with EBmlByteManipIoReExports
   // with EBmlPrimitivesIoReExports
{ EBml: (
   AnyRef 
   with EBmlByteManipIoReExports
   with EBmlPrimitivesIoReExports
) =>
   //
   
   export ebmsGenericUtils.utfEncodedAsUrl
   
   export ebmsGenericUtils.encodedAs

   extension [C](priorChildContent: C) {

      def tryConvertToString(): String = {
         
         import language.unsafeNulls /* for this `toString` impl */

         {
            
                                    util.Try({ s"$priorChildContent" })
                                    .recover(z => s"[cannot stringify: $z ]" )
                                    .get
                                    
         }
      }
      
   } /* trimToJustFiveHundred */

   extension (v: String) {

      def trimToJustFiveHundred(): String = {
         
         import language.unsafeNulls /* for this `toString` impl */

         v
               .replaceFirst("\\A([\\S\\s]{500})[\\S\\s]{87,}\\z", "$1...")
      }
      
   } /* trimToJustFiveHundred */

   /**
    * 
    * "Reader/InputStream Usage Control"
    * a toolkit 
    * for implementing the locking-control before the main InputStream-or-Reader
    * 
    * the entry point is the `newReoc()` method, returning new/independent `Reoc` 
    * 
    * every invoc of the `reoc.mark()` method 
    * shall return a pair of `object`s, one `?{ def checkCompleted() }` and one `?{ def markCompleted() }` .
    * 
    * unless the `markCompleted()` of the latter obj has ben called,
    * the `checkCompleted()` itc returned by the next `reoc.mark()` will `throw` `IllegalStateException`.
    * however,
    * as a base-case,
    * for the first/initial `reoc.mark()`, the returned `checkCompleted()` itc will always return successfully .
    * 
    */
   private[riffmt]
   final
   lazy
   val reocImpl : avcframewrk.util.errorchecking.reocsImpl.type = {

      avcframewrk.util.errorchecking.reocsImpl
   }

}



// trait EBmlSemanticsException extends Exception


















