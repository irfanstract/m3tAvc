package avcframewrk.forms.impl.javaswing









import avcframewrk.util.forms.pure.*

import avcframewrk.forms.javaswing.*




import abstractActionFactory.{XLabel, XF}

object allInterfacesGivens extends 
AnyRef
with Aig1
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

   import aigimImpl.*

   given main :
   AnyRef
   with XAllComponentsList[MainR]
   with XWithNjpBase[MainR, XwnjpFacBase[MainR] & XwnjpFacWithLayoutManagerInvar[[L <: java.awt.LayoutManager] =>> (MainR & XJPanelsImplImpl#newJPanelImpl[L] ) ] ]
   with ^&%%^
   with ComponentSpwReExports
   with XJPanelsImpl
   with XDefinesDoRenderSwingTextDocDisplay
   with XWithCDoSpawnNewJFrame
   with avcframewrk.util.forms.DefinesDoOpenGiven[MainR, java.io.Closeable]
   with {

      /* name imports */

      import java.awt
      import javax.swing

      import avcframewrk.forms.javaswing.actionObjUtil.setIcon

      /* exports */  

      override
      def open(c: MainR) = {
         
         this.spawnNewJFrame(title = "", contentPane = c )
      }

      override
      def open(title: String, body: MainR) = {
         
         this.spawnNewJFrame(title = title, contentPane = body )
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
   
   private[allInterfacesGivens]
   object aigimImpl extends Aig1MoreDefs(aigimImplem = this)
   
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
   trait ESingularCommonCompsImpl(
      //
      
   )
   extends
   AnyRef
   with DefinesDoRenderButtonA1[javax.swing.Action, MainR]
   with DefinesDoRenderDynamicPoster[javax.swing.Action , MainR]
   with DefinesDoRenderPoster       [javax.swing.Icon   , MainR]
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
   with XDefinesGetCustomComponent[MainR]
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

   type MainR = impl.MainR
   
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
   //       // with XAllComponentsList[MainR]
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

   ) extends
   AnyRef
   with XWithNjpBase[MainR, XwnjpFacBase[MainR] & XwnjpFacWithLayoutManagerInvar[[L <: java.awt.LayoutManager] =>> (MainR & XJPanelsImplImpl#newJPanelImpl[L] ) ] ]
   {
      otherComponents : (
         AnyRef
         // with XAllComponentsList[MainR]
         // with XWithNjp[MainR]
         with ^&%%^
         with ComponentSpwReExports
         //
      ) =>

      import otherComponents.*

      /* name imports */

      /* exports */

      override
      // def newFourSidebarHolyGrailLayout
      def newFourAsidesContentPanel() = {

         newJPanel({

            new awt.BorderLayout(gapSize, gapSize ) 
         })
      }

      override
      def newAggregatingPanel() = {

         newJPanel({

            /**
             * GridLayout with exactly `1` column(s)
             */
            new awt.GridLayout(0, 1 ) 
         })
      }

      override
      def newParagraphicPanel() = {

         newJPanel({

            new awt.FlowLayout(awt.FlowLayout.LEADING ) 
         })
      }

      override
      final
      def newThumbnailsListPanel() = {

         newJPanel({

            /**
             * 
             * a subclass of `FlowLayout`
             * with
             * interception in these methods
             * to additionally invoke `reAdjustChildComponentsPreferredSizes` (which reassigns the Component's one-or-more non-`size` properties, normally a wrong thing to do for `LayoutManager`s)
             * .
             * AVOID EXTRACTING THIS OUT
             * 
             */
            new awt.FlowLayout()
            {

               override
               def minimumLayoutSize(container : awt.Container ) = {

                  reAdjustChildComponentsPreferredSizes(container )

                  super.minimumLayoutSize(container)
               }

               override
               def preferredLayoutSize(container : awt.Container ) = {

                  reAdjustChildComponentsPreferredSizes(container )

                  super.preferredLayoutSize(container)
               }

               override
               def layoutContainer(container : awt.Container ) : Unit = {

                  reAdjustChildComponentsPreferredSizes(container )

                  super.layoutContainer(container)
               }

               /**
                * 
                * modify the child components' *preferred size*s
                * 
                */
               def reAdjustChildComponentsPreferredSizes(container: awt.Container ): Unit = {

                  val intendedPerComponentLength = {
                     
                     computePerComponentLength(container)
                  }

                  for (childComp <- container.getComponents() ) {

                     childComp setPreferredSize(new awt.Dimension(intendedPerComponentLength, intendedPerComponentLength ) )
                     
                  }

               }

               def computePerComponentLength(c : awt.Container ) : Int = {

                  96
               }
               
            }
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
         // with XAllComponentsList[MainR]
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
   with DefinesDoRenderButtonA1[javax.swing.Action, MainR ]
   // with XWithNjp[MainR ] // already metioned below
   with ReExportsDoRenderAbstractAction
   with XDefinesAllocNewCheckBoxState
   with DefinesGetNewPlainOrStyledTextDoc[Any]
   with ESingularCommonCompsImpl
   with ENewCheckBoxStateImpl
   with XWithNjp[MainR]
   with Egcc
   {
      this : (
         AnyRef
      ) =>

      /* name imports */

      /* exports */

   } /* ^&%%^ */

   object ^&%%^
   {

      // given Conversion[^&%%^, XDefinesDoRenderSwingTextDocDisplay] = {
      
      //    e => XDefinesDoRenderSwingTextDocDisplay(otherComponents = e )
      // }

   }

}

val _ = {}

sealed
trait XAllComponentsList[R] extends
      AnyRef
      with XDefinesGetCustomComponent[R]
      with DefinesDoRenderButtonA1[javax.swing.Action, R ]
      with (
         //

         /**
          * 
          * `XWithNjpBase` specialised this way --
          * `Aig1MoreDefs` requires type-argument, which would have been the implementing `class`
          * 
          */
         ([Definer <: Singleton & Aig1] =>> (

            XWithNjpBase[R, (

               XwnjpFacBase[R]
               &
               XwnjpFacWithLayoutManager[[L <: java.awt.LayoutManager] =>> (
                  R &
                  Aig1MoreDefs[Definer ]#XJPanelsImplImpl#newJPanelImpl[L] 
               ) ]
               
            ) ]
            
         ) )
         [(
            (Singleton & Aig1)
            & { val impl : EmTypingImpl { type MainR >: R <: R } } 
         )]

      )
      with ReExportsDoRenderAbstractAction
      with DefinesDoRenderDynamicPoster[javax.swing.Action , R ]
      with DefinesDoRenderPoster       [javax.swing.Icon   , R ]
      with XDefinesAllocNewCheckBoxState
      with DefinesGetNewPlainOrStyledTextDoc[Any]
      with XDefinesDoRenderSwingTextDocDisplay
      with avcframewrk.util.forms.DefinesDoOpenGiven[R, ImplSpawnNewJFrame]
      with avcframewrk.util.forms.DefinesDoOpenTopicGiven[String, R, ImplSpawnNewJFrame]
{
   this : (
      AnyRef
      & (Aig1 { val impl : EmTypingImpl { type MainR >: R <: R } } )#ComponentSpwReExports
      //
   ) =>

   def renderLinearRangeBoundedEditor[
      Model <: (
         javax.swing.BoundedRangeModel
      ) ,

   ](model: Model): R = {

      import language.unsafeNulls

      getCustomComponent1 {

         val s = new javax.swing.JSlider(model)
         s
      }
   }

   def renderFiniteItemChooser[
      K : Ordering ,
      Model <: (
         ([E] =>> (
            javax.swing.ListModel[E]
            | javax.swing.ComboBoxModel[E] 
         ) )[K]
      ) ,

   ](m: Model, formatItemForDisplay: K => R ): R = {

      import language.unsafeNulls

      val cellRenderer = {
         
                  identity[javax.swing.ListCellRenderer[K] ]((_, item, i, isSelected, _ ) => {

                     val itemC = {
                        { formatItemForDisplay((item : K | Null).asInstanceOf[K] ) }
                        match { case e => spawnAndGetNative(e) }
                     }
                     itemC
                  })
      }

      getCustomComponent1 {

         (m, () ) match {
            //

            /*
             * 
             * `ComboBoxModel` `extends` `ListModel`, so
             * the `case` for `ComboBoxModel`
             * needs to come up first
             * 
             */

            case (m : javax.swing.ComboBoxModel[?], () ) =>
               ;
               
               val s = new javax.swing.JComboBox(m)
               s.setRenderer({
                  cellRenderer
               })
               s

            case (m : javax.swing.ListModel[?], () ) =>
               ;
               
               val s = new javax.swing.JList(m)
               s setCellRenderer({
                  cellRenderer
               })
               s

         }
      }
   } /* renderFiniteItemChooser */

}

object XAllComponentsList
{

   given defaultInstance : impl.epm.valuePallete.type = {

      impl.epm.valuePallete
   }

   private [XAllComponentsList]
   object impl {

      val epm = {

         new avcframewrk.util.errorchecking.WildcardTypedInstancing.::![XAllComponentsList ] {
            
            opaque type Value
               = allInterfacesGivens.MainR

            final val valuePallete : XAllComponentsList[Value]
               = allInterfacesGivens.main

         }
      }

   } /* `impl` */

} /* object `XAllComponentsList` */

private
val _ @ _ = {
   ;

   import allInterfacesGivens.main

   summon[(
      ([R] =>> (
         XAllComponentsList[R]
      ))
      [?]

   )]
   
   ([C <: AnyRef] => (e: XAllComponentsList[C]) => {
      e.newParagraphicPanel()
      .add({ e.renderTextDocDisplay(src = ??? ) })
   })

}

@main
def runAllInterfacesGivensJPanelDemo() : Unit = {

   import allInterfacesGivens.main

   println(main)
}




