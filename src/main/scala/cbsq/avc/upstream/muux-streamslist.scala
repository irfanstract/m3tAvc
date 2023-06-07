package cbsq.avc.upstream



















abstract class InDemuxStreamMap
{
   thisStreamMap =>

   import InDemuxStreamMap.Matchable

   type ChannelIdent
      <: Matchable

   type ChannelBody

   import ChannelBody as XInMuxStream

   def mapValues[
      Id ,
      ChannelBodyMapped ,

   ](f : ChannelBody => ChannelBodyMapped ) = {
      fold(c => {
         c.toIndexedSeq
         .map(e => (
            e.copy(_3 = f(e._3) )
         ) )
      })
   }

   def withAddedItem[
      Id ,
      EInMuxStream >: thisStreamMap.ChannelBody <: Any ,

   ](addend: (ChannelIdent, InDemuxStreamMap.Emk, EInMuxStream ) ) = {
      fold(c => {
         c.toIndexedSeq
         .appended(addend )
      })
   }

   // transparent inline
   def withAddedItem1[
      Id ,
      EInMuxStream >: thisStreamMap.ChannelBody ,
   ](
      streamId: ChannelIdent,
      // mediaKind: InDemuxStreamMap.Emk ,
      payload: EInMuxStream ,
      
   ) = {
      withAddedItem((streamId, () , payload) )
   }

   /**
    * 
    * all streams each `(streamId, theMediaKind, theFrameItr)`
    * 
    */
   def getAllStreams() : collection.immutable.Iterable[(ChannelIdent, InDemuxStreamMap.Emk, XInMuxStream )]

   def fold[
      Id ,
      EInMuxStream ,
   ](
      c : (
         collection.immutable.Iterable[(ChannelIdent, InDemuxStreamMap.Emk, ChannelBody )]
         =>
         collection.immutable.Iterable[(ChannelIdent, InDemuxStreamMap.Emk, EInMuxStream )]
      ) , 
   ) : (
      InDemuxStreamMap.OfIdentAndBody[thisStreamMap.ChannelIdent , EInMuxStream ]
   )

   def nonEmpty : Boolean = {
      getAllStreams()
      .nonEmpty
   }

   def getAllStreamsForMediaKind(m: InDemuxStreamMap.Emk ): IndexedSeq[XInMuxStream] = {
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
   def getStream(m: InDemuxStreamMap.Emk ): XInMuxStream = {
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

   type Emk
      >: Any
      <: Any
      
   type OfBody[
      +EInMuxStream ,
   ] = (
         InDemuxStreamMap {
            
            type ChannelBody
               <: EInMuxStream 
               
         }
   )

   type OfIdent[
      EStreamId ,
   ] = (
         InDemuxStreamMap {
            
            type ChannelIdent
               >: EStreamId
               <: EStreamId 
               
         }
   )

   type OfIdentAndBody[
      EStreamId ,
      +EInMuxStream ,
   ] = (
         OfIdent[EStreamId] & OfBody[EInMuxStream]
   )

   @deprecated
   def apply[
      EInMuxStream ,
   ](
      allStreams0 : collection.immutable.Iterable[EInMuxStream] ,

   ) = enlistSeq[EInMuxStream](allStreams0)

   def empty[
      EStreamId <: Matchable : Ordering ,
      EInMuxStream ,
   ] = {
      enlistSeq(Seq() )
   }

   def enlistSeq[
      EInMuxStream ,
   ](
      allStreams0 : collection.immutable.Iterable[EInMuxStream] ,

   ) = {

      enlist[Int, EInMuxStream]({
         allStreams0.toIndexedSeq
         .zipWithIndex.map(_.swap)
         .map({
            case (ident, s) =>
               (ident, (), s )
         })
      })

   }

   def enlist[
      EStreamId <: Matchable : Ordering ,
      EInMuxStream ,
   ](
      allStreams0 : collection.immutable.Iterable[(EStreamId, InDemuxStreamMap.Emk, EInMuxStream )] ,

   ) : (
      Enl & OfIdentAndBody[EStreamId, EInMuxStream]
   ) = {
      
      val allStreams = {
         allStreams0
         .toIndexedSeq
         .sortBy(_._1 )
      }

      Impl(allStreams = allStreams, streamIdOrd = summon[Ordering[EStreamId] ] )

   }

   opaque type Enl
      <: InDemuxStreamMap
      = InDemuxStreamMap & Impl[?, ?]

   /**
    *
    * 
    * 
    */
   protected
   case class Impl[
      StreamId <: Matchable ,
      XInMuxStream ,
      
   ](
      allStreams : IndexedSeq[(StreamId, InDemuxStreamMap.Emk, XInMuxStream )] ,

      streamIdOrd : Ordering[StreamId] ,

   )
   extends InDemuxStreamMap
   {

      given streamIdOrd1 : streamIdOrd.type = streamIdOrd

      override
      type ChannelIdent
         >: StreamId
         <: StreamId

      override
      type ChannelBody
         >: XInMuxStream
         <: XInMuxStream

      override
      def getAllStreams() = allStreams
      
      override
      def fold[
         Id ,
         EInMuxStream ,
      ](
         c : (
            collection.immutable.Iterable[(ChannelIdent, InDemuxStreamMap.Emk, ChannelBody )]
            =>
            collection.immutable.Iterable[(ChannelIdent, InDemuxStreamMap.Emk, EInMuxStream )]
         ) , 
      ) = {
         val enl = enlist(allStreams0 = c(allStreams) )
         // summon[enl.ChannelIdent <:< ChannelIdent ]  
         // enl.allStreams map(<:<.refl[(enl.ChannelIdent, Any, Any )] ) 
         // summon[c.type <:< (Seq[Nothing] => IterableOnce[(Any, Any, Any)] )]
         // summon[c.type <:< (Seq[Nothing] => IterableOnce[(Any, Any, EInMuxStream)] )]
         // summon[enl.ChannelBody <:< EInMuxStream ]
         // summon[enl.allStreams.type <:< IterableOnce[(Any, Any, Any)] ]
         // summon[enl.allStreams.type <:< IterableOnce[(Any, Any, EInMuxStream )] ]
         // enl.allStreams map(_._3 ) map(e => summon[e.type <:< EInMuxStream ] ) 
         val cpy = copy(allStreams = enl.allStreams1 )
         cpy
      }

      private[Impl] 
      def allStreams1: IndexedSeq[(ChannelIdent, Emk, ChannelBody)] = {
         allStreams
      }

   }

}

































