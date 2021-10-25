import com.google.devtools.ksp.gradle.KspTaskMetadata
import com.google.devtools.ksp.gradle.KspTaskNative
import com.google.devtools.ksp.gradle.KspTaskJvm
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinNativeCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.konan.properties.Properties
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.BOOLEAN
import java.io.*

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.5.31"
    id("com.android.library")
    id("com.squareup.sqldelight")
    id("com.codingfeline.buildkonfig")
    id("com.google.devtools.ksp") version "1.5.31-1.0.0"

}

buildkonfig {
    packageName = "com.kodatos.shared"
    val secrets = Properties().apply {
        load(FileInputStream(File(projectDir, "secrets.properties")))
    }
    defaultConfigs {
        buildConfigField(STRING, "NYT_API_KEY", secrets["NYT_API_KEY"] as String)
        buildConfigField(BOOLEAN, "DEBUG", "false")
    }
    defaultConfigs("dev") {
        buildConfigField(BOOLEAN, "DEBUG", "true")
    }
}

kotlin {
    android()

    /*val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iosTarget("ios") {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }*/
    sourceSets {
        val ktor_version = "1.6.2"
        val kotest_version = "5.0.0.M3"
        val commonMain by getting {
            dependencies {
                implementation("me.tatarka.inject:kotlin-inject-runtime:${rootProject.extra["kotlin_inject_version"]}")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
                implementation("io.ktor:ktor-client-core:$ktor_version")
                implementation("io.ktor:ktor-client-serialization:$ktor_version")
                implementation("io.ktor:ktor-client-logging:$ktor_version")
                implementation("io.github.aakira:napier:2.1.0")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.0")
                implementation("com.squareup.sqldelight:runtime:${rootProject.extra["sqldelight_version"]}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation("io.kotest:kotest-runner-junit5:$kotest_version")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktor_version")
                implementation("com.squareup.sqldelight:android-driver:${rootProject.extra["sqldelight_version"]}")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        /*val iosMain by getting
        val iosTest by getting*/
    }
}

dependencies {
    ksp("me.tatarka.inject:kotlin-inject-compiler-ksp:${rootProject.extra["kotlin_inject_version"]}")
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(31)
    }
}

sqldelight {
    database("BookmarkDatabase") {
        packageName = "com.kodatos.bookmark.db"
    }
}

// Generate common code with ksp instead of per-platform, hopefully this won't be needed in the future.
// https://github.com/google/ksp/issues/567
kotlin.sourceSets.commonMain {
    kotlin.srcDir("build/generated/ksp/commonMain/kotlin")
}
tasks.withType<KspTaskJvm>().configureEach {
    enabled = false
}
tasks.withType<KotlinCompile>().configureEach {
    dependsOn(tasks.withType<KspTaskMetadata>())
}

tasks.withType<Test> {
    useJUnitPlatform()
}


/*
val packForXcode by tasks.creating(Sync::class) {
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>("ios").binaries.getFramework(mode)
    val targetDir = File(buildDir, "xcode-frameworks")

    group = "build"
    dependsOn(framework.linkTask)
    inputs.property("mode", mode)

    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)*/
