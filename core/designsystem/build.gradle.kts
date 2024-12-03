plugins {
    id("io.knowk.example.primitive.android.library")
    id("io.knowk.example.primitive.android.kotlin")
    id("io.knowk.example.primitive.android.compose")
}

android.namespace = "io.knowk.example.core.designsystem"
android.buildFeatures.compose = true

dependencies {
    implementation(libs.bundles.compose.lifecycle)
}
