import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
    id("org.jetbrains.kotlin.js")// version "1.3.50"
}

group = "com.jessecorbett"
version = "1.5.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://kotlin.bintray.com/kotlinx") // kotlinx.serialization
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(rootProject)
}

tasks.withType<Kotlin2JsCompile> {
    kotlinOptions {
        moduleKind = "commonjs"
    }
}

kotlin.target.nodejs {}
