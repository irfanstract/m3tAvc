package avcframewrk.forms

package templating

package w3e.impl.js

package s1

















trait ELaminarQckCore
extends
   AnyRef
   with ELaminarQckCoreABackreferencings
   with w3e.pre.ArticlesViaLspwmt
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Articles
   with w3e.pre.ArticlesViaLspw
{
   this : (
      AnyRef
      with w3e.pre.Articles
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   // // protected
   // class given_Conversion_SpiwmTwos_LaminarSpawnable_TypeKey

   extension [
      T0Spw
      <: LNRE
      ,
      T0Mdl,
      LNRE
      <: ln.ReactiveElement[?]
      ,
      UOpR ,

   ] (h0: SpiwmTwos[T0Mdl, T0Spw, UOpR ] ) {
      //

      /** 
       * attempt to `treat` `h0` as compatible.
       * note the change in the type-arg `Mdl` (from `T0Mdl` to `T2Mdl` )
       * 
       */
      def tryCompatAgainstSpawned
         [
            T2Mdl,
         ]
         (h2br: aBackreferencings.XEAndStateBag[?] )
         (using reflect.Typeable[LNRE] )
         (using util.NotGiven[LNRE <:< Null ] )
      : (
         Option[(
            // h0.type &
            SpawnabilityAndReconciliabilityNoArg[T2Mdl, T0Spw, UOpR ]
         ) ]
      )
      = {
         ;

         val h0br
         = h0.spawnThisSpiwmTwos().avfwBackreferent[aBackreferencings.XEAndStateBag[?] ]

         if (
            h0br.getClass()
            ==
               h2br.getClass()
         ) then {
            Some(h0._1 )
            .collect({ case h : SpawnabilityAndReconciliabilityNoArg[T2Mdl, T0Spw, UOpR ] => h })
            .map[SpawnabilityAndReconciliabilityNoArg[T2Mdl, T0Spw, UOpR] ] ( e => e )
         }
         else None
      }

      /** 
       * attempt to `treat` `h0` as compatible.
       * note the change in the type-arg `Mdl` (from `T0Mdl` to `T2Mdl` )
       * 
       */
      def tryCompatAgainstSpawned1
         [
            //
            // LNRE2
            // <: ln.ReactiveElement[?]
            // ,
            T2Spw
            <: LNRE
               ,
            T2Mdl,
         ]
         (h2sp: T2Spw )
         (using reflect.Typeable[LNRE] )
         (using util.NotGiven[LNRE <:< Null ] )
      = {
         ;

         val h2br
         = (h2sp ).avfwBackreferent[aBackreferencings.XEAndStateBag[?]]

         h0.tryCompatAgainstSpawned(h2br )
      }

      /** 
       * attempt to `treat` `h0` as compatible.
       * note the change in the type-arg `Mdl` (from `T0Mdl` to `T2Mdl` )
       * 
       */
      def tryCompatAgainstSpawnable
         [
            //
            // LNRE2
            // <: ln.ReactiveElement[?]
            // ,
            T2Spw
            <: LNRE
               ,
            T2Mdl,
         ]
         (h2: SpiwmTwos[T2Mdl, T2Spw, UOpR ] )
         (using reflect.Typeable[LNRE] )
         (using util.NotGiven[LNRE <:< Null ] )
      = {
         ;

         val h2sp
         = h2.spawnThisSpiwmTwos()

         h0.tryCompatAgainstSpawned1(h2sp )
      }

      //
   }

   // type ALS0
   // = (
   //    ({ type Main[T] <: { type HL ; type HD } = T match { case LaminarSpawnable[hl, hd] => { type HL = hl ; type HD = hd } } })
   //    #Main[Article]
   // )
   type ALS
   = (
      ({ type Main[T] <: (Any, Any) = T match { case SpiwmTwos[m, hl, uOpR] => SpiwmTwos[m, hl, uOpR] } })
      #Main[Article]
   )

   def lebControlledly[R]
      (
         runMain: => R ,
         doCatch: Throwable => (Nothing & R ) = { case util.control.NonFatal(z) => throw new RuntimeException(s"LebControlledCode Exception: ${z}", z ) ; case z => throw z } ,
      )
   : R
   = { util.Try({ runMain }).fold(doCatch, e => e ) }

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

   ;
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
                     target <-- statePipe._2.map(m).toLaminarObservable.replaceAllExceptionsWithConstException()
                  case target : com.raquo.laminar.keys.HtmlAttr[v1] =>
                     target <-- statePipe._2.map(m).toLaminarObservable.replaceAllExceptionsWithConstException()
                  /* it was our own wrapper ; now, however, we need compile-time conformance */
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
                     /* it was our own wrapper ; now, however, we need compile-time conformance */
                     .toLaminarObservable
                     .replaceAllExceptionsWithConstException()
                  }
               })
               .startNow()

               statePipe._1
            }
            
         }

      }

      trait XEAndStateBagCm[-M, +R]
      extends
      XEAndStateBag[?]
      {
         ;

         def model_=(newMdl: M )
         : R

         ;
      } // XEAndStateBagCm

      object XEAndStateBagCm {
         ;

         ;

         ;
      } // XEAndStateBagCm$

      @deprecated("this auto-conv is presently experimental.")
      given given_Conversion_C_SpawnabilityAndReconciliabilityNoArg
         [
            M,
            ReconciliativeRunReturnVal,
            C <: XEAndStateBagCm[M, ReconciliativeRunReturnVal] ,
         ]
      : Conversion[() => C, SpawnabilityAndReconciliabilityNoArg[M, C, ReconciliativeRunReturnVal ] ]
      = (constructDefaulted) => {
         SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
            //
            spwImpl1 = (mdl: M) => { val c = constructDefaulted() ; c.model_=(mdl) ; c } ,
            reconcImpl1 = (this1, newMdl) => { this1.model_=(newMdl ) } ,
         )
      }

      @deprecated("this auto-conv is presently experimental.")
      given given_Conversion_C_SpawnabilityAndReconciliabilityNoArg_1
         [
            M,
            ReconciliativeRunReturnVal,
            HL <: com.raquo.laminar.nodes.ReactiveElement[HD & org.scalajs.dom.Element],
            HD <: org.scalajs.dom.Node ,
            // C <: XEAndStateBagCm[M, ReconciliativeRunReturnVal] ,
         ]
         (using reflect.Typeable[XEAndStateBagCm[M, ReconciliativeRunReturnVal] ] )
      : Conversion[() => HL, SpawnabilityAndReconciliabilityNoArg[M, HL, ReconciliativeRunReturnVal ] ]
      = (constructDefaulted) => {
         SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
            //
            spwImpl1 = (mdl: M) => {
               val c = constructDefaulted()
               c
               .avfwBackreferent[XEAndStateBagCm[M, ReconciliativeRunReturnVal] ]
               .model_=(mdl)
               c
            }
            ,
            reconcImpl1 = (this1, newMdl) => {
               this1
               .avfwBackreferent[XEAndStateBagCm[M, ReconciliativeRunReturnVal] ]
               .model_=(newMdl )
            }
            ,
         )
      }

   }

}













