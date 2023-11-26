package avcframewrk.w3mediastreams.internal















given mediaStreamCanWeStartRecord
: eisr.type
= eisr






import cps.{async, await}

import scalajs.js
import scalajs.js.annotation.*

import cps.monads.jsfuture.JSFuture

import typings.std.{global as dom }
import typings.{std as domItc }

import com.raquo.airstream







object eisr {
   ;

   ;

   ;

   extension (src: domItc.MediaStream) {
      //

      /** 
       * starts new `dom.MediaRecorder` session over `src`,
       * optionally auto-started (configure as `runExpectedAutoStart`, defaulting to "true").
       * 
       * the returned handle
       * additionally implements `Closeable`
       * 
       */
      def startRecording
         //
         (
            runExpectedAutoStart:
               (self: ByConstructedMediaStreamRcCtx.ER1Any ) => Unit
            = (self) => {
               self.start(1.38 * 1000 )
            }
            ,
         )
         (using preferredReducer : ByConstructedMediaStreamRcCtx.PreferredBlobEvtReducer )
      = {
         ;

         val peer
         =
            new dom.MediaRecorder(src, {
               domItc.MediaRecorderOptions()
               // .setMimeType("video/webm")
            } )

         ByConstructedMediaStreamRcCtx.ER1
            (peer = peer , srcInfoOpt = Some((src, () ) ) )
         .tapLooseSelf(c => {
            // TODO
            c
         })
         .tapLooseSelf(runExpectedAutoStart.andThen((_: Unit) => {} ) )
      }
   }

   // val srf = (_: dom.MediaStream).startRecording _

   export ByConstructedMediaStreamRcCtx.defaultPreferredBlobLikeEvtReducer

   object ByConstructedMediaStreamRcCtx {
      ;

      private[w3mediastreams]
      type ER1Any
      = ER1[?]

      private[w3mediastreams]
      class ER1
         //
         [
            +ER <: scala.Singleton & PreferredBlobEvtReducer
            ,
         ]
         (
            val peer: domItc.MediaRecorder
            ,
            private
            var srcInfoOpt: Option[(domItc.MediaStream, Unit)]
            ,
         )
         (using val preferredReducer: ER )
      extends
      AnyRef
      with java.io.Closeable
      {
         ;

         ;

         override
         def toString(): String
         = {
            import language.unsafeNulls
            val srcOption *: _
            = {
               srcInfoOpt
               .fold[(Option[domItc.MediaStream ] , Unit )] ((None, () ))({
                  case (src, _) =>
                     (Some(src), () )
               })
            }
            s"startedRecording(${
               s"src=${srcOption.fold("(???)")(_.toString() ) } ;"
            })"
         }

         override
         def close(): Unit
         = {
            srcInfoOpt = None
            stop()
         }

         peer.addEventListener_start(typings.std.stdStrings.start , (_, evt) => {
            dom.console log(s"recording started (from MediaStream)", evt )
         } )

         export peer.start

         export peer.pause

         export peer.stop

         type SpclOnWorkerTerminativeEvtInfo
         >: GeneralisedSpclOnWorkerTerminativeEvtInfo[Unit ]
         <: GeneralisedSpclOnWorkerTerminativeEvtInfo[Unit ]

         object SpclOnWorkerTerminativeEvtInfo {
            def apply(desc: SpclOnWorkerTerminativeEvtInfo )
            = desc
         }

         export peer.{
            addEventListener as addEventListenerOnPeer ,
            /** need these all, to work-around the limitation of the ScT's enc schm */
            addEventListener_start ,
            addEventListener_resume ,
            addEventListener_pause ,
            addEventListener_stop ,
            addEventListener_dataavailable ,
            addEventListener_error ,
         }

         def addOnTerminativeListener
            //
            (
               //
               handleTermtEvt
               : (evt: SpclOnWorkerTerminativeEvtInfo ) => Unit
               ,
            )
         : Unit
         = {
            ;
            peer.addEventListener_error(typings.std.stdStrings.error , (_, evt) => {
               handleTermtEvt(SpclOnWorkerTerminativeEvtInfo(util.Left(evt) , () ) )
            } )
            peer.addEventListener_stop(typings.std.stdStrings.stop , (_, evt) => {
               handleTermtEvt(SpclOnWorkerTerminativeEvtInfo(util.Right(()) , () ) )
            } )
         }

         def addOnDataAvailableListener
            //
            (
               //
               handleNewPartAvailEvt
               : domItc.BlobEvent => Unit
               ,
            )
         = {
            ;
            peer.addEventListener_dataavailable(typings.std.stdStrings.dataavailable , (_, evt) => {
               handleNewPartAvailEvt(evt)
            } )
         }

         // private
         def addOnDataAvailableOrTerminativeListener
            //
            (
               //
               handleNewPartAvailEvt
               : domItc.BlobEvent => Unit
               ,
               handleTermtEvt
               : (evt: SpclOnWorkerTerminativeEvtInfo ) => Unit
               ,
            )
         : Unit
         = {
            ;
            addOnDataAvailableListener(handleNewPartAvailEvt )
            addOnTerminativeListener(handleTermtEvt )
         }

