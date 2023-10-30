package avcframewrk.forms















object Promptibility {

   object XDispatcher
   {

   } /* `XDispatcher$` */

   type DeferredReturn[+R]
      <: (DummyImplicit) ?=> R

}

/* 
 * 
 * 
 * 
 * 
 * 
 */

object Question {

   /**
    * 
    * describes the type/kind of the expected response.
    * 
    */
   final
   lazy val ResponseFormat
      : IResponseFormat.type
      = IResponseFormat

   // TODO the actual implicit-view impl

   // given [C1, C2 >: C1] : AnyRef with {
   //    summon[(
   //       Question.AcceptableResponseFormatDescExtractorAlgebraic[C2]
   //       <:<
   //       Question.AcceptableResponseFormatDescExtractorAlgebraic[C1]
   //    )]
   // }

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

} /* `object IResponseFormat` */




















