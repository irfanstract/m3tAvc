package cbsq.riffmt


















private 
object `% % & @` {

   
      abstract class TraversalDiagnostique {

         val path : String

         def fullScheme : Null | TraversalDiagnostique.FullSchemeInfo

         val RecoverableParsingError : PartialFunction[TraversalDiagnostique.EpError, Seq[Any] ]

      }

      object TraversalDiagnostique {

         val nullaryInstance : TraversalDiagnostique = new TraversalDiagnostique {

            val path = "???"

            val fullScheme = null
            
            val RecoverableParsingError = {
               PartialFunction.empty
            }
            
         }

         // given defaultInstance : TraversalDiagnostique = nullaryInstance

         // private[CodeSchemeOps] 
         private[`% % & @`] 
         def ofChildImpl(

            parent: TraversalDiagnostique,
            divName: String,

         ): TraversalDiagnostique = {

            new TraversalDiagnostique {

               val path = {
                  if (parent == nullaryInstance ) {
                     divName
                  } else {
                     parent.path + "/" + divName
                  }
               }

               export parent.{path => _, *}
               
            }
            
         }
         
         extension (parent: TraversalDiagnostique) {

            def ofChild(divName: String) = {

               ofChildImpl(parent, divName)
               
            }
            
         }
         
         extension (parent: TraversalDiagnostique) {

            def newLexerException(
               //

               msg: String ,

               r: Null | java.io.Closeable = null ,

            ): Exception = {

               new
               java.io.IOException(s"[${parent.path }]: $msg" )
               with EBmlPrimitivesMalformationException.%%!
               {

                  /* only show up in debuggers */
                  val correlatedRes = r

               }

            }
            
         }

         type FullSchemeInfo
            >: collection.immutable.Iterable[cbsq.riffmt.ebmls.elementDtdAnalyse]
            <: collection.immutable.Iterable[cbsq.riffmt.ebmls.elementDtdAnalyse]

         extension (parent: TraversalDiagnostique) {

            def withFullSchemeInfo(s: FullSchemeInfo ) = {

               new TraversalDiagnostique {

                  export parent.{fullScheme => _, * }

                  val fullScheme = s
                  
               }
               
            } : TraversalDiagnostique
            
         }
         
         object PSO {

            def unapplySeq(e: EpError)(using TraversalDiagnostique) = {

               summon[TraversalDiagnostique]
               .RecoverableParsingError
               .lift.apply(e )

            }

         }
         
         type EpError
            <: String | Matchable | Throwable
                  
         extension (parent: TraversalDiagnostique) {

            def withCustomErrorHandler(s: PartialFunction[EpError, Seq[Any] ] ) = {

               new TraversalDiagnostique {

                  export parent.{RecoverableParsingError => _, * }

                  val RecoverableParsingError = s
                  
               }
               
            } : TraversalDiagnostique
            
         }
         
      }


}





































