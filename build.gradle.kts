buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")

        mavenLocal()
        maven(url = "https://jitpack.io")
    }
    dependencies {
        classpath(Build.BUILD_TOOLS)
        classpath(Build.KOTLIN_GRADLE_PLUGIN)
        classpath(ProjectDependencies.SqlDelight.PLUGIN)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
        mavenLocal()
        maven(url = "https://jitpack.io")

    }
}

//tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
//}