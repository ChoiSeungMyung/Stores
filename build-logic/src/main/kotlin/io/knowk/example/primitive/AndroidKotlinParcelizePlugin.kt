package io.knowk.example.primitive

import io.knowk.example.ktx.libs
import io.knowk.example.ktx.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidKotlinParcelizePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugin("kotlin-parcelize").pluginId)
            }
        }
    }
}
