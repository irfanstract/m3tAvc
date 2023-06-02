package cbsq.avc.quick









@main
def runMimempImgDemo() : Unit = {

   import cbsq.avc.newXResourcesManager
   
   import smjg.startBasicMpJpegGener1
   import cbsq.avc.MimeMultipart
   import MimeMultipart.asMimeMultipartDecoded1

   import java.awt
   import javax.swing

   import concurrent.ExecutionContext.Implicits.global

   import language.unsafeNulls

   val rm = {
      newXResourcesManager()
   }

   val proc1 = {
      startBasicMpJpegGener1()
   }
   val procPipe = {
      proc1.pAsInputStream
   }
   /**
    * avoids the issues with `p.destroy()`
    */
   rm register procPipe

   val pItr = {
      ({
         if false then procPipe
         else {
            val b = cbsq.ByteBlob.takeJIoInputStreamRemainder(procPipe )
            b.newGrossReader()
         }
      } : java.io.InputStream)
      .asMimeMultipartDecoded1(delimitingLineContentsPre = "ffmpeg" )
   }

   val f = new swing.JFrame
   f setDefaultCloseOperation swing.WindowConstants.DO_NOTHING_ON_CLOSE
   f addWindowListener {
      new awt.event.WindowAdapter {
         import awt.event.WindowEvent
         override def windowClosing(e: WindowEvent | Null): Unit = {
            (e.nn : WindowEvent)
            .getWindow()
            .dispose()
            rm.close()
         }
      }
   }
   f setTitle "video frames"
   f setContentPane {
      
      val c = new swing.JPanel(new awt.GridLayout(0, 1) )

      val l = new swing.JLabel
      c add l

      def update() : Unit = {

         summon[concurrent.ExecutionContext]
         .execute(() => {
            pItr.nextOption().map(_.payload) match {

               case None => 
                  System.err println("no more frames")

               case Some(d0) => 
                  val d = decodeImgFile(d0 )
                  System.err println(d)
                  awt.EventQueue.invokeLater(() => {
                     l setIcon {
                        new swing.ImageIcon(d)
                     }
                  })

            }
         })

      }

      c add {
         new swing.JButton({
            new swing.AbstractAction("next") {
               import java.awt.event.ActionEvent
               def actionPerformed(e: ActionEvent | Null): Unit = {
                  update()
               }
            }
         })
      }
      
      c
   }
   f setIconImage {
      import awt.image.*
      new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB )
   }
   awt.EventQueue.invokeLater(() => { f.setSize(800, 400 ) ; f.setVisible(true) } )

}










