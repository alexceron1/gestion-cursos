# Etapa 1: Construcción (Build)
# Usamos una imagen de Maven con Java 17 para compilar el proyecto
FROM maven:3.8.5-openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Run)
# Usamos una imagen ligera de Java 17 solo para correr la app
FROM openjdk:21-jdk-slim
COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]