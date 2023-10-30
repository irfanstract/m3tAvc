// package avcframewrk.forms.templating.ext.reactjsify.eclAstRjsUtil

// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify

package eclAstRjsUtil










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*









def lexicalEscapeAnalytics
   //
   (using splCtx1: Quotes)
= {
   new WithSplCtxImpl[splCtx1.type] with LxEscAnalytique
}

protected
trait LxEscAnalytique
{
   this : WithSplCtxImpl[?] =>
   ;

   ;

   import quotes.reflect.{Singleton as _ , *}

   private[LxEscAnalytique] val cc = constructs
   import cc.*

   ;

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

            // a fix
            case s @ (_ : Inlined ) =>
               x
               .map(x1 => {
                  ;
                  (foldTree(util.Success(x1), s.body )(owner = owner ).get ).toSet
                  .--(s.bindings.toSet.map((_: Definition ).symbol ) )
               })

            case s @ (Block(stats, returnExpr ) ) =>
               ;
               for (c1 <- x )
               yield {
                  ;

                  val allReferredSymbols
                  = {
                     ;
                     (foldTrees(util.Success(c1), stats ++: returnExpr +: Nil )(owner = owner ).get )
                     .toSet
                  }

                  val allAtLvlDefinedLeafSymbols
                  = {
                     ;
                     stats
                     .flatMap({
                        //
                        case s @ (_ : Definition ) =>
                           Nil :+ s.symbol
                        case _ => Nil
                     })
                  }

                  /** 
                   * those which each
                   * is referred from here and comes from outside this *block*
                   * 
                   */
                  val allReferredOuterInScopeSymbols
                  = {
                     ;

                     allReferredSymbols
                     .--(allAtLvlDefinedLeafSymbols )
                  }

                  Predef.assert((
                     (allReferredOuterInScopeSymbols.toSet).intersect(allAtLvlDefinedLeafSymbols.toSet)
                     .isEmpty
                  ))

                  // if ({
                  //    (allReferredSymbols ++ allAtLvlDefinedLeafSymbols.toSet ).find(s => s.name.nn.contains("props") ).nonEmpty

                  //    s.tpe.<:<(TypeRepr.of[typings.react.mod.ReactElement] ) && allAtLvlDefinedLeafSymbols.nonEmpty
                  // } ) then {
                  //    ;
                  //    report.error(s"${(allReferredSymbols +: allAtLvlDefinedLeafSymbols.toSet +: Nil ).map(set => set.map(sym => sym.name ) ) }", s.pos )
                  // }

                  // TODO
                  allReferredOuterInScopeSymbols
               }

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
                     ;
                     for  (referredSymbols <- x )
                     yield {
                        ;

                        val util.Success(mNeg)
                        = {
                           foldTrees(util.Success(Nil ) , params.params )(owner = owner )
                        }

                        referredSymbols.toSet -- mNeg
                     }
                  } )
               } )

            // TODO for `Def`s

            case s @ (_ : ValDef) =>
               ;
               // TODO
               foldTrees(x, s.tpt +: s.rhs.toList ++: Nil )(owner = s.symbol )

            case s @ (_ : Definition) =>
               ;
               // TODO
               x

            /** 
             * for `Ident`
             * 
             * TODO
             * 
             * every binding constitutes of an `Ident`, so
             * saying "every `Ident` is a query" is therefore wrong.
             * hence being put herelast
             * 
             */
            case s @ (_ : Ident) =>
               x.map(x => x.++(Nil :+ s.symbol ) )

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

   ;
}

;













val _ = {}
