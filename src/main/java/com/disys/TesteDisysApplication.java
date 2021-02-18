package com.disys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class TesteDisysApplication {
	
	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder.baseUrl("http://www.poatransporte.com.br")
		.build();
		
	}

	public static void main(String[] args) {
		SpringApplication.run(TesteDisysApplication.class, args);
	}

}
