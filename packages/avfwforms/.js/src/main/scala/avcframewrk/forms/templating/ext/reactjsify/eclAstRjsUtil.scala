// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*





import com.raquo.airstream









object eclAstRjsUtil {
   ;

   ;

   ;

   def constructs
      //
      (using splCtx1: Quotes)
   = {
      new %::! {
         val splCtx
         : splCtx1.type
         = splCtx1
      }
   }

   trait %::! {
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

      def symRefTryCollect
         (tree: Tree)
         (owner: Symbol)
      = symRefCollector.foldTree(util.Success(Nil ) , tree )(owner = owner )

      def symRefCollector
      = {
         // def foldTree(x: X, tree: Tree)(owner: Symbol): X
         type X
         >: util.Try[collection.immutable.Iterable[Symbol] ]
         <: util.Try[collection.immutable.Iterable[Symbol] ]
         new TreeAccumulator[X] {
            ;

            override
            def foldOverTree
               (x: X, tree: Tree)
               (owner: Symbol)
            : X
            = {
               ;
               ;

               tree match {
               //

               case s @ (_ : Ident) =>
                  x.map(x => x.++(Nil :+ s.symbol ) )
                  
               case ddef @ DefDef(_, paramss, tpt, rhs) =>
                  val owner = ddef.symbol
                  // foldTrees(foldTree(paramss.foldLeft(x)((acc, y) => foldTrees(acc, y.params)(owner)), tpt)(owner), rhs)(owner)
                  x
                  .pipeLooseSelf(x => foldTrees(x, rhs)(owner = owner ) )
                  .pipeLooseSelf(x => foldTree(x, tpt)(owner = owner ) )
                  .pipeLooseSelf(x => {
                     /* NEGATIVE */
                     paramss
                     .foldLeft[X] (x)((x, params ) => {
                        ;
                        val util.Success(mNeg)
                        = {
                           foldTrees(util.Success(Nil ) , params.params )(owner = owner )
                        }
                        ;
                        x.map(x => x.toSet.--(mNeg ) )
                     } )
                  } )

               case _ =>
                  super.foldOverTree(x, tree )(owner = owner )
               }
            }

            override
            def foldTree
               (x: X, tree: Tree)
               (owner: Symbol)
            : X
            = {
               ;
               tree match {
               //
               case _ =>
                  foldOverTree(x, tree )(owner = owner )
               }
            }

         }
      }

   }

   ;
}


















