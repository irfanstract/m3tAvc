
package avcframewrk.forms.sMain.d1

package rceBasedUiTemplates
















import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.{std as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageUsageUtil.FsWatch









;

object cxdByDomFsDirAndJsonIter {
   ;

   //
   @annotation.experimental
   @annotation.compileTimeOnly("please give an impl")
   def ??? = throw new NotImplementedError

   ;

   ;

   def apply
      //
      [MValueT]
      (using undoRedoFrp : avcframewrk.forms.documentstatemgmt.UndoAndRedo.SpecialFpCcOps._FiniteModeInstance )
      (
         //
         tryGetFilePathImpl
         : () => JSFuture[typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default ]
         ,
         _Json
         : undoRedoFrp.type ?=> ser.%%&[[e] =>> undoRedoFrp.OperatedMdlStateSetCc[e] , MValueT ]
         ,
         initialMdlValue
         : => MValueT
         ,
         mainEditingUi
         : (
            //
            (
               //
               ctx: (
                  `%%^_Impl` {
                     val emva: {
                        type MdlValue
                        >: MValueT
                        <: MValueT
                     }
                  }
               ) ,
               undoRedoFrp : avcframewrk.forms.documentstatemgmt.UndoAndRedo.SpecialFpCcOps._FiniteModeInstance ,
            ) ?=>
            (
               value: MValueT ,
               stack: undoRedoFrp.OperatedMdlStateSetCc[MValueT ] ,
               ce: (
                  ctx._CImplHooks.%!
                  // `%%^_Impl`#_CImplHooks_%!
                  // Any
               ),
            ) =>
               rce.ReactElement
         )
         // = (undoRedoFrp) ?=> { (
         //    _: MValueT,
         //    s: Any ,
         //    ce: (
         //       // `%%^_Impl`#_CImplHooks_%!
         //       Any
         //    ),
         // ) => {
         //    rce.describeElement("p", null, s"value: ${s } " )
         // } }
         ,
      )
   = {
      ;
      object emvaImpl {
         type MdlValue
         >: MValueT
         <: MValueT 
      }
      new %%^(
         //
         tryGetFilePathImpl = tryGetFilePathImpl ,
         emva = emvaImpl ,
         _Json = _Json ,
         initialMdlValue = initialMdlValue ,
         mainEditingUi = ctx ?=> mainEditingUi(using ctx, undoRedoFrp) ,
      )
   }

   ;

   private[rceBasedUiTemplates]
   class %%^
      //
      [MdlValT ]
      (using val undoRedoFrp : avcframewrk.forms.documentstatemgmt.UndoAndRedo.SpecialFpCcOps._Any )
      (
         //
         private[rceBasedUiTemplates]
         val tryGetFilePathImpl
         : () => JSFuture[typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default ]
         ,
         private[rceBasedUiTemplates]
         val emva
         : { type MdlValue >: MdlValT <: MdlValT }
         ,
         val _Json
         : ser.%%&[[e] =>> undoRedoFrp.OperatedMdlStateSetCc[e] , emva.MdlValue ]
         ,
         private[rceBasedUiTemplates]
         val initialMdlValue
         : DummyImplicit ?=> emva.MdlValue
         ,
         private[rceBasedUiTemplates]
         val mainEditingUi
         // : (value: _Json._MValue, stack: _Json._M ) => rce.ReactElement
         : (ctx: (
            `%%^_Impl` {
               val emva: {
                  type MdlValue
                  >: MdlValT
                  <: MdlValT
               }
            }
         ) ) ?=> (
            //
            value: emva.MdlValue ,
            stack: undoRedoFrp.OperatedMdlStateSetCc[emva.MdlValue ] ,
            ce: ctx._CImplHooks.%! ,
         ) => rce.ReactElement
         ,
      )
   extends
   `%%^_Impl`()

   private[rceBasedUiTemplates]
   trait `%%^_Impl`
      //
      (
         //
      )
   extends
   AnyRef
   {
      this1 =>
      ;

      implicit
      val undoRedoFrp : avcframewrk.forms.documentstatemgmt.UndoAndRedo.SpecialFpCcOps._Any

      private[rceBasedUiTemplates]
      val 
      tryGetFilePathImpl
      : () => JSFuture[typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default ]

      private[rceBasedUiTemplates]
      val emva
      : { type MdlValue }

      val _Json
      : ser.%%&[[e] =>> undoRedoFrp.OperatedMdlStateSetCc[e] , emva.MdlValue ]

      private[rceBasedUiTemplates]
      val 
      initialMdlValue
      : DummyImplicit ?=> _Json._MValue

      private[rceBasedUiTemplates]
      val mainEditingUi
      // : (value: emva.MdlValue, stack: _Json._M ) => rce.ReactElement
      : (ctx : this.type) ?=> (
         value: emva.MdlValue ,
         stack: undoRedoFrp.OperatedMdlStateSetCc[emva.MdlValue ] ,
         ss: ctx._CImplHooks.%! ,
      ) => rce.ReactElement

      ;

      ;

      object XData {
         ;

         type _Value
         >: emva.MdlValue
         <: emva.MdlValue

         def useSnapshot
            //
            (un1: Unit = () )
            (using FsWatch.CtxtualSetterStyle._Any )
         = {
            ;

            esns
            .useSnapshot( )
         }

         protected
         final
         lazy val esns
         = {
            ({
               ;

               implicit
               object serHandler {
                  ;

                  val tryParseFromString
                  = _Json.unapply _

                  val serialiseToString
                  = {
                     ;
                     (value: _Json._M) => {
                        _Json(value )
                     }
                  }

               }

               def defaultValue
               = {
                  ;
                  undoRedoFrp.initiallyWith[emva.MdlValue ] ({
                     ;
                     initialMdlValue
                  })
               }

               // TODO
               FsBasedFrpBasedAppState.KsModeFacade
               .apply
                  [_Json._M ]
                  (defaultValue = defaultValue )
                  (tryGetFilePath = tryGetFilePath _ , tgfpDependencies = (Nil :+ "") : rce.AvfwDependenciesArray  )
            })
         }

         export this1._Json

         def tryGetFilePath
            //
            ()
         = tryGetFilePathImpl()

         ;
      }

      type _CImplHooks_%! = _CImplHooks.%!
      object _CImplHooks {
         ;

         class %!
            //
            ()
         {
            ;

            val ((s, updateSTo ), () )
            = {
               ;

               implicit
               val gsp
               = FsWatch.CtxtualSetterStyle.valueAndSetterInstance

               XData.useSnapshot()
            }

            val runRedoNTimesImpl
            = ([R] => (fnc: (n: Int ) => R ) => fnc ) {
               ;
               rce.useEventCallback((n: Int ) => {
                  updateSTo({
                     /* https://github.com/lampepfl/dotty/issues/18768 */
                     val sOps = s.:%&:!!
                     import sOps.{*, given }
                     s.presentlyState

                     s
                     .afterRedoNTimes(n )

                     /* https://github.com/lampepfl/dotty/issues/18768 */
                     .pipeLooseSelf(e => e )
                  } )
               })
            }

            val pushEditTo
            = {
               ;
               rce.useEventCallback((item: emva.MdlValue) => {
                  updateSTo({
                     /* https://github.com/lampepfl/dotty/issues/18768 */
                     val sOps = s.:%&:!!
                     import sOps.{*, given }
                     s.presentlyState

                     s
                     .withClearedRedoStateSeq(Nil :+ item )
                     .afterRedoBy()

                     /* https://github.com/lampepfl/dotty/issues/18768 */
                     .pipeLooseSelf(e => e )
                  } )
               })
            }

            ;
         }

         ;
      }

      val _C = {
         ;

         ;

         ;

         rce.ReactComponent1.describe((_: Any ) => {
            ;

            val sHookValues
            = _CImplHooks.%!()
            import sHookValues.{*, given }

            rce.describeElement("div", null, (
               Nil
               :+ rce.describeElement("p", null, "main app" )
               :+ (
                  //
                  rce.describeElement("div", null, (
                     Nil
                     :+ rce.describeElement("button", rce.newHtmlButtonAttribs.setOnClick(_ => runRedoNTimesImpl(-1 ) ) , "undo" )
                     :+ rce.describeElement("button", rce.newHtmlButtonAttribs.setOnClick(_ => runRedoNTimesImpl( 1 ) ) , "redo" )
                  ) : _* )
               )
               :+ mainEditingUi(using this1 ) (value = s.presentlyState, stack = s , ss = sHookValues )
            ) : _* )
         })
      }

      ;
   }

   ;

   def serScheme
      //
      //
      [
         _MCcT[+e]
         ,
         _MValueT
         // <: Matchable
         ,
      ]
      (using jsoniter_scala.core.JsonValueCodec[_MCcT[_MValueT ] ] )
      ( )
   = {
      new ser.%%&[_MCcT, _MValueT] ( )
   }

   ;

   protected
   object ser {
      ;

      ;

      ;

      private[rceBasedUiTemplates]
      class %%&
         //
         [
            _MCcT[+e]
            ,
            _MValueT
            // <: Matchable
            ,
         ]
         (using jsoniter_scala.core.JsonValueCodec[_MCcT[_MValueT ] ] )
         ( )
      {
         ;

         type _MCc[+e]
         >: _MCcT[e]
         <: _MCcT[e]

         type _MValue
         >: _MValueT
         <: _MValueT

         type _M
         >: _MCc[_MValue ]
         <: _MCc[_MValue ]

         def unapply
            (v: String)
         = {
            ;
            (util.Try(Some {
               jsoniter_scala.core.readFromStringReentrant[_M](v )
            }))
            .recover({
               case z : jsoniter_scala.core.JsonReaderException =>
                  None
            })
            .get
         }

         // dom.global.console.log("emus test", s"${
         //    jsoniter_scala.core.readFromStringReentrant[_M] ("{\"fromKeyCDeviation\":{\"valueInDegrees\":165.22973151443315}}")
         // }")

         def apply
            (v: _M)
         = jsoniter_scala.core.writeToStringReentrant(v)

         ;
      }

      ;
   }

   ;
}














val _ = {}
