package avcframewrk.forms

package templating

package ext.givmk


















/**
 * 
 * impl for
 * the conversion `Article# <- PhrasalAllocator#`
 * 
 */
object Articulability
{
   ;

   ;

   /**
    * 
    * summon
    * the appropriate `Articulability#`
    * 
    * impl for
    * the conversion `Article# <- PhrasalAllocator#`
    * 
    */
   def apply
      //
      (using artism : Article._Allocator )
      (using phr : PhrasalContent._Allocator )
      (using fromXDescToArtConv : Articulability.ByTwo[artism.CAP, phr.Repr ] )
      ( )
   : fromXDescToArtConv.type
   = fromXDescToArtConv

   def fromConverter
      [ArtT, SrcT ]
      (e: PccGeneralisedFactoryImpl[ArtT, SrcT ] )
   : Articulability.ByTwo[ArtT, SrcT ]
   = e

   ;

   type ByTwo[ArtT, -SrcT ]
   = _Impl & PccGeneralisedFactoryImpl[ArtT, SrcT ]

   type _BaseOps
   = _Impl

   private[givmk]
   opaque type _Impl
   <: PccGeneralisedFactoryImpl[?, ? ]
   =  PccGeneralisedFactoryImpl[?, ? ]

   ;

   ;
} // Articulability.




















val _ = {}