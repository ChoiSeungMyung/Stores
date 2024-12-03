package io.knowk.example.primitive

import io.knowk.example.ktx.android
import io.knowk.example.ktx.hilt
import io.knowk.example.ktx.implementation
import io.knowk.example.ktx.ksp
import io.knowk.example.ktx.library
import io.knowk.example.ktx.libs
import io.knowk.example.ktx.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("hilt").pluginId)
                apply(libs.plugin("kotlin-ksp").pluginId)
            }

            android {
                packagingOptions {
                    resources {
                        excludes += "META-INF/gradle/incremental.annotation.processors"
                    }
                }
            }

            dependencies {
                implementation(libs.library("hilt"))
                ksp(libs.library("hilt-compiler"))
                implementation(libs.library("kotlinx-ksp"))
            }

            hilt {
                enableAggregatingTask = true
            }
        }
    }
}
