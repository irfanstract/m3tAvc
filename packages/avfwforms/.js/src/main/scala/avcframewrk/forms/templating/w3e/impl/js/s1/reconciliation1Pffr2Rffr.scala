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

      //
      SpecificSpawnability
      <: SpawnabilityAndReconciliabilityNoArg[?, S, ReconcOpR]
      ,
   ]
      //
      (perFrameReconciler00: SpecificSpawnability )
      (using unpk : Pffr2RffrGivenUnpck1[ImplSpecificPerFrameMdl ] )
      (using specificSpawnabilityConforming : SpecificSpawnability <:< SpawnabilityAndReconciliabilityNoArg[unpk.XPackedly[ImplSpecificPerFrameMdl], S, ReconcOpR] )
   {
      def asPffr2RffrGiven
         //
      = Pffr2RffrGiven(specificSpawnabilityConforming(perFrameReconciler00) )

      export asPffr2RffrGiven.{* }
   }

   object extraPffr2RffrGivenUnpck
   {
      ;

      protected
      final
      lazy
      val defaultPffr2RffrGivenUnpckImpl
      = Pffr2RffrGivenUnpckBy[[E] =>> Option[E] ] (
         //
         [E] => (e: E) => Some(e)
         ,
         None ,
      )

      given defaultPffr2RffrGivenUnpck
      : defaultPffr2RffrGivenUnpckImpl.type
      = defaultPffr2RffrGivenUnpckImpl

      ;
   }

   /** 
    * by default it should wrap in `Option`, but
    * sometimes it's inappropriate ;
    * `given` a custom instance of this,
    * to customise it
    * 
    */
   type Pffr2RffrGivenUnpck
   = Pffr2RffrGivenUnpck1[Any]

   private[s1]
   trait Pffr2RffrGivenUnpck1[-B]
   {
      ;

      type XPackedly[+_ <: B ]

      def pack[E <: B](e: E)
      : XPackedly[e.type]

      def fromNone
      : XPackedly[Nothing]

      ;
   }

   private[s1]
   implicit
   class Pffr2RffrGiven [
      ImplSpecificPerFrameMdl
      ,
      S
      <: ln.ReactiveHtmlElement[?]
      ,
      ReconcOpR
      >: Unit <: Unit
      ,

      +SpecificUnpk <: (
         Pffr2RffrGivenUnpck1[ImplSpecificPerFrameMdl ]
         & Singleton
      ) 
      ,

      //
   ] 
      //
      //
      (using val unpk : SpecificUnpk)
      (perFrameReconciler00: SpawnabilityAndReconciliabilityNoArg[unpk.XPackedly[ImplSpecificPerFrameMdl], S, ReconcOpR] )
   {
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

            .compose((e: Option[UserSideMdl] ) => {
               System.out.nn.write(IArray.emptyByteIArray.toArray )
               e
            })
         } }

         match { case e => e }
      }

      def pffr2Rffr
         [UserSideMdl ]
         (implImplSideAnimFramesFromUserSideMdl: UserSideMdl => L.Signal[ImplSpecificPerFrameMdl] )
      = {
         contraFlatMap1OImpl(implImplSideAnimFramesFromUserSideMdl )
      }

      private[s1]
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

         System.currentTimeMillis()

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
               = perFrameReconciler.spawn(unpk.fromNone )( )

               val internalReconcileTo
               = {
                  (perFrameReconciler.model_=(e1) _ )
                  match { case f : Function1[aType, r] => {
                     f.compose((a: aType ) => { frameCounter.update(_ + 1 ) ; a } )
                  } }
                  match { case f => f.compose[Option[ImplSpecificPerFrameMdl] ](o => o.fold(unpk.fromNone)(e => unpk.pack(e) ) ) }
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

               .composeChanges(s => {
                  // TODO
                  s.delay(15 )
                  // s.delay(815 )
               } )

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

                     ({
                     ;

                     for {
                        eFrame <- eFrames
                     }
                     yield (() => {
                        internalReconcileTo(Some(eFrame ) )
                     } )
                     }) 

                     // .composeChanges(s => {
                     //    // TODO
                     //    // s.delay(15 )
                     //    s
                     //    .delay(815 )
                     // } )
                     .map(<:<.refl )


               })
               .map(_.apply() )
               
               // TODO
               match {
                  case chn => {
                     ;

                     implicit
                     val o = com.raquo.airstream.ownership.ManualOwner()

                     chn
                     .recover({
                        case util.control.NonFatal(z) =>
                           ;
                           import org.scalajs.dom.console
                           // throw
                           //    new LlrConHException(s"exception: ${z} ", z)
                           console.error(s"exception:")
                           console.infoExceptionCollapsed({
                              z
                              // new LlrConHException(s"${z } " , z )
                           }, headline = z.getClass().getName().nn )
                           console.warn(s"removing the subscription")
                           o.killSubscriptions()
                           Some(() )
                     })
                     .observe
                  }
               }

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

   /** 
    * a factory method for `Pffr2RffrGivenUnpck1` .
    * avoid using this variant, use the other one instead.
    * 
    */
   @deprecated
   def Pffr2RffrGivenUnpckBy
      [C[+_] ]
      (c: [E] => E => C[E], cx: => C[Nothing] )
   = {
      Pffr2RffrGivenUnpckBy1[C, Any ](
         //
         (x: Any) => c(x)
         ,
         cx
         ,
      )
   }

   /** 
    * a factory method for `Pffr2RffrGivenUnpck1`
    * 
    */
   def Pffr2RffrGivenUnpckBy1
      [C[+_ <: B], B ]
      (c: (x: B) => C[x.type] , cx: => C[Nothing] )
   = {
      new
         AnyRef
         with Pffr2RffrGivenUnpck1[B]
         with Selectable
      {
         ;
         type XPackedly[+E <: B ]
         >: C[E]
         <: C[E]
         ;
         //
         def pack[E <: B ](e: E)
         = c(e )
         ;
         def fromNone
         = cx
      }
   }

   def Pffr2RffrGivenUnpckByOption1
      [CSme[+_ <: B ], B ] 
      (c: (x: B) => CSme[x.type ] , cx: => B )
   = Pffr2RffrGivenUnpckByOption[CSme, B, B ](c, cx )

   def Pffr2RffrGivenUnpckByOption
      [CSme[+_ <: B ], B, CNe ] 
      (c: (x: B) => CSme[x.type ] , cx: => CNe )
   = {
      Pffr2RffrGivenUnpckBy1[[SpecificB <: B] =>> (CSme[SpecificB] | CNe ) , B ](
         //
         (x: B ) => c(x)
         ,
         cx
         ,
      )
   }

   extension [EB0] (impl: Pffr2RffrGivenUnpck1[? >: EB0] ) {
      //

      def contramap
         //
         [C1[+_ <: EB ] <: EB0, EB ]
         (f: (e: EB) => C1[e.type] )
         (using reflect.Typeable[EB] )
      = {

         Pffr2RffrGivenUnpckBy1
            [[E <: EB ] =>> impl.XPackedly[C1[E] ], EB ]
            (
               //
               (x0: EB) => {
                  x0
                  match { case x : (x0.type & EB) => f(x) }
                  match { case r => impl.pack(r) }
                  match { case r => (r) }
               }
               ,
               (impl.fromNone )
               ,
            )
      }

      //
   }

   extension (impl: Pffr2RffrGivenUnpck1[Any] )
      @deprecated
      def map
         [C1[+_] ]
         (f0: (impl1 : impl.type) ?=> [E] => impl1.XPackedly[E] => C1[E] )
      = {
         ;

         given impl.type
         = impl

         val f
         : ([E] => (x: impl.XPackedly[E]) => C1[E])
         = f0(using impl)

         Pffr2RffrGivenUnpckBy
            [C1]
            (
               //
               [E] => (x: E) => {
                  impl.pack(x)
                  match { case r => f(r) }
                  match { case r => (r) }
               }
               ,
               f(impl.fromNone )
               ,
            )
      }



   ;
   ;
}


















val _ = {}
