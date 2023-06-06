



import cbsq.avc.upstream.breakably





breakably _



breakably(break1 => {
   
   for (i <- Range(0, 11) ) {

      println(i)

      if 3 <= i then {
         break1
      }

   }

})



{
   breakably(break1 => {

      for (i <- Range(0, 11) ) {
         if 3 <= i then {
            break1
         }
      }

      throw new AssertionError

   })
   "OK"
}







