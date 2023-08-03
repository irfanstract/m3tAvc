package avcframewrk.forms















object Promptibility {

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
   object ResponseFormat {

      trait Ops
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
      with Ops
      {
         this : Ops =>

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

      case object ofUnit extends
      Ops
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
      Ops
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
      case object ofUtf extends Ops
      {

         type XValue
            >: String
            <: String

         extension (value: XValue ) {

            def isPositive
            : true
            = true

            def isNegative
            : false
            = false

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
         : (ResponseFormat.Ops { type XValue >: RV <: RV } )
         ,
         
      )
      extends
      Ops
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

      //

   }

}

object Response {

   final
   lazy val XAlgebraicFormat
   : Question.ResponseFormat.type
   = Question.ResponseFormat

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


















