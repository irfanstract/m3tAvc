package avcframewrk.forms















object CompoundReleasable
{
   ;

   object _Ctx {
      type _Any
      = _Impl

      trait _Impl extends
      AnyRef
      {
         ;

         def allocate
            [R : util.Using.Releasable ]
            (r: => R )
         : R
      }
   }

   def existingRAsCloseable
      [R : util.Using.Releasable]
      (r: R )
   : java.io.Closeable
   = {
      r match
      case r: java.io.Closeable =>
         r
      case _ =>
         locally[java.io.Closeable] (() => implicitly[util.Using.Releasable[R] ].release(r) )
   }

   def apply
      (ev: _Ctx._Any => Unit )
   : java.io.Closeable
   = {
      ;

      var doClose : (() => Unit )
      = () => {}

      /** 
       * note that
       * the order of the de-alloc of aggregate
       * needs to be in-reverse
       * 
       */
      def prependDoClose
         (rAsCloseable : java.io.Closeable )
      : Unit
      = {
         ;
         doClose = ((doClose0 : (() => Unit ) ) => () => {
            try
               rAsCloseable.close()
            finally
               doClose0()
         } )(doClose)
      }

      ev({
         new _Ctx._Impl {
            //

            def allocate
               [R : util.Using.Releasable ]
               (r0: => R )
            = {
               val r = r0
               val rAsCloseable
               = existingRAsCloseable(r)
               prependDoClose(rAsCloseable)
               r
            }
         }
      })

      locally[java.io.Closeable ](() => doClose() )
   }

   ;
}


















