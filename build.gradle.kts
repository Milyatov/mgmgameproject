plugins {
    id("java")
}

group = "de.mgm.inf.mgmgame"
version = "1.0.0"

val javaVersion = findProperty("java.version") as String

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

tasks {
    getByName<Test>("test") {
        useJUnitPlatform()
    }

    getByName<Jar>("jar") {
        manifest {
            attributes("Main-Class" to "de.mgm.inf.mgmgame.Main")
        }
        archiveBaseName.set("${project.name}-J$javaVersion")
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
}