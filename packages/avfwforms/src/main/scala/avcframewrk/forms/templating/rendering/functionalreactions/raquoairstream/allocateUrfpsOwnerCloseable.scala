package avcframewrk.forms

package templating

package rendering

package functionalreactions.raquoairstream












import scalajs.js

import typings.{std as dom }

import com.raquo.airstream

import java.util.Locale

;

;









def allocateUrfpsOwnerCloseable
   ()
: (airstream.ownership.ManualOwner & java.io.Closeable )
= {
   ;

   new airstream.ownership.ManualOwner() with java.io.Closeable {
      override def close(): Unit = killSubscriptions()
   }
}












