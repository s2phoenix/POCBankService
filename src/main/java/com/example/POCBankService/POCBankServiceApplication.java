package com.example.POCBankService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.example.POCBankService", "com.example.POCBankService.config", "com.example.POCBankService.component"})
@EnableScheduling
public class POCBankServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(POCBankServiceApplication.class, args);
	}
}
