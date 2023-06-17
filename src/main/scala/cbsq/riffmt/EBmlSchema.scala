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

      // def readAndParseImpl(r: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique): Instance

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
      
      // override
      // def readAndParseImpl(r: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique): Instance

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

         // def readAndParseImpl(r: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique): Instance = {
         //    schemeAlternativeImpl.demarsh[
         //       Instance1 ,
         //       ChildScheme ,
         //    ](s)(using summon[CodeSchemeOps.TraversalDiagnostique].ofChild(divName = "alts"))(ec = r , r = r )
         // }

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
                              
                              val oe = (
                                 summon[CodeSchemeOps.TraversalDiagnostique ]
                                 .newLexerException(msg = s"zero-byte EOF exception" )
                              )
                              throw (
                                 new java.io.IOException(oe.getMessage() , z ) with EBmlPrimitivesMalformationException.IDueToZeroByteEofException
                              )
                        } 
                     })
                     .++({

                        try { r readNBytesEbmSc(-1 + l ) }
                        
                        catch {
                           
                           case z : java.io.IOException => 
                              val oe = (
                                 summon[CodeSchemeOps.TraversalDiagnostique ]
                                 .newLexerException(msg = s"half-payload EOF exception" )
                              )
                              throw (
                                 new java.io.IOException(oe.getMessage() , z ) with EBmlPrimitivesMalformationException.IDueToPayloadEofException
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

      // def readAndParseImpl(r: ReadingParsingImplArg)(using CodeSchemeOps.TraversalDiagnostique): Instance

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
         // private val
         className : FrameSchemeClsSimpleNameArgValue ,
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
      type FrameSchemeClsSimpleNameArgValue
         >: Null
         <: Null
      
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
                  ofFrame(scheme = m, className = null)
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
      ), className: FrameSchemeClsSimpleNameArgValue ): OfFrame = {
         // TODO
         Offr(encodedLength = cHasVariableLength, classPayloadsTable = (
            scheme
         ) , className = className  )
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
      def ofFrameOfExactlyOneOccurInSch(schemeLzy : Lazy[XSc ], className: FrameSchemeClsSimpleNameArgValue ) = {
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
         ), className = className  )
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
      def ofFrameOfOneOrMoreOfAnyInSch(schemeLzy : Lazy[XSc ], className: FrameSchemeClsSimpleNameArgValue ) = {
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
         ) , className = className  )
      }

      object trvdFramesIoExcs {
         
         final val notEBml = (
            "E\u0336B\u0336M\u0336L\u0336MalformedEBml"
         )
         
         def newFirstPlaceEofException(using CodeSchemeOps.TraversalDiagnostique)(z: java.io.EOFException, r: java.io.Closeable) = {
            
            import language.unsafeNulls
            
            val msg = (
               summon[CodeSchemeOps.TraversalDiagnostique]
               .newLexerException(msg = (
                  s"EOF in the first place - wanted to pull unprocessed EBML frame."
                  + " " + z.getMessage()
               ), r = r )
               .getMessage()
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

   /**
    * 
    * instances
    * maintains the element-names.
    * 
    */
   type FrameNameRepertoire
      >: Fnrp1
      <: Fnrp1

   trait Fnrp1 extends AnyRef
   {

      type RegisteredName

      val listOfRegisteredNames : collection.Iterable[RegisteredName]

      def presentlyRegisteredNames : collection.immutable.Iterable[RegisteredName]
      
      def forUnsignedIntName[
         I >: BigInt <: BigInt ,

      ](v: I) : RegisteredName

      def forSimpleName[
         SimpleName >: String <: String ,

      ](v: SimpleName) : RegisteredName

      extension (v: RegisteredName) {

         def asSimpleName : String

         def asUnsignedIntName : BigInt

      }

   }

   extension (r: UnpickleInputStream) {
      
      @annotation.experimental
      def readEbmlByScheme(s: FramePayloadScheme)(using CodeSchemeOps.TraversalDiagnostique) = {
         // s readAndParseAlt(src = r, eagerness = ebmsGenericUtils.Eagerness.toBeEager, reoc = CodeSchemeOps.xNewReoc() )
         Predef.???
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
               .newLexerException(msg = s"reoc exception. check for race-condition or stream pipeline corruption !! $z" )
               .getMessage()
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


















