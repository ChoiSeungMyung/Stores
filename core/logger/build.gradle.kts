plugins {
    id("io.knowk.example.primitive.android.library")
    id("io.knowk.example.primitive.android.kotlin")
    id("io.knowk.example.primitive.android.hilt")
}

android.namespace = "io.knowk.example.logger"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.core.contract)

    implementation(libs.timber)
}
