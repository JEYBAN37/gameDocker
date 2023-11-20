# Dockerfile para la imagen de construcción
FROM gradle:latest

# Copia los archivos necesarios
COPY . /app

# Establece el directorio de trabajo
WORKDIR /app

# Construye la aplicación
RUN gradle build

CMD ["java", "-jar", "build/libs/untitled.jar"]


