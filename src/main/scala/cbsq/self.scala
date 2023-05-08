package cbsq









object SlfOnEveryValue 
{

   object implicits {
      
      extension[V](v: V) {

         /**
          * 
          * adds compile-time inheritance from `Singleton` 
          * 
          */
         // transparent 
         // inline 
         def self: v.type = v
         
      }

   }

}








