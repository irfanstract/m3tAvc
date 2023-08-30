













@main
def runSMain(): Unit
= {
   ()
   ()
   println(s"hello!")
   ()
   locally {
      import org.scalajs.dom
      import com.raquo.laminar.api.L
      // /* in general `render` is unsafe unless it's well known that `document` has become available, while `renderOnDomContentLoaded` is the safe one; but it didn't even work as expected */
      L.renderOnDomContentLoaded(dom.document.querySelector("#app") , {
         val a
         = avcframewrk.forms.templating.w3e.impl.js.s1.ebAll.PlainLocaleStringPlainTxtArticle({ import java.util.Locale ; (Locale.ROOT.nn , "hello" ) } )
         a.spawn()
         // identity { import L.* ; img(src := "/vite.svg", className := "logo", alt := "Vite logo") }
      } )
      // .mount()
   }
}
















