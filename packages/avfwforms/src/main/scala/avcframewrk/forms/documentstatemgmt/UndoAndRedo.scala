package avcframewrk.forms

package documentstatemgmt


















object UndoAndRedo
{
   ;

   object SpecialFpCcOps {
      ;

      ;

      ;

      type _Any
      = _Impl

      type _ForModelStateSetTExactly
         [Cc[+E ] <: _AnyCaseMdlState ]
      = _Impl { type OperatedMdlStateSetCc[+E] >: Cc[E] <: Cc[E] }

      type _ForModelStateSetTExtending
         [+Cc[+E ] <: _AnyCaseMdlState ]
      = _Impl { type OperatedMdlStateSetCc[+E] <: Cc[E] }

      ;

      type _AnyCaseMdlState
      >: Matchable
      <: Matchable

      ;

      protected
      trait _Impl
         //
      {
         ;

         type OperatedMdlStateSetCc
            [+E ]
         <: _AnyCaseMdlState

         extension [OperatedMdlSnapshot] (ss: OperatedMdlStateSetCc[OperatedMdlSnapshot] ) {
            //

            def presentlyState : OperatedMdlSnapshot

            def afterUndoBy()(using SpecialOutOfStackMode._Any) : OperatedMdlStateSetCc[OperatedMdlSnapshot ]
            def afterRedoBy()(using SpecialOutOfStackMode._Any) : OperatedMdlStateSetCc[OperatedMdlSnapshot ]
         }

         object SpecialOutOfStackMode {
            ;
            trait _Any {
               ;
               def failOrFallbackTo
                  [R](v: R )
               : R
            }
            ;
            implicit
            final
            lazy val lenientInstance
            : _Any
            = new _Any {
               ;
               def failOrFallbackTo
                  [R](v: R )
               : v.type
               = v
            }
            final
            lazy val failingInstance
            = new _Any with Selectable {
               ;
               def failOrFallbackTo
                  [R](v: R )
               : Nothing
               = {
                  throw new java.util.NoSuchElementException
               }
            }
         }

         def initiallyWith
            //
            [OperatedMdlSnapshot ]
            (initialHeadState: OperatedMdlSnapshot )
         : OperatedMdlStateSetCc[OperatedMdlSnapshot ]

         extension [OperatedMdlSnapshot] (ss: OperatedMdlStateSetCc[OperatedMdlSnapshot] ) {
            //

            def withClearedRedoStateSeq
               (newSeq: Seq[OperatedMdlSnapshot] )
            : OperatedMdlStateSetCc[OperatedMdlSnapshot]
         }

      }

      type _FiniteModeInstance
      = _FiniteModeImpl

      protected
      trait _FiniteModeImpl
      extends
      _Impl
      {
         ;

         extension [OperatedMdlSnapshot] (ss: OperatedMdlStateSetCc[OperatedMdlSnapshot ] ) {
            //
            def presentlyState : OperatedMdlSnapshot

            def  precedingStateHist : Seq[OperatedMdlSnapshot]
            def successiveStateHist : Seq[OperatedMdlSnapshot]
         }

         ;
      }

      type UndoAndPresentlyAndRedoPairBasedInstance
      = UndoAndPresentlyAndRedoPairImpl

      protected
      trait UndoAndPresentlyAndRedoPairImpl
      extends
      _Impl
      {
         ;

         type OperatedMdlStateSetCc[+E]
         <: (_AnyCaseMdlState, E, _AnyCaseMdlState )

         def initiallyWith
            [OperatedMdlSnapshot ]
            (initialHeadState: OperatedMdlSnapshot )
         : OperatedMdlStateSetCc[OperatedMdlSnapshot] & (_AnyCaseMdlState, initialHeadState.type, _AnyCaseMdlState )

         extension [OperatedMdlSnapshot] (presentlyHist: OperatedMdlStateSetCc[OperatedMdlSnapshot ] ) {
            //

            def withClearedRedoStateSeq
               (newSeq: Seq[OperatedMdlSnapshot] )
            : OperatedMdlStateSetCc[OperatedMdlSnapshot] & (presentlyHist._1.type, presentlyHist._2.type, _AnyCaseMdlState )
         }

         ;
      }

      @annotation.experimental
      given defaultInstance
         // [E <: _AnyCaseMdlState ]
      : (_FiniteModeImpl )
      = gv.forPairOfConstLl

      object gv {
         ;

         /** 
          * `forPairOfConstLl`
          * 
          * ```
          * (
          *   undoSeq: collection.immutable.List[E] ,
          *   presently: E,
          *   redoSeq: collection.immutable.List[E] ,
          * )
          * ```
          * 
          */
         given forPairOfConstLl
            //
         : _FiniteModeImpl with UndoAndPresentlyAndRedoPairImpl
         with {
            ;

            type OperatedMdlStateSetCc[+E]
            >: (List[E], E, List[E] )
            <: (List[E], E, List[E] )

            def initiallyWith
               [OperatedMdlSnapshot]
               (initialHeadState: OperatedMdlSnapshot )
            : OperatedMdlStateSetCc[OperatedMdlSnapshot] & (Nil.type, initialHeadState.type, Nil.type )
            = (Nil, initialHeadState, Nil )

            extension [OperatedMdlSnapshot] (presentlyHist: OperatedMdlStateSetCc[OperatedMdlSnapshot] ) {
               //

               def withClearedRedoStateSeq
                  (newSeq: Seq[OperatedMdlSnapshot] )
               : OperatedMdlStateSetCc[OperatedMdlSnapshot] & (presentlyHist._1.type, presentlyHist._2.type, List[OperatedMdlSnapshot] )
               = {
                  (presentlyHist._1, presentlyHist._2, newSeq.toList )
               }
            }

            extension [OperatedMdlSnapshot] (presentlyHist: OperatedMdlStateSetCc[OperatedMdlSnapshot] ) {
               //

               def presentlyState = presentlyHist._2
               def  precedingStateHist : List[OperatedMdlSnapshot ] = presentlyHist._1
               def successiveStateHist : List[OperatedMdlSnapshot ] = presentlyHist._3

               def afterUndoBy()(using fbm: SpecialOutOfStackMode._Any) = (    precedingStateHist, presentlyState ) match { case (s2 +: restS, s0 ) => (                   restS, s2, s0 +: successiveStateHist ) ; case _ => fbm.failOrFallbackTo(presentlyHist ) }
               def afterRedoBy()(using fbm: SpecialOutOfStackMode._Any) = (   successiveStateHist, presentlyState ) match { case (s2 +: restS, s0 ) => (s0 +: precedingStateHist, s2,                     restS ) ; case _ => fbm.failOrFallbackTo(presentlyHist ) }
            }
         }

      }

      ;
   }

   ;
}


















