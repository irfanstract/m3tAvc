package avcframewrk.forms

package templating

package ext.givmk

package impl


















import org.scalajs.dom

import com.raquo.laminar.{nodes as ln }

final
lazy val llBasedPhrContentAllocator
=  {
   import PhrasalContent.{_AllocatorImpl, _Allocator }
   _Allocator.fromTypeBox((
      _AllocatorImpl.forReprT[String]
   ))
}




















val _ = {}