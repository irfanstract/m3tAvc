


/* needs to be updated accordingly */
// export * from "./target/scala-3.3.1/mainsjs-for-js-fastopt/main.js"
export {} ;
(() => {
   ;
   const loadScriptFromUrl = (
      /** @type {(src: URL) => void } */
      function implLoadScriptFromUrl(src) {
         document.body.appendChild(document.createElement("script") ).src = src.href ;
      }
   );
   ;
   console.info("loading the app bundle via the Vite-specific 'new URL(... ...)' translation.") ;
   loadScriptFromUrl(new URL("./target/scala-3.3.1/scalajs-bundler/main/mainsjs-for-js-fastopt-bundle", import.meta.url ) ) ;
   // loadScriptFromUrl(new URL("./target/scala-3.3.1/scalajs-bundler/main/mainsjs-for-js-fastopt-library", import.meta.url ) ) ;
   // loadScriptFromUrl(new URL("./target/scala-3.3.1/scalajs-bundler/main/mainsjs-for-js-fastopt-loader", import.meta.url ) ) ;
   // loadScriptFromUrl(new URL("./target/scala-3.3.1/scalajs-bundler/main/mainsjs-for-js-fastopt", import.meta.url ) ) ;
})() ;
// export * from "./target/scala-3.3.1/scalajs-bundler/main/mainsjs-for-js-fastopt-bundle"



