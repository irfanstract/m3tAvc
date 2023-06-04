package cbsq.avc.quick.javaswing

















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
                        g.setRenderingHint(awt.RenderingHints.KEY_INTERPOLATION, awt.RenderingHints.VALUE_INTERPOLATION_BICUBIC )
                     }
                  }

                  Option(icon) match {

                     case Some(icon : swing.ImageIcon) => 
                        val img = icon.getImage()
                        g.drawImage(img, 0, 0, c.getWidth(), c.getHeight(), c )
                        
                     case Some(icon) => 
                        // fill with solid zero
                        g.fillRect(0, 0, c.getWidth(), c.getHeight() )

                     case None => 
                        // no-op

                  }

               }

            }
            
}




















