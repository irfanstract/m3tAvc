package avcframewrk.util.errorchecking


















/**
 * 
 * "Reader/InputStream Usage Control"
 * a toolkit 
 * for implementing the locking-control before the main InputStream-or-Reader
 * 
 * the entry point is the `newReoc()` method, returning new/independent `Reoc` 
 * 
 * every invoc of the `reoc.mark()` method 
 * shall return a pair of `object`s, one `?{ def checkCompleted() }` and one `?{ def markCompleted() }` .
 * 
 * unless the `markCompleted()` of the latter obj has ben called,
 * the `checkCompleted()` itc returned by the next `reoc.mark()` will `throw` `IllegalStateException`.
 * however,
 * as a base-case,
 * for the first/initial `reoc.mark()`, the returned `checkCompleted()` itc will always return successfully .
 * 
 */
// protected 
object reocsImpl
{
      ;
      
      trait MarkableNoArg[+R] {

         def mark() : R
         
      }

      export avcframewrk.util.{AwaitableWithoutArg as JoinableNoArg }

      trait HasDoMarkCompletedNoArg[+R] {

         /**
          * 
          * if this itc were a pointer to a To-Do item,
          * mark it as "completed"
          * 
          */
         def markCompleted() : R
         
      }

      trait HasDoCheckCompletedNoArg[+R] {

         /**
          * 
          * if this itc were a pointer to a To-Do item,
          * check that it's already "completed",
          * synchronously `throw`ing otherwise
          * 
          */
         def checkCompleted() : R
         
      }

      type IsAnyNorNothing[R]
         = EvidenceOfBeingExactlyAnyOrNothing[R]
      
      type NeitherAnyNorNothing[R]
         = EvidenceOfBeingNeitherExactlyAnyNorNothing[R]
      
      import avcframewrk.util.LateBoundValue

      type NhwWhichShallReturn[R]
         = (LateBoundValue.NhwCompleteWith[R] & LateBoundValue.NhwGetValue[R] )

      def newUnresolvedNhw[R](using NeitherAnyNorNothing[R] ) = {
         avcframewrk.util.LateBoundValue.newInstance[R]
      }
      
      type ReocReturn
         >: (JoinableNoArg[Unit] & HasDoCheckCompletedNoArg[Unit] , HasDoMarkCompletedNoArg[Unit] )
         <: (JoinableNoArg[Unit] & HasDoCheckCompletedNoArg[Unit] , HasDoMarkCompletedNoArg[Unit] )
         
      /**
       * 
       * every invoc of the `reoc.mark()` method 
       * shall return a pair of `object`s, one `?{ def checkCompleted() }` and one `?{ def markCompleted() }` .
       * 
       * unless the `markCompleted()` of the latter obj has ben called,
       * the `checkCompleted()` itc returned by the next `reoc.mark()` will `throw` `IllegalStateException`.
       * however,
       * as a base-case,
       * for the first/initial `reoc.mark()`, the returned `checkCompleted()` itc will always return successfully .
       * 
       * TODO define whether `markCompleted()` shall be idempotent or non-idempotent
       * 
       */
      opaque type Reoc
         <: AnyRef & MarkableNoArg[ReocReturn ]
         = AnyRef & MarkableNoArg[([E] =>> (E, E) )[AelGeneric[Any] ] ]

      // import java.util.concurrent.Semaphore
      type Semaphore
         >: NhwWhichShallReturn[Smci ]
         <: NhwWhichShallReturn[Smci ]

      protected 
      case class Smci(e : Throwable)
      def newSmci(message: String = "" ) : Smci = {
         Smci(e = new Exception(message) {} )
      }

      /**
       * 
       * return a fresh, independent `Reoc`
       * 
       */
      def newReoc() : Reoc = {

         object impl extends
         AnyRef
         with MarkableNoArg[([E] =>> (E, E) )[AelGeneric[Any] ] ]
         {

            import language.unsafeNulls

            override
            def toString(): String = {
               s"Reoc(iterator: ${waitListItr } ; )"
            }

            private[impl]  
            type Ael
               = AelGeneric[Int]

            def waitListKnownItems = {

               val ksz = {
                  waitListEvaluatedSize
               }
               waitList
               .take( 1000 * 1000 ).lazyAppendedAll({ throw new Error(s"too many") })
               .take(ksz )
               .to(IndexedSeq)
            }

            /**
             * progressive
             */
            protected 
            val waitList: LazyList[Ael ] = {

               def newSemaphore(resolve : Boolean ): Semaphore = {
                  
                  val s = newUnresolvedNhw[Smci]
                  if resolve then s.success({ newSmci(s"completed by having 'resolve' been 'true' ") })
                  s
               }
               
               LazyList.from(0 )
               .map({

                  case (i) =>
                     ;

                     object mainHandle extends
                     Ael(
                        //

                        i = i,
                        sm = newSemaphore(resolve = false ) ,
                        
                        creationalCallEvt = new Exception(s"turn $i handle created") {} ,

                     )
                     {

                        override
                        def toString(): String = {
                           s"Reoc.Mark(${this.i }; sm: $sm ; )"
                        }

                        // TODO
                        def tryGetPrecedingEvent() = {
                           waitListKnownItems
                           .takeWhile(_ != mainHandle )
                           .to(IndexedSeq )
                           .reverse
                           .headOption
                        }

                        // TODO
                        def tryGetInterleavingEventsAndThis() = {
                           waitListKnownItems match {
                           case waitListKnownItems =>
                              ;
                              
                              val i = {
                                 ;
                                 waitListKnownItems
                                 .indexWhere((e : AelGeneric[?] ) => {
                                    val isImportant = (
                                       (e == mainHandle || (e.sm.asFuture ).value.fold[Boolean](true)(_.isFailure ) )
                                    )
                                    isImportant
                                 } )
                              }

                              waitListKnownItems
                              .drop(i + -1 )

                           }
                        }

                        override
                        protected
                        def newMissingPrecedingMarkCompleteCallYetException(): Exception = {
                           import language.unsafeNulls
                           val e = {
                              super[AelGeneric].newMissingPrecedingMarkCompleteCallYetException()
                           }
                           for ((p, precedingTurnAllocE ) <- {
                              tryGetInterleavingEventsAndThis()
                              .map(e => (e, e.creationalCallEvt) )
                           } ) {
                              e addSuppressed {
                                 new Exception(s"apparent interleaving mark() calls [$p] -- ${precedingTurnAllocE } ", precedingTurnAllocE )
                              }
                           }
                           e
                        }

                     }

                     mainHandle
                     
               })
               .zipWithIndex
               .tapEach({ case (item, i) => waitListEvaluatedSize = i })
               .map({ case (item, i) => item })
            }

            private var waitListEvaluatedSize : Int = 0

            waitList(0).markCompleted()

            private 
            val waitListItr = {
               waitList
               .iterator
               .sliding(size = 2, step = 1)
               .map({ case Seq(h0, h1) => (h0, h1) })
            }

            override
            def mark() = {
               
               waitListItr
               .next()
            }

         }
         impl
      }

