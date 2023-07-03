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
    * quick implementation inspired by ECMA-262's `new Promise((return, reject) => ... )` idiom
    * 
    */
   def byLbv[Value, Title, Options](
      // 
      implStart: (Title, avcframewrk.util.LateBoundValue.NhwCompleteWith[? >: Value]) => Unit ,
   ) : (
      AnyRef
      & ByTitleAndOptions.ByGiven[Title, Options, avcframewrk.util.LateBoundValue.NhwGetValue[Value] ]
   ) = {

      object main extends
      AnyRef
      with ByTitleAndOptions.ByGiven[Title, Options, avcframewrk.util.LateBoundValue.NhwGetValue[Value] ]
      {

         val ePtoTyp: PtoInvar[Title, Options] = {
            /* (hopefully) harmless `asInstanceOf` towards the `type`s-only `trait` */
            new AnyRef()
            .asInstanceOf[PtoInvar[Title, Options] ]
         }
         
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

            implStart(title, q)

            q
         }

      }

      main
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
















