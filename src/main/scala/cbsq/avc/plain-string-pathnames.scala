package cbsq.avc















// TODO
sealed
trait PlainStringPathnameHandler
{

   extension (src: String ) {
      def toURI () : java.net.URI
      def toPath() : java.nio.file.Path
   }

   def openFile(
      src: String | java.net.URI | java.nio.file.Path,
      mode: PlainStringPathnameHandler.OpfMode ,
      
   ): PlainStringPathnameHandler.IoHandleByOpfMode[mode.type, Byte | Char]
   
}

object PlainStringPathnameHandler
{

   enum OpfMode
   {

      case toRead

      /**
       * 
       * if the requested path points to existing file,
       * *abort*
       * 
       */
      case toCreateNew

      /**
       * 
       * if the requested path points to existing file,
       * concatenate
       * 
       */
      case toAppend
      
      /**
       * 
       * if the requested path points to existing file,
       * *clears* the file, first
       * 
       */
      case toClearAndWrite

   }

   type IoHandleByOpfMode[Modus <: OpfMode, C <: Byte | Char] <: (
        java.io.InputStream | java.io.Reader
      | java.io.OutputStream | java.io.Writer
   ) =
      (Modus, C) match {
         
         case (OpfMode.toRead.type, _) =>
            C match {
               case Byte => java.io.InputStream
               case Char => java.io.Reader
               case _    => java.io.InputStream | java.io.Reader
            }
            
         case (OpfMode.toClearAndWrite.type | OpfMode.toAppend.type | OpfMode.toCreateNew.type, _) =>
            C match {
               case Byte => java.io.OutputStream
               case Char => java.io.Writer
               case _    => java.io.OutputStream | java.io.Writer
            }

         // case _ =>
         //    java.io.Closeable
            
      }

}














































