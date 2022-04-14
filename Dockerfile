FROM maven:3.8.4-openjdk-11-slim as builder

MAINTAINER Mohamed Belkamel

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests


FROM openjdk:11-jre-slim as runner

WORKDIR /app

ARG JAR_FILE=/app/target/*.jar

COPY --from=builder ${JAR_FILE} app.jar

CMD ["java", "-jar", "app.jar"]