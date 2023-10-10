













import avcframewrk.forms.templating.reactjs.{
   < ,
   <+ ,
   KS ,
}
import avcframewrk.forms.templating.reactjs.e_ks.{
   ksDefaultReactJsImpl ,
   ksDefaultReactJsImplMethodism ,
}
import avcframewrk.forms.templating.reactjs.ReactComponentsImplicit.{*, given }
import avcframewrk.forms.templating.reactjs.{
   Fragment ,
}
object reactjs1 {
   export avcframewrk.forms.templating.reactjs.{
      AvfwReactFunctionComponent,
      ReactComponent1 ,
      ReactComponentsImplicit ,
      ReactCtx ,
      ReactElement ,
      ReactWithinRender ,
   }
}
import reactjs1.{*, given }

import java.util.Locale
import org.scalajs.dom

object rce {
   /* don't use `typings.react.global.React` */
   export typings.react.mod.{
      createElement ,
      createContext ,
   }
}

@main
def runSMain(): Unit
= {
   ;

   println(s"hello!")
   ()

   locally {
      ;

      ;

      val dateTimeStr
      = scalajs.js.Date()

      ({
         val r = typings.reactDom.clientMod.createRoot(dom.document.querySelector("#app") )
         // KS.Sl.applyDynamicNamed(using defaultJsxImpl ) (<)("???")( )
         // KS.Sl.applyDynamicNamed(<)("???")( )
         r
         .render({
         ;
         val c1
         = (
            rce.createElement("div", null, (
               Seq()
               :+ rce.createElement("p", null, "hello!" )
               // :+ rce.createElement("a", scalajs.js.Dictionary(("href", "javascript:console.log(\"opening the tutorial...\")" )), "consider reading the tutorial for more abt it." )
               :+ (
                  <.p("do some simple action" )
               )
               :+ (
                  <.a(
                     href = "javascript:console.log(\"opening the tutorial...\")"
                     ,
                     "consider reading the tutorial for about it."
                     ,
                     "consider reading the tutorial for about it."
                     ,
                  )
               )
               :+ (
                  <.button(`type` = "button", "do some simple action" )
               )
               :+ (
                  <.button(typ = "button", "do some simple action" )
               )
               :+ (
                  <.button(`type` = "button", "do my favourite things" )
               )
               :+ (
                  <.button(`typed` = "button", "do my favourite things" )
               )
               // :+ (
               //    <.span(`class` = "button", "do some simple action" )
               // )
               // :+ (
               //    <.label(`for` = "someButton", "do some simple action" )
               // )
               :+ (
                  <.label(htmlFor = "someButton", "do some simple action" )
               )
               :+ (
                  <.select(`child` = <.option("option side 1" ), <.option("option main 1" ) )
               )
               :+ (
                  <.select(children = Seq() :+ <.option("option side 1" ), <.option("option main 1" ) )
               )
               :+ (
                  <.button(typ = "button", "do some simple action" )
               )
               :+ (
                  <.p(attachedSnippet = "button", "do some simple action" )
               )
               :+ (
                  <.ul((
                     Seq()

                     :+ (
                        <.li(key = "button", "do my favourite things" )
                     )
                     // :+ (
                     //    <.li(key = "button" -> "", "do my favourite things" )
                     // )
                     :+ (
                        <.li(key = "button", "do my favourite things" )
                     )
                     // :+ (
                     //    <.li(key = "button" -> "", "do my favourite things" )
                     // )
                     // :+ (
                     //    <.li(ref = "button", "do those things" )
                     // )
                     // :+ (
                     //    <.li(ref = (_ => {} ) : Function1[Product, ?] , "do those things" )
                     // )
                     // :+ (
                     //    <.li(ref = ((_) => {} ) : scalajs.js.Function1[?, ?] , "do those things" )
                     // )
                     :+ (
                        <.li(key = "edothesethings", "do those things" )
                     )
                     :+ (
                        <.li(keyo = "edothesethings", "do those things" )
                     )
                     // :+ (
                     //    <.li(key = "edothesethings", "do those things" -> "bar" )
                     // )
                     :+ {
                        //
                        <+.apply("div" , (
                           Seq()
                           :+ <+.apply("button", `type` = "button", "do those things" )
                        ) )
                     }
                     :+ {
                        //
                        <+.apply("div" , (
                           Seq()
                           :+ <+.apply("button", "do those things" )
                           :+ <+.apply("button", `type` = "button", "do those things" )
                           :+ <+.apply("button", `type` = "button", "do those things" )
                        ) )
                     }
                     // :+ {
                     //    //
                     //    <+.apply("typings.react.mod.Fragment" , (
                     //       Seq()
                     //       :+ <+.apply("button", "do those things" )
                     //    ) )
                     // }
                     :+ {
                        //
                        <+.apply(Fragment._C , (
                           Seq()
                           :+ <+.apply("button", "ReactFragment" )
                           :+ <+.apply("button", "do those things" )
                        ) )
                     }
                     // :+ {
                     //    //
                     //    <+.apply(typings.react.mod.Fragment , (
                     //       Seq()
                     //       :+ <+.apply("button", "do those things" )
                     //    ) )
                     // }
                     :+ {
                        //
                        <+.apply("div" , (
                           Seq()
                           :+ <+.apply(Fragment._C, "do those things" )
                           :+ <+.apply(Fragment._C, "do those things" )
                        ) )
                     }
                     // :+ {
                     //    //
                     //    <+.apply("div" , (
                     //       Seq()
                     //       :+ <+.apply(typings.react.mod.Fragment, "do those things" )
                     //       :+ <+.apply(typings.react.mod.Fragment, "do those things" )
                     //    ) )
                     // }
                  ) )
               )
               // :+ (
               //    <.span(`className` = "button", children = (Seq() :+ "do some simple action" ) )
               // )
            ) : _* )
         )
         lazy val _ = (
            //
            Seq()
            :+ <+.apply(??? : ([TL <: Tu, Tu] =>> AvfwReactFunctionComponent[TL] )[Nothing, Any ] , "do those things" )
            :+ <+.apply(??? : ([TL <: Tu, Tu] =>> AvfwReactFunctionComponent[TL] )[Nothing, Any ] , "do those things" )
         )
         val Button1
         = reactjs1.ReactComponent1.describe((_: Any) => {
            <.button("clicked n times")
         })
         <.div((
            Nil
            :+ <+.apply(Button1, `type` = "button" )
            :+ <+.apply("button", `type` = "button", dateTimeStr )
         ))
         })
      })
   }
   //
}

implicit val defaultJsxImpl
: (
   // KS.SlMethodism._ToPeer[ksDefaultReactJsImpl.type ]
   // &
   KS.SlMethodism._ToUni[ksDefaultReactJsImplMethodism.slMethodsImpl.type ]
)
= _ => ksDefaultReactJsImplMethodism.slMethodsImpl
















