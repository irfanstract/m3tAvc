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
       * a discretely-progressive anim whose (key)frames come from the given `EventIterator`
       * 
       * the diffing will solely be based on the final `RDoc`s
       * 
       */
      def describeDiscretelyProgressiveContent(
         c: KeyFrameIterator[RDoc ] ,

      ) 
      : RDoc

      /**
       * 
       * describe
       * a discretely-progressive ctrl modulation
       * whose data (key)frames come from the given `EventIterator`
       * and
       * which'd dispatch `r` to render the ctrl value
       * 
       * the diffing will primarily be based on the values returned by `i1`
       * 
       */
      def describeDiscretelyProgressiveValue[
         Value ,
         
      ](
         i1: KeyFrameIterator[Value ] ,
         r: Value => RDoc ,

      ) 
      : RDoc

   }

   /**
    * 
    * provides
    * impl, in terms of `describeDiscretelyProgressiveContent`, for the other methods
    * 
    */
   trait DdpcMixinImpl[RDoc]
   {

      thisD1 : IndependentlyImpl[RDoc] =>

      private[DdpcMixinImpl]
      object ddpcMixinImpl1 extends
      IndependentlyImpl[RDoc]
      {

         export thisD1.describeDiscretelyProgressiveContent
         
         def describeDiscretelyProgressiveValue[
            Value ,
            
         ](
            i1: KeyFrameIterator[Value ] ,
            renderItem : Value => RDoc ,

         ) 
         : RDoc
         = {

            describeDiscretelyProgressiveContent({

               i1
               .map((value: Value) => {

                  renderItem(value)
               } : RDoc )
            } )
         }

         //
         
      }

      export ddpcMixinImpl1.describeDiscretelyProgressiveValue

      //

   }

}













