package cbsq.riffmt















object EBml
{

   import byteManipImplicits.*

   export EBmlPrimitivesIo.*

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
   abstract class Schema
   {

      type Instance

      type RnpSource
        >: java.io.DataInputStream
        <: java.io.DataInput

      type RnpDest
        >: java.io.DataOutputStream
        <: java.io.DataOutput

      def readAndParse(r: RnpSource): Instance

      def writeBnr(d: Instance, dest: RnpDest): WbnrR

      type WbnrR >: Unit <: Unit

   }
   object Schema
   {

      extension(this1: Schema) {

         def binarise(d: this1.Instance) = {
            val o = new java.io.ByteArrayOutputStream()
            this1.writeBnr(d, dest = new java.io.DataOutputStream(o) )
            o.toByteArray().toIndexedSeq
         }
         
      }

      type S[+T] = Singleton & T
 
      case object cHasVariableLength

      val globalBaseDate = (
         {
            import  concurrent.duration.*
            // TODO
            Deadline((
               ((2001 - 1970 ) * 365.25 ).toInt.days
            ))
         }
      ) : concurrent.duration.Deadline

      // export iMPoll.*
      // val iMPoll: IMPoll = {}
      // sealed trait IMPoll {
      //
      //    type MPoll[+C] 
      //       <: (src: java.io.DataInput) => C
      //    
      //    given mp
      //
      // }
      import byteManipImplicits.{OctetReadingOp as MPoll }

      sealed trait OfFixedLengthStrv extends 
      Schema 
      {

         val length: cHasVariableLength.type | cbsq.FileSize

      }

      @annotation.experimental
      sealed 
      case class OfDate  [C <: Unit | Long ]( c: reflect.ClassTag[C ] , defaultValue: Null | concurrent.duration.Deadline ) extends 
      OfFixedLengthStrv 
      { 

         type Instance 
            >: concurrent.duration.Deadline
            <: concurrent.duration.Deadline

         val length = getLengthOfDataType(c) 

         def readAndParse(r: RnpSource) = {
            import  concurrent.duration.*
            val parsedValue = (
               // TODO
               ???
            ) : BigInt
            globalBaseDate `+` (
               // TODO
               (parsedValue ).toLong.nanoseconds
            )
         }
         
         def writeBnr(d: Instance, dest: RnpDest): WbnrR = ??

      }
      sealed
      abstract
      class OfNumber[
         
         /* specialisability is quite limited, including due-to opaque-type usages */
         C : reflect.ClassTag : OctetReadingOp : OctetWritedownOp ,

      ]( 
         // val defaultValue: Null | C ,
         // mPoll: MPoll[C] ,
      ) extends 
      OfFixedLengthStrv
      { 

         type Instance 
            >: C
            <: C

         // inline
         val length = getLengthOfDataType(summon[reflect.ClassTag[C] ] )

         val defaultValue: Null | C
         
         def readAndParse(src: RnpSource): Instance = {
            (summon[OctetReadingOp[C] ] )(src)
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
         {}

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
            .println("EBml$$Schema$$OfNumber$$ - done")
         }

      }

      @annotation.experimental
      sealed 
      case class OfStr[
         +Len             <: S[cHasVariableLength.type | cbsq.FileSize], 
         +ActualCharset   <: S[EBmlCharset ] ,
         +DEcv            <: S[Null | String   ] ,
      ](  
         length   : Len , 
         enc      : ActualCharset ,
         defaultEncodedValue : DEcv ,
      ) 
      extends OfFixedLengthStrv
      {
         
         type Instance 
            >: cbsq.ByteBlob | java.net.URI
            <: cbsq.ByteBlob | java.net.URI

         def readAndParse(r: RnpSource) = ??

         def writeBnr(d: Instance, dest: RnpDest): WbnrR = ??
         
      }
      
      @annotation.experimental
      protected 
      sealed 
      case class OfChildListImpl[
         +Len               <: S[cHasVariableLength.type | cbsq.FileSize], 
         +ChildrenLsPattern <: Set[?] ,
      ](  
         length: Len , 
         childrenSet1: ChildrenLsPattern ,
      ) 
      extends OfFixedLengthStrv
      {

         def readAndParse(r: RnpSource) = ??

         def writeBnr(d: Instance, dest: RnpDest): WbnrR = ??
         
      }

      @annotation.experimental
      def ofAnyChildren(c: Set[? <: Schema]): Schema & OfFixedLengthStrv = {
         OfChildListImpl(length = cHasVariableLength, childrenSet1 = c )
      }
      
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
   class PF extends Throwable

   @annotation.experimental
   protected 
   def ?? = ???
   
}

@main
def ebmlImplTest(): Unit =
   ebmlIoImplTest()
   EBml.toString()
   ebmlSchemalImplTest()

@main
def ebmlSchemalImplTest(): Unit =
   EBml.Schema.OfNumber.toString()
   {
      import byteManipImplicits.*
      {
         val s1 = EBml.Schema.OfNumber.of[Long](defaultValue = -1 )
         println((
            s1.readAndParse((
               IndexedSeq[Int](-1, -1, -1, -1, -1, -1, -1, -1).map(_.toByte)
               .toNewFd()
            ))
         ))
         println((
            s1.readAndParse((
               IndexedSeq[Int](-1, -1, -1, -1, -1, -2, -1, -1).map(_.toByte)
               .toNewFd()
            ))
         ))
         println((
            s1.readAndParse((
               IndexedSeq[Int](-1, -1, -1, -2, -1, -1, -1, -1).map(_.toByte)
               .toNewFd()
            ))
         ))
      }
      println((
         EBml.Schema.OfNumber.of[Double](defaultValue = 0)
         .readAndParse((
            IndexedSeq[Int](-1, -1, -1, -2, -1, -2, -1, -1).map(_.toByte)
            .toNewFd()
         ))
      ))
      println((
         EBml.Schema.OfNumber.of[Double](defaultValue = 0)
         .readAndParse((
            IndexedSeq[Int](-1, -25, -1, -2, -1, -2, -1, -1).map(_.toByte)
            .toNewFd()
         ))
      ))
      try {
         util.Try({ throw new InterruptedException })
         throw new AssertionError
      } catch {
         case z : InterruptedException =>
            println(z)
      }
      println((
         util.Try((
            EBml.Schema.OfNumber.of[Double](defaultValue = 0)
            .readAndParse((
               IndexedSeq[Int](-1, -25, -1, -2, -1 ).map(_.toByte)
               .toNewFd()
            ))
         ))
         .failed
         .map({ case e : java.io.EOFException => e })
      ))
   }

























