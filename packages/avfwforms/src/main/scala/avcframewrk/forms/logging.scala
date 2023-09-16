package avcframewrk.forms













trait ConsoleOps {
   def info(msg: => Any, e: Any * ) : Unit
   def warn(msg: => Any, e: Any * ) : Unit
}

opaque type Console
<: AnyRef & ConsoleOps
= ConsoleOps

def consoleByOps
   (c: ConsoleOps )
: Console
= c

final
lazy val silentConsole
: Console
= {
   new ConsoleOps
   {
      def info(msg: => Any, e: Any * ) : Unit = {}
      def warn(msg: => Any, e: Any * ) : Unit = {}
   }
}

extension (parent: ConsoleOps )
   def subConsole(title: String)
   = {
      val prefixWithoutSpacing
      = s"[${title} ]" 
      new Console {
         ;
         def info(msg: => Any, e: Any * ) : Unit = parent.info(msg.toString().prependedAll(prefixWithoutSpacing + " " ) , e : _* )
         def warn(msg: => Any, e: Any * ) : Unit = parent.warn(msg.toString().prependedAll(prefixWithoutSpacing + " " ) , e : _* )
      }
   }

transparent
inline def currentMethodName
: String
= {
   import language.unsafeNulls
   new Exception().getStackTrace().head match { case e => s"${e.getMethodName() } in ${e.getClassName().replaceAll("u|o|e|i", "") }" }
}

/* `transparent` is very important here, to let devs know in advance the acquired `Console` inst will be a no-op one. */
transparent
inline given given_Console
: Console
= {
   ;
   val st = currentMethodName
   consoleWithTitle(title = st )
}

transparent
inline def given_Console_alt
: Console
= {
   ;
   val st = currentMethodName
   given Console
   = {
      compiletime.summonInline[ActualConsoleProvider ]
      .apply()
   }
   consoleWithTitle(title = st )
}

transparent /* `transparent` is very important here, to let devs know in advance the acquired `Console` inst will be a no-op one. */
inline def consoleWithTitle(title: String )
: Console
= {
   ;
   compiletime.summonFrom({
      case e : Console =>
         e.subConsole(title = title )
      case _ =>
         warnNoOpConsole()
         silentConsole
   })
}

private[avcframewrk]
// opaque, virtual
def warnNoOpConsole()
: Unit
= {
   ;
   wnocPipe
   .onNext(() )
}
private[avcframewrk]
// opaque, virtual
def warnNoOpConsoleNow()
: Unit
= {
   ;
   given_Console_alt.info(s"no logging will happen this way as there's no pre-existing 'given' Console in-scope . to fix this, have one in-scope first.")
}
private
final
lazy
val wnocPipe
= {
   ;
   startThrottledService( )(_ => {
      warnNoOpConsoleNow()
   } )
}

/** 
 * a provider of Console which will really work
 * 
 */
@annotation.implicitNotFound("no given instance of ActualConsoleProvider was found.")
opaque type ActualConsoleProvider
<: () => Console
= () => Console

object ActualConsoleProvider {
   ;

   def apply
      (v: () => Console )
   : ActualConsoleProvider
   = v

   ;
}

var topLevelConsole
: Console
= {
   def kConsoleLog(msg: => Any, e: Any* ) : Unit
   = {
      import language.unsafeNulls
      System.err.println(Seq().:+(msg).:++(e).mkString(". ") )
   }
   new ConsoleOps
   {
      ;
      def info(msg: => Any, e: Any * ) : Unit = kConsoleLog(msg, e : _* )
      def warn(msg: => Any, e: Any * ) : Unit = kConsoleLog(msg, e : _* )
   }
}

given ActualConsoleProvider
= {
   ActualConsoleProvider(() => topLevelConsole )
}


















