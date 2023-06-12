package avcframewrk.forms.impl.javaswing















object abstractActionFactory {

   import avcframewrk.util.forms.pure.*

   import language.unsafeNulls

   // given lcafP
   // 
   implicit 
   lazy val lcafP : (
      // LabelledCallbackButtonFactory[XLabel, XF , javax.swing.Action ]
      ([T[-_ >: PartialFunction[Any, Nothing]] ] =>> (
         // T[XF]
         // & 
         T[PartialFunction[Any, Unit] ]
         // & T[PartialFunction[Any, Boolean] ] 

      ) )[[F >: PartialFunction[Any, Nothing] ] =>> LabelledCallbackButtonFactory[XLabel, F , javax.swing.Action ] ]
   ) = identity[LabelledCallbackButtonFactory[XLabel, XF | PfUnitOrBoolean[Any] , javax.swing.Action ] ] {

      (label, callback) => {

         val runCallback = {
            callback
         }

         val a = {
            identity[javax.swing.AbstractAction](e => {

               // TODO
               callback(e)
            } )
         }

         val (name, icon) = {

            getNameAndIcon(label = label )

         } : (String | Null, javax.swing.Icon | Null )

         a putValue(javax.swing.Action.NAME, name )
         a putValue(javax.swing.Action.SMALL_ICON, icon )

         a
      }
   }

   type XLabel
      >: String | javax.swing.Icon | %@!
      <: String | javax.swing.Icon | %@!

   case class %@!(name: String, icon: javax.swing.Icon )

   def getNameAndIcon(label : XLabel) : (String | Null, javax.swing.Icon | Null ) = {

            label match {

               case l : String =>
                  (l, null )

               case l : javax.swing.Icon =>
                  (null, l )

               case l : %@! =>
                  (l.name, l.icon )

            }
   }

   type XF
      >: XFallibleCallback[Any   ]
      <: XFallibleCallback[AnyRef]

}

type XFallibleCallback[-P]
   >: PfUnitOrBoolean[P ]
   <: PfUnitOrBoolean[P ]

type PfUnitOrBoolean[-P]
   = PartialFunction[P, Unit] | PartialFunction[P, Boolean]

type OpaqueParamPf[+R] = (
   PartialFunction[Any, R ]
   
)




























