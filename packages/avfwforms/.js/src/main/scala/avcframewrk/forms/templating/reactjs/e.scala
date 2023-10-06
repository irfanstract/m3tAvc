package avcframewrk.forms

package templating

package reactjs













import scalajs.js

export typings.react.mod.{createElement as describeElement }

// export typings.react.mod.ReactElement
type ReactElement
= typings.react.mod.ReactElement

type ReactPropValueAny
>: Any
<: Any

case class PropsAndChildren1(
   //
   attribValues : Map[String, ReactPropValueAny ]
   ,
   children : IndexedSeq[ReactElement]
   ,
)
{
   ;

   def toTupleOf2 = (attribValues, children)

   @deprecated
   def toTuple = (this.attribValuesScalablytyped, children)

   ;
}

object PropsAndChildren1 {
   ;

   import avcframewrk.forms.localutil.predefChainingOpsImplicits.{*, given }

   ;

   val addingAttrib
   = {
      ;
      monocle.macros.GenLens[PropsAndChildren1](_.attribValues )
      .pipeLooseSelf(l => {
         (kv: (String, ReactPropValueAny ) ) =>
         (receiver: PropsAndChildren1 ) =>
            val (k, v) = kv
            l
            .modify(propsBefore => propsBefore.updated(k, v ) )(receiver)
      })
   }

   val addingAll
   = {
      ;
      monocle.macros.GenLens[PropsAndChildren1](_.children )
      .pipeLooseSelf(l => {
         (children: collection.immutable.Iterable[ReactElement] ) =>
         (receiver: PropsAndChildren1 ) =>
            l
            .modify(_ :++ children )(receiver)
      })
   }

   val adding1
   = {
      ;
      addingAll
      .compose(IndexedSeq().appended[ReactElement] _ )
   }

   extension (d: PropsAndChildren1 )
      def attribValuesScalablytyped
      = {
         d.attribValues
         .foldLeft[typings.react.mod.Attributes ] ({
            typings.react.mod.Attributes()
         })({
            case (receiver, kv ) =>
               (receiver.set _ ).tupled
               .apply(kv )
         })
      }

   ;
}

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
      : ReactElement
      = {
         ;

         val (props, children)
         = {
            propsAndChildrenFromApplyDyn((
               propAdnListChecked(cls )(propSeq )
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
      }

      ;
   }

   transparent
   inline
   def propAdnListChecked
      //
      [C]
      (cls: C )
      (inline propSeq: collection.immutable.Iterable[(String, ReactPropValueAny ) ] )
   = ${propAdnListCheckedImpl(clsExpr = '{ cls })('{ propSeq }) }

   protected[templating]
   def propAdnListCheckedImpl
      //
      (clsExpr: quoted.Expr[Any] )
      (e: quoted.Expr[collection.immutable.Iterable[(String, ReactPropValueAny ) ] ] )
      (using quoted.Quotes )
   : quoted.Expr[collection.immutable.Iterable[(String, ReactPropValueAny ) ] ]
   = {
      ;

      import quoted.quotes.reflect.*

      def eshow(e: Term)
      = {
         s"(${e.getClass().getName() }) ${Printer.TreeCode.show(e) } "
      }

      '{ ${e }.toIndexedSeq }
      match {
         //

         case quoted.Varargs(e1Ls) if false =>
            report.error(s"[react.js] [propAdnListCheckedImpl] the expr was: ${ e1Ls.map(e1 => eshow(e1.asTerm ) ) } : (spread as varargs) " )
            e

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

         ;

         for { case perPropE @ '{ ("children", ${_} ) } <- Some(itemExpr) }
         do {
            report.error(s"'children' is not supported, use expr '(childrenSeq : _* )' instead. (locally limitation )", perPropE )
         }

         for { case perPropE @ '{ ("class", ${_} ) } <- Some(itemExpr) }
         do {
            report.error(s"'class' is not supported, use 'className' instead. (see ${commonAttribSpellingsTutoUrl } )", perPropE )
         }

         for { case perPropE @ '{ ("for", ${_} ) } <- Some(itemExpr) }
         do {
            report.error(s"'for' is not supported, use 'htmlFor' instead. (see ${commonAttribSpellingsTutoUrl } )", perPropE )
         }

         // for { case perPropE @ '{ (${'{ "onclick" } | '{ "onchange" } | '{ "onblur" } | '{ "onsubmit" } }, ${_} ) } <- Some(itemExpr) }
         // do {
         //    report.error("must be 'onClick' or 'onChange' .", perPropE )
         // }

         // for { case perPropE @ '{ (${'{ "contenteditable" } | '{ "s" } }, ${_} ) } <- Some(itemExpr) }
         // do {
         //    report.error("'for' is not supported, use 'htmlFor' instead.", perPropE )
         // }

         ;
         '{
            ${itemExpr }
         }
      }

      ;
   }

   /** 
    * if found,
    * legal
    * 
    */
   class Voibility[-C, -N <: Int ]

   // protected
   def propsAndChildrenFromApplyDyn
      //
      (propSeq: collection.immutable.Iterable[(String, ReactPropValueAny ) ] )
   = {
      ;

      implicit val chO
      = avcframewrk.forms.localutil.predefChainingOps

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
               case "" =>
                  ;
                  adding1
                  .apply(v.asInstanceOf[ReactElement] )(s0 )
               case "children" =>
                  ;
                  addingAll
                  .pipeLooseSelf({ case f: Function1[itemsT, Function1[s0Type, t ] ] => {
                     f.apply(v.asInstanceOf[itemsT] )(s0 )
                     // ???
                  }})
               case _ =>
                  ;
                  addingAttrib
                  .apply((k, v) )(s0 )
            }
      })
      .toTuple
   }

   ;

   val commonAttribSpellingsTutoUrl
   = "https://react.dev/reference/react-dom/components/common"

   ;
}

export KS.{Sl as KSAsSelectableImpl }

val <
// : KS
// = new AnyRef
= new KSAsSelectableImpl(new AnyRef)













val _ = {}
