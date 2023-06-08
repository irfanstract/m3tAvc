package cbsq.avc.quick.java2d


















export java.awt.image.ImageConsumer

/**
 * 
 * rather than creating new `java.awt.image.ImageFilter`s everytime,
 * use this instead since the same `ImageConsumer` will not be added twice
 * 
 */
lazy val dummyImgConsumer : java.awt.image.ImageConsumer = {

   cbsq.avc.NoOpImplOfInterface.instanceOfThese[java.awt.image.ImageConsumer ]
   
}

/**
 * 
 * an `ImageFilter` which
 * turns every `STATICIMAGEDONE` into `SINGLEFRAMEDONE`
 * 
 */
def getSustainingImageFilter() : java.awt.image.ImageFilter = {
               ;
               
               object this1 extends
               java.awt.image.ImageFilter
               {

                  import language.unsafeNulls

                  private[this1] 
                  final
                  lazy val c = consumer.nn

                  // export c.{
                  //    imageComplete => _,
                  //    * ,
                  // }

                  override
                  def imageComplete(status: Int): Unit = {

                     import java.awt.image.ImageConsumer.*

                     status match {

                        case status @ STATICIMAGEDONE =>
                           c imageComplete(SINGLEFRAMEDONE)
                           
                        case status @ SINGLEFRAMEDONE =>
                           // TODO choosing between propagating it or neglecting it

                        case status =>
                           c imageComplete(status)

                     }

                  }

                  override
                  def setHints(hints: Int): Unit = {
                     if {
                        val hasAlreadyDone = hsh
                        hsh = true
                        true || !hasAlreadyDone
                     } then {
                        super.setHints(hints & ~{ import java.awt.image.ImageConsumer.* ; SINGLEFRAME } )
                     }
                  }
                  
                  protected 
                  var hsh : Boolean = false

               }
               this1
               
}

;





export java.awt.image.ImageProducer

/**
 * 
 * `ImageProducer` methods which deals with listener-listing and nothing else 
 * (this is `ImageProducer`, not `ImageConsumer`)
 * 
 * no other methods are overriden
 * 
 */
trait ImageConsumerList extends
AnyRef
// with ImageProducer // 
{
         this : (
            AnyRef
            with ImageProducer
         ) =>

         def getAllConsumersSc(): collection.immutable.Iterable[java.awt.image.ImageConsumer ] = {
            import language.unsafeNulls
            cl.get().nn
         }

         // protected 
         private
         val cl = {
            new java.util.concurrent.atomic.AtomicReference[Set[java.awt.image.ImageConsumer] ](Set() )
         }

         override
         def addConsumer(x$0: java.awt.image.ImageConsumer | Null): Unit = {
            import language.unsafeNulls
            addConsumerImpl(x$0 )
         }
         
         protected 
         def addConsumerImpl(x$0: java.awt.image.ImageConsumer ): Unit = {
            import language.unsafeNulls
            cl
            .updateAndGet(_ incl x$0 )
         }
         
         override
         def removeConsumer(x$0: java.awt.image.ImageConsumer | Null): Unit = {
            ;
            import language.unsafeNulls
            cl
            .updateAndGet(_ excl x$0 )
         }

         override
         def isConsumer(x$0: java.awt.image.ImageConsumer | Null): Boolean = {
            ;
            import language.unsafeNulls
            getAllConsumersSc()
            .toSeq.contains(x$0 )
         }

}


































