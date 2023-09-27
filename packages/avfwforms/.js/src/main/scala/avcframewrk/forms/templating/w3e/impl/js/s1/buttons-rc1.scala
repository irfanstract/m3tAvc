package avcframewrk.forms

package templating

package w3e.impl.js

package s1
















private
trait ELaminarQckButtonsReconc
extends
   AnyRef
   /* */
   with ENativeElementsD1
   with ELaminarQckButtonsReconcNatives
   with ELaminarQckButtonsReconcAbcdCbRenderability
   with ELaminarQckButtonsReconcCtls
   with ELaminarQckCoreWRE
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
   with w3e.pre.Articles
   with ELaminarQckCoreFailsafeReconcilers
{
   this : (
      AnyRef
      with w3e.pre.Articles
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
      with ENativeElementsD1
      with ELaminarQckCoreFailsafeReconcilers
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

   ;

   ;

   ;

   /**
    * 
    * a locally-adjusted itc for scan-left (see `IterableOnceOps`) reconciliation
    * 
    */
   private
   trait XScanLeftReconciliativeOps1[ContentModel]
   {
      ;

      val lE
      : ln.ReactiveHtmlElement[dom.HTMLElement]

      def tryUpdateTo
         (m : ContentModel )
      : Either[XScanLeftReconciliativeOps1[ContentModel] , Unit]

   }

   ;

   private[s1]
   final
   lazy val abcDbbaFacPreByAnim
   = {
      ;

      import CallbackTypeL.{*, given}
      import abcdCallbackRenderablility1.ftm

      // ;

      ({
         ;

         val ct1 = {
            val p = {
               ;
               (
                           //

                           //
                           // ({
                           //    ;

                           //    Pffr2RffrGivenUnpckBy[[_] =>> ((Any) & (A | B | C) , FlowThroughMode , Article ) ] (
                           //       //
                           //       [E] =>
                           //       (e: E) =>
                           //          summon[reflect.Typeable[((Any) & (A | B | C) , FlowThroughMode , Article ) ] ].unapply(e ).get
                           //       , 
                           //       defaultNoOpActional
                           //       ,
                           //    )
                           // })
                           // match { case tc => {
                           //    ;

                           //    tc
                           //    .contramap[[_] =>> (
                           //       //
                           //       L.Signal[tc.XPackedly[Any] ]
                           //    ), L.Signal[Any] ] ((e: L.Signal[Any] ) => {
                           //       e
                           //       match {
                           //          case s : L.Signal[eT] =>
                           //             s
                           //             .map(_.asInstanceOf[tc.XPackedly[Any] ] )
                           //          case s =>
                           //             throw
                           //                new Error(new MatchError(s).toString() )
                           //       }
                           //    } )
                           // } }
                           Pffr2RffrGivenUnpckByOption1
                              [[E] =>> E , ((Any) & (A | B | C) , FlowThroughMode , Article ) ]
                              (e => e , (defaultNoOpActional ) )
                        )
            }
            p
         }

         abcDbbaFacPrePerFrame

         .compose(<:<.refl)

         .contraFlatMap1OC(using ct1 )(using <:<.refl ) (L.span )({
            <:<.refl[L.Signal[(A | B | C, FlowThroughMode, Article ) ] ]
            // .andThen(o => { o.debugSpy(e => org.scalajs.dom.console.log(e) ) ; o } )
            .andThen(s => {
               s
               .composeChanges(s => {
                  s.delay(3 * 1000 )
               } )
            } )
         } )

         // // TODO remove this debug-only LOC
         // .compose(([E] => () => (e: E) => {
         //    // org.scalajs.dom.console.log(e.toString() )
         //    e 
         // } ).apply() )

         .compose(([E] => () => (e: E) => Some(e) ).apply() )

         .compose(<:<.refl)
      })

      match { case f00 => {
         ;

         val defaultS
         = {
            reconcNoconfDelaySig
               ({ import scala.concurrent.duration.{*, given} ; 5.second })
               (defaultNoOpActional )
         }

         ;
         val f01 = SRNA.allocateGScanLeft(defaultS )(f00 )
         val f02 = laminarSpawnableMdlFactory(f01 )
         val f03 = {
            lnByModelElemReconciler1(f02.compose(([E] => (fb: DummyImplicit ?=> E ) => (e : Option[E] ) => e.getOrElse(fb) ).apply(defaultS ) ) )(using <:<.refl )
            .compose(([E] => () => Some.apply[E] _ ).apply() )
         }
         f03
      } }
   }

   private[s1]
   final
   lazy val abcDbbaFacPrePerFrame
   = {
      ;

      import CallbackTypeL.{*, given}
      import abcdCallbackRenderablility1.ftm

      ({
         ;

         abcdCallbackRenderablility1.spawnabilityOfAbc
         .compose({
            <:<.refl[(A | B | C, FlowThroughMode, Article ) ]
         })
      })
   }

   private[s1]
   inline
   def defaultNoOpActional
   = {
      ;

      val s = currentMethodName

      val title
      = {
         PlainLocaleStringPlainTxtArticle(java.util.Locale.ROOT.nn , s )
      }

      defaultActionalImpl(title = title )
   }

   private[s1]
   def defaultActionalImpl(title: Article )
   = {
      ;

      import CallbackTypeL.{*, given}

      // TODO
      (B(callbackOption = Some((_: Any) => {} ) ), FlowThroughMode.forSkip, title )
   }

   private[s1]
   lazy val defaultNoOpAction
   = URLAction(baseTitle = "")({ case _ => new java.net.URI("javascript", s"void(0)", null ) })

   ;

   extension (m: Action ) {
      //

      private[s1]
      def animFramesB
      = {
         ;
         (m.stateSpecificCallbackAnim1.unlifted combineWith m.stateTitleAnim.toLaminarObservable )
         .map(e => e )
      }

      private[s1]
      def animFramesBAlt
      = {
         ;
         (m.stateSpecificCallbackAnim1.toLaminarObservable combineWith m.stateTitleAnim.toLaminarObservable )
         .map(e => e )
      }

      //
   }

   ;

   ;

   ;

} // ELaminarQckButtonsReconc


















val _ = {}