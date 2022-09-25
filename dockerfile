#FROM openjdk:8-alpine3.9
FROM maven:3.8.2-jdk-8
WORKDIR /mybackend
ADD target/mybackend-0.0.1-SNAPSHOT.jar mybackend.jar
EXPOSE 8080

CMD ["java","-jar", "mybackend.jar"]
