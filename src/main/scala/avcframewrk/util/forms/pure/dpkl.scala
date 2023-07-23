package avcframewrk.util.forms.pure

val _ = {}
















@deprecated
object XDefinesDoDescribePhrasalOrKeyList
{

   type ByR[RDoc]
      = Impl[RDoc]

   protected
   trait Impl[RDoc]
   {

      /**
       * 
       * a prosal list,
       * with the orderedness depends on the `CC` which `children` implements,
       * 
       */
      def describePhrasalList(
         children: collection.immutable.Iterable[RDoc] ,
         header: RDoc ,

      )
      : RDoc
      
      /**
       * 
       * a list of values each together with label,
       * with the orderedness depends on the `CC` which `children` implements,
       * 
       */
      def describeKeyList[
         Value ,
      ](
         dataSet: (
            DklDataSetByItem[Value]
         ) ,
         renderItemByKey: Value => RDoc ,

      )
      : RDoc

      type DklDataSet

      val DklDataSet
      : (
         AnyRef
         & ImplDkldsFacOpsImpl[DklDataSetByItem ]
      )

      type DklDataSetByItem[+Item]
         <: DklDataSet

   } /* Impl */
   
   /**
    * 
    * the impl for `Impl.instance.DklDataSet`
    * 
    */
   trait ImplDkldsFacOpsImpl[+ROf <: [Item] =>> Any ]
   {

      def apply[
         Value ,
      ](
         using
         // TODO
         typer : ([KeyType0] =>> (
         {
            type KeyType
               = KeyType0
            
         }
         ))[AnyVal | String] 
         = ([E <: AnyRef] => () => (new AnyRef).asInstanceOf[E] ).apply()
         ,
      ) (
         keySet: (
            SeqOrSetOf[typer.KeyType]
         ) ,
         getItemByKey: (
            typer.KeyType => Value
         ) ,

      )
      : ROf[Value]

   } /* ImplDkldsFacOpsImpl */

   type SeqOrSetOf[E]
      = Seq[E] | Set[E]

} /* object XDefinesDoDescribePhrasalOrKeyList */

















