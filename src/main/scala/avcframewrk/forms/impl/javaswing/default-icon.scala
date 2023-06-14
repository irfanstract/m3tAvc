package avcframewrk.forms.impl.javaswing
















lazy val defaultAppIconImg : java.awt.Image & java.awt.image.RenderedImage = {
   ;

   import java.awt
   import javax.swing

   import awt.image.*

   import language.unsafeNulls
   
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
}
















