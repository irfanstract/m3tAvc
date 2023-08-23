package avcframewrk.forms

package templating

package w3e













export allDefsSjsImpl.*

protected
final
lazy
val allDefsSjsImpl
= {

   object jsWindow {

      // export org.scalajs.dom.{
      //    Element ,
      // }

   }

   import ebAll.{*, given}

   {
      //

      new AnyRef
      with avcframewrk.forms.templating.w3e.pre.Articles
      with avcframewrk.forms.templating.w3e.pre.Buttons
      {

         override
         type Article
         >: SjsEOps
         <: SjsEOps

         override
         val Action
         = {
            AcsfLabelledCallbackTranslator(
               //
               doFinalAdapt = (_, run, s) => {
                  // TODO
                  val edsb = {
                     Edsb[s._1.State, s._1.Title](
                        //

                        stateOption = s._2._1 ,
                        stateCheck = s._2._2 ,
                        baseTitle = s._2._3 ,

                        // TODO
                        stateTitle = ??? ,
                        
                     )
                  }
                  (edsb, () => { run().left.map({ case z: Throwable => z ; case () => new RuntimeException }).toTry.get } )
               } ,
            )
         }

         override
         type Action
            >: (Edsb[?, ?], () => Unit)
            <: (Edsb[?, ?], () => Unit)

         ;
         type ButtonArt
            >: ButtonOrAHrefDesc
            <: ButtonOrAHrefDesc

         override
         def describeButtonByAction(action: Action)
         = {
            ButtonOrAHrefDesc(
               //
               desc = {
                  ButtonOrAHrefDesc1(
                     //
                     edsb =
                        // Edsb(stateOption = ???)
                        // action._1
                        ???
                     ,
                     callback = (ev) => util.Try({ action._2.apply() })
                     ,
                  )
               },
            )
         }

      }
   }
} // allDefsImpl$












val _ = {}
