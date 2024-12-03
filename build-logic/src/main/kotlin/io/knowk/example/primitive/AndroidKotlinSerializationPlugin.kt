package io.knowk.example.primitive

import io.knowk.example.ktx.implementation
import io.knowk.example.ktx.library
import io.knowk.example.ktx.libs
import io.knowk.example.ktx.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidKotlinSerializationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("kotlin-serialization").pluginId)
            }

            dependencies {
                implementation(libs.library("kotlinx-serialization-json"))
            }
        }
    }
}
