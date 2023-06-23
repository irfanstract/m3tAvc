package avcframewrk.util.forms.pure

















trait DefinesDoRenderPoster[-A, +R]
{

   def renderPoster(c: A ): R

}

trait DefinesDoRenderDynamicPoster[-A, +R]
{

   /**
    * 
    * treats `c: A` as a possibly-animating source of a graphical content, and
    * return
    * (a markup for)
    * a display-component for it which will animate accordingly
    * 
    */
   def renderDynamicPoster(c: A ): R

}

























