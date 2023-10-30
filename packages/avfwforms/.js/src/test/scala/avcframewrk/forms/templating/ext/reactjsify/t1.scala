package avcframewrk.forms.templating.ext.reactjsify










class T1 extends
org.scalatest.funsuite.AnyFunSuite
{

   ;

   test ("literal-values will compile") {
      ;

      assertCompiles("""{
         ;

         eclFrontEnd.eop({
            ;
            val master = "master"
         })
      }""")
   }

   test ("path-values will compile") {
      ;

      assertCompiles("""{
         ;

         eclFrontEnd.eop({
            ;
            val master10 = scala.Tuple2
            val master11 = scala.Tuple3
         })
      }""")
   }

   test ("'import's will compile") {
      ;

      assertCompiles("""{
         ;

         eclFrontEnd.eop({
            ;
            import language.unsafeNulls
            import reflect.Typeable
         })
      }""")
   }

   test ("constant-foldable arithmetics will compile") {
      ;
      
      assertCompiles("""
         ;

         eclFrontEnd.eop({
            val master = 5 + 5
         })
      """)
   }

   test ("nontrivial infix ops will break compile") {
      ;
      assertTypeError(""" {
         ;

         eclFrontEnd.eop({
            ;
            val master = "5" + 5
         })
      }""")
   }

   test ("calls to opaque methods will break compile") {
      ;
      assertTypeError(""" {
         ;

         eclFrontEnd.eop({
            val master11
            = "master".intern().nn
         })
      }""")
   }

   test ("reads of var(s) will break compile") {
      ;
      assertTypeError(""" {
         ;

         ({
            var ymy: Double = 5
            ;
            eclFrontEnd.eop({
               ;
               val master = ymy
            })
         })
      }""")
   }

   test("non-'case' 'object' decl would compile ") {
      ;

      assertCompiles("""{
         ;

         eclFrontEnd.eop({
            import language.unsafeNulls

            object comparatorImpl extends AnyRef with java.io.Serializable

            System.currentTimeMillis()
         })
      }""")
   }

   test("non-'case' 'class' decl would compile ") {
      ;

      assertCompiles("""{
         ;
         eclFrontEnd.eop({
            import language.unsafeNulls

            class SpecialComparator(mode: String) {}

            System.currentTimeMillis()
         })
      }""")
   }

}








