import cbsq.avc.codecs.matrCd






matrCd

val doc = matrCd.doc

matrCd.entries
.map(e => (
   // s"[${e.mName } : ${e.usageNoteTxt } ]"
   e.toString()
   // e.toString().take("[Element 'Segment'/0x18538067 (master) ; Root Element that contains".length() )
) )
.mkString("\n")



