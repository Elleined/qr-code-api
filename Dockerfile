FROM openjdk:17-alpine
MAINTAINER Elleined

ENV PORT=8092

ADD ./target/*.jar email-sender-api.jar
EXPOSE 8092
CMD ["java", "-jar", "email-sender-api.jar"]