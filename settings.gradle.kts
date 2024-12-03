pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "knowk"
include(":app")
include(":core:contract")
include(":core:data")
include(":core:database")
include(":core:designsystem")
include(":core:domain")
include(":core:initializer")
include(":core:logger")
include(":core:model")
include(":core:network")
include(":presentation")
include(":feature:main")
include(":feature:home")
include(":feature:favorite")
