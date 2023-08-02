package avcframewrk.evm.xutil









/**
 * 
 * `{ type Main[+E] <: collection.WithFilter[E, Main ] }`
 * 
 */
type CwfMonadTypeAsMain
   = { type Main[+E] <: collection.WithFilter[E, Main ] }

// /**
//  * 
//  * defines `collect` for `definer.Main[?]`.
//  * 
//  */
// case class CwfMonadCollectivity[
//    +Definer <: Singleton & CwfMonadTypeAsMain ,

// ](definer: Definer )
// {

//    extension[E0] (s: definer.Main[E0] )
//    {

//       def collect[E2] (f: PartialFunction[E0, E2] )
//       : definer.Main[E2]
//       = {

//          s
//          .flatMap(e0 => {
//             f
//             .andThen[Some[E2] ](e20 => Some(e20) )
//             .applyOrElse[E0, Option[E2] ](e0, _ => None )
//          } )
//       }

//    }

// }
















