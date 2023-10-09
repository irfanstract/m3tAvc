package avcframewrk.forms

package templating

package reactjs













import scalajs.js

final
lazy val ksDefaultReactJsImpl
= KS._Impl.Impl(using ksDefaultReactJsImplImpl )

protected
object ksDefaultReactJsImplImpl
extends
AnyRef
with KS._ImplImpl.Impl
{

   private[avcframewrk]
   final
   lazy val PlcPacked
   = ksImplUtil.PlcPacked

   type _ElementConstructor
   >: String
   <: String

   type _DataAny
   >: ReactPropValueAny
   <: ReactPropValueAny

   // protected
   def propsAndChildrenFromApplyDyn
      //
      (propSeq: Seq[(String, ReactPropValueAny ) ] )
   = {
      ;

      //

      import PropsAndChildren1.{* }

      propSeq
      .foldLeft[PropsAndChildren1 ] (({
         ;

         /** it's mutable ; shall not use the fnc-al syntax */
         val dict
         = typings.react.mod.Attributes()

         PropsAndChildren1(
            //
            attribValues = Map()
            ,
            children = IndexedSeq()
            , 
         )
      }))({
         //
         case (s0, (k, v) ) =>
            ;
            import s0.{children as children0 }

            k
            match {
               //

               case "" | "child" =>
                  ;
                  adding1
                  .apply(v.asInstanceOf[ReactElement] )
                        (s0 )

               case "children" =>
                  ;
                  addingAll
                  .apply({
                     v.asInstanceOf[collection.immutable.Iterable[Any ] ]
                  } )
                        (s0 )

               case _ =>
                  ;
                  addingAttrib
                  .apply((k, v) )
                        (s0 )

            }
      })
      .toTuple
   }

   def mroDynamicRjsElementImpl1
      //
      [
         C <: _ElementConstructor
         : quoted.Type
         ,
      ]
      (clsExpr: quoted.Expr[C] )
      // (e: quoted.Expr[Seq[(String, _DataAny ) ] ] )
      (  e1: quoted.Expr[Seq[(String, _DataAny ) ] ] )
      (using quoted.Quotes )
   = {
      '{
         ;

         val cls = ${clsExpr }

         val (props, children)
         = {
            propsAndChildrenFromApplyDyn((
               // propKvPairSeqChecked(cls )(propSeq )
               ${e1 }
            ) )
         }

         describeElement
            (
               //
               cls ,
               props
               ,
               // TODO children
               children : _*
               ,
            )
         .asInstanceOf[ReactElement.FromCls[cls.type ] ]
      }
   }

   // protected[templating]
   def propKvPairSeqCheckedImpl
      //
      (clsExpr: (
         // quoted.Expr[? >: _ElementConstructor <: Any]
         quoted.Expr[? <: Any]
      ) )
      (e: quoted.Expr[Seq[(String, _DataAny ) ] ] )
      (using quoted.Quotes )
   : quoted.Expr[Seq[(String, _DataAny ) ] ]
   = {
      ;

      import quoted.*
      import quotes.reflect.*

      import ksImplUtil.VarargsOrSeqLike

      import ksImplUtil.asLinebreaking

      // TODO
      def eshow(e: Term)
      = {
         s"(${e.getClass().getName() }) ${Printer.TreeCode.asLinebreaking().show(e) } "
      }

      ({
         ;

         ;
         e
         .pipeLooseSelf({
            //

            case PlcPacked(e) =>
               e

            case e @ ksImplUtil.CrookedVarargs() =>
               locally[(msg: String, e: Expr[?] ) => Any ]({
                  // report.errorAndAbort(_, _)
                  report.error(_, _)
               })
               .apply((
                  s"[propKvPairSeqCheckedImpl] crooked varargs: ${Printer.TreeCode.asLinebreaking().show(e.asTerm ) } /// ${Printer.TreeStructure.asLinebreaking().show(e.asTerm ) }  "
               ) , e )
               e

            case e =>
               locally[(msg: String, e: Expr[?] ) => Any ]({
                  // report.errorAndAbort(_, _)
                  report.error(_, _)
               })
               .apply((
                  s"[propKvPairSeqCheckedImpl] unsupported expr: ${Printer.TreeCode.asLinebreaking().show(e.asTerm ) } /// ${Printer.TreeStructure.asLinebreaking().show(e.asTerm ) }  "
               ) , e )
               e

         })
      })
      match {
         //

         /** a debug-log-and-abort case - do not enable unless debugging! */
         case Varargs(e1Ls) if false =>
            report.ksErrorAndAbort(s"[react.js] [propKvPairSeqCheckedImpl] the expr was: ${ e1Ls.map(e1 => eshow(e1.asTerm ) ) } : (spread as varargs) " )

         case e @ VarargsOrSeqLike(e1Ls) =>
            ;

            Varargs({
               ;

               e1Ls

               .map(itemExpr => {
                  ;

                  PropAdnFwRenamedProps.checkValid(clsExpr)(itemExpr )
               } ) 
            })

         case e1 @ ksImplUtil.CrookedVarargs() =>

            report.error((
               Seq()
               :+ s"match error, \n  (${ Printer.TreeShortCode.asLinebreaking(lnCLimit = 8 ).show(e.asTerm ) }) : "
               :+ s"unsupported-or-crooked spread-to-varargs Expr. "
               :+ s"please rewrite into regular direct varargs,"
               :+ s"and try again. "
               :+ s"=== "
               :+ s"note: "
               :+ s"  - repeated quoting-and-splicing can lead to an (erroneous) extraneous synthetic '.asInstanceOf[_* & _* ]' suffix, "
               :+ s"    leading to this error, "
               :+ s"    consider simply passing the quoted-ref-to-varargs Expr directly, to avoid that issue "
               :+ s"fix the code, and try again. "
               :+ "==="

               mkString "\n"
            ) , e )

            e

         case _ =>

            report.error((
               Seq()
               :+ s"match error, \n  (${ Printer.TreeShortCode.asLinebreaking().show(e.asTerm ) }) : "
               :+ s"unsupported Expr. "
               :+ s"=== "
               :+ s"supported Expr(s) include: "
               :+ s"  - Expr(s) obtained from 'Varargs' or from quoted ref to varargs "
               :+ s"note: "
               :+ s"  - repeated quoting-and-splicing can lead to an (erroneous) extraneous synthetic '.asInstanceOf[_* & _* ]' suffix, "
               :+ s"    leading to this error, "
               :+ s"    consider simply passing the quoted-ref-to-varargs Expr directly, to avoid that issue "
               :+ s"fix the code, and try again. "
               :+ "==="
               // :+ "==="
               // :+ s"${ Printer.TreeCode.show(e.asTerm ) } "
               // :+ s"// "
               // :+ s"${ Printer.TreeStructure.show(e.asTerm ) } "

               mkString "\n"
            ) , e )

            e

         //
      }
   }

   /**
    * 
    * React/ReactDOM
    * renames a small number of attribs/props, like `for -> htmlFor`, so
    * a minor static-checking becomes very important
    * 
    */
   object PropAdnFwRenamedProps
   {
      ;

      ;

      def checkValid
         //
         [
            //
            _PKey <: String
            : quoted.Type
            ,
            _PV <: ReactPropValueAny
            : quoted.Type
            ,
         ]
         (receivingCompClsExpr : quoted.Expr[Any] )
         (itemExpr : quoted.Expr[(_PKey, _PV )] )
         (using quoted.Quotes )
      : quoted.Expr[(_PKey, _PV )]
      = {
         ;

         import quoted.quotes.reflect.*

         ;

         ;

         /** 
          * make compile-time warning, and then
          * return an expr which'd do a run-time logging
          * 
          */
         inline
         def rpWarnAtCtAndRt
            (msg: String, e: quoted.Expr[Any])
         = {
            ;

            report.warning(msg = msg , expr = e )

            '{
               ;

               import org.scalajs.dom.console

               console.warn(${quoted.Expr(msg) } )
               console.groupCollapsed("the expr was: " )
               console.log(${quoted.Expr(Printer.TreeCode.show(e.asTerm ) ) } )
               console.groupEnd()

               ()
            }
         }

         var lgs : Seq[quoted.Expr[Unit ] ]
         = Seq()

         ;

         val L = quoted.Expr

         ;

         for { case perPropE @ '{ (${L(key @ ("children" | "child" ) ) }: String , ${valueExpr} : Any ) } <- Some(itemExpr) }
         do {
            lgs
               :+= rpWarnAtCtAndRt((
                  (
                     Seq()
                     :+ s"adding child(en) via '${key } = ${key }' is deprecated ;"
                     :+ s"instead, meld into the expr '(children : _* )' instead. (locally limitation ). "
                     // :+ s"the expr:\n  ${key } = ${ Printer.TreeCode.show(valueExpr.asTerm ) } "
                     :+ s"see also https://react.dev/learn#rendering-lists for in-depth . "
                     :+ "maybe the 'child' or 'children' attrib you intended \nactually has different name (eg not 'children' but instead 'docuChildren' or 'exprChildren' or 'items' or something else )? - \ncheck your FW/lib docs for the right syntax. "
                  ).mkString("\r\n")
               ), perPropE )
         }

         // report.warning(s"a warning.")

         for { case perPropE @ '{ (${keyL }: String , ${valueExpr} : Any ) } <- Some(itemExpr) }
         do ({
            ;

            // PropCheckCompulsion.conformantCheckerFromExpr(itemExpr )
            ({
               ;

               None

               .orElse({
                  for {
                     //

                     key <- L.unapply(keyL)

                     impl <- {
                        ;

                        import PropCheckCompulsion.{*, given}

                        val ccoCtx = CcoLookupCtx.byKey(key )
                        val gvClc = PropCheckCompulsion._UserSpaceCheckerLookupCtx.byKeyTAndValueT[key.type, Any ]

                        Some {
                           ({
                              ;

                              val ctx = {
                                 // val myKey : key.type = key
                                 PropCheckCompulsion.FullCcrLookupCtx.byKey(key = key, totalNfWarningTarget = perPropE )
                              }

                              PropCheckCompulsion._ComprehensiveChecker.forFullCcrCtx(ctx)
                           })
                        }
                     }

                     //
                  }
                  yield impl
               })

               .getOrElse({
                  ;

                  if false
                  then report.warning(s"no 'PropCheckCompulsion.CheckingFnc' found for expr '${Printer.TreeCode.show(keyL.asTerm) }' ; this means, no checking!")

                  PropCheckCompulsion._CheckingFnc.ignorantInstance
               })
            })
            .run(
               //
               keyExpr = '{ throw new NotImplementedError(s"no reason to pass 'key' the second time") },
               valueExpr = valueExpr ,
            )
         })

         for { case perPropE @ '{ (${L(key @ "typ" ) }: String , ${_} ) } <- Some(itemExpr) }
         do {
            lgs :+= rpWarnAtCtAndRt(s"'${key }' is not supported, use 'type' instead. \n(if migrating from Laminar, there's specifically no such respelling here in React ). \nsee ${commonAttribSpellingsTutoUrl } ", perPropE )
         }

         { System.currentTimeMillis() + 5 + 55 }

         ;
         itemExpr
         match {
            case e =>
               e
         }
         match { case e => {
            '{ Seq(${quoted.Varargs(lgs) } : _* ) ; ${e} }
         } }
      }

      ;
   }

   export supplementaryPccs.{given}
   export supplementaryPccs.{denyEverythingsInstance as denyEverythingsPcc }

   ;

   export PropCheckCompulsion.{commonAttribSpellingsTutoUrl as commonAttribSpellingsTutoUrl }

   ;
}

;















val _ = {}
