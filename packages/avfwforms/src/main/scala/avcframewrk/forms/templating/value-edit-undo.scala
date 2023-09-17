package avcframewrk.forms

package templating













enum ValueEditOrUndoOrRedo
{
   ;

   case ForEditTo[+Value](value: Value )

   case ForUndo()
   case ForRedo()

   ;
}












