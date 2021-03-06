// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val compose_version by extra("1.2.0-alpha03")
    val kotlin_version by extra("1.6.10")
    val sqldelight_version by extra("1.5.1")
    val hilt_version by extra("2.40.5")
    val kotlin_inject_version by extra("0.4.1")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra["kotlin_version"]}")
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
