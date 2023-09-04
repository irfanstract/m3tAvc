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
   implicit def given_SpawnabilityNoArg_LaminarSpawnable_LElemPlusPossibleData
      [
         //
         HL <: ln.ReactiveElement[HD & dom.Element],
         HD <: dom.Node ,
         M ,
      ]
   : (
      SpawnabilityAndReconciliabilityNoArg[
         //
         LaminarSpawnable[HL, HD],
         LElemPlusPossibleData[HL],
         Unit ,
      ]
   )
   = {
      ;

      ;

      SpawnabilityAndReconciliabilityNoArg
      .bySpawnabilityAndReconciliabilityFnc(
         //

         spwImpl1 =
            (mdl: LaminarSpawnable[HL, HD]) =>
               mdl.spawnThisSpiwmTwos()

         ,

         reconcImpl1 =
            (this1, mdl) => {
               ;

               mdl.doSpiwmTwoReconciliationOf(this1 )
            }
         ,

      )
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
   Mdl ,
   Spawned   ,
   U ,
](s: SpiwmTwos[Mdl, Spawned, U ])
   //

   // transparent inline
   def spawnThisSpiwmTwos()
   = {
      implicit
      val sp: s._1.type = s._1
      /* needed to desugar this `extension` dispatch, to avoid the ambiguity risking an infinite-looping */
      sp.spawn(s._2)( )
   }

   // transparent inline
   def doSpiwmTwoReconciliationOf(target: Spawned )
   = {
      implicit
      val sp: s._1.type = s._1
      /* needed to desugar this `extension` dispatch, to avoid the ambiguity risking an infinite-looping */
      sp.model_=(target)(s._2 )
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
          * to set-up the back-reference
          */
         def avfwBackreferent_=(this1 : scalajs.js.Any )
         : e.type
         = {
            ;

            e.ref.asJsDynamic
            .updateDynamic(nativityKey )(this1 )

            e
         }

         /**
          * the backreferent
          */
         def avfwBackreferent1
         : scalajs.js.Dynamic
         = {
            e.ref.asJsDynamic
            .selectDynamic(nativityKey )

         }

         /**
          * the backreferent,
          * `asInstanceOf`ed to `R`
          */
         def avfwBackreferent
            [R]
            (using util.NotGiven[R <:< (Null | AnyVal ) ] )
            (using reflect.Typeable[R] )
         : R
         = {
            (avfwBackreferent1 : Any )
            match { case returnValue => {
               if { returnValue == scalajs.js.undefined }
               then { throw new IllegalStateException(s"'returnValue' is '${returnValue}' ; please check that 'avfwBackreferent_=' has been run on it! ") { final val mRv = returnValue } }
               returnValue
            } }
            match { case e => e.asInstanceOf[R] }

         }

      }

      extension [NativeE <: org.scalajs.dom.HTMLElement] (e: com.raquo.laminar.tags.HtmlTag[NativeE] ) {
         //

         /**
          * necessary to set-up the back-reference
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

      /**
       * 
       * the spawn-and-reconcile-er
       * needs to
       * maintain, for each SpawnedElement (would be a Laminar Node),
       * exactly one instance of an ad-hoc class to take-care of the diffing-and-reconciliation
       * 
       * this ctor does these seq of things
       * 1) run `ec.constructWithBackref(this)`,
       *    and then
       * 2) maintain the returned `HtmlTag` for later-time retrieval
       * 3) define `wrappedLaminarElement` as a public method to retrieve that
       * 4) define `startAttribNow` and friends these ways
       * 
       * 
       * 
       */
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

         extension [V](target: com.raquo.laminar.keys.HtmlAttr[V] | com.raquo.laminar.keys.HtmlProp[V, V] ) {
            //

            def startAttribNow
               [V0]
               (
                  m: (value0: V0) => V
                  = identity[V] _ 
                  ,
                  initialValue: V0
                  ,
               )
            = {
               ;

               val statePipe = {
                  newValueUpdateRepipe(prototype = (_: V0) => {} , initialValue = initialValue )
               }

               (target match {
                  case target : com.raquo.laminar.keys.HtmlProp[v1, v2] =>
                     target <-- statePipe._2.map(m)
                  case target : com.raquo.laminar.keys.HtmlAttr[v1] =>
                     target <-- statePipe._2.map(m)
               } )
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
               (
                  f: (existingNodeOption: Option[C1], newValue: V) => C1 ,
                  initialDataValue: V ,
               )
            = {
               ;

               val statePipe = {

                  newValueUpdateRepipe(
                     
                     prototype = (value: V) => {},
                     initialValue = initialDataValue ,
                  )
               }

               ({
                  import laminar.api.L
                  L.child <-- {
                     statePipe._2
                     // .delayExecution({ import concurrent.duration.* ; 2.second })
                     .scanLeft[Option[C1] ](None )((s, v) => (f(s, v) ) match { case r => Some(r) } )
                     .map({
                        case Some(c) =>
                           c : com.raquo.laminar.nodes.ReactiveElement[?]
                           c

                        case None =>
                           L.commentNode(" ")

                     })
                  }
               })
               .startNow()

               statePipe._1
            }
            
         }

      }

   }

}













