package avcframewrk.forms

package templating

package w3e.impl.js.s1

















transparent inline
def typeable[T]
= {
   // summonHereNotInline[reflect.Typeable[T] ]
   summon[reflect.Typeable[T] ]
}

given given_TypeTest_AnyToOptionOfT[T2]
   (using reflect.TypeTest[Any, T2] )
: reflect.TypeTest[Any , Option[T2] ]
with {

   override
   def unapply(e: Any )
   = {
      Some[e.type ](e)
      .collect({ case e1 @ (None | Some(_ : T2) ) => e1 })
      .map[e.type & Option[T2] ](_ => e.asInstanceOf[e.type & Option[T2] ] )
   }

} // given_TypeTest_Any_Option

extension (console: org.scalajs.dom.Console ) {
   //

   def infoExceptionCollapsed(z: Throwable, headline: String = "the exception was:" )
   = {
      ;

      util.Using.resource({
         console.groupCollapsed(headline )
         locally[java.io.Closeable](() => {
            console.groupEnd()
         } )
      })(_ => {
         console.info({
            z
            /* on DevTools stack-trace printing-out broke unless the class-name ended with `Error` */
            match {
               case z : scalajs.js.JavaScriptException =>
                  z.exception
                  match { case z => (z.asJsDynamic.stack) : Any }
                  match { case z => {
                     z.toString()
                     // .replaceFirst("Exception\\b", "Error")
                     .prependedAll("Error: ")
                  } }
               case z =>
                  z
            }
         })
      } )
   }
} // infoExceptionCollapsed$

/* again, on DevTools stack-trace printing-out broke unless the class-name ended with `Error` */
type IecJavascriptException
= IecJavascriptError
private class IecJavascriptError(z: scalajs.js.JavaScriptException )
extends
Exception

object ParentChildRelationship {

   object Cio
   extends
   RelatorOps
   {

      trait ClassOps
         [
            +P <: ClassOps[P, C],
            +C <:  ClassInstanceOps[P, C],
         ]
      {
         this : P =>

         //

         //

         type InstanceOps
         <: (
            (ClassInstanceOps[P, C] {
               val class1 : P & ClassOps.this.type
            })
            &
            C
         )

         type Instance
         = InstanceOps
         
      } // ClassOps

      trait ClassInstanceOps
         [
            +P <: ClassOps[P, C],
            +C <: ClassInstanceOps[P, C],
         ]
      {
         this : C =>

         //

         //

         // protected 
         val class1
         : P

         final
         lazy val `class` : class1.type = class1
         
         final
         lazy val cls : class1.type = class1
         
      } // ClassInstanceOps

   } // Cio$
   
   trait RelatorOps
   {

      //

      type ClassOps
      <: AnyKind

      type ClassInstanceOps
      <: AnyKind

   } // RelatorOps

} // ParentChildRelationship$

/**
 * 
 * "close" all the specified "resource"s, by iterating over them in reverse and "close"ing each
 * 
 */
def closeAllOf
   [
      Res
      : util.Using.Releasable
      ,
   ]
   (resources : Seq[Res ] )
: Unit
= {
   ;

   ;

   util.Using.Manager(m => {
      ;

      for (r <- resources.reverse ) {
         m(r)
      }
   })

   ;
} // closeAllOf

given [T0]
: util.Using.Releasable[monix.reactive.Observer[?] ]
= r => r.onComplete()

given given_Releasable_Laminar_Observer[T0]
: util.Using.Releasable[com.raquo.airstream.core.Observer[?] ]
= r => { } // TODO

/**
 * strives for `monix.execution.Scheduler(concurrent.ExecutionContext.parasitic )`, but
 * since the factory overload was unavailable/missing in the JS build of Monix
 * we needed to resort back to `monix.execution.Scheduler.global`
 * 
 */
def trySameThreadScheduler()
: monix.execution.Scheduler
= monix.execution.Scheduler.global

/**
 * translates the `GivenSpinner1` into
 * the corresponding value which
 * , when used as a `&lt;button>`'s `type`, will make the elem an editor for the data-type
 * 
 */
transparent inline
def nativeTypStrFor(edType: w3e.pre.StdGsps.ofSnb.GivenSpinner1[?] )
: org.scalajs.dom.AvfwHTMLButtonType
= {
   ;

   edType

   match {
      //
      case edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_DateTime.type =>
         "date"
      case edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_Number[?] =>
         "number"
      case _ =>
         ""
      //
   }

   match { case v => org.scalajs.dom.AvfwHTMLButtonType(v) }
} // nativeTypStrFor

val _ = if false then {
   ;

   import org.scalajs.dom.console

   ;
   def inEgc[R] (msg: => String) (impl: => R )
   = {
      ;

      util.Using.resource({
         console.groupCollapsed(msg )
         locally[java.io.Closeable](() => console.groupEnd() )
      })(_ => {
         impl
      })
   }

   ;
   templating.rendering.reconciliabilityCWgc.impl_=([E] => (c: Product, impl: DummyImplicit ?=> E ) => {
      inEgc(s"reconciling ${c} ")({
         inEgc("(...)")(impl )
         match { case r =>
            console.log("done")
            r
         }
      })
   } )
}

/* 
 * 
 * use as cond breakpoint in the JS console
 * 
 * 
 * ```
 * (() => { try { $m_Lcom_raquo_airstream_core_Transaction$pendingTransactions$().done__Lcom_raquo_airstream_core_Transaction__V(transaction) ; } catch (z) { if (z.message.match(/Maximum call/g) ) { console.error(z) ; return true ; } } return false ; })()
 * ```
 * 
 * ```
 * (() => {
 *    try {
 *       $m_Lcom_raquo_airstream_core_Transaction$pendingTransactions$().done__Lcom_raquo_airstream_core_Transaction__V(transaction) ;
 *       return false ;
 *    }
 *    catch (z) {
 *       if (z.message.match(/Maximum call/g) )
 *       { console.error(z) ; return true ; }
 *    }
 *    return false ; 
 * })
 * ()
 * ```
 * 
 */

















val _ = {}
