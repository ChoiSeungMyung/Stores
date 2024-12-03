import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "io.knowk.example.buildlogic"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.android.gradlePlugin)
    implementation(libs.hilt.android.gradlePlugin)
    implementation(libs.protobuf.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "io.knowk.example.primitive.android.application"
            implementationClass = "io.knowk.example.primitive.AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "io.knowk.example.primitive.android.library"
            implementationClass = "io.knowk.example.primitive.AndroidLibraryPlugin"
        }
        register("androidProguard") {
            id = "io.knowk.example.primitive.android.proguard"
            implementationClass = "io.knowk.example.primitive.AndroidProguardPlugin"
        }
        register("androidUnitTest") {
            id = "io.knowk.example.primitive.android.unitTest"
            implementationClass = "io.knowk.example.primitive.AndroidKotlinUnitTestPlugin"
        }
        register("androidCompose") {
            id = "io.knowk.example.primitive.android.compose"
            implementationClass = "io.knowk.example.primitive.AndroidComposePlugin"
        }
        register("androidHilt") {
            id = "io.knowk.example.primitive.android.hilt"
            implementationClass = "io.knowk.example.primitive.AndroidHiltPlugin"
        }
        register("androidKotlinPlugin") {
            id = "io.knowk.example.primitive.android.kotlin"
            implementationClass = "io.knowk.example.primitive.AndroidKotlinPlugin"
        }
        register("androidKotlinSerializationPlugin") {
            id = "io.knowk.example.primitive.android.kotlin.serialization"
            implementationClass = "io.knowk.example.primitive.AndroidKotlinSerializationPlugin"
        }
        register("androidKotlinParcelizePlugin") {
            id = "io.knowk.example.primitive.android.kotlin.parcelize"
            implementationClass = "io.knowk.example.primitive.AndroidKotlinParcelizePlugin"
        }
        register("googleProtoBuf") {
            id = "io.knowk.example.primitive.google.protobuf"
            implementationClass = "io.knowk.example.primitive.GoogleProtoBufPlugin"
        }

        // Conventions
        register("androidFeature") {
            id = "io.knowk.example.convention.feature"
            implementationClass = "io.knowk.example.convention.AndroidFeaturePlugin"
        }
    }
}
