plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "configurate-parent"

listOf(
    "src/target/core" to "core",

    "src/target/examples" to "examples",

    "src/target/format/jackson" to "jackson",
    "src/target/format/gson" to "gson",
    "src/target/format/yaml" to "yaml"
).forEach {
    val path = it.first

    if (file(path).exists()) {
        includeProject(path, it.second)
    }
}

fun includeProject(name: String) {
    includeProject(name) {
        this.name = "${rootProject.name.lowercase()}-$name"
    }
}

fun includeProject(folder: String, name: String) {
    includeProject(name) {
        this.name = "${rootProject.name.lowercase()}-$name"
        this.projectDir = file(folder)
    }
}

fun includeProject(name: String, block: ProjectDescriptor.() -> Unit) {
    include(name)
    project(":$name").apply(block)
}