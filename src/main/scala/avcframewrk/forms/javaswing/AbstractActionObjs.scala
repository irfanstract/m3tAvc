package avcframewrk.forms.javaswing

















object actionObjUtil
{

   extension (l : javax.swing.Action ) {

      /**
       * 
       * make
       * changes to the (`l : Action`)'s "icon" property ;
       * will be reflected in all `AbstractJButton`s whose `action` is `l`
       * 
       * in particular,
       * the right key is `swing.Action.SMALL_ICON` ;
       * `AbstractButtons` (except for some) will always fall back to the property
       * 
       */
      def setIcon(v : javax.swing.Icon | Null ): Unit = {

         import java.awt
         import javax.swing

         l.putValue(swing.Action.SMALL_ICON , v )

      }

   }
   
}


































