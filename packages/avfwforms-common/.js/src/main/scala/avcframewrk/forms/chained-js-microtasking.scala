package avcframewrk.forms

















import scalajs.js

private[avcframewrk]
trait GivenChainedJsMicroTaskedForms1[Cb1[+ActualR ] ]
{

   extension [ActualR] (f: Cb1[ActualR] ) {
      //

      def afterJsPr
         (s: js.Promise[Unit] )
      : Cb1[scalajs.js.Promise[ActualR] ]

      def afterTimeoutMillis
         (delayMillis: Double )
      : Cb1[scalajs.js.Promise[ActualR] ]

      def atNextMicroTask
         ()
      : Cb1[scalajs.js.Promise[ActualR] ]

   }

}

def startDelayMillis
   //
   (delayMillis: Double )
= {
   ;

   js.Promise[Unit]({
      case (r1, _) =>
         js.timers.setTimeout(delayMillis ) {
            r1(() )
         }
   })
}

def nextMicrotask()
= js.Promise.resolve(() )

given gcsm_fnc0
: GivenChainedJsMicroTaskedForms1[[R1] =>> (() => R1 ) ]
with {
   //

   extension [ActualR] (f: () => ActualR ) {
      //

      override
      def afterJsPr
         (schd: js.Promise[Unit] )
      = () => {
         schd
         .`then`({ case () => f() })
      }

      override
      def afterTimeoutMillis
         (delayMillis: Double )
      = () => {
         startDelayMillis(delayMillis )
         .`then`({ case () => f() })
      }

      override
      def atNextMicroTask
         ()
      = () => {
         nextMicrotask()
         .`then`({ case () => f() })
      }

   }

}











val _ = {}