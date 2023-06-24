package avcframewrk.forms.impl.javaswing















trait XWithNjpBase[+R, +RFac <: XwnjpFacBase[R] ](protected val xwnjpFac : RFac = { (new AnyRef with XwnjpFacBase[R] ).asInstanceOf[RFac] } )
extends 
AnyRef
// with XwnjpTest[R, (
//       {}
//       & RFac
// ) ]
{

   import xwnjpFac.{WithLayoutManager => Njp }

   import java.awt
   import javax.swing

   /**
    * 
    * a `JPanel` with one main content and four asides
    * 
    */
   // def newFourSidebarHolyGrailLayout
   def newFourAsidesContentPanel() : Njp[awt.BorderLayout ]

   /**
    * 
    * a `JPanel` for
    * mutually-logically-independent children with equivalent level-of-priority
    * 
    */
   def newAggregatingPanel() : Njp[awt.LayoutManager ]

   def newParagraphicPanel() : Njp[awt.LayoutManager ]

   def newThumbnailsListPanel() : Njp[awt.LayoutManager ]

   // def newComparativePanel() : Njp[awt.LayoutManager ]

   // type Njp[+SpecificLayoutMgr <: awt.LayoutManager ]
   //    <: R

} /* XWithNjp */

protected 
trait XwnjpTest[
   +R,
   +C <: (
      {}
      & XwnjpFacBase[R]
   ) ,

](private[XwnjpTest] val xwNjpC : C = (new AnyRef).asInstanceOf[C] )




trait XwnjpFacBase[+R] extends
AnyRef
with XwnjpFacWithLayoutManager[[_] =>> R ]

type XwnjpFacWithLayoutManager[+R[+L <: java.awt.LayoutManager ] ] = XwnjpFacWithLayoutManagerInvar[? <: ([L <: java.awt.LayoutManager ] =>> R[L]) ]

trait XwnjpFacWithLayoutManagerInvar[R[+L <: java.awt.LayoutManager ] ] { type WithLayoutManager[+L <: java.awt.LayoutManager ] >: R[L] <: R[L] }

type XwnjpEany[R] = ({ type Main[_] = R })


















