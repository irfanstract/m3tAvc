package avcframewrk.forms

package templating













trait AcsfLabelledCallbackTranslator[+M]
extends
AnyRef
with AcsfTitleIndependentCodings1
with AcsfReadinessIndCodings1
with AcsfDispatchTimeCtxIndependentCodings1
with AcsfReturnIndependentCodings1
{

   //

   def apply
      [
         //
         AcModelState ,
         IsReady : CReadinessCoding ,
         Title : TitleCoding ,
         P : CallbackCtxCoding ,
         R : ReturnCoding ,

      ]
      (
         //
         internalStateOption : avcframewrk.evm.AsyncAlgebraicMonad[AcModelState]
         = { monix.reactive.Observable(true ) }
         ,
         isReadyState : AcModelState => IsReady
         = identity[Any => Unit ](_ => {} )
         ,
         baseTitle: Title
         ,
         updatedTitle: (baseTitle: Title, internalState: AcModelState ) => Title
         = (baseTitle: Title, s: AcModelState ) => baseTitle
         ,
      )
      (doTheMainThing: PartialFunction[P, R] )
      : M

} // AcsfLabelledCallbackTranslator

object AcsfLabelledCallbackTranslator
{

   //

   private[AcsfLabelledCallbackTranslator]
   trait XCommonApcGivens extends
   AnyRef
   with AcsfTitleIndependentCodings1
   with AcsfReadinessIndCodings1
   with AcsfDispatchTimeCtxIndependentCodings1
   with AcsfReturnIndependentCodings1
   {
      //

      // TODO
      override
      opaque type TitleCoding[-Value]
         /* made a refinement of `Tuple2` introducing dependent-typing (eg the adapter's param-type is set to `this._1.CAP` ) */
         /* the keyword `CAP` was inspired by the (internal) API `scala.runtime.TypeBox`, which Scala 3 relied on */
         <: ({ type CAP >: Value    }, Nothing => String ) { val _2 : (value: _1.CAP) => (value.type & String ) }
         =  ({ type CAP >: Value    }, Nothing => String ) { val _2 : (value: _1.CAP) => (value.type & String ) }
      override
      implicit
      def stringAcTitling[Value <: String]
      = {
         val tb1 = new AnyRef().asInstanceOf[{ type CAP >: Value <: Value }]
         identity[(tb1.type, (value: tb1.CAP) => (value.type & String ) )]((
            tb1 ,
            (e) => e ,
         ))
      }

      export AcsfReadinessIndCodings1.whichTranslatesToHalfs.{*, given}

      export AcReturnIndependentCodings1.whichTranslatesToEitheres.{*, given}

      case class Puv[+R](src: avcframewrk.evm.AsyncAlgebraicMonad[R] )

   }

   /**
    * 
    * factory method
    * 
    * 
    * @param doFinalAdapt   to customise how the resulting itc must be like
    * @param eventAllocator to customise the event obj instantiations
    * 
    */
   def apply
      [R]
      (
         /* to free users from these complexities, we're giving defaults for these params */

         //
         eventAllocator : (
            (
               AcCallbackCtxIndependentCodings1,
               Any ,
            ) {
               val _2: [Evt] => (cc: _1.CallbackCtxCoding[Evt] ) => Evt
            }
         )
         = {
            val ccx = AcCallbackCtxIndependentCodings1.ofOpcev
            identity[(
               (
                  ccx.type,
                  Any,
               ) {
                  val _2: [Evt] => (cc: _1.CallbackCtxCoding[Evt] ) => Evt
               }
            )]((
               ccx
               ,
               [Evt] => (cc: ccx.CallbackCtxCoding[Evt] ) => cc.apply()
               ,
            ))
         }
         ,

         //
         doFinalAdapt: (
            (
               //
               labelFrp: XCommonApcGivens#Puv[String],
               
               run: () => Either[Unit | Throwable, Unit] ,

               pr: (
                  (Any, Any) & /* needs to be separated, otherwise causing failure "recursion limit exceeded" */
                  {
                     val _1 : { type State ; type Title >: String <: String }
                     val _2: (
                        avcframewrk.evm.AsyncAlgebraicMonad[_1.State] ,
                        _1.State => (0 | 0.5 | 1 ) ,
                        _1.Title ,
                        (baseTitle: _1.Title, newState: _1.State) => (_1.Title) ,
                     ) 
                  }
               )
               ,

            ) =>
            R 
         )
         = (_, run, _) => (() => { val res = run() ; res.getOrThrow() } )
         ,
         
      )
   =
      new AcsfLabelledCallbackTranslator[R ]
      with XCommonApcGivens
      {
         //

         ;

         export eventAllocator._1.{*, given}

         ;

         override
         def apply
            [
               //
               AcModelState ,
               IsReady : CReadinessCoding ,
               Title : TitleCoding ,
               P : CallbackCtxCoding ,
               R : ReturnCoding ,

            ]
            (
               //
               internalStateOption : avcframewrk.evm.AsyncAlgebraicMonad[AcModelState]
               ,
               isReadyState : AcModelState => IsReady
               ,
               baseTitle: Title
               ,
               updatedTitle: (baseTitle: Title, internalState: AcModelState ) => Title
               ,
            )
            (doTheMainThing: PartialFunction[P, R] )
         = {
            // TODO
            {
               ;

               def newEvent()
               : P
               = {
                  // (summon[CallbackCtxCoding[P] ] ).apply()
                  eventAllocator._2
                  .apply(summon[CallbackCtxCoding[P] ] )
               }

               def tryDoTheMainThing()
               : Either[Unit | Throwable, Unit]
               = {
                  //

                  val evtInfo
                  = newEvent()

                  val returnValue
                  = {
                     doTheMainThing
                     /* convert into a Function which returns `Either[MatchError, R]` */
                     .lift.andThen[Either[MatchError, R] ](o => o.toRight(new MatchError(s"rejected event") ) )
                     /* then apply a `(given ReturnCoding[R] ).flatMap` step */
                     .andThen(o => o.flatMap((r: R) => (summon[ReturnCoding[R] ] ).translate(r ) ) )
                     /* actually run the (lifted) function, yielding an `Either` */
                     .apply(evtInfo )
                  }

                  returnValue
               }

               /**
                * the label.
                * may animate/change/refresh/update over time, evidenced by the iterator being an `AsyncAlgebraicMonad`.
                */
               val updatedLabelOption
               = {
                  internalStateOption
                  .map(state => updatedTitle(baseTitle, state ) )
                  .map((summon[TitleCoding[Title] ] )._2 )
               }

               /**
                * return a possibly-adapted form
                */
               doFinalAdapt(
                  //
                  labelFrp = Puv(updatedLabelOption) ,
                  run = () => tryDoTheMainThing() ,
                  pr = {
                     val _1 = new AnyRef().asInstanceOf[{ type State >: AcModelState <: AcModelState ; type Title >: String <: String }]
                     val _2 = {
                        identity[(
                           //
                           
                           avcframewrk.evm.AsyncAlgebraicMonad[_1.State] ,
                           _1.State => (0 | 0.5 | 1 ) ,
                           _1.Title ,
                           (baseTitle: _1.Title, newState: _1.State) => (_1.Title) ,

                        ) ]((
                           internalStateOption
                           ,
                           isReadyState
                              .andThen((summon[CReadinessCoding[IsReady ] ] ).translate _ )
                           ,
                           summon[TitleCoding[Title] ]
                              ._2
                              .apply(baseTitle )
                           ,
                           // TODO
                           (_, _) => {
                              ;
                              summon[TitleCoding[Title] ]
                                 ._2
                                 .apply(baseTitle )
                           }
                           ,
                        ))
                     }
                     identity[(_1.type, _2.type)](_1, _2)
                  } ,
                  
               )
            }
         }

      } 
      // def apply[R](Function2)

