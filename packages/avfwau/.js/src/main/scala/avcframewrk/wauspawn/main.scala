package avcframewrk.wauspawn










import scalajs.js

object commonImplicits {
   ;

   ;

   // extension (dest: org.scalajs.dom.AudioNode )
      // def startGainNode() :

   ;
}

object PreConnectedAOps
{
   ;

   ;

   type _Any
   = _Impl[_CorrespoBase ]

   type _CorrespoBase
   /* in `org.scalajs.dom` `AudioParam` `extends` `AudioNode`, even though in the W3C spec it doesn't. doh */
   >: org.scalajs.dom.AudioNode | org.scalajs.dom.AudioParam
   <: org.scalajs.dom.AudioNode | org.scalajs.dom.AudioParam

   private[wauspawn]
   type _CorrespondingToANode
      [+T <: _CorrespoBase ]
   = _Impl[T]

   opaque type _InCtx
      [+T <: org.scalajs.dom.AudioContext ]
   <: _Any
   = _Impl[_CorrespoBase ]

   type _InCtxInvar
      [T <: org.scalajs.dom.AudioContext ]
   >: _InCtx[T]
   <: _InCtx[T]

   private[wauspawn]
   opaque type _Impl
      [+T <: _CorrespoBase ]
   <: org.scalajs.dom.EventTarget
   = T @annotation.unchecked.uncheckedVariance

   def inCtx
      (ctx: org.scalajs.dom.AudioContext )
   : (
      PreConnectedAOps._InCtx[ctx.type]
      & PreConnectedAOps._CorrespondingToANode[ctx.destination.type ]
   )
   = ctx.destination

   extension [Impl <: _CorrespoBase] (receiver: _CorrespondingToANode[Impl ] ) {
      //

      def runOp
         [R] (f: (receiver: Impl) => R )
      : R
      = f(receiver = receiver )

      def run
         [R] (r: (_CorrespondingToANode[Impl ] <:< Impl ) ?=> R )
      : R
      = r(using <:<.refl[Impl] )

   }

   extension (receiver: _CorrespondingToANode[org.scalajs.dom.AudioNode ] ) {
      export iAudioNodeOps.context
      export iAudioNodeOps.{numberOfInputs, numberOfOutputs}
      export iAudioNodeOps.{channelCount, channelCountMode, channelInterpretation}
      def    iAudioNodeOps: (org.scalajs.dom.AudioNode )
      = receiver
   }

   extension [
      //
      Ctx <: org.scalajs.dom.AudioContext ,
      Nd <: _CorrespoBase ,
   ] (receiver: _InCtx[Ctx] & _CorrespondingToANode[Nd ] )
         (using ctxRef: ValueOf[Ctx] )
   {
      def param
         [R <: org.scalajs.dom.AudioParam ]
         (f: (receiver: Nd) => R )
      : (
         //
         _InCtx[Ctx] & _CorrespondingToANode[R ]
      )
      = f(receiver = receiver )
   }

   extension (receiver: _CorrespondingToANode[org.scalajs.dom.AudioParam ] ) {
      //

      def    iAudioParamOps: (org.scalajs.dom.AudioParam )
      = receiver
      def    iAudioParamExtraOps: (typings.std.AudioParam )
      = receiver.asInstanceOf[typings.std.AudioParam ]

      export iAudioParamExtraOps.{defaultValue, minValue, maxValue }

      export iAudioParamOps.{cancelScheduledValues}

      export iAudioParamExtraOps.{cancelAndHoldAtTime}
      export iAudioParamExtraOps.{linearRampToValueAtTime, exponentialRampToValueAtTime }

      export iAudioParamExtraOps.{setValueAtTime, setValueCurveAtTime }
      export iAudioParamExtraOps.{setTargetAtTime }

      //
   }

   extension [
      Ctx <: org.scalajs.dom.AudioContext & Singleton,
      ReceiverT <: _InCtx[Ctx] ,
   ]
         // (using ctxRef: ValueOf[Ctx] )
         (receiver: ReceiverT )
         (using ctxRef: ValueOf[Ctx] )
   {
      /** 
       * starts an AudioNode of the expected type
       * 
       */
      def openC
         [C <: org.scalajs.dom.AudioNode ]
         (using cls: js.ConstructorTag[C] )
      : (
         PreConnectedAOps._InCtx[(
            // Ctx
            ctxRef.value.type
         ) ]
         & PreConnectedAOps._CorrespondingToANode[C]
         & PreConnectedAOps._CorrespondingToANode[(org.scalajs.dom.AudioNode { val context: ctxRef.value.type } )]
      )
      = {
         ;

         val ctx
         : ctxRef.value.type
         = ctxRef.value

         // TODO
         ({
            val nd
            = {
               cls.newInstance(ctx )
            }
            nd.connect(receiver)
            nd
            match { case nd: _CorrespondingToANode[org.scalajs.dom.AudioNode { val context: ctxRef.value.type }] => nd }
         })
      }
   }

   given intuitiveCloseabilty
      [Nd <: org.scalajs.dom.AudioNode ]
      (using util.NotGiven[Nd <:< org.scalajs.dom.AudioParam ])
   : Conversion[_CorrespondingToANode[Nd ] , java.io.Closeable]
   = {
      ((receiver: org.scalajs.dom.AudioNode ) => {
         locally[java.io.Closeable](() => receiver.disconnect() )
      } ).apply _
   }

   ;
}

lazy val _ = {
   (ctx: org.scalajs.dom.AudioContext ) ?=>
      (receuver : (
         PreConnectedAOps._InCtx[ctx.type]
         & PreConnectedAOps._CorrespondingToANode[org.scalajs.dom.AudioParam ]
      ) ) => {
         ;
         // receuver
         // import avcframewrk.wauspawn.PreConnectedAOps.openC
         receuver
         .openC[org.scalajs.dom.GainNode ]
      }
}

object missingAudioParamMethods {
   ;

   ;

   extension (receiver: org.scalajs.dom.AudioParam ) {
      private
      def impl1
      = receiver.asInstanceOf[typings.std.AudioParam ]
      export impl1.*
   }

   ;
}











val _ = {}
