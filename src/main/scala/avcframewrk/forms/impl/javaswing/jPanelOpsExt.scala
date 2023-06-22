package avcframewrk.forms.impl.javaswing


















type XWithNjp[+R] = (
   XWithNjpBase[R, XwnjpFacBase[R] & XwnjpFacWithLayoutManager[[_] =>> R ] ]
)

object XWithNjp {

   type WithNjpCovar[+R[+SpecificLayoutMgr <: java.awt.LayoutManager ] ] = (
      WithNjpInvar[? <: [SpecificLayoutMgr <: java.awt.LayoutManager ] =>> R[SpecificLayoutMgr] ]
   )

   trait WithNjpInvar[R[+SpecificLayoutMgr <: java.awt.LayoutManager ] ] {
      
      type Njp[+SpecificLayoutMgr <: java.awt.LayoutManager ]
         >: R[SpecificLayoutMgr]
         <: R[SpecificLayoutMgr]

   }

}





































