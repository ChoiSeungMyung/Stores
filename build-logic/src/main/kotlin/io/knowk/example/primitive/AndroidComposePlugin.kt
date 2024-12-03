package io.knowk.example.primitive

import io.knowk.example.ktx.android
import io.knowk.example.ktx.bundle
import io.knowk.example.ktx.implementation
import io.knowk.example.ktx.ksp
import io.knowk.example.ktx.library
import io.knowk.example.ktx.libs
import io.knowk.example.ktx.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("kotlin-compose").pluginId)
            }

            android {
                buildFeatures.compose = true
            }

            dependencies {
                implementation(libs.bundle("compose"))
                implementation(libs.bundle("compose-animation"))
                implementation(libs.bundle("compose-basic"))
                implementation(libs.bundle("compose-ui"))
                implementation(libs.bundle("compose-navigation"))
                implementation(libs.bundle("compose-lifecycle"))
                implementation(libs.library("androidx-hilt-navigation"))
                ksp(libs.library("androidx-hilt-compiler"))
            }
        }
    }
}
