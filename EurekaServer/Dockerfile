FROM openjdk:11

WORKDIR /EurekaServer

COPY target/EurekaServer-0.0.1-SNAPSHOT.jar EurekaServer/

EXPOSE 8761

CMD ["java","-jar","EurekaServer/EurekaServer-0.0.1-SNAPSHOT.jar"]
