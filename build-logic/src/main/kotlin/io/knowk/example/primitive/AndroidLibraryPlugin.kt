package io.knowk.example.primitive

import io.knowk.example.ktx.androidLibrary
import io.knowk.example.ktx.setupAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }

            androidLibrary {
                setupAndroid()

                buildFeatures {
                    buildConfig = false
                }

                lint {
                    checkReleaseBuilds = false
                    abortOnError = false
                }
            }
        }
    }
}
