package avcframewrk.util.test








/**
 * 
 * SynchronousAwaitTest
 * 
 * https://docs.scala-lang.org/scala3/book/tools-sbt.html 
 * 
 */
class SynchronousAwaitTest extends
org.scalatest.funsuite.AnyFunSuite
{

   import avcframewrk.util.*

   test("await(Future.never) shall fail with IllegalStateException") {

      assertThrows[IllegalStateException] {

         concurrent.Future.never
         .checkHasSucceedAndGetReturnValue()

      }

   }
   
   test("await(Future.unit) shall return valueOf[Unit]") {

      assertResult(() ) {

         concurrent.Future.unit
         .checkHasSucceedAndGetReturnValue()

      }

   }
   
}
