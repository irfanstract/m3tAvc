package cbsq.avc.upstream

















type Lavf <: LavfCtxOps[?]

/**
 * 
 * .
 * 
 */
trait LavfCtxOps[Ctx]
extends
AnyRef
with InMuxChSelectorialTyper
with LavfFmtSpecificalTyper[Nothing ]
with LavfInputOpenupOps[Ctx, Nothing, [F] =>> LavfFmtSpecificalTyper[F] ]
with LavfRnfOps[Ctx, Nothing]
{

   def isRunning : Boolean
   def isRunning_=(v: Boolean) : Unit

}

// trait LavfCtxTyper {
// 
//    type Ctx
// 
// }

type LavfInMuxChSelectorialTyper
   >: InMuxChSelectorialTyper
   <: InMuxChSelectorialTyper

/**
 * 
 * defines these type-templates dealing with `lavf fmt-specifiques`
 * 
 */
type LavfFmtSpecificalTyper[-FGeneral] = 
   LavfFmtSpecificalTyperInvar[? >: FGeneral]

val _ = {

   def forTwoTypes[F1, F2 >: F1 ] = {
      summon[LavfFmtSpecificalTyper[F2] <:< LavfFmtSpecificalTyper[F1] ]
   }

}

trait LavfFmtSpecificalTyperInvar[FGeneral]
extends
AnyRef
{

   // summon["c" <:< "d"]

   /**
    * 
    * for true codecs
    * this would be eg type-alt like `java.io.InputStream | java.io.OutputStream` ;
    * for devices (eg capture-dvcs) which don't,
    * this might evalt to `Nothing`
    * 
    */
   type FmtCharacteristicFd[+FSpecific <: FGeneral]
   
   /**
    * 
    * fmt-specific options as Map
    * 
    * must be
    * a type which the expr `Map()` conforms to
    * 
    */
   type FmtSpecificOptions[+FSpecific <: FGeneral]
      >: LavfEmptyMap
      <: Map[?, Any]

}

protected
object Lvfst
{

}

/**
 * 
 * .
 * 
 */
type LavfInputOpenupOps[-Ctx, -Fmt, +Fst[-F] <: LavfFmtSpecificalTyper[F] ]
   = LavfInputOpenupOps1[Ctx, ? >: Fmt, Fst ]

trait LavfInputOpenupOps1[-Ctx, Fmt, +Fst[-F] <: LavfFmtSpecificalTyper[F] ](protected val lvioFst : Fst[Fmt])
extends
AnyRef
{

   thisLav : (
      AnyRef

   ) =>

   import lvioFst.*

   extension (ctx: Ctx) {

      /**
       * 
       * Open an input stream and read the header.
       * The codecs are not opened.
       * 
       * setting `fmt` to `null`
       * can be translated as a request for *probing* ;
       * however,
       * depending on the fmts
       * there may be limitations to *probing*,
       * 
       */
      @`throws`[LavfIoException[this.type ] ]
      def openInput[ActualFmt <: Fmt | Null](
         //
         
         fmt : Fmt | Null = null ,

         src : (
            (String | java.net.URI)
            | lavfConditionalTyping.IfConforms[fmt.type, Fmt, FmtCharacteristicFd, [_] =>> Null]

         ) ,

         otherOpts : (
            lavfConditionalTyping.IfConforms[fmt.type, Fmt, FmtSpecificOptions, [_] =>> LavfEmptyMap ]
            
         ) = { Map() } ,
         
      ) : Unit

      @`throws`[LavfIoException[this.type ] ]
      def closeAllInput() : Unit

   }

   lazy
   val _ : Unit = {

      extension (c: Ctx ) {

         def text1(): Unit = {

            // c.openInput(fmt = null, src = "pipe:" )

         }

      }
      
   }

}

type LavfT
   >: concurrent.duration.Duration
   <: concurrent.duration.Duration

/**
 * 
 * `readNextFrame`
 * 
 */
trait LavfRnfOps[-AvFormatCtx, -AvPacket]
{

   extension (ctx: AvFormatCtx) {

      /**
       * 
       * read the next frame from the stream (subject to usual decoding process).
       * exactly what's encoded in the file,
       * without regard to whether the decoded frame fmt/repr is supported by the codec.
       * 
       */
      @`throws`[LavfIoException[this.type ] ]
      def readNextFrame(p: AvPacket) : Unit

   }
   
}

object LavfSeekingOps
{

}

trait LavfSeekingOpsStgtF[Ctx, Flags](defaultFlags : Flags )
{
   this : (
      AnyRef
      & LavfInMuxChSelectorialTyper
   ) =>

   /**
    * 
    * 
    * 
    */
   def seekStreamToGivenT(
      //

      s: InMuxChSelector,
      t: LavfT ,
      flags : Flags = defaultFlags ,

   ) : Unit
   
}

type LavfIoException[+This <: AnyRef]
   >: java.io.IOException
   <: java.io.IOException

trait InMuxChSelectorialTyper {

   type InMuxChSelector

}

protected
final
lazy val lavfConditionalTyping : avcframewrk.util.lavf.conditionalTyping.type = {

   avcframewrk.util.lavf.conditionalTyping

}

type LavfEmptyMap
      >: Map[?, Nothing]
      <: Map[?, Nothing]

val _ = {
   summon[LavfEmptyMap <:< Map[?, Any ] ]
}



































