FROM openjdk:11

WORKDIR /GatewayService

COPY target/GatewayService-0.0.1-SNAPSHOT.jar GatewayService/

EXPOSE 9191

CMD ["java","-jar","GatewayService/GatewayService-0.0.1-SNAPSHOT.jar"]
