package avcframewrk.wauspawn











import scalajs.js

/* sadly, `package`s can't be aliased as concrete `object`s ... */
import typings.{std as dom }

object PreConnectedAOps
extends
AnyRef
with aNdWriterFwImpl
with PreConnectedACoreOps
{
   ;

   ;

   ;
}

/** 
 * needs to ensure that the relevant static-typing(s) will work as intended
 * 
 */
lazy val _ = {
   ;

   import PreConnectedAOps.startInitiallyOrphanedNode

   extension
      //
      (using ctx: PreConnectedAOps._CorrespoCtxBase )
      //
      (receiver : (
         PreConnectedAOps._InCtx[ctx.type]
         & PreConnectedAOps._CorrespondingToANodeParam[dom.AudioParam ]
      ) )
   {
      //

      def main
         //
         ()
      : Unit
      = {
         ;

         receiver
         .openC[dom.global.GainNode ]
         .param(_.gain )

         receiver
         .openC[dom.global.GainNode ]
         .param(_.gain )
         .cancelScheduledValues(receiver.ctx.currentTime )

         receiver
         .openC[dom.global.AnalyserNode ]

         receiver
         .openC[dom.global.GainNode ]
         .param(_.gain )
         .sv((self, ctx) => self.setValueAtTime(self.defaultValue, ctx.currentTime ) )

         ;

         ({
            val nd
            = startInitiallyOrphanedNode(ctx = ctx )
            nd._1
            .openC[dom.global.GainNode ]
            .param(_.gain )
            nd._2
            .connect(receiver.asFirstClassANode() )
         })

         ;

      }

      //
   }
}











val _ = {}
