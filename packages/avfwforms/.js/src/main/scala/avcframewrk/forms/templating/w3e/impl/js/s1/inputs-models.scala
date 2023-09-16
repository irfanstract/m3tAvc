package avcframewrk.forms

package templating

package w3e.impl.js

package s1





















private[w3e]
trait ELaminarQckInputElemsReconcNativesModels
extends
   AnyRef
   /* */
   with ENativeElementsD1
   with ELaminarQckInputElemsLcs
   /* a temporary repetition here (of below) necessary to prevent the compiler from hanging */
   with ELaminarQckCoreHtml
   with ELaminarQckButtonsReconcCtls
   with w3e.pre.Articles
   with ELaminarQckCore
{
   this : (
      AnyRef
      with ELaminarQckCoreHtml
      with ELaminarQckButtonsActionModelling
      with ELaminarQckButtonsActionModellingTwo
      with ELaminarQckButtonsReconcCtls
      with ENativeElementsD1
      with w3e.pre.Articles
      with ELaminarQckCore
      with ELaminarQckCoreHtml
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import laminar.api.L

   ;

   // private[avcframewrk]
   transparent
   inline def summonGspGoodDefaultValue
      [Value]
      (using GivenSpinner1[Value] )
   : Value
   = {
      ;

      summon[GivenSpinner1[Value] ]
      match {
         case `given_GivenSpinner_DateTime` =>
            ("2023-09-06" )
            // (0.25 )
            // (0.25, 0.5, 0.75, { org.scalajs.dom.console.log("did compare:", typ, given_GivenSpinner_DateTime ) } )
         case edType : w3e.pre.StdGsps.ofSnb.given_GivenSpinner_Number[enm] =>
            edType.apply("0")
         case `given_GivenSpinner_Boolean` =>
            (false )
         case `given_GivenSpinner_String` =>
            ("" )
         // case _ : DateTime =>
         //    ("" )
      }
      match {
         case e : Value =>
            e
      }
   }

   lazy val _ = {
      val _ = summonGspGoodDefaultValue[Boolean] match { case v => v }
      val _ = summonGspGoodDefaultValue[String ] match { case v => v }
   }

   lazy val inpfaDemoAutoIncrement
   = {
      import laminar.api.L

      ;

      ;

      val vr = L.Var[String]("")

      new {
         reschedule()
         def reschedule()
         : Unit
         = {
            scalajs.js.timers.setTimeout(970)({
               vr.set(scalajs.js.Date.apply() )
               reschedule()
            })
         }
      }

      vr.signal
   }

   /**
    * 
    * `input`s where setting the attrib-or-prop `value` will do what the name suggests
    * (as it's not the case when `type` were `button` or `submit` or `checkbox` or `file` )
    * 
    */
   @deprecated("this is a co-variant (re)export of the latter.")
   type InpfaStatic[+Value ]
   = InpfaStaticCovar[Value ]

   type InpfaStaticCovar[+Value ]
   = InpfaStaticInvar[? <: Value ]

   /**
    * 
    * `input`s where setting the attrib-or-prop `value` will do what the name suggests
    * (as it's not the case when `type` were `button` or `submit` or `checkbox` or `file` )
    * 
    */
   case class InpfaStaticInvar
      [Value ]
      (
         //
         value: Value
         ,
         propagate1 : (evtInfo: dom.Event, newValue: Value ) => Unit
         ,
      )
   {
      ;

      ;
   }


   ;

   ;

   ;

}























val _ = {}
