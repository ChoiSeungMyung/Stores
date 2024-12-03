plugins {
    id("io.knowk.example.primitive.android.library")
    id("io.knowk.example.primitive.android.kotlin")
    id("io.knowk.example.primitive.android.hilt")
    id("io.knowk.example.primitive.android.compose")
}

android.namespace = "io.knowk.example"
android.buildFeatures.compose = true

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.bundles.lifecycle)

    implementation(projects.feature.main)
}
