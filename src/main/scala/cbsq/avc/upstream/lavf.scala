package cbsq.avc.upstream

















type Lavf <: LavfCtxOps[?]

/**
 * 
 * .
 * 
 */
trait LavfCtxOps[-Ctx]
extends
AnyRef
with InMuxChSelectorialTyper
with LavfSuspentiveOps
with LavfInputOpenupOps[Ctx, Nothing ]
// with WithLvioFst[LavfFmtSpecificalTyper , Nothing ]
with LavfSeekingOpsStgtF[Ctx, Nothing, Nothing, Nothing]
with LavfRnfOps[Ctx, Nothing]
{

   thisLav : (
      AnyRef
      // & WithLvioFst[[F] =>> LavfFmtSpecificalTyper[F] , Nothing]
      // & LavfFmtSpecificalTyper[Nothing ]
      & LvfioInvar_!@[Ctx, Nothing ]

   ) =>

}

/**
 * 
 * properly-formulated *self-type* of `LavfInputOpenupOps`
 * 
 */
type LvfioInvar_!@[-Ctx, -Fmt] = (
   
      AnyRef
      & WithLvioFst[LavfFmtSpecificalTyper , Fmt ]
      & LavfInputOpenupOps[Ctx, Fmt]

)

// trait LavfCtxTyper {
// 
//    type Ctx
// 
// }

/**
 * 
 * defines the (nested) `type`
 * 
 */
@deprecated
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

protected
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

trait LavfSuspentiveOps
extends AnyRef
{

   def isRunning : Boolean
   def isRunning_=(v: Boolean) : Unit

}

type LavfIoException[+This <: AnyRef]
   >: java.io.IOException
   <: java.io.IOException

/**
 * 
 * .
 * 
 */
type LavfInputOpenupOps[-Ctx, -Fmt ]
   = LavfInputOpenupOps1[Ctx, ? >: Fmt ]

// protected
trait LavfInputOpenupOps1[-Ctx, -Fmt ]
extends
AnyRef
{

   thisLav : (
      AnyRef
      & WithLvioFst[LavfFmtSpecificalTyper, Fmt ]

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
       * it's better if the fmt is known AOT
       * 
       */
      @`throws`[LavfIoException[this.type ] ]
      def openInputOrOutput(
         //
         
         fmt : Fmt | Null = null ,

         src : (
            (String | java.net.URI)
            // | lavfConditionalTyping.IfConforms[fmt.type, Fmt, FmtCharacteristicFd, [_] =>> Null]

         ) ,

         otherOpts : (
            // lavfConditionalTyping.IfConforms[fmt.type, Fmt, FmtSpecificOptions, [_] =>> LavfEmptyMap ]
            LavfEmptyMap
            
         ) = { Map() } ,
         
      ) : Unit

      /**
       * 
       * in `avformat.h`: `avformat_close_input`
       * 
       */
      @`throws`[LavfIoException[this.type ] ]
      def closeAllInput() : Unit

   }

   lazy
   val _ : Unit = {

      extension (c: Ctx ) {

         def text1(): Unit = {

            c.openInputOrOutput(fmt = null, src = "pipe:" )

         }

      }
      
   }

}

trait WithLvioFst[+C[-F] <: LavfFmtSpecificalTyper[F], -ActualF ](val lvioFst : C[ActualF] )

object WithLvioFst {
   ;

   val _ = {

      def forTwoTypes[F1, F2 >: F1 ] = {

         type EcArg[A] = LavfFmtSpecificalTyper[A]

         type Ec[A] = WithLvioFst[LavfFmtSpecificalTyper, A ] 

         summon[EcArg[F2] <:< EcArg[F1] ]

         summon[Ec[F2] <:< Ec[F1] ]

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

type LavfSeekingOpsStgtF[-Ctx, -InMuxChSelector, Unused, -Flags] = (
   LavfSeekingOpsStgtF1[Ctx, InMuxChSelector, ? >: Flags]
)

protected 
trait LavfSeekingOpsStgtF1[-Ctx, -InMuxChSelector, Flags](defaultSeekingCallFlags : Flags )
{
   this : (
      AnyRef
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
      flags : Flags = defaultSeekingCallFlags ,

   ) : Unit
   
}



































