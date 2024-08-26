plugins {
	java
	id("org.springframework.boot") version "2.7.11"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.v02"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.3.1")
	implementation("org.springframework.data:spring-data-commons:3.2.5")
	implementation ("io.jsonwebtoken:jjwt:0.12.3")
    compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:2.3.1")
	testImplementation("org.springframework.security:spring-security-test")
    annotationProcessor("org.projectlombok:lombok")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
//	implementation ("org.springframework.boot:spring-boot-starter-data-redis")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
