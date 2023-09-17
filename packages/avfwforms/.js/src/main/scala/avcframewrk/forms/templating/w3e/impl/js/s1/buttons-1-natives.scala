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
   with ELaminarQckInputElemsDataTypesPre
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

      ebAvfwInlineBtnCssInit

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

         val reconcilerI = summon[SpawnabilityAndReconciliabilityNoArg[Article, ?, ? ] ].asTypeTupelified

         (
            //

            prov

               (L.child )
               ({ case ((title, flowThruMode ), _) => title } , summon[avcalg.CBC[Article] ].empty )

               ((s: reconcilerI._1.Reconcilee ) => laminarInSpawneddLL(s) , (

                  (existingStateBagOption, newArtD ) => (
                     //

                     existingStateBagOption
                     .fold({

                        reconcilerI._2
                        .spawn(newArtD )( )
                     } )({ case e => {
                        ;

                        reconcilerI._2
                        .model_=(e )(newArtD )
                        
                        e
                     } })
                     match { case e => e }
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

















val _ = {} 
