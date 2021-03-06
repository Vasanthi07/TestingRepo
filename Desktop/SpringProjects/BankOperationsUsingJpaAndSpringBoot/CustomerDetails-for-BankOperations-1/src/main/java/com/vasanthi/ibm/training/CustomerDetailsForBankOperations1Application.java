package com.vasanthi.ibm.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
public class CustomerDetailsForBankOperations1Application {

	public static void main(String[] args) {
		SpringApplication.run(CustomerDetailsForBankOperations1Application.class, args);
	}

	
	@Bean
	RestTemplate getNewRestTemplate() {
		return new RestTemplate();
	}

}
