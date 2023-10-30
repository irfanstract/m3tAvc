package avcframewrk.wauspawn




















import scalajs.js

/* sadly, `package`s can't be aliased as concrete `object`s ... */
import typings.{std as dom }

trait PreConnectedACoreOps
{ 
   PreConnectedAOps : (
      AnyRef
      & aNdWriterFwImpl
      & PreConnectedAOps.type
   ) =>
   ;

   // summon[this.type <:< aNdWriterFwImpl ]

   ;

   ;

   ;

   type _Any
   = _Impl[_CorrespoBase ]

   /**
    * the base `AudioNode`-ish, which is `AudioNode` .
    * 
    */
   type _CorrespoBase
   /* in `dom` `AudioParam` `extends` `AudioNode`, even though in the W3C spec it doesn't. doh */
   >: dom.AudioNode | dom.AudioParam
   <: dom.AudioNode | dom.AudioParam

   /**
    * the base `AudioContext`-ish, which is `BaseAudioContext` . 
    * and not `AudioContext` ; that's what the W3C spec says.
    * 
    */
   type _CorrespoCtxBase
   >: dom.BaseAudioContext
   <: dom.BaseAudioContext

   /**
    * an instance corresponding to the given `_CorrespoBase` which's not necessarily the first-class `AudioNode` .
    * (use `_CorrespondingToANodeUnit` instead )
    * 
    */
   @deprecated
   type _CorrespondingToANode
      [+T <: _CorrespoBase ]
   = (
      _Impl[T]
      &
      ({
         type Main[T <: _CorrespoBase ]
         = T match {
            //
            case (actualT & dom.AudioNode  ) => _CorrespondingToANodeUnit [actualT]
            case (actualT & dom.AudioParam ) => _CorrespondingToANodeParam[actualT]
         }
      })
      #Main[T @annotation.unchecked.uncheckedVariance]
   )

   type _CorrespondingToANodeUnit
      [+T <: dom.AudioNode ]
   = _Impl[T] & impls.ForANode._ForT[T]

   type _CorrespondingToANodeParam
      [+T <: dom.AudioParam ]
   = _Impl[T] & impls.ForANodeParam._ForT[T]

   opaque type _InCtx
      [+T <: _CorrespoCtxBase ]
   <: _Any
   = _Impl[_CorrespoBase ]

   type _InCtxInvar
      [T <: _CorrespoCtxBase ]
   >: _InCtx[T]
   <: _InCtx[T]

   private[wauspawn]
   opaque type
      _Impl
      [+T <: _CorrespoBase ]
   <: (AnyRef | js.Any )
   // = T @annotation.unchecked.uncheckedVariance
   = impls.ForAny._Impl[T]

   ;

   /** 
    * an entry instance for the given `_CorrespoCtxBase`,
    * which would be for/over its `.destination`
    * 
    */
   def inCtx
      (ctx: _CorrespoCtxBase )
   : (
      PreConnectedAOps._InCtx[ctx.type]
      & PreConnectedAOps._CorrespondingToANode[dom.AudioNode ]
   )
   // = ctx.destination
   = {
      given ctx.type
      = ctx
      impls.ForANode._ForT[dom.global.GainNode ]( )
   }

   ;

   ;

   // extension [T <: dom.AudioNode] (i: T )
   //    def packed
   //    = i.pipeLooseSelf(i => impls.ForANode._ForT(main = i ) )

   extension [T <: dom.AudioParam] (i: T )
      def packed
      = i.pipeLooseSelf(i => impls.ForANodeParam._ForT(main = i ) )

   extension [Impl <: _CorrespoBase] (receiver: _CorrespondingToANode[Impl ] )
   {
      //

      /** 
       * run the specified fnc
       * 
       */
      def runOp
         [R] (f: (receiver: Impl) => R )
      : R
      = f(receiver = receiver.main )

   }

   extension [
      Ctx <: _CorrespoCtxBase & Singleton,
      ReceiverT <: _InCtx[Ctx] ,
   ]
         // (using ctxRef: ValueOf[Ctx] )
         (receiver: ReceiverT )
         (using ctxRef: ValueOf[Ctx] )
   {
      //

      /** 
       * the parenting `Ctx`
       * 
       */
      def ctx
      // : ctxRef.value.type
      : Ctx
      = ctxRef.value

   }

   extension (receiver: _Any & impls.ForDomEventTarget._Impl[?] ) {
      export iEventTargetOps.{addEventListener, removeEventListener}
      def    iEventTargetOps
      = receiver.mainNodeAsEvtTarget
   }

   def startInitiallyOrphanedNode
      (ctx: _CorrespoCtxBase )
   : (
      //

      (
         //

         PreConnectedAOps._InCtx[ctx.type]

         & PreConnectedAOps._CorrespondingToANode[(
            dom.AudioNode
         )]
      )

      ,

      SpecialReconnectOps
   )
   = {
      ;

      PreConnectedAOps.inCtx(ctx )

      .runOp(this1 => {
         ;

         implicit val ctx
         = this1.context

         impls.ForANode._ForT[dom.global.GainNode ] ()
         .pipeLooseSelf(e => (e -> (
            SpecialReconnectOps(receiver = e.endEndpoint )
         ) ) )
      })
   }

