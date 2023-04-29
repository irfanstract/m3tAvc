package cbsq.avc















enum MediaKind {

   /**
    * multiplexed streams
    */   
   case Mix

   case Audio
   case Captions 
   case Video
   
   @deprecated("experimental")
   case SideData 

}
object  MediaKind {
   
}















