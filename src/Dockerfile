FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/typing-speed-test.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]