package avcframewrk.forms

package templating

package w3e.pre












trait Buttons
extends
AnyRef
with Articles
{

   type Action

   val Action
   : (
      AnyRef
      & AcsfLabelledCallbackTranslator[Action]
   )

   /** 
    * `URLAction`
    * 
    * needs to be a separate NS since
    * the default-parameterisations prevent overloading `-____-`
    * 
    */
   val URLAction
   : (
      AnyRef
      & AcsfLabelledUrlTranslator[URLAction]

   ) // URLAction$

   type URLAction
   >: Action
   <: Action

   type ButtonArt
      <: Article

   def describeButtonByAction(action: Action)
   : ButtonArt

   extension (mainLineContents: Article) {

      /**
       * with clickability leading to the specified Action
       * 
       */
      def asHavingDirectAction(action: Action)
      : Article
      = {
         (mainLineContents ++ describeButtonByAction(action ) )
      }

   } // (mainLineContents: Article) asHavingDirectAction(action: Action)

}

// TODO
case class given_AcTitleIndependentCodings1
   [+C <: Articles & PlainTxtContents ]
   (ctx: C )
extends
   AcTitleIndependentCodings1
{
   ;

   import ctx.{*, given}

   ;

   opaque type TitleCoding[-Title ]
      <: (value: Title @annotation.unchecked.uncheckedVariance ) => Article
      =  (value: Title @annotation.unchecked.uncheckedVariance ) => Article

   implicit def stringAcTitling[Title <: String]
   = {
      identity[(value: Title) => Article ](vl => {
         PlainLocaleStringPlainTxtArticle(java.util.Locale.ROOT.nn, vl )
      })
   }

} // given_AcTitleIndependentCodings1

object VarEditingActionsProv
{
   ;

   ;

} // VarEditingActionsProv$

trait VarEditingActionsProv
extends
AnyRef
with StdGsps
{
   this : (
      AnyRef
      & Buttons
      & StdGsps
   ) =>
   ;

   ;

   import laminar.api.L

   ;

   /**
    * `Action`s which each updates the `Var`.
    * 
    */
   val VarEditingAction
   : (
      VarEditingActionConstructor

   )

   protected[avcframewrk]
   opaque type VarEditingActionConstructor
   <: VarEditingActionConstructorImpl
   = VarEditingActionConstructorImpl

   private[pre]
   case class VarEditingActionConstructorImpl
      (impl: (
         //

         /** 
          * `[Value given GivenSpinner] -> (varLike : VarLike[Value] ) -> Action`
          * 
          * anticipating some 3rd party libs which provides "mapped var(s)" which `extends` both these `trait`s yet does not `extends` `Var#`.
          * `Var[type A]#` `extends` both `SignalSource[A]#` and `Sink[A]#`
          * 
          */
         [Value] =>
         (baseTitle: String | Article ) =>
         (r: L.SignalSource[Value], w: ODEC[Value] ) =>
         (GivenSpinner[Value] ) ?=>
            Action

      ))
   {
      ;

      // export impl.{apply as applyAlt }

      def apply
         //
         [Value]
         (baseTitle: String | Article )
         (r: L.Var[Value] )
         (using GivenSpinner[Value] )
      : Action
      = {
         ;
         
         impl
         .apply
            (baseTitle)
            (r = r, w = ODEC[Value](editSinkOption = Some(r ) ) )
      }

      ;
   }

   lazy val _ = {
      val f = VarEditingAction
      // f.apply("")(??? : L.Var["5"] )
      f.apply("")(??? : L.Var[String] )
   }

   private[w3e]
   case class ODEC[Value] (
      //
      editSinkOption
      : Option[com.raquo.airstream.core.Sink[Value] ]
      = None
      ,
      undoRedoCmdSinkOption
      : Option[com.raquo.airstream.core.Sink[ValueEditOrUndoOrRedo.ForUndo | ValueEditOrUndoOrRedo.ForRedo ] ]
      = None
      ,
   )

   @deprecated
   protected[avcframewrk]
   given VarEditingActionConstructorFromAVar
   : Conversion[(
      //

      [Value] =>
      (baseTitle: String | Article ) =>
      (operand: L.SignalSource[Value] & L.Sink[Value] ) =>
      (GivenSpinner[Value] ) ?=>
         Action

   ), VarEditingActionConstructor]
   = (impl1) => {
      ;
      VarEditingActionConstructorImpl(
         //

         impl = (
            //

            [Value] =>
            (baseTitle: String | Article ) =>
            (r: L.SignalSource[Value], edc: ODEC[Value] ) =>
            (gsp: GivenSpinner[Value] ) ?=>
            {
               impl1
                  [Value ]
                  (baseTitle )
                  ({
                     new L.SignalSource[Value] with L.Sink[Value]
                     { export r.toObservable ; val toObserver = edc.editSinkOption.get.toObserver }
                  })
            }
         )
         ,

      )
   }

   ;

   ;
} // VarEditingActionsProv#











