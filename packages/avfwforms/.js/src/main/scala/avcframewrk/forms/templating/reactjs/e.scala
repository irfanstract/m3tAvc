package avcframewrk.forms

package templating

package reactjs













import scalajs.js

val <
// : KS
// = new AnyRef
= new KSAsSelectableImpl(new AnyRef)

opaque type KS
<: Any
= AnyRef
object KS
{
   ;

   import language.dynamics

   ;

   ;

   implicit class Sl(receiver: KS )
   extends
   AnyRef
   // with Selectable
   with Dynamic
   {
      ;

      transparent
      inline
      def applyDynamicNamed
         //
         [
            C <: String ,
         ]
         (cls: C )
         (inline propSeq: (String, ReactPropValueAny )* )
      = ${mroDynamicRjsElementImpl(clsExpr = '{ cls } )('{ Seq(propSeq : _* ) } ) }

      transparent
      inline
      def applyDynamic
         //
         [
            C <: String ,
         ]
         (cls: C )
         (inline children: (ReactPropValueAny )* )
      = ${mroDynamicRjsElementAltImpl(clsExpr = '{ cls } )('{ Seq(children : _* ) } ) }

      ;
   }

   /** 
    * if found,
    * legal
    * 
    */
   class Voibility[-C, -N <: Int ]

   export ksDefaultReactJsImpl.{*}

}

object ksDefaultReactJsImpl
{
   ;

   ;

   def mroDynamicRjsElementAltImpl
      //
      [
         C <: String
         : quoted.Type
         ,
      ]
      (clsExpr: quoted.Expr[C] )
      (e: quoted.Expr[Seq[(ReactPropValueAny ) ] ] )
      (using quoted.Quotes )
   = {
      ;

      mroDynamicRjsElementImpl1(clsExpr = clsExpr )({
         ;

         '{ ${ e }.map(("", _ ) ) }
      })
   }

   def mroDynamicRjsElementImpl
      //
      [
         C <: String
         : quoted.Type
         ,
      ]
      (clsExpr: quoted.Expr[C] )
      (e: quoted.Expr[Seq[(String, ReactPropValueAny ) ] ] )
      (using quoted.Quotes )
   = {
      mroDynamicRjsElementImpl1(clsExpr = clsExpr )({
         ;

         propKvPairSeqCheckedImpl(clsExpr = clsExpr )(e)
      })
   }

   export ksDefaultReactJsImplImpl.{
      mroDynamicRjsElementImpl1 ,
      propKvPairSeqCheckedImpl ,
   }

   ;
}

protected
object ksDefaultReactJsImplImpl
{

