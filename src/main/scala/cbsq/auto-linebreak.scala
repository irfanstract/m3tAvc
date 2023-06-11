package cbsq










import language.unsafeNulls /* UTF/String utility */



export avcframewrk.util.autoLinebroken

;



extension (docum: java.lang.String) {

   // TODO
   def autoTruncated(
      locale: java.util.Locale = {
         java.util.Locale.ENGLISH
      } ,
      
   ): String = {

      docum
      .autoTruncateImpl(
         //

         locale = locale ,
         
      )
   }

}

import avcframewrk.util.{autoTruncated => autoTruncateImpl }




















