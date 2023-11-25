// package avcframewrk.forms.templating.ext.airstreamify

package avcframewrk.forms

package templating

package ext.airstreamify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import compiletime.*

import quoted.*





import com.raquo.airstream



val _ = {
   ;

   // error({
   //    ;

   //    codeOf({
   //       ;

   //       summon[5 <:< Int ]
   //       summon[reflect.Typeable[Int] ]
   //       summon[reflect.Typeable[5.0] ]
   //       ( (1, 2, 3 ).toList )

   //       monocle.macros.GenLens[(Any, Any)](_._1)

   //       {
   //          cps.async[cps.monads.jsfuture.JSFuture] {}
   //       }

   //       ByGetFromO({
   //          ;
   //          println("Bar")
   //       })
   //    })
   // })
   ;

   ((
      path: String ,
   ) => {
      ;

      ByGetFromO.applyAndWarn({
         ;
         ByGetFromO.stubs.pick({
            airstream.state.Val(path )
         })
         println("Bar")
         ByGetFromO.stubs.pick({
            airstream.state.Val("back in the mood again" )
         })
      } : Unit )
   } )

   // /* an example of crooked usage (ie aliasing `stubs` into an opaque `val` ) */
   // ((
   //    path: String ,
   // ) => {
   //    ;

   //    ByGetFromO.applyAndWarn({
   //       ;

   //       val stubs
   //       : ByGetFromO.ImplementativeCtxOps._Any
   //       = ByGetFromO.stubs

   //       stubs.pick({
   //          airstream.state.Val(path )
   //       })
   //       println("Bar")
   //       stubs.pick({
   //          airstream.state.Val("back in the mood again" )
   //       })
   //    } : Unit )
   // } )

   ((
      path: String ,
   ) => {
      ;

      ByGetFromO.applyAndWarn({
         ;

         for {
            l0 <- "some"
            l1 <- Some("some")
         }
         yield {
            ;

            ByGetFromO.stubs.pick({
               airstream.state.Val(path )
            })
            println("Bar")
            ByGetFromO.stubs.pick({
               airstream.state.Val("back in the mood again" )
            })
         }
      } : Unit )
   } )
}


















val _ = {}