   private[avcframewrk]
   final
   lazy val PlcPacked
   = ksImplUtil.PlcPacked

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
         C <: String
         : quoted.Type
         ,
      ]
      (clsExpr: quoted.Expr[C] )
      // (e: quoted.Expr[Seq[(String, ReactPropValueAny ) ] ] )
      (  e1: quoted.Expr[Seq[(String, ReactPropValueAny ) ] ] )
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
      (clsExpr: quoted.Expr[Any] )
      (e: quoted.Expr[Seq[(String, ReactPropValueAny ) ] ] )
      (using quoted.Quotes )
   : quoted.Expr[Seq[(String, ReactPropValueAny ) ] ]
   = {
      ;

      import quoted.quotes.reflect.*

      def eshow(e: Term)
      = {
         s"(${e.getClass().getName() }) ${Printer.TreeCode.show(e) } "
      }

      ({
         ;

         //

         ;
         e
         .pipeLooseSelf({
            case PlcPacked(e) =>
               e
            // case e =>
            //    report.error(s"[propKvPairSeqCheckedImpl] unsupported expr: ${Printer.TreeCode.show(e.asTerm ) } /// ${Printer.TreeStructure.show(e.asTerm ) }  " )
            //    e
         })
      })
      match {
         //

         case quoted.Varargs(e1Ls) if false =>
            report.errorAndAbort(s"[react.js] [propKvPairSeqCheckedImpl] the expr was: ${ e1Ls.map(e1 => eshow(e1.asTerm ) ) } : (spread as varargs) " )

         case e @ quoted.Varargs(e1Ls) =>
            ;

            quoted.Varargs({
               ;

               e1Ls

               .map(itemExpr => {
                  ;

                  PropAdnFwRenamedProps.checkValid(clsExpr)(itemExpr )
               } ) 
            })

         case _ =>

            report.errorAndAbort(s"yup2 (${ Printer.TreeCode.show(e.asTerm ) }) : " + Printer.TreeStructure.show(e.asTerm ) )

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
               None
               .orElse({
                  for {
                     key <- L.unapply(keyL)
                     impl <- {
                        import PropCheckCompulsion.{*, given}
                        val ccoCtx = CcoLookupCtx.byKey(key )
                        val gvClc = PropCheckCompulsion._UserSpaceCheckerLookupCtx.byKeyTAndValueT[key.type, Any ]
                        // conformantCheckerForCommons11Option(ccoCtx )
                        Some {
                           // PropCheckCompulsion._ComprehensiveChecker.for1Alt1(
                           //    //
                           //    ccoCtx = Some(ccoCtx ) ,
                           //    gvlcLookupCtx = Some(gvClc ) ,
                           // )
                           ({
                              ;

                              val ctx = {
                                 // val myKey : key.type = key
                                 PropCheckCompulsion.FullCcrLookupCtx.byKey(key = key, totalNfWarningTarget = perPropE )
                              }

                              PropCheckCompulsion._ComprehensiveChecker.forFullCcrCtx(ctx)
                           })
                           // .pipeLooseSelf({
                           //    case e : PropCheckCompulsion._CheckingFnc.ByPropNameAndValue[k, v] =>
                           //       e : PropCheckCompulsion._CheckingFnc.ByPropNameAndValue[Nothing, Any]
                           // })
                        }
                     }
                  }
                  yield impl
               })
               .getOrElse({
                  if false then report.warning(s"no 'PropCheckCompulsion.CheckingFnc' found for expr '${Printer.TreeCode.show(keyL.asTerm) }' ; this means, no checking!")
                  PropCheckCompulsion.CheckingFnc.ignorantInstance
               })
            })
            .run(keyExpr = '{ throw new NotImplementedError(s"no reason to pass 'key' the second time") }, valueExpr = valueExpr )
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

   object supplementaryPccs
   {
      ;

      lazy
      val denyEverythingsInstance
      : PropCheckCompulsion._CheckingFnc.ByPropNameAndValue[String, Any ]
      = {
         PropCheckCompulsion._CheckingFnc(splctx ?=> (kExpr, vlExpr) => {
            splctx.reflect.report.error((
               Seq()
               :+ s"not allowed "
               mkString("\n")
            ))
         })
      }

      given PropCheckCompulsion._CheckingFnc.ByPropNameAndValue["typ", Any ]
      = {
         PropCheckCompulsion._CheckingFnc(splctx ?=> (kExpr, vlExpr) => {
            splctx.reflect.report.error((
               Seq()
               :+ s"unsupported attrib : Laminar HTML attrib 'typ'. "
               :+ s"no such rename <<'type' to 'typ'>> imposed here. "
               :+ s"for the correct syntax-or-spelling, \nsee ${commonAttribSpellingsTutoUrl } . "
               mkString("\n")
            ))
         })
      }

   }

   ;

   export PropCheckCompulsion.{commonAttribSpellingsTutoUrl as commonAttribSpellingsTutoUrl }

   ;
}

// private[avcframewrk]
object ksImplUtil
{
   ;

   // private[avcframewrk]
   object PlcPacked {
      ;

      def unapply
         [E : quoted.Type ]
         (e : quoted.Expr[Seq[E] ] )
         (using quoted.Quotes )
      = {
         ;

         //

         ;
         Some(e)
         .collect({
            case '{ Seq(${e1 } : _* ) } =>
               e1
               .asExprOf[Seq[E ] ]
         })
      }
   }

}

export KS.{Sl as KSAsSelectableImpl }













val _ = {}
