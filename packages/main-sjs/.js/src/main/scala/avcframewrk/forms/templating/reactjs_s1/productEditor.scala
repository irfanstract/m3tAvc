package avcframewrk.forms

package templating

package reactjs_s1














import cps.{async, await}

import scalajs.js

import com.github.plokhotnyuk.jsoniter_scala

import cps.monads.jsfuture.JSFuture

import typings.{std as dom }

import com.raquo.airstream








;

object ReactProductEditComponentPr
{
   ;

   ;

   def propsIValue
      [T ]
      (value: T )
   : (
      PropsIValue[value.type ]
      & typings.react.mod.Attributes
      & PropsWithExtMethodIOnChange[PropsIValue[T ] ]
   )
   = propsIValueAndOnChange[T] (value = value, onChangeFncOption = None )

   def propsIValueAndOnChange
      [T ]
      (value: T, onChangeFncOption: Option[js.Function1[PropsIValue[T ] , Unit] ] )
   : (
      PropsIValue[value.type ]
      & typings.react.mod.Attributes
      & PropsWithExtMethodIOnChange[PropsIValue[T ] ]
   )
   = {
      ;
      ({
         ;

         (onChangeFncOption *: EmptyTuple ) match
         //

         case (Some(onChangeFnc) *: EmptyTuple ) =>
            ;
            js.Dictionary("value" -> value, "onChange" -> onChangeFnc )

         case (None *: EmptyTuple ) =>
            ;
            js.Dictionary("value" -> value )
      })
      .asInstanceOf[(
         PropsIValue[value.type ]
         & typings.react.mod.Attributes
         & PropsWithExtMethodIOnChange[PropsIValue[T ] ]
      ) ]
   }

   type PropsIValue
      [+Value]
   >: PropsWithExtMethodIValue[Value]
   <: PropsWithExtMethodIValue[Value]

   // /* 
   //  * temporary early-detection, due to a SJS compiler bug resulting in later spurious "not a function" failure
   //  */
   // ({
   //    ;

   //    KSelectable.Esd(propsIValue(5) )

   //    propsIValue(5) : KSelectable.Esd[?]

   //    ({ val rV = KSelectable.Esd(propsIValue(5) ).selectDynamic("value") })

   //    ({ val conv = ((c: PropsIValue[Int] ) => KSelectable.Esd(c) ) })

   //    ({ val conv = ((c: (
   //       PropsIValue[Int ]
   //       & typings.react.mod.Attributes
   //    ) ) => KSelectable.Esd(c) ) })

   //    ({ val conv = summon[Conversion[PropsIValue[Int] , KSelectable.Esd[?] ] ] })

   //    propsIValue(5 ).value : Int

   //    System.currentTimeMillis()

   //    // propsIValue(5 ).value
   // })

   object KSelectable {
      ;

      ;

      type _ByKV
         //
         [-K, +V ]
      = _ByMT[(
         ({
            type Main[+actualK] = (actualK match { case K => V }) @annotation.unchecked.uncheckedVariance
         })
         #Main
      ) ]

      // opaque
      // type _ByMT
      //    //
      //    [+ValueByK[+k] ]
      // <: _Any
      // =  _Any

      // type _Any
      //    //
      // <: Any

      opaque
      type _ByMT
         //
         [+ValueByK[+k] ]
      <: Any
      =  Any

      type _Any
         //
      = _ByMT[[_] =>> Any ]

      // extension (receiver: _Any )
      //    private
      //    def receiverESl
      //    : Esd[receiver.type ]
      //    = receiver
      //    export receiverESl.selectDynamic

      // private
      implicit class Esd [
         // ValueByK_T[+actualK] ,
         +Receiver <: _Any ,
      ] (val receiver: Receiver )
      extends
      Selectable
      {
         ;

         @deprecated("KSelectable.Esd")
         def selectDynamic
            //
            [
               K <: String ,
               ValueByK_T[+actualK] ,
            ]
            (key: K )
            (using Receiver <:< _ByMT[ValueByK_T ] )
         : ValueByK_T[key.type ]
         = {
            (receiver : Any )
            .asInstanceOf[js.Dynamic ].selectDynamic(key)
            .asInstanceOf[ValueByK_T[key.type ] ]
         }
      }

