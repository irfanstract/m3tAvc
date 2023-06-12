package cbsq.avc.quick.javaswing

















/**
 * 
 * Swing's built-in `LabelUI`
 * did not make the rendering full-size .
 * this alternative `LabelUI`
 * exclusively deals with `ImageIcon`s and
 * make its `paint` method directly invoke `drawImage` with its `getImage()`
 * 
 */
def labelIconFullSizeUi: javax.swing.plaf.LabelUI = {
   
            import java.awt
            import javax.swing

            import language.unsafeNulls

            val impl = {
               new %%!()
               {
                  ;
                  
                  type SupportedComponent
                     >: swing.JLabel
                     <: swing.JLabel

                  override
                  def getIconFromSupportedComponent(c: SupportedComponent ) = {
                     
                     val icon = {
                        Option(c.getIcon() )
                        .orNull
                     }

                     icon
                  }

               }
            }

            new
            swing.plaf.LabelUI
            with impl.Main
            {
               
            }
            
}

/**
 * 
 * Swing's built-in `LabelUI`
 * did not make the rendering full-size .
 * this alternative `LabelUI`
 * exclusively deals with `ImageIcon`s and
 * make its `paint` method directly invoke `drawImage` with its `getImage()`
 * 
 */
def buttonIconFullSizeUi: javax.swing.plaf.ButtonUI = {
   
            import java.awt
            import javax.swing

            import language.unsafeNulls

            val impl = {
               new %%!()
               {
                  ;
                  
                  type SupportedComponent
                     >: swing.AbstractButton
                     <: swing.AbstractButton

                  override
                  def getIconFromSupportedComponent(c: SupportedComponent ) = {
                     
                     /**
                      * 
                      * the right code/expr
                      * would be `getAction() match { case v => v.getLargeIcon() || v.getSmallIcon() } ` .
                      * however,
                      * `setAction(a: swing.Action )` appears to internally invoke `setIcon(a.getIcon() )`
                      * 
                      * will be `null` IOIF there's none.
                      * 
                      */
                     c.getIcon()
                  }

               }
            }

            new
            swing.plaf.ButtonUI
            with impl.Main
            {

               if false then {
                  
                     paint( ???, ??? )

               }

            }
            
}

// 
private
abstract
class %%!
{
            ;
            
            import java.awt
            import javax.swing

            import language.unsafeNulls

            type SupportedComponent
               <: swing.JComponent

            @throws[ClassCastException]
            @throws[MatchException]
            @throws[MatchError]
            def getIconFromSupportedComponent(c: SupportedComponent ): swing.Icon | Null

            trait Main
            extends
            javax.swing.plaf.ComponentUI
            {
               ;

               import awt.Graphics

               /**
                * 
                * implements `ComponentUI.instance.paint(....)`. 
                * expects the Icon, if any, to be `ImageIcon`, and then
                * make `draw*Image` call on `g`;
                * render black-or-fallback screen for any other non-null Icon.
                * nothing to render if `null`.
                * 
                * to ensure precedence over the overridden method,
                * needs to make the return-type something "more specific than Unit" .
                * the only instance of Unit is `()`, but
                * it's possible to use an opaque type declared `? <: Unit`
                * 
                */
               override
               // final
               def paint(g: Graphics, c: swing.JComponent): EpUnit = identity[Unit] {

                  val icon = {
                     getIconFromSupportedComponent {
                        (c: swing.JComponent)
                        .asInstanceOf[SupportedComponent ]
                     }
                  }

                  for (g <- Some(g).collect({ case g : awt.Graphics2D => g }) ) {
                     if true then {
                        /* i wanted the `AREA_AVERAGING` equivalent `:/` */
                        g setRenderingHint(awt.RenderingHints.KEY_INTERPOLATION, awt.RenderingHints.VALUE_INTERPOLATION_BICUBIC )
                     }
                  }

                  Option(icon) match {

                     case Some(icon : swing.ImageIcon) => 
                        val img = icon.getImage()
                        g drawImage(img, 0, 0, c.getWidth(), c.getHeight(), c )
                        
                     case Some(icon) => 
                        g match {
                        //

                        case g : awt.Graphics2D =>
                           val g1 = g.create().asInstanceOf[awt.Graphics2D]
                           g1.scale(
                              (c.getWidth()  ).toDouble / (icon.getIconWidth()  ) ,
                              (c.getHeight() ).toDouble / (icon.getIconHeight() ) ,
                              
                           )
                           icon paintIcon (c, g1, 0, 0 )

                        case _ =>
                           // fill with solid zero
                           g fillRect(0, 0, c.getWidth(), c.getHeight() )
                           
                        }

                     case None => 
                        // no-op

                  }

               }

            }
            
            protected
            opaque type EpUnit
               <: Unit
               = Unit

}




















