package avcframewrk.forms.templating

















object AirstreamFromMonix
{

   private[AirstreamFromMonix]
   final
   lazy val sameThreadMonixScheduler
   : monix.execution.Scheduler
   = monix.execution.Scheduler(concurrent.ExecutionContext.parasitic )

} // AirstreamFromMonix$


















