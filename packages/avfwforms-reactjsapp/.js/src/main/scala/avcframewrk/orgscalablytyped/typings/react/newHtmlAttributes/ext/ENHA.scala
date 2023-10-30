package avcframewrk.orgscalablytyped.typings.react.newHtmlAttributes.ext












import typings.{std as dom }




package ENHA {
   ;

   ;

   /** 
    * of these three
    * 
    */
   object ofThree {
      ;

      /** 
       * `newHtmlAttributes`, defined as `new typings.react.mod.HTMLProps[T]()`
       * 
       */
      // inline
      def newHtmlAttributes[T]
      = typings.react.mod.HTMLProps.apply[T]()

      /** 
       * `newHtmlGenericAttribs`, defined as `newHtmlAttributes[dom.global.HTMLElement ]`
       * 
       */
      def newHtmlGenericAttribs
      = newHtmlAttributes[dom.global.HTMLElement ]

      /** 
       * `newHtmlButtonAttribs`, defined as `newHtmlAttributes[dom.HTMLButtonElement].setType("button")`
       * 
       */
      def newHtmlButtonAttribs
      = {
         ;
         newHtmlAttributes[dom.HTMLButtonElement]
         .setType("button")
      }

   }

   ;

   ;
}













