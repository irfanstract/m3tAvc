package avcframewrk.forms.templating.reactjs




import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given }









/**
 * conversion from Slinky `ReactElement` to ScalablyTyped `ReactElement`
 * 
 * this conversion would generally be safe as
 * SJS is sufficiently lenient in unchecked-casts
 * 
 * no need to use `to` (as in `toList`, `toString`) ;
 * can use `as` (as in `Arrays.asList`, `asJava`, `asScalaCollectionView` ) as
 * the conv will not do any additional alloc
 * 
 */
/* choosing keyword `given` makes things harder ; use `implicit` instead */
;

object csftDefs {
   ;

   type SlinkyReactElement
   = slinky.core.facade.ReactElement

   type StReactElement
   = typings.react.mod.ReactElement

   ;
}

import csftDefs.{*}

implicit
object toForceBuildSlinkyElem
{
   ;

   extension [T <: (
      slinky.core.WithAttrs[?]
      | slinky.core.KeyAddingStage
   ) ] (e: T )
      //

      def build
      : SlinkyReactElement
      = {
         e
         .pipeLooseSelf ({
            case e : slinky.core.WithAttrs[?] =>
               e : SlinkyReactElement
            case e : slinky.core.KeyAddingStage =>
               e : SlinkyReactElement
         })
      }

   ;

}

implicit
object toConvertSlinkyElemFromStReactElem
{
   ;

   extension (e: StReactElement | SlinkyReactElement )
      transparent
      inline
      def asSlinkyReactElement
      = e.asInstanceOf[e.type & SlinkyReactElement ]
   //

   extension [Props] (e: avcframewrk.forms.templating.reactjs_s1.AvfwReactFunctionComponent[Props] )
      transparent
      inline
      def asSlinkyReactFunctionComponent
      = e.asInstanceOf[slinky.core.FunctionalComponent[Props] ]
   //

}

implicit
object toConvertSlinkyElemToStReactElem
{
   ;

   ;

   extension (e: SlinkyReactElement | StReactElement )
      transparent
      inline
      def asStReactElement
      = e.asInstanceOf[e.type & StReactElement ]
   //

   lazy val _ = {
      ;

      val e1
      = ??? : SlinkyReactElement

      val e2
      = ((e: Any) => Some[e.type](e) )(e1.asStReactElement )

      ;
   }

   extension [Props] (e: slinky.core.FunctionalComponent[Props] )
      transparent
      inline
      def asStReactFunctionComponent
      = e.asInstanceOf[avcframewrk.forms.templating.reactjs_s1.AvfwReactFunctionComponent[Props] ]
   //

   ;
}