      /**
       * 
       * TODO
       * 
       */
      protected 
      trait AelGeneric[+I](
         val i : I ,
         val sm : Semaphore ,
         val creationalCallEvt : Throwable ,
         
      ) extends
      AnyRef
      with HasDoMarkCompletedNoArg[Unit]
      with JoinableNoArg[Unit]
      with HasDoCheckCompletedNoArg[Unit]
      {
               ;
               
               protected 
               def closeWith(tr : util.Try[Smci] ) = {
                  sm tryComplete(tr )
               }

               def tryMarkCompleted() : Boolean = {
                  
                  sm.tryComplete(util.Success { newSmci(message = s"tryMarkCompleted() here ") })
               }

               override
               def checkCompleted(): Unit = {

                  sm.asFuture
                  .value
                  .getOrElse({
                     val mainEvt = {
                        newMissingPrecedingMarkCompleteCallYetException()
                     }
                     if shallCloseOnFailingCheckCompletedCall then {
                        closeWith { util.Failure { new IllegalStateException(s"closed due to failing 'checkCompleted()' ", mainEvt ) } }
                     }
                     throw mainEvt 
                  })
                  .get
               }

               protected 
               def newMissingPrecedingMarkCompleteCallYetException() : Exception = {
                  val e = new IllegalStateException(s"no 'markCompleted()' call yet -- ${this } -- ")
                  e addSuppressed { new Exception(s"created here (check apparent interleaving/intermediating calls!) -- $creationalCallEvt ", creationalCallEvt ) {} }
                  e
               }

               var shallCloseOnFailingCheckCompletedCall : Boolean = false

               /**
                * 
                * TODO - whether to make this idempotent or not
                * 
                */
               override
               def markCompleted(): Unit = {

                  if !tryMarkCompleted() then {

                     // dumpCompletingThreadStackTrace()

                     throw new IllegalStateException(s"failed - LBV/Promise already terminated.", cmImplTryGetThrownException() )
                  }

               }

               private[AelGeneric] 
               def cmImplTryGetThrownException() : Throwable | Null = {

                  util.Try(sttm.value.fold[Throwable | Null ](null )(_.get ) )
                  .get
               }

               def synchronouslyAwaitUntilClosed(): Unit = {
                  
                  /**
                   * 
                   * can't simply `sm.getValue()` ;
                   * `sm.value` is designed to `throw` on Failure(s), but
                   * `synchronouslyAwaitUntilClosed()` is supposed to always return normally
                   * 
                   */
                  locally {
                     val bl1 = newUnresolvedNhw[Unit]
                     sm.asFuture
                     .transform(_ => util.Success { bl1.success({ }) } )(using concurrent.ExecutionContext.parasitic )
                     bl1.getValue()
                  }
               }

               /**
                * 
                * the stack-trace from which this `Ael` was `&lt;init>`ed
                * 
                */
               val creationalCallEvtStackTraceStr = {

                  import language.unsafeNulls
                  
                  val sb = new java.io.StringWriter
                  creationalCallEvt.printStackTrace({ new java.io.PrintWriter(sb, true) })
                  sb.toString()
               }

               /**
                * 
                * this method
                * will dump/print, the stack-trace from which the main `Semaphore` was `complete`d
                * 
                */
               // protected 
               def dumpCompletingThreadStackTrace() : Unit = {
                     ;

                     sttm
                     .foreach(z => {
                        z.printStackTrace()
                     })(using concurrent.ExecutionContext.parasitic )

               }

               /**
                * 
                * this `Future`
                * maintains, the stack-trace from which the main `Semaphore` was `complete`d
                * 
                */
               private[reocsImpl] 
               val sttm = {
                  ;

                  implicit val ec = {
                     concurrent.ExecutionContext.parasitic 
                  }
                  
                  sm.asFuture
                  .transform(tr => util.Success {
                     tr.map(_.e ) match {
                        case util.Success(value @ e ) =>
                           e
                        case util.Failure(z ) =>
                           new Exception(s"markCompleted() t/here by Failure: $z", z) {}
                     }
                  })
               }

               /**
                * 
                * synchronously `await` until completion, and
                * return normally if it's already completed (regardless whether successful or not)
                * 
                */
               override
               def join(): Unit = {
                  
                  synchronouslyAwaitUntilClosed()
               }
               
      }


}

export reocsImpl.newReoc
export reocsImpl.ReocReturn
export reocsImpl.Reoc




















































