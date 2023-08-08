package avcalg

















// export cats.{Functor   =>       ItemWiseTransformability    }
// export cats.{Functor   =>    ElementWiseTransformability    }
// export cats.{Monad     =>       ItemWiseUnfoldability       }
// export cats.{Monad     =>    ElementWiseUnfoldability       }
// export cats.{Monad     =>           ListUnfoldability       }
// export cats.{Monad     =>             LsUnfoldability       }

trait ItemWiseTransformability[CC[_] ](using catsFunctorCc : cats.Functor[CC] )
extends
AnyRef
{

   extension [E](e: CC[E] ) {

      private
      def toFunctorOps = { cats.syntax.all.toFunctorOps(e)(using catsFunctorCc ) }

      export toFunctorOps.{self as _, typeClassInstance as _, TypeClassType as _, * }

   }
   
}

trait ItemWiseUnfoldability[CC[_] ](using catsMonadCc : cats.Monad[CC] )
extends
AnyRef
with ItemWiseTransformability[CC]
{

   extension [E](e: CC[E] ) {

      private
      def toFlatMapOps = { cats.syntax.all.toFlatMapOps(e)(using catsMonadCc ) }

      export toFlatMapOps.{self as _, typeClassInstance as _, TypeClassType as _, * }

      //

   }

}

type ElementWiseTransformability[CC[_] ]
   = ItemWiseTransformability[CC ]

type ElementWiseUnfoldability[CC[_] ]
   = ItemWiseUnfoldability[CC ]

given [CC[_] ](using cats.Functor[CC] )
: AnyRef with ItemWiseTransformability[CC ] with {}

given [CC[_] ](using cats.Monad[CC] )
: AnyRef with ItemWiseUnfoldability[CC] with {}

// export cats.{Foldable      =>       LsFoldability        }
// export cats.{Foldable      =>     ListFoldability        }
// export cats.{Reducible     =>       LsReducibility       }
// export cats.{Reducible     =>     ListReducibility       }

trait ListFoldability[CC[_] ](using catsFoldableCc : cats.Foldable[CC] )
extends
AnyRef
{

   extension [E](e: CC[E] ) {

      private
      def toFoldableOps = { cats.syntax.all.toFoldableOps(e)(using catsFoldableCc) }

      export toFoldableOps.{self as _, typeClassInstance as _, TypeClassType as _, * }

      //

   }

}

trait ListReducibility[CC[_] ](using catsReduxCc : cats.Reducible[CC] )
extends
AnyRef
{

}

given [CC[_] ](using cats.Foldable[CC] )
: AnyRef with ListFoldability[CC ] with {}

given [CC[_] ](using cats.Reducible[CC] )
: AnyRef with ListReducibility[CC ] with {}


















val _ = {}
