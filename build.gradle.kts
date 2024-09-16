plugins {
    kotlin("jvm") version "2.0.10"
}

group = "fr.avainfo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.mysql:mysql-connector-j:9.0.0") // Ajout de la dépendance
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(8)
}