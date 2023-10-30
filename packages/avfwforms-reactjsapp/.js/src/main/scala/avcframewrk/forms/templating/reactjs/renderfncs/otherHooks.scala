package avcframewrk.forms

package templating

package reactjs

package renderfncs













import scalajs.js

import org.scalajs.dom

import dom.console

;

;

;

;

;

export typings.react.mod.{useRef as useRefHolder }

;

;

/** 
 * a hook to handle diffing across consecutive redraws
 * 
 * you might actually not need to use this at all.
 * 
 */
object ConsecutiveRedrawDigestiveHook
{
   ;

   ;

   /** 
    * `ConsecutiveRedrawDigestiveHook`
    * 
    * *synchronously*
    * 
    */
   def useByFnc
      [Value]
      (
         digestAppropriately: Value => Value ,
         initialValue: => Value
         = null
         ,
         // whenToRun : ReSubscriptiveHook._When
         // ,
      )
      (using util.NotGiven[Any <:< Value ] )
   : Value
   = {
      ;

      val holder
      = useRefHolder[Value ] (initialValue = initialValue )

      digestAppropriately(holder.current)
      .pipeLooseSelf(newValue => { holder.current = newValue } )

      holder.current
   }

   ;
}

;

;

;

;

;













val _ = {}
