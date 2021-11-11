dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://oss.sonatype.org/content/repositories/snapshots/") }
        jcenter() // Warning: this repository is going to shut down soon
    }
}
pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}
rootProject.name = "Bookmark"
include(":app")
include(":shared")
include(":components")
