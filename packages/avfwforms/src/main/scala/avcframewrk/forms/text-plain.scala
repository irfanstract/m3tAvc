package avcframewrk.forms















given PlainTextOps[
   D ,
](using DummyImplicit)
(using cc : avcalg.Concatenability[D] )
(using pto : PlainTextToStringConversion1[D] )
: AnyRef with {

   //

   export pto.toString1

   export cc.{plus, ++ }
   
}

trait PlainTextToStringConversion1[D]
{

   extension (d: D)
      def toString1: String
   
}