         final
         val fullLengthBlobAnim *: termStateAnim *: _
         = {
            ;

            implicit
            val suggestedOw = airstream.ownership.ManualOwner()

            val termS
            : airstream.state.Var[? >: true <: Boolean ]
            = airstream.state.Var[Boolean](false )

            val payloadS
            // = airstream.state.Var[List[domItc.Blob] ](Nil )
            = preferredReducer.newRedux.apply()

            val o = {
               ;

               addOnDataAvailableOrTerminativeListener(
                  //
                  handleNewPartAvailEvt = evt => {
                     // payloadS
                     // .update(l => l.appended(evt.data) )
                     preferredReducer
                     .addIntoRedux(payloadS, evt )
                  } ,
                  handleTermtEvt = evt => {
                     termS
                     .update((_) => { evt.get ; true } )
                  } ,
               )
            }

            (preferredReducer.unboxFromRedux.apply(payloadS ) , termS.signal )
         }

         // case class Fbs

         ;
      }

      export epberDefs.{*, given }

      @deprecated
      given defaultPreferredBlobLikeEvtReducer
      : simplePreferredBlobLikeEvtReducer.type
      = simplePreferredBlobLikeEvtReducer

      type GeneralisedSpclOnWorkerTerminativeEvtInfo
         [+ReturnValue]
      >: (util.Either[domItc.Event, ReturnValue ] , Unit)
      <: (util.Either[domItc.Event, ReturnValue ] , Unit)

      extension [R] (c: GeneralisedSpclOnWorkerTerminativeEvtInfo[R] ) {
         //

         def code = c._1

         def codeAsTr
         = c.code.fold(e => util.Failure(new java.io.IOException(e.toString() ) ) , util.Success(_) )

         def value
         = c.codeAsTr.get

      }

   }

   ;

   ;

   object epberDefs {
      ;

      ;

      protected 
      val impl1 = new EpberDefsPre[domItc.BlobEvent] {}

      export impl1.ehPreferredBlobLikeEvtReducerOps

      type PreferredBlobEvtReducer
      = impl1.PreferredBlobLikeEvtReducer

      export impl1.simplePreferredBlobLikeEvtReducer

   }

   trait EpberDefsPre[XBlobEvt <: domItc.BlobEvent ]
   {
      ;

      ;

      ;
      implicit object ehPreferredBlobLikeEvtReducerOps {
         ;

         extension (receiver: PreferredBlobLikeEvtReducer )
            def newRedux = receiver._4
            def addIntoRedux = receiver._2
            def unboxFromRedux = receiver._3
      }

      type PreferredBlobLikeEvtReducer
      >: epberAllocator.CAP
      <: epberAllocator.CAP

      protected 
      final lazy val epberAllocator
      : ([C] =>> { type CAP >: C <: C })[(
         //
         (AnyRef, AnyRef, AnyRef, AnyRef ) {
            val _1 : { type Redux ; type ReduxOut }
            val _2 : (this._1.Redux, XBlobEvt ) => Unit
            val _3 : (this._1.Redux ) => this._1.ReduxOut
            val _4 : () => this._1.Redux
         }
      )]
      = ???

      object PreferredBlobLikeEvtReducer1 {
         ;

         def apply
            //
            [ReduxT, ReduxOutT]
            (
               //
               newRedux1: => ReduxT
               ,
               unboxRedux: ReduxT => ReduxOutT
               ,
               addIntoRedux1: (ReduxT, XBlobEvt ) => Unit
               ,
            )
         : PreferredBlobLikeEvtReducer
         = {
            ;

            val newRedux = () => newRedux1

            (new Selectable {
               type Redux
               >: ReduxT
               <: ReduxT
               type ReduxOut
               >: ReduxOutT
               <: ReduxOutT
            } )
            .pipeLooseSelf(allocator => {
               ((allocator , addIntoRedux1 , unboxRedux, newRedux ) : (allocator.type , addIntoRedux1.type , unboxRedux.type, newRedux.type ) )
               .pipeLooseSelf(pr => pr : PreferredBlobLikeEvtReducer )
            } )
         }

         ;
      }

      final
      lazy val simplePreferredBlobLikeEvtReducer
      = {
         PreferredBlobLikeEvtReducer1(
            airstream.state.Var[List[domItc.Blob ] ](Nil ),
            c => c.signal , (payloadS, evt: XBlobEvt ) => {
               ;

               payloadS
               .update(l => l.appended(evt.data ) )
            } )
      }

      ;
   }

   ;

   ;

   final
   lazy val SpecialCdeLl
   : avcframewrk.nio.avc.streams.internal.SPrLl.type
   = avcframewrk.nio.avc.streams.internal.SPrLl

   type SpecialCdeLl[+E]
   = avcframewrk.nio.avc.streams.internal.SPrLl[E]

   ;
}














