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

object ebmlSchemesUtilChronography
{
   
            export  concurrent.duration.{Deadline, Duration, FiniteDuration }
            export  concurrent.duration.{DurationDouble, DurationLong, DurationInt }
            import  System.currentTimeMillis
            val deadlineZero = (
               Deadline(0.second)
            )
            val forAmtSinceEpoch = ((sp: FiniteDuration) => (
               // Deadline(Duration())
               // .`-`(() )
               // .`+`(sp)
               Deadline((
                  (
                     /** duration from `Deadline(0.seconds)` to `TheEpoch` */ 
                     { 
                        val durationSinceDeadlineZero = (
                           ((Deadline.now - deadlineZero ) : FiniteDuration )
                        )
                        val ctmWhenDeadlineZero = (
                           currentTimeMillis()
                           + 
                           -durationSinceDeadlineZero.toMillis
                        )
                        Duration((
                           -ctmWhenDeadlineZero 
                        ) : Long, java.util.concurrent.TimeUnit.MILLISECONDS)
                     }  
                     : FiniteDuration
                  )
                  .`+`(sp )
               ))
            ))
            
}

// def ***%(e: EBmlByteManipIoReExports) = {
//    e.isAtEof()
//    object eio {
//       export byteManipImplicits.isAtEof
//    }
//    eio.isAtEof()
//    byteManipImplicits.isAtEof()
// }
// def ***%@(e: EBmlPrimitivesIoReExports) = {
//    e.isAtEof()
// }

/**
 * 
 * `EBml.CodeSchemeOps` shall `extends` this `trait`
 * 
 */
sealed trait chvl extends 
   AnyRef 
{
   
      /**
       * 
       * extending `Singleton` is necessary,
       * so that the inferred types become the exact argument value types
       * 
       * ```
       * applyRelevantMod(mode = 3)
       * ```
       * 
       */
      type S[+T] = Singleton & T

      sealed
      case class Lze[K, +V](protected val getPresentValue: K => V ) {

         private
         val at = {
            new java.util.concurrent.atomic.AtomicReference[Map[K, util.Try[V]] ](Map() )
         }

         private
         def prepareForKey(k: K) = {
            at
            .updateAndGet(m0 => {
               m0
               /**
                * load, if-and-only-if left unset
                */
               .updatedWith[util.Try[V] ](k)(o => (
                  o orElse ({
                     val tr = (
                        util.Try({
                           val v = getPresentValue(k)
                           v
                        })
                     )
                     Some(tr)
                  })
               ) )
            })
         }

         def get(k: K): V = {
            prepareForKey(k)
            .apply(k )
            .get
         }
         
      }
      extension [V](r: Lze[Unit, V]) {

         def value: V = {
            r get()
         }
         
      }

      class Lazy[+V](presentlyValue: => V ) {
         lazy val value = presentlyValue
      }
 
      /**
       * 
       * a specia-value denoting "can be any length"
       * 
       */
      case object cHasVariableLength

      /**
       * 
       * the EBML RFC/spec 
       * defines this to be `the 1st of January 2001, 00:00`
       * 
       */
      val globalBaseDate = (
         {
            import ebmlSchemesUtilChronography.*
            locally {
               // TODO
               forAmtSinceEpoch((
                  ((2001 - 1970 ) * ((365.25 * 86400 ).toDouble + 0.5 ) )
                  .toLong
                  .second
               ) )
            }
         }
      ) : concurrent.duration.Deadline

      extension (r: java.io.InputStream) {

         /**
          * 
          * reads and interprets EBml Date Fmt as specified
          *
          * @param supposedReadingLength the exact expected number of bytes
          * 
          */
         def readEbmlDateBytes(supposedReadingLength: Long): concurrent.duration.Deadline = {
            import  concurrent.duration.*
            val parsedValue = (
               // TODO
               {
                  val rawBytes = (
                     r
                     .readNBytes((
                        supposedReadingLength
                        .toInt
                     ))
                     .toIndexedSeq
                  )
                  BigInt(rawBytes.toArray )
               }
            ) : BigInt
            globalBaseDate `+` (
               // TODO
               (parsedValue )
               .toLong.nanoseconds
            )
         }
         
      }

}

