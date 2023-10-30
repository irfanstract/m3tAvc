package avcalculus

package trig
















package LmMatrix {
   ;

   case class Of3Times3
      [+ValueAll <: DataOf3Times3[Any] ]
      (data: ValueAll )
   {
      export data.{_1 as r0c0, _2 as r0c1, _3 as r0c2 }
      export data.{_4 as r1c0, _5 as r1c1, _6 as r1c2 }
      export data.{_7 as r2c0, _8 as r2c1, _9 as r2c2 }

      // transparent inline
      // def valueAt(row: Int, col: Int)
      // = {
      //    (row) match {
      //       case 0 => (data._1, data._2, data._3)
      //    }
      // }
   }

   type DataOf3Times3[+E]
   >: (E, E, E,   E, E, E,   E, E, E )
   <: (E, E, E,   E, E, E,   E, E, E )

   ;
}

package LinearMap {
   ;

   object implicits {
      ;

      import LmMatrix.DataOf3Times3

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
}

// type LmNumeric[Value]
// = LmNumericLU[Value, Value ]

// type LmNumericLU[-ValueL <: ValueU, +ValueU]
// >: Numeric[? >: ValueL <: ValueU] & { type Underlying >: ValueL <: ValueU }
// <: Numeric[? >: ValueL <: ValueU] & { type Underlying >: ValueL <: ValueU }

// trait LinearMapC
// {
//    ;

//    // implicit
//    val ctxtualNumeric
//    : LmNumericLU[Nothing, Any]

//    object Of3Times3 {
//       type _Any = LmMatrix.Of3Times3[LmMatrix.DataOf3Times3[ctxtualNumeric.Underlying ] ]
//    }

//    ;
// }













