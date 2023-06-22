package avcframewrk.forms.impl.javaswing









import avcframewrk.util.forms.pure.*

import avcframewrk.forms.javaswing.*




import abstractActionFactory.{XLabel, XF}

object allInterfacesGivens extends 
AnyRef
with Aig1More
{

   import avcframewrk.forms.javaswing.localUtil.enClosure

   import impl.*
   
   /* givens and UnsafeNulls */

   import concurrent.ExecutionContext.Implicits.global
   import language.unsafeNulls

   /* main exports */

   private 
   lazy val defaultFrameIconImg = {
      ;

      avcframewrk.forms.impl.javaswing.defaultAppIconImg

      ;
   }

   // abstract 
   open class spawnNewJFrame(title: String, contentPane: MainR )
   extends
   // AnyRef
   ImplSpawnNewJFrame(
      //

      title = title ,
      newContentPane = () => { main.spawnContentPaneAndGetNative(contentPane ) } ,
      
      iconImage = defaultFrameIconImg ,

   )
   with java.io.Closeable
   {
      
      import java.awt
      import javax.swing

      import main.spawnContentPaneAndGetNative

   }

   given main :
   AnyRef
   with OmiAll[MainR]
   with XWithNjpBase[MainR, XwnjpFacBase[MainR] & XwnjpFacWithLayoutManagerInvar[[L <: java.awt.LayoutManager] =>> (MainR & XJPanelsImplImpl#newJPanelImpl[L] ) ] ]
   with ^&%%^
   with ComponentSpwReExports
   with XWithCDoSpawnNewJFrame
   with {

      /* name imports */

      import java.awt
      import javax.swing

      import avcframewrk.forms.javaswing.actionObjUtil.setIcon

      /* exports */  

      // export xjpiImpl.*
      export xjpiImpl.{*}

      private[javaswing]
      final
      lazy val xjpiImpl = {
         new AnyRef
         with XJPanelsImpl(otherComponents = this )
         // with XwnjpTest[MainR, (
         //       {}
         //       & XwnjpFacBase[MainR]
         //       & XwnjpFacWithLayoutManagerInvar[[L <: java.awt.LayoutManager] =>> XJPanelsImplImpl#newJPanelImpl[L] ]
         // ) ]
         with XWithNjpBase[MainR, XwnjpFacBase[MainR] & XwnjpFacWithLayoutManagerInvar[[L <: java.awt.LayoutManager] =>> (MainR & XJPanelsImplImpl#newJPanelImpl[L] ) ] ]
         // with XWithNjp.WithNjpInvar[[L <: java.awt.LayoutManager] =>> (MainR & XJPanelsImplImpl#newJPanelImpl[L] )]
      }

   }

   private[javaswing] 
   trait XWithCDoSpawnNewJFrame extends
   AnyRef
   {

      //
      
      export allInterfacesGivens.spawnNewJFrame

   } /* XWithCDoSpawnNewJFrame */

   object impl extends
   AnyRef
   with EmviTypingAndAllocImpl
   
}

protected 
// sealed
trait Aig1More extends 
AnyRef
with Aig1
{

   //

   export aigimImpl.*

   private[Aig1More]
   object aigimImpl extends Aig1MoreDefs(aigimImplem = this)
   
}

protected 
// sealed
trait Aig1MoreDefs[
   +Ctx <: Singleton & Aig1 ,

](
   //

   private[Aig1MoreDefs]
   val aigimImplem : Ctx ,

) extends 
AnyRef
{

   import aigimImplem.*

   import avcframewrk.forms.javaswing.localUtil.enClosure

   import impl.*
   
   import java.awt
   import javax.swing

   import avcframewrk.forms.javaswing.actionObjUtil.setIcon

   /* givens and UnsafeNulls */

   import concurrent.ExecutionContext.Implicits.global
   import language.unsafeNulls

   /* main exports */

   // given Conversion[(
   //       AnyRef
   //       // with OmiAll[MainR]
   //       // with XWithNjp[MainR]
   //       with ^&%%^
   //       with ComponentSpwReExports
   //       //
   // ), XJPanelsImpl] = {
   //
   //    e => {
   //       new AnyRef
   //       with XJPanelsImpl(otherComponents = e )
   //    }
   // }

   private[javaswing] 
   trait XJPanelsImpl(
      //

      private[XJPanelsImpl]
      val otherComponents : (
         AnyRef
         // with OmiAll[MainR]
         // with XWithNjp[MainR]
         with ^&%%^
         with ComponentSpwReExports
         //
      ) ,

   ) extends
   AnyRef
   with XWithNjpBase[MainR, XwnjpFacBase[MainR] & XwnjpFacWithLayoutManagerInvar[[L <: java.awt.LayoutManager] =>> (MainR & XJPanelsImplImpl#newJPanelImpl[L] ) ] ]
   {
      this : Any =>

      import otherComponents.*

      /* name imports */

      /* exports */

      export xwnjpFac.{WithLayoutManager => IWithLayoutManager }

      private
      def byEvid1[L <: java.awt.LayoutManager](): Unit = {
         summon[xwnjpFac.WithLayoutManager[L] <:< MainR ]
         // summon[(MainR & XJPanelsImplImpl#newJPanelImpl[L] ) <:< xwnjpFac.WithLayoutManager[L] ]
         // identity[(MainR & XJPanelsImplImpl#newJPanelImpl[L] ) => (
         //    (XwnjpFacBase[MainR] & XwnjpFacWithLayoutManagerInvar[[L <: java.awt.LayoutManager] =>> (MainR & XJPanelsImplImpl#newJPanelImpl[L] ) ] )#WithLayoutManager[L]
         // ) ](e => e )
         // identity[xwnjpFac.WithLayoutManager[L] => (
         //    (XwnjpFacBase[MainR] & XwnjpFacWithLayoutManagerInvar[[L <: java.awt.LayoutManager] =>> (MainR & XJPanelsImplImpl#newJPanelImpl[L] ) ] )#WithLayoutManager[L]
         // ) ](e => e )
         identity[(MainR & XJPanelsImplImpl#newJPanelImpl[L] ) => xwnjpFac.WithLayoutManager[L] ](e => e )
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

      /**
       * 
       * new `JPanel`
       * 
       * `layout` shall never reuse instances
       * 
       */
      def newJPanel[SpecificLayoutMgr <: awt.LayoutManager ](layout : => SpecificLayoutMgr ) = {

         newJPanelImpl(layout = layout )
         match { case c => fromHasGetNewInstanceNoArg(c) }
         match { case c => c }
      }

      // override
      // opaque type Njp[+SpecificLayoutMgr <: awt.LayoutManager ]
      //    <: MainR & newJPanelImpl[SpecificLayoutMgr ]
      //    =  MainR & newJPanelImpl[SpecificLayoutMgr ]

      export njpImplImpl.newJPanelImpl
      
      private[XJPanelsImpl]
      final
      lazy val njpImplImpl = {
         new AnyRef with XJPanelsImplImpl(otherComponents = otherComponents )
      }

   }

   private[javaswing] 
   trait XJPanelsImplImpl(
      //

      private[XJPanelsImplImpl]
      val otherComponents : (
         AnyRef
         // with OmiAll[MainR]
         // with XWithNjp[MainR]
         with ^&%%^
         with ComponentSpwReExports
         //
      ) ,

   ) extends
   AnyRef
   {

      /* base closure */

      import otherComponents.*

      /* utility imports */

      /* exports */

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
      AnyRef with util_%^**#%.SupportsGetNewInstanceNoArg[MainRSpawned ]
      {

         import newJPanelImpl.*

         export nsstHelper.newInstance

         private[newJPanelImpl] 
         val nsstHelper = {
            
            (mainRImplEither {

               val p = new swing.JPanel(layout )
               addNativesCAlt
               .addOperand(p)
               p
            })
            .toHasGetNewInstanceNoArg
         }

         /**
          * 
          * append the given instruction
          * 
          */
         def appendInit(impl : java.awt.Container => Unit ): Unit = {

            addNativesCAlt

            .addOperator({

               (c : java.awt.Container ) => {

                  /**
                   * actually run `impl`
                   */
                  impl(c)

                  /**
                   * mitigates
                   * the failure of AWT/Swing to stay in-sync following the *add-or-modify* calls
                   */
                  c.revalidate() 

               } 
            })
            
         }

         private[newJPanelImpl] 
         val addNativesCAlt = {
            new XDecorativeFncQueue[java.awt.Container](
               //
            )
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
      
   }

   sealed
   trait ^&%%^ extends
   AnyRef
   with OmiAll[MainR]
   with ENewCheckBoxStateImpl
   with XWithNjp[MainR]
   with Egcc
   {
      this : (
         AnyRef
      ) =>

      /* name imports */

      /* exports */

      export eBasicCompsImpl.*

      private[Aig1MoreDefs]
      final lazy
      val eBasicCompsImpl = {
         EBasicCompsImpl(otherComponents = this )
      }

   } /* ^&%%^ */

   object ^&%%^
   {

      given Conversion[^&%%^, Rtdd] = {

         e => Rtdd(otherComponents = e )
      }

   }

   class Rtdd(
      //
      
      private[Rtdd] val otherComponents : Egcc ,

   )
   {
      this : Any =>

      import otherComponents.*

      /* name imports */

      /* exports */

      import avcframewrk.util.lavf.{conditionalTyping as rtddConditionalTyping}

      def renderTextDocDisplay(
         //

         src : swing.text.Document ,
         onlyShortPhrase : (
            rtddConditionalTyping.IfConforms[src.type, swing.text.StyledDocument, [_] =>> false, [_] =>> Boolean ]
            
         ) = false ,
         
         editing : Boolean = false ,
         editorKit : (
            rtddConditionalTyping.IfConforms[editing.type, true, [_] =>> (swing.text.EditorKit | Null), [_] =>> Null ]
            
         ) = null ,
         
      ) = getCustomComponent1 {

         (src, onlyShortPhrase) match {
            //

            case (_, true) =>

               new swing.JTextField(src, null, 0 )

            case (src : swing.text.PlainDocument, false) =>

               new swing.JTextArea(src)

            case (src : swing.text.StyledDocument, false) =>

               new swing.JTextPane(src)

            case (src, false) =>

               val edp = new swing.JEditorPane

               if editorKit != null then {
                  edp setEditorKit editorKit
               }
               edp setDocument src
               
               edp

         }
         match { case e => e.setEditable(editing) ; e }
      }

   }

}

protected 
trait Aig1 extends 
AnyRef
{ allInterfacesGivens =>

   import avcframewrk.forms.javaswing.localUtil.enClosure

   private[javaswing] 
   val impl : (
      AnyRef
      & EmTypingImpl
   )
   
   import impl.*
   
   /* givens and UnsafeNulls */

   import concurrent.ExecutionContext.Implicits.global
   import language.unsafeNulls

   /* main exports */

   private[javaswing] 
   trait ENewCheckBoxStateImpl
   extends
   AnyRef
   {
      this : OmiAll[?] =>

      /* name imports */

      import java.awt
      import javax.swing

      import abstractActionFactory.lcafP.{renderButton as renderAbstractAction }

      /* exports */

      override
      def newCheckBoxState(
         //

         initiallySelected : Boolean ,

      ) : swing.ButtonModel = {

         val jcb = new swing.JCheckBox
         jcb setSelected initiallySelected
         jcb.getModel()
      }

   }

   private[javaswing] 
   class EBasicCompsImpl(
      //
      
      private[EBasicCompsImpl]
      val otherComponents : (
         AnyRef
      ) ,

   )
   extends
   AnyRef
   with DefinesDoRenderButtonA1[javax.swing.Action, MainR]
   {

      /* name imports */

      import java.awt
      import javax.swing

      import abstractActionFactory.lcafP.{renderButton as renderAbstractAction }

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

   }

   /**
    * 
    * `export impl.{mainRImplEither as getCustomComponent1 }`
    * 
    */
   trait Egcc extends
   AnyRef
   {

      export impl.{mainRImplEither as getCustomComponent1 }

   }

   protected[javaswing]
   trait ComponentSpwReExports {

      export componentSpw.*

   } /* ComponentSpwReExports */

   private[javaswing] 
   object componentSpw {
      
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

      extension [C <: MainRSpawned](c : C ) @deprecated def spawnedNativeComponent = {
         spw.getSpawnedNativeComponent(c )
      }

   }

   /* trait XWithNjp was here */
   {

   }

   type MainR = impl.MainR
   
   // private[javaswing] 
   // object typingAndFactoryImpl extends 
   // AnyRef
   // {
   //
   //    /*   */
   //   
   // }
   // final lazy
   // val typingAndFactoryImpl = {
   //    emviTypingImpl
   // }
   
}

trait ReExportsDoRenderAbstractAction
{
   
   export abstractActionFactory.lcafP.{renderButton as renderAbstractAction }

}

trait OmiAll[R] extends 
AnyRef
with DefinesDoRenderButtonA1[javax.swing.Action, R ]
with XWithNjp[R ]
// with XwnjpTest[R, (
//       {}
//       & XwnjpFacBase[R]
// ) ]
with ReExportsDoRenderAbstractAction
with DefinesGetNewPlainOrStyledTextDoc[Any]
{

   import xwnjpFac.{WithLayoutManager => Njp }

   def newCheckBoxState(
      //

      initiallySelected : Boolean ,

   ) : javax.swing.ButtonModel

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

type XWithNjp[+R] = (
   XWithNjpBase[R, XwnjpFacBase[R] & XwnjpFacWithLayoutManager[[_] =>> R ] ]
)

object XWithNjp {

   type WithNjpCovar[+R[+SpecificLayoutMgr <: java.awt.LayoutManager ] ] = (
      WithNjpInvar[? <: [SpecificLayoutMgr <: java.awt.LayoutManager ] =>> R[SpecificLayoutMgr] ]
   )

   trait WithNjpInvar[R[+SpecificLayoutMgr <: java.awt.LayoutManager ] ] {
      
      type Njp[+SpecificLayoutMgr <: java.awt.LayoutManager ]
         >: R[SpecificLayoutMgr]
         <: R[SpecificLayoutMgr]

   }

}

/**
 * 
 * a helper to
 * allow later-added decorators
 * to automatically be applied to instances of `C` already passed-in-to `addOperand`
 * 
 * the templates returned by `allInterfacesGivens`
 * are not directly an instantiated `awt.Component`s (since that'd prevent reuse), but instead
 * a "zero-arg factory" (eg `DefinesGetNewInstanceNoArg`) which produces those.
 * the ability to `theTemplate.newInstance()` more-than-once,
 * combined with
 * the imperativity (to make it a drop-in sub of the typical `swing.JYyyComponent`s) of
 * the interface(s) returned by the methods `newYyyPanel(.....)`,
 * this additional complexity becomes essential.
 * 
 */
export avcframewrk.util.syncing.CallbackSequenceReplay.XDecorativeFncQueue

/**
 * 
 * secondary `ensureOped` invoc "with given instance of `C`"
 * will not make the callback run twice (ie the callback will only run once)
 * 
 */
export avcframewrk.util.syncing.CallbackSequenceReplay.XIdempotentInitOperandList

/**
 * 
 * the 2nd itc is
 * an infinite-length `LazyList`
 * whose items are the values submitted onto the *callback* returned as the 1st itc (in order)
 * 
 */
// : avcframewrk.util.errorchecking
export avcframewrk.util.syncing.CallbackSequenceReplay.newXcdfLl

private
val _ @ _ = {
   ;

   import allInterfacesGivens.main

   summon[(
      OmiAll[?]

   )]
   
}

@main
def runAllInterfacesGivensJPanelDemo() : Unit = {

   import allInterfacesGivens.main

   println(main)
}




