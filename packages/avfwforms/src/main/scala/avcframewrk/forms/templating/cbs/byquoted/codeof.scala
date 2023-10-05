package avcframewrk.forms

package templating

package cbs

package byquoted
















transparent
inline
def codeOf
   [A]
   (inline e: A)
   : String
   = {
      ${ codeForExprM('e ) }
   }

// inline
private[templating]
def codeForExprM
   [
      A : quoted.Type
      ,
   ]
   (using quotes : quoted.Quotes )
   (e: quoted.Expr[A] )
= quoted.Expr { (e).codeI() }





/** 
 * a supposedly human-readable repr
 * 
 */
transparent
inline
def evAstOf
   [A]
   (inline e: A)
   : String
   = {
      ${ evAstOfEvM('e ) }
   }

/** 
 * a supposedly human-readable repr
 * 
 */
// inline
private[templating]
def evAstOfEvM
   [
      A : quoted.Type
      ,
   ]
   (using quotes : quoted.Quotes )
   (e: quoted.Expr[A] )
= quoted.Expr {
   val e1 = {
      e
      // '{ (identity[(e: Any) => e.type ](e => e ) )(${e } ) }
   }
   (e1).toSyntaxTree1()
}






extension
   //
   [
      A : quoted.Type
      ,
   ]
   (e: quoted.Expr[A] )
{
   //

   /** 
    * a code/snippet supposed to end up on equivalent Expr
    * 
    */
   def codeI
      //
      (using quotes : quoted.Quotes )
      ()
   : String
   = {
      ;

      (e)
      .toPrintedExpr1Impl1(printMode = quotes.reflect.Printer.TreeCode )
   }

   /** 
    * a supposedly human-readable repr
    * 
    */
   def toSyntaxTree1
      //
      (using quotes : quoted.Quotes )
      ()
   : String
   = {
      ;

      (e)
      .toPrintedExpr1Impl1(printMode = quotes.reflect.Printer.TreeStructure )
   }

   def toPrintedExpr1Impl1
      //
      (using quotes : quoted.Quotes )
      (
         //
         printMode
         : quotes.reflect.Printer[quotes.reflect.Tree ] 
         ,
      )
   // : quoted.Expr[String]
   = {
      ;

      ;
      val expr = {
         ;

         import quoted.{quotes => _, *}
         import quotes.*

         import reflect.*

         // reflect.TreePrinter.show(reflect.asTerm(e ) )
         printMode.show(e.asTerm )
      }

      // '{ compiletime.codeOf(${e } ) }
      (expr )
   }

   //
}





extension
   //
   [
      A : quoted.Type
      ,
   ]
   (using quotes : quoted.Quotes )
   (e: quoted.Expr[A] )
{
   //

   def iceeInspImpl1
      //
      (
         //
         // printMode: quotes.reflect.Printer[quotes.reflect.Tree ] 
      )
   : quoted.Expr[Option[A] ]
   = {
      ;

      ;
      val valueOption = {
         ;

         import quoted.{quotes => _, *}
         import quotes.*

         import reflect.*

         // reflect.TreePrinter.show(reflect.asTerm(e ) )
         Some(e.asTerm )
         .collect({ case Literal(e) => e })
      }

      val exprOption
      = {
         valueOption
         .map(v => {
            ;

            import quoted.{quotes => _, *}
            import quotes.*

            import reflect.*

            '{ (${Literal(v ).asExpr.assertedNowAs[A] } ) }
         } )
         .fold[quoted.Expr[Option[A] ] ]('{ None } )(e => '{ Some(${e }) } )
      }

      // '{ compiletime.codeOf(${e } ) }
      exprOption
   }

   //
}

implicit class QuotedExprAssertedOrCastAsTOps
   //
   [S : quoted.Type ]
   (using quoted.Quotes )
   (impl: quoted.Expr[S] )
{
   //

   import quoted.*
   import quotes.*

   import reflect.*

   /** 
    * `${impl.asExprOf[A] }`
    * 
    */
   def assertedNowAs
      //
      [A : Type ]
   : Expr[A]
   = {
      impl
      .asExprOf[A]
   }

   /** 
    * `${impl } : A`
    * 
    */
   def assertedLaterAs
      //
      [A : Type ]
   : Expr[A]
   = {
      Typed(impl.asTerm, TypeTree.of[A] )
      .asExprOf[A]
   }

   def asExprInstanceOfPlain
      //
      [A : Type ]
   : Expr[A]
   = {
      '{ ${impl }.asInstanceOf[A] }
   }

   /** 
    * unlike `asExprInstanceOfPlain`,
    * `asExprInstanceOf` strives to maintain the path-dependent typing
    * 
    */
   def asExprInstanceOf
      //
      [A : Type ]
   : Expr[S & A]
   = {
      '{
         def castToA
            [E]
            (e: E )
         : e.type & A
         = e.asInstanceOf[e.type & A ]
         castToA(${impl } )
      }
   }

}






/* */
type ExpdExprStringStyle
>: SEvS
<: SEvS

private[templating]
trait SEvS
{
   type R
   val R : (code: String) => R
   extension (e: R)
      def toExpr()
      : quoted.Expr[String]
}

def SEvS_E
   //
   (using qq : quoted.Quotes )
= {

   import quoted.*
   import quoted.quotes
   import quotes.*

   import reflect.*

   new
   Selectable
   with
   SEvS
   {
      type R
      >: Expr[String]
      <: Expr[String]
      val R
      = (code: String) => Expr(code)
      extension (e: R)
         def toExpr() = e
   }
}

















val _ = {}
