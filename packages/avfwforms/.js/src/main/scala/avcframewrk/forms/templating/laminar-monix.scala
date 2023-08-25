package avcframewrk.forms.templating

















implicit
object AirstreamFromMonix
{

   private[AirstreamFromMonix]
   final
   lazy val sameThreadMonixScheduler
   : monix.execution.Scheduler
   = monix.execution.Scheduler(concurrent.ExecutionContext.parasitic )

} // AirstreamFromMonix$


















