plugins {
    id("io.knowk.example.primitive.android.library")
    id("io.knowk.example.primitive.android.kotlin")
    id("io.knowk.example.primitive.android.kotlin.serialization")
    id("io.knowk.example.primitive.android.hilt")
}

android.namespace = "io.knowk.example.contract"
android.buildFeatures.resValues = true
