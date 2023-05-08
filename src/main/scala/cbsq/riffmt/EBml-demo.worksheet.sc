





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

import cbsq.riffmt.EBmlPrimitivesIo.*

0xD3
(-0xD3) & 0xFF

toEbmlBytesSc(0x1)
toEbmlBytesSc(0x7)
toEbmlBytesSc(0x3)
toEbmlBytesSc(-3)
toEbmlBytesSc(0xD3)
toEbmlBytesSc(-0xD3)
(toEbmlBytesSc(0x3) : IndexedSeq[Byte]).toNewFd().readEbmlInteger(unsigned = false, invalidateAllSameBitExamples = false)
(toEbmlBytesSc(0x7) : IndexedSeq[Byte]).toNewFd().readEbmlInteger(unsigned = false, invalidateAllSameBitExamples = false)
(toEbmlBytesSc(-3) : IndexedSeq[Byte]).toNewFd().readEbmlInteger(unsigned = false, invalidateAllSameBitExamples = false)
(toEbmlBytesSc(0xD3) : IndexedSeq[Byte]).toNewFd().readEbmlInteger(unsigned = false, invalidateAllSameBitExamples = false)
(toEbmlBytesSc(-0xD3) : IndexedSeq[Byte]).toNewFd().readEbmlInteger(unsigned = false, invalidateAllSameBitExamples = false)
(toEbmlBytesSc(-3) : IndexedSeq[Byte]).toNewFd().readEbmlInteger(unsigned = true, invalidateAllSameBitExamples = false)








