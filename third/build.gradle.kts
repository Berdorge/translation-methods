plugins {
    kotlin("jvm") version "2.0.20"
    antlr
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"
val antlrOutputDirectory = file("${project.buildDir}/generated/sources/main/java/antlr")

repositories {
    mavenCentral()
}

dependencies {
    antlr(libs.antlr.compiler)
}

application {
    mainClass = "org.example.formatter.MainKt"
}

kotlin {
    jvmToolchain(21)
}

sourceSets {
    main {
        java {
            srcDir(antlrOutputDirectory)
        }
    }
}

tasks.compileKotlin {
    dependsOn(tasks.generateGrammarSource)
}

tasks.generateGrammarSource {
    outputDirectory = File(antlrOutputDirectory, "org/example/formatter")
    arguments = arguments + listOf("-package", "org.example.formatter", "-visitor")
}
