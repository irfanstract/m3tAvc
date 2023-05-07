





import cbsq.riffmt.byteManipImplicits.*




(0x4000 : BigInt).bytes
(0x7000 : BigInt).bytes
(0x8000 : BigInt).bytes
(0xC000 : BigInt).bytes

{
   import  cbsq.riffmt.EBml.{readEbmlInteger }
   IndexedSeq[Int](0xFF, 0xFF, 0xFF).map(_.toByte)
   .toNewFd()
   .readEbmlInteger(unsigned = false, invalidateAllSameBitExamples = false )
}

import cbsq.riffmt.EBml

EBml.Schema.OfNumber.of[Long](defaultValue = 0)
.binarise(-20)
EBml.Schema.OfNumber.of[Long](defaultValue = 0)
.binarise(0x7)
EBml.Schema.OfNumber.of[Double](defaultValue = 0)
.binarise(0x1 : Double )








