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

private[reactjsify]
object eclReactHookGsr {
   ;

   import eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.DependenciesArray

   import eclReactHookingLambdalComponentEsvAndImplicitlyPassedInstallmentalOpsDefs.{*, given }

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
               .fold("(no file-addr info)")(_.toString())
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
               .pipeLooseSelf(pos => s"${pos.hashCode() } in ${pos.toString() } " )
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
