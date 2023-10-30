// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*





import com.raquo.airstream



object eclFrontEnd {
   ;

   transparent
   inline
   def eop
      [R]
      (inline e: R )
   = ${impl_eop('e) }

   def impl_eop
      [R]
      (e: Expr[R])
      (using Quotes)
   = {
      ;

      avcframewrk.forms.templating.ext.airstreamify.commonProtocol.runQuotativeSessionDmpably
         //
         (e, (e, _) => {
            ;

            import quotes.reflect.{Singleton as _ , *}

            val ctx1
            = Ecl()

            import ctx1.{given }

            import ctx1.applyTransform

            ({
               ;

               e
               .asTerm
               .applyTransform({
                  ctx1.mainReliftingTreeMap()
               } )(owner = Symbol.spliceOwner )
               .applyTransform({
                  ctx1.closingTreeTransform()
               } )(owner = Symbol.spliceOwner )
               .asExpr
            })
         } , warnResultingCode = true )
   }

   ;
}

object Ecl :
   def apply
      (using splCtx1: Quotes )
      ()
   = new EclOps { val splCtx: splCtx1.type = valueOf }
trait EclOps
{
   ;

   ;

   ;

   implicit
   val splCtx: Quotes

   import quotes.reflect.{Singleton as _ , *}

   extension (e: Term)
      def applyTransform
         (tx: TreeMap)
         (owner: Symbol)
      : Term
      = {
         ;
         tx.transformTerm(e)(owner = owner )
      }

   object CaseClassDef {
      def unapply
         (s: ClassDef )
      = {
         Some(s)
         .collect({
            // 'class'es
            case s: ClassDef if ((s.symbol.flags is Flags.Case) ) =>
               s
         })
      }
   }

   object CaselyObjDef {
      def unapply
         (s: ValDef | DefDef )
      = {
         Some(s)
         .collect({
            // 'case object's
            case s: (ValDef | DefDef) if (
               (s.symbol.flags is Flags.Module) && (s.symbol.flags is Flags.Case)
            ) =>
               s
         })
      }
   }

   object NonObjValDef {
      def unapply
         (s: ValDef )
      = {
         Some(s)
         .collect({
            // 'case object's
            case s if (
               !(s.symbol.flags is Flags.Module)
            ) =>
               s
         })
      }
   }

   ;

   // implicit class SpecialStOps (term: Statement ) {
   //    //

   //    def reactify()
   //    : Statement
   //    = {
   //       ;
   //       mainReliftingTreeMap()
   //       .transformStatement(term )(Symbol.spliceOwner )
   //    }

   // }

   // TODO
   def mainReliftingTreeMap
      //
      ()
   : TreeMap
   = {
      ;

      val nhDoc
      = {
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
         "".++(msg ).++("\r\n").++(nhDoc )
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
            tree match {
            //

            case eTree @ CaseClassDef(_) =>
               ;
               report.errorAndAbort((
                  formatNhErrorMsg(s"cannot define 'case class'es in React Hooks setting.", eTree )
               ) , eTree.pos )
            case eTree @ CaselyObjDef(_) =>
               ;
               report.errorAndAbort((
                  formatNhErrorMsg(s"cannot define 'case object's in React Hooks setting.", eTree )
               ) , eTree.pos )
            case tree @ (NonObjValDef(_) ) =>
               ;
               val owner = tree.symbol
               val tpt1 = transformTypeTree(tree.tpt)(owner)
               val rhs1 = {
                  tree.rhs
                  .map(x0 => {
                     val x1 = transformTerm(x0)(owner)
                     x1
                  })
                  .map(x1 => {
                     ;
                     x1.asExpr
                     .asEsg()
                     .asTerm
                  })
               }
               ValDef.copy(tree)(tree.name, tpt1, rhs1)

            case _ : Term =>
               super.transformStatement(tree )(owner = owner )
            case _ @ (_ : (Term | DefDef | TypeDef | (Import | Export ) ) ) =>
               super.transformStatement(tree )(owner = owner )

            case eTree =>
               val expr
               = eTree.asExpr
               report.errorAndAbort((
                  new MatchError(expr)
                  .getMessage()
               ) , expr )
            }
         }

         //
      }
   }

   extension [R : Type ] (x: Expr[R] )
      def asEsg
         //
         ()
      : Expr[R]
      = {
         ;
         x
         .pipeLooseSelf({
            //
            case '{ ${x1 } : (x1Type & Singleton) } => {
               '{ ([T <: Singleton] => (value: T) => value )(${x1 }) }
            }
            case e @ '{ ${x1 } : (x1Type) } =>
               report.error((
                  s"not stable expr: [as ${
                     Printer.TypeReprCode.show(TypeRepr.of[x1Type] )
                  }] ${
                     Printer.TreeShortCode.show(x1.asTerm )
                  } "
               ) , e )
               e
         })
      }
   //

   // TODO
   def closingTreeTransform
      //
      ()
   : TreeMap
   = {
      new TreeMap {}
   }
   ;
}



















val _ = {}

