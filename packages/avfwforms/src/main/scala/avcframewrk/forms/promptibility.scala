package avcframewrk.forms















object Promptibility {

   object XDispatcher
   {

   } /* `XDispatcher$` */

}

type HeadlineInspectiveExtension[-C]
   = HeadlineInspectiveExtensiveOps[? >: C]

trait HeadlineInspectiveExtensiveOps[C]
{

   extension (c: C)
      def headline
      : ItsHeadline[c.type]

   type ItsHeadline[+c <: InstanceOf[C] ]
      <: InstanceOf[Any ]

} /* `HeadlineInspectiveExtensiveOps` */

/* 
 * 
 * 
 * 
 * 
 * 
 */

object Question {

   type HeadlineExtractor[-C]
      = HeadlineInspectiveExtension[C]

   type ResolverExtractor[-C <: Any]
      = ResolutiveExtension[C]

   trait AcceptableResponseFormatDescExtractor[C <: Any]
   {

      extension (c: C)
         def responseFormat
         : ItsAcceptableResponseFormatDesc[c.type]

      type ItsAcceptableResponseFormatDesc[+c <: InstanceOf[C] ]
         <: InstanceOf[ResponseFormat.Ops ]

   }

   /**
    * 
    * describes the type/kind of the expected response.
    * 
    */
   final
   lazy val ResponseFormat
      : IResponseFormat.type
      = IResponseFormat

}

/**
 * 
 * describes the type/kind of the expected response.
 * 
 */
final
lazy val ResponseFormat
   : IResponseFormat.type
   = IResponseFormat

object Response {

}

type ResolutiveExtension[-C <: Any]
   = ResolutiveExtensionOps[? >: C]

trait ResolutiveExtensionOps[C <: Any]
{

   extension (c: C)
      def resolver
      : ItsResolver[c.type]

   type ItsResolver[+c <: InstanceOf[C] ]
      <: InstanceOf[Any]

} /* ResolutiveExtensionOps */

/* 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */



protected
object IResponseFormat
{ ResponseFormat =>

   sealed
   trait Ops

   trait XAlgebraicCaseOps
   extends
   Ops
   {

      type XValue

      extension (value: XValue ) {

         def isPositive
         : Boolean

         def isNegative
         : Boolean

      }

   }

   /**
    * 
    * for nullable cases
    * 
    * rather than
    * resorting to
    * `Option` which does not provide any way to propagate "the failing-case details",
    * we
    * strive for `Either` which is as polymorphic as necessary
    * 
    */
   case class OfOptional[LV, RV](
      //

      positiveCaseScheme
      : (ResponseFormat.XAlgebraicCaseOps { type XValue >: RV <: RV } )
      ,

   )
   extends
   XAlgebraicCaseOps
   with ImplXvi[
      Either[LV , RV ]
      ,
      (e: Either[LV , RV ] ) => e.type
      ,

   ](
      toEither = e => e 
      ,
   )
   {

      lazy val _ = {

         val r01
         = (Right(??? ) : XValue ).isPositive

      } : Unit

   } /* `OfOptional` */

   case object ofUnit extends
   XAlgebraicCaseOps
   with ImplXvi[
      Unit,
      (e: Unit) => Right[Nothing, Unit]
      ,

   ](
      toEither = e => Right(() ) ,
   )
   {

   }

   case object ofBoolean extends
   XAlgebraicCaseOps
   with ImplXvi[
      Boolean,
      (e: Boolean) => OboTrueGivesRightAndFalseGivesLeft[e.type]
      ,

   ](
      toEither = e => oboTryAssertTrue(e) ,
   )
   {

   }

   /* does not throw */
   def oboTryAssertTrue(e: Boolean) : OboTrueGivesRightAndFalseGivesLeft[e.type]
   = {
      e match {
         case (_: true) =>
            Right(() )
         case (_: false) =>
            Left(() )
      }
   }

   type OboTrueGivesRightAndFalseGivesLeft[v <: Boolean]
      <: (Right[Nothing, Any] | Left[Any, Nothing] )
      =
         v match {
            case true => Right[Nothing, Any]
            case false => Left[Any, Nothing]
         } 

   @deprecated
   case object ofUtf extends
   XAlgebraicCaseOps
   with ImplXvi[
      String,
      (e: String) => Right[Nothing, Unit]
      ,

   ](
      toEither = e => Right(() ) ,
   )
   {

   }

   //

   /**
    * 
    * implementative mixin
    * constraining `XValue` to `E` and
    * making those methods `transparent`.
    * 
    */
   protected
   trait ImplXvi[
      E
         <: Any
      ,
      +XPositivityWindow
         <: (e: E) => Either[Any, Any]
      ,

   ](
      toEither : XPositivityWindow
      ,
   )
   extends 
   AnyRef
   with XAlgebraicCaseOps
   {
      this : XAlgebraicCaseOps =>

      type XValue
         >: E
         <: E

      extension (value: XValue ) {

         transparent inline
         def isPositive
         = toEither(value).isRight

         transparent inline
         def isNegative
         = toEither(value).isLeft

      }

      //

   }

} /* `object IResponseFormat` */




















