package avcframewrk.forms

package templating

package reactjs













import scalajs.js

opaque type KS
<: Any
= AnyRef
object KS
{
   ;

   import language.dynamics

   ;

   ;

   import e_ks.*

   ;

   object slToExprValueOfGvns {
      ;

      import compiletime.*
      import quoted.*

      @deprecated
      given picklingInstance[T : ValueOf : Type ]
      : ToExpr[T]
      with {
         def apply(t: T)(using Quotes )
         = {
            import quotes.reflect.*
            '{
               given tSinglecy
               : ValueOf[T]
               = ${
                  Expr.summon[ValueOf[T] ]
                  .getOrElse(report.ksErrorAndAbort("cannot re-resolve the ValueOf[T]") )
               }
               valueOf[T]
            }
         }
      }

      @deprecated
      // transparent
      inline
      given unpicklingInstance[T ]
      : FromExpr[T]
      = {
         ;
         val r
         = summonFrom({ case e : ValueOf[T] => Some(e) ; case _ => None })
         new FromExpr[T]
         {
            def unapply(t: Expr[T] )(using quoted.Quotes )
            = for ( r1 <- r ) yield {
               given r1.type = r1
               valueOf[T]
            }
         }
      }

      object tvoImplicits {
         ;

         ;

         given vwOfT[T : Type ] (using Quotes )
         : ValueOf[T]
         = {
            import quotes.reflect.*
            ( for (value <- Type.valueOfConstant[T] ) yield ValueOf(value ) )
            .getOrElse(report.ksErrorAndAbort(s"no Type.valueOfConstant[T]. \neligible types include (... ...) ") )
         }

