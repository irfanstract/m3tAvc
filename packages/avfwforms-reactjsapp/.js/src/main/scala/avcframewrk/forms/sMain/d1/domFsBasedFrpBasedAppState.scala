package avcframewrk.forms.sMain.d1
















import cps.{async, await}

import scalajs.js

import scalajs.js.annotation.*

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.{std as dom }

import com.raquo.airstream

import avcframewrk.forms.domNavigatorObj.storageUsageUtil.FsWatch








object FsBasedFrpBasedAppState {
   ;

   ;

   ;

   ;

   object KsModeFacade {
      ;

      import &&&&.{*, given}

      ;

      def apply
         //
         [_M ]
         (using
            //
            serHandler : FromAndToStringSerHandler._ForMdlT[_M ] ,
         )
         (
            //
            defaultValue : _M ,
            debug: Boolean = false ,
         )
         (tryGetFilePath : () => js.Promise[typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default ] , tgfpDependencies : rce.AvfwDependenciesArray )
      = {
         ;

         ({
            ;

            new Selectable {
               ;

               def useSnapshot
                  //
                  ( )
                  (using FsWatch.CtxtualSetterStyle._Any )
               = {
                  ;

                  &&&&
                  .apply
                     [_M ]
                     (defaultValue = defaultValue )
                     (tryGetFilePath = tryGetFilePath , tgfpDependencies = tgfpDependencies )
               }

            }
         })
      }

      {
         ;

         // def useSnapshot
         //    //
         //    (un1: Unit = () )
         //    (using FsWatch.CtxtualSetterStyle._Any )
         // = {
         //    ;

         //    ({
         //       ;

         //       implicit
         //       object serHandler {
         //          ;

         //          val tryParseFromString
         //          = _Json.unapply _

         //          val serialiseToString
         //          = {
         //             ;
         //             (value: _Json._M) => {
         //                jsoniter_scala.core.writeToStringReentrant(value )
         //             }
         //          }

         //       }

         //       def defaultValue
         //       = {
         //          ;
         //          avcalculus.musical.Key.byFromCKeyDeviation({
         //             avcalculus.musical.InTwelvethKey.D.fromKeyCDeviation
         //          })
         //       }

         //       &&&&
         //       .apply
         //          [_Json._M ]
         //          (defaultValue = defaultValue )
         //          (tryGetFilePath = tryGetFilePath _ , tgfpDependencies = (Nil :+ "") : rce.AvfwDependenciesArray  )
         //    }) 
         // }
      }

      ;
   }

   ;
}

object &&&& {
   ;

   ;

   object FromAndToStringSerHandler {
      ;

      ;

      type _ForMdlT
         [_M]
      = _ForMdlTAlt[_M, _M]

      type _ForMdlTAlt
         [-ML <: MRet, +MRet]
      >: ETPFS[ML, MRet]
      <: ETPFS[ML, MRet]

      type ETPFS
         [-_ML <: _MRet, +_MRet]
      = (AnyRef | js.Any) {
         //
         val tryParseFromString : (String) => Option[_MRet ]
         val serialiseToString : (_ML) => String
      }

      ;
   }

   def apply
      //
      [_M ]
      (using
         //
         serHandler : FromAndToStringSerHandler._ForMdlT[_M ] ,
      )
      (
         //
         defaultValue : _M ,
         debug: Boolean = false ,
      )
      (using ctsp : FsWatch.CtxtualSetterStyle._Any )
      (tryGetFilePath : () => js.Promise[typings.nativeFileSystemAdapter.typesSrcFileSystemFileHandleMod.default ] , tgfpDependencies : rce.AvfwDependenciesArray )
   = {
      ;

      import serHandler.tryParseFromString
      import serHandler.serialiseToString

      val (fContentsOption, c) *: cAlt *: EmptyTuple
      = {
         ;
         FsWatchInReact.useLeafNodePayloadOpt(() => {
            tryGetFilePath()
         } , tgfpDependencies )
      }

      if (debug) rce.useValueChangeLogging(fContentsOption, s"fContentsOption: $fContentsOption" )

      val fAsC
      = {
         rce.useJsFuture(() => async[JSFuture] {
            ;

            fContentsOption
            .flatMap(v => Option(v).map(_.nn ) )
            .map({
               case c => await(c.text() )
            })
            .flatMap(tryParseFromString(_) )
            .getOrElse({
               defaultValue
            })
         }, defaultValue, () , {
            implicit val p = rce.AvfwDependenciesArrayItemability.byIdentity
            Nil :+ fContentsOption
         })
      }

      if (debug) rce.useValueChangeLogging(fAsC, s"fAsC: $fAsC" )

      val updateTo
      = {
         c
         .compose((value: _M) => {
            dom.global.console.log("new value: ", s"$value" )
            FsWatchInReact.plainTxtBlob(serialiseToString(value ) )
         } )
      }

      (fAsC, updateTo).->(cAlt)
   }

   ;
}















val _ = {}