package templating









class XcbTest
extends 
org.scalatest.funsuite.AnyFunSuite
{

   //

   trait TypeBox
   { type CAP }

   import avcframewrk.forms.*

   import templating.*

   trait CReprTb extends
   TypeBox

   given cReprByExistingXcb[R](using xcb : Xcb.ProsingOpsImpl[R ] )
   : (CReprTb { type CAP = R } )
   = "".asInstanceOf[CReprTb { type CAP = R }]

   def runExample1
   (using cRepr : CReprTb )
   (using xcb : Xcb.ProsingOpsImpl[cRepr.CAP ])
   ()
   = {
      
      {
         //

         val emptyExample = xcb.emptyExample

         val c1 = emptyExample ++ emptyExample ++ emptyExample
         
      }

      {
         //

         val emptyExample = xcb.emptyExample

         // val c1 = 3 *: emptyExample
         
      }

      ()
   }

   test("this basic example 1 compiles") {

      () => {
         given Xcb.ProsingOpsImpl[?]
         = ???
         runExample1()
      }

      assert(1 == 1 )
      
   }

}