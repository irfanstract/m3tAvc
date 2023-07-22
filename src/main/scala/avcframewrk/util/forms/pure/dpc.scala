package avcframewrk.util.forms.pure

val _ = {}
















object XDefinesDoDescribeDiscretelyProgressiveCont
{

   type IndependentlyByRDoc[RDoc]
      = IndependentlyImpl[RDoc]

   protected 
   trait IndependentlyImpl[RDoc]
   extends
   AnyRef
   {
      
      /**
       * 
       * describe
       * a discretely-progressive content described by the given `EventIterator`
       * 
       */
      def describeDiscretelyProgressiveContent(
         c: EventIteratorByItemAndDesignation[RDoc, TsevpEventType.ofUpdate.type ] ,

      ) 
      : RDoc

      /**
       * 
       * describe
       * a rendition of discretely-progressive value described by the given `EventIterator`
       * 
       */
      def describeDiscretelyProgressiveValue[
         Value ,
         
      ](
         i1: EventIteratorByItemAndDesignation[Value, TsevpEventType.ofUpdate.type ] ,
         r: Value => RDoc ,

      ) 
      : RDoc

   }

}













