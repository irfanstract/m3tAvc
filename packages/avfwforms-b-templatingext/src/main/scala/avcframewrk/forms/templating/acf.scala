package avcframewrk.forms

package templating














trait AcfLabelledCallbackTranslator[+M]
extends
AnyRef
with AcTitleIndependentCodings1
with AcCallbackCtxIndependentCodings1
with AcReturnIndependentCodings1
{

   //

   def apply[
      //
      Title : TitleCoding ,
      P : CallbackCtxCoding ,
      R : ReturnCoding ,

   ](title: Title, callback: PartialFunction[P, R] )
   : M

}

trait AcfgeLabelledCallbackTranslator[+M]
extends
AnyRef
with AcTitleIndependentCodings1
with AcCallbackPFormIndependentCodings1
with AcCallbackCtxIndependentCodings1
with AcReturnIndependentCodings1
{

   //

   def apply[
      //
      Title : TitleCoding ,
      Cb[+R] : CallbackPFormCoding ,
      R : ReturnCoding ,

   ](title: Title, callback: Cb[R] )
   : M

}

trait AcTitleIndependentCodings1
extends
AnyRef
{

   //

   type TitleCoding[-Title ]

   given stringAcTitling[R <: String]
   : TitleCoding[R]

}

object AcTitleIndependentCodings1
{

   //

} // AcTitleIndependentCodings1$

trait AcCallbackCtxIndependentCodings1
extends
AnyRef
{

   //

   /**
    * `CallbackCtxCoding`
    * 
    */
   type CallbackCtxCoding[+CbCtx ]

   /* made not `given` as it didn't play well with type-inference */
   def unitValuedCaseApc
   : CallbackCtxCoding[Unit]

   given productValuedCaseApc
   : CallbackCtxCoding[Product ]

} // AcCallbackCtxIndependentCodings1

object AcCallbackCtxIndependentCodings1
{

   //

   object ofOpcev extends
   AcCallbackCtxIndependentCodings1
   {

      //

      trait CallbackCtxCoding[+Evt ]
      { type Instance <: Evt ; def apply() : Evt }

      given unitValuedCaseApc
      : CallbackCtxCoding[Unit]
      with { opaque type Instance <: Unit = Unit ; def apply() = {} }

      given productValuedCaseApc
      : CallbackCtxCoding[Product & Equals ]
      with { opaque type Instance <: Product & Equals = Product & Equals ; def apply() = { case object clickEventInfo ; clickEventInfo } }

   } // ofOpcev$

} // AcCallbackCtxIndependentCodings1$

trait AcCallbackPFormIndependentCodings1
extends
AnyRef
{
   this : (
      AnyRef
      & AcCallbackCtxIndependentCodings1
   ) =>

   //

   type CallbackPFormCoding[-M[+CbReturnValue ] ]

   given acForNoArg
   : CallbackPFormCoding[[CbReturnValue] =>> (() => CbReturnValue ) ]

   given acForSingleArgConditional[
      CbCtx ,

   ](using CallbackCtxCoding[CbCtx] )
   : CallbackPFormCoding[[CbReturnValue] =>> PartialFunction[CbCtx, CbReturnValue] ]

}

object AcCallbackPFormIndependentCodings1
{

   //

} // AcCallbackPFormIndependentCodings1$

trait AcReturnIndependentCodings1
extends
AnyRef
{

   //

   type ReturnCoding[-CbReturnValue ]

   given acRcUnit
   : ReturnCoding[Unit]
   given acRcOfBoolean[R <: Boolean]
   : ReturnCoding[R]

   given acRcOfEitherRElseUnit[R : ReturnCoding ]
   : ReturnCoding[Either[Unit, R] ]
   given acRcOfAttemptForR[R : ReturnCoding ]
   : ReturnCoding[scala.util.Try[R] ]

}

object AcReturnIndependentCodings1
{

   //

   /**
    * 
    * a default implementation which coerces into `Either`s
    * 
    * your code can simply `export` everything in here:
    * ```
    * new extends AcReturnIndependentCodings1 {
    *    export AcReturnIndependentCodings1.ReturnCoding
    *    export AcReturnIndependentCodings1.{given }
    * }
    * ```
    * 
    */
   object whichTranslatesToEitheres
   extends
   AcReturnIndependentCodings1
   {

      trait ReturnCoding[-Value ] { def translate(value: Value) : Either[Unit | Throwable, Unit ] }

      given acRcUnit
      : ReturnCoding[Unit]
      with { override def translate(value: Unit): Right[Nothing, Unit] = Right(value ) }

      given acRcOfBoolean[R <: Boolean]
      : ReturnCoding[R]
      with { override transparent inline def translate(value: R) = { if value then Right(() ) else Left(new Exception ) } }

      given acRcOfEitherRElseUnit[R : ReturnCoding ]
      : ReturnCoding[Either[Unit, R] ]
      with { override def translate(value: Either[Unit, R] ) = value map (_ => {} ) }

      given acRcOfAttemptForR[R : ReturnCoding ]
      : ReturnCoding[scala.util.Try[R] ]
      with { override def translate(value: scala.util.Try[R]) = { ; value.toEither.flatMap((summon[ReturnCoding[R] ] ).translate _ ) } }

   }

} // AcReturnIndependentCodings1$














val _ = {}
