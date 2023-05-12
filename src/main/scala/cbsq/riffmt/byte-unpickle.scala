package cbsq.riffmt
















object CStdPrimitiveTypeMarshalling {
   


   opaque type OctetReadingOp[+C] 
      <: (src: java.io.DataInput) => C
      = (src: java.io.DataInput) => C

   given OctetReadingOp[Unit   ] = { case _ => () /* nothing to read */ }

   given OctetReadingOp[Byte   ] = _.readByte()
   given OctetReadingOp[Char   ] = _.readChar()
   given OctetReadingOp[Short  ] = _.readShort()
   given OctetReadingOp[Int    ] = _.readInt()
   given OctetReadingOp[Long   ] = _.readLong()
   given OctetReadingOp[Float  ] = _.readFloat()
   given OctetReadingOp[Double ] = _.readDouble()
   


   opaque type OctetWritedownOp[C] 
      <: (src: java.io.DataOutput, v: C) => Unit
      = (src: java.io.DataOutput, v: C) => Unit

   given OctetWritedownOp[Unit   ] = { case _ => /* nothing to write */ }

   given OctetWritedownOp[Byte   ] = _.writeByte(_)
   given OctetWritedownOp[Char   ] = _.writeChar(_)
   given OctetWritedownOp[Short  ] = _.writeShort(_)
   given OctetWritedownOp[Int    ] = _.writeInt(_)
   given OctetWritedownOp[Long   ] = _.writeLong(_)
   given OctetWritedownOp[Float  ] = ((o, v) => o.writeInt(java.lang.Float.floatToRawIntBits(v) ) )
   given OctetWritedownOp[Double ] = ((o, v) => o.writeLong(java.lang.Double.doubleToRawLongBits(v) ) )

   

}


































































