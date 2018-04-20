package com.itrally

class GradleDSL {
    lateinit var group: String
    lateinit var version: String



    inner class ApplyPluginDSL {
        val plugins = arrayListOf<String>()

        fun plugin(pluginName: String) = plugins.add(pluginName)
    }

    inner class RepositoriesDSL {
        fun mavenCentral() = "https://mavenrepo.com"
    }

    inner class DependenciesDSL {
        val dependencies = arrayListOf<String>()

        fun compile(dependencyName: String) = dependencies.add(dependencyName)
        fun testCompile(dependencyName: String) = dependencies.add(dependencyName)
    }

    fun apply(init: ApplyPluginDSL.() -> Unit) {
        val applyPluginDSL = ApplyPluginDSL()
        applyPluginDSL.init()
    }

    fun repositories(init: RepositoriesDSL.() -> Unit) {
        val repositoriesDSL = RepositoriesDSL()
        repositoriesDSL.init()
    }

    fun dependencies(init: DependenciesDSL.() -> Unit) {
        val dependenciesDSL = DependenciesDSL()
        dependenciesDSL.init()
    }
}

fun gradleScript(init: GradleDSL.() -> Unit): GradleDSL {
    val gradleDSL = GradleDSL()
    gradleDSL.init()
    return gradleDSL
}

fun main(args: Array<String>) {
    gradleScript {
        group = "itrally"
        version = "1.0.0"

        apply {
            plugin("Java")
            plugin("Kotlin")
        }

        repositories {
            mavenCentral()
        }

        dependencies {
            compile("org.itrally.dep1")
            compile("org.itrally.dep2")
            testCompile("org.itrally.test")
        }
    }
}
