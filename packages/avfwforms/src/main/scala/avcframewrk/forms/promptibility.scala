package avcframewrk.forms















object Promptibility {

   object XDispatcher
   {

      type ByNoSpec
         >: ByTAndSubjectAndBlockingnessImpl
         <: ByTAndSubjectAndBlockingnessImpl

      /**
       * 
       * of this form
       * ```
       * [A] -> (subject: Question.XSummedAllView[A ] ) -> (using expectedAsynchronicity: LexicalAsynchronicity)
       * &nbsp;=>
       * expectedAsynchronicity.MainByReturnValue[subject.responseFormat.XValue ]
       * ```
       * 
       */
      trait ByTAndSubjectAndBlockingnessImpl {

         /**
          * 
          * `apply`
          * 
          * 
          * @param main the main action item
          * @param expectedAsynchronicity `LexicalImperativeSynchronicityGiven`
          * 
          */
         def apply
            [
               A <: Product
               ,
            ]
            (
               main
               : (
                  // A
                  Question.XSummedAllView[A ]
                  // Any
               )
               ,
            )
            (using
               expectedAsynchronicity
               : LexicalAsynchronicity
               ,
            )
            : (
               expectedAsynchronicity.MainByReturnValue[main.responseFormat.XValue ]

            ) // r

      }

   } /* `XDispatcher$` */

   type DeferredReturn[+R]
      <: (DummyImplicit) ?=> R

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

   trait AcceptableResponseFormatDescExtractor[-C <: Any]
   {

      extension (c: C)
         def responseFormat
         : ItsAcceptableResponseFormatDesc[c.type]

      type ItsAcceptableResponseFormatDesc[+c <: InstanceOf[C] ]
         <: InstanceOf[ResponseFormat.Ops ]

   }

   /**
    * 
    * `AcceptableResponseFormatDescExtractor` where
    * the extracted `ResponseFormat` shall also conform to `ResponseFormat.XAlgebraicCaseOps`
    * 
    */
   type AcceptableResponseFormatDescExtractorAlgebraic[-C <: Any]
      <: /* not an alias, just co-incidence */
      (
         AcceptableResponseFormatDescExtractor[C] {

            type ItsAcceptableResponseFormatDesc[+c <: InstanceOf[C] ]
               <: InstanceOf[ResponseFormat.XAlgebraicCaseOps ]
            
         }
      )

   /**
    * 
    * describes the type/kind of the expected response.
    * 
    */
   final
   lazy val ResponseFormat
      : IResponseFormat.type
      = IResponseFormat

   /**
    * 
    * this `implicit class`
    * would
    * avoid the need to list each child/individual `given`s separately and
    * enforce these contract(s) across/between them
    * 
    * the "sum-it-all" view of this instance of a user-selected struct
    * 
    * the itc defined in `XDispatcher`
    * on each call expects/requires `given` `Promptibility.XDispatchTimePrereqsImpl[reqInf.type]`.
    * the `given def`
    * would
    * bundle these relevant set of `given` instances of these `type`s defined here in `promptibility.scala`,
    * taking care of the contract(s) between those TC instances and
    * providing some functionality based on those TC instances
    * 
    * - `Question.AcceptableResponseFormatDescExtractorAlgebraic`,
    *   to serve as the `.headline` impl
    * 
    * - `Question.HeadlineExtractor`,
    *   to serve as the `.responseFormat` impl
    * 
    */
   type XSummedAllView[
      XReceiver
         <: Product
      ,
   ]
      = (
         XSummedAllViewImpl[
            Singleton & XReceiver ,
            ? ,
            ? ,
         ]
      )

   // TODO the actual implicit-view impl

   // given [C1, C2 >: C1] : AnyRef with {
   //    summon[(
   //       Question.AcceptableResponseFormatDescExtractorAlgebraic[C2]
   //       <:<
   //       Question.AcceptableResponseFormatDescExtractorAlgebraic[C1]
   //    )]
   // }

   /**
    * 
    * the actual impl for
    * the automatic conv to `XSummedAllView[_1.type]`
    * 
    */
   given [
      XReceiver
         <: Product
      ,
      XRfExtractor <: Question.AcceptableResponseFormatDescExtractorAlgebraic[XReceiver]
      ,
      XHeadlExtractor <: Question.HeadlineExtractor[XReceiver]
      ,
      
   ] (using
      rfExtractor: Question.AcceptableResponseFormatDescExtractorAlgebraic[XReceiver] ,
      headlExtractor: Question.HeadlineExtractor[XReceiver] ,
   )
   : (
      Conversion[XReceiver, (
         XSummedAllViewImpl[
            XReceiver ,
            ? ,
            ? ,
         ]
      ) ]
   ) with {

      protected 
      object impl {

         def apply(p: XReceiver)
         = {
            XSummedAllViewImpl[p.type ](p)(using
               rfExtractor = rfExtractor ,
               headlExtractor = headlExtractor ,
            )
         }

      }

      export impl.{apply => apply }
      
   }

   protected[Question]
   object XSummedAllViewImpl {

      def apply[
         XReceiver
            <: Product
         ,
         
      ](_1: XReceiver)
      (using 
         rfExtractor: Question.AcceptableResponseFormatDescExtractorAlgebraic[XReceiver] ,
         headlExtractor: Question.HeadlineExtractor[XReceiver] ,
      )
      = {

         new XSummedAllViewImpl[
            _1.type ,
            rfExtractor.type ,
            headlExtractor.type ,
            
         ](_1 = _1)(using
            rfExtractor = rfExtractor ,
            headlExtractor = headlExtractor ,
         )
      }

   }

   protected[Question]
   class XSummedAllViewImpl[
      +XReceiver
         <: Product
      ,
      +XRfExtractor <: Question.AcceptableResponseFormatDescExtractorAlgebraic[XReceiver]
      ,
      +XHeadlExtractor <: Question.HeadlineExtractor[XReceiver]
      ,
      
   ]
   (val _1 : XReceiver )
   (using 
      val rfExtractor: XRfExtractor ,
      val headlExtractor: XHeadlExtractor ,
   )
   {

      //
      
      val responseFormat
      = _1.responseFormat

      val headline
      = _1.headline

   }

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




















