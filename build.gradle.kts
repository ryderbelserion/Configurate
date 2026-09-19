plugins {
    id("com.ryderbelserion.feather.patcher")
    `java-plugin`
}

rootProject.version = rootProject.property("version") as String
rootProject.group = rootProject.property("group") as String

val path = projectDir.resolve("src")

patcher {
    patchesDirectory.set(projectDir.resolve("patches"))
    targetDirectory.set(path.resolve("target"))
    workingDirectory.set(path)

    url.set("git@github.com:SpongePowered/Configurate.git")
    sha.set("033bdf8d757fdb96959b313ed2d7c578252d9cd9")

    group = "feather-patcher"
}

tasks.withType<Test> {
    isEnabled = false
}