      ;
   }

   type PropsWithExtMethodIValue
      [+Value]
   = KSelectable._ByKV["value", Value ] { val value: Value }

   // extension [Value] (p: PropsWithExtMethodIValue[Value] )
   //    def value
   //    : Value
   //    = {
   //       p.asInstanceOf[js.Dictionary[Value] ]
   //       .apply("value")
   //    }

   type PropsWithExtMethodIOnChange
      [-OnChgEvt]
   = PropsWithExtMethodIOnChange._Any[OnChgEvt]

   object PropsWithExtMethodIOnChange {
      ;

      opaque type _Any
         [-OnChgEvt]
      // >: js.Any
      <: Any
      =  Any

      // implicit
      def typeEqlEv[T <: Any ]
      : <:<[T, T & _Any[Any] ]
      = <:<.refl[T]

      // given termConv[T <: Any ]
      // : Conversion[T, T & _Any[Any] ]
      // = typeEqlEv[T].apply _

      extension [OnChgEvt] (p: PropsWithExtMethodIOnChange[OnChgEvt] )
         def onChangeFncOption
         = {
            p.asInstanceOf[js.Dictionary[js.Function1[OnChgEvt, Unit ] ] ]
            .get("onChange")
         }

   }

   ;
}

object ReactProductEditComponentTs
{
   ;

   ;

   /** 
    * ops to work with the eligible `T`s,
    * including
    * the syntheses of the corresponding `Mirror` and
    * the syntheses of the `avcalg.Lens`es
    * 
    */
   object EligibleT {
      ;

      /** 
       * `allFieldNames` (by definition excluding members inherited from `Product` ) ,
       * in order (since `case class`es each make its "elements" ordered )
       * 
       */
      transparent inline
      def allFieldNames
         [T <: Product ]
         (using tProducity: deriving.Mirror.ProductOf[T] )
      : collection.immutable.IndexedSeq[?]
      = {
         compiletime.constValueTuple[tProducity.MirroredElemLabels]
         .toIArray.toIndexedSeq
      }

      object TupleHolo {
         ;

         type _ForT
            [T]
         =  _ForTAndMirrorT[T, deriving.Mirror.ProductOf[T] ]

         opaque
         type _ForTAndMirrorT
            [T, +MirT <: deriving.Mirror.ProductOf[T] ]
         <: ([T1] =>> (monocle.Iso[Tuple, T1 ] *: IndexedSeq[String] *: MirT *: Unit *: EmptyTuple ) )[T ]
         =  ([T1] =>> (monocle.Iso[Tuple, T1 ] *: IndexedSeq[String] *: MirT *: Unit *: EmptyTuple ) )[T ]

         ;

         /** 
          * `forT`
          * 
          * presently the main entry-point
          * 
          */
         implicit
         inline /* `deriving.Mirror` only defines them as `type`s, not `val`s ... */
         def forT
            [T <: Product ]
            (using sdMirror: deriving.Mirror.ProductOf[T] )
         : _ForTAndMirrorT[T, sdMirror.type]
         = {
            ;
            val tFieldNames
            = {
               EligibleT.allFieldNames[T]
               .map(_.toString() )
            }
            val tFieldNameAndIndexPairs
            = {
               tFieldNames
               .zipWithIndex
            }
            ;
            val lsIso
            = {
               ;
               ({ val l = (
                  monocle.macros.GenIso.fields[T]
                  // work-around to the spurious discrepancy of the actually-returned `Expr` type
                  : monocle.PIso[T, T, ?, ?]
               ) ; l.asInstanceOf[monocle.Iso[T, Tuple ] ] } )
            }
            ;
            lsIso.reverse *: tFieldNames *: ((sdMirror, () ) : (sdMirror.type, Unit ) )
         }

         ;

         def tupleToIndexedSeqHolo
         : monocle.Iso[Tuple, IndexedSeq[?] ]
         = {
            ;
            monocle.Iso
               ((_.toList.toIndexedSeq) : (Tuple => IndexedSeq[?]) )
               ((s: IndexedSeq[?] ) => s.foldLeft[Tuple](EmptyTuple)(_ :* _ ) )
         }

         extension [T] (receiver: _ForT[T])
            def xArity
            : Int
            = receiver._2.length

