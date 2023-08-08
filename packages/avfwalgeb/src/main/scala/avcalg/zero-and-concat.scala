package avcalg
















trait Concatenability[C ](using peer : cats.Semigroup[C] )
extends
AnyRef
{

   transparent inline /* needs to be `transparent` to avoid the need for explicit (re)ovd/def */
   def reverse
   = peer.reverse

}

trait ConcatenabilityK[C[_] ](using peer : cats.SemigroupK[C] )
extends
AnyRef
{

   transparent inline /* needs to be `transparent` to avoid the need for explicit (re)ovd/def */
   def reverse
   = peer.reverse

}

given [C    ](using peer : cats.Semigroup[C]  ) : Concatenability[C] with {}

given [C[_] ](using peer : cats.SemigroupK[C] ) : ConcatenabilityK[C] with {}

trait CBC[C ](using peer : cats.Monoid[C] )
extends
AnyRef
with Concatenability[C ]
{

   transparent inline /* needs to be `transparent` to avoid the need for explicit (re)ovd/def */
   def empty
   = peer.empty

}

trait CBCK[C[_] ](using peer : cats.MonoidK[C] )
extends
AnyRef
with ConcatenabilityK[C ]
{

   transparent inline /* needs to be `transparent` to avoid the need for explicit (re)ovd/def */
   def empty[E]
   = peer.empty[E]

}

given [C    ](using peer : cats.Monoid[C]  ) : CBC[C] with {}

given [C[_] ](using peer : cats.MonoidK[C]  ) : CBCK[C] with {}



















val _ = {}
