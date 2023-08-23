package templating.w3e





















class ButtonDescriptiveCodeTest
extends 
org.scalatest.funsuite.AnyFunSuite
{

   //

   import avcframewrk.forms.*

   import templating.*

   //

   test("this example 1 shall compile and complete") {

      /** a future versions of Scala could inline `locally` ; use `identity` instead */
      identity[(ctx : w3e.pre.Articles & w3e.pre.Buttons ) => ctx.Action ](ctx => {

         identity((
            //
            ctx.Action(baseTitle = "action 1")((_ : Any) => {
               println(s"hello")
            })
         ))

         identity((
            //
            ctx.Action(
               //
               internalStateOption = {
                  monix.reactive.Observable(() )
               } ,
               baseTitle = "action 1",
               
            )((_ : Any) => {
               println(s"hello")
            })
         ))

      })

      assert(1 == 1 )

      println("this example 1 is completing")
      
   }

}


























