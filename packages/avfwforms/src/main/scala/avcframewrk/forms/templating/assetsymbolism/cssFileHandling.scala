package avcframewrk.forms

package templating

package assetsymbolism













object CssFileLinking
{
   ;

   ;

   object CustomHandler {
      ;

      ;

      type _Any
      = _Impl[?]

      protected
      trait _Impl[T0] {
         ;

         // transparent inline
         def handleCssFile
            (src: java.net.URI )
         : Any
      }

      ;

      object noOpInstance
      extends
      CustomHandler._Impl[?]
      {
         ;

         transparent inline
         def handleCssFile
            (src: java.net.URI )
         : Unit
         = {}
      }

      ;
   }

   object CustomHandlerSummon {
      ;

      def inQuotesOptional
         (using quoted.Quotes )
      : Option[quoted.Expr[CustomHandler._Any ] ]
      = {
         quoted.Expr.summon[CustomHandler._Any ]
      }

      ;
   }

   ;
}









val _ = {}