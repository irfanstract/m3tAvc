package avcframewrk.forms

package advanced















@annotation.experimental
object clauseInterweavedActionItemDispatcherImpl
{

   /* the language imports (though, for some reason putting em here works) */

   import language.experimental.clauseInterleaving

   /* the library name imports */

   import Promptibility.XDispatchTimePrereqsImpl

   /* the main def */

   trait Main
   {

      import Main.LexicalAsynchronicity

      /**
       * 
       * .
       * 
       * 
       * @param main the main action item
       * @param manager the main support for dealing with `main`
       * 
       * @param expectedAsynchronicity `LexicalImperativeSynchronicityGiven`
       * 
       */
      def apply
         [
            A <: Product ,
         ]
         (
            main
            : (
               A
               // Any
            )
            ,
         )
         [M >: main.type <: A ]
         (using
            manager: XDispatchTimePrereqsImpl[? >: M]
            ,
         )
         (using
            expectedAsynchronicity
            : LexicalAsynchronicity
            ,
         )
         : (
            ([R] =>> (
               expectedAsynchronicity.MainByReturnValue[R]
            ))
            [(
               // TODO wait until the first cand no longer crash the compiler, and switch back to it

               manager.ItsRfdXValue[main.type]
            ) ]

         ) // r

   }

   object Main {

      //

      type LexicalAsynchronicity
         = avcframewrk.forms.math.LexicalImperativeSynchronicityGiven.ByCc[[_] =>> Any ]

      object LexicalAsynchronicity {

         //
         
      } // LexicalAsynchronicity$

      def apply[
         A0 >: Product <: Product ,
      ](
         //
         runImpl: (
            [A <: A0 ]
            =>
            (e: A)
            =>
            (manager: XDispatchTimePrereqsImpl[? >: A] )
            ?=>
            (expectedAsynchronicity: LexicalAsynchronicity )
            ?=>
            expectedAsynchronicity.MainByReturnValue[manager.ItsRfdXValue[e.type] ]
         ) ,
      )
      = {
         //

         summon[A0 <:< Product ]

         summon[Product <:< A0 ]

         new AnyRef with Main {

            override
            def apply
               [
                  A <: Product ,
               ]
               (
                  main
                  : (
                     A
                  )
                  ,
               )
               [M >: main.type <: A ]
               (using
                  manager: XDispatchTimePrereqsImpl[? >: M]
                  ,
               )
               (using
                  expectedAsynchronicity
                  : LexicalAsynchronicity
                  ,
               )
            = {

               summon[A <:< A0 ]

               summon[M <:< A ]
               summon[main.type <:< M ]
               summon[main.type <:< A ]

               summon[XDispatchTimePrereqsImpl[? >: A] <:< XDispatchTimePrereqsImpl[? >: M] ]
               summon[manager.type <:< XDispatchTimePrereqsImpl[? >: M] ]

               runImpl(main )(using manager )
               match { case r => r }
            }

         }
      }

      def hangingUpInstance
      = {

         Main((
            [A <: Product]
            =>
            (e: A)
            =>
            (manager : XDispatchTimePrereqsImpl[? >: A] ) ?=>
            (asyncness: LexicalAsynchronicity ) ?=>
            {

               {
                  println(s"call: $e ")
                  println(s"ignoring ")
               }

               val responseFmt
                  : manager.rfExtractor.ItsAcceptableResponseFormatDesc[e.type]
                  = e.responseFormat

               summon[(
                  responseFmt.type
                  <:<
                  manager.ItsAcceptableResponseFormatDesc[e.type]
               )]

               summon[(
                  responseFmt.XValue
                  <:<
                  Promptibility.RfXAcoXValue[responseFmt.type ]
               )]
               summon[(
                  Promptibility.RfXAcoXValue[responseFmt.type ]
                  <:<
                  manager.ItsRfdXValue[e.type]
               )]
               // summon[(
               //    responseFmt.XValue
               //    <:<
               //    manager.ItsRfdXValue[e.type]
               // )]

               summon[(
                  responseFmt.type
                  <:<
                  Question.ResponseFormat.XAlgebraicCaseOps
               )]

               val appReturnValue
               = {
                  /** 
                   * 
                   * caveat:
                   * this trick
                   * depends on narrowing of type-member(s) arising from conjunction/intersection of the prefix-type.
                   * chances are
                   * a future version of the compiler will stop this from working anymore ;
                   * be prepared to amend this!
                   * 
                   */
                  (responseFmt match {
                     //

                     case fmt : Question.ResponseFormat.ofUnit.type =>
                        summon[Unit =:= fmt.XValue ]
                        // valueOf[Unit]
                        ???

                     case fmt : Question.ResponseFormat.ofBoolean.type =>
                        summon[Boolean =:= fmt.XValue ]
                        // false
                        ???

                  }) : responseFmt.XValue
               }

               summon[(
                  appReturnValue.type
                  <:<
                  responseFmt.XValue
               )]

               // summon[(
               //    appReturnValue.type
               //    <:<
               //    manager.rfExtractor.ItsAcceptableResponseFormatDesc[e.type]#XValue
               // )]

               // (
               //    asyncness.mainByEv(appReturnValue )
               // ) : asyncness.MainByReturnValue[responseFmt.XValue ]

               ???

            }
         ) )
      }

   } // Main$

} // `&&&%!`