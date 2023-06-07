package cbsq.avc
















// protected 
sealed 
trait PhrStagedLoggingOps extends
AnyRef
{

   /**
    * 
    * cause emit of a message described by `term`, and
    * return a nested interface
    * 
    */
   def enstage(
      term: => String ,
      
   ) : EnstagedInterface

   type EnstagedInterface <: PhrStagedLogging
   
}

protected  
opaque type PhrStagedLogging <: PhrStagedLoggingOps
   = PhrStagedLoggingOps
   
object PhrStagedLogging
{

   @deprecated("experimental")
   opaque type ByDName[+Name <: Singleton & String] <: PhrStagedLoggingOps
      = PhrStagedLoggingOps

   /**
    * 
    * the default, "given" instance
    * 
    */
   transparent inline
   given defaultInstance[Name <: Singleton & String] : PhrStagedLogging.ByDName[Name] = {
      // compiletime.error("check your code. (PhrStagedLogging.defaultInstance)")
      // noOpInstance
      compiletime.summonFrom {
         case ctx : PhrStagedLogging.ByDName[?] =>
            ctx.enstage(term = compiletime.constValue[Name] )
         case _ =>
            noOpInstance
      }
   }

   /**
    * 
    * a no-op instance
    * 
    */
   lazy val noOpInstance : PhrStagedLogging = {

      new AnyRef with PhrStagedLogging
      {

         override
         def toString(): String = {
            s"PhrStagedLogging.noOpInstance"
         }

         override
         type EnstagedInterface 
            >: noOpInstance.type
            <: noOpInstance.type
            
         override
         def enstage(
            term: => String ,
            
         ) : EnstagedInterface = {

            noOpInstance

         }

      }
      
   }

   def whichLogsTo(
      emitLine: String => Either[?, Unit] ,
      
   ) : ByDName[Nothing] = {

      new AnyRef with PhrStagedLogging
      {

         override
         def toString(): String = {
            s"PhrStagedLogging.whichLogsTo(....) @ ${java.lang.Integer.toHexString(hashCode) }"
         }

         override
         type EnstagedInterface 
            >: PhrStagedLogging
            <: PhrStagedLogging
            
         override
         def enstage(
            term: => String ,
            
         ) : EnstagedInterface = {
            ;
            
            emitLine(s"$term")
            
            whichLogsTo(emitLine = (clientLine: String) => emitLine(s"[$term] $clientLine") )

         }

      }
      
   }

}




















































