FROM openjdk:17-oracle
MAINTAINER Evgeniy Kanareikin
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]