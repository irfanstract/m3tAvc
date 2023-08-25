package avcframewrk.forms.templating















/*
 * 
 * Laminar.
 * 
 * not able to `export` `package`s.
 * 
 */
protected
object laminarReExports {

   object api {
      //

      export com.raquo.laminar.api.{L, A, features}
      
   }

   // export com.raquo.laminar.DomApi

   //

}

val Laminar
: laminarReExports.type
= laminarReExports
val laminar
: laminarReExports.type
= laminarReExports

implicit
object LaminarBasedNativeElementRef
{

   //

   opaque type LlNessAs[+R]
      = Any

   @deprecated
   type LlNess
      = LlNessAs[Any]

   extension [R](e: R) {

      def asJsDynamic
      : scalajs.js.Dynamic
      = {
         ;
         e.asInstanceOf[scalajs.js.Dynamic]
      }

   }

   @deprecated
   def init
      [R <: org.scalajs.dom.Node ]
      (e: com.raquo.laminar.nodes.ReactiveNode[R] )
   : e.ref.type & LlNessAs[R]
   = e.setupBackreferenceAndGetReferent()

   extension [R <: org.scalajs.dom.Node](e: com.raquo.laminar.nodes.ReactiveNode[R] ) {

      def setupBackreference
      : e.type
      = {
         ;

         e.ref
         .asJsDynamic.lll_=(e.asInstanceOf[scalajs.js.Any ] )

         e
      }

      def setupBackreferenceAndGetReferent()
      : e.ref.type & LlNessAs[R]
      = {
         setupBackreference
         refWithLlness
      }

      def refWithLlness
      : e.ref.type & LlNessAs[R]
      = {
         ;

         e.ref
      }

   } // setupBackreference refWithLlness

   extension [R <: org.scalajs.dom.Element](e: org.scalajs.dom.Element & LlNessAs[R] ) {

      def devLaminarWrapperE
      : com.raquo.laminar.nodes.ReactiveElement[e.type]
      = {
         ;

         e
         .asJsDynamic.lll
         .asInstanceOf[com.raquo.laminar.nodes.ReactiveElement[e.type] ]
         .nn
      }

   } // Element devLaminarWrapper

   extension [R <: org.scalajs.dom.html.Element](e: org.scalajs.dom.html.Element & LlNessAs[R] ) {

      def devLaminarWrapperEH
      : com.raquo.laminar.nodes.ReactiveHtmlElement[e.type]
      = {
         ;

         e
         .asJsDynamic.lll
         .asInstanceOf[com.raquo.laminar.nodes.ReactiveHtmlElement[e.type] ]
         .nn
      }

   } // HtmlElement devLaminarWrapper

} // LaminarBasedNativeElementRef$

val Airstream
: laminarReExports.api.A.type
= laminarReExports.api.A

// object AirstreamFromMonix
// {

//    def apply[Item](src : monix.reactive.Observable[Item])
//    : Airstream.Observable[Item]
//    = {
//       ;

//       // TODO
//       ;

//       var subscriptionsMap
//       : Map[Int, AnyRef & monix.execution.Cancelable ]
//       = Map.empty

//       def unsubscribeFor(sI: Int)
//       = {
//          ;

//          subscriptionsMap =
//             subscriptionsMap
//             .tapEach({ case (`sI`, s) => s.cancel() ; case _ => })
//             .removed(sI)
//       }

//       val frontEnd = {
//          ;
//          Airstream.EventStream.fromCustomSource[Item](
//             //

//             //
//             shouldStart = sI => true ,

//             //
//             start = {
//                case (fireValue, fireError, getSI, _ ) =>
//                   ;

//                   val sI = getSI()

//                   subscriptionsMap = {
//                      subscriptionsMap.updatedWith(sI)({
//                         case None =>
//                            ;

//                            val s = {
//                               given sameThreadMonicScheduler.type = sameThreadMonicScheduler
//                               src
//                               .map(fireValue)
//                               .onErrorHandle(fireError )
//                               .subscribe()
//                            }

//                            Some(s)

//                         case Some(s) =>
//                            /* can't Subscribe more than once */
//                            throw new IllegalStateException(s"for i=${sI} ")
//                      })
//                   }

//             },

//             //
//             stop = (sI) => {
//                unsubscribeFor(sI)
//             } ,

//             //
//          )
//       }

//       frontEnd
//    }

//    final
//    lazy val sameThreadMonicScheduler
//    : monix.execution.Scheduler
//    = monix.execution.Scheduler(concurrent.ExecutionContext.parasitic )

// } // AirstreamFromMonix$











