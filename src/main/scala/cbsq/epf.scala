package cbsq








import language.experimental.pureFunctions





@scala.annotation.experimental
private object epf {
   //
   
   def f(m: Tuple -> "") =
      ()
   f((value) => {
      println("info prints")
      ""
   })
   lazy val myFunc = f 
   
   def f2(m: Tuple -> "") =
      println("info prints")
      ()
   lazy val myFunc2 = f2

}






