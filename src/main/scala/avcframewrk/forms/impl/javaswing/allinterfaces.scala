package avcframewrk.forms.impl.javaswing









import avcframewrk.util.forms.pure.*




import abstractActionFactory.{XLabel, XF}

object allInterfacesGivens {

   import avcframewrk.forms.javaswing.util.enClosure

   import impl.*
   
   given main :
   AnyRef
   with OmiAll[MainR]
   with {

      /* name imports */

      import java.awt
      import javax.swing

      import avcframewrk.forms.javaswing.actionObjUtil.setIcon

      /* givens and UnsafeNulls */

      import concurrent.ExecutionContext.Implicits.global
      import language.unsafeNulls

      /* exports */

      def renderButton(l: swing.Action) = mainRImplLw {
         new swing.JButton(l)
      }

      export impl.{newJPanelImpl as newJPanel }

      export spw.spawn

      export spw.getSpawnedNativeComponent

   }

   private[allInterfacesGivens] 
   object impl {

      /* givens and UnsafeNulls */

      import concurrent.ExecutionContext.Implicits.global
      import language.unsafeNulls

      /*   */

      trait XNewInstance[+R] {

         def newInstance() : R

      }

      opaque type MainR
         <: AnyRef
         = XNewInstance[MainRSpawned ]
      
      opaque type MainRSpawned
         <: AnyRef with java.io.Closeable
         = MainRImpl[java.awt.Component ]
      
      object spw {
         
         def spawn(c : MainR ): MainRSpawned = {
            c.newInstance()
         }

         def getSpawnedNativeComponent(c : MainRSpawned ): java.awt.Component = {
            c.main
         }

      }

      abstract class MainRImpl[+R](val main : R ) extends
      AnyRef with java.io.Closeable
      {

         override
         def toString(): String = {
            s"MainR Instantiated (value: ${main } ; )"
         }

         //
         
      }
         
      def mainRImplLw[R <: java.awt.Component ](newInstance : => R ) : MainR = mainRImplEither { newInstance }

      def mainRImplHeavywW[R <: java.awt.Window](newInstance : => R ) : MainR = mainRImplEither { newInstance }

      def mainRImplEither[R <: java.awt.Component ](newInstance : => R ) : MainR = identity[XNewInstance[MainRSpawned] ] (() => {

         val instance = newInstance

         new MainRImpl(main = instance) {

            override
            def close(): Unit = {
               
               tryCloseAsIfCloseable(instance )

            }

         }
      })

      class newJPanelImpl[+SpecificLayoutMgr <: java.awt.LayoutManager ](layout : => SpecificLayoutMgr ) extends
      AnyRef with XNewInstance[MainRSpawned ]
      {

         import spw.*

         export nsstHelper.newInstance

         private[newJPanelImpl] 
         val nsstHelper : MainR = mainRImplEither {

            val p = new javax.swing.JPanel
            addNativesC.get()
            .apply(p )
            p
         }

         private[allInterfacesGivens] 
         var addNativesC = {
            new java.util.concurrent.atomic.AtomicReference[java.awt.Container => Unit ]({ case _ => })
         }

         def appendInit(impl : java.awt.Container => Unit ): Unit = {
            addNativesC
            .updateAndGet(fnc0 => {
               c => {
                  fnc0(c)
                  impl(c)
               }
            })
         }
         
         def add(addend : MainR ): Unit = {
            appendInit(c => {
               c.add({ val instance = spawn(addend) ; getSpawnedNativeComponent(instance) })
            })
         }
         
         def addOne(addend : MainR, itemConstraint : java.lang.Object ) : Unit = {
            appendInit(c => {
               c.add({ val instance = spawn(addend) ; getSpawnedNativeComponent(instance) }, itemConstraint )
            })
         }
         
      }
      
      def tryCloseAsIfCloseable[C <: java.awt.Component ](instance : C ) : Unit = {
         
         for (c <- Some(instance).collect({ case c : java.awt.Window => c }) ) {
            c.dispose()
         }

      }

   }

}

trait OmiAll[R] extends 
AnyRef
with ButtonFactory1[javax.swing.Action, R ]
{

   export abstractActionFactory.lcafP.{renderButton as renderAbstractAction }

   //

}

private
val _ @ _ = {
   ;

   import allInterfacesGivens.main

   summon[(
      OmiAll[?]

   )]
   
}




