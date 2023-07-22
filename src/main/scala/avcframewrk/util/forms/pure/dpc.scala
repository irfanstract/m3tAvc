package avcframewrk.util.forms.pure

val _ = {}
















object XDefinesDoDescribeDiscretelyProgressiveCont
{

   // protected 
   // trait DefinesRDoc { type RDoc }

   // type Adjacently
   //    = AdjacentlyImpl

   // trait AdjacentlyImpl
   // extends AnyRef
   // {

   //    this : XSTyper[Singleton & DefinesRDoc] =>
      
   //    /**
   //     * 
   //     * describe
   //     * a discretely-progressive content described by the given `EventIterator`
   //     * 
   //     */
   //    def describeDiscretelyProgressiveContent(
   //       c: EventIteratorByItemAndDesignation[RDoc, TsevpEventType.ofUpdate.type ] ,

   //    ) 
   //    : RDoc

   //    /**
   //     * 
   //     * describe
   //     * a rendition of discretely-progressive value described by the given `EventIterator`
   //     * 
   //     */
   //    def describeDiscretelyProgressiveValue[
   //       Value ,
         
   //    ](
   //       i1: EventIteratorByItemAndDesignation[Value, TsevpEventType.ofUpdate.type ] ,
   //       r: Value => RDoc ,

   //    ) 
   //    : RDoc

   // }

   // type IndependentlyByC[+C <: Singleton & DefinesRDoc]
   //    = IndependentlyImpl[C]

   // trait IndependentlyImpl[+C <: Singleton & DefinesRDoc]
   // extends
   // AnyRef
   // with AdjacentlyImpl
   // with avcframewrk.util.errorchecking.TypeParamPlacement.STyper[C]
   // {
      
   //    this : (
   //       AnyRef
   //       & XSTyper[C]
   //       & avcframewrk.util.errorchecking.TypeParamPlacement.STyper[C]
   //    ) =>

   // }

   // val _ = {
   //    //

   //    def runCc(ctx: Singleton & DefinesRDoc, c: (IndependentlyByC[ctx.type] & XSTyper[?] ) ): Unit = {

   //       summon[c.RDoc =:= ctx.RDoc ]

   //    }

   // }

   // ()

   // trait XSTyper[+C <: Singleton & DefinesRDoc]
   // extends
   // AnyRef
   // with avcframewrk.util.errorchecking.TypeParamPlacement.STyper[C]
   // {

   //    export $typer.RDoc

   // }

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













