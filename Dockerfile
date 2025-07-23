# Imagen base con Java 11
FROM openjdk:11-jdk-slim

# Directorio dentro del contenedor
WORKDIR /app

# Copiá tu archivo .jar al contenedor (ajustá el nombre real del JAR)
COPY target/UsuariosRPI-1.0-SNAPSHOT.jar app.jar

# Puerto que usa tu app (opcional)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
