



import cbsq.avc.LateBoundValue




LateBoundValue.nhwgvTimeoutPolicies
.setTimeoutCtxValue(value = {
   import concurrent.duration.*
   3.seconds
})




import cbsq.avc.upstream.PerMuuxCtxOps




class EMco extends AnyRef with PerMuuxCtxOps {}

summon[EMco <:< PerMuuxCtxOps.OfInputUrl ]



PerMuuxCtxOps



val s1 = {
   (util.Try {
      (new EMco )
      .setDestToNull()
   } )
   .get
}

s1.srcUrl



val s1020 = {
   (util.Try {
      val c = (new EMco )
      c.srcUrl = "http://127.0.0.1:20300/"
      c
   } )
   .get
}

s1020.srcUrl

val s1021 = {
   (util.Try {
      (new EMco )
      .setDestToStdIo()
   } )
   .get
}

s1021.srcUrl




{
   (util.Try {
      val c = (new EMco )
      c.srcUrl = "http://127.0.0.1:20100/"
      c.srcUrl = "http://127.0.0.1:20300/"
   } )
   .failed
   .get
}

{
   (util.Try {
      (new EMco )
      .setDestToStdIo()
      .setDestToStdIo()
   } )
   .failed
   .get
}



extension [V](this1 : concurrent.Future[V]) {

   def checkHasBeenTerminated() = {
      this1
      .value
      .collect({
         case util.Success(value) =>
            s"has been resolved: '$value'"
         case util.Failure(value) =>
            s"failed: $value"
      })
      .getOrElse(throw new RuntimeException() {})
   }

   def checkRemainUnresolved() = {
      this1
      .value
      .toLeft("remained unresolved" )
      .getOrElse(throw new RuntimeException("it has been resolved") {})
   }

}



{
   (util.Try {
      (new EMco )
   } )
   .get
   .srcUrlQuestion
   .asFuture
   .checkRemainUnresolved()
   
}

{
   (util.Try {
      (new EMco )
      .setDestToStdIo()
   } )
   .get
   .srcUrlQuestion
   .asFuture
   .checkHasBeenTerminated()
   
}

math.random()

"str"

// {
//    (util.Try {
//       (new EMco )
//       .setDestToStdIo()
//    } )
//    .get
//    .srcUrlQuestion
//    .asFuture
//    .checkRemainUnresolved()
   
// }

{
   (util.Try {
      val s = (new EMco )
      s.srcUrl = "pipe:"
      s
   } )
   .get
   .srcUrl
   
}

{
   (util.Try {
      (new EMco )
   } )
   .get
   .endTQuestion
   .value
   
}










