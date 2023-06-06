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

            new swing.plaf.LabelUI {

               import awt.Graphics

               override
               def paint(g: Graphics, c: swing.JComponent) = {

                  val icon = {
                     Option(c.asInstanceOf[swing.JLabel].getIcon() )
                     .orNull
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
            
}




















