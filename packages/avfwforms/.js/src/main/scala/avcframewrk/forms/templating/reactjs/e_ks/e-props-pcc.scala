package avcframewrk.forms

package templating

package reactjs

package e_ks













import scalajs.js

object PropCheckCompulsion {
   ;

   ;

   ;

   private[templating]
   type SingletonPolyIdentityFnc
   = [R <: scala.Singleton ] => (e: R) => e.type

   ;

   final
   lazy
   val _CheckingFnc
   : PropCheckFnc.type
   = PropCheckFnc

   @deprecated
   // protected
   final
   lazy
   val CheckingFnc
   : PropCheckFnc.type
   = PropCheckFnc

   ;

   // object _ComprehensiveChecker
   // {
   //    ;

   //    /** 
   //     * alt
   //     * `[K, V ]`
   //     * 
   //     */
   //    transparent
   //    inline
   //    def `for`
   //       [Key <: String, Value >: Any <: Any ]
   //    : _CheckingFnc.ByPropNameAndValue[Key, Value]
   //    = ${ _ComprehensiveChecker.forRef[Key, Value] }

   //    /** 
   //     * alt
   //     * `[K, V ](key: K )`
   //     * 
   //     */
   //    transparent
   //    inline
   //    def for1
   //       [Key <: String, Value >: Any <: Any ]
   //       (key: Key)
   //    : _CheckingFnc.ByPropNameAndValue[Key, Value]
   //    = ${
   //       _ComprehensiveChecker.forRef1(quoted.Type.of[Key], quoted.Type.of[Any] )
   //    }

   //    /** 
   //     * alt
   //     * `splice { [K, V ](_: Type[K], _: Type[V] ) }`
   //     * 
   //     */
   //    def forRef1
   //       [Key <: String , Value >: Any <: Any ]
   //       (kT1: quoted.Type[Key] , vT: quoted.Type[Value] )
   //       (using quoted.Quotes)
   //    = {
   //       given kT1.type
   //       = kT1
   //       given vT.type
   //       = vT
   //       _ComprehensiveChecker.forRef[Key, Value ]
   //    }

   //    // // transparent inline
   //    // def forRef1
   //    //    //
   //    //    (c : FullCcrLookupCtx.ByKeyTAndValueT[?, ? ])
   //    //    (using quoted.Quotes)
   //    // = {
   //    //    ;
   //    //    _ComprehensiveChecker.forRef
   //    //       (using c.kT, c.vT )
   //    // }

   //    /** 
   //     * alt
   //     * `splice { [K, V ](using Type[K], Type[V] ) }`
   //     * 
   //     */
   //    def forRef
   //       [Key <: String , Value >: Any <: Any ]
   //       (using quoted.Type[Key], quoted.Type[Value] )
   //       (using quoted.Quotes)
   //    : quoted.Expr[_CheckingFnc.ByPropNameAndValue[Key, Value ] ]
   //    = {
   //       ;

   //       import compiletime.*
   //       import quoted.*
   //       import quotes.reflect.*

   //       _ComprehensiveChecker.forRefImpl
   //          [Key, Value]
   //          (
   //             //
   //             ccoLookupCtxOptionExpr = {
   //                ;

   //                Type.valueOfConstant[Key]
   //                .fold('{ None })(c => '{
   //                   Some {
   //                      CcoLookupCtx.byKey(${Expr(c) } )
   //                   }
   //                })
   //             }
   //             ,
   //             gvlcLookupCtxOptionExpr = '{
   //                ;

   //                val c = _UserSpaceCheckerLookupCtx.byKeyTAndValueT[Key, Value ]
   //                ;
   //                // Expr.summon[_CheckingFnc.ByPropNameAndValue[c.Key, c.Value] ]
   //                // .fold('{ None })(e => '{ Some(${e} ) } )
   //                Some(c)
   //             }
   //             ,
   //          )
   //    }

   //    // @annotation.experimental
   //    transparent
   //    inline
   //    def forFullCcrCtx
   //       [Key <: String, Value >: Any <: Any]
   //       (
   //          ctx : FullCcrLookupCtx.ByKeyTAndValueT[Key, Value ]
   //          ,
   //       )
   //       (using FullCcrLookupDiagCtx._Any )
   //    : _CheckingFnc.ByPropNameAndValue[Key, Value ]
   //    = ${
   //       ;
   //       _ComprehensiveChecker.forRefImpl
   //          [Key, Value]
   //          (
   //             ccoLookupCtxOptionExpr = '{ ctx.ccoCtxOption }
   //             ,
   //             gvlcLookupCtxOptionExpr = '{ Some { ctx.asUserSpaceCheckerLookupCtx } }
   //             ,
   //          )
   //    }

