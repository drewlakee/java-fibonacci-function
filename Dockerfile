FROM openjdk:14-jdk-alpine

LABEL maintainer = "Andrew Aleynikov [drew.lake@yandex.ru]"

CMD ["gradlew", "build"]
COPY ["build/libs/java-fibonacci-function-1.0.0.jar", "."]

ENTRYPOINT ["java", "-jar", "java-fibonacci-function-1.0.0.jar"]
