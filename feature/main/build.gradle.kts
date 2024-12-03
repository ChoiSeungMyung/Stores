import io.knowk.example.ktx.implementation

plugins {
    id("io.knowk.example.primitive.android.library")
    id("io.knowk.example.primitive.android.kotlin")
    id("io.knowk.example.primitive.android.hilt")
    id("io.knowk.example.primitive.android.compose")
}

android.namespace = "io.knowk.example.feature.main"
android.buildFeatures.compose = true

dependencies {
    implementation(libs.bundles.compose.lifecycle)
    implementation(projects.core.model)
    implementation(projects.core.domain)
    implementation(projects.feature.home)
    implementation(projects.feature.favorite)
}
