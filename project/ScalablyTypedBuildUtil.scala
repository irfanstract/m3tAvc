













trait ScalablyTypedBuildUtil
{
  this : (
    Build.mainly.type
  ) =>
  ;

  import sbt._
  import sbt.Keys.{libraryDependencies }

  import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

  import sbtcrossproject.CrossProject
  import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType, _}

  import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

  import scalajscrossproject.ScalaJSCrossPlugin.autoImport._

  ;

  ;

  ;

  implicit class ScpScalablyTypedBuilderOps(receiver: CrossProject ) {
    //

    import org.scalablytyped.converter.plugin.*

    import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport.*
    import org.scalablytyped.converter.plugin.ScalablyTypedConverterGenSourcePlugin.autoImport.*
    import org.scalablytyped.converter.plugin.ScalablyTypedConverterPlugin.autoImport.*
    import org.scalablytyped.converter.plugin.ScalablyTypedConverterExternalNpmPlugin.autoImport.*

    def asScalablyTypedImportRepo()
    : CrossProject
    = {
      receiver
      // TODO
      .asLeafProjectWithNecessarySettings()
      .withScalablyTypedConv()
    }

    //
  }

  ;

  ;

  implicit class ScpScalablyTypedOps(receiver: CrossProject ) {
    //

    import org.scalablytyped.converter.plugin.*

    import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport.*
    import org.scalablytyped.converter.plugin.ScalablyTypedConverterGenSourcePlugin.autoImport.*
    import org.scalablytyped.converter.plugin.ScalablyTypedConverterPlugin.autoImport.*
    import org.scalablytyped.converter.plugin.ScalablyTypedConverterExternalNpmPlugin.autoImport.*

    def withScalablyTypedConv()
    = {
      receiver
      .platformsEnablePlugins(JSPlatform )(ScalablyTypedConverterPlugin )
      .jsSettings(
        //
        /* ERROR Unable to reload workspace: scalaJSModuleKind must be set to ModuleKind.CommonJSModule in projects where ScalaJSBundler plugin is enabled */
        scalaJSLinkerConfig ~= {

          //  import org.scalajs.linker.interface.ModuleSplitStyle

          _.withModuleKind(ModuleKind.CommonJSModule)
        },
      )
    }

    //
  }

  ;

  ;

  //
}













