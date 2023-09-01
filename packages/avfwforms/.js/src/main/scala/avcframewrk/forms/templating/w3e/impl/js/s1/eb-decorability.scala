package avcframewrk.forms

package templating

package w3e.impl.js

package s1

















trait EbDecorativityOf[OperandBase, -A ]
{
   ;

   extension (receiver: OperandBase)
      def withDecor(a: A )
      : OperandBase

   ;
}

// TODO
trait ELaminarQckCoreHtmlArticleDecorsExt
extends
   AnyRef
   /* with these items item merely listed in the self-type, the IDE/editor won't show any relevant "overrides super member" markers */
   // 
   /* a temporary treat necessary to prevent the compiler from hanging */
   with ELaminarQckCore
{
   this : (
      AnyRef
      with w3e.pre.Articles
      // with ELaminarQckCoreHtml
      with ELaminarQckCore
   ) =>
   ;

   import com.raquo.laminar.{nodes as ln}

   import org.scalajs.dom

   ;

   // TODO
   implicit def given_EbDecorativityOf_Article_Function
      [
         HL <: ln.ReactiveElement[HD & dom.Element],
         HD <: dom.Node ,
         T1 ,
      ]
      (using LaminarSpawnable[HL, HD] <:< Article )
      /* the `TypeTest`s */
      (using reflect.Typeable[HL ] )
      (using reflect.Typeable[LElemPlusPossibleData[ln.ReactiveHtmlElement[? <: dom.HTMLElement ] | ln.ReactiveSvgElement [? <: dom.SVGElement ] ] ] )
   : (
      EbDecorativityOf[
         //
         Article,
         (
            ([LEelemBasic] =>> ((operand: LEelemBasic ) => LEelemBasic ) )
            [HL ]
         ) ,
      ]
   )
   = {
      ;

      type XDecorator
      >: HL => HL
      <: HL => HL

      /**
       * a list of ops to be applied (in order), and
       * the operand .
       * 
       * @param operand the targeted `Article`
       * 
       */
      case class AugList(ops: ([E] =>> (List[E] | IndexedSeq[E] ) )[XDecorator], operand: Article )
      { export ops.{toList, toIndexedSeq} }

      val reconciliability
      = {
         ;

         SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
            //

            //
            spwImpl1 = (mdl: AugList) => {
               ;

               val sp0
               = { mdl.operand.spawn() } match { case e : HL => e : HL }

               mdl.toList

               .foldLeft[HL](sp0 )({

                  case (operand, dec) =>
                     ;

                     /** apply it to the operand */
                     dec.apply(operand)
                        // necessary. needs sync here
                        .avfwBackreferent_=(sp0.avfwBackreferent1 ) // TODO

               })
            }
            ,

            //
            reconcImpl1 = (this1: LElemPlusPossibleData[HL], mdl ) => {
               ;

               ;

               import fallibleReconciliativeImplicits.*

               this1.model_:=(mdl.operand )
               match { case r: Either[l1, res] => r }

               match { case r => {
                  r.fold(z => (z match { case () => throw new UnsupportedOperationException }) , e => e )
               } }
            }
            ,

            //
         )
      }

      new (
         //

         EbDecorativityOf[Article, XDecorator ]
      )
      {
         ;

         ;

         extension (receiver: Article) {
            //

            override
            def withDecor(addend: XDecorator )
            : Article
            = {
               ;

               ;

               val finalDList
               = {
                  receiver match {
                     case (`reconciliability`, l1 : AugList ) =>
                        l1
                        match { case l => {
                           l.copy(ops = l.ops :+ addend )
                        } }
                     case _ =>
                        AugList(ops = List() :+ addend, operand = receiver  )
                  }
               } : AugList

               ;

               summon[Conversion[SpiwmTwos[AugList, HL, Unit ], ? ] ]
               match { case conv => conv((reconciliability, finalDList ) ) }
               match { case a => a }
            }

         }

         ;
      }
   }

   ;

   ;
}

























val _ = {}
