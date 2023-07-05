package avcframewrk.util.test









class ILateBoundPtIterableOpsTest extends
org.scalatest.funsuite.AnyFunSuite
{

   import cbsq.avc.LateBoundValue

   test("every mapped instance mirrors the source's completional stat") {

      val e1 = LateBoundValue.newInstance[Unit]

      assertPersistiousCompletionalStat(e1 )
      
      val e2 = LateBoundValue.ofAlreadyResolvedWithUnit

      assertPersistiousCompletionalStat(e1 )
   }

   test("the IterableOps signatures work properly, and, as src resolves, mapped instances all each resolves as well") {

      val e1 = LateBoundValue.ofAlreadyResolvedWithUnit

      assertPersistiousCompletionalStat(e1 )
      
      assert(e1.asFuture.value.nonEmpty )

      val e2 = {
         e1 map(v => s"$v")
      }

      summon[e2.type <:< LateBoundValue.NhwGetValue[String] ]

      assert(e2.asFuture.value.nonEmpty )

      val e3 = {
         e2 map(v => { v ; true })
      }

      summon[e3.type <:< LateBoundValue.NhwGetValue[Boolean] ]

      assert(e3.asFuture.value.nonEmpty )
   }

   def assertPersistiousCompletionalStat[E](e1: LateBoundValue.NhwGetValue[E] ): Unit = {

      assert(e1.asFuture.value.isEmpty == (e1 map(identity[E] _ ) ).asFuture.value.isEmpty )
   }

}
