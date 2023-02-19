FROM openjdk:11

WORKDIR /WalletService

COPY target/WalletService-0.0.1-SNAPSHOT.jar WalletService/

EXPOSE 8383

CMD ["java","-jar","WalletService/WalletService-0.0.1-SNAPSHOT.jar"]
