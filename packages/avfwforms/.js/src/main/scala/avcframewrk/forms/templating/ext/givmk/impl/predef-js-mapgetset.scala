package avcframewrk.forms

package templating

package ext.givmk

package impl

















;

import scalajs.js

def newJsMap
   [K, V]
= {
   ;
   new js.Map[K, V]()
}

// TODO
def newJsWeakMap
   [K, V]
= {
   ;
   // new js.Function("return new WeakMap() ;").call(js.undefined )
   // .asInstanceOf[js.Map[K, V] ]
   new js.Map[K, V]()
}

;



















val _ = {}