   //
   case class SpecialReconnectOps
      (val receiver: dom.AudioNode )
   {
      ;

      def connect
         (dest: PreConnectedAOps._CorrespondingToANode[dom.AudioNode] )
      = receiver.connect(dest.iAudioNodeOps )

      export receiver.{numberOfOutputs }
   }

   given intuitiveAudioNodeCloseabilty
      [Nd <: dom.AudioNode ]
      (using util.NotGiven[Nd <:< dom.AudioParam ])
   : Conversion[_CorrespondingToANodeUnit[Nd ] , java.io.Closeable]
   = {
      (identity[impls.ForANode._ForT[Nd] ] _ )
      .apply _
   }

   /** 
    * the methods of `dom.AudioNode`,
    * demoted to avoid "ambiguous reference"s
    * 
    */
   implicit
   object lowerPriorityAudioNodeOps
   {
      ;

      extension (receiver: _CorrespondingToANodeUnit[dom.AudioNode ] ) {
         //

         export iAudioNodeOps.*
         def    iAudioNodeOps: (dom.AudioNode )
         = receiver.main
      }

   }

   extension [
      //
      Ctx <: _CorrespoCtxBase & Singleton ,
      Nd <: dom.AudioNode ,
   ] (receiver: _InCtx[Ctx] & _CorrespondingToANodeUnit[Nd ] )
         // (using ctxRef: ValueOf[Ctx] )
   {
      //

      /** 
       * runs the specified fnc supposed to dereference an `AudioParam` referenced by the receiver.
       * 
       * ```
       * (... : dom.GainNode )
       * .param(_.gain ) // <--
       * .cancelAndHold()
       * ```
       * 
       */
      def param
         [R <: dom.AudioParam ]
         (f: (receiver: Nd) => R )
      : (
         //
         _InCtx[(
            Ctx
         )]
         & _CorrespondingToANodeParam[R ]
      )
      = {
         f(receiver = receiver.main )
         .packed
      }

   }

   extension [
      Ctx <: _CorrespoCtxBase & Singleton,
      ReceiverT <: _InCtx[Ctx] ,
   ]
         // (using ctxRef: ValueOf[Ctx] )
         (receiver: ReceiverT )
         (using ctxRef: ValueOf[Ctx] )
   {
      //

      /** 
       * starts an AudioNode of the expected type
       * 
       */
      def openC
         [C <: dom.AudioNode ]
         (using util.NotGiven[C <:< Nothing] )
         (using cls: js.ConstructorTag[C] )
      : (
         PreConnectedAOps._InCtx[(
            // Ctx
            // ctxRef.value.type
            Ctx
         ) ]
         & PreConnectedAOps._CorrespondingToANodeUnit[C]
         // & PreConnectedAOps._CorrespondingToANodeUnit[(dom.AudioNode { val context: ctxRef.value.type } )]
      )
      = {
         ;

         // TODO
         ({
            implicit val ctx
            = ctxRef.value

            impls.ForANode._ForT[C] ()
         })
      }
   }

   /** 
    * the methods of `dom.AudioParam`,
    * demoted to avoid "ambiguous reference"s
    * 
    */
   implicit
   object lowerPriorityAudioParamOps
   {
      ;

      extension (receiver: _CorrespondingToANodeParam[dom.AudioParam ] ) {
         //

         /** 
          * the corresponding binding in `org.scalajs.dom` lacks some methods; however,
          * since `dom` currently points to `typings.std`, there should be nothing missing
          * 
          */
         def    iAudioParamOps: (dom.AudioParam )
         = receiver.main

         export iAudioParamOps.{
            //
            *, given
         }

         //
      }

   }

   extension [
      //
      Ctx <: _CorrespoCtxBase & Singleton ,
      Nd <: dom.AudioParam ,
   ] (receiver: _InCtx[Ctx] & _CorrespondingToANodeParam[Nd ] )
         (using ctxRef: ValueOf[Ctx] )
   {
      //

      /** 
       * run the specified fnc, supposedly an in-place op to the wrapped `AudioParam`
       * 
       * ```
       * lp
       * .param(_.gain )
       * .sv((i, ctx ) => i.setTargetAtTime(someValue, ctx.currentTime ) )
       * ```
       * 
       */
      def sv
         //
         [R ]
         (op: (
            (self: receiver.main.type, ctx: (
               // ctxRef.value.type
               Ctx
            ) ) =>
               R
         ) )
      = {
         ;
         op(self = receiver.main, ctx = (
            ctxRef.value
         ) )
      }

      transparent inline
      def asFirstClassANode
         ()
      = receiver.openC[dom.global.GainNode ]

      // TODO
      def cancelAndHold
         //
         ()
      : Unit
      = {
         ;
         receiver.main
         .cancelScheduledValues(receiver.ctx.currentTime )
      }
   }

   ;
}





















val _ = {}