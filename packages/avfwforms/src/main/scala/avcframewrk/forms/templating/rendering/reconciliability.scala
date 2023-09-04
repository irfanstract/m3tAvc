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
   } // SpawnabilityAndReconciliabilityNoArg

   object SpawnabilityAndReconciliabilityNoArg
   {
      ;

      /**
       * `bySpawnabilityAndReconciliability`
       * 
       * we
       * left this factory method here as a helper/util
       * 
       * very important
       * to write usages in a way avoiding the possibiliy of on-terminating givens/implicits search
       * 
       */
      def bySpawnabilityAndReconciliability
         [ButtonContentModel, SpawnedButton, U ]
         (
            //
            spwImpl : SpawnabilityNoArg[ButtonContentModel, SpawnedButton]
            ,
            reconcImpl : Reconciliability[SpawnedButton, ButtonContentModel, U ]
            ,
         )
      = {
         ;

         new
            AnyRef
            with SpawnabilityAndReconciliabilityNoArg[ButtonContentModel, SpawnedButton, U ]
         {
            ;

            export spwImpl.spawn
            export reconcImpl.model_=

            ;
         }
      } // bySpawnabilityAndReconciliability

      /**
       * `bySpawnabilityAndReconciliabilityFnc`
       * 
       * the "spawn" method(s)
       * will first run `spwImpl1` and then run, with the returned handle, `reconcImpl1`.
       * the "reconcile" method(s)
       * will solely run `reconcImpl1`
       * 
       * this treatment
       * avoids the need to first name the "reconcile" fnc in the user-land, as
       * now it will happen automatically
       * 
       */
      def bySpawnabilityAndReconciliabilityFnc
         [ButtonContentModel, SpawnedButton, U ]
         (
            //
            spwImpl1 : (mdl: ButtonContentModel ) => SpawnedButton
            ,
            reconcImpl1 : (SpawnedButton, ButtonContentModel) => U
            ,
         )
      = {
         ;

         val reconcImpl = {
            new Reconciliability[SpawnedButton, ButtonContentModel, U]
            {
               extension (this1: SpawnedButton)
                  def model_=(newModel: ButtonContentModel )
                  = {
                     reconcImpl1(this1, newModel )
                  }
            }
         } // reconcImpl$

         val spwImpl = {
            new SpawnabilityNoArg[ButtonContentModel, SpawnedButton ]
            {
               extension (mdl: ButtonContentModel)
                  def spawn()
                  = {
                     val this1 = spwImpl1(mdl)
                     reconcImpl1(this1, mdl)
                     this1
                  }
            }
         } // spwImpl$

         SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliability(
            //
            spwImpl = spwImpl
            ,
            reconcImpl = reconcImpl
            ,
         )
      } // bySpawnabilityAndReconciliabilityFnc

      ;
   } // SpawnabilityAndReconciliabilityNoArg$

   ;
} // reconciliabilityC$















val _ = {}
