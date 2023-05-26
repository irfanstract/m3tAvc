


import cbsq.riffmt.byteManipImplicits.*


val re0 = (-1 : BigInt) << (0x2 * 0x7 )

re0.bytes

re0.bytes.toBits

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

(() => {})






