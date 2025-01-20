FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Скопируем проект в контейнер
COPY . /app

# Соберём через Maven (если хотите собирать внутри контейнера)
# Если уже собираете вне Docker, то можно просто COPY jar-файл.
RUN ./mvnw clean package -DskipTests

# Запуск (примерно так, либо укажите точный jar)
CMD ["java", "-jar", "target/Project_Avax-1.0-SNAPSHOT-jar-with-dependencies.jar"]