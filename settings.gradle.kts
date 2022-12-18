enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ktcast"

include(":app")

// Core

include(":core:di:library")

include(":core:navigation:android-library")

include(":core:exceptions:library")

include(":core:ui-components:android-library")
include(":core:ui-components:res")

include(":core:mvi:android-library")
include(":core:mvi:android-utils")
include(":core:mvi:res")

include(":core:debug-helper:android-library")

include(":core:dialog:android-library")

// Common

include(":common:network:android-library")
include(":common:network:utils")

include(":common:persistence:database:android-library")

include(":common:persistence:secure-storage:android-library")

include(":common:logout:android-library")

// Libraries

include(":libraries:mapper:library")
include(":libraries:either:library")
include(":libraries:viewmodel-factory:android-library")
include(":libraries:resource-provider:android-library")
include(":libraries:validator:android-library")

// Feature

include(":feature:splash:api")
include(":feature:splash:impl")
include(":feature:splash:res")
include(":feature:splash:screen")

include(":feature:authorization:api")
include(":feature:authorization:impl")
include(":feature:authorization:screen")
include(":feature:authorization:res")
include(":feature:authorization:widget")

// Data

include(":data:authorization:api")
include(":data:authorization:impl")

include(":libraries:utils:core:android_library")
