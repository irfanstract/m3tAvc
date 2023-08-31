package avcframewrk.forms

package templating

package w3e.impl.js

package s1


















trait ELaminarQckPlainStringConts
extends
   AnyRef
   with ELaminarQckPlainStringContsReconc
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Articles
   with w3e.pre.PlainTxtContents
   /* a temporary treat necessary to prevent the compiler from hanging */
   // with ELaminarQckCoreHtml
{
   this : (
      AnyRef
      with w3e.pre.Articles
      with w3e.pre.PlainTxtContents
      with ELaminarQckCoreHtml
      with ELaminarQckPlainStringContsReconc
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   override
   val PlainLocaleStringPlainTxtArticle
   : (locale: java.util.Locale, txt: String) => Article
   = (

      {
         //

         case value => {
            (summon[SpawnabilityAndReconciliabilityNoArg[EbLocaleAndTxtString[?], ?, ? ] ] , EbLocaleAndTxtString(value ) )
            match { case s => s : Article }
         }

      }
   )

   ;
}

case class EbLocaleAndTxtString[+V <: (java.util.Locale, String)](impl: V)
{
   ;

   export impl.{_1 as locale}

   val d
   : impl._2.type
   = impl._2

   ;
}

protected
trait ELaminarQckPlainStringContsReconc
extends
   AnyRef
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
{
   this : (
      AnyRef
      with w3e.pre.Articles
      with ELaminarQckCoreHtml
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   ;

   // TODO
   private[avcframewrk]
   given [T0]
   : (
      SpawnabilityAndReconciliabilityNoArg[
         EbLocaleAndTxtString[?] ,
         ln.ReactiveHtmlElement[org.scalajs.dom.HTMLElement ], /* at this point there's no idea which subclass to choose - for plain texts there's rather wide range of choices available */
         Unit,
      ]
   )
   = {
      ;

      type SpawnedButton
         >: ln.ReactiveHtmlElement[dom.HTMLElement ]
         <: ln.ReactiveHtmlElement[dom.HTMLElement ]

      type ButtonContentModel
         >: EbLocaleAndTxtString[?]
         <: EbLocaleAndTxtString[?]

      // { given_Conversion_LElemPlusPossibleData1_HL_D[SpawnedButtonL, Any ] }
      // { val s = summon[Conversion[LElemPlusPossibleData1[SpawnedButtonL, Any ] , ? ] ] }

      val _ = {}

      val aBackreferencings1
      = summon[aBackreferencings.type ]

      class XEAndStateBag() extends
      aBackreferencings1.XEAndStateBag(ec = { laminar.api.L.span })
      {
         // this : aBackreferencings1.XEAndStateBag[org.scalajs.dom.HTMLButtonElement ] =>
         ;

         import laminar.api.L

         override
         def close(): Unit = {
            ;

            /* a hack, to make the `close()` ing of each sub unconditional */
            closeAllOf((
               Seq()
               :+ labelRendPipe1
            ))

            ;
         }

         /**
          * Laminar doesn't provide native support for re-routings of `Observable`s,
          * so
          * we'll need to leave it to Monix's `switch` or `switchMap`
          * 
          * 
          */
         ;

         // TODO
         val labelRendPipe1
         = {
            ;
            L.child
            .startChildrenListUpdateNow(((_: Any, item: () => com.raquo.laminar.nodes.ReactiveHtmlElement[dom.html.Element ] ) => {
               item
               .apply()
            }) , initialDataValue = () => laminar.api.L.span() )
         }

         def model_=(m: ButtonContentModel )
         : Unit
         = {
            import laminar.api.L

            ;

            /**
             * note --
             * if one needs improved diffing/reconc,
             * they should make it concat(s) instead
             * 
             */
            labelRendPipe1
            .onNext({
               locally[() => com.raquo.laminar.nodes.ReactiveHtmlElement[?] ](() => {
                  import language.unsafeNulls
                  L.span(
                     L.lang := { m.locale match { case java.util.Locale.ROOT => "" ; case l => l.getISO3Language() } } ,
                     { import L.* ; m.d } ,
                  )
               })
               match { case nd => laminar.api.L.Val(nd) }
            } )

            // TODO more
         }

         ;

         ;

         ;
      }

      SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
         //
         spwImpl1 = (mdl : ButtonContentModel ) => {
            val c = XEAndStateBag()
            c.model_=(mdl)
            c.wrappedLaminarElement
         }
         ,
         reconcImpl1 = (this1 : SpawnedButton, newModel) => {
            ;
            this1.avfwBackreferent[XEAndStateBag]
            .model_=(newModel )
         }
         ,
      )
   }

}














val _ = {}
