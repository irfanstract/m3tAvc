package avcframewrk.forms.impl.javaswing









import avcframewrk.util.forms.pure.*




import abstractActionFactory.{XLabel, XF}

object allInterfacesGivens {

   import avcframewrk.forms.javaswing.util.enClosure

   import impl.*
   
   /* givens and UnsafeNulls */

   import concurrent.ExecutionContext.Implicits.global
   import language.unsafeNulls

   // abstract 
   open class spawnNewJFrame(title: String, contentPane: MainR ) extends AnyRef with java.io.Closeable
   {
      
      import java.awt
      import javax.swing

      import main.spawnContentPaneAndGetNative

      val f = new swing.JFrame
      
      f setDefaultCloseOperation swing.WindowConstants.DO_NOTHING_ON_CLOSE
      f addWindowListener {
         new awt.event.WindowAdapter {
            import awt.event.WindowEvent
            override def windowClosing(e: WindowEvent | Null): Unit = {
               runCloseButtonAction()
            }
         }
      }

      f setTitle title

      f setContentPane { spawnContentPaneAndGetNative(contentPane ) }

      f setIconImage {
         import awt.image.*
         new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB )
      }
      
      awt.EventQueue.invokeLater(() => { f.setSize(800, 400 ) ; f.setVisible(true) } )

      protected
      def disposeAllWindows() : Unit = {
         awt.EventQueue.invokeLater(() => { f.dispose() } )
      }

      def runCloseButtonAction() : Unit = {
         disposeAllWindows()
      }

      override
      def close(): Unit = closed1

      /* ensure not running more than once */
      private 
      lazy val closed1 = runCloseButtonAction()
      
   }

   given main :
   AnyRef
   with OmiAll[MainR]
   with {

      /* name imports */

      import java.awt
      import javax.swing

      import avcframewrk.forms.javaswing.actionObjUtil.setIcon

      /* exports */

      def renderButton(l: swing.Action) = mainRImplLw {
         new swing.JButton(l)
      }

      def renderIcon(l: swing.Action) = mainRImplLw {
         
         val lbl1 = new swing.JButton(l)
         lbl1.setUI({
            cbsq.avc.quick.javaswing.buttonIconFullSizeUi
         })
         lbl1
      }

      export impl.{mainRImplEither as getCustomComponent1 }

      // def getJFrameCompByTitleAndContentPane1(title: String, contentPane: MainR) : MainR = mainRImplCircular {
      //    //
      //    ???
      // }
      
      extension (c : MainR ) def spawnNow() = spawn(c )

      export spw.spawn

      export spw.getSpawnedNativeComponent

      def spawnAndGetNative[C <: MainR](c : C )  = {
         c
         match { case c => spawn(c) }
         match { case c => getSpawnedNativeComponent(c) }
      }

      @deprecated
      def spawnContentPaneAndGetNative[C <: MainR](c : C ) = {
         spawnAndGetNative(c )
         match { case c: java.awt.Container => c }
      }

      export allInterfacesGivens.spawnNewJFrame

      object newJPanelImpl {

         given Conversion[XNewInstance[MainRSpawned ], MainR] = {
            identity[MainR] _
         }

      }
      
      class newJPanelImpl[+SpecificLayoutMgr <: awt.LayoutManager ](layout : => SpecificLayoutMgr ) extends
      AnyRef with XNewInstance[MainRSpawned ]
      {

         export nsstHelper.newInstance

         private[newJPanelImpl] 
         val nsstHelper = {
            
            (mainRImplEither {

               val p = new swing.JPanel
               addNativesC.get()
               .apply(p )
               p
            })
         }

         private[newJPanelImpl] 
         var addNativesC = {
            new java.util.concurrent.atomic.AtomicReference[awt.Container => Unit ]({ case _ => })
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
         
         /**
          * 
          * `c add { spawnAndGetNative(addend ) }`
          * 
          */
         def add(addend : MainR ): Unit = {
            appendInit(c => {
               c add({ spawnAndGetNative(addend ) })
            })
         }
         
         /**
          * 
          * `c add({ spawnAndGetNative(addend ) }, itemConstraint )`
          * 
          * not supported by `LayoutManager`s which do not also `extends` `LayoutManager2` -
          * `constraint`-support requires `LayoutManager2`
          * 
          */
         def addOne(
            addend : MainR,
            itemConstraint : java.lang.Object ,

         )(using SpecificLayoutMgr <:< awt.LayoutManager2 ): Unit = {
            appendInit(c => {
               c add({ spawnAndGetNative(addend ) }, itemConstraint )
            })
         }
         
      }
      
      extension [C <: MainRSpawned](c : C ) def spawnedNativeComponent = {
         spw.getSpawnedNativeComponent(c )
      }

   }

   opaque type MainR
      <: AnyRef
      = XNewInstance[MainRSpawned ]
   
   private[allInterfacesGivens] 
   object impl {

      /*   */

      trait XNewInstance[+R] {

         def newInstance() : R

      }

      opaque type MainRSpawned
         <: AnyRef with java.io.Closeable
         = MainRImpl[java.awt.Component ]
      
      def fromXNewInstance(c : XNewInstance[MainRSpawned ] ): MainR = {
         c
      }

      extension (c : MainR ) def toXNewInstance: XNewInstance[MainRSpawned ] = {
         c
      }

      object spw {
         
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

      def mainRImplEither[R <: java.awt.Component ](newInstance : => R ) : MainR = mainRImplCircular {

         val instance = newInstance

         new MainRImpl(main = instance) {

            override
            def close(): Unit = {
               
               tryCloseAsIfCloseable(instance )

            }

         }
      }

      def mainRImplCircular[R <: java.awt.Component ](newInstance : => MainRImpl[R ] ) : MainR = identity[XNewInstance[MainRSpawned ] ] (() => {

         val instance = newInstance

         instance
      })

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




