package cbsq.avc












export numericImpl.Integer
export numericImpl.integer




/**
 * the implementation
 */
private
lazy val numericImpl : Nmi = 
   new Nmi {
      type Integer = Long
      def integer(v: BigInt) =
         BigDecimal(v).toLongExact
   }
sealed 
trait Nmi {
   type Integer <: Int | Long | BigInt
   def integer(v: BigInt): Integer
}











