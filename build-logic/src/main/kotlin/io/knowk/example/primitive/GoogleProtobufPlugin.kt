package io.knowk.example.primitive

import com.android.build.api.variant.AndroidComponentsExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import io.knowk.example.ktx.setupProtobuf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.extensions.stdlib.capitalized
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.tasks.AbstractKotlinCompileTool

class GoogleProtoBufPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.protobuf")
            }

            pluginManager.withPlugin("com.google.protobuf") {
                extensions.configure<LibraryAndroidComponentsExtension> {
                    configure(this)
                }
            }

            setupProtobuf()
        }
    }

    // https://github.com/google/dagger/issues/4051
    private fun Project.configure(
        extension: AndroidComponentsExtension<*, *, *>,
    ) {
        extension.onVariants { variant ->
            afterEvaluate {
                project.tasks.getByName("ksp" + variant.name.capitalized() + "Kotlin") {
                    val buildConfigTask =
                        project.tasks.getByName("generate${variant.name.capitalized()}Proto")
                            as com.google.protobuf.gradle.GenerateProtoTask
                    dependsOn(buildConfigTask)
                    (this as AbstractKotlinCompileTool<*>).setSource(buildConfigTask.outputBaseDir)
                }
            }
        }
    }
}
