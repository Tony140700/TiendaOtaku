FROM eclipse-temurin:24-jdk
WORKDIR /app

# Copia el jar repackaged que Maven dejó en /target
COPY target/TiendaOtaku-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
