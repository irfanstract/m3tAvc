package cbsq.avc.quick.java2d




















object ImageCopyOfs
{

   def blitResized(
      src : java.awt.image.RenderedImage,
      dest: java.awt.image.BufferedImage ,
   ): Unit = {
      ;

      import language.unsafeNulls

      val g = dest.createGraphics()
      try {
         g.drawRenderedImage(src, {
            java.awt.geom.AffineTransform.getScaleInstance(
               ( dest.getWidth() ).toDouble / ( src.getWidth() ) ,
               (dest.getHeight() ).toDouble / (src.getHeight() ) ,
            )
         } )
      }
      finally g.dispose()
   }

   extension (src : java.awt.image.RenderedImage ) {

      def newCompatibleBufferedImage1(
         resol : (Int, Int) ,
         
      ) = {

               import language.unsafeNulls

               /**
                * 
                */
               val colorModel = {
                  src
                  .getColorModel()
               }
               
               val newRaster = {
                  colorModel
                  .createCompatibleWritableRaster(resol._1, resol._2 )
               }

               new java.awt.image.BufferedImage(colorModel, newRaster, {
                  // TODO
                  colorModel.isAlphaPremultiplied()

               }, null )

      }

   }

}
































