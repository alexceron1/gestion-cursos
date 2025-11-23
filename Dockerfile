# Etapa 1: Construcción (Build)
# Usamos Maven con JDK 21
FROM maven:3.9.9-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Run)
# Usamos una imagen ligera de Java 21 (JRE) para correr la app
FROM eclipse-temurin:21-jre
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]