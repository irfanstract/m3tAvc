package avcframewrk.wauspawn











import scalajs.js

/* sadly, `package`s can't be aliased as concrete `object`s ... */
import typings.{std as dom }

object commonImplicits {
   ;

   ;

   // extension (dest: dom.AudioNode )
      // def startGainNode() :

   ;
}

object missingAudioParamMethods {
   ;

   ;

   extension (receiver: dom.AudioParam ) {
      private
      def impl1
      = receiver.asInstanceOf[typings.std.AudioParam ]
      export impl1.*
   }

   ;
}











val _ = {}