trait EBsd extends 
   AnyRef 
   // with EBmlByteManipIoReExports
   // with EBmlPrimitivesIoReExports
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
   sealed trait CodeSchemeOps {
      
      type Instance

      def readAndParse(r: RnpSource)(using CodeSchemeOps.TraversalDiagnostique): Instance

      type RnpSource
        <: java.io.InputStream | java.io.DataInput

      def writeBnr(d: Instance, dest: RnpDest): WbnrR

      type RnpDest
        <: java.io.DataOutput

      type WbnrR >: Unit <: Unit

   }
   object CodeSchemeOps extends 
   AnyRef
   with chvl
   {

      abstract class TraversalDiagnostique {

         val path : String

      }
      object TraversalDiagnostique {

         val nullaryInstance : TraversalDiagnostique = new TraversalDiagnostique {
            val path = "???"
         }

         // given defaultInstance : TraversalDiagnostique = nullaryInstance

         private[CodeSchemeOps] 
         def ofChildImpl(parent: TraversalDiagnostique, divName: String): TraversalDiagnostique = {
            if (parent == nullaryInstance) {
               return (
               new TraversalDiagnostique {
                  val path = divName
               }
               )
            }
            new TraversalDiagnostique {
               val path = parent.path + "/" + divName
            }
         }
         extension (parent: TraversalDiagnostique) {

            def ofChild(divName: String) = {
               ofChildImpl(parent, divName)
            }
            
         }
         
         extension (parent: TraversalDiagnostique) {

            def newLexerException(
               msg: String ,
               r: Null | java.io.Closeable = null ,
            ): Exception = {
               new java.io.IOException(s"[${parent.path }]: $msg") with EBmlPrimitivesMalformationException {

                  /* only show up in debuggers */
                  val correlatedRes = r

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

   }

   import `! EBmlSch iCommon1` as common1
   object `! EBmlSch iCommon1` {
 
      export CodeSchemeOps.*

      def getLengthOfDataType[C](c: reflect.ClassTag[C]): cHasVariableLength.type | cbsq.FileSize = {
         cStdDataTypeSizingUtil.getLengthOfDataType(c = c )
      }

      extension(this1: FramePayloadScheme | CodeUnitScheme) {

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
      def readAndParse(r: RnpSource)(using CodeSchemeOps.TraversalDiagnostique): Instance

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
            
            def readAndParse(r: RnpSource)(using CodeSchemeOps.TraversalDiagnostique): Instance = {
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

      @annotation.experimental
      type OfPrm[
         +K <: Singleton & ("|" ) ,
      ] = OfPrmOf[K, ?, ?]
      
      @annotation.experimental
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

      @annotation.experimental
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

         def readAndParse(r: RnpSource)(using CodeSchemeOps.TraversalDiagnostique): Instance = {
            schemeAlternativeImpl.demarsh[
               Instance1 ,
               ChildScheme ,
            ](s)(using summon[CodeSchemeOps.TraversalDiagnostique].ofChild(divName = "alts"))(r)
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

         def readAndParse(r: RnpSource)(using CodeSchemeOps.TraversalDiagnostique) = {
            r.readEbmlDateBytes(supposedReadingLength = supposedReadingLength )
         }
         
         def writeBnr(d: Instance, dest: RnpDest): WbnrR = {
            util.control.NonLocalReturns.returning[WbnrR](resolve ?=> {
               @annotation.experimental
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
         
         def readAndParse(src: RnpSource)(using CodeSchemeOps.TraversalDiagnostique): Instance = {
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

      @annotation.experimental
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
      with XLengthOverrideable
      {
         
         type Instance 
            >: cbsq.ByteBlob | java.net.URI
            <: cbsq.ByteBlob | java.net.URI

         def readAndParse(r: RnpSource)(using CodeSchemeOps.TraversalDiagnostique) = {
            encodedLength match {
               case encodedLength : cbsq.FileSize =>
                  val b = cbsq.ByteBlob.copyOf(r readNBytes(encodedLength.inBytes.toInt ) )
                  b encodedAs(enc = enc )
                  
               case _ =>
                  throw summon[CodeSchemeOps.TraversalDiagnostique].newLexerException(msg = "'encodedLength' not specified")
            }
         }

         def writeBnr(d: Instance, dest: RnpDest): WbnrR = ??

         // TODO
         override
         def withSpecificLength(l: cbsq.FileSize) = {
            copy(encodedLength = l)
         }
         
      }

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
      trait XLengthOverrideable extends 
      AnyRef 
      { thisScheme : FramePayloadScheme =>

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
         )

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

      def readAndParse(r: RnpSource)(using CodeSchemeOps.TraversalDiagnostique): Instance

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
      @deprecated("experimental")
      // private[FramePayloadScheme ]
      object `elements_@&%!` {

         // sealed 
         trait Element { val className: BigInt ; val children: Seq[FramePayloadScheme#Instance] } 

         // sealed 
         // case class Element1(
         //    val className: BigInt ,
         //    val children: Seq[Element] ,
         // )

      }

      extension (className: BigInt) {

         def ebmlClassNameFmatted: String = {
            "!e:" + className.toString(0x10)
         }
      }
      
      import `elements_@&%!` as @!
      
      private
      abstract class `E S` 
      extends
      AnyRef 
      with `elements_@&%!`.Element
      {
         
               override
               def toString(): String = {
                  (
                     Seq()
                     :+ s"<!e:${className.ebmlClassNameFmatted } >"
                     :++ (
                        children
                        // .tapEach({
                        //    case e: collection.immutable.ArraySeq.ofByte if (500 <= e.length) =>
                        //       throw java.io.IOException(s"too many bytes: ${e.length }")
                        //    case _ =>
                        // })
                        .map[String]({
                           
                           case e: collection.immutable.ArraySeq.ofByte if (2 <= e.length) =>
                              // BigInt(0x1, (
                              //    e
                              //    .prepended[Byte](1.toByte)
                              //    .toArray
                              // ))
                              // .toString(0x10 )
                              // .drop(0x1 ) /* to remove the leading `1` char */
                              ({
                                 import java.util.HexFormat
                                 HexFormat.of()
                                 .formatHex(e.unsafeArray )
                              })
                              .replaceFirst("\\A([\\S\\s]{500,})\\z", "$1...")
                              .prependedAll("[raw_bytes]")

                           case e =>
                              e.toString()

                        })
                        .map(s => s.indent(0x2 ) )
                     )
                     :+ "</>"
                  ).mkString("\r\n")
               }

      }

      @annotation.experimental
      opaque type OfFrame
         <: (
         CodeUnitScheme & OfFixedLengthStrv0 & FramePayloadScheme.OfFixedLengthStrv {
            
            type Instance 
               >: @!.Element
               <: @!.Element

         }
         )
         = Offr[?, ?]      
      
      @annotation.experimental
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

         def readAndParse(r: RnpSource)(using CodeSchemeOps.TraversalDiagnostique): Instance = {
               // TODO
               val efpr = {
                  import trvdFramesIoExcs.*
                  try ({
                     util.Using.resource((
                        newMarkResetTurn(r, 0x100)
                     ))(_ => {
                        try {
                           new java.io.DataInputStream(r)
                           .readInt()
                        } catch {
                           
                           case z : (java.io.EOFException ) =>
                              throw (
                                 newFirstPlaceEofException(z = z, r = r)
                              )

                        }
                     })
                     //
                     /**
                      * 
                      * take the next chunk of bytes, and
                      * get the raw/as-is payload
                      * 
                      */
                     (new java.io.DataInputStream(r) )
                     .readEbmlFrameOfPayloadRaw()
                  })
                  catch {

                     case z : (java.io.EOFException ) =>
                        throw (
                           summon[CodeSchemeOps.TraversalDiagnostique]
                           .newLexerException(msg = (
                              s"EOF while pulling the raw, unprocessed $notEBml frame repr."
                              + " " + z.getMessage()
                           ), r = r )
                        )

                     case z : ( EBmlPrimitivesMalformationException) =>
                        throw (
                           summon[CodeSchemeOps.TraversalDiagnostique]
                           .newLexerException(msg = (
                              s"malformed raw, unprocessed $notEBml frame repr."
                              + " " + (z.getMessage())
                           ), r = r )
                        )
                        
                     case z : (java.io.IOException ) =>
                        throw (
                           summon[CodeSchemeOps.TraversalDiagnostique]
                           .newLexerException(msg = (
                              s"IOException rwhile pulling the raw, unprocessed $notEBml frame repr."
                              + " " + (z match { case z : java.io.EOFException => s"EOF: $z" ; case _ => z.getLocalizedMessage() })
                           ), r = r )
                        )

                  }
               }
               /**
                * 
                * the high-level repr
                * 
                */
               ernp(using (
                  summon[CodeSchemeOps.TraversalDiagnostique ]
                  .ofChild(divName = s"<${efpr.typeAsUtf } (${efpr.payloadLength })>")
               ) )(efpr = efpr )
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
            efpr: EbmRawFrameElement[String] ,
         ) = {
               (new `E S` with `elements_@&%!`.Element {

                  val className = {
                     efpr.typeInt
                  }

                  override
                  def toString(): String = {
                     super.toString()
                     .replaceFirst("\\s*(?=\\>)", s" (length)=${efpr.payloadLength }")
                  }

                  val children = {
                     val r = (
                        ((
                           new MarkableInputStreamImpl((
                              efpr.payload.newGrossReader()
                           ))
                        ))
                     )
                     val cp = ({
                        /**
                         * 
                         * new `LazyList` running `readAndParse`
                         * 
                         */
                        LazyList() lazyAppendedAll {
                           ((using : CodeSchemeOps.TraversalDiagnostique) ?=> {
                              val scheme = (

                                 classPayloadsTable
                                 .applyOrElse(className : BigInt, className => {
                                    throw (
                                       summon[CodeSchemeOps.TraversalDiagnostique]
                                       .newLexerException(msg = (
                                          s"no scheme for cls ${className.ebmlClassNameFmatted } "
                                       ))
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
                              (scheme match {

                                 case scheme : VariadicImpl[?, ?] =>
                                    scheme.readAndParse(r)
                                 case scheme =>
                                    Seq(scheme.readAndParse(r) )
                                    
                              }): Seq[FramePayloadScheme#Instance]
                           })(using (
                              
                              summon[CodeSchemeOps.TraversalDiagnostique ]
                              .ofChild(divName = s"contents")

                           ))
                        }
                     })
                     /**
                      * 
                      * instruct for eager eval of the `LazyList`
                      * 
                      */
                     try {
                        cp
                        .to(IndexedSeq)
                        .toSeq
                     } catch {
                        case z : Exception =>
                           sys.process.stderr.println(s"failed parsing ${efpr.toString() }")
                           sys.process.stderr.println(s"failing with ($z) ; payload-length: ${efpr.payloadLength } ; parsed children LL: $cp")
                           throw z
                     }
                  }

               }) : `elements_@&%!`.Element
               // {
               //    // TODO
               //    r.readEbmlElements11(validator = null)
               // }
         }

         // @deprecated("experimental")
         // @annotation.experimental
         def writeBnr(d: Instance, dest: RnpDest): WbnrR = {
            // dest writeEbmlFrame (({
            //    import d.{typeInt, payloadLength, payload }
            //    Wrbeiop(typeInt = typeInt, payload = payload )
            // }))
            ??
         }

      }

      @annotation.experimental
      opaque type OfMulti
         <: (
         FramePayloadScheme & FramePayloadScheme.OfFixedLengthStrv {
            
            type Instance 
               >: Seq[FramePayloadScheme#Instance]
               <: Seq[FramePayloadScheme#Instance]

         }
         )
         = VariadicImpl[?, ?]
      
      @annotation.experimental
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
      with (CodeUnitScheme.XLengthOverrideable)
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

         def readAndParse(r: RnpSource)(using CodeSchemeOps.TraversalDiagnostique) = {
                  val scheme = (
                     (
                        childSchemeM1()
                     )
                  ) : FramePayloadScheme
                  var c : Int = 0
                  def readNextChild()(using CodeSchemeOps.TraversalDiagnostique): scheme.Instance = (
                        ({
                           scheme
                           .readAndParse(r )
                        } , c += 1 )._1
                  )
                  lazy val childrenLl : LazyList[FramePayloadScheme#Instance] = {
                     //
                     LazyList.unfold[FramePayloadScheme#Instance, Unit](() )((_) => {
                        val noMore = {
                           r.isAtEofRelevantly
                        } : Boolean
                        if (noMore) {
                           sys.process.stderr.println("no more child to parse, ceasing")
                           None
                        } else { 
                           try 
                              val i = c
                              val s1 = (
                                 readNextChild()(using (
                                    summon[CodeSchemeOps.TraversalDiagnostique]
                                    .ofChild(divName = s"$i")
                                 ))
                              )
                              Some(s1 , ())

                           catch {
                              
                              case z : java.io.EOFException =>
                                 // sys.process.stderr.println(z)
                                 // None
                                 java.lang.ref.Reference.reachabilityFence(BigInt )
                                 throw (
                                    summon[CodeSchemeOps.TraversalDiagnostique]
                                    .newLexerException(msg = s"encountering EOF during (rather than right-before) parsing of a child. (collected: ${childrenLl })" , r = r )
                                 )

                           }
                        }
                     })
                  }
                  /**
                   * 
                   * instruct for eager eval of the `LazyList`, and
                   * return the resulting Seq
                   * 
                   */
                  childrenLl
                  .toIndexedSeq
         }

         extension (r: RnpSource) {
            def isAtEofRelevantly: Boolean = {
               // TODO
               r.isAtEof(tipSize = (0x2).B )
               // ??
            }
         }

         def writeBnr(d: Instance, dest: RnpDest): WbnrR = ??
         
      }
      
      export CodeUnitScheme.ofAnyOf

      @annotation.experimental
      def ofOneOrMoreOfAnyOf[ChildSchema <: FScOps](c: Set[? <: ChildSchema]): (
         FramePayloadScheme & FramePayloadScheme.OfFixedLengthStrv
      ) = {
         ofOneOrMoreOfAnyOf1(c = c)
      }
      @annotation.experimental
      def ofOneOrMoreOfAnyOf1[ChildSchema <: FScOps](c: Set[? <: ChildSchema]) = {
         ofOneOrMoreOfAnyOf1A(c = Lazy(c) )
      }
      @annotation.experimental
      def ofOneOrMoreOfAnyOf1A[ChildSchema <: FScOps](c: Lazy[Set[? <: ChildSchema] ]) = {
         lazy val cCached = c.value
         VariadicImpl(encodedLength = cHasVariableLength, childSchemeM1 = () => {
               ofAnyOf(c = cCached )
         } )
      }
      @annotation.experimental
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
      @annotation.experimental
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

      @annotation.experimental
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
       * of exactly one child
       * in-turn conforming to any of these schemes
       * 
       */
      @annotation.experimental
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
       * of one-or-more children
       * each in-turn conforming to any of these schemes
       * 
       */
      @annotation.experimental
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
            (
               summon[CodeSchemeOps.TraversalDiagnostique]
               .newLexerException(msg = (
                  s"EOF in the first place - wanted to pull unprocessed EBML frame."
                  + " " + z.getMessage()
               ), r = r )
            )
         }
      }
   
      @annotation.experimental
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
         s readAndParse(r)
      }

   }

   // def getLengthOfDataType[C](c: reflect.ClassTag[C]): cHasVariableLength.type | cbsq.FileSize
   private 
   object cStdDataTypeSizingUtil {

      import CodeSchemeOps.cHasVariableLength

      def getLengthOfDataType[C](c: reflect.ClassTag[C]): cHasVariableLength.type | cbsq.FileSize = {
         import reflect.ClassTag.*
         val bigIntClassTag = reflect.classTag[BigInt     ]
         val bigDcmClassTag = reflect.classTag[BigDecimal ]
         val dcdClassTag = reflect.ClassTag[concurrent.duration.Deadline]
         c match
            
            case Unit  => 0.B

            case Byte  => ( 0x01).B
            case Char  => ( 0x02).B
            case Short => ( 0x02).B
            case Int   => ( 0x04).B
            case Long  => ( 0x08).B

            case `bigIntClassTag` => cHasVariableLength

            case Float   => ( 0x04).B
            case Double  => ( 0x08).B

            case `bigDcmClassTag` => cHasVariableLength

            case `dcdClassTag` => (0x08 ).B

         
      }

   }

   private 
   object schemeAlternativeImpl {

      def demarsh[
         Instance1 ,
         ChildScheme <: (FramePayloadScheme) { type Instance <: Instance1 } ,
      ](
         s: ([I] =>> (Set[? <: I] | Seq[I] ) )[ChildScheme ] ,
      )(using CodeSchemeOps.TraversalDiagnostique)(r: UnpickleInputStream): Instance1 = {
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
            util.control.NonLocalReturns.returning(resolve ?=> {
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
                           c readAndParse(r)
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
                           resolve.throwReturn(v)
                     }
                  })
               }
               // TODO
               // throw new java.io.IOException(s"none match. ${s }") with EBmlPrimitivesMalformationException
               throw summon[CodeSchemeOps.TraversalDiagnostique].newLexerException(msg = s"none match. ${s }")
            })
      }

   }

   extension (v: String) {
      def encodedAsUrl: java.net.URI = {
         new java.net.URI("data:text/plain," + v)
      }
   }
   
   extension (b: cbsq.ByteBlob) {
      
      def encodedAs(enc: EBmlCharset): cbsq.ByteBlob | java.net.URI = {
            enc match {
               
               case EBmlCharset.EBmlBigInt => 
                  // TODO
                  // BigInt(b.byteValues.toArray )
                  // .toString()
                  b
               
               case EBmlCharset.RawOctetString => 
                  b
               case EBmlCharset.Utf8 => 
                  new String(b.byteValues.toArray, java.nio.charset.StandardCharsets.UTF_8 ).encodedAsUrl
               case EBmlCharset.AsciiString => 
                  new String(b.byteValues.toArray, java.nio.charset.StandardCharsets.US_ASCII ).encodedAsUrl
                  
            }
      }

   }

   private 
   class PF extends Throwable

   @annotation.experimental
   protected 
   def ?? = ???
   
}



// trait EBmlSemanticsException extends Exception


















