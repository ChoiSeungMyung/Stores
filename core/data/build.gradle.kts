import io.knowk.example.ktx.implementation

plugins {
    id("io.knowk.example.primitive.android.library")
    id("io.knowk.example.primitive.android.kotlin")
    id("io.knowk.example.primitive.android.hilt")
}

android.namespace = "io.knowk.example.core.data"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.database)
    implementation(projects.core.network)

    implementation(libs.androidx.room)
    implementation(libs.androidx.room.ktx)
}
