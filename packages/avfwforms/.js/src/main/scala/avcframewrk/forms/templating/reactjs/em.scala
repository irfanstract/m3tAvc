package avcframewrk.forms

package templating

package reactjs













import scalajs.js
import scala.PolyFunction

object Em {
   ;

   ;

   import compiletime.*
   import quoted.{runtime as _, *}

   import emsImplPredefs.{*, given }

   transparent
   inline
   def apply
   = ${applyImpl }

   def applyImpl
      //
      (using quoted.Quotes)
   = {
      ;

      applyImpl1
   }

   def applyImpl1
      //
      (using quoted.Quotes)
   = {
      ;

      ;

      import quotes.*
      import reflect.*

      ;

      val clsName = "typings.react.mod.AllHTMLAttributes"

      // report.error(s"fields of class '$clsName': ${Symbol.classSymbol(clsName).fieldMembers } ")

      val xQuotesUtil1 = xQuotesUtil
      import xQuotesUtil1.{*, given }

      import ksImplUtil.asLinebreaking

      ;
      // Symbol.classSymbol(clsName).fieldMembers

      // report.info(Printer.TreeStructure.asLinebreaking().show(({ '{ type T = { def length: Int } ; val value : T = ??? ; value } }).asTerm ) )

      ({
         ;

         val acns
         = ScalablyTypedAnlys.analyseClassNamedSymbol(clsName )

         import acns.elems

         val projType
         = {
            structuralTypeMemberMethodTyping
            .pack(elems.filter(s => s.name.matches("\\w+") ) )
         }

         ;
         ({
            ;

            Lambda(Symbol.spliceOwner, {
               projType
            }, {
               case _ =>
                  ('{} )
                  .asTerm
            } )

            .pipeLooseSelf( e => {
               Typed(e, {
                  singleMethodRefinement1(("apply", projType ), baseTypeRepr = e.tpe )
                  .pipe(e => {
                     e
                     // .pipeLooseSelf({ case '{ ${e }: t } => {
                     //    ('{ Some(${e } : t ).value : t })
                     // } })
                     .asTerm
                     .pipeLooseSelf(e => {
                        ;
                        new TreeMap {
                           override
                           def transformStatement(t: Statement)(owner: Symbol): Statement
                           = {
                              t match {
                              case tree @ (t : ValDef) =>
                                 // ;
                                 // if (
                                 //    // tree.symbol.name.matches("value(Value)?").unary_! 
                                 //    false
                                 // ) then ({
                                 //    import  language.unsafeNulls
                                 //    (null : Statement | Null ).nn
                                 // })
                                 // else {
                                 //    ;
                                 //    report.info({
                                 //       s"${tree.symbol.name }/${tree.name } : ${(
                                 //          Seq()
                                 //          // ${Printer.TreeStructure.asLinebreaking( ).show(t.tpt ) }/${Printer.TypeReprStructure.asLinebreaking( ).show(t.tpt.tpe ) }
                                 //          :+ Printer.TreeStructure.asLinebreaking( ).show(t.tpt )
                                 //          :+ (t.tpt.tpe.dealias.pipeLooseSelf({
                                 //             case t @ Refinement(t1, name, repr) => s"Refinement(${t1.asType.toString().take(32) }, $name, ... )"
                                 //             case t => Printer.TypeReprStructure.asLinebreaking( ).show(t ) 
                                 //          }) )
                                 //          :+ Printer.TreeStructure.asLinebreaking( ).show(TypeTree.of(using t.tpt.tpe.simplified.asType ) )
                                 //          mkString "//////"
                                 //       )} "
                                 //    })
                                 // }
                                 val tS = t.symbol
                                 val s
                                 = Symbol.newVal(
                                    //
                                    owner ,
                                    t.name.++("Value"), {
                                       t.tpt
                                       .pipeLooseSelf(t => TypeTree.of(using t.tpe.asType ) )
                                       .pipeLooseSelf(t => transformTypeTree(t)(owner = owner ) )
                                       .tpe
                                       // TypeRepr.of[Unit ]
                                    } ,
                                    Flags.Param & Flags.HasDefault, Symbol.noSymbol ,
                                 )
                                 ValDef(s, None )
                                 // val owner = tree.symbol
                                 // val tpt1 = transformTypeTree(tree.tpt)(owner)
                                 // val rhs1 = tree.rhs.map(x => transformTerm(x)(owner))
                                 // ValDef.copy(tree)(tree.name.++("Attrib"), tpt1, rhs1)
                                 // ({
                                 //    import  language.unsafeNulls
                                 //    (null : Statement | Null ).nn
                                 // })
                              case _ =>
                                 super.transformStatement(t)(owner = owner )
                              }
                           }
                           override
                           def transformTypeTree(tree : TypeTree)(owner: Symbol)
                           = {
                              tree
                              match {
                                 case t @ Inferred() =>
                                    t.tpe match {
                                       case t @ Refinement(baseType, methName, sign) =>
                                          super.transformTypeTree({
                                             Refinement(baseType, methName, sign)
                                             .pipeLooseSelf(t => TypeTree.of(using t.asType ) )
                                             .tapLooseSelf(e => {
                                                // report.info({
                                                //    s"TTT : ${Printer.TreeStructure.asLinebreaking().show(e) } "
                                                // })
                                                report.warning({
                                                   s"parameter type sig : ${Printer.TypeReprCode.asLinebreaking().show(sign) } "
                                                })
                                             })
                                          })(owner = owner )
                                       case _ =>
                                          super.transformTypeTree(tree)(owner = owner )
                                    }
                                 case _ =>
                                    super.transformTypeTree(tree)(owner = owner )
                              }
                           }
                        }
                        .transformTree(e)({
                           // e.symbol
                           Symbol.spliceOwner
                        } )
                     })
                     .tapLooseSelf(e => {
                        // report.info({
                        //    s": ${Printer.TreeCode.asLinebreaking(lineWidth = 80 ).show(e) } "
                        // })
                     })
                     .asExpr
                  })
                  .pipeLooseSelf({ case '{ ${_} : t } => TypeTree.of[t] })
               } )
            } )
         })
         // // Typed(('{ ??? }).asTerm , (
         // //    ('{ () => {} } )
         // //    .asTerm
         // //    .tpe
         // //    .asType
         // //    match { case t => TypeTree.of(using t) }
         // // ) )
         // match { case e => {
         //    ;
         //    e
         //    // .etaExpand(e.symbol )
         // } }
         // match { case e => {
         //    ;
         //    singleMethodRefinement(e.toApplyDefDef() )
         //    .asTerm
         //    // e
         // } }
         // match { case e => {
         //    ;
         //    Typed(e, {
         //       '{
         //          ??? : (
         //             // AnyRef { }
         //             scala.PolyFunction { }
         //          )
         //       }
         //       .asTerm.tpe
         //       .pipeLooseSelf(t => TypeTree.of(using t.asType ) )
         //       .pipeLooseSelf(t => Refined.copy(t)({
         //          TypeTree.of[scala.PolyFunction ]
         //          // TypeTree.of(using e.tpe.asType )
         //       } , {
         //          Seq()
         //          .:+({
         //             ;
         //             e
         //             .toApplyDefDef()
         //          })
         //       }.toList ) )
         //    } )
         // } }
         match { case e => {
            ;
            // report.ksErrorExpr(e.asExpr )
            e
         } }
         match { case e => {
            ;
            val typeOf = e.tpe.asType.asInstanceOf[Type[? <: Any ] ]
            report.warning({
               ;
               import ksImplUtil.asLinebreaking

               (
                  Seq()
                  .:+(s"type: ${Printer.TypeReprCode.asLinebreaking().show(TypeRepr.of(using typeOf ) ) } ")
                  .:+(s"repr: ${Printer.TreeShortCode.asLinebreaking().show(e) } " )
                  .mkString("\n")
                  .grouped(150)
                  .mkString("\n")
               )
            })
            e
            // .etaExpand(e.symbol )
            .asExpr.asExprOf(using typeOf )
         } }

         // projType1

         // ;

         // '{ ??? }
      })
   }

   object ScalablyTypedAnlys
   {
      ;

      def analyseClassNamedSymbol
         (clsName: String)
         (using Quotes)
      = {
         ;

         import quotes.*
         import reflect.*

         new Selectable {
            ;

            val elems
            = {
               ;

               Symbol.classSymbol(clsName).fieldMembers
               .take(24)
               .toIndexedSeq
               .sortBy(_.name)
            }

            ;
         }
      }

      ;
   }

   ;
}

;













val _ = {}
