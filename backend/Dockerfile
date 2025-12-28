FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY mvnw pom.xml ./
COPY .mvn .mvn

RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/quarkus-app/quarkus-run.jar"]