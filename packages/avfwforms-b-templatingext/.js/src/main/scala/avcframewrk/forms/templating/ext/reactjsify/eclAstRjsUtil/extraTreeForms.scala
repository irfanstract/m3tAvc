// package avcframewrk.forms.templating.ext.reactjsify.eclAstRjsUtil

// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify

package eclAstRjsUtil










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*









;

// protected
trait WithSplCtxImpl[+C <: Quotes & Singleton ](using val splCtx : C )

given constructs
   //
   [C <: Singleton & Quotes ]
   (using splCtx1: C)
: WithSplCtxImpl[C ] with ConstructsImpl

given FTE
   [C <: Singleton & Quotes ](using C )
: AnyRef with {
   ;

   import quotes.reflect.{Singleton as _ , *}

   object FromExprTree {
      ;
      def apply(e: Expr[?] ) = e.asTerm.underlyingArgument
      def unapply(eStr: Term ) = Some(eStr).collect({ case eStr if eStr.isExpr => eStr.asExpr })
   }

   object FromTreeExpr {
      ;
      def unapply(e: Expr[?] ) = Some(FromExprTree(e) )
      def apply(eStr: Term ) = FromExprTree.unapply(eStr ).get
   }

}

given CAT
   [C <: Singleton & Quotes ](using given_C : C )
: AnyRef with {
   ;

   import given_C.reflect.{Singleton as _ , *}

   extension (e: Term)
      def applyTransform
         (tx: TreeMap)
         (owner: Symbol)
      : Term
      = {
         ;
         tx.transformTerm(e)(owner = owner )
      }
   //

}

given QuotesQuasiPathRefs1
   [C <: Singleton & Quotes ](using given_C : C )
: AnyRef with {
   ;

   import given_C.reflect.{Singleton as _ , *}
   
   ;

   // TODO
   /** 
    * all of these
    * 
    * ```
    * pref.bar5
    * 
    * pref.bar5[T]
    * 
    * pref1.pref2.pref3.pref4[R]
    * pref1.pref2.pref3[T1].pref4
    * pref1.pref2[T2].pref3.pref4
    * ```
    * 
    */
   object StrictQuasiPathRef {
      ;

      export StrictQuasiPathRef.BySuffixSeq.unapply

      object BySuffixSeq {
         ;

         def unapply
            (eTR: Tree)
         : Option[(Tree, Seq[QpQuasiSelect.Desc._Any ] ) ]
         = {
            Some(eTR)

            .flatMap({
               //

               case AnyPrefixQuasiPathRef(prefixTr, presentlyOpDesc ) =>
                  for {
                     (globalPrefix, s0 ) <- StrictQuasiPathRef.unapply(prefixTr)
                  }
                  yield {
                     (globalPrefix, s0 :+ presentlyOpDesc )
                  }

               case _ =>
                  None

            })
         }

         ;
      }
   }

   /** 
    * all of these
    * 
    * ```
    * (pref expr).bar5
    * 
    * (pref expr).bar5[T]
    * ``` 
    * 
    */
   object AnyPrefixQuasiPathRef {
      ;

      def unapply
         (eTR: Tree)
      = {
         Some(eTR)

         .collect[(
            Term,
            QpQuasiSelect.Desc._Any ,
         )] ({
            //

            case Select(prefixTr, nameTr ) =>
               (prefixTr, (nameTr, Nil) )
            case TypeApply(Select(prefixTr, nameTr ), types1 ) =>
               (prefixTr, (nameTr, types1) )

         })
      }

   }

   object QpQuasiSelect {
      ;

      object Desc {
         ;

         type _Any
         >: (String, QpTypeArgs._TTreeLsAny )
         <: (String, QpTypeArgs._TTreeLsAny )

         ;
      }

   }

   object QpTypeArgs {
      ;

      type _TTreeLsAny
      >: List[TypeTree]
      <: List[TypeTree]

      type _TReprLsAny
      >: List[TypeRepr]
      <: List[TypeRepr]

   }

}

// private
given ConstructsImplAlt
   [C <: Singleton & Quotes ](using given_C : C )
   (using given_FTE : FTE                 [given_C.type ] )
   (using given_CAT : CAT                 [given_C.type ] )
   (using given_QPR : QuotesQuasiPathRefs1[given_C.type ] )
: AnyRef with {
   ;

   import quotes.reflect.{Singleton as _ , *}

   export given_FTE.{*, given}

   export given_CAT.{*, given}

   export given_QPR.{*, given}

}

protected
trait ConstructsImpl
{
   this : WithSplCtxImpl[?] =>
   ;

   import quotes.reflect.{Singleton as _ , *}

   // val fetCciSplCtx
   // : splCtx.type
   // = splCtx

   private[ConstructsImpl ]
   val peer1
   = summon[ConstructsImplAlt[splCtx.type ] ] 

   export peer1.{*, given }

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
            //

            /** 
             * 'case object's.
             * 
             * for some reason,
             * those two flag-checks
             * did not reject
             * (ie in a `case`-like setting) pattern-binding whose "underlying type" happen to conform to `case object` ST(s), so
             * an additional check will be necessary
             * 
             */
            case s: (ValDef | DefDef) if (
               (
                  (s.symbol.flags is Flags.Module) && (s.symbol.flags is Flags.Case)
               )
               &&
               (
                  Printer.TreeShortCode.show(s )
                  .matches("\\w+")
                  /* uh oh, it's a wrong one */
                  .unary_!
               )
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

   object TrueValDef {
      def unapply
         (tree: ValDef )
      = {
         Some(tree)
         .collect({
            case tree @ (_ : ValDef) if { !(tree.symbol.flags is Flags.Mutable ) } =>
               tree
         })
      }
   }

   object SingleArgTerm {
      def unapply
         //
         (s: Term )
      = {
         Some(s.asExpr )
         .collect({
            case SingleArgExpr(e) =>
               e.asTerm
         })
      }
   }
   object SingleArgExpr {
      def unapply
         //
         [T ]
         (s: Expr[T] )
      = {
         Some(s)
         .flatMap({
            case Varargs(e) =>
               None
            case e =>
               Some(e)
         })
      }
   }

}

















val _ = {}
