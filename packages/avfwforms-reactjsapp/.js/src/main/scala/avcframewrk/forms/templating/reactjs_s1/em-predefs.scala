package avcframewrk.forms

package templating

package reactjs_s1













import scalajs.js
import scala.PolyFunction

object emsImplPredefs
{
   ;

   ;

   import compiletime.*
   import quoted.{runtime as _, *}

   val structuralTypeMemberMethodTyping
   = {
      MtLevelling.forSymbolList[(
         [_0 <: Quotes] =>>
            ({
               val _1 : _0
               type _2 = _1.reflect.MethodType
            })
            #_2

         //
      ) ] (quotes ?=> elems0 => {
         ;

         import quotes.*
         import reflect.*

         val elems
         = elems0.toIndexedSeq

         MethodType({
            elems
            .map((e: Symbol ) => e.name )
            .toList
         })(
            //
            _ => List.from {
               elems
               .indices.map(i => {
                  elems(i).tree
                  match {
                     case e : DefDef => e.returnTpt.tpe
                     case e : ValDef => e.tpt.tpe
                  }
               } )
            } ,
            _ => TypeRepr.of[Unit] ,
         )
      } )
   }

   // val lmdExprTyping
   // = {
   //    MtLevelling.forSymbolList[(
   //       [_0 <: Quotes] =>>
   //          ({
   //             val _1 : _0
   //             type _2 = _1.reflect.PolyType
   //          })
   //          #_2

   //       //
   //    ) ] (quotes ?=> elems0 => {
   //       ;

   //       import quotes.*
   //       import reflect.*

   //       val elems
   //       = elems0.toIndexedSeq

   //       PolyType.apply({
   //          elems
   //          .map((e: Symbol ) => e.name )
   //          .toList
   //       })(
   //          //
   //          _ => List.from {
   //             elems
   //             .indices.map(i => {
   //                elems(i).tree
   //                match {
   //                   case e : DefDef => e.returnTpt.tpe
   //                   case e : ValDef => e.tpt.tpe
   //                }
   //             } )
   //          } ,
   //          _ => TypeRepr.of[Unit] ,
   //       )
   //    } )
   // }

   /** 
    * a set of relevant `Quotes`-related goodies
    * 
    */
   def xQuotesUtil
      //
      (using ctx1 : Quotes)
   = new XQuotesUtilImpl

