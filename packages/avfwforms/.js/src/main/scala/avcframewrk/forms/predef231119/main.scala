package avcframewrk.forms

package predef231119

// package avcframewrk.forms

// package domNavigatorObj.storageUsageUtil










export avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given }

extension [E](r: E | Null )
   (using util.NotGiven[Null <:< E ] )
   def nn
   : (E & r.type )
   = js.Function("value", "value.__proto__ ; return value ;").asInstanceOf[js.Function1[r.type, E & r.type ] ].apply(r) 

import cps.{async, await}

import scalajs.js

import typings.{std as domItc }
import typings.std.{global as dom }

import cps.monads.jsfuture.{JSFuture, given }

extension [R] (pr: js.Promise[R])
   def mapToUtilTry()
   : js.Promise[util.Try[R] ]
   = {
      pr
      .`then`[util.Try[R] ] (
        util.Success(_),
        ((e) => e.pipeLooseSelf({ case tr : Throwable => tr ; case tr => new Error(s"$tr") }).pipeLooseSelf(util.Failure(_) ) ) )
   }

def fromAsyncIterator
   [E]
   // TODO
   (src: js.Any | AnyRef )
= async[JSFuture] {
   await({
      ;
      js.eval("async (src) => { var c = [] ; for await (const item of src ) { c = [...c, item ] ; } ; return c ; } ")
      .asInstanceOf[js.Function1[src.type, js.Promise[js.Array[E]] ] ]
      .apply(src)
   })
   .to(List )
}


















val _ = {}
