// package avcframewrk.forms.templating.rendering.virtualdoms.diffing.engines

package avcframewrk.forms

package templating
package rendering

package virtualdoms
package diffing
package engines



















object c1
{
   ;

   // trait SpawnabilityOpModels[-Mdl]
   // { type Model >: Mdl <: Mdl }

   trait SpawnabilityNoArg[-Mdl, +R ]
   {
      ;

      // @deprecated
      type Model
      >: Mdl @annotation.unchecked.uncheckedVariance
      <: Mdl @annotation.unchecked.uncheckedVariance

      extension (this1: Model)
         def spawn()
         : Spawned

      @deprecated
      type Spawned
      >: R @annotation.unchecked.uncheckedVariance
      <: R @annotation.unchecked.uncheckedVariance

   }

   trait SpawnabilityA1[-Mdl, -A, +R ]
   {
      ;

      // @deprecated
      type Model
      >: Mdl @annotation.unchecked.uncheckedVariance
      <: Mdl @annotation.unchecked.uncheckedVariance

      extension (this1: Model)
         def spawn(arg: A)
         : R

      ;
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

      type Reconcilee
      >: Receiver @annotation.unchecked.uncheckedVariance
      <: Receiver @annotation.unchecked.uncheckedVariance

      extension (this1: Reconcilee )
         def model_=(newModel: Mdl )
         : R

      @deprecated
      type ReconciliativeStat
      >: R @annotation.unchecked.uncheckedVariance
      <: R @annotation.unchecked.uncheckedVariance

      ;
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
                     System.out.nn.flush()
                     try c1Wgc.impl.apply((this1, newModel), reconcImpl1(this1, newModel ) )
                     finally System.out.nn.flush()
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

      extension [HL, MdAfter, UOpR] (spawnerOriginal: SpawnabilityAndReconciliabilityNoArg[MdAfter, HL, UOpR ] ) {
         //

         /**
          * pre-`map`-ed version of the `SpawnabilityAndReconciliabilityNoArg`,
          * very much what `Function1#compose` and `com.raquo.airstream.Observer#contraMap` does
          * 
          */
         def compose
            [MdPre]
            (f: MdPre => MdAfter )
         : SpawnabilityAndReconciliabilityNoArg[MdPre, HL, UOpR]
         = {

            val adaptMdlAsNecessary
            : f.type
            = f

            SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
               //
               spwImpl1 = (mdl: MdPre) => (
                  mdl
                  match { case mdl => adaptMdlAsNecessary(mdl) }
                  match { case mdl => spawnerOriginal.spawn(mdl)( ) }
               )
               ,
               reconcImpl1 = (spawnedThis, mdl) => (
                  mdl
                  match { case mdl => adaptMdlAsNecessary(mdl) }
                  match { case mdl => spawnerOriginal.model_=(spawnedThis )(mdl ) } 
               )
               ,
            )
         }

         //
      } // extension compose

      extension [HL, Md, UOpR] (spawnerOriginal: SpawnabilityAndReconciliabilityNoArg[Md, HL, UOpR ] ) {
         //

         /**
          * 
          * with post-spawn intercept, possibly changing the return-value -
          * `reconcile` won't run the callback .
          * 
          */
         def withAfterSpawnIntercept
            [HLAfter <: HL ]
            (doPostSpw1: (thisSpawned: HL, mdl: Md ) => HLAfter )
         : SpawnabilityAndReconciliabilityNoArg[Md, HLAfter, UOpR]
         = {
            ;

            SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
               //
               spwImpl1 = (mdl: Md) => (
                  mdl
                  match { case mdl => spawnerOriginal.spawn(mdl)( ) }
                  match { case sp => doPostSpw1(sp, mdl) }
               )
               ,
               reconcImpl1 = (spawnedThis: HLAfter, mdl) => (
                  mdl
                  match { case mdl => spawnerOriginal.model_=(spawnedThis )(mdl ) } 
               )
               ,
            )
         }

         def withAfterReconcileIntercept
            [UOpRNew <: UOpR ]
            (doPostSpw1: (receiver: HL, newMdl: Md, c0: UOpR ) => UOpRNew )
            (using util.NotGiven[Any <:< UOpRNew ] )
         : SpawnabilityAndReconciliabilityNoArg[Md, HL, UOpRNew ]
         = {
            ;

            ;

            SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
               //
               spwImpl1 = (mdl: Md) => (
                  mdl
                  match { case mdl => spawnerOriginal.spawn(mdl)( ) }
               )
               ,
               reconcImpl1 = (spawnedThis, mdl) => (
                  mdl
                  match { case mdl => spawnerOriginal.model_=(spawnedThis )(mdl ) }
                  match { case r => doPostSpw1(spawnedThis, mdl, r ) }
               )
               ,
            )
         }

         //
      }

      extension [HL, Md, UOpR] (spawnerOriginal: SpawnabilityAndReconciliabilityNoArg[Md, HL, UOpR ] ) {
         //

         //

         /** 
          * in `Tuple2` form, as
          * otherwise there'd be no way to get a type which e
          * 
          */
         def asTypeTupelified
         = {
            spawnerOriginal.asTypeTupelifiedImpl()
         }

         def asTypeTupelifiedImpl
            ( )
         = {
            ;
            val tc
               = Tuple.asInstanceOf[{ type Reconcilee = HL }]
            (tc, spawnerOriginal )
               : (tc.type, Any ) { val _2 : SpawnabilityAndReconciliabilityNoArg[Md, _1.Reconcilee, UOpR ] }
         }

         //
      }

      ;
   } // SpawnabilityAndReconciliabilityNoArg$

   ;
} // c1$

object c1Wgc {
   var impl
   : [E] => (ctx: Product, impl: DummyImplicit ?=> E ) => E
   = [E] => (p: Product, c: DummyImplicit ?=> E ) => c
}















val _ = {}
