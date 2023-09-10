package avcframewrk.forms

package templating

package w3e.impl.js

package s1



















/**
 * 
 * a rather minimal wrapper over the Laminar's 'builder pattern' for native comp(s)
 * 
 */
private[w3e]
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

   /**
    * a `SpawnabilityAndReconciliabilityNoArg` for
    * `&lt;anchor>`s (Laspa) and `&lt;button>`s (Btna) ;
    * letting `mdl` to Tuple `(headline: Article, contentConfig: Option[Pv] )`
    * 
    */
   def summonLaspaBtnaOrFriends
      [Pv]
      (using impl: SpawnabilityAndReconciliabilityNoArg[(Article, Option[Pv] ), ?, ? ] )
   : impl.type
   = impl

   /**
    * a `SpawnabilityAndReconciliabilityNoArg` for
    * `&lt;anchor>`s (Laspa)
    * 
    */
   given given_SpawnabilityAndReconciliability_Laspa[XModel <: LaspaStatic]
   : SpawnabilityAndReconciliabilityNoArg[(Article, Option[LaspaStatic] ), ln.ReactiveHtmlElement[dom.HTMLAnchorElement], Unit ]
   = {
      ;

      import laminar.api.L

      ;

      given_SpawnabilityAndReconciliability_CaseClassGeneralised1[
         (Article, Option[LaspaStatic] )
         ,
         dom.HTMLAnchorElement
         ,
      ](
         //
         prov => (

            prov.applyLaspaBtnaHeadlineProp()

         )
         ,
         prov => prov(L.href )((_ )._2.flatMap(_.href ).map(_.toASCIIString().nn ).getOrElse("") , "" )
         ,
         prov => prov(L.disabled )((_ )._2.isEmpty, false )
         ,

      )(nativeElemLCtor = L.a )
   }

   case class LaspaStatic(
      //
      href : ([A] =>> A )[Option[java.net.URI] ]
      ,
   )

   /**
    * a `SpawnabilityAndReconciliabilityNoArg` for
    * `&lt;button>`s (Btna)
    * 
    */
   given given_SpawnabilityAndReconciliability_Btna[XModel <: BtnaStatic]
   : (
      //
      SpawnabilityAndReconciliabilityNoArg[
         (Article, Option[BtnaStatic] )
         ,
         ln.ReactiveHtmlElement[dom.HTMLButtonElement]
         ,
         Unit ,
      ]
   )
   = {
      ;

      ;

      given_SpawnabilityAndReconciliability_CaseClassGeneralised1[
         (Article, Option[BtnaStatic] )
         ,
         dom.HTMLButtonElement
         ,
      ](
         //

         prov => prov.applyLaspaBtnaHeadlineProp()
         ,

         prov => prov(laminar.api.L.onClick )((_ )._2.map(_.onClick ).getOrElse(_ => {} ) , (_: Any) => {} )((evt, dispatch) => dispatch(evt) )
         ,
         prov => prov(laminar.api.L.disabled )((_ )._2.flatMap(d => Some(d.onClick) ).isEmpty , true )
         ,

      )(nativeElemLCtor = L.button )
   }

   case class BtnaStatic(
      //
      onClick : (evtInfo: dom.Event) => Unit
      ,
   )

   ;

   ;

   extension [Contents] (prov : given_SpawnabilityAndReconciliability_CaseClassGeneralised1.SrcLensAndDestAttrPairRawSelInvar[(Article, Contents )] ) {
      //

      def applyLaspaBtnaHeadlineProp()
      : laminar.api.L.Observer[(Article, Contents ) ]
      = {
         ;

         import laminar.api.L

         (
            //

            prov

               (L.child )
               ({ case (title, _) => title } , summon[avcalg.CBC[Article] ].empty )

               ((s: ([A] =>> A )[ln.ReactiveHtmlElement[?] ] ) => s , (

                  (existingNodeOption, newDataValue) => (

                     existingNodeOption
                     .fold(newDataValue.spawn() )(e => {
                        e.model_=(newDataValue )
                        e
                     })
                  )
               ) )

         )
      }

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
