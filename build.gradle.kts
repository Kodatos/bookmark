// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val compose_version by extra("1.0.3")
    val kotlin_version by extra("1.5.21")
    val sqldelight_version by extra("1.5.1")
    val hilt_version by extra("2.38.1")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
        classpath("com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:0.10.2")
        classpath("com.squareup.sqldelight:gradle-plugin:${rootProject.extra["sqldelight_version"]}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${rootProject.extra["hilt_version"]}")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
