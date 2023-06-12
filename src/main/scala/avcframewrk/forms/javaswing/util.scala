package avcframewrk.forms.javaswing
















object util {
   
   def enClosure[R](run : => R ) : (() => R ) = () => run

}






extension (s: java.awt.Shape) {

   def toStroked(c: java.awt.Stroke) = {

      import language.unsafeNulls

      c createStrokedShape s
   }

}



























