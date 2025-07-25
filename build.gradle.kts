plugins {
    id("java-library")
    id("maven-publish")
}

group = "fr.mrmicky"
version = "2.1.5"
description = "Lightweight packet-based scoreboard API for Bukkit plugins."

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.21.4-R0.1-SNAPSHOT")
    compileOnly("net.kyori:adventure-api:4.13.0")
    compileOnly("net.kyori:adventure-text-serializer-legacy:4.13.0")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
        }
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}