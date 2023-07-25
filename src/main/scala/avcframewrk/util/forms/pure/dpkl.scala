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
         Key <: scala.AnyVal | String ,
         Value ,
      ](
         keySet: (
            SeqOrSetOf[Key]
         ) ,
         getItemByKey: (
            Key => Value
         ) ,

      )
      (using homogenity : (Key, Key) <:< ((AnyVal, AnyVal) | (String, String) ) )
      : ROf[Value]

      (() => {

         apply(
            keySet = Seq(3) ,
            getItemByKey = e => (e, PartialFunction ) ,
         )

         apply(
            keySet = Seq("5") ,
            getItemByKey = e => (e, PartialFunction ) ,
         )

      } : Unit )

   } /* ImplDkldsFacOpsImpl */

   type SeqOrSetOf[E]
      = Seq[E] | Set[E]

   @deprecated("this' signature doesn't reject those impossible things.")
   def getKeyer[E <: AnyRef]()
   : E
   = (new AnyRef).asInstanceOf[E ]

} /* object XDefinesDoDescribePhrasalOrKeyList */


















// /**
//  * 
//  * `getTyper`
//  * is meant to be run whenever a `given &lt;some-typing-obj-type>` is needed
//  * 
//  * ```
//  * import language.paramAutoDelim
//  * 
//  * def apply
//  *    (using 
//  *       ctx : { type Key }
//  *          defaults to { type Key =:: String } 
//  *    )
//  *    (
//  *       mode: OpMode  
//  *       keys: immutable.Iterable[ctx.Key] 
//  *    )
//  * : XPayback
//  * ```
//  * 
//  */
// opaque type Typer[+E <: AnyRef]
//    <: E
//    = E
// object Typer
// {

//    @deprecated("this' signature doesn't reject those impossible things.")
//    implicit
//    def getInstance[E <: AnyRef]()
//    : Typer[E]
//    = (new AnyRef).asInstanceOf[Typer[E] ]

// }
// export Typer.{getInstance => getTyper }
