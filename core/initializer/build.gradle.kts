plugins {
    id("io.knowk.example.primitive.android.library")
    id("io.knowk.example.primitive.android.kotlin")
    id("io.knowk.example.primitive.android.hilt")
}

android.namespace = "io.knowk.example.initializer"
android.buildFeatures.resValues = false

dependencies {
    implementation(libs.androidx.startup)

    implementation(libs.timber)
}
