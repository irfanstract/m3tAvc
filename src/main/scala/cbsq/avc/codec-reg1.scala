package cbsq.avc












import MediaKind as EMediaKind







object  CodecOverview {
   
   lazy val IsUnspecified : Null | Product =
      case object IsUnspecified1
      IsUnspecified1

}
trait CodecOverview 
{ this1 =>

   val mimeType    : Null | String
   lazy
   val fourCcName  : Null | cbsq.riffmt.FourCC =
      null 

   val mediaKind : EMediaKind

   def isNotBusy: Boolean =
      true
   
}


















