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

         import $typer.Title
         import $typer.Options

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
         val $typer : (
            DefinesInterfacesTitleAndOptions & 
            PtoInvar[PromptTitle, PromptOptions ]
         )

         type PromptTitle
         type PromptOptions

      }
      
   }

   type TitleAndOptionsCallback[-Title, -Options, +R ]
      = (title: Title, options: Options ) => R

   @deprecated("the literal meaning of 'TitleOptions' conflicts with what pseudo-that meant here.")
   type TitleOptionsCallback[-Title, -Options, +R ]
      = TitleAndOptionsCallback[Title, Options, R ]

   /**
    * 
    * packs `TitleOptionsCallback`s,
    * yielding `DefinesDoPrompt` subclass instance(s)
    * 
    */
   object ByTitleAndOptionsCallback
   {

      /**
       * 
       * "by LateBoundValue", characterised by these "resolve-with"-like methods
       * 
       * 
       * @param implStart to handle those things on every "start new question"
       * 
       * @tparam Title serve as the upper-bound of `prompt$.title`
       *
       * @tparam Options serve as the upper-bound of `prompt$.options`
       *
       * @tparam ImmediateReturnValue the immediate return-value of the resulting main method
       *
       * @param mainRepack (re)wrap into being `ImmediateReturnValue`
       * 
       */
      private[ByTitleAndOptionsCallback]
      def applyImpl[Value, Title, Options, ImmediateReturnValue](
         // 
         implStart: TitleOptionsCallback[Title, XStdOptions[Value, Options], Unit ] ,
         mainRepack: avcframewrk.util.LateBoundValue.NhwGetValue[Value] => ImmediateReturnValue ,
      ) : (
         AnyRef
         & ByTitleAndOptions.ByGiven[Title, Options, ? <: ImmediateReturnValue ]
      ) = {

         trait WithEPtoTypImpl extends
         AnyRef
         with WithPtoTyper[PtoInvar[Title, Options ] ]
         {

            val $typer = {
               /* (hopefully) harmless `asInstanceOf` towards the `type`s-only `trait` */
               new AnyRef()
               .asInstanceOf[PtoInvar[Title, Options] ]
            }
            
         }

         def newXQuestion() = {

            newLateBinding[Value]
         }

         object main extends
         AnyRef
         with ByTitleAndOptions.ByGiven[Title, Options, ImmediateReturnValue ]
         with WithEPtoTypImpl
         {

            export $typer.Title
            export $typer.Options
            
            override
            def prompt(
               //
               title: Title,
               options: Options,

            ) = {

               val q = {
                  
                  newXQuestion()
               }

               implStart(title, new XStdOptions[Value, Options](r = q, options = options ) )

               mainRepack(q)
            }

         }

         main
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
       * 
       * @param implStart to handle those things on every "start new question"
       * 
       * @tparam Title serve as the upper-bound of `prompt$.title`
       *
       * @tparam Options serve as the upper-bound of `prompt$.options`
       *
       */
      def apply[Value, Title, Options](
         // 
         
         implStart: TitleOptionsCallback[Title, XStdOptions[Value, Options], Unit ]
         ,

         /* can't use regular parameter due to the resulting widening ; needs it to be implicits instead */

      )(using implRepack: PostSpawnAutoUnpackingPrefByValue[[_] =>> Any ] )
      // : (
      //    //
      //    AnyRef
      //    & ByTitleAndOptions.ByGiven[Title, Options, implRepack.UnpackedFormByValueAsIs[Value] ]
      // )
      = {

         applyImpl[Value, Title, Options, implRepack.UnpackedFormByValueAsIs[Value] ](
            implStart = implStart,
            mainRepack = e => { implRepack(e) : implRepack.UnpackedFormByValueEquiv[Value] } ,
         )
      }

      /**
       * 
       * the default `PostSpawnAutoUnpackingPref`, which shall transparently be `givenImmediateRepacker`
       * 
       */
      given givenImmediateRepacker.type =
         givenImmediateRepacker
      
      // export npsuug.*
      export npsuug.{
         //

         givenNonRepacking ,
         givenImmediateRepacker ,

         PostSpawnAutoUnpackingPrefByValue ,

      }

      final lazy val npsuug
         // : avcframewrk.util.LateBoundValue.NhwFactoryPostSpawnAutoUnpackingUtilDefs /* won't work, as `XRhetoricalGiven` is defined separately */
         : npsuugImpl.type
         = npsuugImpl
      
      protected[DefinesDoPrompt]
      object npsuugImpl extends
      AnyRef
      with avcframewrk.util.LateBoundValue.NhwFactoryPostSpawnAutoUnpackingUtilDefs
      with avcframewrk.util.LateBoundValue.NhwFactoryPostSpawnAutoUnpackingUtilDefs.DefinesTypeXRhetoricalGivenEquiv[XRhetoricalGiven]
      ;

      /**
       * 
       *
       * @param r
       * 
       * @param options supposed to be the *options* argument in the originating call
       * 
       */
      protected 
      class XStdOptions[Value, +Options] private[DefinesDoPrompt] (
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
          * the signature `XRhetoricalGiven ?=> Value`,
          * to replicate *by-name parameters*, `throw`ing in case of Failure
          * 
          */
         val onClose = {
            asFuture
            .transform(tr => util.Success((_: XRhetoricalGiven) ?=> tr.get ) )(using concurrent.ExecutionContext.parasitic )
         }

      }

      type XRhetoricalGiven
         >: DummyImplicit
         <: DummyImplicit

   }

   export ByTitleAndOptionsCallback.{apply as byLbvS }

   /**
    * 
    * utility; `LateBoundValue.newInstance[Value]`
    * 
    */
   def newLateBinding[Value] = {

      avcframewrk.util.LateBoundValue.newInstance[Value]
   }

}

;

/**
 * 
 * ad-hoc `trait` to
 * support both type-param-ing pattern(s) - one being top-level and another being inner/nested
 * 
 */
@deprecated("this is an ad-hoc definition which we would otherwise have removed.")
trait WithPtoTyper[
   +T <: DefinesInterfacesTitleAndOptions ,

]
extends
AnyRef
{

   protected
   // final
   // lazy
   val $typer : T

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
















