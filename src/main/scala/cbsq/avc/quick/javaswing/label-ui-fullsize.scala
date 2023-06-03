package cbsq.avc.quick.javaswing

















def labelIconFullSizeUi: javax.swing.plaf.LabelUI = {
   
            import java.awt
            import javax.swing

            import language.unsafeNulls

            new swing.plaf.LabelUI {

               import awt.Graphics

               override
               def paint(g: Graphics | Null, c: swing.JComponent | Null) = {

                  val icon = {
                     Option(c.asInstanceOf[swing.JLabel].getIcon() )
                     .orNull
                  }

                  Option(icon) match {

                     case Some(icon : swing.ImageIcon) => 
                        g.drawImage(icon.getImage(), 0, 0, c.getWidth(), c.getHeight(), c )
                        
                     case Some(icon) => 
                        // fill with solid zero
                        g.fillRect(0, 0, c.getWidth(), c.getHeight() )

                     case None => 
                        // no-op

                  }

               }

            }
            
}




















