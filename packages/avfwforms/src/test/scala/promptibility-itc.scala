





import avcframewrk.forms.*






extension (dispatcher: Promptibility.XDispatcher.Ops)
{

   def applyXdpERTestPre(e1 : Product )
   = {

      {

         extension (receiver : e1.type) {

            def hello() = { println(s"hello!") }

         }

         e1.hello()

      }

      {

         implicit
         object implicits {

            extension (receiver : e1.type) {

               def hello() = { println(s"hello!") }

            }
            
         }

         // e1.hello()

      }

      ()
   }

   def applyXdpERTest(e1 : Product )( using
      //

      xdp
      : (
         Question.AcceptableResponseFormatDescExtractorAlgebraic[e1.type]
         {
            type ItsAcceptableResponseFormatDesc[+c]
               >: ResponseFormat.ofBoolean.type
               <: ResponseFormat.ofBoolean.type
         }
      )
      ,
   )
   = {

      ({ val ef = xdp.responseFormat _ })

      ({ val ef = println(xdp) })

      {
         summon[xdp.ItsAcceptableResponseFormatDesc[e1.type] <:< ResponseFormat.ofBoolean.type ]
      }

      {

         val xdpc = summon[Promptibility.XDispatchTimePrereqsImpl[e1.type] ]

         summon[xdpc.ItsAcceptableResponseFormatDesc[e1.type] <:< ResponseFormat.ofBoolean.type ]

         // summon[xdpc.rfExtractor.type <:< xdp.type ]

         val xdpcWasGiven
            = summon[Promptibility.XDispatchTimePrereqsImpl[e1.type] ]
         ({ val ef = xdpc.responseFormat _ })
         (xdp).responseFormat(e1)
         // val rF = e1.responseFormat
         // val rF = (e1 : e1.type).responseFormat
      }

      // {

      //    ({ val ef = xdp.responseFormat _ })
      //    // val rf = e1.responseFormat
      // }

      // ()

      {
         ()

         implicit val as
         = avcframewrk.forms.math.LexicalImperativeSynchronicityGiven.byDmCf
         
         val r0Aw = dispatcher.apply(e1) 

         val r0 = r0Aw(using summon[DummyImplicit] )

         // summon[r0.type <:< ResponseFormat.ofBoolean.XValue ]

      } : Unit

      ()

   }

   def applyXdpERTestAlt10(e1 : Product )( using
      //

      xdp
      : (
         Question.AcceptableResponseFormatDescExtractorAlgebraic[Product]
         {
            type ItsAcceptableResponseFormatDesc[+c]
               >: ResponseFormat.ofBoolean.type
               <: ResponseFormat.ofBoolean.type
         }
      )
      ,
   )
   = {

      {

         ({ val ef = xdp.responseFormat _ })
         val rf = e1.responseFormat
      }

      ()
   }

   def applyXdpERTestAlt1[C <: Product](e1 : C )( using
      //

      xdp
      : (
         Question.AcceptableResponseFormatDescExtractorAlgebraic[C]
         {
            type ItsAcceptableResponseFormatDesc[+c]
               >: ResponseFormat.ofBoolean.type
               <: ResponseFormat.ofBoolean.type
         }
      )
      ,
   )
   = {

      {

         ({ val ef = xdp.responseFormat _ })
         val rf = e1.responseFormat
      }

      ()
   }

} // Promptibility.XDispatcher.Impl.applyXdpERTest.










