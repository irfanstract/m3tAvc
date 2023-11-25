// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*





import scalajs.js

import com.raquo.airstream



import typings.{std as domItc }
import typings.std.{global as dom }
import typings.std.{global as window }



;

def newGsrGeneralisedUidGenerator
   //
   ()
//
= new Selectable { this10 =>
   ;

   import eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.DependenciesArray

   import eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.{*, given }

   ;

   var m
   : Map[Quotes#reflectModule#Position, Iterator[Long] ]
   = Map()

   type KeyByCtx[+Ctx <: Quotes]
   >: Quotes#reflectModule#Position
   <: Quotes#reflectModule#Position

   def initForKey
      //
      (using splCtx: Quotes)
      (s: KeyByCtx[splCtx.type] )
   = {
      ;
      m =
         m
         .updatedWith(s)(o => o.orElse(Some {
            ;

            lazy val gslUidIntGenerator
            = {
               ;
               Iterator.iterate[Long]( 758768757L )({
                  ;
                  (val0: Long) => {
                     import scala.math
                     val0
                     .pipeLooseSelf(_.abs )
                     .pipeLooseSelf(vl => (vl ^ math.pow(vl.toDouble, 5 ).toLong ) )
                     .pipeLooseSelf(vl => vl ^ math.sqrt(vl.toDouble ).toLong )
                     .pipeLooseSelf(<:<.refl[Long] )
                  }
               })
            }

            gslUidIntGenerator
         }))
      ;

      m.apply(s)
   }

   def next
      //
      (using splCtx: Quotes)
      (s: KeyByCtx[splCtx.type] )
   = {
      ;
      import quotes.reflect.*
      initForKey(s)
      .nextOption()
      .getOrElse(throw new AssertionError("NoSuchElementException") )
   }

   val main = new Selectable {
      ;

      export this10.next

   }
}.main



















val _ = {}
