package avcframewrk.forms.impl.javaswing










import avcframewrk.util.forms.pure.*

import avcframewrk.forms.javaswing.*



protected 
trait XDefinesGetCustomComponent[+R0]
extends
AnyRef
{

   def getCustomComponent1[R1 <: java.awt.Component ](newNativePeer: => R1 ): R0

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


























