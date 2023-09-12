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
   given given_SpawnabilityAndReconciliability_Laspa[XModel <: LaspaStaticWithoutHeadline]
   : SpawnabilityAndReconciliabilityNoArg[LaspaStaticA, ln.ReactiveHtmlElement[dom.HTMLAnchorElement], Unit ]
   = {
      ;

      import laminar.api.L

      ;

      given_SpawnabilityAndReconciliability_CaseClassGeneralised1[
         LaspaStaticA
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

   case class LaspaStaticWithoutHeadline(
      //
      href : ([A] =>> A )[Option[java.net.URI] ]
      ,
   )

   opaque type LaspaStaticA
   <: Matchable
   = ((Article, Option[FlowThroughMode] ) , Option[LaspaStaticWithoutHeadline] )

   @deprecated
   given laspaStaticAFromAcTuple2(using DummyImplicit)
      (using util.NotGiven[LaspaStaticA <:< (Tuple | Tuple2[?, ?] | Tuple3[?, ?, ?]) ] ) /* to disallow local usage */
   : Conversion[(Article, Option[LaspaStaticWithoutHeadline]) , LaspaStaticA ]
   = btnaOrLaspaStaticImplAFromAcTuple2[LaspaStaticA, Option[LaspaStaticWithoutHeadline]]

   /**
    * a `SpawnabilityAndReconciliabilityNoArg` for
    * `&lt;button>`s (Btna)
    * 
    */
   given given_SpawnabilityAndReconciliability_Btna[XModel <: BtnaStaticWithoutHeadline]
   : (
      //
      SpawnabilityAndReconciliabilityNoArg[
         BtnaStaticA
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
         BtnaStaticA
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
      .withAfterSpawnIntercept((e, mdl) => {
         for {
            _ <- mdl.headlineAndFlowThruMode._2.collect({ case FlowThroughMode.forThroughness => })
         } do e.amend(L.className := "avfw-inline" )
         e
      })
   }

   case class BtnaStaticWithoutHeadline(
      //
      onClick : (evtInfo: dom.Event) => Unit
      ,
   )

   opaque type BtnaStaticA
   <: Matchable
   = ((Article, Option[FlowThroughMode] ) , Option[BtnaStaticWithoutHeadline] )

   @deprecated
   given btnaStaticAFromAcTuple2(using DummyImplicit)
      (using util.NotGiven[BtnaStaticA <:< (Tuple | Tuple2[?, ?] | Tuple3[?, ?, ?]) ] ) /* to disallow local usage */
   : Conversion[(Article, Option[BtnaStaticWithoutHeadline]) , BtnaStaticA ]
   = btnaOrLaspaStaticImplAFromAcTuple2[BtnaStaticA, Option[BtnaStaticWithoutHeadline]]

   final
   lazy
   val BtnaStaticInline
   : (headline: Article, cb: Option[BtnaStaticWithoutHeadline] ) => BtnaStaticA
   = (headline: Article, cb: Option[BtnaStaticWithoutHeadline] ) => ((headline, Some(FlowThroughMode.forThroughness ) ) , cb )

   final
   lazy
   val BtnaStaticAside
   : (headline: Article, cb: Option[BtnaStaticWithoutHeadline] ) => BtnaStaticA
   = (headline: Article, cb: Option[BtnaStaticWithoutHeadline] ) => ((headline, Some(FlowThroughMode.forSkip ) ) , cb )

   private object btnaStaticFlowThruModeNotSpecifiedWarningDone { org.scalajs.dom.console.error(s"[BtnaStaticWithoutHeadline] missing 'flowThroughMode' property") }

   ;

   ;

   extension [BtnlWithoutHeadline] (c: ((Article, Option[FlowThroughMode]) , BtnlWithoutHeadline ) ) {
      //

      def headlineAndFlowThruMode
      : (Article, Option[FlowThroughMode])
      = c._1

      def contentualConfig1
      : BtnlWithoutHeadline
      = c._2

      //
   }

   @deprecated
   def btnaOrLaspaStaticImplAFromAcTuple2[
      BtnlWithHeadline
         >: ((Article, Option[FlowThroughMode]) , BtnlWithoutHeadline )
         <: ((Article, Option[FlowThroughMode]) , BtnlWithoutHeadline )
      ,
      BtnlWithoutHeadline ,
   ]
      (using DummyImplicit)
   : Conversion[(Article, BtnlWithoutHeadline) , BtnlWithHeadline ]
   = {
      /* use combination of pat-matching and eta-expansion and fnc-composition, to avoid infinite-loopings */
      identity[((Article, BtnlWithoutHeadline)) => ((Article, Option[FlowThroughMode]) , BtnlWithoutHeadline ) ]({
         case (headline, config) =>
            ((headline, None ) , config )
      })
      .apply _
   }

   extension [Contents] (prov : (
      given_SpawnabilityAndReconciliability_CaseClassGeneralised1.SrcLensAndDestAttrPairRawSelInvar[((Article, Option[FlowThroughMode] ) , Contents )]
   ) ) {
      //

      def applyLaspaBtnaHeadlineProp()
      : laminar.api.L.Observer[((Article, Option[FlowThroughMode] ) , Contents ) ]
      = {
         ;

         import laminar.api.L

         (
            //

            prov

               (L.child )
               ({ case ((title, flowThruMode ), _) => title } , summon[avcalg.CBC[Article] ].empty )

               ((s: ([A] =>> (A, A) )[ln.ReactiveHtmlElement[?] ] ) => s._2 , (

                  (existingNodeOption, newDataValue) => (
                     //

                     // TODO

                     // existingNodeOption
                     // .fold({
                     //    val e
                     //    = {
                     //       newDataValue.spawn()
                     //       .asInstanceOf[ln.ReactiveHtmlElement[?] ]
                     //    }
                     //    (e, e)
                     // } )({ case e0 @ (e, _) => {
                     //    e.model_=(newDataValue )
                     //    e0
                     // } })
                     ???
                  )
               ) )

         )
      }

      // @deprecated
      // def applyLaspaBtnaHeadlineProp()
      // : laminar.api.L.Observer[(Article, Contents ) ]
      // = ???

   }

   locally {
      ""
      match { case s => s }
      ;
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