   //    // @annotation.experimental
   //    transparent
   //    inline
   //    def for1Alt1
   //       [Key <: String, Value >: Any <: Any]
   //       (
   //          ccoCtx : Option[CcoLookupCtx.ByKey[Key] ]
   //          ,
   //          gvlcLookupCtx: Option[_UserSpaceCheckerLookupCtx.ByKeyAndValue[Key, Value] ]
   //          ,
   //       )
   //    : _CheckingFnc.ByPropNameAndValue[Key, Value ]
   //    = ${
   //       ;
   //       _ComprehensiveChecker.forRefImpl
   //          [Key, Value]
   //          (
   //             ccoLookupCtxOptionExpr = '{ ccoCtx }
   //             ,
   //             gvlcLookupCtxOptionExpr = '{ gvlcLookupCtx }
   //             ,
   //          )
   //    }

   //    def forRefImpl
   //       [Key <: String , Value >: Any <: Any ]
   //       (using quoted.Type[Key], quoted.Type[Value] )
   //       (using quoted.Quotes)
   //       (
   //          //
   //          ccoLookupCtxOptionExpr : quoted.Expr[Option[CcoLookupCtx.ByKey[Key] ] ]
   //          ,
   //          gvlcLookupCtxOptionExpr : quoted.Expr[Option[_UserSpaceCheckerLookupCtx.ByKeyAndValue[Key, Value] ] ]
   //          ,
   //       )
   //       // (using FullCcrLookupDiagCtx._Any )
   //    : quoted.Expr[_CheckingFnc.ByPropNameAndValue[Key, Value ] ]
   //    = {
   //       ;

   //       import compiletime.*
   //       import quoted.*
   //       import quotes.reflect.*

   //       val gvlcLookupFailureMsgExpr
   //       = {
   //          ;

   //          val originalShortExpr
   //          = {
   //             Printer.TreeShortCode.show(gvlcLookupCtxOptionExpr.asTerm )
   //          }

   //          '{
   //             (
   //                //

   //                Seq()
   //                :+ s"empty 'gvlcLookupResultOption' (indicating failure) . "
   //                :+ s"  ctx ref: ${${Expr(originalShortExpr) } } "
   //                mkString("\n")
   //             )
   //          }
   //       }

   //       '{
   //          ;

   //          ;

   //          val ccoLookupCtxOption
   //          = ${ccoLookupCtxOptionExpr }

   //          val gvlcLookupCtxOption
   //          = ${gvlcLookupCtxOptionExpr }

   //          None
   //          .orElse({
   //             ;

   //             /** 
   //              * as the fixed beginning,
   //              * try resolve to these fixed selection
   //              * 
   //              */
   //             for {
   //                ctx <- ccoLookupCtxOption
   //                impl <- conformantCheckerForCommons11Option(ctx )
   //             }
   //             yield impl
   //          })
   //          .orElse({
   //             ;

   //             /** 
   //              * try 
   //              * summon whatever `given` such TC
   //              * visible at the point of the *inline/splice* (hence the call-site)
   //              * 
   //              */
   //             for {
   //                cand <- {
   //                   ;

   //                   ({
   //                      ;

   //                      for {
   //                         ctx <- gvlcLookupCtxOption
   //                         result <- {
   //                            ctx.runInlineFallibly()
   //                         }
   //                      }
   //                      yield result
   //                   })

   //                   .orElse({
   //                      if false then {
   //                         ;
   //                         compiletime.summonInline[quoted.Quotes]
   //                         .reflect.report.warning((
   //                            ${gvlcLookupFailureMsgExpr }
   //                         ))
   //                      }
   //                      None
   //                   })
   //                }

   //                //
   //             }
   //             yield cand
   //          })
   //          .orElse(( {
   //             ;

   //             /** 
   //              * if it's found in the ScalablyTyped-generated symbols
   //              * silently (ie without any warnings)
   //              * resolve to a no-op instance
   //              * 
   //              */
   //             ({
   //                ;

