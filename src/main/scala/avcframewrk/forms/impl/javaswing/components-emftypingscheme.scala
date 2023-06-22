package avcframewrk.forms.impl.javaswing
















object util_%^**#% {
   
      trait SupportsGetNewInstanceNoArg[+R] {

         def newInstance() : R

      }

      trait SupportsDoSpawnByArgs1[-MainR, +MainRSpawned] {

         def spawn(c : MainR ): MainRSpawned

      }

}




// @deprecated
// protected
trait EmTypingImpl extends 
AnyRef
{

      //

      ;

      type MainR
         <: AnyRef

      type MainRSpawned
         <: AnyRef with java.io.Closeable

      def fromHasGetNewInstanceNoArg[
         C <: XNewInstance[MainRSpawned ] ,

      ](c : C ): C & MainR

      extension (c : MainR ) def toHasGetNewInstanceNoArg: XNewInstance[MainRSpawned ]
      
      type XNewInstance[+R]
         >: util_%^**#%.SupportsGetNewInstanceNoArg[R]
         <: util_%^**#%.SupportsGetNewInstanceNoArg[R]
      
      @deprecated
      abstract class MainRSpawnedImpl[+R](val main : R )
      extends
      AnyRef with java.io.Closeable
      {

         override
         def toString(): String = {
            s"MainR Instantiated (value: ${main } ; )"
         }

         //
         
      }

      val spw : (
         AnyRef
         with util_%^**#%.SupportsDoSpawnByArgs1[MainR, MainRSpawned]
         with XGspnc[MainR, MainRSpawned]

      )

      /**
       * 
       * this is
       * for by given expr returning a `MainRSpawnedImpl[R ]`.
       * the previously-mentioned alternatives
       * does not expose enough interface to access the resulting `?{ def close(): Unit }`
       * 
       */
      def mainRImplCircular[R <: java.awt.Component ](newInstance : => MainRSpawnedImpl[R ] ) : MainR

      /**
       * 
       * for whatever Component(s) Swing calls "lightweight components"
       * 
       */
      def mainRImplLw[R <: java.awt.Component ](newInstance : => R ) : MainR = mainRImplEither { newInstance }

      /**
       * 
       * for whatever Component(s) Swing calls "heavyweight components" like `Window`, `JFrame`
       * 
       */
      def mainRImplHeavywW[R <: java.awt.Window](newInstance : => R ) : MainR = mainRImplEither { newInstance }

      /**
       * 
       * when it's unclear whether it needs to be `ImplLw` or `ImplLHeavywW`
       * 
       */
      def mainRImplEither[R <: java.awt.Component ](newInstance : => R ) : MainR

} /* EmTypingImpl */

// protected 
trait XGspnc[+MainR, MainRSpawned] {

   def getSpawnedNativeComponent[C <: MainRSpawned](c : C ) : java.awt.Component
   
}

// @deprecated
// protected 
trait EmviTypingAndAllocImpl extends 
AnyRef
with EmTypingImpl
{

      /*   */

      opaque type MainR
         <: AnyRef
         = XNewInstance[MainRSpawned ]

      export util_%^**#%.{SupportsGetNewInstanceNoArg => XNewInstance }

      def fromHasGetNewInstanceNoArg[
         C <: XNewInstance[MainRSpawned ] ,

      ](c : C ): C & MainR = {
         c
      }

      extension (c : MainR ) def toHasGetNewInstanceNoArg: XNewInstance[MainRSpawned ] = {
         c
      }

      opaque type MainRSpawned
         <: AnyRef with java.io.Closeable
         = MainRSpawnedImpl[java.awt.Component ]
      
      object spw extends
      AnyRef
      with util_%^**#%.SupportsDoSpawnByArgs1[MainR, MainRSpawned]
      with XGspnc[MainR, MainRSpawned]
      {
         
         def spawn(c : MainR ): MainRSpawned = {
            c.newInstance()
         }

         def getSpawnedNativeComponent[C <: MainRSpawned](c : C ) = {
            c.main
         }

         // type Gspnc[C <: MainRSpawned] <: java.awt.Component = 
         //    C match {
         //       case XNewInstance => java.awt.Component
         //       case _ => java.awt.Component
         //    }

      }

      // abstract class MainRSpawnedImpl[+R](val main : R ) extends
      {

         //
         
      }
      
      override
      def mainRImplCircular[R <: java.awt.Component ](newInstance : => MainRSpawnedImpl[R ] ) : MainR = identity[XNewInstance[MainRSpawned ] ] (() => {

         val instance = newInstance

         instance
      })

      // def mainRImplLw[R <: java.awt.Component ](newInstance : => R ) : MainR = mainRImplEither { newInstance }

      // def mainRImplHeavywW[R <: java.awt.Window](newInstance : => R ) : MainR = mainRImplEither { newInstance }

      override
      def mainRImplEither[R <: java.awt.Component ](newInstance : => R ) : MainR = mainRImplCircular {

         val instance = newInstance

         new MainRSpawnedImpl(main = instance) {

            override
            def close(): Unit = {
               
               tryCloseAsIfCloseable(instance )

            }

         }
      }

      /**
       * 
       * utility
       * 
       */
      def tryCloseAsIfCloseable[C <: java.awt.Component ](instance : C ) : Unit = {
         
         for (c <- Some(instance).collect({ case c : java.awt.Window => c }) ) {
            c.dispose()
         }

      }


}


































