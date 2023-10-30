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
         thisTc =>
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

         ;

         extension [OperatedMdlSnapshot ]
            (receiver: OperatedMdlStateSetCc[OperatedMdlSnapshot ] )
         {
            //

            transparent inline
            def afterRedoNTimes
               (n: Int )
               (using SpecialOutOfStackMode._Any)
            : OperatedMdlStateSetCc[OperatedMdlSnapshot ]
            = {
               ;
               type OperatedMdlStateSet
               >: OperatedMdlStateSetCc[OperatedMdlSnapshot ]
               <: OperatedMdlStateSetCc[OperatedMdlSnapshot ]
               ;
               IndexedSeq.fill[Int] (n.abs )(n.sign )
               .foldLeft[OperatedMdlStateSet] (receiver)({ case (e, dir ) => {
                  ;
                  dir match
                  case -1 => e.afterUndoBy()
                  case  1 => e.afterRedoBy()
                  case  0 => e
               } })
            }
         }

         /** necessary, for https://github.com/lampepfl/dotty/issues/18768 */
         implicit class `:%&:!Ops` [OperatedMdlSnapshot] (ss: OperatedMdlStateSetCc[OperatedMdlSnapshot] ) {
            ;
            /** return `thisTypeclass`. */
            def :%&:!!
            : thisTc.type
            = thisTc
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

         import com.github.plokhotnyuk.jsoniter_scala

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

            ;

            given epclJsonSer
               [E]
               (using jsoniter_scala.core.JsonValueCodec[E] )
            : jsoniter_scala.core.JsonValueCodec[OperatedMdlStateSetCc[E] ]
            = {
               ;
               jsoniter_scala.macros.JsonCodecMaker.make[(List[E], E, List[E] )]
            }

         }
         
         ;

         private
         object epclJsonSerDemo {
            ;

            import quoted.*

            transparent inline
            def main
            = ${ mainImpl() }

            def mainImpl
               //
               (using Quotes)
               ( )
            : Expr[String]
            = {
               Expr({
                  jsoniter_scala.core.writeToStringReentrant[forPairOfConstLl.OperatedMdlStateSetCc[_M] ] ((
                     (Nil, _M(degree = 1), Nil)
                  ))(using summon )
               })
            }

            case class _M(degree: Int)
            object _M {
               given jsoniter_scala.core.JsonValueCodec[_M]
               = jsoniter_scala.macros.JsonCodecMaker.make
            }

            // final
            // lazy val mainCached
            // = main

            ;
         }

      }

      ;
   }

   ;
}


















