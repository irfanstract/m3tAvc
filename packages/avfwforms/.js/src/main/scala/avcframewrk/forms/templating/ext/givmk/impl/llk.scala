package avcframewrk.forms

package templating

package ext.givmk

package impl
















// private
// transparent
// inline
// def smImplTest1
//    [Value]
//    (inline value: Value)
// = ${smImpl[Int, String, Value ] ('{ value } ) }

// private
// def smImpl
//    //
//    [
//       K : quoted.Type ,
//       BoxV : quoted.Type ,
//       CompatibleK[v] <: K : quoted.Type ,
//       ByVBoxV[v] <: BoxV : quoted.Type ,
//       // KCompVImplFncT : quoted.Type ,
//    ]
//    (using quoted.Quotes)
//    (initialiserFncExpr: quoted.Expr[[V] => (key: CompatibleK[V]) => ByVBoxV[V] ] )
// = {
//    ' {
//       ;

//       trait S1
//       extends
//       AnyRef
//       with Selectable
//       with LlEaKoT
//       {
//          ;

//          ;

//          override
//          type KeyObjTrait
//          >: K
//          <: K

//          protected
//          val cache
//          = {
//             newJsWeakMap[KeyObjTrait , BoxV ]
//          }

//          // inline
//          def apply
//             [
//                V
//                ,
//             ]
//             (key: CompatibleK[V] )
//          = {
//             cache.updateWith(key )(o => {
//                o
//                .orElse({
//                   ( ${ initialiserFncExpr } )
//                   .apply(key )
//                } pipeLooseSelf(Some(_) ) )
//             } )
//             .get
//             // .pretendedAsForT[V]
//             .asInstanceOf[ByVBoxV[V] ] 
//          }

//          // // @deprecated
//          // val initFnc = ${ initialiserFncExpr }

//          // export initFnc.{*}

//          ;
//       }

//       new AnyRef with Selectable with S1
//    }
// }















val _ = {}
