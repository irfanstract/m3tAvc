package avcframewrk.forms

package templating

package w3e.impl.js

package s1

















/* we intended it `import` or `private export` */
export rendering.reconciliabilityC.*

trait ELaminarQckCore
extends
   AnyRef
   with ELaminarQckCoreABackreferencings
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Articles
{
   this : (
      AnyRef
      with w3e.pre.Articles
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   /**
    * `Article`
    * 
    * we can't make this opaque here, as
    * that'd close all the remaning ways to express the necessary specialisations
    * 
    */
   override
   type Article
   // = () => ArticleSpawned
   <: LaminarSpawnable[ln.ReactiveHtmlElement[? <: dom.HTMLElement] | ln.ReactiveSvgElement[? <: dom.SVGElement] , dom.HTMLElement | dom.SVGElement ]

   /**
    * `LaminarSpawnable`
    * 
    * opaque.
    * we provided a `given` `Spawnability` instead
    * 
    */
   protected
   opaque
   type LaminarSpawnable[
      +HL <: ln.ReactiveElement[HD & dom.Element],
      +HD <: dom.Node ,
   ]
   = (
      SpiwmTwos[Any, LElemPlusPossibleData[HL] @annotation.unchecked.uncheckedVariance, Unit]
   )

   protected
   // opaque
   type LElemPlusPossibleData[+HL]
   = LElemPlusPossibleData1[HL, Any]

   protected
   // opaque
   type LElemPlusPossibleData1[+HL, +D]
   // >: (HL, D)
   // <: AnyRef
   // =  (HL, D)
   >: HL @annotation.unchecked.uncheckedVariance
   <: HL

   // protected
   // given [HL, D]
   // : Conversion[LElemPlusPossibleData1[HL, D], (HL, D) ]
   // = identity[(HL, D)] _

   /**
    * allows them to serve as impl of `LaminarSpawnable`
    * 
    */
   given [
      //
      HL <: ln.ReactiveElement[HD & dom.Element],
      HD <: dom.Node ,
      Mdl ,
   ]
   : (
      Conversion[
         SpiwmTwos[Mdl, LElemPlusPossibleData[HL] , Unit] ,
         LaminarSpawnable[HL , HD] ,
      ]
   )
   = identity[SpiwmTwos[Mdl, LElemPlusPossibleData[HL] , Unit] ] _

   /**
    * `SpawnabilityNoArg`
    * 
    */
   // transparent inline
   given [
      //
      HL <: ln.ReactiveElement[HD & dom.Element],
      HD <: dom.Node ,
      M ,
   ]
   : SpawnabilityNoArg[LaminarSpawnable[HL, HD], LElemPlusPossibleData[HL] ]
   with {
      ;

      extension (s: LaminarSpawnable[HL, HD])
         override
         // transparent inline
         def spawn()
         = {
            s.spawnThisSpiwmTwos()
         }

   }

   ;
}

trait ELaminarQckCoreHtml
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with ELaminarQckCore
{
   this : (
      AnyRef
      with ELaminarQckCore
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   override
   type Article
   >: LaminarSpawnable[ln.ReactiveHtmlElement[? <: dom.HTMLElement] , dom.HTMLElement ]
   <: LaminarSpawnable[ln.ReactiveHtmlElement[? <: dom.HTMLElement] , dom.HTMLElement ]

   /**
    * 
    */
   extension (src: monix.reactive.Observable[Article] ) {
      //

      def toLaminarRefreshMonix()
      : monix.reactive.Observable[ln.ReactiveHtmlElement[? <: dom.HTMLElement] ]
      = {
         ;

         src
         .scan[Option[ln.ReactiveHtmlElement[? <: dom.HTMLElement] ] ](None )({
            case (_, newR) =>
               ;

               val gvn = given_SpawnabilityNoArg_LaminarSpawnable_LElemPlusPossibleData[ln.ReactiveHtmlElement[? <: org.scalajs.dom.HTMLElement] , org.scalajs.dom.HTMLElement, Nothing ]
               ;

               // newR.spawn() /* this LOC caused the compiler to hang */
               gvn.spawn(newR )( )
               match { case e => (e) }

               match { case e => Some(e) }
         })
         /* */
         .flatMapIterable(o => o.toList )
      }
   }

   ;
}

/**
 * a pair, which's
 * a `SpawnabilityAndReconciliabilityNoArg` and a "data-model"
 * 
 * refines the tuple-type to achieve that 'dependent-typing' of `_1`
 * 
 */
private[avcframewrk]
type SpiwmTwos[+Mdl, Sp, +R]
= (
   /**
    * to avoid the "unreducible applic with wildcard args" complaint,
    * 
    * we
    * make it a conjunction of two,
    * one being a refined-type, leaving those type-param(s) wildcards, and
    * the next one being the one instantiating them as we demand
    * 
    */

   (
      (SpawnabilityAndReconciliabilityNoArg[?, ?, ? ], Any )
      {
         //
         val _1 : SpawnabilityAndReconciliabilityNoArg[_2.type, ?, ? ]
      }
   )
   & /* the not-so-interesting part */
   (SpawnabilityAndReconciliabilityNoArg[?, Sp, R], Mdl )
)

extension [
   //
   HL ,
   HD   ,
   M ,
](s: SpiwmTwos[HL, HD, Any])
   //

   // transparent inline
   def spawnThisSpiwmTwos()
   = {
      implicit
      val sp: s._1.type = s._1
      /* needed to desugar this `extension` dispatch, to avoid the ambiguity risking an infinite-looping */
      sp.spawn(s._2)( )
   }

val _ = {
   ((arg : SpiwmTwos[1, 2, 3] ) => {})
   .nn
}

trait ELaminarQckCoreABackreferencings
extends
   AnyRef
{
   ;

   given aBackreferencings
   : AnyRef with {

      ;

      // import com.raquo.laminar

      final lazy
      val avfwNativityKey
      : nativityKey.type
      = nativityKey

      val nativityKey
      = "avfwSpecificNativeHandle"

      extension (e : com.raquo.laminar.nodes.ChildNode[?] ) {
         //

         /**
          * needs to set-up the back-reference
          */
         def avfwBackreferent_=(this1 : scalajs.js.Any )
         : e.type
         = {
            ;

            e.ref.asJsDynamic
            .updateDynamic(nativityKey )(this1 )

            e
         }

         def avfwBackreferent1
         : scalajs.js.Dynamic
         = {
            e.ref.asJsDynamic
            .selectDynamic(nativityKey )

         }

         def avfwBackreferent[R]
            (using reflect.Typeable[R] )
         : R
         = {
            ((v: Any) => v.asInstanceOf[R] )
            .apply(avfwBackreferent1 )

         }

      }

      extension [NativeE <: org.scalajs.dom.HTMLElement] (e: com.raquo.laminar.tags.HtmlTag[NativeE] ) {
         //

         /**
          * needs to set-up the back-reference
          * 
          * 
          * @param backreferent the intended backreferent
          * 
          */
         transparent inline /* a must */
         def constructWithBackref
            [BackreferentOps <: Singleton & AnyRef]
            (backreferent : BackreferentOps)
         : (
            com.raquo.laminar.nodes.ReactiveHtmlElement[NativeE]
         )
         = {
            e.apply()
            .avfwBackreferent_=(backreferent.asInstanceOf[scalajs.js.Any ] )
         }
      }

      abstract
      class XEAndStateBag
         [+NativeE <: org.scalajs.dom.HTMLElement]
         (ec: com.raquo.laminar.tags.HtmlTag[NativeE] )
      extends
         AnyRef
         with java.io.Closeable
      {
         ;
         
         ;

         private[XEAndStateBag]
         val e = {
            ;

            import laminar.api.L

            /**
             * needs to set-up the back-reference
             */
            ec
            .constructWithBackref(XEAndStateBag.this)
         }

         /** only use if needed !!! */
         def wrappedLaminarElement
         : e.type
         = e

         /**
          * Laminar doesn't provide native support for re-routings of `Observable`s,
          * so
          * we'll need to leave it to Monix's `switch` or `switchMap`
          * 
          * 
          */
         ;

         // def applyAttrRefresh[V](target)
         // extensioon [V](target: com.raquo.laminar.receivers.ChildReceiver )

         extension [V](target: com.raquo.laminar.modifiers.Modifier[? >: wrappedLaminarElement.type] ) {
            //

            def startNow( )
            : wrappedLaminarElement.type
            = {
               wrappedLaminarElement
               .amend(target )
            }
         }

         // avcframewrk.evm.AsyncAlgebraicItemStream.newReroutiblePipe[Article ]()

         extension [V](target: com.raquo.laminar.keys.HtmlProp[V, V] ) {
            //

            def startAttribNow[V0](m: (value0: V0) => V = identity[V] _ )
            = {
               ;

               val statePipe = newValueUpdateRepipe(prototype = (_: V0) => {} )

               ({ target <-- statePipe._2.map(m).toLaminarEventStream() })
               .startNow()

               statePipe._1
            }
            
         }

         extension [V <: org.scalajs.dom.Event](targetEventKey: com.raquo.laminar.keys.EventProp[V] ) {
            //

            def startCallbackUpdateNow()
            = {
               ;

               val cbImplUpdatePipe = newCallbackImplUpdateRepipe(prototype = (_: V) => {} )

               ({ import laminar.api.L.* ; targetEventKey --> cbImplUpdatePipe._2 })
               .startNow()

               cbImplUpdatePipe._1
            }
            
         }

         extension [T0](target: com.raquo.laminar.receivers.ChildReceiver.type ) {
            //

            /**
             * 
             *
             * @param V
             * @param C1
             * @param f conversion to `C1`, can be stateful
             */
            def startChildrenListUpdateNow
               [
                  V,
                  C1 <: ([A] =>> A )[com.raquo.laminar.nodes.ChildNode[?] & com.raquo.laminar.nodes.ReactiveElement.Base ]
                  ,
               ]
               (f: (existingNodeOption: Option[C1], newValue: V) => C1 )
            = {
               ;

               val statePipe = newValueUpdateRepipe(prototype = (value: V) => {} )

               ({
                  import laminar.api.L
                  L.child <-- {
                     statePipe._2
                     .scan[Option[C1] ](None )((s, v) => (f(s, v) match { case c => Some(c) } ) )
                     .flatMapIterable(c => c.toList )
                     .toLaminarEventStream()
                  }
               })
               .startNow()

               statePipe._1
            }
            
         }

      }

   }

}












