package io.knowk.example.primitive

import io.knowk.example.ktx.android
import io.knowk.example.ktx.implementation
import io.knowk.example.ktx.kotlinOptions
import io.knowk.example.ktx.library
import io.knowk.example.ktx.libs
import io.knowk.example.ktx.plugin
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidKotlinPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("kotlin-android").pluginId)
                apply(libs.plugin("kotlin-ksp").pluginId)
            }

            tasks.withType(KotlinCompile::class.java) {
                kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
            }

            android {
                kotlinOptions {
                    jvmTarget = JavaVersion.VERSION_17.toString()

                    freeCompilerArgs =
                        listOf(
                            "-opt-in=kotlin.RequiresOptIn",
                            "-Xcontext-receivers",
                        )
                }
            }

            dependencies {
                implementation(libs.library("kotlin-stdlib"))
                implementation(libs.library("kotlin-stdlib-jdk8"))
                implementation(libs.library("kotlin-reflection"))
                implementation(libs.library("kotlinx-coroutines-core"))
                implementation(libs.library("kotlinx-coroutines-android"))
            }
        }
    }
}
