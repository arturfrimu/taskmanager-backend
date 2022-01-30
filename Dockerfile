FROM openjdk:8-jre-alpine

COPY target/taskmanager-0.0.1-SNAPSHOT.jar /taskmanager.jar

EXPOSE 8080
CMD ["java", "-jar", "/taskmanager.jar"]