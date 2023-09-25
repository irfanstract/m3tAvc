package avcframewrk.forms

package templating

package w3e.impl.js

package s1



















trait ELaminarQckCorePfr2Rffr
extends
   AnyRef
   // with w3e.pre.ArticlesViaLspwmt
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Articles
   /* a temporary repetition here (of below) necessary to prevent the compiler from "crashing" or serious 100%-CPU hanging */
   with ELaminarQckCoreABackreferencings
   with w3e.pre.ArticlesViaLspw
   with ELaminarQckCore1
   with ELSRNA
{
   this : (
      AnyRef
      with ELaminarQckCore
      with w3e.pre.Articles
      with ELaminarQckCoreFailsafeReconcilers
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

   ;

   ;

   ;

   extension [
      ImplSpecificPerFrameMdl
      ,
      S
      <: ln.ReactiveHtmlElement[?]
      ,
      ReconcOpR
      >: Unit <: Unit
      ,
   ] (perFrameReconciler00: SpawnabilityAndReconciliabilityNoArg[Option[ImplSpecificPerFrameMdl], S, ReconcOpR] )
   {
      def asPffr2RffrGiven
      = Pffr2RffrGiven(perFrameReconciler00)

      export asPffr2RffrGiven.{* }
   }

   private[s1]
   case class Pffr2RffrGiven [
      ImplSpecificPerFrameMdl
      ,
      S
      <: ln.ReactiveHtmlElement[?]
      ,
      ReconcOpR
      >: Unit <: Unit
      ,
   ] (perFrameReconciler00: SpawnabilityAndReconciliabilityNoArg[Option[ImplSpecificPerFrameMdl], S, ReconcOpR] ) {
      //

      /** 
       * `contraFlatMap1OC`
       * 
       */
      def contraFlatMap1OC
         [UserSideMdl ]
         (containerElem : com.raquo.laminar.tags.HtmlTag[?] )
         (implImplSideAnimFramesFromUserSideMdl: UserSideMdl => L.Signal[ImplSpecificPerFrameMdl] )
      = {
         ;

         pffr2Rffr(implImplSideAnimFramesFromUserSideMdl ).repipingImplReconciler

         match { case rc => {
            ;

            llrConv(containerElem )((mdl: Option[UserSideMdl] ) => {
               ;

               rc.spawnAsXsr(mdl )
               .mapHl(_.wrappedLaminarElemI  )
            } )
         } }

         match { case e => e }
      }

      def pffr2Rffr
         [UserSideMdl ]
         (implImplSideAnimFramesFromUserSideMdl: UserSideMdl => L.Signal[ImplSpecificPerFrameMdl] )
      = {
         contraFlatMap1OImpl(implImplSideAnimFramesFromUserSideMdl )
      }

      private[Pffr2RffrGiven ] 
      class contraFlatMap1OImpl
         [UserSideMdl ]
         (implImplSideAnimFramesFromUserSideMdl: UserSideMdl => L.Signal[ImplSpecificPerFrameMdl] )
      {
         ;

         val perFrameReconciler0
         = {
            ({
               ;
               perFrameReconciler00
            })
            match { case s: SpawnabilityAndReconciliabilityNoArg[t1, t2, t3] => s: SpawnabilityAndReconciliabilityNoArg[t1, ? <: t2, t3] }
            match { case s => s.asTypeTupelified }
         }
         /* can't use `import` */
         val perFrameReconciler
         : perFrameReconciler0._2.type
         = perFrameReconciler0._2

         ;

         case class RepipeModeCompStateBag(impl : (
            //

            (
               ln.ReactiveHtmlElement[?] ,
               L.Var[Option[UserSideMdl ] ]
               ,
            )
         ) )
         {
            ;

            export impl.{_1 as wrappedLaminarElemI }

            export impl._2.{set as btnModelOption_= }

         }

         val repipingImplReconciler
            /* can't make the type inferred, due to the resulting Cyclic Error .. */
         : (
            SpawnabilityAndReconciliabilityNoArg[
               //
               Option[UserSideMdl ] ,
               RepipeModeCompStateBag ,
               Unit ,
            ]
         )
         = {
            ;

            class RC01
               (using com.raquo.airstream.ownership.Owner )
            {
               ;

               val frameCounter
               : FCI
               = L.Var[Int](0)

               opaque type FCI
               <: L.Source[Int]
               =  L.Var[Int]

               val e1
               = perFrameReconciler.spawn(None )( )

               val internalReconcileTo
               = {
                  (perFrameReconciler.model_=(e1) _ )
                  match { case f : Function1[aType, r] => {
                     f.compose((a: aType ) => { frameCounter.update(_ + 1 ) ; a } )
                  } }
               }

               ;
            }

            class RC02
               (initialDescrOption: Option[UserSideMdl ] )
               (using subscrAssignee : com.raquo.airstream.ownership.Owner )
            {
               ;

               ;

               val rc01
               = new RC01
               export rc01.{*, given}

               val repipeCounter
               : repipeCounter
               = L.Var[Int](0)

               opaque type repipeCounter
               <: L.Source[Int]
               =  L.Var[Int]

               val repiping1
               = L.Var[Option[UserSideMdl ] ](initialDescrOption )

               repiping1.signal
               .foreach(mdlOption => { repipeCounter.update(_ + 1 ) } )

               repiping1.signal

               .flatMap({

                  case None =>
                     for { _ <- L.Val(() ) }

                     yield () => {
                        internalReconcileTo(None )
                     }

                  case Some(desc) =>
                     ;

                     val eFrames
                     = implImplSideAnimFramesFromUserSideMdl(desc)

                     for {
                        eFrame <- eFrames
                     }
                     yield (() => {
                        internalReconcileTo(Some(eFrame ) )
                     } )

               })
               .foreach(_.apply() )

               ;
            }

            SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc[
               //
               Option[UserSideMdl ] ,
               RepipeModeCompStateBag ,
               Unit ,
            ] (
               //

               //
               spwImpl1 = (initialDescrOption ) => {
                  ;

                  // TODO
                  implicit
                  val subscrAssignee
                  = com.raquo.airstream.ownership.ManualOwner()

                  val rc02
                  = new RC02(initialDescrOption = initialDescrOption )
                  import rc02.{*, given}

                  val e11 = {
                     ;

                     import L.{given}

                     def xNewCounterComponent
                        (src: L.Source[Int] )
                     = {
                        L.span(L.child <-- src.toObservable.map(_.toString() ) )
                     }

                     L.span(e1, (
                        // L.inpfaReconclCountUpDebugSpan
                        L.span
                     )((
                        L.span((
                           L.span(s"frames:", xNewCounterComponent(src = frameCounter ), L.title := "the frame-count" )
                        ) , ";" , (
                           L.span(s"repipes:", xNewCounterComponent(src = repipeCounter ), L.title := "the count of switching across the src BInputFunc(s) " )
                        ) , L.button("Repipe", L.onClick --> (_ => { repiping1.update(identity _ ) } ) ) )
                     )) )
                  }

                  RepipeModeCompStateBag((e11, repiping1) )
               } ,

               //
               reconcImpl1 = {
                  //

                  case (s0, newDescrOption ) =>
                     ;
                     s0.btnModelOption_=(newDescrOption )

                  //
               } ,

               //
            )
         }

         ;

      }

      //
   }


   ;
   ;
}


















val _ = {}
