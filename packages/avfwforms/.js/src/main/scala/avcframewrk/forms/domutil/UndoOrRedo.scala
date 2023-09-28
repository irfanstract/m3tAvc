package avcframewrk.forms

package domutil


















def isUndoOrRedoKey
   (e: org.scalajs.dom.KeyboardEvent )
: Boolean
= {
   ;

   import language.unsafeNulls

   (
      e.ctrlKey &&
      {
         /* is `KeyZ` or `KeyY` pressed, but not `Shift` ? */
         e.key
         // .toLowerCase(java.util.Locale.ROOT )
         .matches("[zy]")
      }
   )
}

















