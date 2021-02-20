package com.disys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
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
