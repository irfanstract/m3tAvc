package avcframewrk.forms

package templating

package rendering



















/**
 * 
 * in case
 * the creation of a new peer would be unacceptably inefficient/expensive,
 * it'd be better to (simply) reuse the existing peer at the place
 * 
 */
object reconciliabilityC
{
   ;

   trait SpawnabilityNoArg[-Mdl, +R ]
   {
      ;

      extension (this1: Mdl)
         def spawn()
         : R

   }

   trait SpawnabilityA1[-Mdl, -A, +R ]
   {
      ;

      extension (this1: Mdl)
         def spawn(arg: A)
         : R

   }

   /**
    * in case
    * the creation of a new peer would be unacceptably inefficient/expensive,
    * it'd be better to (simply) reuse the existing peer at the place
    * 
    */
   trait Reconciliability[-Receiver, -Mdl, +R ]
   {
      ;

      extension (this1: Receiver)
         def model_=(newModel: Mdl )
         : R

   }

   final
   lazy val falliblyReconciliativeImplicits
   : fallibleReconciliativeImplicits.type
   = fallibleReconciliativeImplicits

   object fallibleReconciliativeImplicits
   {

      extension [
         ReceiverL,
         ReceiverU,
         Mdl,
         R <: Unit ,
      ]
         (this1: ReceiverU)
      {
         //

         /**
          * gracefully-fallible version of `Reconciliability`'s' `model_=`
          * 
          */
         transparent inline /* allow automatic narrowing to `Left[Unit]` if the receiver were clearly incompatible */
         def model_:=
            (newModel: Mdl )
            (using Reconciliability[ReceiverL, Mdl, R] )
            (using reflect.TypeTest[ReceiverU, ReceiverL])
         : Either[Unit, Unit]
         = {
            this1 match {
               case this1 : ReceiverL =>
                  this1.model_=(newModel )
                  Right(() )
               case _ =>
                  Left(() )
            }
         }

      }

      /* test */
      locally {
         ([I] => (receiver: AnyVal & I) => (IC : reflect.Typeable[I] ) ?=> (g: Reconciliability[AnyRef & I, Unit, Unit] /* an incompatible one */ ) ?=> {
            val r = receiver.model_:=(() )
         } )
      }

   } // fallibleReconciliativeImplicits$

   /**
    * simultaneous `SpawnabilityNoArg` and `Reconciliability`
    * 
    * the type `R` is only used for the "reconcile" methods -
    * `spawn`'s return-type has already been narrowed to `Spawned` so we can't make it `R`.
    * additionally,
    * it's possible to
    * further narrow `spawn`'s return-type by re-`extends`ing `SpawnabilityNoArg` with more-specific `R`
    * 
    */
   trait SpawnabilityAndReconciliabilityNoArg[-Mdl, Spawned, +R]
   extends
   AnyRef
   with SpawnabilityNoArg[Mdl, Spawned]
   with Reconciliability[Spawned, Mdl, R]
   {
      this : (
         AnyRef
      ) =>

      ;

      ;
   }

   ;
} // reconciliabilityC$















val _ = {}
