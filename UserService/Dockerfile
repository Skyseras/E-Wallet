FROM openjdk:11

WORKDIR /UserService

COPY target/UserService-0.0.1-SNAPSHOT.jar UserService/

EXPOSE 8484

CMD ["java","-jar","UserService/UserService-0.0.1-SNAPSHOT.jar"]
