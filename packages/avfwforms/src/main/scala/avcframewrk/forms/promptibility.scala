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

      }

      case object ofUnit extends Ops
      {

         type XValue
            >: Unit
            <: Unit

      }

      case object ofBoolean extends Ops
      {

         type XValue
            >: Boolean
            <: Boolean

      }

      @deprecated
      case object ofUtf extends Ops
      {

         type XValue
            >: String
            <: String

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
      {

         import annotation.unchecked.uncheckedVariance

         type XValue
            >: Either[LV , RV ]
            <: Either[LV , RV ]

      } /* `OfOptional` */

      //

   }

}

object Response {

   final
   lazy val AlgebraicFormat
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


















