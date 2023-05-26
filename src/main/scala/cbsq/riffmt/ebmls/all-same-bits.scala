package cbsq.riffmt.ebmls


















/**
 * 
 * validates that it's not an all-same-bits example
 * 
 */
// inline 
def validateAwayAllSameBitsExample(bytes: IndexedSeq[Byte]): Unit = {
      require((
         (
            bytes
            .toBits
            .takeRight(bytes.length * 0x7)
            .toSet
            .toSeq
         ) match {
            case Seq(false | true ) => 
               false
            case _ => 
               true
         }
      ), s"reserved all-same-bits syntax, ${bytes }" )
}
























