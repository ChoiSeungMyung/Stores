plugins {
    id("io.knowk.example.primitive.android.library")
    id("io.knowk.example.primitive.android.kotlin")
    id("io.knowk.example.primitive.android.kotlin.serialization")
    id("io.knowk.example.primitive.android.hilt")
}

android.namespace = "io.knowk.example.core.network"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.core.contract)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)

    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.serialization)

    implementation(libs.timber)
}
