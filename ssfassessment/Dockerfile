FROM openjdk:21-jdk 

# Build the application
# Create a directory call /app
# go into the directory cd /app
WORKDIR /src
#WORKDIR /app

# Copy all the required to /app
COPY src src
COPY .mvn .mvn
COPY mvnw.cmd .
COPY mvnw .
COPY pom.xml .

# Build & compile the java application
RUN mvn package -Dmaven.test.skip=true

# Run the application
# Define environment variable 
ENV PORT=8080
ENV SPRING_REDIS_HOST=localhost
ENV SPRING_REDIS_PORT=6379
ENV SPRING_REDIS_USERNAME=default
ENV SPRING_REDIS_PASSWORD=
ENV SPRING_REDIS_DATABASE=0

# Expose the portmv
EXPOSE ${PORT}
#EXPOSE 8080

# Run the program
ENTRYPOINT SERVER_PORT=${PORT} java -jar target/assessment/kristal/ssfassessemnt-0.0.1-SNAPSHOT.jar