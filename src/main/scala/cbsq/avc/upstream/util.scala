package cbsq.avc.upstream


















// @annotation.experimental
protected 
def notImplemented: Nothing = {
   Predef.???
}








export cbsq.avc.LateBoundValue








trait GrowableSeq[E] extends
   AnyRef
   with collection.Seq[E]
   // with collection.SeqOps[E, GrowableSeq, GrowableSeq[E] ]
{
   
   def prepend(            e: E) : this.type
   def insert (index: Int, e: E) : Unit
   def addOne (            e: E) : this.type

}
object GrowableSeq
{

   def nextInstance[E] = {
      newBy[E]()
   }

   def newBy[E](): (
      AnyRef
      & collection.Seq[E]
      & collection.IndexedSeq[E]
      & GrowableSeq[E]
      
   ) = {
      val backing = {
         collection.mutable.ArrayBuffer.empty[E]
      }
      new 
      collection.AbstractSeq[E]
      with collection.IndexedSeq[E]
      with GrowableSeq[E]
      {
         
         export backing.length
         
         export backing.apply
         
         // export backing.iterator
         
         export backing.insert
         export backing.insertAll

         override def prepend(e: E) = { backing prepend e ; this }
         override def addOne (e: E) = { backing addOne  e ; this }
         
         override def knownSize = super.knownSize

         val genericMigrativelySuggestiveSentence = {
            s"please switch to 'collection.mutable.ArrayBuffer' directly."
         }
         

      }
   }

}
















































































































