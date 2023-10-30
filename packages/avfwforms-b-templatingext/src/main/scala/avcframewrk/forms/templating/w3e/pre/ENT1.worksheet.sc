
















trait ENT[R, +C <: R] {
   def empty: C
   def reprocess(i: R): R
}

val eSrc1: ENT[?, ?] = {
   type R
   >: 5
   <: 5
   new ENT[R, R]
   {
      def empty: R = 5
      def reprocess(i: R): R = 5
   }
}

val e1
= eSrc1.empty

trait ENT_ALT[R, +C <: R] {
   def empty: C
   extension (i: R) def asReprocessed : R
}

val eAltSrc1: ENT_ALT[?, ?] = {
   type R
   >: 5
   <: 5
   new ENT_ALT[R, R]
   {
      def empty: R = 5
      extension (i: R) def asReprocessed : R = i
   }
}

lazy val eAlts1 = {
   ;
   eAltSrc1.asReprocessed(??? )
}

val s : avcframewrk.forms.templating.rendering.reconciliabilityC.SpawnabilityAndReconciliabilityNoArg[?, ?, ?]
= {
   import avcframewrk.forms.templating.rendering.reconciliabilityC.{*, given}
   SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
      //
      spwImpl1 = (m: Unit) => {} ,
      reconcImpl1 = (_: Unit, _: Unit) => {} ,
   )
}

locally[() => s.type ](() => s )

val sm1
= s : avcframewrk.forms.templating.rendering.reconciliabilityC.SpawnabilityNoArg[?, ?]

() => {
   locally(() => sm1.spawn(???)( ) )
}

() => {
   locally(() => {
      val r = sm1.spawn(???)( )
      r
   } )
}

val sm11
= s : (
   avcframewrk.forms.templating.rendering.reconciliabilityC.SpawnabilityNoArg[?, ?]
   & avcframewrk.forms.templating.rendering.reconciliabilityC.Reconciliability[?, ?, ?]
)

() => {
   locally(() => sm11.spawn(???)( ) )
}

() => {
   locally(() => {
      sm11.spawn(???)( )
   } )
}

() => {
   locally(() => {
      Seq(sm11.spawn(???)( ))
      match { case r => r }
   } )
}

() => {
   locally(() => {
      sm11.spawn(???)( )
      match { case r => r }
   } )
}

() => {
   locally(() => {
      val r = sm11.spawn(???)( )
      r
   } )
}

() => { s.spawn(??? )( ) }

lazy val sE1
= {
   s.spawn(??? )( )
}

() => sE1

5

val sc : avcframewrk.forms.templating.rendering.reconciliabilityC.SpawnabilityAndReconciliabilityNoArg[?, ? >: Unit <: (Unit | 3 | 5 | Tuple.type | IndexedSeq[?] | List[?] ), ?]
= {
   import avcframewrk.forms.templating.rendering.reconciliabilityC.{*, given}
   SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
      //
      spwImpl1 = (m: Unit) => {} ,
      reconcImpl1 = (_: Unit, _: Unit) => {} ,
   )
}

lazy val scExample
= {
   sc.spawn(??? )()
}

() => scExample

5













