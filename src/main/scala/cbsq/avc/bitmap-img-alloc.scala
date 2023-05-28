package cbsq.avc











trait Acp[+Instance] {

   /* OH WHAT - THE FOLLOWING DEF ONLY MAKE TYPE-LVEL REF TO THE OBJ */
   import reflect.Selectable.reflectiveSelectable

   /**
    *
    * `allocate`
    * 
    * if `pixFmt.colorSpace` is not `props.colorSpace` then
    * a compile-time complaint will be raised
    *
    * @param resolution
    * @param colorSpace
    * @param pixFmt
    * 
    */
   def allocate(
      resolution: ((Int, Int)) ,

      colorSpace:  ColorChannelsFmt[ColorChannelsFmt.Properties1] ,

      pixFmt: (
         ([SpecificColorSpace1] =>> (

            PixelFmt {
               val colorSpace: SpecificColorSpace1 
            }
            
         ))[colorSpace.type]
      ) ,
      
   ): Instance
   
}












