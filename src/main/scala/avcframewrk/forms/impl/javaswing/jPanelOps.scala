package avcframewrk.forms.impl.javaswing















// trait XWithNjp[
//    +R,
//    +C <: (
//       {}
//       & XwnjpFacWithLayoutManager[R]
//    ) ,

// ](private[XWithNjp] val xwNjpC : C = (new AnyRef).asInstanceOf[C] )
// {

//    import xwNjpC.WithLayoutManager

//    import java.awt
//    import javax.swing

//    summon[WithLayoutManager[?] <:< R ]

//    /**
//     * 
//     * a `JPanel` with one main content and four asides
//     * 
//     */
//    // def newFourSidebarHolyGrailLayout
//    def newFourAsidesContentPanel() : WithLayoutManager[awt.BorderLayout ]

//    def newInlineSequencePanel() : WithLayoutManager[awt.LayoutManager ]

//    def newThumbnailsLayout() : WithLayoutManager[awt.LayoutManager ]

//    def newComparativePanel() : WithLayoutManager[awt.LayoutManager ]

// } /* XWithNjpNew */

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


















