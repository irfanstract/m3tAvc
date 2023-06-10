package avcframewrk.all.test






/**
 * 
 * InstalledCodecsTest
 * 
 * https://docs.scala-lang.org/scala3/book/tools-sbt.html 
 * 
 */
class InstalledCodecsTest extends
org.scalatest.funsuite.AnyFunSuite
{

   import cbsq.avc.codecs.*

   test("Show Installed Codecs") {

      runCodecListingDemo()

   }
   
}
