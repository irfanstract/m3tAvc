package avcframewrk.forms

package templating

package w3e.pre












trait Articles
extends
AnyRef
{

   type Article

   implicit val articleConcatenability
   : (
      // avcalg.CBC[? >: Article]
      avcalg.CBC[Article]
   )

}

trait TitledArticles
extends
AnyRef
{
   this : (
      AnyRef
      & Articles
   ) =>
   ;

   def describeTitledArticle
      (title: Article )
      (body: Article )
   : Article

   extension (body: Article )
      transparent
      inline
      def asTitled(title: Article )
      = describeTitledArticle(title = title )(body = body )

}











