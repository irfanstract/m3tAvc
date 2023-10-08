package avcframewrk.forms

package templating

package reactjs













import scalajs.js

object Em {
   ;

   ;

   transparent
   inline
   def apply
   = ${applyImpl }

   def applyImpl
      //
      (using quoted.Quotes)
   = {
      ;

      ;

      import quoted.*
      import quotes.*
      import reflect.*

      ;

      val clsName = "typings.react.mod.AllHTMLAttributes"

      // report.error(s"fields of class '$clsName': ${Symbol.classSymbol(clsName).fieldMembers } ")

      val t1 = '{ () => {} }

      ;
      // Symbol.classSymbol(clsName).fieldMembers

      ({
         ;

         val elems
         = {
            ;

            Symbol.classSymbol(clsName).fieldMembers
            .take(24)
            .toIndexedSeq
            .sortBy(_.name)
         }

         val projType
         = {
            ;

            MethodType({
               elems
               .map(e => e.name )
               .toList
            })(_ => elems.indices.map(i => (elems(i).tree match { case e : DefDef => e.returnTpt.tpe ; case e : ValDef => e.tpt.tpe } ) ).toList , _ => TypeRepr.of[Unit] )
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
         })
         // Typed(('{ ??? }).asTerm , (
         //    ('{ () => {} } )
         //    .asTerm
         //    .tpe
         //    .asType
         //    match { case t => TypeTree.of(using t) }
         // ) )
         match { case e => {
            ;
            e.etaExpand(e.symbol )
         } }
         match { case e => {
            ;
            Typed(e, TypeTree.of(using projType.asType ) )
         } }
         match { case e => {
            ;
            val typeOf = e.tpe.asType.asInstanceOf[Type[? <: Any ] ]
            report.warning((
               Seq()
               // .:+(s"type: ${Type.show(using typeOf) } ")
               .:+(s"repr: ${Printer.TreeShortCode.show(e) } " )
               .mkString("\n")
               .grouped(150)
               .mkString("\n")
            ))
            e
            // .etaExpand(e.symbol )
            .asExpr.asExprOf(using typeOf )
         } }
      })
   }

   ;
}

;













val _ = {}
