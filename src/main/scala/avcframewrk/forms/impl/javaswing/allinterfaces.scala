package avcframewrk.forms.impl.javaswing









import avcframewrk.util.forms.pure.*




import abstractActionFactory.{XLabel, XF}

object allInterfacesGivens extends 
AnyRef
// with Aig1
// {
// 
//    import avcframewrk.forms.javaswing.util.enClosure
// 
//    import impl.*
//    
//    /* givens and UnsafeNulls */
// 
//    import concurrent.ExecutionContext.Implicits.global
//    import language.unsafeNulls
// 
//    //
//    
// }
// 
// protected 
// trait Aig1 extends 
// AnyRef
{

   import avcframewrk.forms.javaswing.util.enClosure

   import impl.*
   
   /* givens and UnsafeNulls */

   import concurrent.ExecutionContext.Implicits.global
   import language.unsafeNulls

   private 
   lazy val defaultFrameIconImg = {
      ;

      import java.awt
      import javax.swing
   
      import awt.image.*
      
      locally {
         import avcframewrk.forms.javaswing.toStroked
         val b = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB )
         val g = b.createGraphics()
         g.scale(b.getWidth(), b.getHeight() )
         g.scale(1d / 2, 1d / 2)
         g.setPaint(awt.Color(0x0, 0x0, 0x0, 0x40 ) )
         g.fill(new awt.geom.Rectangle2D.Double(0, 0, 2, 2 ) )
         g.setPaint(awt.Color(0x0, 0x0, 0x0, 0xFF ) )
         g.fill(new awt.geom.Rectangle2D.Double(0.75, 0.75, 0.5, 0.5 ) )
         g.fill(new awt.geom.Rectangle2D.Double(0, 0, 2, 2 ) toStroked(awt.BasicStroke(0.125.toFloat ) ) )
         b
      }

      ;
   }

   // abstract 
   open class spawnNewJFrame(title: String, contentPane: MainR )
   extends
   AnyRef
   with java.io.Closeable
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
         defaultFrameIconImg
      }
      
      awt.EventQueue.invokeLater(() => { f.setSize(800, 400 ) ; f.setVisible(true) } )

      /**
       * 
       * unconditionally
       * make all the opened windows disappear
       * 
       */
      protected
      def disposeAllWindows() : Unit = {
         awt.EventQueue.invokeLater(() => { f.dispose() } )
      }

      /**
       * 
       * run
       * what's supposed to run whenever the "close" button gets clicked
       * 
       */
      def runCloseButtonAction() : Unit = {
         disposeAllWindows()
      }

      /**
       * 
       * `close()`.
       * 
       */
      override
      def close(): Unit = closed1

      /* ensure not running more than once */
      private 
      lazy val closed1 = runCloseButtonAction()
      
   }

   given main :
   AnyRef
   with OmiAll[MainR]
   with XWithNjp[MainR]
   with {

      /* name imports */

      import java.awt
      import javax.swing

      import avcframewrk.forms.javaswing.actionObjUtil.setIcon

      override
      def newCheckBoxState(
         //

         initiallySelected : Boolean ,

      ) : javax.swing.ButtonModel = {

         val jcb = new swing.JCheckBox
         jcb setSelected initiallySelected
         jcb.getModel()
      }

      /* exports */

      def renderButton(l: swing.Action) = mainRImplLw {
         new swing.JButton(l)
      }

      /**
       * 
       * display the Action's Icon dynamically
       * 
       */
      def renderDynamicPoster(l: swing.Action) = mainRImplLw {
         
         val lbl1 = new swing.JButton(l)
         lbl1.setUI({
            cbsq.avc.quick.javaswing.buttonIconFullSizeUi
         })
         lbl1
      }

      /**
       * 
       * display the Icon
       * 
       */
      def renderPoster(l: swing.Icon ) = {

         renderDynamicPoster({
            
            renderAbstractAction(label = l , callback = { case _ => } )
         })
      }

      override
      // def newFourSidebarHolyGrailLayout
      def newFourAsidesContentPanel() = {

         newJPanel({

            new awt.BorderLayout(gapSize, gapSize ) 
         })
      }

      override
      def newInlineSequencePanel() = {

         newJPanel({

            new awt.FlowLayout(awt.FlowLayout.LEADING ) 
         })
      }

      override
      final
      def newThumbnailsLayout() = {

         newJPanel({

            new awt.GridLayout(0, 2)
         })
      }

      private 
      def gapSize = {

         3
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

      /**
       * 
       * new `JPanel`
       * 
       * `layout` shall never reuse instances
       * 
       */
      def newJPanel[SpecificLayoutMgr <: awt.LayoutManager ](layout : => SpecificLayoutMgr ): Njp[SpecificLayoutMgr] = {

         newJPanelImpl(layout = layout )
      }

      override
      opaque type Njp[+SpecificLayoutMgr <: awt.LayoutManager ]
         <: MainR & newJPanelImpl[SpecificLayoutMgr ]
         =  MainR & newJPanelImpl[SpecificLayoutMgr ]

      object newJPanelImpl {

         // given Conversion[XNewInstance[MainRSpawned ], MainR] = {
         //    identity[MainR] _
         // }

         sealed 
         trait Etp[SpecificLayoutMgr] {
         ;
         
         type NotJavaxSwingGroupLayout
            = util.NotGiven[SpecificLayoutMgr <:< (swing.GroupLayout) ]

         type PerItemRequiresConstraints
            >: (util.NotGiven[SpecificLayoutMgr <:< (awt.GridBagLayout) ] )
            <: (util.NotGiven[SpecificLayoutMgr <:< (awt.GridBagLayout) ] )

         type SupportsPerItemConstraints
            >: (SpecificLayoutMgr <:< awt.LayoutManager2 )
            <: (SpecificLayoutMgr <:< awt.LayoutManager2 )

         }

      }
      
      class newJPanelImpl[+SpecificLayoutMgr <: awt.LayoutManager ](layout : => SpecificLayoutMgr ) extends
      AnyRef with XNewInstance[MainRSpawned ]
      {

         import newJPanelImpl.*

         export nsstHelper.newInstance

         private[newJPanelImpl] 
         val nsstHelper = {
            
            (mainRImplEither {

               val p = new swing.JPanel(layout )
               addNativesC.get()
               .apply(p )
               p
            })
         }

         /**
          * 
          * append the given instruction
          * 
          */
         def appendInit(impl : java.awt.Container => Unit ): Unit = {
            addNativesC
            .updateAndGet(fnc0 => {
               c => {
                  fnc0(c)
                  impl(c)
               }
            })
         }

         private[newJPanelImpl] 
         var addNativesC = {
            new java.util.concurrent.atomic.AtomicReference[awt.Container => Unit ]({ case _ => })
         }

         import etp.*

         /**
          * 
          * for typing only ; 
          * DO NOT USE!!!
          * 
          */
         protected
         final
         lazy
         val etp : Etp[? <: SpecificLayoutMgr ] = {
            object etpImpl extends Etp[? <: SpecificLayoutMgr ]
            etpImpl
         }
         
         /**
          * 
          * `c add { spawnAndGetNative(addend ) }`
          * 
          */
         def add(
            addend : MainR,

         )(using PerItemRequiresConstraints, NotJavaxSwingGroupLayout ): Unit = {
            appendInit(c => {
               c add({ spawnAndGetNative(addend ) })
            })
         }
         
         /**
          * 
          * `c add({ spawnAndGetNative(addend ) }, itemConstraint )`
          * 
          * not supported by `LayoutManager`s which do not also `extends` `LayoutManager2` -
          * `constraint`-support requires `LayoutManager2` .
          * also,
          * not supported for `javax.swing.GroupLayout` (shall instead be via its `Group` instances' methods )
          * 
          */
         def addOne(
            addend : MainR,
            itemConstraint : java.lang.Object ,

         )(using SupportsPerItemConstraints, NotJavaxSwingGroupLayout ): Unit = {
            appendInit(c => {
               c add({ spawnAndGetNative(addend ) }, itemConstraint )
            })
         }
         
      }
      
      extension [C <: MainRSpawned](c : C ) @deprecated def spawnedNativeComponent = {
         spw.getSpawnedNativeComponent(c )
      }

   }

   /* trait XWithNjp was here */
   {

   }

   opaque type MainR
      <: AnyRef
      = XNewInstance[MainRSpawned ]
   
   private[javaswing] 
   object impl {

      /*   */

      trait XNewInstance[+R] {

         def newInstance() : R

      }

      def fromXNewInstance(c : XNewInstance[MainRSpawned ] ): MainR = {
         c
      }

      extension (c : MainR ) def toXNewInstance: XNewInstance[MainRSpawned ] = {
         c
      }

      opaque type MainRSpawned
         <: AnyRef with java.io.Closeable
         = MainRImpl[java.awt.Component ]
      
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
      def mainRImplEither[R <: java.awt.Component ](newInstance : => R ) : MainR = mainRImplCircular {

         val instance = newInstance

         new MainRImpl(main = instance) {

            override
            def close(): Unit = {
               
               tryCloseAsIfCloseable(instance )

            }

         }
      }

      /**
       * 
       * this is
       * for by given expr returning a `MainRImpl[R ]`.
       * the previously-mentioned alternatives
       * does not expose enough interface to access the resulting `?{ def close(): Unit }`
       * 
       */
      def mainRImplCircular[R <: java.awt.Component ](newInstance : => MainRImpl[R ] ) : MainR = identity[XNewInstance[MainRSpawned ] ] (() => {

         val instance = newInstance

         instance
      })

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

}

trait OmiAll[R] extends 
AnyRef
with ButtonFactory1[javax.swing.Action, R ]
with XWithNjp[R ]
{

   export abstractActionFactory.lcafP.{renderButton as renderAbstractAction }

   def newCheckBoxState(
      //

      initiallySelected : Boolean ,

   ) : javax.swing.ButtonModel

   /**
    * 
    * returns
    * a new/independent `Document`
    * storing plain, unformatted text (MIME Type: `text/plain` ) (hence, UTF) doc.
    * 
    */
   def newPlainTextDocument(
      //

   ) : javax.swing.text.Document = {

      new javax.swing.text.PlainDocument
   }

   /**
    * 
    * returns
    * a new/independent `StyledDocument`.
    * 
    * avoid making any assumption about the returned `Document`'s actual `class` -
    * if it's necessary for it to be `HTMLDocument` then
    * use the following code instead.
    * 
    * ```
    * val doc = {
    * 
    *    import javax.swing
    * 
    *    val edp = new swing.JEditorPane()
    * 
    *    &#x2F;**
    *     * switch the EditorKit to HTMLEditorKit, so that
    *     * subsequently `setText` would  parse as HTML code/snippet ;
    *     * *&#x2F;
    *    edp setContentType("text/html")
    * 
    *    &#x2F;**
    *     * already invoked switch the EditorKit to HTMLEditorKit, so now
    *     * invoke `setText` with this HTML code/snippet ;
    *     * *&#x2F;
    *    edp setText("&lt;html> ... &lt;body> &lt;p> Paragraph 1 &lt;/p> ... ... ")
    * 
    *    (edp.getDocument() ) asInstanceOf[swing.text.html.HTMLDocument ]
    * } : swing.text.html.HTMLDocument
    * ```
    * 
    */
   def newStyledTextDocument(
      //

   ) : javax.swing.text.StyledDocument = {

      new javax.swing.text.html.HTMLDocument
   }

   def newThumbnailsLayout() : Njp[java.awt.LayoutManager]

   //

   /**
    * 
    * render a "button" wrapping the given `Action`
    * 
    */
   override
   def renderButton(l: javax.swing.Action): R

}

trait XWithNjp[+R]
{

   import java.awt
   import javax.swing

   /**
    * 
    * a `JPanel` with one main content and four asides
    * 
    */
   // def newFourSidebarHolyGrailLayout
   def newFourAsidesContentPanel() : Njp[awt.BorderLayout ]

   def newInlineSequencePanel() : Njp[awt.LayoutManager ]

   def newThumbnailsLayout() : Njp[awt.LayoutManager ]

   type Njp[+SpecificLayoutMgr <: awt.LayoutManager ]
      <: R

} /* XWithNjp */

private
val _ @ _ = {
   ;

   import allInterfacesGivens.main

   summon[(
      OmiAll[?]

   )]
   
}




