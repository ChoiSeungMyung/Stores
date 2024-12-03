package io.knowk.example.primitive

import io.knowk.example.internal.proguardPath
import io.knowk.example.internal.release
import io.knowk.example.ktx.android
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidProguardPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            android {
                buildTypes {
                    release {
                        isMinifyEnabled = true
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
                        proguardPath("$projectDir/proguard")
                    }
                }
            }
        }
    }
}
