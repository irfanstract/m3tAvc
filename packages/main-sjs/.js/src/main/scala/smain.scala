













@main
def runSMain(): Unit
= {
   ()
   ()
   println(s"hello!")
   ()
   locally {
      import org.scalajs.dom
      val eb = avcframewrk.forms.templating.w3e.impl.js.s1.ebAll
      import com.raquo.laminar.api.L
      L.renderOnDomContentLoaded(dom.document.querySelector("#app") match { case e => e.innerHTML = "" ; e } , {
         val a
         = eb.PlainLocaleStringPlainTxtArticle({ import java.util.Locale ; (Locale.ROOT.nn , "hello from SJS" ) } )
         // identity { import L.* ; img(src := "/vite.svg", className := "logo", alt := "Vite logo") }
         a.spawn()
      } )
   }
}
















