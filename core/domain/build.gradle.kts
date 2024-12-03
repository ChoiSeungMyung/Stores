plugins {
    id("io.knowk.example.primitive.android.library")
    id("io.knowk.example.primitive.android.kotlin")
    id("io.knowk.example.primitive.android.hilt")
}

android.namespace = "io.knowk.example.core.domain"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.data)
}
