package avcframewrk.forms

package templating

package ll_util














def onWindowIvn
   [E <: org.scalajs.dom.Event, R <: Unit ]
   (evnm: String, l: scalajs.js.Function1[E, R] )
= new Selectable {
   ;

   lazy val wfcl
   : scalajs.js.Function1[E, R]
   = (e) => {
      ;

      org.scalajs.dom.window
      .removeEventListener(evnm, wfcl )

      l.apply(e)

      ;
   }

   def reRegisterWfcl()
   = {
      org.scalajs.dom.window
      .addEventListener(evnm, wfcl )
   }

} // onWindowIvn

;

def llOnElementTreeFocusOutIvn(
   //
   processFocusOutEvent : (e: org.scalajs.dom.FocusEvent) => Unit
   ,
)
= {
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

   ;

   import domutil.{isDescendantOrSelf as isDescendant }

   ({
      ;

      ;

      import L.{given }
      ;
      ({
         ;

         type Target
         >: ln.ReactiveElement[dom.Element]
         <: ln.ReactiveElement[dom.Element]

         ;

         ;
         new com.raquo.laminar.modifiers.Modifier[Target] {
            ;

            override
            def apply(dst: Target)
            = {
               ;

               ;

               val reRegisterWfcl
               = {
                  onWindowIvn("focusin", (e: dom.FocusEvent) => {
                     ;

                     if isDescendant(dst.ref)(e.target.asInstanceOf[dom.Node] ) then {}
                     else {
                        ;

                        given_Console_alt.info("focus away from the mini-form ", e.toString() )
                        processFocusOutEvent(e)

                     }

                     ;
                     // TODO
                     // (???)

                     ;
                  })
                  match { case f => f.reRegisterWfcl _ }
                  match { case f => {
                     //
                     () => {
                        ;
                        scalajs.js.timers
                        .setTimeout(30)(f() )
                     }
                  } }
               }

               L.eventProp[dom.FocusEvent ]("focusin").-->(e => {
                  ;
                  reRegisterWfcl()
               })
               .apply(dst)
            }

            ;
         }
      })
   })

}

;
















val _ = {}

