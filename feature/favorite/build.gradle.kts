import io.knowk.example.ktx.implementation

plugins {
    id("io.knowk.example.primitive.android.library")
    id("io.knowk.example.primitive.android.kotlin")
    id("io.knowk.example.primitive.android.hilt")
    id("io.knowk.example.primitive.android.compose")
}

android.namespace = "io.knowk.example.feature.favorite"
android.buildFeatures.compose = true

dependencies {
    implementation(libs.bundles.compose.lifecycle)
    implementation(libs.bundles.coil)
    implementation(libs.androidx.compose.material.icons.extended)
    implementation(projects.core.designsystem)
    implementation(projects.core.model)
    implementation(projects.core.domain)
}
