# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/pet_name-0.0.1-SNAPSHOT.jar app.jar

# Copy the SQLite database file
COPY database/pets_database.db /app/database/pets_database.db

# Expose the port
EXPOSE 9092

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
