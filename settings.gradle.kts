enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
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
include(":libraries:reaction:library")
include(":libraries:viewmodel-factory:android-library")
include(":libraries:resource-provider:android-library")
include(":libraries:validator:android-library")

// Feature

include(":feature:pre-authorized-zone:splash:api")
include(":feature:pre-authorized-zone:splash:impl")
include(":feature:pre-authorized-zone:splash:res")
include(":feature:pre-authorized-zone:splash:screen")

include(":feature:pre-authorized-zone:authorization:api")
include(":feature:pre-authorized-zone:authorization:impl")
include(":feature:pre-authorized-zone:authorization:screen")
include(":feature:pre-authorized-zone:authorization:res")
include(":feature:pre-authorized-zone:authorization:widget")

// Data

include(":data:authorization:api")
include(":data:authorization:impl")

