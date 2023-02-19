FROM openjdk:11

WORKDIR /TransactionService

COPY target/TransactionService-0.0.1-SNAPSHOT.jar TransactionService/

EXPOSE 8585

CMD ["java","-jar","TransactionService/TransactionService-0.0.1-SNAPSHOT.jar"]
