package avcframewrk.util

val _ = {}













case class InitialityFor[+T] protected (instance: T )

object InitialityFor {

   def apply[T](using impl : InitialityFor[T] )(using DummyImplicit )
   : impl.instance.type
   = impl.instance

   given [T >: "" <: String]
      : InitialityFor[T]
      = byValue(instance = "")
   
   given [T : Numeric]
      : InitialityFor[T]
      = byValue(instance = { Numeric[T].zero }.ss )
   
   given [T >: Unit <: Unit]
      : InitialityFor[Unit]
      = byValue(instance = ().ss )
   
   given [CC <: [_] =>> Any, E ](using CC1 : collection.Factory[E, CC[E] ] )
      : InitialityFor[CC[E] ]
      = byValue(instance = { CC1 fromSpecific(Seq() ) }.ss )

   /* workaround */
   extension [C](c: C) {

      def ss
         : C & Singleton
         = c

   }
   
   def byValue[T](instance: T )
      = new InitialityFor[instance.type](instance = instance )

}

val _ = {

   { val r = summon[InitialityFor[String ] ] ; assert(r.instance == "" ) }

   { val r = summon[InitialityFor[Int ] ] ; assert(r.instance == 0 ) }

   { val r = summon[InitialityFor[Double ] ] }

} : Unit

type ConcatenabilityOfTwo[T]
   = ConcatenabilityOf[T]

object ConcatenabilityOf {

   def apply[T](using impl : ConcatenabilityOf[T] )
   : impl.type
   = impl

   given ConcatenabilityOf[String] with {

   extension (lhs: String) def plus(rhs: String) = StringConcatImpl(lhs, rhs )

   }
   
}

trait ConcatenabilityOf[T]
{

   extension (lhs: T) def plus(rhs: T) : T

   extension (lhs: T) transparent inline def ++(rhs: T)
      = lhs plus rhs

   extension (lhs: T) transparent inline def +(rhs: T)
      = lhs plus rhs

}

type ConcatenabilityBetween[T]
   = ConcatenabilityOf[T]

@deprecated
type Concatenability[T]
   = ConcatenabilityOf[T]

val _ = {

   def m1(using Concatenability[String])() = {

      "" plus ""

   }

} : Unit

object StringConcatImpl {

   transparent inline
   def apply(v1: String, v2: String) = v1 + v2

}


















