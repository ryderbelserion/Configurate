rootProject.name = "configurate-parent"

fun includeProject(pair: Pair<String, String>): Unit = includeProject(pair.first, pair.second)

fun includeProject(name: String, block: ProjectDescriptor.() -> Unit) {
    include(name)
    project(":$name").apply(block)
}

fun includeProject(path: String, name: String) {
    includeProject(name) {
        this.projectDir = File(path)
        this.name = name
    }
}

fun includeProject(name: String) {
    includeProject(name) {
        this.name = name
    }
}

if (file("src/target").exists()) {
    includeProject("src/target" to "configurate")
}