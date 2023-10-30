package avcalculus

package trig
















package LinearMap {
   ;

   object implicits {
      ;

      import Numeric.Implicits.{*}

      // extension [Nm : Numeric] (lhs: LmMatrix.Of3Times3[DataOf3Times3[Nm] ] )
      //    def *
      //       (rhs: LmMatrix.Of3Times3[DataOf3Times3[Nm] ] )
      //    : LmMatrix.Of3Times3[DataOf3Times3[Nm] ]
      //    = {
      //       LmMatrix.Of3Times3((
      //          lhs.r0c0 * rhs.r0c0 , lhs.r0c1 * rhs.r1c0
      //       ))
      //    }

      ;
   }

   ;

   ;

   object  RowAndColStorageMapper
   {
      ;

      ;

      object InQuotes {
         ;

         import quoted.*

         ;

         type _Any
         = _ImplMono

         opaque type _ForSize1
            [+D <: Tuple ]
         <: _Any
         =  _Any

         opaque type _ForStorageType
            [+D <: Any ]
         <: _Any
         =  _Any

         protected
         opaque type _ImplMono
         // <: AnyRef
         =  (Unit, (coord: (Int, Int) ) => (Quotes) ?=> Expr[?] )

         extension (receiver: _Any ) {
            //
            def forTrcWidenedQuotedTrFnc = receiver._2
            export forTrcWidenedQuotedTrFnc.{apply as translateCoord2DToExpr }
         }

         def fcu
            //
            [E ]
            (dimns: (Int, Int) , fnc: (Quotes) ?=> (coord: (Int, Int) ) => Expr[E] )
         : _ForSize1[dimns.type ]
         = {
            (() , (
               ((coord: (Int, Int) ) => (fnc(coord) , () ) : (Quotes ?=> Expr[E] , Unit ) )
               .andThen(([E] => () => (_ : (E, Any) )._1 )() )
            ) )
         }

         type ThreeOf[+E]
         = (E, E, E)

         @annotation.experimental
         inline
         given forRowsEachAsTuple3
            [
               SizeT >: (3, 3) <: (3, 3)
               ,
               E : Type
               ,
               Str >: ThreeOf[ThreeOf[E] ] <: ThreeOf[ThreeOf[E] ]
               : Type
               ,
            ]
         : (_ForSize1[SizeT] & _ForStorageType[Str ] )
         = {
            ;
            val size = compiletime.constValueTuple[SizeT]
            val main
            = {
               ;
               fcu(size, splCtx ?=> (coord: (Int, Int) ) => {
                  import splCtx.reflect.*
                  '{
                     (src: Str) => {
                        ???
                     }
                  }
               } )
            }
            main
         }

         ;
      }

      ;
   }

   ;
}












