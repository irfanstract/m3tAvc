package avcframewrk.wauspawn




















import scalajs.js

/* sadly, `package`s can't be aliased as concrete `object`s ... */
import typings.{std as dom }

trait aNdWriterFwImpl
{ PreConnectedAOps : PreConnectedAOps.type =>
   ;

   ;

   ;

   ;

   private[wauspawn]
   object impls {
      //

      ;

      /* a match-type */
      @deprecated
      type
         _AsMT
         [+T <: _CorrespoBase ]
      = (
         (
            //

            (impls.ForANode._ForT[dom.AudioNode ] | impls.ForANodeParam._ForT[dom.AudioParam ] )
            & impls.ForAny._Impl[T]
         )
         &
         ({
            type Main
               [T0 <: Seq[_CorrespoBase | dom.EventTarget ] ]
            <: impls.ForAny._Impl[_CorrespoBase]
            = T0 match {
               //

               case Seq[actualT & dom.AudioNode   ] => impls.ForAny._Impl[_CorrespoBase] & (impls.ForANode._ForT[actualT]          )
               case Seq[actualT & dom.AudioParam  ] => impls.ForAny._Impl[_CorrespoBase] & (impls.ForANodeParam._ForT[actualT]     )
               case Seq[actualT & dom.EventTarget ] => impls.ForAny._Impl[_CorrespoBase] & (impls.ForDomEventTarget._Impl[actualT] )

               case Seq[actualT ] => impls.ForAny._Impl[_CorrespoBase] & impls.ForAny._Impl[actualT]
            }
         })
         #Main[Seq[? <: T] @annotation.unchecked.uncheckedVariance ]
      )

      object ForAny {
         ;

         trait _Impl
            [+A <: Any ]
         {
            //
            val main : A

         }
      }

      object ForDomEventTarget {
         ;

         trait _Impl
            [+A <: dom.EventTarget ]
         extends
         AnyRef
         with ForAny._Impl[A]
         {
            //
            val main : A

            def mainNodeAsEvtTarget
            : dom.EventTarget
            = main
         }
      }

      object ForANode {
         ;

         class _ForT
            [+A <: dom.AudioNode : js.ConstructorTag ]
            (using val ctx : dom.BaseAudioContext )
            ( )
         extends
         AnyRef
         with ForAny._Impl[A]
         with ForDomEventTarget._Impl[A]
         with java.io.Closeable
         {
            ;
            val main
            = js.constructorTag[A].newInstance(ctx )

            private[wauspawn]
            val endEndpointImpl
            = new dom.global.GainNode(ctx )

            main
            .connect(endEndpointImpl)

            override
            def close(): Unit
            = {
               ;
               endEndpointImpl.gain
               .setTargetAtTime(0, ctx.currentTime, 0.5 )
               js.timers.setTimeout(11 * 1000 ) {
                  main.disconnect()
               }
            }

            def endEndpoint
            : dom.AudioNode
            = endEndpointImpl

            //
         }
      }

      object ForANodeParam {
         ;

         case class _ForT
            [+T <: dom.AudioParam ]
            (val main: T )
         extends
         AnyRef
         with ForAny._Impl[T ]
      }

      //
   }

   ;
}





















val _ = {}