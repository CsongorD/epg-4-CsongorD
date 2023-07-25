### Download maven img ###
FROM maven:3.9.3-sapmachine-17 AS build
WORKDIR /buildmaven
RUN mkdir ./src
COPY backend/pom.xml .
COPY backend/src/ ./src
RUN mvn -f pom.xml clean package

###
FROM eclipse-temurin:17-jre-alpine
COPY --from=build /buildmaven/target/*.jar app.jar
EXPOSE 8080
CMD "java" "-jar" "app.jar"


