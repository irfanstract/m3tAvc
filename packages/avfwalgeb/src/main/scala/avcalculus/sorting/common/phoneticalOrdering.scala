package avcalculus.sorting.common
















;

import avcalg.plsAndTlsAsImplicit.given_plsAndTls

import scala.util.matching.Regex

extension (s: String)
   def codePointsAsSeq
   : IndexedSeq[? <: Int ]
   = {
      import language.unsafeNulls
      s.codePoints().toArray().toIndexedSeq
   }

;

val commonPhoneticalOrdering
= {
   ;

   import language.unsafeNulls

   val lettersPrio
   = {
      ;

      /* TODO: handle the rest of Latin-Script Code-Page */
      "uwmbpvfoqkgahxelrntdcsyijz"
      .grouped(1).toIndexedSeq
   }

   Ordering.by(({
      ;

      ;

      ((nm: String) => (Numeric[Double].parseString(nm ).getOrElse[Double](Double.NaN ) *: (
         //

         nm.toLowerCase(java.util.Locale.ROOT )

         .pipeLooseSelf(nm => {
            val delimiter = "-"
            nm
            .replaceAll((
               Nil
               .prepended("[\\S\\s]" )
               .prepended("[cq][uoa]")
               .prepended("ch|c(?=[ei])")
               .mkString("|")
            ), "$0" + Regex.quoteReplacement(delimiter ) ).split(delimiter).toIndexedSeq
         } )

         .pipeLooseSelf(str => {
            str
            .map(s => (s *: (s.grouped(1).toIndexedSeq ) *: EmptyTuple ) match {
               //

               case s *: (
                  ("c" | "q") +: (s1 @ ("u" | "o" | "a" ) ) +: _
               ) *: _ =>
                  "k" + s1

               case _ *: ("c" +: ("h") +: _ ) *: _ =>
                  "s"

               case s *: _ =>
                  s

               //
            })
         })

         .pipeLooseSelf(letters => (
            //

            lettersPrio
            .indexOf({
               letters.apply(0)
               .take(1)
            })

            .&(Int.MaxValue )
         ))

         //
      ) *: nm *: EmptyTuple ) )
   }))
}













