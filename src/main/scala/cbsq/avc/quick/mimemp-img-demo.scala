package cbsq.avc.quick

















@main
def runMimempImgDemo() : Unit = {

   startMimempImgDemo()

}

class startMimempImgDemo()
extends AnyRef with java.io.Closeable
{

   import cbsq.avc.newXResourcesManager
   
   import smjg.startBasicMpJpegGener1
   import cbsq.avc.MimeMultipart
   import MimeMultipart.asMimeMultipartDecoded1

   import java.awt
   import javax.swing

   import concurrent.ExecutionContext.Implicits.global

   //

   import language.unsafeNulls

   protected 
   val payloadResource = {
      rmpdStart()
   }
   
   import payloadResource.{
      close => closeAllPayloadResources,
      * ,
   }

   private[startMimempImgDemo] 
   val f = new swing.JFrame
   f setDefaultCloseOperation swing.WindowConstants.DO_NOTHING_ON_CLOSE
   f addWindowListener {
      new awt.event.WindowAdapter {
         import awt.event.WindowEvent
         override def windowClosing(e: WindowEvent | Null): Unit = {
            runCloseButtonAction()
         }
      }
   }
   f setTitle "video frames"
   f setContentPane {
      
      val c = new swing.JPanel(new awt.BorderLayout )

      val l = {
         val lbl1 = new swing.JLabel
         lbl1.setUI({
            cbsq.avc.quick.javaswing.labelIconFullSizeUi
         })
         lbl1
      }
      c add l

      def runUpdateBtnAction() : Unit = {

         concurrent.Future.unit
         .map((_: Unit ) => {
            nextAsJ2DBufferedImg()
         })
         .map(d => {
            
            if d != null then {
                  awt.EventQueue.invokeLater(() => {
                     l setIcon {
                        new swing.ImageIcon(d)
                     }
                  })
            }

         })
         .transform(tr => util.Success(tr) ).foreach(_.get )

      }
      val updateBtnAction = {
            new swing.AbstractAction("next") {
               import java.awt.event.ActionEvent
               def actionPerformed(e: ActionEvent | Null): Unit = {
                  runUpdateBtnAction()
               }
            }
      }

      c add({
         new swing.JButton({
            updateBtnAction
         })
      }, awt.BorderLayout.PAGE_END )
      
      c
   }
   f setIconImage {
      import awt.image.*
      new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB )
   }
   awt.EventQueue.invokeLater(() => { f.setSize(800, 400 ) ; f.setVisible(true) } )

   protected
   def disposeAllWindows() : Unit = {
      f.dispose()
   }

   protected
   def runCloseButtonAction() : Unit = {
            ;
            disposeAllWindows()
            closeAllPayloadResources()
   }

   // ???

   override
   def close(): Unit = {
      runCloseButtonAction()
   }

}

class rmpdStart()
extends AnyRef with java.io.Closeable
{

   import cbsq.avc.newXResourcesManager
   
   import smjg.startBasicMpJpegGener1
   import cbsq.avc.MimeMultipart

   import java.awt

   import concurrent.ExecutionContext.Implicits.global

   import rmpdUtils.*

   import language.unsafeNulls

   protected 
   val rm = {
      newXResourcesManager()
   }

   final 
   val proc1 = {
      startBasicMpJpegGener1()
   }
   final
   val procPipe = {
      proc1.pAsInputStream
               match {
                   case s =>

                     new java.io.FilterInputStream(s) {
                        
                        import language.unsafeNulls

                        override
                        def read(b: Array[Byte] | Null, off: Int, len: Int): Int = {
                           val actualRead = {
                              in.read(b, off, len)
                           }
                           c.addAndGet(actualRead )
                           actualRead
                        }

                        val c = {
                           new java.util.concurrent.atomic.AtomicLong(0)
                        }

                        override
                        def close(): Unit = {
                           try {
                              super.close()
                           }
                           finally {
                              import cbsq.FileSize.boxingImplicits.*
                              System.out println(s"actual total read: ${c.get().B }")
                           }
                        }

                     }
                     
               }
               match { case s => new java.io.BufferedInputStream(s) }
   }

   val delimitingLinePre = {
      "ffmpeg"
   } : String
   
   /**
    * avoids the issues with `p.destroy()`
    */
   rm register procPipe

   protected 
   def shallDebugEachOfPItr : Boolean = false

   final
   val pItr = {
      rmpdUtils.decodeMimeMultipartStream({
            if {
               /**
                * 
                * for some reason,
                * throttling caused stream corruption (packet dropped, isn't it?)
                * 
                */
               // true
               true
               
            } then {
               procPipe
            }
            else {
               procPipe
               .preBuffer()
            }
            
      })(delimitingLinePre = delimitingLinePre )
      .tapEach(c => {
         if shallDebugEachOfPItr then {
            System.err println(s"[debug] c: ${c }")
         }
      })
   }

   def nextAsJ2DBufferedImg(): java.awt.image.BufferedImage | Null = {
      
            {
               pItr
               .nextOption()
               .map(_.payload)

            } match {

               case None => 
                  System.err println("no more frames")

                  null

               case Some(d0) => 
                  val d = decodeImgFile(d0 )
                  System.err println(d)
                  
                  d

            }
            
   }

   def close() : Unit = {
      rm.close()
   }

}

object rmpdUtils
{
   
   import cbsq.avc.MimeMultipart
   import MimeMultipart.asMimeMultipartDecoded1

   /**
    * 
    * for some reason,
    * throttling the `InputStream` reading
    * spuriously caused stream corruption (packets got dropped, isn't it?)
    * 
    */
   extension (src: java.io.InputStream ) {

      def preBuffer() = {
               val b = cbsq.ByteBlob.takeJIoInputStreamRemainder(src )
               b.newGrossReader()
      }

   }
   
   extension (
      procPipe : java.io.InputStream 

   ) {

      def decodeMimeMultipartStream( 
         delimitingLinePre : String ,
         
      ) = {
         
         import language.unsafeNulls

         (procPipe : java.io.InputStream)
         .asMimeMultipartDecoded1(delimitingLineContentsPre = delimitingLinePre )

      }

   } 

}





















