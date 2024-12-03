package io.knowk.example.primitive

import io.knowk.example.internal.Dimension
import io.knowk.example.internal.Flavors
import io.knowk.example.internal.Version
import io.knowk.example.internal.debug
import io.knowk.example.internal.proguardPath
import io.knowk.example.ktx.androidApplication
import io.knowk.example.ktx.libs
import io.knowk.example.ktx.plugin
import io.knowk.example.ktx.setupAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply(libs.plugin("hilt").pluginId)
            }

            androidApplication {
                setupAndroid()

                defaultConfig {
                    applicationId = "io.knowk.example"
                    versionCode = Version.version_code
                    versionName = Version.version_name
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    vectorDrawables.useSupportLibrary = true
                }

                bundle {
                    language {
                        enableSplit = false
                    }
                }

                signingConfigs {
                    debug {
                        storeFile = file("$rootDir/settings/debug.keystore")
                    }
                }

                buildTypes {
                    debug
                    release {
                        isMinifyEnabled = true
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
                        proguardPath("$rootDir/app/proguard")
                    }
                }

                flavorDimensions.add(Dimension.VERSION)
                productFlavors {
                    create(Flavors.DEV) { proguardFile("debug/proguard-debug.pro") }
                    create(Flavors.STAGING)
                    create(Flavors.PRODUCTION)

                    forEach { flavor ->
                        with(flavor) {
                            dimension = Dimension.VERSION

                            if (name != Flavors.PRODUCTION) {
                                applicationIdSuffix = name
                            } else {
                                versionName = Version.production_version_name
                            }
                        }
                    }
                }

                lint {
                    checkReleaseBuilds = false
                    abortOnError = false
                }
            }
        }
    }
}
