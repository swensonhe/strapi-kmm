pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")

        mavenLocal()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "StrapiKMM"
include(":strapi")
include(":app")
include(":androidapp")
