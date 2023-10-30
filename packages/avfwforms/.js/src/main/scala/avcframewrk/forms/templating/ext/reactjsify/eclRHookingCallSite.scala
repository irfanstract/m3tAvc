// package avcframewrk.forms.templating.ext.reactjsify

package avcframewrk.forms

package templating

package ext.reactjsify










import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given}

import quoted.*





import scalajs.js

import com.raquo.airstream



import typings.{std as domItc }
import typings.std.{global as dom }
import typings.std.{global as window }



;

private
object eclReactHooking {
   ;

   ;

   type DependenciesArray
   = eclReactHooksDependencyArraysRelatedDefs.DependenciesArray

   final
   lazy val DependenciesArray
   : eclReactHooksDependencyArraysRelatedDefs.DependenciesArray.type
   = eclReactHooksDependencyArraysRelatedDefs.DependenciesArray

   trait %%@ {
      ;

      ;

      /** 
       * `stateHoldEwm` - RUNTIME ONLY!!!
       * 
       */
      private[reactjsify]
      inline
      def stateHoldEwm_=
         //
         (newValue: SHEWM._S )
         (using carrier: SHEWM._Carrier._Any )
      : Unit
      = {
         carrier.s_=(newValue )
      }

      transparent inline
      def stateHoldEwm
         //
         (using carrier : SHEWM._Carrier._Any )
      = carrier.s

      type SCA
      = SHEWM._Carrier._Any

      final
      lazy val SHEWM
      : StateHoldEwmD.type
      = StateHoldEwmD

      object StateHoldEwmD
      {
         ;

         type _S
         >: Map[OnRuntimeStringUuid, Esv._Any ]
         <: Map[OnRuntimeStringUuid, Esv._Any ]

         // TODO
         object _Carrier
         {
            ;

            type _Any
            = _Impl

            protected
            trait _Impl {
               ;

               def s: _S
               def s_=(newValue: _S )
               : Unit

               implicit def eobsm
               : eclReactObservingHooksImpl.EOBSM._Any
               
               ;
            }

            ;
         }

         ;
      }

      object StateHoldEwmDInReactJs {
         ;

         ;

         // TODO
         def useCarrier
            //
            ()
         : StateHoldEwmD._Carrier._Any
         = {
            ;

            typings.react.mod.useMemo(() => {
               ;

               new StateHoldEwmD._Carrier._Any
               {
                  ;

                  var s: StateHoldEwmD._S
                  = Map()

                  def eobsm
                  = ???

                  ;
               }
            } , js.Array() )
         }

         ;
      }

      ;
   }

   object %%@ {
      ;

      ;

      final
      lazy val mainInstance
      : %%@
      = {
         new AnyRef with %%@
      }

      ;
   }

   object Esv {
      ;

      type _Any
      >: (Any, DependenciesArray)
      <: (Any, DependenciesArray)

      type WhichReturnsValueT
         [+Value]
      = _ForValueTLAndU[Nothing, Value]

      type _ForValueT
         [Value]
      = _ForValueTLAndU[Value, Value]

      type _ForValueTLAndU
         [-ValueL <: ValueU, +ValueU]
      >: (ValueL, DependenciesArray) @annotation.unchecked.uncheckedVariance
      <: (ValueU, DependenciesArray)

      extension [Value] (d: _Any & _ForValueTLAndU[Value, Value] )
         def value
         : Value
         = d._1
         def dependenciesArray
         : DependenciesArray
         = d._2

      ;
   }

   ;

   type OnRuntimeStateHold

   type OnRuntimeStringUuid
   = OnRuntimeStringUuid._Any

   object OnRuntimeStringUuid {
      ;

      opaque type _Any
      <: String
      = String

      opaque type _ForValue[+Value <: String ]
      <: _Any
      = String

      def apply
         (value: String)
      : _ForValue[value.type]
      = value
   }

   ;
}

private[reactjsify]
object eclReactHookGsr {
   ;

   import eclReactHooking.DependenciesArray

   import eclReactHooking.{*, given }

   ;

   ;

   private[templating]
   case class GsrPerCallSitePathDependedDefs
      [+T <: (
         OnRuntimeStringUuid._Any ,
         Tuple ,
      ) ]
      (c: T)
   {

      export c.{_1 as uid }

      val onRtAllocator
      : %%@.mainInstance.type
      = %%@.mainInstance

   }

   /* extracted method, to minimise clutter away from the emitted code */
   /** 
    * `describeGsrPerCallSiteCtx`
    * 
    * we extracted this method
    * to minimise clutter away from the emitted code.
    * in practice
    * they're only `uidValue` who needs to be unique per call-site, and
    * for everything else
    * we can safely lift them away unify into being this method
    * 
    */
   def describeGsrPerCallSiteCtx
      //
      (
         uidValue: String ,
      )
   = {
      ;

      GsrPerCallSitePathDependedDefs((
         OnRuntimeStringUuid(uidValue ),
         EmptyTuple ,
      ) )
   }

   // TODO
   def generalisedSlotRef
      //
      [R : Type ]
      (using splCtx: Quotes )
      (
      //
      f1: Expr[(
         (onRtAllocator: %%@ ) =>
         (GsrPerCallSitePathDependedDefs[?] ) =>
         (OCA : onRtAllocator.SHEWM._Carrier._Any) ?=>
            R
      ) ] ,
      assumedPos : splCtx.reflect.Position ,
      )
   : Expr[R ]
   = {
      ;

      import quotes.reflect.*

      // TODO
      /* currently will generate same string more-than-once for same splice, not good, can't use this for now */
      val callSitePosString
      = {
         import language.unsafeNulls
         assumedPos
         .pipeLooseSelf(pos => "callsite:" + {
            /* avoid VSCode from freezing - needs line-break */
            s"${
               s"line ${pos.startLine}:${pos.startColumn} to ${pos.endLine}:${pos.endColumn}"
            } \n in file \n '${
               pos.sourceFile
               .getJPath
               .fold("(???)")(_.toString())
            }'"
         })
      } : String

      /** 
       * can safely use UUID gen this way since
       * macro expansion is just a one-time op.
       * 
       */
      val uidValue
      = {
         import language.unsafeNulls
         gslUidGenerator.asInstanceOf[{ def next(using Quotes)(key: java.lang.Object): Any }].next(assumedPos )
         .pipeLooseSelf(v => {
            s"${v } in ${
               assumedPos
               .pipeLooseSelf(pos => s"${pos.startLine} in ${pos.sourceFile.getJPath.fold("(repl)")(_.toString() ) } " )
            } "
         } )
      } : String

      '{
         ;

         val f1V
         = ${f1 }

         System.currentTimeMillis()

         ((f1U: f1V.type , uidValue: String) => {
            ;

            val ctx
            = {
               ;
               describeGsrPerCallSiteCtx
                  (uidValue = uidValue )
            }

            import ctx.*

            ((
               f1U
                  (onRtAllocator )
                  (ctx )
                  (using compiletime.summonInline )
            ))
         })(f1V , ${ Expr(uidValue) })
      }
      // .pipeLooseSelf(e => Expr.betaReduce(e) )
   }

   lazy val gslUidGenerator
   = newGsrGeneralisedUidGenerator()

   ;
}


















val _ = {}
