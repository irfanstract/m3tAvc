package avcframewrk.forms

package templating

package ext.givmk

package impl


















;

import scalajs.js

import org.scalajs.dom

import com.raquo.laminar.{nodes as ln }

import laminar.api.L

;

// %&**@!@%*@
object LlKeyOrPropSetReconciliability1
{
   ;

   ;

   def byAttrAssignList
      //
      (s: Set[AttrKeyAndValuePairByValue[? >: Nothing <: Any ] ] )
   : AttrAssignListAndChldList
   = {
      AttrAssignListAndChldListImpl((
         s ,
         () ,
      ))
   }

   ;

   type AttrKeyAndValuePairAny
   = AttrKeyAndValuePairImpl[?, ?]

   type AttrKeyAndValuePairByValue[V]
   = AttrKeyAndValuePairImpl[?, V]

   type AttrKeyAndValuePairWithValue[+V]
   = AttrKeyAndValuePairImpl[?, ? <: V]

   type AttrKeyAndValuePair
      [+K <: LlAttr.ForValue[V] , V]
   = AttrKeyAndValuePairImpl[K, V]
   final
   lazy val AttrKeyAndValuePair
   = AttrKeyAndValuePairImpl

   protected
   case class AttrKeyAndValuePairImpl
      [+K <: LlAttr.ForValue[V] , V]
     (protected val impl : (K, V) )
   {
      export impl.{_1 as key }
      export impl.{_2 as value }
      def asReselved
      = {
         AttrKeyAndValuePairImpl[key.type, V ]((key, value) )
      }
   }

   ;

   type AttrAssignListAndChldList
   = AttrAssignListAndChldListImpl

   protected
   case class AttrAssignListAndChldListImpl
      (impl: (
         Set[AttrKeyAndValuePairByValue[? >: Nothing <: Any ] ] ,
         Unit ,
      ) )
   {
      ;

      export impl.{_1 as attribAssignmSet }

      @deprecated
      val attribAssignmMap
      = {
         attribAssignmSet
         .map({ val l = (e : AttrKeyAndValuePairAny ) => (e.key, e.value) ; l })
         .toMap
      }

      ;
   }

   ;
}

def allocateLlTagReconciler
   [
      SpawnedLl <: ln.ReactiveElement[?] & AcceptableLE
         : reflect.Typeable
      ,
   ]
   (llTag: com.raquo.laminar.tags.Tag[SpawnedLl ] )
: (
   LReconciliativeKeyTo1[(
      ScnAllocAndReconcileAndDistillH[?, LlKeyOrPropSetReconciliability1.AttrAssignListAndChldList, ? <: AcceptableLE ]
   )]
)
= {
   ;

   import LLTR.{*, given }

   ;

   LReconciliativeKey.allocate[ScnAllocAndReconcileAndDistillH.type ] ((
      //

      ScnAllocAndReconcileAndDistillH[Xsb1[SpawnedLl], LlKeyOrPropSetReconciliability1.AttrAssignListAndChldList, SpawnedLl ](
         //
         alloc = () => Xsb1(llTag = llTag ) ,
         reconcile = { case e => e._1.model_=(e._2) } ,
         distillLHandle = _.llE ,
      )
   ))
}
object LLTR {
   ;

   ;

   import LlKeyOrPropSetReconciliability1.{*, given }

   /** 
    * does these things
    * - `k.prepareOn(e)` ; a necessary initialitative call
    * - `k.asAnimablySettibleProp() as asUpdatable`
    * 
    */
   def ByLlAttrPrepared
      [
         //
         V : reflect.Typeable ,
         // K <: LlAttr.ForValue[V] ,
      ]
      (k: LlAttr.ForValue[V], keyValuePair: AttrKeyAndValuePair[k.type, V ] )
      (e: ln.ReactiveElement[?] )
      (using LlPropAnimableSettibility.GivenDefaultSequencingKV[k.type, V] )
   = {
      new ByLlAttrPreparedImpl[V ](k, keyValuePair)(e)
   }

   protected
   class ByLlAttrPreparedImpl
      [
         //
         V : reflect.Typeable ,
         // K <: LlAttr.ForValue[V] ,
      ]
      (val k: LlAttr.ForValue[V], private[ByLlAttrPreparedImpl] val keyValuePair: AttrKeyAndValuePair[k.type, V ] )
      // (e: )
      (e: ln.ReactiveElement[?] )
      (using LlPropAnimableSettibility.GivenDefaultSequencingKV[k.type, V] )
   {
      ;

      // org.scalajs.dom.console.log(s"ByLlAttrPreparedImpl", k, e.hashCode(), keyValuePair.value )

      k.prepareOn(e)

      val asUpdatable
      = k.asAnimablySettibleProp()

      @deprecated
      def :=(newValue: V)
      = { e.amend(asUpdatable.:=(newValue) ) }

      @deprecated
      def <--(newS: L.Signal[V])
      = { e.amend(asUpdatable.<--(newS ) ) }

      ;
   }

