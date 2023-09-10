package avcframewrk.forms

package templating

package w3e.pre

















@deprecated
trait ArticlesViaLspwLppd
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
{
   this : (
      AnyRef
      // with w3e.pre.Articles
      // with w3e.pre.ArticlesViaLspw
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   protected
   type LElemPlusPossibleData[+HL]
   = LElemPlusPossibleData1[HL, Any]

   protected
   type LElemPlusPossibleData1[+HL, +D]

}

@deprecated
trait ArticlesViaLspwmt
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   with w3e.pre.Articles
   with w3e.pre.ArticlesViaLspw
   with w3e.pre.ArticlesViaLspwLppd
{
   this : (
      AnyRef
      with w3e.pre.Articles
      with w3e.pre.ArticlesViaLspw
      with w3e.pre.ArticlesViaLspwLppd
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   import avcframewrk.forms.templating.rendering.{SpiwmTwos, spawnThisSpiwmTwos, doSpiwmTwoReconciliationOf }

   import avcframewrk.forms.templating.rendering.reconciliabilityC.{*, given}

   ;

   /**
    * `LaminarSpawnable`
    * 
    * opaque.
    * we provided a `given` `Spawnability` instead
    * 
    */
   override
   protected
   opaque
   type LaminarSpawnable[
      +HL <: ln.ReactiveElement[HD & dom.Element],
      +HD <: dom.Node ,
   ]
   = (
      SpiwmTwos[
         Any,
         LElemPlusPossibleData[HL] @annotation.unchecked.uncheckedVariance,
         Unit ,
      ]
   )

   protected
   // opaque
   type LElemPlusPossibleData1[+HL, +D]
   >: HL @annotation.unchecked.uncheckedVariance
   <: HL

   /**
    * allows a to serve as impl of `LaminarSpawnable`
    * 
    * 'a pair of, a reconciler and the model'
    * 
    */
   given given_Conversion_SpiwmTwos_LaminarSpawnable[
      //
      HL <: ln.ReactiveElement[HD & dom.Element],
      HD <: dom.Node ,
      Mdl ,
   ]
   : (
      Conversion[
         SpiwmTwos[Mdl, LElemPlusPossibleData[HL] , Unit] ,
         LaminarSpawnable[HL , HD] ,
      ]
   )
   = identity[SpiwmTwos[Mdl, LElemPlusPossibleData[HL] , Unit] ] _

   /**
    * `SpawnabilityNoArg`
    * 
    */
   // transparent inline
   implicit def given_SpawnabilityNoArg_LaminarSpawnable_LElemPlusPossibleData
      [
         //
         HL <: ln.ReactiveElement[HD & dom.Element],
         HD <: dom.Node ,
         M ,
      ]
   : (
      SpawnabilityAndReconciliabilityNoArg[
         //
         LaminarSpawnable[HL, HD],
         LElemPlusPossibleData[HL],
         Unit ,
      ]
   )
   = {
      ;

      ;

      SpawnabilityAndReconciliabilityNoArg
      .bySpawnabilityAndReconciliabilityFnc(
         //

         spwImpl1 =
            (mdl: LaminarSpawnable[HL, HD]) =>
               mdl.spawnThisSpiwmTwos()

         ,

         reconcImpl1 =
            (this1, mdl) => {
               ;

               mdl.doSpiwmTwoReconciliationOf(this1 )
            }
         ,

      )
   }

   /** 
    * a conversion
    * to extract, from each `Article`,
    * a Tuple denoting 'a pair of a reconciler and the model'
    * 
    * note on the return-type (`SpiwmTwos` which `extends` `(?, ?)` ) ;
    * the 2nd elem is deliberately `Any` - that's how `SpiwmTwos` is defined
    * 
    * this is
    * effectively the inverse of the previously-listed conv to `Article`
    * 
    * not `given`/`implicit`,
    * to avoid serious compile-time infinite-looping
    * 
    */
   def artToSpiwmTwoConv
      //
      /** 
       * put in these evidence-ing(s) here,
       * necessary for
       * automatic specialisation depending on where the call to this materialiser is
       * 
       */
      [
         HL <: ln.ReactiveElement[HD & dom.Element],
         HD <: dom.Node ,
      ]
      (using Article <:< LaminarSpawnable[HL, HD] )
   : Conversion[LaminarSpawnable[HL, HD], SpiwmTwos[Any, HL, Unit]]
   = {
      def toConv[t1, t2](impl : <:<[t1, t2] ) = identity[Conversion[t1, t2] ](impl.apply _ )

      ({
         //

         [
            //

            Mdl
            // >: Any <: Any
            ,

            LS <:
               LaminarSpawnable[HL, HD]
            ,

            /* already (pre)defined above */
            // HL <: ln.ReactiveElement[HD & dom.Element],
            // HD <: dom.Node ,

            ReconcOpR
            // >: Unit <: Unit
            ,

            //
         ] =>
         (v: (
            <:<[
               LS ,
               (
                  SpiwmTwos[Mdl, HL, ReconcOpR]
               )
               ,
            ]
         ) ) =>
         {
            toConv
               (v)
         } 
      })
      .apply({
         val s
         = {
            summon[(
               <:<[
                  LaminarSpawnable[HL, HD] ,
                  (SpawnabilityAndReconciliabilityNoArg[?, ? <: LElemPlusPossibleData[ln.ReactiveElement[?] ] , ?] , Any ) ,
               ] 
            )]
         }
         s
      } )
   }

}

















val _ = {}
