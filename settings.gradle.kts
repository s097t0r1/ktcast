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

// DI
include(":core:di:library")

// Navigation
include(":core:navigation:android-library")

// mvi
include(":core:mvi:android-library")
include(":core:mvi:android-utils")
include(":core:mvi:res")

include(":core:exceptions:library")
include(":common:network:androidLibrary")
include(":common:network:androidUtils")

include(":core:utils:mapper:library")
include(":core:utils:reaction:library")
include(":core:utils:viewmodel_factory:android_library")

include(":common:persistence:database:android-library")

include(":feature:pre_authorized_zone:splash:api")
include(":feature:pre_authorized_zone:splash:impl")
include(":feature:pre_authorized_zone:splash:res")
include(":feature:pre_authorized_zone:splash:compose-screens")

include(":core:ui-components:android-library")
include(":core:ui-components:res")

include(":feature:pre_authorized_zone:authorization:api")
include(":feature:pre_authorized_zone:authorization:impl")
include(":feature:pre_authorized_zone:authorization:screens")
include(":feature:pre_authorized_zone:authorization:res")
include(":core:utils:validator:android-library")

include(":core:utils:resource-provider:androidLibrary")
include(":feature:pre_authorized_zone:authorization:widget")

include(":common:persistence:secure_storage:androidLibrary")
