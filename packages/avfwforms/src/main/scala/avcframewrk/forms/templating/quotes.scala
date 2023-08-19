package avcframewrk.forms

package templating
















trait ProperNounQuotability[+Rendered ]
{

   /**
    * 
    * pronounciation of the *proper-noun*
    * 
    */
   def quoteProperNoun(value: String)
   : Rendered

} // ProperNounQuotability




trait PlainTextQuotability[+Rendered]
{

   def quote(value: Utf)
   : Rendered

} // PlainTextQuotability

object PlainTextQuotability {

   import language.implicitConversions

   given [R]
   : Conversion[QuotabilityFnc[Utf, R] , PlainTextQuotability[R] ]
   = (impl => new PlainTextQuotability[R] { export impl.{quote as quote } } )

} // PlainTextQuotability$

















