













@main
def runSMain(): Unit
= {
   ()
   ()
   println(s"hello!")
   ()
   locally {
      import java.util.Locale
      import org.scalajs.dom
      val eb = avcframewrk.forms.templating.w3e.impl.js.s1.ebAll
      import com.raquo.laminar.api.L
      (if true then {
         val prz = {
            Iterator.fill(3)((z: Throwable) => {
               org.scalajs.dom.console.error(z)
            } )
            .concat({ org.scalajs.dom.console.error(s"too many exceptions logged ; no more will be emitted") ; Iterator.continually((z: Throwable) => {} ) } )
         }
         import  com.raquo.airstream.core.AirstreamError
         AirstreamError.unregisterUnhandledErrorCallback(AirstreamError.consoleErrorCallback )
         AirstreamError.registerUnhandledErrorCallback(z => { prz.next().apply(z) } )
      })
      def renderOnDomContentLoadedAlt[I](e: => dom.Element, run1: => com.raquo.laminar.nodes.ReactiveElement.Base )
      : Unit
      = {
         // scalajs.js.timers.setTimeout(3 * 1000 )(new com.raquo.laminar.nodes.RootNode(e , run1).mount() )
         L.renderOnDomContentLoaded(e, run1 )
      }
      // renderOnDomContentLoaded
      renderOnDomContentLoadedAlt(dom.document.querySelector("#app") match { case e => e.innerHTML = "" ; e } , {
         val a
         = {
            eb.PlainLocaleStringPlainTxtArticle(locale = Locale.ROOT.nn , txt = s"hello from SJS" )
            match { case e => e ++ e ++ e }
            // match { case e => e }
         }
         // identity { import L.* ; img(src := "/vite.svg", className := "logo", alt := "Vite logo") }
         (
            a
            ++
            eb.PlainLocaleStringPlainTxtArticle(locale = Locale.ROOT.nn , txt = s"to do it" )
            .asHavingDirectAction(eb.Action(baseTitle = "click here" )((_: Product) => { println(s"a click ") } ) ) 
            ++
            eb.PlainLocaleStringPlainTxtArticle(locale = Locale.ROOT.nn , txt = s"like that" )
            .asHavingDirectAction(eb.URLAction(baseTitle = "click here" )(PartialFunction.fromFunction((_: Any) => { import language.unsafeNulls ; new java.net.URI("javascript", s"""console.info("5 from the button")""" , null ) } ) ) ) 
            ++
            eb.PlainLocaleStringPlainTxtArticle(locale = Locale.ROOT.nn , txt = s"(really?)" )
            .asHavingDirectAction(eb.Action(baseTitle = "click here" )(PartialFunction.empty[Product, Unit] ) )  
            ++
            ({
               eb.PlainLocaleStringPlainTxtArticle(locale = Locale.ROOT.nn , txt = s"do no thing" )
               match { case label => {
                  val action = eb.Action(baseTitle = "click here" )(PartialFunction.empty[Product, Unit] )
                  eb.describeButtonByAction(action )
               } }
            })
            ++
            ({
               val var1 = com.raquo.laminar.api.L.Var[String]("hello! after the input box has entered this, this this has entered this this after has entered this this, this after has entered this this")
               val label = {
                  ;
                  eb.PlainLocaleStringPlainTxtArticle(locale = Locale.ROOT.nn , txt = s"progress" )
               }
               locally {
                  ;
                  val action = {
                     eb.VarEditingAction(baseTitle = label )(var1 )
                  }
                  eb.describeButtonByAction(action )
               }
            })
            ++
            ({
               val var1 = com.raquo.laminar.api.L.Var[Boolean ]({ true })
               val label = {
                  ;
                  eb.PlainLocaleStringPlainTxtArticle(locale = Locale.ROOT.nn , txt = s"encouraged" )
               }
               locally {
                  ;
                  val action = {
                     eb.VarEditingAction(baseTitle = label )(var1 )
                  }
                  eb.describeButtonByAction(action )
               }
            })
            ++
            ({
               val var1 = com.raquo.laminar.api.L.Var[BigDecimal ](1.25 )
               val label = {
                  ;
                  eb.PlainLocaleStringPlainTxtArticle(locale = Locale.ROOT.nn , txt = s"amt" )
               }
               locally {
                  ;
                  val action = {
                     eb.VarEditingAction(baseTitle = label )(var1 )
                  }
                  eb.describeButtonByAction(action )
               }
            })
            ++
            ({
               val var1 = com.raquo.laminar.api.L.Var[avcframewrk.forms.templating.w3e.pre.StdGsps.DateTime ]({ "2023-09-03" match { case e => ([A] => () => e.asInstanceOf[A] ).apply() } })
               val label = {
                  ;
                  eb.PlainLocaleStringPlainTxtArticle(locale = Locale.ROOT.nn , txt = s"date" )
               }
               locally {
                  ;
                  val action = {
                     eb.VarEditingAction(baseTitle = label )(var1 )
                  }
                  eb.describeButtonByAction(action )
               }
            })
         )
         match { case v => import eb.laminarInSpawneddLLImplicits.{given } ; v.spawn() }
      } )
   }
}
