   //                ;
   //                for {
   //                   ctx <- ccoLookupCtxOption
   //                   fieldName <- {
   //                      (${Expr {
   //                         ;

   //                         Symbol.classSymbol("typings.react.mod.AllHTMLAttributes" )
   //                         .fieldMembers
   //                         .map(_.name )
   //                      }})
   //                      .find(_ == ctx.key )
   //                   }
   //                }
   //                yield {
   //                   if fieldName == "type" then {
   //                      // throw new RuntimeException(s"fieldName: ${fieldName } ")
   //                   }
   //                   ({ _CheckingFnc.ignorantInstance })
   //                }
   //             })
   //          }))
   //          .orElse(Some( ${
   //             ;

   //             /** 
   //              * as a last-resort -
   //              * emit warning, and then
   //              * resolve to a no-op instance
   //              * 
   //              */
   //             ({
   //                ;

   //                ;
   //                '{
   //                   ;

   //                   ((splctx : quoted.Quotes ) ?=> {
   //                      ;

   //                      ({
   //                         ;
   //                         import splctx.reflect.{*}

   //                         if true then {
   //                            ;

   //                            ((), (for { ctx <- ccoLookupCtxOption } yield ctx.key ).getOrElse("(no 'key' as 'ccoLookupCtxOption' was None )" ) )
   //                            match {
   //                               case ((), (key) ) =>
   //                                  ;

   //                                  // given Type[Key] = Type.of[]

   //                                  noCheckerCaseSpliceWarning1[String] (key = key )

   //                               case e if false =>
   //                                  throw new AssertionError(new MatchError(e).getMessage() )
   //                            }
   //                         }
   //                      })

   //                      _CheckingFnc.ignorantInstance
   //                   })
   //                      (using compiletime.summonInline[quoted.Quotes] )
   //                }
   //             })
   //          }))
   //          .get
   //       }
   //    }


   // }

   // private val ccrWrnDid

   object FullCcrLookupCtx {
      ;

      ;

      class ByKeyTAndValueT
         //
         [K <: String , V >: Any <: Any ]
         (using ValueOf[K] )
         (using
            //
            val kT: quoted.Type[K],
            val vT: quoted.Type[V],
         )
         // (val userSpaceGivenScope : quoted.Quotes )
         (val totalNfWarningTarget: DummyImplicit ?=> quoted.Expr[?] )
      { val key = valueOf[K] }

      @deprecated
      def byKeyTAndValueT
         //
         [K <: String , V >: Any <: Any ]
         (using ValueOf[K] )
         (using
            //
            kT: quoted.Type[K],
            vT: quoted.Type[V],
         )
      = byKeyTAndValueTAlt[K, V](totalNfWarningTarget = ??? )

      def byKeyTAndValueTAlt
         //
         [K <: String , V >: Any <: Any ]
         (using ValueOf[K] )
         (using
            //
            kT: quoted.Type[K],
            vT: quoted.Type[V],
         )
         (totalNfWarningTarget: => quoted.Expr[?] )
      = new ByKeyTAndValueT[K, V ](totalNfWarningTarget = totalNfWarningTarget  )

      def byKey
         //
         [K <: String , V >: Any <: Any ]
         (key: K , totalNfWarningTarget: => quoted.Expr[?] )
         (using
            //
            // kT: quoted.Type[key.type ],
            vT: quoted.Type[V],
         )
         (using quoted.Quotes )
      = {
         ;
         import quoted.*
         import quotes.reflect.*
         // byKeyTAndValueTAlt[key.type, V ](totalNfWarningTarget = totalNfWarningTarget  )
         ({
            ;
            type t = key.type
            given Type[t]
            = Literal(StringConstant(key) ).tpe.asType.asInstanceOf[Type[t] ]
            byKeyTAndValueTAlt[t, V ](totalNfWarningTarget = totalNfWarningTarget  )
         })
      }

      ;

      ;
   }

   extension
      //
      [Key <: String, Value >: Any <: Any]
      (
         ctx : FullCcrLookupCtx.ByKeyTAndValueT[Key, Value ]
      )
   {
      //

      // transparent
      // inline
      def ccoCtxOption
      = {
         ;
         Some {
            val key = ctx.key
            CcoLookupCtx.byKey(key)
         }
      }

      def asUserSpaceCheckerLookupCtx
      : _UserSpaceCheckerLookupCtx.ByKeyAndValue[Key, Value ]
      = {
         ;
         _UserSpaceCheckerLookupCtx.byKeyTAndValueT[Key, Value]
      }
   }

