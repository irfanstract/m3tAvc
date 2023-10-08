package avcframewrk.forms

package templating

package reactjs


















;

import scalajs.js

private
object StdPropsCheckCompulsion
{
   ;

   ;

   import PropCheckCompulsion.{*, given }

   ;

   ;

   /** 
    * optional
    * one of
    * the mandated early-searched instances
    * 
    */
   private[forms]
   // transparent
   // inline
   def conformantCheckerForCommons11Option
      [Key <: String , Value >: Any <: Any ]
      // (ctx: CcoLookupCtx.ByKey[? <: String] )
      (ctx: CcoLookupCtx.ByKey[? <: Key ] )
   : Option[_CheckingFnc.ByPropNameAndValue[Key, Value] ]
   = {
      ;

      import ctx.{key as ccTargetPropKey }

      ;

      val SCF
      = _CheckingFnc.apply[Key, Value].andThen(Some(_) )

      def blockingAskRewrite
         //
         (valueExpr : quoted.Expr[Value ], ccLookupCaseActualKey: String )
         (finalName: String )
         (using cQuotes: quoted.Quotes)
      : Unit
      = {
         ;

         ;

         import compiletime.*
         import quoted.*
         import cQuotes.reflect.*

         report.error((
            (
               Seq()
               :+ s"mis-named property '${ccLookupCaseActualKey }' ;"
               :+ s"use '${finalName }' instead."
               :+ "=== "
               :+ s"React and ReactDOM \nrenames some attrib names, including these ones,"
               :+ s"like <<'${ccLookupCaseActualKey }' becomes '${finalName }'>> ."
               :+ s"for more info, including the proper supported <e>s and attribs,"
               :+ s"see ${commonAttribSpellingsTutoUrl } ."
               :+ s"Note: "
               :+ s"maybe the '${ccLookupCaseActualKey }' attrib you intended \nactually has different name (eg not '${ccLookupCaseActualKey }' but instead something else )? -"
               :+ s"check the FW/lib u're using's docs for the right syntax-and-spelling. "
            ).mkString("\r\n")
         ), valueExpr )
      }

      def toAskLookBackActualFwDocs
         //
         (ccLookupCaseActualKey: String )
         ( )
      : String
      = {
         ;

         (
            Seq()
            :+ s"maybe the '${ccLookupCaseActualKey }' attrib you intended \nactually has different name (eg not '${ccLookupCaseActualKey }' but instead something else )? -"
            :+ s"check the FW/lib u're using's docs for the right syntax-and-spelling. "
         ).mkString("\r\n")
      }

      ;

      (ccTargetPropKey, () )
         match {
         //

         case (k1 : "class", () ) => SCF(quotes ?=> (_, valueExpr) => {
            ;
            blockingAskRewrite(valueExpr = valueExpr, ccLookupCaseActualKey = k1 )(finalName = "className" )
         } )

         case (k1 : "for", () ) => SCF(quotes ?=> (_, valueExpr) => {
            ;
            blockingAskRewrite(valueExpr = valueExpr , ccLookupCaseActualKey = k1 )(finalName = "htmlFor" )
         } )

         case (k1 : "key", () ) => SCF(quotes ?=> (_, valueExpr) => {
            ;
            import quotes.reflect.{*}

            if !valueExpr.isExprOf[String | Double ] then
               // report.error(s"not statically String nor Double: ${Printer.TreeShortCode.show(valueExpr.asTerm ) } ")
               ;
               report.error((
                  (
                     Seq()
                     :+ s"unsupported 'key' value: "
                     :+ s"  ${ Printer.TreeShortCode.show(valueExpr.asTerm ) } "
                     :+ s"; not the expected '(_ : String | long float )' . "
                     :+ s"=== "
                     :+ s"value of 'key' \nneeds be one of those two types (String or 'long float') - "
                     :+ s"React's reconciler \ndoes not support any more-complicated \"key object\"s . "
                     :+ s"see also https://react.dev/learn#rendering-lists for in-depth . "
                     :+ s"Note: "
                     :+ s"maybe the 'key' attrib you intended \nactually has different name (eg not '${k1 }' but instead 'authKey' or 'productKey' or 'unlockNextLevelGmKey' or something else )? -"
                     :+ s"check the FW/lib u're using's docs for the right syntax-and-spelling. "
                  ).mkString("\r\n")
               ) , valueExpr )
         } )

         case (k1 : "ref", () ) => SCF(quotes ?=> (_, valueExpr) => {
            ;
            import quotes.reflect.{*}

            if (
               !valueExpr.isExprOf[AnyRef | Function1[?, ?] | js.Function ]
               ||
               valueExpr.isExprOf[String | AnyVal | java.lang.Number ]
            ) then
               // report.error(s"not statically String nor Double: ${Printer.TreeShortCode.show(valueExpr.asTerm ) } ")
               ;
               report.error((
                  (
                     Seq()
                     :+ s"unsupported 'ref' value: "
                     :+ s"  ${ Printer.TreeShortCode.show(valueExpr.asTerm ) } "
                     :+ s"; not the expected 'React.Ref' . "
                     :+ s"=== "
                     :+ s"value of 'ref' \nneeds be one of those two types (CallbackRef or MutableRefObject) - "
                     :+ s"see also https://react.dev/learn#rendering-lists for in-depth . "
                     :+ s"Note: "
                     :+ s"maybe the 'key' attrib you intended \nactually has different name (eg not '${k1 }' but instead something else )? -"
                     :+ s"check the FW/lib u're using's docs for the right syntax-and-spelling. "
                  ).mkString("\r\n")
               ) , valueExpr )
         } )

         case (k1 : "", () ) => SCF(quotes ?=> (_, valueExpr) => {
            ;
            import quotes.reflect.{*}

            if (
               !valueExpr.isExprOf[([E] =>> (E | (collection.immutable.Iterable[E] & Seq[E] ) ) )[typings.react.mod.ReactElement | String | AnyVal ] ]
               // ||
               // valueExpr.isExprOf[String | AnyVal | java.lang.Number ]
            ) then
               // report.error(s"not statically String nor Double: ${Printer.TreeShortCode.show(valueExpr.asTerm ) } ")
               ;
               report.error((
                  (
                     Seq()
                     :+ s"unsupported 'children' value: "
                     :+ s"  ${ Printer.TreeShortCode.show(valueExpr.asTerm ) } "
                     :+ s"; not the expected (ReactNode or Seq thereof ) . "
                     :+ s"=== "
                     :+ s"value of 'children' \nneeds be one of those two types (ReactNode or Seq thereof ) - "
                     :+ s"see also https://react.dev/learn#rendering-lists for in-depth . "
                     :+ s"Note: "
                     :+ s"maybe the 'child' or 'children' attrib you intended \nactually has different name (eg not '${k1 }' but instead something else )? -"
                     :+ s"check the FW/lib u're using's docs for the right syntax-and-spelling. "
                  ).mkString("\r\n")
               ) , valueExpr )
         } )

         case _ =>
            None

      }
   }

   export supplementaryPccs.commonAttribSpellingsTutoUrl
   
   ;
}

object supplementaryPccs
{
   ;

   val commonAttribSpellingsTutoUrl
   = "https://react.dev/reference/react-dom/components/common"

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


















val _ = {}
