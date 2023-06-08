package cbsq.riffmt


















object epochChronography
{
   
            export  concurrent.duration.{Deadline, Duration, FiniteDuration }

            export  concurrent.duration.{DurationDouble, DurationLong, DurationInt }

            import  System.currentTimeMillis

            export fmseImpl.{apply => forAmtSinceEpoch }
            
            private 
            val fmseImpl = ((v: FiniteDuration) => ({
               
               Deadline((
                  (
                     /** duration from `Deadline(0.seconds)` to `TheEpoch` */ 
                     { 
                        val durationSinceDeadlineZero = (
                           ((Deadline.now - deadlineZero ) : FiniteDuration )
                        )
                        val ctmWhenDeadlineZero = (
                           currentTimeMillis()
                           + 
                           -durationSinceDeadlineZero.toMillis
                        )
                        Duration((
                           -ctmWhenDeadlineZero 
                        ) : Long, java.util.concurrent.TimeUnit.MILLISECONDS)
                     }  
                     : FiniteDuration
                  )
                  .`+`(v )
               ))

            }))
            
            /** 
             * 
             * `Deadline(0.seconds)`
             * 
             */ 
            val deadlineZero = (
               Deadline(0.second)
            )
            
}































