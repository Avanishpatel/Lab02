package com.solstice.stockdata.stockdatapersistantquery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class StockDataPersistantQueryApplication {

	public static void main(String[] args) {

		SpringApplication.run(StockDataPersistantQueryApplication.class, args);
	}
}
