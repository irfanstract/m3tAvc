package avcframewrk.forms

package templating

package ext.givmk

package impl

















;

import org.scalajs.dom

import com.raquo.laminar.{nodes as ln }

import laminar.api.L

/**
 * 
 * a var of `L.Var`, with lifted producer-side
 * 
 */
object XVerFlatteningVar
{
   ;

   def apply
      [V]
      (initialS: => L.Signal[V] )
   : (
      //
      AnyRef
      & L.Source[V ]
      & L.Sink[L.Signal[V] ]
   )
   = {
      ;

      val impl
      = L.Var[L.Signal[V] ](initialS )

      new
         AnyRef
         with L.Source[V ]
         with L.Sink[L.Signal[V] ]
      {
         export impl.toObserver
         val toObservable
         = impl.toObservable.flatten
      }
   }

   ;
}

;



















val _ = {}
