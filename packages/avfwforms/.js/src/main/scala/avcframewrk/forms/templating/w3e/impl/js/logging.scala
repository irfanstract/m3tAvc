package avcframewrk.forms

package templating

package w3e.impl.js.s1











final
lazy val topLevelJsConsole
: Console
= consoleByOps {
   new ConsoleOps
   {
      ;
      def info(msg: => Any, e: Any * ) : Unit = org.scalajs.dom.console.info(msg, e : _* )
      def warn(msg: => Any, e: Any * ) : Unit = org.scalajs.dom.console.warn(msg, e : _* )
   }
}

val _ = {
   /** 
    * the default Console sucks ;
    * let's override the setting
    */
   topLevelConsole
   = topLevelJsConsole
}

implicit def given_ActualConsoleProvider
: ActualConsoleProvider
= {
   ({
      ;
      topLevelJsConsole
      .info(s"an ActualConsoleProvider based on the JS console ")
   })
   ActualConsoleProvider(() => topLevelJsConsole )
}









