plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testImplementation("org.hamcrest:hamcrest:2.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(libs.guava)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    mainClass.set("org.plein.graphs.CourseSchedule")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

sourceSets {
    getByName("test") {
        java.srcDirs("app/src/test/java")
    }
}
