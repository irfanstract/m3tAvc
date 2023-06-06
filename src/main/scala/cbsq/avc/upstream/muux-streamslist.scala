package cbsq.avc.upstream



















abstract class InDemuxStreamMap
{
   thisStreamMap =>

   import InDemuxStreamMap.Matchable

   type StreamIdent
      <: Matchable

   /**
    * 
    * all streams each `(streamId, theMediaKind, theFrameItr)`
    * 
    */
   def getAllStreams() : collection.immutable.Iterable[(StreamIdent, InDemuxStreamMap.MediaKind, InMuxStream )]

   def fold(
      c : ([C] =>> (C => C) )[collection.immutable.Iterable[(StreamIdent, InDemuxStreamMap.MediaKind, InMuxStream )] ] , 
   ) : InDemuxStreamMap { type StreamIdent <: thisStreamMap.StreamIdent }

   def nonEmpty : Boolean = {
      getAllStreams()
      .nonEmpty
   }

   def getAllStreamsForMediaKind(m: InDemuxStreamMap.MediaKind ): IndexedSeq[InMuxStream] = {
      getAllStreams()
      .toIndexedSeq
      .collect({
         case (id, mediaKind @ `m`, s ) =>
            s
      })
   }

   /**
    * 
    * expects that there's exactly one stream of that media-kind,
    * failing with `NoSuchElementException` (if none) or `IllegalStateException` (if multiple)
    * 
    */
   @deprecated
   def getStream(m: InDemuxStreamMap.MediaKind ): InMuxStream = {
      getAllStreamsForMediaKind(m) match {

         case seq @ (Seq() | Seq(_) ) =>
            seq.head
         case seq @ (_ +: _ +: _) =>
            throw new IllegalStateException(s"multiple: ${seq } ")

      }
   }

}

object InDemuxStreamMap
{

   type Matchable
      >: Any
      <: Any

   export cbsq.avc.MediaKind

   protected
   case class Impl[
      StreamId <: Matchable ,
      
   ](
      allStreams : IndexedSeq[(StreamId, InDemuxStreamMap.MediaKind, InMuxStream )] ,

      streamIdOrd : Ordering[StreamId] ,

   )
   extends InDemuxStreamMap
   {

      given streamIdOrd1 : streamIdOrd.type = streamIdOrd

      type StreamIdent
         >: StreamId
         <: StreamId

      override
      def getAllStreams() = allStreams
      
      override
      def fold(
         c : ([C] =>> (C => C) )[collection.immutable.Iterable[(StreamIdent, InDemuxStreamMap.MediaKind, InMuxStream )] ] , 
      ) = {
         val enl = enlist(allStreams0 = c(allStreams) )
         summon[enl.StreamIdent =:= StreamIdent ]
         val cpy = copy[enl.StreamIdent ](allStreams = enl.allStreams )
         cpy
      }

   }

   def enlist[
      EStreamId <: Matchable : Ordering ,
   ](
      allStreams0 : collection.immutable.Iterable[(EStreamId, InDemuxStreamMap.MediaKind, InMuxStream )] ,

   ) : Enl { type StreamIdent >: EStreamId <: EStreamId } = {
      
      val allStreams = {
         allStreams0
         .toIndexedSeq
         .sortBy(_._1 )
      }

      Impl(allStreams = allStreams, streamIdOrd = summon[Ordering[EStreamId] ] )

   }

   opaque type Enl
      <: InDemuxStreamMap
      = InDemuxStreamMap & Impl[?]

}

































