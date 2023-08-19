package avcalg
















trait Concatenability[C ](using peer : cats.Semigroup[C] )
extends
AnyRef
{

   object ConcatenabilityCatsInfix {
   //

   extension (receiver: C ) {

      private
      def impl = { cats.syntax.all.catsSyntaxSemigroup(receiver)(using peer ) }

      export impl.{self as _, typeClassInstance as _, TypeClassType as _, * }

   }

   } // ConcatenabilityCatsInfix$

   export ConcatenabilityCatsInfix.{combine => andThen }
   export ConcatenabilityCatsInfix.{`|+|` => plus }
   export ConcatenabilityCatsInfix.{`|+|` => `++` }
   export ConcatenabilityCatsInfix.{|+| }

   extension (n: Int) def *: (receiver: C ) = { import ConcatenabilityCatsInfix.* ; peer.combineN(receiver, n ) }
   extension (n: Int) def *  (receiver: C ) = { import ConcatenabilityCatsInfix.* ; peer.combineN(receiver, n ) }

   transparent inline /* needs to be `transparent` to avoid the need for explicit (re)ovd/def */
   def reverse
   = peer.reverse

}

trait ConcatenabilityK[C[_] ](using peer : cats.SemigroupK[C] )
extends
AnyRef
{

   object ConcatenabilityKCatsInfix {
   //

   extension [E](receiver: C[E] ) {

      private
      def impl = { cats.syntax.all.toSemigroupKOps(receiver)(using peer ) }

      export impl.{self as _, typeClassInstance as _, TypeClassType as _, * }

   }

   } // ConcatenabilityKCatsInfix$

   export ConcatenabilityKCatsInfix.{combineK => andThen }
   export ConcatenabilityKCatsInfix.{`<+>` => plus }
   export ConcatenabilityKCatsInfix.{`<+>` => `++` }
   export ConcatenabilityKCatsInfix.{<+> }

   extension (n: Int) def *:[A] (receiver: C[A] ) = { import ConcatenabilityKCatsInfix.* ; peer.combineNK(receiver, n ) }
   extension (n: Int) def * [A] (receiver: C[A] ) = { import ConcatenabilityKCatsInfix.* ; peer.combineNK(receiver, n ) }

   transparent inline /* needs to be `transparent` to avoid the need for explicit (re)ovd/def */
   def reverse
   = peer.reverse

}

given ConcatenabilityFromCatsSemigroup[C    ](using peer : cats.Semigroup[C]  ) : Concatenability[C] with {}

given ConcatenabilityKFromCatsSemigroupK[C[_] ](using peer : cats.SemigroupK[C] ) : ConcatenabilityK[C] with {}

given CatsSemigroupFromCatsSemigroupK[C[_], E ](using peer : cats.SemigroupK[C] )
: cats.Semigroup[C[E] ] with {

   override
   def combine(opd1: C[E], opd2: C[E] )
   = peer.combineK(opd1, opd2)
   
}

trait CBC[C ](using peer : cats.Monoid[C] )
extends
AnyRef
with Concatenability[C ]
{

   transparent inline /* needs to be `transparent` to avoid the need for explicit (re)ovd/def */
   def empty
   = peer.empty

   extension (receiver: C ) {

      private
      def impl = { cats.syntax.all.catsSyntaxMonoid(receiver)(using peer ) }

      export impl.{self as _, typeClassInstance as _, TypeClassType as _, * }

   }

}

trait CBCK[C[_] ](using peer : cats.MonoidK[C] )
extends
AnyRef
with ConcatenabilityK[C ]
{

   transparent inline /* needs to be `transparent` to avoid the need for explicit (re)ovd/def */
   def empty[E]
   = peer.empty[E]

   // extension [E](receiver: C[E] ) {

   //    private
   //    def impl = { cats.syntax.all.toSemigroupKOps(receiver)(using peer ) }

   //    export impl.{self as _, typeClassInstance as _, TypeClassType as _, * }

   // }

}

given [C    ](using peer : cats.Monoid[C]  ) : CBC[C] with {}

given [C[_] ](using peer : cats.MonoidK[C]  ) : CBCK[C] with {}



















val _ = {}
