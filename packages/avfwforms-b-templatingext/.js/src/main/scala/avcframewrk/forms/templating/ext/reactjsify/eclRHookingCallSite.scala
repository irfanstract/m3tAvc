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

   /** 
    * `generalisedSlotRef`
    * 
    * @tparam R the type which `value` shall conforms to
    */
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
   = generalisedSlotRefFlexed(f1, assumedPos = assumedPos )

   /**
    * a generalisation of `generalisedSlotRef` 
    * 
    * @tparam R0 the type which `value` shall conforms to
    */
   def generalisedSlotRefFlexed
      //
      [R0 : Type, R2 : Type ]
      (using splCtx: Quotes )
      (
      //
      f1: Expr[(
         (onRtAllocator: %%@ ) =>
         (GsrPerCallSitePathDependedDefs[?] ) =>
         (OCA : onRtAllocator.SHEWM._Carrier._Any) ?=>
            R2
      ) ] ,
      assumedPos : splCtx.reflect.Position ,
      )
   : Expr[R2 ]
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
               .fold("(no file-addr info)")(_.toString() )
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
               .pipeLooseSelf(pos => s"${pos.hashCode() } in ${
                  pos.toString()
                  .replace("\\", "/")
                  .xLettroshuffled()
               } " )
            } "
         } )
      } : String

      '{
         ;

         System.currentTimeMillis()

         ((ignorev1: Unit , uidValue: String) => {
            ;

            val ctx
            = {
               ;
               describeGsrPerCallSiteCtx
                  (uidValue = uidValue )
            }

            import ctx.*

            ((
               ({ "no B-reduction" ; ${f1 } })
                  (onRtAllocator )
                  (ctx )
                  (using compiletime.summonInline )
            ))
         })(() , ${ Expr(uidValue) })
      }
      // .pipeLooseSelf(e => Expr.betaReduce(e) )
   }

   lazy val gslUidGenerator
   = newGsrGeneralisedUidGenerator()

   extension (s: String)
      def xLettroshuffled
         ()
      : String
      = {
         ;

         import language.unsafeNulls
         s
         .codePoints().toArray().toIndexedSeq
         .zipWithIndex
         .sortBy({ case (_, i) => {
            Int.MaxValue
            ./(23700 )
            .toLong
            /* requires nmcl-overflow-truncation for this to work properly */
            .pipeLooseSelf(vl => Seq.fill(i)({}).foldLeft[Long] (vl)((vl2, _) => (vl * vl2 ) ) )
            .abs
         } })
         .map(_._1 )
         .pipeLooseSelf(codePts => new String(codePts.toArray, 0, codePts.length ) )
      }

   ;
}


















val _ = {}