   /** 
    * the impl for `xQuotesUtil` -
    * needs to be this separate `class` (`trait`) ,
    * to avoid those known limitations with reflective-calls
    * 
    */
   protected
   class XQuotesUtilImpl
      //
      [+Ctx <: Quotes & Singleton ]
      (using protected val ctx : Ctx)
   {
      ;

      ;

      import quotes.*
      import reflect.*

      // implicit object given_asLinebreaking1 {
      //    export ksImplUtil.asLinebreaking
      // }
      export ksImplUtil.asLinebreaking

      ;

      // report.error(s"fields of class '$clsName': ${Symbol.classSymbol(clsName).fieldMembers } ")

      extension (r : report.type ) {
         def ksErrorExpr(e1: Expr[?])
         = {
            ;

            report.ksErrorAndAbort({
               s"(type: ${Printer.TypeReprCode.asLinebreaking().show(e1.asTerm.tpe ) }) expr: ${Printer.TreeCode.asLinebreaking().show(e1.asTerm ) } "
            } , e1 )
         }

         def ksInfoExpr(e1: Expr[?])
         : Unit
         = {
            ;

            report.info({
               s"expr: ${Printer.TreeCode.asLinebreaking().show(e1.asTerm ) } (${Type.show(using e1.asTerm.tpe.asType ) }) "
            } , e1 )
         }
      }

      ;

      if true then
         //
         val e = '{ ??? : AnyRef { def length: Int ; def apply(r: Any ): r.type } }
         // throw new AssertionError({
         //    e.asTerm
         //    .tpe
         //    .pipeLooseSelf(tRepr => s"type: ${Printer.TypeReprStructure.asLinebreaking().show(tRepr) } " )
         // })

      ;

      extension (e: Block )
         def toApplyDefDef()
         : DefDef
         = {
            ;
            e
            .pipeLooseSelf({ case Block(e +: Nil , _ ) => e })
            .asInstanceOf[DefDef ]
            .pipeLooseSelf(df => {
               // DefDef.copy(df)("apply", df.paramss, df.returnTpt, df.rhs )
               df
            } : DefDef )
         }

      /** 
       * for `new (t.RepresentedT ) <no '()' at-all> ` .
       * see https://github.com/lampepfl/dotty/issues/16357 , a ticket abt the right Tree structure for `new Bar ...`s
       * 
       */
      def properNewCd
         (t: ClassDef)
      : Select
      = {
         ;

         assert(t.symbol.name == t.name )

         New(TypeTree.ref(t.symbol ) )
         .pipeLooseSelf(enw => Select(enw, t.symbol.primaryConstructor ) )
         .pipeLooseSelf(e => e )
      }

      def singleMethodClass
         (df: DefDef )
      : ClassDef
      = {
         ;

         /** 
          * a template,
          * to avoid the complexity of (... ...) ;
          * in the form of `do { class Main extends Selectable { def pro() : Unit } ; new Main }`
          * 
          */
         val sample1
         = {
            ;

            '{
               class Main extends Selectable {
                  def pro() : Unit = {}
               }
               new Main
            }
         }

         sample1
         .pipeLooseSelf({
            case e @ '{ ${e1} : t ; ${_} } =>
               ;

               // report.warning({
               //    import ksImplUtil.asLinebreaking
               //    s"expr: ${Printer.TreeCode.asLinebreaking().show(e1.asTerm ) } (${Type.show(using e1.asTerm.tpe.asType ) }) "
               // } , e1 )

               e1.asTerm

         })
         .pipeLooseSelf({
            case e @ ClassDef(_, _, _, _, _ ) =>
               val newName = "Mainly"
               if false then
                  //
                  throw new AssertionError({
                     s"${
                        e.constructor
                        .pipeLooseSelf(m => s"${m.name } : ${Printer.TypeReprCode.asLinebreaking().show(m.returnTpt.tpe ) }")
                     } , of ${e.name } "
                  })
               ClassDef.copy(e )(
                  //
                  {
                     // e.name
                     newName
                  },
                  e.constructor
                  .pipeLooseSelf(m => DefDef.copy(m)(m.name, m.paramss, m.returnTpt, m.rhs ) )
                  ,
                  e.parents,
                  e.self,
                  {
                     List()
                     :+ df
                     // :++ e.body
                  },
               )

            // case e =>
            //    // '{ ??? }.asTerm
            //    ???
         })
      }

      @deprecated
      def singleMethodRefinement
         (df: DefDef )
      : Expr[AnyRef ]
      = {
         ;

         singleMethodRefinement1((df.name, df.toEtaExpandedTypeReprNoWiden() ) )
      }

      def singleMethodRefinement1
         (t: (String, TypeRepr), baseTypeRepr: TypeRepr = TypeRepr.of[PolyFunction ] )
      : Expr[AnyRef ]
      = {
         ;

         // throw new AssertionError({
         //    TypeTree.of[AnyRef { def notImplemented(): Nothing }]
         //    .pipeLooseSelf({
         //       case Refined(baseT, defs) =>
         //          s"Refined(baseT=${baseT }, defs=${defs } ) "
         //    })
         // })

         val tR = {
            // df
            // TypeRepr.of[PolyFunction { }]
            // TypeRepr.of[AnyRef]
            baseTypeRepr
            .pipeLooseSelf(baseT => {
               Refinement(baseT, t._1, t._2 )
            } )
            // .tpe
         }

         ('{ ??? }).asTerm
         .pipeLooseSelf(e => Typed(e, TypeTree.of(using tR.asType ) ) )
         .tapLooseSelf(e => if false then {
            ;

            report.info({
               s"[singleMethodRefinement1] : expr : ${Printer.TreeStructure.asLinebreaking().show(e) } "
            })
         })
         .asExpr
         .pipeLooseSelf({ case '{ ${e}: t } => {
            ;
            ('{
               type T = t
               val value: T
               = ${e }
               value
            })
         } })
         .asExprOf[AnyRef ]
      }

      // TODO
      extension (df0 : DefDef )
         def toEtaExpandedTypeReprNoWiden()
         : TypeRepr
         = {
            ;

            df0 match

            case df : DefDef =>
               ;

               df.paramss
               // TODO
               .foldLeft[TypeRepr](df.returnTpt.tpe )({
                  case (t0, paramClause : TermParamClause ) =>
                     MethodType
                        (paramClause.params.map(_.name ) )
                        (
                           //
                           _ => paramClause.params.map(_.tpt.tpe ) ,
                           _ => t0 ,
                        )
                  case (t0, paramClause : TypeParamClause ) =>
                     // MethodType
                     //    (paramClause.params.map(_.name ) )
                     //    (
                     //       //
                     //       _ => paramClause.params.map(_.tpt.tpe ) ,
                     //       _ => t0 ,
                     //    )
                     ???
               })
         }

   }

   object MtLevelling {
      ;

      type _Any
      = Impl[?]

      case class Impl
         [+RT[C <: Singleton & Quotes ] ]
         (impl: ((quotes: Quotes) ?=> (collection.immutable.Iterable[quotes.reflect.Symbol ] ) => RT[quotes.type ] , Unit ) )
      {
         // def pack
         //    (using Quotes)(es: collection.immutable.Iterable[quotes.reflect.Symbol ] )
         // = impl
         export impl._1.{apply as pack }
         type R[C <: Singleton & Quotes ]
         >: RT[C] @annotation.unchecked.uncheckedVariance
         <: RT[C]
      }

      def forSymbolList
         [RT[C <: Singleton & Quotes ] ]
         (impl: (quotes: Quotes) ?=> (collection.immutable.Iterable[quotes.reflect.Symbol ] ) => RT[quotes.type ] )
      = Impl[RT ](impl = (quotes ?=> items => impl(items) , () ) )

      ;
   }

   ;
}

;













val _ = {}
