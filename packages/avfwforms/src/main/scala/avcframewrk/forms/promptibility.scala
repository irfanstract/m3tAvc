package avcframewrk.forms















object Promptibility {

}

object Question {

   trait Ops
   {

      val preamble
      : Any

      type XPreamble
         = preamble.type

      /**
       * 
       * describes the type/kind of the expected response.
       * 
       */
      val responseFormat
      : ResponseFormat.Ops
      
      type AcceptableResponse
         >: responseFormat.XValue
         <: responseFormat.XValue

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

      //

   }
   
}

object Response {

   given AlgebraicFormat
   : Question.ResponseFormat.type
   = Question.ResponseFormat

}


















