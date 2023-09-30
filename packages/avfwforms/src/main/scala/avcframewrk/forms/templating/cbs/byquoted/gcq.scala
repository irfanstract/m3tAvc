package avcframewrk.forms

package templating

package cbs

package byquoted














@deprecated
transparent
inline
def gcq
= ${gcqImpl() }

private
def gcqImpl
   ()
   (using quoted.Quotes)
: quoted.Expr[String]
= {
   val s
   : String
   = evAstOf({ '{ "using 'scala.quoted.*' in our app" } })
   quoted.Expr[String] (s )
}

transparent
inline
def fromCode
   (code: String )
   (using quoted.Quotes)
: quoted.Expr[Any]
= {
   ;

   quoted.quotes.asInstanceOf[quoted.runtime.QuoteUnpickler]
   .unpickleExprV2[Any](code, types = null, termHole = null )
   // quote(code ).apply(summon[quoted.Quotes ] )
}

/**
 * tries to
 * assert the lexical-independence of the receiving expr
 * -
 * *which'd be violated by having refs to locally-defined syms in the quote*
 * 
 */
transparent
inline
def asFcRedone
   [V]
   (inline r: V)
   // (using idIng : FcrIdIng )
: V
= ${
   asFcRedoneImpl('r )
}

// given FcrIdIng
// : AnyRef with { val idFieldValue = scala.math.random() }

object asFcRedoneImpl
{
   ;

   import quoted.{Expr}

   def apply
      [
         V
         : quoted.Type
         ,
         // Id
         // <: Matchable
         // : quoted.FromExpr
         // : quoted.ToExpr
         // ,
      ]
      // (id : Id )
      (e : quoted.Expr[V])
      (using quoted.Quotes )
   = {
      import quoted.quotes.reflect.Symbol
      ;
      val id
      = {
         // TODO
         Symbol.spliceOwner.fullName
      }
      val idExpr = Expr(id)
      ;
      '{
         ;
         (() => { ${ put[V] (idExpr )(e ) } ; ${ popOut[V](idExpr) } } )
         .apply()
      }
   }

   private
   def put
      //
      [
         V
         : quoted.Type
         ,
      ]
      (
         //
         idExpr : Expr[String]
         ,
      )
      (
         //
         mainExpr : Expr[V]
         ,
      )
      (using quoted.Quotes )
   = {
      ;
      Expr.put(Expr.unapply(idExpr ).get )(mainExpr )
   }

   private
   def popOut
      //
      [
         V
         : quoted.Type
         ,
      ]
      (
         //
         idExpr : Expr[String]
         ,
      )
      (using quoted.Quotes )
   = {
      ;
      /** 
       * 
       * enforcing a splice
       */
      '{ ${idExpr } ; ${ Expr.get[V](Expr.unapply(idExpr ).get ) } }
   }


   ;
}

var lastFcRi
: Option[(Matchable, quoted.Expr[Any] )]
= None

extension
   //
   (tout: quoted.Expr.type )
   (using quoted.Quotes)
{
   //

   private[templating]
   def put
      //
      [
         Id <: Matchable
         ,
         V : quoted.Type
         ,
      ]
      (id: Id )
      (rExp: quoted.Expr[V])
   : quoted.Expr[Unit]
   = {
      lastFcRi = Some((id, rExp ))
      '{ if true then {} }
   }

   //

   private[templating]
   def get
      //
      [
         // Id <: Matchable
         // ,
         V : quoted.Type
         ,
      ]
      (id: Matchable )
      // (rExp: quoted.Expr[V])
   = {
      val Some(vPair @ (id, _) ) = lastFcRi.orElse(throw new IllegalStateException )
      vPair
      ._2
      .asExprOf[V]
   }

   //
}

/**
 * tries to
 * pickle the Expr and then unpickle back
 * 
 */
@annotation.experimental
// private
def reUnpickle
   [V : quoted.Type ]
   (using quoted.Quotes)
   (rExp: quoted.Expr[V])
: quoted.Expr[V]
= {
   ;
   rExp
   match { case e => e.codeI() }
   match { case code => fromCode(code ) }
   match { case e => e.asExprOf[V] }
}



















val _ = {}
