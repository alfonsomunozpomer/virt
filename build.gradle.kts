plugins {
    java
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-ollama:0.26.1")
    implementation("io.quarkus:quarkus-websockets-next")
    implementation("io.quarkiverse.quinoa:quarkus-quinoa:2.5.3")
    implementation("io.quarkus:quarkus-web-dependency-locator")
    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-openai:0.26.0")
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-rest")
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")

    runtimeOnly("org.webjars.npm:vue:3.5.13")

//    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-easy-rag:0.26.1")
    implementation("dev.langchain4j:langchain4j-embeddings-bge-small-en-v15:1.0.0-beta2")
    implementation("io.quarkiverse.langchain4j:quarkus-langchain4j-pgvector:0.26.1")
}

group = "com.spotqa.virtuoso"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
