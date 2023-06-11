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

}

// trait LavfCtxTyper {
// 
//    type Ctx
// 
// }

trait InMuxChSelectorialTyper {

   type InMuxChSelector

}

type LavfInMuxChSelectorialTyper
   >: InMuxChSelectorialTyper
   <: InMuxChSelectorialTyper

trait LavfFmtSpecificalTyper[-FGeneral]
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
   type FmtCharacteristicFd[FSpecific <: efgTyper.EFg]
   
   /**
    * 
    * fmt-specific options as Map
    * 
    * must be
    * a type which the expr `Map()` conforms to
    * 
    */
   type FmtSpecificOptions[FSpecific <: efgTyper.EFg]
      >: Lvfst.FsoLower
      <: Lvfst.FsoUpper

   private[LavfFmtSpecificalTyper]
   val efgTyper = {
      new LvfstEfgTyper[FGeneral]
   }
   
}

class LvfstEfgTyper[-FGeneral] {
   
      type EFg >: FGeneral
      
}

protected
object Lvfst
{

   type FsoLower
      >: LavfEmptyMap
      <: LavfEmptyMap

   type FsoUpper
      >: Map[?, Any]
      <: Map[?, Any]

}

/**
 * 
 * .
 * 
 */
trait LavfInputOpenupOps[-Ctx, -Fmt, +Fst[-F] <: LavfFmtSpecificalTyper[F] ](protected val lvioFst : Fst[Fmt])
extends
AnyRef
{

   this : (
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
      @`throws`[java.io.IOException ]
      def openInput[ActualFmt <: Fmt](
         //
         
         fmt : ActualFmt | Null = null ,

         src : (
            (String | java.net.URI)
            | lavfConditionalTyping.IfConforms[fmt.type, ActualFmt, FmtCharacteristicFd, [_] =>> Null]

         ) ,

         otherOpts : (
            lavfConditionalTyping.IfConforms[fmt.type, Fmt, FmtSpecificOptions, [_] =>> LavfEmptyMap ]
            
         ) = { Map() } ,
         
      ) : Unit

   }

}

final
lazy val lavfConditionalTyping : avcframewrk.util.lavf.conditionalTyping.type = {

   avcframewrk.util.lavf.conditionalTyping

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

type LavfEmptyMap
      >: Map[?, Nothing]
      <: Map[?, Nothing]

val _ = {
   summon[LavfEmptyMap <:< Map[?, Any ] ]
}



































