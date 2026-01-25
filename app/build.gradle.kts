plugins {
    application
    checkstyle
}

application {
    mainClass = "hexlet.code.App"
}

checkstyle {
    toolVersion = "10.12.4"
    configFile=file("./config/checkstyle/checkstyle.xml")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}