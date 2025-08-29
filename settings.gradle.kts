rootProject.name = "Ifound"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()


    }
}
include(":core:common")
include(":core:data")
include(":core:domain")
include(":core:navigation")
include(":core:ui")
include(":composeApp")
include(":feature:appointment")
include(":feature:recover_password")
include(":feature:sign")
include(":feature:stores")