         ;
      }

   }

   implicit class Sl(receiver: KS )
   extends
   AnyRef
   // with Selectable
   with Dynamic
   {
      ;

      import slToExprValueOfGvns.{*, given }

      transparent
      inline
      def applyDynamicNamed
         //
         [
            // C <: _ElementConstructor ,
            T1 ,
            implS <: (
               Singleton &
               KS._Impl._Any
            ) ,
         ]
         (using implManifest: _ImplManifest[implS] )
         (using impl: implManifest.value.type = implManifest.value )
         (cls: impl._ElementConstructor )
         (inline propSeq: (String, ReactPropValueAny )* )
      = ${sd.importable.mroDynamicRjsElementImpl[impl.type, implS ] ('{ impl }) (clsExpr = '{ cls } )('propSeq ) }

      transparent
      inline
      def applyDynamic
         //
         [
            // C <: _ElementConstructor ,
            T1 ,
            implS <: (
               Singleton &
               KS._Impl._Any
            ) ,
         ]
         (using implManifest: _ImplManifest[implS] )
         (using impl: implManifest.value.type = implManifest.value )
         (cls: impl._ElementConstructor )
         (inline children: ReactPropValueAny* )
      = ${sd.importable.mroDynamicRjsElementAltImpl[impl.type, implS ] ('{ impl }) (clsExpr = '{ cls } )('children ) }

      ;
   }

   /** 
    * if found,
    * legal
    * 
    */
   class Voibility[-C, -N <: Int ]

   /** 
    * the way the multi-staging happens to be implemented,
    * it becomes impossible to directly pass the impl directly .
    * sadly macro(s) were disallowed to take ctx-bound(s) either .
    * hence the need to do this
    * 
    */
   case class _ImplManifest
      [+C <: _Impl._Any & Singleton ]
      (value : C )

   /** 
    * instances each
    * provide the full impl, impl of those `applyDynamicNamed` and `applyDynamic` methods .
    * note --
    * cannot directly run instance methods in the top-level splice (ie the `${...}s`) in macro(s), so
    * needs a helper below, see below
    * 
    */
   object _Impl {
      ;

      type _Any
      = Impl[?]

      class Impl
         [C <: _ImplImpl.Impl & Singleton ]
         (using val ksDefaultImplImpl : C )
      extends
      AnyRef with ImplCtxsAndThereofTypeReexports
      {
         ;

         ;

         import slToExprValueOfGvns.{*, given }

         ;

         def mroDynamicRjsElementAltImpl
            //
            [
               C <: _ElementConstructor
               : quoted.Type
               ,
            ]
            (clsExpr: quoted.Expr[C] )
            (e0: quoted.Expr[Seq[(_DataAny ) ] ] )
            (using quoted.Quotes )
            (using quoted.Type[_DataAny] )
         = {
            ;

            val e = ksImplUtil.plcPackQuotedVarargs(e0)

            mroDynamicRjsElementImpl1(clsExpr = clsExpr )({
               ;

               '{ ${ e }.map(("", _ ) ) }
            })
         }

         def mroDynamicRjsElementImpl
            //
            [
               C <: _ElementConstructor
               : quoted.Type
               ,
            ]
            (clsExpr: quoted.Expr[C] )
            (e0: quoted.Expr[Seq[(String, _DataAny ) ] ] )
            (using quoted.Quotes )
            (using quoted.Type[_DataAny] )
         = {
            ;

            val e = ksImplUtil.plcPackQuotedVarargs(e0)

            mroDynamicRjsElementImpl1(clsExpr = clsExpr )({
               ;

               propKvPairSeqCheckedImpl(clsExpr = clsExpr )(e)
            })
         }

         export ksDefaultImplImpl.{
            mroDynamicRjsElementImpl1 ,
            propKvPairSeqCheckedImpl ,
         }

         @annotation.experimental
         private[forms]
         def e3(e: _ElementConstructor )
         : ksDefaultImplImpl._ElementConstructor
         = e

         ;
      }

      protected
      trait ImplCtxsAndThereofTypeReexports
      {
         ;

         val ksDefaultImplImpl : _ImplImpl.Impl

         export ksDefaultImplImpl.{
            _DataAny ,
            _ElementConstructor ,
         }

         ;
      }

      ;
   }

   /** 
    * a helper to
    * summon instances of the impl-ref type, and then invoke the selected method.
    * this is necessary as
    * the compiler restricts macros away from calling non-static methods
    * 
    */
   object sd {
      ;

      ;

      import compiletime.*
      import quoted.*

      ;

      extension [
         I <: I0 & Singleton,
         I0 <: (KS._Impl._Any & Singleton ) ,
      ] (implRef: Expr[I] )
         (using Type[I] )
         (using Type[I0] )
         // (using ugh: implRef.type = implRef )
         (using Quotes )
      {
         export implAk.*

         private
         def implAk : _IReExportsFrom[I]
         = {
            import quotes.reflect.*
            given Type[I]
            = {
               Type.of[I0]
               .pipeLooseSelf({
                  e => {
                     e
                  }
               })
               .asInstanceOf[Type[I] ]
            }
            (for {
               impl <- {
                  None
                  .orElse(Type.valueOfConstant[I] )
                  .orElse({
                     for {
                        case TermRef(prefixT, name) <- Some(TypeRepr.of[I] )
                        // prefixObj <- Type.valueOfConstant(using prefixT.asType.asInstanceOf[Type[? <: Any ] ] )
                        // _ <- Option.when(prefixT.sym) {}
                        cS <- prefixT.classSymbol
                        r <- {
                           ;

                           // ;
                           // report
                           // .ksErrorAndAbort(s"[KS] TermRef(${prefixT }, '$name' ) -> (in ${cS.fullName } ) ; ", implRef )
                           /** reflection is unavailable on SJS .. hope that the SJS compiler don't pick this LOC up */
                           ({
                              import language.unsafeNulls
                              for {
                                 r1 <- {
                                    ;

                                    // java.lang.invoke.MethodHandles.lookup()
                                    // .in(java.lang.Class.forName(cS.fullName ) )
                                    java.lang.Class.forName({
                                       cS.fullName
                                       .replace("-", "$minus")
                                    })
                                    .getFields()
                                    .find(_.getName().startsWith("MODUL") )
                                    .map(_.get(null ) )
                                 }
                              }
                              yield {
                                 ;

                                 r1
                                 .pipeLooseSelf(e => e.getClass().getMethod(name).invoke(e) )
                                 .asInstanceOf[I]
                              }
                           })
                        }
                     }
                     yield {
                        r
                     }
                  } )
               } : Option[I]
            } yield _IReExportsFrom(impl) )
            .getOrElse({
               report
               .ksErrorAndAbort(s"cannot re-summon (in spliceOwner: ${Symbol.spliceOwner.fullName } ): ${Type.show[I] } ; ", implRef )
            })
         }
      }

      case class _IReExportsFrom
         [+I <: (KS._Impl._Any & Singleton )]
         (impl: I )
      {

         /** 
          * cannot safely base the `export` directly on/at `impl`, as
          * that resulted in the types approx-ed to `?`.
          * instead,
          * the `export` needs to be "based on a `val` whose 'underlying type' is not a(other) wildcard-type"
          * 
          */
         val implProxy
         : impl.type
         = impl

         export implProxy.{*, given}

      }

      /** 
       * interestingly,
       * we still need another level of indirection,
       * like this one
       * 
       */
      object importable {
         export sd.{*, given}
      }

      ;
   }

   /** 
    * instances each
    * does exactly these things
    * - specialise `_ElementConstructor` and `_Element` and `_ElementFromCls` and `_DataAny`
    * - provide impl for `propKvPairSeqCheckedImpl` (validation of the props-list)
    * - provide impl for `mroDynamicRjsElementImpl1` (translated the pre-validated list-of-props, into `_Element` )
    * 
    */
   object _ImplImpl {
      ;

      trait Impl
      {
         ;

         ;

         type _ElementConstructor

         // TODO
         type _Element
         >: _DataAny & ReactElement.FromCls[Any]
         <: _DataAny & ReactElement.FromCls[Any]

         // TODO
         type _ElementFromCls[+C]
         >: _Element & ReactElement.FromCls[C]
         <: _Element & ReactElement.FromCls[C]

         type _DataAny
         // TODO remove this pre-bounding
         >: ReactPropValueAny
         <: ReactPropValueAny

         def mroDynamicRjsElementImpl1
            //
            [
               C <: _ElementConstructor
               : quoted.Type
               ,
            ]
            (clsExpr: quoted.Expr[C] )
            (  e1: quoted.Expr[Seq[(String, _DataAny ) ] ] )
            (using quoted.Quotes )
         : quoted.Expr[_ElementFromCls[C] ]

         def propKvPairSeqCheckedImpl
            //
            (clsExpr: (
               // quoted.Expr[? >: _ElementConstructor <: Any]
               quoted.Expr[? <: Any]
            ) )
            (e: quoted.Expr[Seq[(String, _DataAny ) ] ] )
            (using quoted.Quotes )
         : quoted.Expr[Seq[(String, _DataAny ) ] ]

         ;
      }

      ;
   }

}

export KS.{Sl as KSAsSelectableImpl }













val _ = {}
