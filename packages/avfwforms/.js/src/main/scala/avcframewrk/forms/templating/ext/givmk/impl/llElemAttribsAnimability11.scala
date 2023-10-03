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

@annotation.experimental
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
      ScnAllocAndReconcileAndDistillH[Xsb1[SpawnedLl], LlKeyOrPropSetReconciliability1.AttrAssignListAndChldList, SpawnedLl ](
         //
         alloc = () => Xsb1(llTag = llTag ) ,
         reconcile = { case e => e._1.model_=(e._2) } ,
         distillLHandle = _.llE ,
      )
      // ???
   ))
}
object LLTR {
   ;

   ;

   import LlKeyOrPropSetReconciliability1.{*, given }

   def ByLlAttrPrepared
      [
         //
         V : reflect.Typeable ,
         // K <: LlAttr.ForValue[V] ,
      ]
      (k: LlAttr.ForValue[V], kp: AttrKeyAndValuePair[k.type, V ] )
      (e: ln.ReactiveElement[?] )
      (using LlPropAnimableSettibility.GivenDefaultSequencingKV[k.type, V] )
   = new ByLlAttrPreparedImpl[V ](k, kp)(e)

   protected
   class ByLlAttrPreparedImpl
      [
         //
         V : reflect.Typeable ,
         // K <: LlAttr.ForValue[V] ,
      ]
      (val k: LlAttr.ForValue[V], val kp: AttrKeyAndValuePair[k.type, V ] )
      // (e: )
      (e: ln.ReactiveElement[?] )
      (using LlPropAnimableSettibility.GivenDefaultSequencingKV[k.type, V] )
   {
      ;

      k.prepareOn(e)

      val asUpdatable
      = k.asAnimablySettibleProp()

      ;
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

      var attrs
      : Set[ByLlAttrPreparedImpl[? >: Nothing <: Any ] ]
      = Set()

      def model_=
         (a: AttrAssignListAndChldList )
      : Unit
      = {
         ;
         val incomingSetAttrs
         = a.attribAssignmSet
         ;
         attrs_=((
            attrs
            .map[(AttrKeyAndValuePair[?, ?], ByLlAttrPreparedImpl[?] ) ](e => (e.kp, e ) )
            .toMap
            // .filterKeys(_ => true )
            .filter(_ => true )
            .pipeLooseSelf(m => {
               for {
                  _ @ (k: AttrKeyAndValuePairByValue[vl] ) <- (Seq().:++(m.keySet).:++(incomingSetAttrs).toSet ) 
               }
               yield {
                  m.get(k)
                  .getOrElse[ByLlAttrPreparedImpl[?] ] ({
                     k
                     .pipeLooseSelf({
                        case k: AttrKeyAndValuePairByValue[v] =>
                           // TODO
                           given LlPropAnimableSettibility.GivenDefaultSequencingKV[k.key.type, v ]
                           = ???
                           new ByLlAttrPreparedImpl[v](k.key, k.asReselved)(llE)
                     })
                     .pipeLooseSelf(<:<.refl[ByLlAttrPreparedImpl[?] ] )
                  })
               }
            })
            .pipeLooseSelf(<:<.refl[Set[ByLlAttrPreparedImpl[? >: Nothing <: Any ] ] ] )
         ))
      }

      ;
   }

   ;
}

;

;

;




















val _ = {}
