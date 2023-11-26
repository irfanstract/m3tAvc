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

    val inPatternsAccumTrav
    = new TreeAccumulator[X] {
      ;

      override
      def foldOverTree
        (x: X, tree: Tree)
        (owner: Symbol)
      : X
      = {
        ;
        ;

        def runSuperImpl()
        = super.foldOverTree(x, tree )(owner = owner )

        val DDL
        = PartialFunction.fromFunction(<:<.refl[Tree ] ).andThen[(
            Option[Symbol] ,
            Some[Symbol] ,
            collection.immutable.Iterable[Symbol] ,
            collection.immutable.Iterable[Symbol] ,
        )] ({
            //

            case ddef @ DefDef(_, paramss, tpt, rhs) =>
              val symbol = ddef.symbol

              val owner = symbol

              // TODO
              val allReferencedSymbols
              = {
                  ;

                  x
                  .map(ls => ls.concat(Nil :+ owner ) )
                  .pipeLooseSelf(x => foldTrees(x, rhs)(owner = owner ) )
                  .pipeLooseSelf(x => foldTree(x, tpt)(owner = owner ) )
                  .pipeLooseSelf(x => {
                    ;
                    paramss
                    .foldLeft[X] (x)((x, params ) => {
                        ;
                        foldTrees(x , params.params )(owner = owner )
                    } )
                  } )
                  .get
              } : collection.immutable.Iterable[Symbol]

              val allParamNameDeclSyms
              = {
                  ;

                  paramss
                  .flatMap(params => {
                    params.params
                    .map(_.symbol)
                  } )
              } : Seq[Symbol]

              (Some(symbol), Some(owner), allReferencedSymbols, allParamNameDeclSyms )

            case dmx @ Match(scrutinee, cases1) =>
              ;
              val allReferencedSymbols = runSuperImpl().get
              ;
              // TODO
              val _ = {
                  cases1
                  .flatMap(casd => {
                    // TODO
                    Nil :+ casd.pattern
                  } )
              }
              // TODO this is a hard one
              ({
                  throw new IllegalArgumentException((
                    s"""
                    | currently 'match' is not supported.
                    |
                    | ${Printer.TreeShortCode.show(dmx : Term ) }
                    |
                    """.stripMargin
                  ))
              })
              (None, Some(owner), (
                  Nil
              ), Nil )
        })

        tree match {
        //

        // a fix
        case s : Bind =>
          ;
          x
          .map(seq => seq.toSet.incl(s.symbol ) )

        case _ =>
            runSuperImpl()
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

          def runSuperImpl()
          = super.foldOverTree(x, tree )(owner = owner )

          val DDL
          = PartialFunction.fromFunction(<:<.refl[Tree ] ).andThen[(
              Option[Symbol] ,
              Some[Symbol] ,
              collection.immutable.Iterable[Symbol] ,
              collection.immutable.Iterable[Symbol] ,
          )] ({
              //

              case ddef @ DefDef(_, paramss, tpt, rhs) =>
                val symbol = ddef.symbol

                val owner = symbol

                // TODO
                val allReferencedSymbols
                = {
                    ;

                    x
                    .map(ls => ls.concat(Nil :+ owner ) )
                    .pipeLooseSelf(x => foldTrees(x, rhs)(owner = owner ) )
                    .pipeLooseSelf(x => foldTree(x, tpt)(owner = owner ) )
                    .pipeLooseSelf(x => {
                      ;
                      paramss
                      .foldLeft[X] (x)((x, params ) => {
                          ;
                          foldTrees(x , params.params )(owner = owner )
                      } )
                    } )
                    .get
                } : collection.immutable.Iterable[Symbol]

                val allParamNameDeclSyms
                = {
                    ;

                    paramss
                    .flatMap(params => {
                      params.params
                      .map(_.symbol)
                    } )
                } : Seq[Symbol]

                (Some(symbol), Some(owner), allReferencedSymbols, allParamNameDeclSyms )

              case dmx @ Match(scrutinee, cases1) =>
                ;
                val allReferencedSymbols
                = runSuperImpl().get
                ;
                // TODO
                val allParamNameDeclSyms = {
                    cases1
                    .flatMap(casd => {
                      // TODO
                      Nil :++ {
                        casd.pattern
                        .pipeLooseSelf(tr => {
                          ;

                          inPatternsAccumTrav
                          .foldTree(util.Success(Nil), tr )(owner = owner )
                        } )
                        .get
                      }
                    } )
                }

                (None, Some(owner), (
                    allReferencedSymbols
                ), allParamNameDeclSyms )
          })

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

                // TODO
                allReferredOuterInScopeSymbols
              }

          case ddef @ DDL(d, Some(owner), allReferencedSymbols, allParamNameDeclSyms ) =>
              ;

              util.Try {
                allReferencedSymbols.toSet -- (allParamNameDeclSyms ++ d.toList ).toSet
              }

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
              runSuperImpl()
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