   case class PspwPair
      [V]
   (impl: (LlAttr.ForValue[V ], ByLlAttrPreparedImpl[V] ) )
   {
      def toTuple2 : impl.type = impl
   }

   type Xsb
   = Xsb1[?]

   class Xsb1
      //
      [
         SpawnedLl <: ln.ReactiveElement[?] & AcceptableLE
         : reflect.Typeable
         ,
      ]
      (llTag: com.raquo.laminar.tags.Tag[SpawnedLl ] )
   {
      // LlKeyOrPropSetReconciliability1.AttrAssignListAndChldList

      val llE
      = {
         llTag
         .pipeLooseSelf({
            case e : com.raquo.laminar.tags.HtmlTag[t] =>
               e.apply()
            case e : com.raquo.laminar.tags.SvgTag[t] =>
               e.apply()
         })
         .pipeLooseSelf(_.asInstanceOf[SpawnedLl ] )
      }

      extension [v] (keyValuePair: AttrKeyAndValuePairByValue[v] ) {
         //

         /** 
          * run the ctor of `ByLlAttrPreparedImpl`
          * unconditionally (ie ignoring whether it has already been done )
          * 
          */
         private[Xsb1]
         def runPrepConstructorUnconditionally
            ()
         : ByLlAttrPreparedImpl[v]
         = {
            ;

            // TODO
            given LlPropAnimableSettibility.GivenDefaultSequencingKV[keyValuePair.key.type, v ]
            = LlPropAnimableSettibility.gdsBy(L.Val(keyValuePair.value : v ) )

            new ByLlAttrPreparedImpl[v](keyValuePair.key, keyValuePair.asReselved)(llE)
         }

         //
      }

      private[givmk]
      var attrs
      : collection.immutable.Iterable[ByLlAttrPreparedImpl[? >: Nothing <: Any ] ] & collection.Set[?]
      = Set()

      /** 
       * update `attrs`,
       * exercising the necessary init for the missing keys
       * 
       */
      def model_=
         (a: AttrAssignListAndChldList )
      : Unit
      = {
         // org.scalajs.dom.console.log(a.attribAssignmSet.toArray )
         initMissingKeys(a)
      }

      /** 
       * update `attrs`,
       * exercising the necessary init for the missing keys
       * 
       */
      def initMissingKeys
         (a: AttrAssignListAndChldList )
      : Unit
      = {
         ;

         val incomingSetAttrValuePairs
         = a.attribAssignmSet
         val incomingSetAttrs
         = incomingSetAttrValuePairs.map[LlAttr.ForValueLU[Nothing, Any] ]({ case e : AttrKeyAndValuePairByValue[v] => e.key } )

         def incomingSAttrValuePairForLlKey
            [v]
            (key: LlAttr.ForValue[v] )
         // : AttrKeyAndValuePairAny
         = {
            ;
            incomingSetAttrValuePairs.find(p => p.key.==(key ) ).get
            // TODO
            .asInstanceOf[AttrKeyAndValuePairByValue[v] ]
         }

         attrs_=(({
            ;

            val preExistingSpawnedAttrsMap
            = {
               attrs
               .toMapToPreSpawnedAttrs()
            }

            preExistingSpawnedAttrsMap

            .withDefaultedKeys1(incomingSetAttrs )({
               //
               case (key: LlAttr.ForValue[v] ) =>
               //

               incomingSAttrValuePairForLlKey(key)
               match {
                     //
                     case (keyValuePair: AttrKeyAndValuePairByValue[vl] ) =>
                        ;
                        keyValuePair
                        .runPrepConstructorUnconditionally()

                     //
               }
            })

            // TODO
            .tapEach({
               ;

               type _Pair = ([V] =>> (LlAttr.ForValue[V], ByLlAttrPreparedImpl[V] ) )

               { case e : `_Pair`[v] => {
                  ;

                  val kvPair
                  = incomingSAttrValuePairForLlKey(e._1 )

                  // given_Console_alt.info(e._1, kvPair.key, kvPair.value )

                  val newValue
                  = kvPair.asReselved.value

                  e._2
                  .:=(newValue )
               }}
            })

            .values.toSet
         }))
      }

      ;
   }

   extension (attrs: collection.immutable.Iterable[ByLlAttrPreparedImpl[?]] & collection.Set[?] ) {
      //

      @deprecated
      def toMapToPreSpawnedAttrs()
      = {
         ;
         attrs
         .map({ case e: ByLlAttrPreparedImpl[v] => PspwPair((e.k, e )) })
         .map[(LlAttr.ForValueLU[Nothing, Any ], ByLlAttrPreparedImpl[?] ) ](e => (e.toTuple2) )
         .toMap
      }

      //
   }

   ;
}

;

;

;




















val _ = {}
