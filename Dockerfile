# Этап сборки: используем официальный Maven образ
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Копируем проект во внутрь контейнера
COPY . /app

# Делаем mvnw исполняемым
RUN chmod +x mvnw

# Собираем проект с помощью Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Запускаем собранный JAR (укажите корректное имя файла)
CMD ["java", "-jar", "target/Project_Avax-1.0-SNAPSHOT-jar-with-dependencies.jar"]
