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
       * implementation-notes for `describeDiscretelyProgressiveContent`:
       * 
       * to maintain efficiency in case of lifecycle-based backend,
       * implementations
       * should try to keep the peer mounted and simply dispatch something like *set-content-to*,
       * unless the type clearly changes (eg from *picture* to *text-field*)
       * 
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
       * implementation-notes for `describeDiscretelyProgressiveValue`:
       * 
       * the intent is that the refresh-calls be restricted to updates ; however,
       * the machinery had no way to check the callback's purity, so
       * it would be very important to re-run the callback to compute updated value and,
       * if desired, emit a deprec warning
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













