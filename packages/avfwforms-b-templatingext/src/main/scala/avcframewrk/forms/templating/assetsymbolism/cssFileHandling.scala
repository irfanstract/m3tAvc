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

      transparent inline
      given CustomHandler._Any
      = ${rdiWarnImpl() }

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

      private[avcframewrk]
      def rdiWarnImpl
         (using quoted.Quotes )
         ()
      = {
         ;
         import quoted.*
         import quotes.reflect.*
         report.info(s"[CssFileLinking.CustomHandler._Any] summoning 'reassignablyDelegatingInstance'.")
         '{
            reassignablyDelegatingInstance
         }
      }

      final
      lazy val reassignablyDelegatingInstance
         //
      = {
         ;
         new CustomHandler._Impl[?]
         with Selectable
         {
            ;

            var impl
            : CustomHandler._Any
            = noOpInstance

            def handleCssFile
               (src: java.net.URI )
            : EHCP
            = {
               impl.handleCssFile(src = src )
               ()
            }

            opaque type EHCP
            = Unit
         }
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