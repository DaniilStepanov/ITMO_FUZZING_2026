plugins {
    id("java")
}

group = "org.itmo.fuzzing"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

dependencies {
    implementation("org.ow2.asm:asm:9.7")
}

tasks.register<Jar>("agentJar") {
    archiveBaseName = "coverage-agent"
    archiveClassifier = "agent"

    from(sourceSets.main.get().output)
    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })

    manifest {
        attributes(
            "Premain-Class" to "org.itmo.fuzzing.lect2.instrumentation.CoverageAgent",
            "Can-Redefine-Classes" to "true",
            "Can-Retransform-Classes" to "true",
        )
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    exclude("META-INF/*.RSA", "META-INF/*.SF", "META-INF/*.DSA")
}
