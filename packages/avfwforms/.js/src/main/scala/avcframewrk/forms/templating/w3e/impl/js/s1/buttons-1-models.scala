package avcframewrk.forms

package templating

package w3e.impl.js

package s1


















/**
 * 
 * solely the infrastructure for 'model'-ing
 * 
 */
protected
trait ELaminarQckButtonsReconcCtls
extends
   AnyRef
   /* */
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
{
   this : (
      AnyRef
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
   ) =>
   ;

   ;

   object CallbackTypeL {
      ;

      /** `anchor` */
      case class A(hrefOption: Option[java.net.URI] )

      /** `button` */
      case class B(callbackOption: Option[EdsbEventInfo => Unit ] )

      /** following `A` and `B`, is `C` . `BInputFunc` */
      case class C(edTypeOption: Option[BInputFunc[?] ] ) { export edTypeOption.{get => edType } }

   }

   @deprecated("the return-type of the sole view-method 'unlifted' is plain 'Airstream.Signal', rather than 'AsyncStateChangeMonad' as the receiver does.")
   implicit def OptionalCallbackAnimLaminarUnliftToAbcd (src : AsyncStateChangeMonad[Option[(EdsbEventInfo => Unit ) | java.net.URI ] ] )
   : OptionalCallbackAnimLaminarUnliftToAbcd1
   = OptionalCallbackAnimLaminarUnliftToAbcd1(src.toLaminarObservable )

   // extension
   implicit class OptionalCallbackAnimLaminarUnliftToAbcd1 (src : laminar.api.L.Signal[Option[(EdsbEventInfo => Unit ) | java.net.URI ] ] ) {
      //

      ;

      // /* only for the Observables (from Airstream) */
      import laminar.api.L

      ;

      import CallbackTypeL.{A, B, C }

      /** 
       * 
       * unlifts the `Signal[Option[Function1 | URI ] ]` into being `Signal[A | B | C ]`
       * 
       */
      def unlifted
      : L.Signal[A | B | C ]
      = {
         ;

         src

         .map({
            case (Some(s) ) =>
               Some {
                  //

                  /** 
                   * NOTE -
                   * there's some overlap between these case(s)
                   * (eg `BInputFunc` `extends` `Function0` as well )
                   * , so
                   * case-ordering is significant here
                   * 
                   */
                  s match {

                     //
                     case (edType : BInputFunc[t1] ) =>
                        C(edTypeOption = Some(edType ) )

                     //
                     case (run : Function1[evt$, rv$] ) =>
                        B(Some(run) )

                     //
                     case (href: java.net.URI ) =>
                        A(Some(href) )

                     //
                  }
               }
            case None =>
               None
         })
         .scanLeft[([T] =>> T )[A | B | C ] ](e => e.getOrElse(A(None) ) )({
            case (_, Some(v)) =>
               v
            case (v0, None ) =>
               v0 match {
                  case _ : A => A(None)
                  case _ : B => B(None)
                  case _ : C => C(None)
               }
         })
      }

      //
   }

   ;

   ;

   ;

   private[avcframewrk]
   case class BfSnaConfig(
      //
      expectInlineHeadline : Boolean
      ,
   )

   ;
} // ELaminarQckButtonsReconcCtls

















val _ = {}
