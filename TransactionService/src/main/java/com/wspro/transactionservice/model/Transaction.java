package com.wspro.transactionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.time.LocalDate;

@Document("transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable {
	@MongoId
	private String transactionId;
	private LocalDate dateTransaction;
	private Double amount;
	private String walletRef;
	private TransactionType transactionType;
}
