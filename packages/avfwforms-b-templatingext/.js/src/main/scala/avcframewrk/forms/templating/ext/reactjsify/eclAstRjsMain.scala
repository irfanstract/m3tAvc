// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import scalajs.js



import com.raquo.airstream



;

object EclKit :
   def apply
      (using splCtx1: Quotes )
      ()
   =
      new eclAstRjsUtil.WithSplCtxImpl[splCtx1.type]
      with EclPreGraphOps
      with EclKitOps
//

trait EclKitOps
extends
AnyRef
with EclTdfOps
{
   this : (
      eclAstRjsUtil.WithSplCtxImpl[? ]
      & EclPreGraphOps
   ) =>
   ;

   ;

   ;

   // import quotes.reflect.{Singleton as _ , *}

   // // final
   // // lazy val %%::! = eclAstRjsUtil.constructs
   // import %%::!.{
   //    applyTransform as _,
   //    splCtx as _,
   //    *, given
   // }

   ;

   ;

   // TODO
   def mainReliftingTreeMap
      //
      (using splCtx : Quotes)
      ()
      (using ExtraReflectiveOpExports1[splCtx.type ] )
      (using uyteryt : %@&%%%%[splCtx.type ] )
   : quotes.reflect.TreeMap
   = {
      ;

      import extraReflectiveOpExports.*

      import uyteryt.{*, given}

      new TreeMap {
         ;

         class SpclWithGivenOwnerOps1
            //
            (val owner: Symbol)
         {
            ;

            ;

            given eaqcOps.type
            = eaqcOps

            // implicit
            val mQuotes
            = owner.asQuotesC
            // given mQuotes.type
            // = mQuotes
            object eroe {
               export extraReflectiveOpExports.*
            }

            object Internable1 {
               ;

               import eroe.*

               def unapply(tree: Tree )
               = {
                  Some(tree)
                  .collect({
                     //

                     /** 
                      * handling
                      * `ValDef`s (which are not `var`s) and possibly `DefDef`s,
                      * including if defined as `object`
                      * 
                      */
                     case tree @ TrueValDef(_*) =>
                        ;

                        val tpt0 = tree.tpt
                        val rhs0 = tree.rhs

                        val owner = tree.symbol

                        // given Quotes
                        // = owner.asQuotes
                        // import extraReflectiveOpExports.*

                        val tpt1 = transformTypeTree(tpt0)(owner)
                        val rhs1 = {
                           rhs0
                           .map({
                              case (x0) => {
                                 transformTerm(x0)(owner)
                              }
                           })
                           .map({
                              //
                              case SingleArgTerm(xpr1) => {
                                 ;
                                 val intendedOwner = owner
                                 xpr1.asExpr
                                 .toDeferredAsExpected1(intendedOwner = intendedOwner )
                                 // /* ad-hoc early-detection of the spurious type-mismatch (bug) */
                                 // .asExprOf(using { tpt1.tpe.asType match { case '[t] => Type.of[t] } } )
                                 .asTerm
                              }
                              case xpr1 =>
                                 xpr1
                           })
                        }

                        /**
                         * depending on what's going on,
                         * we might need to override/replace the type to be ascribed
                         */
                        val rhs1ActualTypeOpt
                        = {
                           ;
                           rhs1
                           .map(((_: Term).tpe ) andThen (t => TypeTree.of(using t.asType ) ) )
                        }

                        ValDef.copy(tree)(tree.name, (
                           /**
                            * depending on what's going on,
                            * we might need to override/replace the type to be ascribed .
                            * TODO
                            */
                           {
                              // tpt1
                              // (rhs1ActualTypeOpt getOrElse tpt1 )
                              tpt1
                           }
                        ), rhs1)
                     //

                  })
               }

               extension [R : Type] (xpr1: Expr[R] ) {
                  //

                  def toDeferredAsExpected1
                     //
                     (intendedOwner: Symbol )
                  : Expr[R]
                  = {
                     ;

                     xpr1

                     .pipeLooseSelf({
                        case (
                           quer1
                           // @ '{ ${_} : t }
                        ) =>
                           quer1 match {
                           //
                           case NoTxPleaseeeBoundedExpr(quer1 *: _ ) =>
                              quer1
                           case e =>
                              e
                              .toDeferredAsExpected(assumedOwner = intendedOwner )
                           }
                     })
                  }
               }

            }

            ;
         }

         override
         def transformStatement
            (tree: Statement)
            (owner: Symbol)
         : Statement
         = {
            ;

            def fallbackToDefaultImpl()
            = super.transformStatement(tree )(owner = owner )

            val e1 = SpclWithGivenOwnerOps1(owner = owner )
            import e1.{*, given }

            import eroe.*

            tree match {
            //

            /** 
             * locally-defined `case`-class(es) will behave unsoundly ;
             * let's disallow them
             * 
             */

            case eTree @ (CaseClassDef(_) | CaselyObjDef(_) ) =>
               ;

               report.errorAndAbort((
                  //
                  formatNhErrorMsg({
                     ;
                     s"Case Of Unsoundness: ${
                        eTree
                        .match {
                           case CaseClassDef(_) =>
                              "a 'case class'"
                           case CaselyObjDef(_) =>
                              "a 'case object'"
                           case _ =>
                              "'case class' or 'case object'"
                        }
                     } in React Hooks setting. \n  ${eTree.toString().take(80) } "
                  } , eTree )
               ) , eTree.pos )

            /** 
             * handling
             * `ValDef`s (which are not `var`s) and possibly `DefDef`s,
             * including if defined as `object`
             * 
             */
            case _ @ Internable1(r) =>
               r

            /** 
             * currently we can't handle `var`s, but
             * as documented, the compiler extends `ValDef`s to `var`s
             * 
             */
            //
            case eTree @ ( _ : ValDef ) if { eTree.symbol.flags is Flags.Mutable } =>
               ;
               report.error((
                  s"Implementation Restriction: cannot handle 'var's ;"
                  +: ((Printer.TreeShortCode.show(eTree ) ) + "\n^^^^ " ).indent(2).nn
                  +: {
                     val dnm = eTree.symbol.name
                     s"a work-around is to use a pair 'def $dnm' and 'def ${dnm}_=(newValue)' ."
                  }
                  +: Nil
               ).mkString("\n") , eTree.pos )
               eTree

            case _ : Term =>
               /* will eventually reach `transformTerm` */
               fallbackToDefaultImpl()

            case _ @ (_ : (Term | DefDef | TypeDef | (Import | Export ) ) ) =>
               fallbackToDefaultImpl()

            /** FAILING FALLBACK */
            case eTree =>
               report.error((
                  new MatchError(eTree )
                  .getMessage()
               ) , eTree.pos )
               eTree
            }
         }

         override
         def transformTerm
            (tree: Term)
            (owner: Symbol)
         : Term
         = {
            ;

            def fallbackToDefaultImpl()
            = super.transformTerm(tree )(owner = owner )

            given Quotes
            = owner.asQuotes
            import extraReflectiveOpExports.*

            object spclDebug {
               ;

               object getClsCmp {
                  ;

                  def format(tree: java.lang.Object, tree1: java.lang.Object )
                  = s"${tree.getClass()}/${tree1.getClass()}"

                  ;
               }

               ;
            }

            tree match {
            //

            case (FromExprTree('{ (${_} : eclFrontEnd.type ).takeGsgv(${sAnimExpr } ) : s }) ) =>
               '{
                  eclFrontEnd.takeGsgvM[s](${sAnimExpr } )
               }
               .asTerm

            case (FromExprTree('{ ${ FromTreeExpr(PolymorphicApply(FromExprTree('{ ${_} : eclFrontEnd.type }) , typeArgs, FromExprTree(sAnimExpr) ) ) } : s }) ) =>
               '{
                  eclFrontEnd.takeGsgvM[s](${sAnimExpr.asExprOf[airstream.core.Signal[s] ] } )
               }
               .asTerm

            case Try(FromExprTree('{ ${e } : (t & typings.react.mod.ReactElement ) }), catch1, finally1) =>
               '{
                  import typings.react.mod.*
                  createElement("reactjs-errorcaught", null, ${e } )
               }
               .asTerm

            case _ : Term =>
               fallbackToDefaultImpl()

            /** FAILING FALLBACK */
            case eTree =>
               report.error((
                  new MatchError(eTree )
                  .getMessage()
               ) , eTree.pos )
               eTree
            }
         }

         //
      }
   }

   // TODO
   def closingTreeTransform
      //
      ()
   : quotes.reflect.TreeMap
   = {
      ;
      import quotes.reflect.*
      new TreeMap {}
   }

   ;
}


















val _ = {}
