package avcframewrk.util





















object SlfOnEveryValue 
{

   object implicits {
      
      extension[V](v: V) {

         /**
          * 
          * adds compile-time inheritance from `Singleton` 
          * 
          * alternative: `&lt;expr>.nn`
          * 
          */
         // transparent 
         // inline 
         def self: v.type = v
         
      }

   }

}






















