@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("io.knowk.example.primitive.android.application")
    id("io.knowk.example.primitive.android.kotlin")
    id("io.knowk.example.primitive.android.kotlin.serialization")
    id("io.knowk.example.primitive.android.kotlin.parcelize")
    id("io.knowk.example.primitive.android.hilt")
    id("io.knowk.example.primitive.android.compose")
    id("io.knowk.example.primitive.android.unitTest")
}

android {
    namespace = "io.knowk.example"

    buildFeatures {
        resValues = true
    }
}

dependencies {
    implementation(projects.core.contract)
    implementation(projects.presentation)

    implementation(libs.google.material)
}
