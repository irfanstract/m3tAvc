package cbsq.avc













/**
 * 
 * defines these two members describing the service's instantiative parametre
 * - `Args`
 * 
 * see [[Gawb]] and [[EArgsAndTheirBuildability]].
 * 
 */
// @deprecated("experimental")
// protected 
trait Argin
{
   
   type Args
   
}

/**
 * 
 * the complement, *wrt* [[EArgsAndTheirBuildability]], of [[Argin]]
 * 
 */
@deprecated("experimental")
// protected 
trait Gawb 
{
   
   /**
    * 
    * applying *the builder pattern* without unnecessarily constraining `Args` to specific `trait`,
    * here shall be this `given` for `Conversion` from it to `ArgsBuilderBaseOps`
    * 
    */
   given argsBuildable[
      Builder <: ArgsBuilderBaseOps,
   ]: (
      Conversion[
         ArgsLeadingToBuilder[Builder ], 
         Builder ,
      ]
   )

   /**
    * 
    * a subtype of `Args` this way
    * 
    */
   type ArgsLeadingToBuilder[
      +Builder <: ArgsBuilderBaseOps,
   ]
   
   /**
    * 
    * the base-interface which all [[Args]] builders shall implements
    * 
    */
   type ArgsBuilderBaseOps <: AnyRef
   

}

/**
 * 
 * a derivative of [[Argin]] which
 * defines 
 * these set of members 
 * describing the service's instantiative parametre and their buildability (*the builder pattern*)
 * 
 */
@deprecated("experimental")
// sealed 
trait EArgsAndTheirBuildability
   extends 
   AnyRef
   with Argin
   with Gawb
{ 

   type Args
   
   /**
    * 
    * applying *the builder pattern* without unnecessarily constraining `Args` to specific `trait`,
    * here shall be this `given` for `Conversion` from it to `ArgsBuilderBaseOps`
    * 
    */
   override 
   given argsBuildable[
      Builder <: ArgsBuilderBaseOps,
   ]: (
      Conversion[
         ArgsLeadingToBuilder[Builder ], 
         Builder ,
      ]
   )
   
   /**
    * 
    * a subtype of `Args` this way
    * 
    */
   type ArgsLeadingToBuilder[
      +Builder <: ArgsBuilderBaseOps,
   ] 
      <: Args
      
   /**
    * 
    * applying *the builder pattern*,
    * everyone need this as the starting-point
    * 
    */
   val argsInitially : (
      ArgsLeadingToBuilder[ArgsBuilderBaseOps]
   )
   
   /**
    * 
    * the base-interface which all [[Args]] builders shall implements
    * 
    */
   type ArgsBuilderBaseOps 
      <: AnyRef
   
}

object EaBuilder 
{
   
   /**
    * 
    * defines exactly these stuffs.
    * introduced as a workaround to the compiler limitations in handling type-cycles.
    * 
    */
   @deprecated("experimental")
   // sealed 
   trait XDerivedTypes[+Host <: Gawb] {

      val host : Host
      
      type Derived 
            // >: host.ArgsLeadingToBuilder[DerivedBuilder]
            <: host.ArgsLeadingToBuilder[DerivedBuilder]
      type DerivedBuilder <: (
         host.ArgsBuilderBaseOps
      )

   }
   
}











