import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(libs.plugins.detekt)
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.android.gradle.plugin)
    }
}
allprojects {

    repositories {
        google()
        mavenCentral()
    }

    apply(plugin = "io.gitlab.arturbosch.detekt")

    detekt {
        source = files("src/main/java", "src/main/kotlin")
        parallel = true
        buildUponDefaultConfig = true
        config = files(
            rootProject.file("config/detekt.yml"),
            rootProject.file("config/detekt-compose.yml")
        )

        dependencies {
            detektPlugins(rootProject.libs.kode.detekt.rules.compose)
            detektPlugins(rootProject.libs.arturbosch.detekt.formatting)
        }

        tasks.withType<Detekt> {
            autoCorrect = true
            reports {
                html.required.set(true)
                html.outputLocation.set(rootProject.file("build/reports/detekt.html"))

                txt.required.set(true)
                txt.outputLocation.set(rootProject.file("build/reports/detekt.html"))
            }
        }
    }
}