   extension [R](res: Either[Unit | Throwable, R] ) {

      def getOrThrow()
      : R
      = res.left.map({ case z : Throwable => z ; case () => new Exception(s"idiopathic failure") }).toTry.get

   }

} // AcsfLabelledCallbackTranslator$

type AcsfTitleIndependentCodings1
= AcTitleIndependentCodings1

trait AcsfReadinessIndCodings1
extends
AnyRef
{

   //

   type CReadinessCoding[-R]

   /** one states, always "totally ready" */
   given cRdnssu
   : CReadinessCoding[Unit]

   /** two states -- "not ready" and "totally ready" */
   given cRdnsBi
   : CReadinessCoding[Boolean]

   /** three states -- "not ready" and "partially ready" and "totally ready" */
   given cRdnsFrc
   : CReadinessCoding[0 | 0.5d | 1 ]

} // AcsfReadinessIndCodings1

object AcsfReadinessIndCodings1
{

   //

   /**
    * 
    * a default implementation which coerces into enum of three FP values `0`, `0.5`, `1`
    * 
    * your code can simply `export` everything from here:
    * ```
    * trait Action .........
    * 
    * object Action extends AcsfReadinessIndCodings1 {
    *    export AcsfReadinessIndCodings1.ReturnCoding
    *    export AcsfReadinessIndCodings1.{given }
    * }
    * ```
    * 
    */
   object whichTranslatesToHalfs
   extends
   AcsfReadinessIndCodings1
   {

      //

      trait CReadinessCoding[-P ]
      { def translate(value0: P ): 0 | 0.5 | 1 }

      /** one states, always "totally ready" */
      override
      given cRdnssu
      : CReadinessCoding[Unit]
      with { override def translate(value: Unit ): 1 = 1 }

      /** two states -- "not ready" and "totally ready" */
      override
      given cRdnsBi
      : CReadinessCoding[Boolean]
      with {

         type Translated[V <: Boolean]
            <: 0 | 1
            = V match { case true => 1 case false => 0 }

         override
         def translate(value: Boolean )
         : Translated[value.type]
         = {
            (value match { case true => 1 ; case false => 0 } )
            .asInstanceOf[Translated[value.type] ] // TODO remove this LOC if possible
         }

      }

      /** three states -- "not ready" and "partially ready" and "totally ready" */
      override
      given cRdnsFrc
      : CReadinessCoding[0 | 0.5 | 1 ]
      with { override def translate(value: 0 | 0.5 | 1 ): value.type = value }

   }

} // AcsfReadinessIndCodings1$

// trait AcsfReadinessListenability1
// extends
// AnyRef
// {
//    this : (
//       AnyRef
//       & AcsfTitleIndependentCodings1
//    ) =>

//    //

//    extension [Title : TitleCoding](key: Title)
//       def readinessOption
//       : avcframewrk.evm.AsyncAlgebraicMonad[0 | 0.5d | 1 ]

// }

type AcsfDispatchTimeCtxIndependentCodings1
= AcCallbackCtxIndependentCodings1

type AcsfReturnIndependentCodings1
= AcReturnIndependentCodings1















