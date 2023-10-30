// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*





import com.raquo.airstream



;

lazy val _ = {
   ;

   eclFrontEnd.eop({
      import language.unsafeNulls
      val master = "master"
   })
   // eclFrontEnd.eop({
   //    import language.unsafeNulls
   //    val master10 = "master"
   //    val master11 = "master".intern()
   // })
   eclFrontEnd.eop({
      import language.unsafeNulls
      val master10 = scala.Tuple2
      val master11 = scala.Tuple3
   })
   eclFrontEnd.eop({
      import language.unsafeNulls
      val master = 5 + 5
   })
   // eclFrontEnd.eop({
   //    import language.unsafeNulls
   //    val master = "5" + 5
   // })
   // ({
   //    var ymy: Double = 5
   //    ;
   //    eclFrontEnd.eop({
   //       import language.unsafeNulls
   //       val master = ymy
   //    })
   // })
   ({
      ;
      eclFrontEnd.eop({
         import language.unsafeNulls
         val master = "ymy"
         object comparatorImpl {}
         System.currentTimeMillis()
      })
   })
   // ({
   //    ;
   //    eclFrontEnd.eop({
   //       import language.unsafeNulls
   //       val master = "ymy"
   //       case object comparatorImpl {}
   //       System.currentTimeMillis()
   //    })
   // })
   ({
      ;
      eclFrontEnd.eop({
         import language.unsafeNulls
         val master = "ymy"
         class ScTrait(val mode: String) {}
         System.currentTimeMillis()
      })
   })
   // ({
   //    ;
   //    eclFrontEnd.eop({
   //       import language.unsafeNulls
   //       val master = "ymy"
   //       case class SpecialComparator(mode: String) {}
   //       System.currentTimeMillis()
   //    })
   // })
} : Unit

lazy val _ = {
   ;
   eclReactHooks.useCachedValue[Int] (5, ??? )
   eclReactHooks.useCachedValue[Double] (5.1, ??? )
   ;
} : Unit


















val _ = {}