         extension [T, MirT <: deriving.Mirror.ProductOf[T] ] (receiver: _ForTAndMirrorT[T, MirT ] )
            def sdMirror
            : MirT
            = receiver._3

            // transparent inline
            // def mirroredElemTypes
            // = compiletime.constValueTuple[receiver._3.MirroredElemTypes ]

         extension [T] (receiver: _ForT[T]) {
            //

            def lensAt
               [Idx <: Int]
               (i: Idx)
            = {
               ;
               val sLens
               = {
                  genericLensAt(i)
               }
               (receiver._1.reverse : monocle.Iso[T, Tuple] )
               .andThen(sLens )
            }

            def lensAndDescAt
               [Idx <: Int]
               (i: Idx)
            = {
               receiver.lensAt(i) *: receiver._2.apply(i) *: true  *: EmptyTuple
            }

            def lenses
            = {
               IndexedSeq.tabulate(receiver.xArity )(receiver.lensAndDescAt _ )
            }

            //
         }

         def genericLensAt
            //
            [Idx <: Int]
            (i: Idx)
            = {
               monocle.Lens
                  [Tuple, Any]
                  (d => d.toIArray.apply(i) )
                  (newItemValue => (s => ((s.take(i) ).:*(newItemValue).++(s.drop(i + 1 ) ) ) ) )
            }

         ;
      }

      ;

      ;
   }

   ;
}

object ReactProductEditComponent {
   ;

   // import rcpeSelectableIllegal.reflectiveSelectableIllegal

   ;

   ;

   export ReactProductEditComponentPr.{KSelectable => _ , *, given}
   final
   lazy val KSelectable
   : ReactProductEditComponentPr.KSelectable.type
   = valueOf

   ;

   def forValueT
      [T <: Product ]
      (using EligibleT.TupleHolo._ForT[T] )
   = {
      ;
      val holo0 @ (holo *: fieldNames *: tSdMirror *: _ )
      = implicitly[EligibleT.TupleHolo._ForT[T] ]
      ;
      locally({
         ;
         xx.comp({
            ((props: PropsIValue[T] & PropsWithExtMethodIOnChange[PropsIValue[T ] ] ) => {
               ;
               describeElement("div", null, (
                  Nil
                  :+ describeElement("p", null, (
                     Nil
                     :+ describeElement("code", null, (
                        Tuple.fromArray(fieldNames.toArray).toString()
                     ))
                  ) : _* )
                  :+ toEditor(holo0 )(props.value )
               ) : _* )
            })
         })
      })
   }

   extension [T] (desc: EligibleT.TupleHolo._ForT[T]) {
      //
      def toEditor
         //
         (value: T )
      : ReactElement
      = {
         ;
         // describeElement("div", null )
         // TODO
         ({
            ;

            val lenses = {
               (({ EligibleT.TupleHolo.lenses(desc ) } ) : IndexedSeq[(monocle.Lens[T, Any] *: String *: Tuple )] )
            }
            val lensesAndKs
            = {
               lenses
               .map({
                  case pair @ (l *: name *: _ ) =>
                     (name, pair )
               })
            }
            avcframewrk.forms.sMain.d1.rce.describeMappedItmListByKv(lensesAndKs)({
               //

               case l @ (lens *: key *: _ ) => {
                  ;
                  describeElement("div", null, (
                     //
                     Nil
                     :+ describeElement("p", null, "property", " ", (
                        describeElement("code", null, key )
                     ) )
                     :+ describeElement("div", null, "value:", " ", (
                        describeElement("code", null, s"${lens.get(value) }" )
                     ) )
                  ) : _* )
               }
            })
         })
      }
   }

   private[reactjs_s1]
   object xx {
      ;

      // def describeDivC(children: ReactWithinRender )

      /** 
       * a Component
       * 
       */
      def comp
         //
         [T <: js.Any ]
         (fnc : (
            //
            (props: T ) =>
               ReactElement
         ) )
      : AvfwReactFunctionComponent[T]
      = ReactComponent1.describe(fnc)

      ;
   }

   final
   lazy val EligibleT
   : ReactProductEditComponentTs.EligibleT.type
   = ReactProductEditComponentTs.EligibleT

   ;

   ;
}






















val _ = {}
