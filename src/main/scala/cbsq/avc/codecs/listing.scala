package cbsq.avc.codecs


















@main
def runCodecListingDemo() : Unit = {
   codecListing
   .getAllRegisteredDevices()
   .toSeq
   .map(e => e.toString() )
   .prepended("[")
   .appended("]")
   .foreach(println(_) )
}

@main
def runCodecListingAndMpJpegTrialDemo() : Unit = {

   import cbsq.avc.quick.smjg.startBasicMpJpegGener1

   val allRegisteredDevices = {
      ;
      codecListing
      .getAllRegisteredDevices()
      
   } : collection.immutable.Iterable[cbsq.avc.MediaDeviceProperties ]

   val mpJpegCodecOvw = {
      allRegisteredDevices
      .toSeq
      .collectFirst({
         case c : (cbsq.avc.McdcTyper#MediaCodecOverview ) if (
            (c.encodedFormMimeType == "application/x-libavformat-mpjpeg" )
         ) =>
            c
      })
      .getOrElse(throw new java.util.NoSuchElementException(s"no mpjpeg-codec") )
   }
   
   println(s"codec: ${mpJpegCodecOvw }")

   val s = {
      startBasicMpJpegGener1()
   }

   util.Using.resource(s.pAsInputStream )(_ => {
      try {
         ;
         ;
         
         import s.pAsInputStream

         val started = {
            mpJpegCodecOvw.argsInitially
            .forOpenedStream(pAsInputStream.asInstanceOf[mpJpegCodecOvw.CharacteristicFd] )
            .spawnNow()
            match { case s : encodedFormsECdl.XDecoderInstance => s }
         }

         println(s"started ")

         started.getClass()

         println(s"${started }")

         // cbsq.avc.quick.openInteractiveFrameIterativeUiImpl(src = started.frameIterator )
         // .join()
         ???
         
      }
      finally {
         println(s"ending the codec stream in two secs ")
         Thread.sleep(3 * 1000 )
      }
   })

   // application/x-libavformat-mpjpeg

   // Predef.???

}

// TODO
lazy val codecListing = {

   import cbsq.avc.{*}
   import cbsq.avc.upstream.{*}

   import ewfi.*

   val endp = {
      new EncodedFormsNcp()
   }

   import endp.*

   import endp.getCodecOverviewImpl

   import encodedFormsECdl.*

   import encodedFormsEDcei.*

   extension (ctx : XedfMuuxProperties) {

      /**
       * 
       * this excludes the leading `--`.
       * 
       */
      def getMultipartDelimitingPhr() : String = {
         // TODO
         "ffmpeg"
      }

   }
   
   extension (src : java.io.InputStream) {

      def decodeAsMpJpeg(delimiterCPre: String ) = {
         src decodeMpJpegImpl(delimiterCPre = delimiterCPre )
      }

   }

   val allCodecs = (
      Seq()

      :+ {
         getCodecOverviewImpl(
            //
            canonicalNames = Seq("mpjpeg") ,
            encodedFormMimeType = "application/x-libavformat-mpjpeg" ,
            mediaKind = MediaKind.Video ,
            optionalDecodeFnc = {
               Some({
                  identity[XTraversiveDecoder]({
                     
                     case (src : java.io.InputStream, muxProperties) =>
                        
                        newDemuxingProc1(src)(
                           mediaKind = MediaKind.Video,
                           submitDecod = src => { src decodeAsMpJpeg(delimiterCPre = muxProperties.getMultipartDelimitingPhr() ) } ,
                        )
                        
                  })
               })
            } ,
            optionalEncodingFnc = {
               Some({
                  identity[XSynchronousPipingEncoder]((

                     (src, muxProperties, dest0) => {
                        
                        val dest1 = {
                           dest0 match {
                              case dest : java.io.OutputStream =>
                                 new java.io.OutputStreamWriter(dest, java.nio.charset.StandardCharsets.US_ASCII )
                              case dest : java.io.Writer =>
                                 dest
                           }
                        } : java.io.Writer
                        
                        val destPw = {
                           new java.io.PrintWriter(dest1, true )
                        }

                        destPw.encodeMpJpegImpl(src = src )

                     }

                  ))
               })
            } ,
         )
      }
      
      :+ {
         getCodecOverviewImpl(
            //
            canonicalNames = Seq("ignorecodec") ,
            encodedFormMimeType = "application/x-scalavfmt-discardallfrominputanddecodenothing" ,
            mediaKind = MediaKind.Video ,
            optionalDecodeFnc = {
               Some({
                  identity[XTraversiveDecoder]({
                     
                     case (src : java.io.InputStream, muxProperties) =>
                        
                        // TODO
                        Predef.???
                        
                  })
               })
            } ,
            optionalEncodingFnc = None ,
         )
      }
      
   )

   // TODO
   new AnyRef
   with MediaDeviceAttributeTyper1
   with CodecExtraOpsProvider1
   with XmasEpcd
   with XdmasCdv
   {
   
   mce =>

   override
   def getAllRegisteredDevices() = {
      allCodecs
   }

   override
   def getAllRegisteredDemuxers() = {
      getAllRegisteredDevices()
      .collect({
         case e : XMediaCodecOverview =>
            e
      })
   }

   }
}






































