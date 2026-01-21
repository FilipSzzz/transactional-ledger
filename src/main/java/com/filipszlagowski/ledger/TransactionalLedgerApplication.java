package com.filipszlagowski.ledger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionalLedgerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalLedgerApplication.class, args);
	}

}
