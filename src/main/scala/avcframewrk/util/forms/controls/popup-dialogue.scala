package avcframewrk.util.forms.controls


















;

object DefinesDoPrompt {

   /**
    * 
    * `prompt(title = ???, options = ??? )`
    * 
    */
   object ByTitleAndOptions {
      //
      
      private[DefinesDoPrompt]
      trait ImplByR[+R]
      extends
      AnyRef
      // with WithPtoTyper[?]
      {
         this : (
            AnyRef
            & WithPtoTyper[?]
         ) =>

         import ePtoTyp.Title
         import ePtoTyp.Options

         /**
          * 
          * .
          * 
          * @param title   - the short leading message
          * @param options - the options
          * 
          */
         def prompt(
            //
            title: Title,
            options: Options,

         ) : R

      }

      /**
       * 
       * defines `private` `Title` and `Options`, and
       * make them the main argument-types
       * 
       */
      trait ByGiven[-Title, -Options, +R]
      extends
      AnyRef
      with ImplByR[R]
      with WithPtoTyper[PtoContravar[Title, Options] ]
      {

      }
      
      /**
       * 
       * defines `PromptTitle` and `PromptOptions`, and
       * make them the main argument-types
       * 
       */
      trait ByInner[+R]
      extends
      AnyRef
      with ImplByR[R]
      with WithPtoTyper[DefinesInterfacesTitleAndOptions ]
      {
         
         override
         protected
         val ePtoTyp : (
            DefinesInterfacesTitleAndOptions & 
            PtoInvar[PromptTitle, PromptOptions ]
         )

         type PromptTitle
         type PromptOptions

      }
      
   }

   /**
    * 
    * quick implementation inspired by ECMA-262's `new Promise((return, reject) => ... )` idiom .
    * pass a callback ;
    * the second argument
    * will provide method `tryComplete` and `success` both to close *the enclosing question*
    * 
    * `byLbvS` and `byLbv`
    * only differ in that `byLbv`'s version of `prompt` is *async*, while `byLbv`'s is *synchronous*,
    * otherwise the two 're equivalent
    * 
    */
   def byLbvS[Value, Title, Options](
      // 
      implStart: (Title, Lbvb[Value, Options]) => Unit ,
   ) = {

      byLbvImpl[Value, Title, Options, ValueOf[Unit] ?=> Value ](
         implStart = implStart,
         mainRepack = e => _ ?=> e.value ,
      )
   }

   /**
    * 
    * quick implementation inspired by ECMA-262's `new Promise((return, reject) => ... )` idiom .
    * pass a callback ;
    * the second argument
    * will provide method `tryComplete` and `success` both to close *the enclosing question*
    * 
    * `byLbvS` and `byLbv`
    * only differ in that `byLbv`'s version of `prompt` is *async*, while `byLbv`'s is *synchronous*,
    * otherwise the two 're equivalent
    * 
    */
   def byLbv[Value, Title, Options](
      // 
      implStart: (Title, Lbvb[Value, Options]) => Unit ,
   ) = {

      byLbvImpl[Value, Title, Options, avcframewrk.util.LateBoundValue.NhwGetValue[Value]](
         implStart = implStart,
         mainRepack = e => e ,
      )
   }
   
   def byLbvImpl[Value, Title, Options, Erp](
      // 
      implStart: (Title, Lbvb[Value, Options]) => Unit ,
      mainRepack: avcframewrk.util.LateBoundValue.NhwGetValue[Value] => Erp
   ) : (
      AnyRef
      & ByTitleAndOptions.ByGiven[Title, Options, Erp ]
   ) = {

      trait WithEPtoTypImpl extends
      AnyRef
      with WithPtoTyper[PtoInvar[Title, Options ] ]
      {

         val ePtoTyp: PtoInvar[Title, Options] = {
            /* (hopefully) harmless `asInstanceOf` towards the `type`s-only `trait` */
            new AnyRef()
            .asInstanceOf[PtoInvar[Title, Options] ]
         }
         
      }

      object main extends
      AnyRef
      with ByTitleAndOptions.ByGiven[Title, Options, Erp ]
      with WithEPtoTypImpl
      {

         export ePtoTyp.Title
         export ePtoTyp.Options
         
         override
         def prompt(
            //
            title: Title,
            options: Options,

         ) = {

            val q = {
               avcframewrk.util.LateBoundValue.newInstance[Value]
            }

            implStart(title, new Lbvb[Value, Options](r = q, options = options ) )

            mainRepack(q)
         }

      }

      main
   }

   protected 
   class Lbvb[Value, +Options] private[DefinesDoPrompt] (
      //
      val r : (
         avcframewrk.util.LateBoundValue.NhwCompleteWith[Value]
         & avcframewrk.util.LateBoundValue.NhwGetValue[Value]
         // AnyRef
      ) ,

      val options : Options ,
   )
   {

      export r.success
      export r.{complete, tryComplete }
      // export r.{completeWith, tryCompleteWith }

      export r.asFuture

      /**
       * 
       * this
       * is supposed to *resolve* when *asFuture* *becomes closed*, regardless of whether-or-not it *succeed*s
       * -
       * the suggested way
       * to schedule eg "ensuring that, on `asFuture.onClose`, all remaining open windows closes"
       * 
       * note
       * the signature `ValueOf[Unit] ?=> Value`,
       * to replicate *by-name parameters*, `throw`ing in case of Failure
       * 
       */
      val onClose = {
         asFuture
         .transform(tr => util.Success((_: ValueOf[Unit]) ?=> tr.get ) )(using concurrent.ExecutionContext.parasitic )
      }

   }

}

;

/**
 * 
 * ad-hoc `trait` to
 * support both type-narrowing pattern(s) - one being top-level and another one being inner
 * 
 */
@deprecated("this is an ad-hoc definition which we would otherwise have removed.")
trait WithPtoTyper[
   +T <: DefinesInterfacesTitleAndOptions ,

]
{
   protected
   val ePtoTyp : T
}

@deprecated("this is an ad-hoc definition which we would otherwise have removed.")
type PtoInvar[Ttl, O] = (

   DefinesInterfacesTitleAndOptions {

      type Title
         >: Ttl
         <: Ttl

      type Options
         >: O
         <: O

   }

)

@deprecated("this is an ad-hoc definition which we would otherwise have removed.")
type PtoContravar[-Ttl, -O] = (

   DefinesInterfacesTitleAndOptions {

      type Title
         >: Ttl

      type Options
         >: O

   }

)

;

/**
 * 
 * defines these two member `type`s "interfaces", `Inner` and `Options`
 * 
 */
type DefinesInterfacesTitleAndOptions = (
   Any
   & DefinesITitle
   & DefinesIOptions
)

trait DefinesITitle { type Title }

trait DefinesIOptions { type Options }

;
















