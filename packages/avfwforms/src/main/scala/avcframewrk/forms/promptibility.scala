package avcframewrk.forms















object Promptibility {

   object XDispatcher
   {

      type Ops
         <: AnyRef

      @annotation.experimental
      given OpsCiad
         : Conversion[Ops, clauseInterweavedActionItemDispatcherImpl.Main ]
         = (_: AnyRef).asInstanceOf[clauseInterweavedActionItemDispatcherImpl.Main ]

   } /* `XDispatcher$` */

   type DeferredReturn[+R]
      <: (DummyImplicit) ?=> R

   /**
    * 
    * this `given`
    * would
    * avoid the need to list each child/individual `given`s separately and
    * enforce these contract(s) across/between them
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
   type XDispatchTimePrereqsImpl[XReceiver]
      = XDispatchTimePrereqsImplImpl[
         XReceiver,
         ? ,
         ? ,
      ]

   /**
    * 
    * INTERNAL ONLY --
    * the implementation of `XDispatchTimePrereqsImpl`
    * 
    */
   given XDispatchTimePrereqsImplImpl[
      XReceiver ,
      XRfExtractor <: Singleton & Question.AcceptableResponseFormatDescExtractorAlgebraic[XReceiver] ,
      XHeadlExtractor <: Singleton & Question.HeadlineExtractor[XReceiver] ,
      
   ] (using 
      rfExtractor0: XRfExtractor ,
      headlExtractor0: XHeadlExtractor ,
   )
   : AnyRef with {

      val rfExtractor : rfExtractor0.type
         = rfExtractor0

      val headlExtractor : headlExtractor0.type
         = headlExtractor0

      export rfExtractor.ItsAcceptableResponseFormatDesc

      summon[(
         ItsAcceptableResponseFormatDesc[InstanceOf[XReceiver] ]
         <:< ResponseFormat.XAlgebraicCaseOps
      ) ]

      export rfExtractor.responseFormat

      /**
       * 
       * `(arg : XReceiver ).responseType.XValue`.
       * 
       */
      type ItsRfdXValue[+m$ <: InstanceOf[XReceiver] ]
         = (
         ({

         val m : m$

         // type mResponseTypeDesc$ = ItsAcceptableResponseFormatDesc[m.type ]

         // type mResponseTypeXValue = (
         //    mResponseTypeDesc$#XValue
         // )

         val mResponseType : ItsAcceptableResponseFormatDesc[m.type ]

         type mResponseTypeXValue = (
            mResponseType.XValue
         )

         })
         #mResponseTypeXValue
         )
      
      /**
       * 
       * relevant to the above defs -
       * supposed to compile given all that
       * 
       */
      locally[(e: XReceiver ) => Unit ]((e) => {

         val eRf = e.responseFormat

         summon[(
            eRf.type
            <:<
            ItsAcceptableResponseFormatDesc[e.type ]
         ) ]

         summon[(
            eRf.type
            <:< ResponseFormat.XAlgebraicCaseOps
         ) ]

         summon[(
            ({ val m : e.type ; type m$ = m.type })#m$
            =:= e.type
         ) ]

         // TODO
         // summon[(
         //    ItsRfdXValue[e.type ]
         //    =:= eRf.XValue
         // ) ]

      } )

      /**
       * 
       * relevant to `RfXAcoXValue` --
       * supposed to compile given all that
       * 
       */
      locally[(e: XReceiver ) => Unit ]((e) => {

         val eRf = e.responseFormat

         summon[(
            eRf.type
            <:<
            ItsAcceptableResponseFormatDesc[e.type ]
         ) ]

         summon[(
            eRf.type
            <:< ResponseFormat.XAlgebraicCaseOps
         ) ]

         summon[(
            ({ val m : e.type ; type m$ = m.type })#m$
            =:= e.type
         ) ]

         summon[(
            RfXAcoXValue[eRf.type ]
            =:=
            eRf.XValue
         ) ]

      } )

   }

   /**
    * 
    * `(arg : ResponseFormat.XAlgebraicCaseOps ).XValue`.
    * 
    */
   @deprecated("this is a misnomer.") /* merely looking at this method's name will not make one properly understand the intent/purpose of it. */
   type RfXAcoXValue[
      +fmt$ <: InstanceOf[ResponseFormat.XAlgebraicCaseOps] ,
   ]
         = (
            ({
               val fmt
                  : fmt$
                  // : { type XValue }
               type AcceptableValue
                  = fmt.XValue 
                  // = Any
            })#AcceptableValue
         )

   given LolAyRef101[M] : AnyRef with {}
   given LolAyRef102[M](using i: DummyImplicit) : AnyRef with {}

   @deprecated("this is a misnomer.")
   def approduct[
      A0 >: Product <: Product ,
   ](
      //
      runImpl: (
         [A <: A0 ]
         =>
         (e: A)
         =>
         (manager: XDispatchTimePrereqsImpl[? >: A] )
         ?=>
         (expectedAsynchronicity: avcframewrk.forms.math.LexicalImperativeSynchronicityGiven.ByCc[[_] =>> Any ] )
         ?=>
         expectedAsynchronicity.MainByReturnValue[manager.ItsRfdXValue[e.type] ]
      ) ,
   )
   = runImpl

}

@annotation.experimental
protected
final
lazy val clauseInterweavedActionItemDispatcherImpl
   : avcframewrk.forms.advanced.clauseInterweavedActionItemDispatcherImpl.type
   = avcframewrk.forms.advanced.clauseInterweavedActionItemDispatcherImpl

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




