   object FullCcrLookupDiagCtx
   {
      ;

      case class _Any(receivingExprOption : Option[quoted.Expr[?] ] )

      @deprecated
      given fallbackInstance
      : FullCcrLookupDiagCtx._Any
      = _Any(receivingExprOption = None )

   }

   /** 
    * as a last-resort -
    * emit warning
    * 
    */
   private[templating]
   def noCheckerCaseSpliceWarning1
      [Key : quoted.Type ]
      (using quoted.Quotes)
      (key: Any )
      // ( )
      (using FullCcrLookupDiagCtx._Any )
   : Unit
   = {
      ;

      // import compiletime.*
      import quoted.*
      import quotes.reflect.*

      ((
         summon[FullCcrLookupDiagCtx._Any ].receivingExprOption
         .fold[(msg: String) => Unit ](report.warning(_) )(receiver => {
            msg => report.warning(msg, receiver )
         })
      ))
      .apply(msg = (
         Seq()
         .:+(s"no PropCheckCompulsion found for Key ('${ key }' : ${Type.show[Key] } ) " )
         .:++((
            key match {
               case "" =>
                  Seq()
                  .:+(s"  (empty String, hence 'children' ) " )
                  .:+(s"no user-defined instance was found for it . " )
                  .:+(s"this means, no checking at all. " )
               case NccNonEmptyString(key) =>
                  ;
                  Seq()
                  .:+(s"  (attribute '${Printer.TreeCode.show(Expr(key).asTerm ) }' ) " )
                  .:+(s"no user-defined instance was found for it, and \n it didn' point to \n one of the known attrib list, either . " )
                  .:+(s"this means, no checking at all. " )
                  .:+(s"  .valueOfConstant[Key @ ${Type.show[Key] } ]: ${key } ")
            }
         ))
         .mkString("\r\n")
      ))

   }

   val NccNonEmptyString = (Some.apply[String].andThen(o => o.filter(_.nonEmpty ) ) ).unlift

   object CcoLookupCtx {
      ;

      type _Any
      = ByKey[? ]

      class ByKey
         [+K <: Any : ValueOf ]
      {
         type Key >: K @annotation.unchecked.uncheckedVariance <: K
         val key: K = valueOf[K]
      }

      def byKey
         (key: Any )
      = ByKey[key.type]

      ;

      ;
   }

   object _UserSpaceCheckerLookupCtx
   {
      ;

      ;

      type _Any
      = ByKeyAndValue[?, ?]

      class ByKeyAndValue[+K, Vl ]
      {
         type Key
         >: K @annotation.unchecked.uncheckedVariance
         <: K
         // val key: K = valueOf[K]
         def key(using ValueOf[Key])
         = valueOf[Key]

         type Value
         >: Vl @annotation.unchecked.uncheckedVariance
         <: Vl
      }

      def byKeyTAndValueT
         [K, Vl]
      = ByKeyAndValue[K, Vl ]

      ;

      // implicit
      // transparent
      // inline
      // def given_runInlineFallibly
      //    [K, Vl] (c : ByKeyAndValue[K, Vl ] )
      // : _RanInlineFoundOption[_CheckingFnc.ByPropNameAndValue[c.Key, c.Value] ]
      // = {
      //    ;
      // }

      extension
         (c : ByKeyAndValue[? <: String, ? ] )
      {
         //

         /** 
          * run the main call-site lexical lookup
          * 
          */
         transparent
         inline
         def runInlineFallibly
            ()
         : _RanInlineFoundOption[_CheckingFnc.ByPropNameAndValue[c.Key, c.Value] ]
         = {
            ;

            compiletime.summonFrom({
               case e : _CheckingFnc.ByPropNameAndValue[c.Key, c.Value] =>
                  Some(e)
               case _ =>
                  None
            })
         }

         //
      }

      opaque type _RanInlineFoundOption
         [+T ]
      <: Option[T]
      =  Option[T]

      ;
   }

   ;

   ;

   ;

   export StdPropsCheckCompulsion.{*, given }

   ;
}











val _ = {}
