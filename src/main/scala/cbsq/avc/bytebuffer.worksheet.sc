



import cbsq.avc.{KBuffer, KByteBuffer}



val bp1 = KByteBuffer.allocate(len = 0x32 )

val bp101 = (bp1 + 0x4 + 0x4)

val bp102 = (bp1 + 0x8)

bp101 == bp102 



