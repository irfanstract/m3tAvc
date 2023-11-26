// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*

import scalajs.js



import com.raquo.airstream



;

object Ecl :
   def apply
      (using splCtx1: Quotes )
      ()
   =
      new eclAstRjsUtil.WithSplCtxImpl[splCtx1.type]
      with EclPreGraphOps
      with EclOps
//

trait EclOps
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
      ()
   : quotes.reflect.TreeMap
   = {
      ;

      import extraReflectiveOpExports.*

      val nhDoc
      = {
         ;
         import language.unsafeNulls
         ;
         s"""
         | 
         | to avoid bugs like `false negatives for object-literal, across redraws, resulting in constant call/firing`
         | as retold at https://react.dev/learn/removing-effect-dependencies#does-some-reactive-value-change-unintentionally
         |
         """.stripMargin
      }

      def formatNhErrorMsg
         (msg: => String, pos: Tree )
      : String
      = {
         ;
         import language.unsafeNulls
         ;
         s"""
         |${msg }
         |
         |${Printer.TreeShortCode.show(pos ).indent(2) }
         |
         |${nhDoc }
         """.stripMargin
      }

      new TreeMap {
         ;

         override
         def transformStatement
            (tree: Statement)
            (owner: Symbol)
         : Statement
         = {
            ;

            def fallbackToDefaultImpl()
            = super.transformStatement(tree )(owner = owner )

            given Quotes
            = owner.asQuotes
            import extraReflectiveOpExports.*

            tree match {
            //

            /** 
             * locally-defined `case`-class(es) will behave unsoundly ;
             * let's disallow them
             * 
             */

            case eTree @ CaseClassDef(_) =>
               ;
               report.errorAndAbort((
                  formatNhErrorMsg(s"Case Of Unsoundness: 'case class'es in React Hooks setting.", eTree )
               ) , eTree.pos )

            case eTree @ CaselyObjDef(_) =>
               ;
               report.errorAndAbort((
                  formatNhErrorMsg(s"Case Of Unsoundness: 'case object's in React Hooks setting.", eTree )
               ) , eTree.pos )

            /** 
             * handling `ValDef`s (which are not `var`s) and possibly `DefDef`s,
             * including if defined as `object`
             * 
             */
            case _ @ &%%!(tree *: _ *: o *: _ ) =>
               ;

               import o.{rhs0, tpt0}

               val owner = tree.symbol

               // given Quotes
               // = owner.asQuotes
               // import extraReflectiveOpExports.*

               val tpt1 = transformTypeTree(tpt0)(owner)
               val rhs1 = {
                  rhs0
                  .map({
                     //
                     case (x0) => {
                        val xpr1 = transformTerm(x0)(owner)
                        xpr1
                     }
                  })
                  .map({
                     //
                     case SingleArgTerm(xpr1) => {
                        ;
                        xpr1.asExpr
                        .toDeferredAsExpected(assumedOwner = owner )
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

            case Try(FromExprTree('{ ${e } : (t & typings.react.mod.ReactElement ) }), catch1, finally1) =>
               // TODO
               '{
                  import typings.react.mod.*
                  createElement("reactjs-errorcaught", null, ${e } )
               }
               .asTerm

            case _ : Term =>
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

         /** 
          * for both `ValDef` and (TODO) `DefDef`
          * 
          * currently we can't handle `var`s, but
          * as documented, the compiler extends `ValDef`s to `var`s, so
          * `ValDef`s which are `var`s will be rejected here
          * 
          */
         object &%%! {
            ;

            ;

            def unapply
               (tree: ValDef | DefDef )
            //
            = {
               ;
               trait Ier extends Selectable
               {
                  ;

                  val s = tree.symbol

                  val tpt0 : TypeTree

                  val rhs0 : Option[Term]

                  ;
               }
               Some(tree)
               .collect[(
                  // tree.type
                  ValDef | DefDef
                  , (() => Any ) *: EmptyTuple.type
                  , Ier
               )] ({
                  //
                  case tree @ (_ : ValDef) if { !(tree.symbol.flags is Flags.Mutable ) } =>
                     ;
                     (
                        tree
                        *:
                        ((() => ??? ) *: EmptyTuple)
                        *: {
                           new Ier {
                              ;

                              val tpt0 = tree.tpt
                              val rhs0 = tree.rhs

                           }
                        }
                        *:
                           EmptyTuple
                     )
               })
            }

            ;
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
