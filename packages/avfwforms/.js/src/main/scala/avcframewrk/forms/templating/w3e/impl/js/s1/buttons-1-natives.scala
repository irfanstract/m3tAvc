package avcframewrk.forms

package templating

package w3e.impl.js

package s1



















/**
 * 
 * a rather minimal wrapper over the Laminar's 'builder pattern' for native comp(s)
 * 
 */
private
trait ELaminarQckButtonsReconcNatives
extends
   AnyRef
   /* */
   with ENativeElementsD1
   with ELaminarQckInputElemsReconcNatives
   with ELaminarQckInputElemsLcs
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
   with ELaminarQckButtonsReconcCtls
   with w3e.pre.Articles
   with ELaminarQckCore
{
   this : (
      AnyRef
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
      with ELaminarQckButtonsReconcCtls
      with ENativeElementsD1
      with w3e.pre.Articles
      with ELaminarQckCore
      with ELaminarQckCoreHtml
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

   ;

   ;

   locally {
      ""
      match { case s => s }

      ;
   }

   transparent inline
   def nativeTypStrFor(edType: GivenSpinner1[?] )
   : String
   = {
      ;

      edType

      match {
         //
         case edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_DateTime.type =>
            "date"
         case edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_Number[?] =>
            "number"
         case _ =>
            ""
         //
      }
   }

   ;

   extension [Item] (dest: laminar.api.L.Observer[? >: AsyncStateChangeMonad[Item] ] ) {
      //

      def contraconst()
      = dest.contramap((v: Item) => laminar.api.L.Val(v) )

      //
   }

   ;

   ;


   ;
}

given ebAvfwInlineBtnCssInit
: AnyRef
with {
   ;

   org.scalajs.dom.console.log(s"[ebAvfwInlineBtnCssInit]")

   avcframewrk.forms.addGlobalCss({
      ;

      enum Hoverffect {
         case OnBorder()
         case ToIncreaseUnderline()
      }

      val hoverEffect
      = Hoverffect.OnBorder()

      (
         //

         Seq()

         :+ s"button, input { padding-block: 0.75ex ; } "

         :+ s"button.avfw-inline, a.avfw-inline, input.avfw-inline { display: inline ; } "

         :+ s"button.avfw-inline, a.avfw-inline, input.avfw-inline { padding-block: 0.7ex ; padding-block-end: 1.5ex ; margin-block: -0.4ex ; } "
         :+ s"button.avfw-inline, input.avfw-inline { margin-block-end: -1ex ; } "

         :+ s"button.avfw-inline { padding-inline: 1ex ; } "

         :+ s"button.avfw-inline { background: transparent ; background: rgba(0, 0, 0, 0.02) ; } "

         :+ s"button.avfw-inline { margin-inline: -1ex ; } "

         // :+ s"button.avfw-inline { font-weight: bolder ; } "

         :++ (hoverEffect match {

            case Hoverffect.OnBorder() => 

               (Seq()

               :+ s"button { border: 0.1ex solid transparent ; } "

               :+ { def sel(sc: String ) = s"#app${sc } button " ; s"${sel(":hover") }, ${sel(":focus-within") } { border-color: currentColor ; } " }

               )

            case _ =>
               Seq()

         } )

         :+ s"button, a { text-decoration: underline ; } "

         :++ (hoverEffect match {

            case Hoverffect.ToIncreaseUnderline() => 

               (Seq()

         :+ { def sel(sc: String ) = s"#app${sc } button.avfw-inline " ; s"${sel(":hover") }, ${sel(":focus-within") } { text-decoration-style: double ; } " }

               )

            case _ =>
               Seq()

         } )

         :+ s"button.avfw-offtopic { user-select: none !important ; } "

      )
      .mkString("\r\n\r\n")
   })

} // ebAvfwInlineBtnCssInit$

















val _ = {} 
