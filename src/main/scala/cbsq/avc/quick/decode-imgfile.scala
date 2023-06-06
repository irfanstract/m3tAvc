package cbsq.avc.quick


















/**
 * 
 * quick means for img-file decoding ;
 * allocates new independently-buffered `BufferedImage` with the decoded result
 * 
 * for optimal performance,
 * consider
 * switching to direct usage of `ImageReader` and `ImageReadParam`
 * 
 */
def decodeImgFile(
   payload: cbsq.ByteBlob ,
   
) = {
   ;

   import language.unsafeNulls

   Thread.sleep(200 )

   javax.imageio.ImageIO.read({
      payload
      .newGrossReader()
   })

}








































