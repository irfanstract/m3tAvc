package riffmt.test






class PracticalReadingTest extends
org.scalatest.funsuite.AnyFunSuite
{

   import cbsq.riffmt.*

   test("Practical EBML/MKV Reading Eager") {

      ebmlPracticalTest1()

   }
   
   test("Practical EBML/MKV Reading Lazy") {

      ebmlPracticalTest1Lazy()

   }
   
}
