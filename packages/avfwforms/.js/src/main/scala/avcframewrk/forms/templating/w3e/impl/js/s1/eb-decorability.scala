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
      (using reflect.Typeable[HL ] )
      (using LaminarSpawnable[HL, HD] <:< Article )
   : (
      EbDecorativityOf[Article, (
         ([LEelemBasic] =>> ((target: LEelemBasic ) => LEelemBasic ) )
         [HL ]
      ) ]
   )
   = {
      ;

      type XDecorator
      >: HL => HL
      <: HL => HL

      /**
       * `AugList`
       * 
       * the appl is from top down - the common order(ing)
       * 
       * @param target the targeted `Article`
       * 
       */
      case class AugList(s: ([E] =>> (List[E] | IndexedSeq[E] ) )[XDecorator], target: Article )
      { export s.{toList, toIndexedSeq} }

      val reconciliability
      = {
         ;

         SpawnabilityAndReconciliabilityNoArg.bySpawnabilityAndReconciliabilityFnc(
            //
            spwImpl1 = (mdl: AugList) => {
               ;

               mdl.toList

               .foldLeft[HL]({ mdl.target.spawn() } match { case e : HL => e } )({

                  case (target, dec) =>
                     dec.apply(target)

               })
            }
            ,
            reconcImpl1 = (this1: HL, mdl ) => {
               ;

               ???

               ;

               ;
            }
            ,
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
                           l.copy(s = l.s :+ addend )
                        } }
                     case _ =>
                        AugList(s = List() :+ addend, target = receiver  )
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
