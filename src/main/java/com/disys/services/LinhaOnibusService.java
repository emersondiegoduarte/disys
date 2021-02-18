package com.disys.services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.disys.entities.Coordenadas;
import com.disys.entities.Itinerarios;
import com.disys.entities.LinhaOnibus;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import reactor.core.publisher.Mono;

@Service
public class LinhaOnibusService {

	@Autowired
	private WebClient webClient;
	
	public LinhaOnibus[] index(){
		String url = "http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o"; //2
		Mono<String> mono = webClient.
			method(HttpMethod.GET).
			uri("/php/facades/process.php?a=nc&p=%&t=o")
			.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML). 
			retrieve().bodyToMono(String.class);
		
		
		String linhas = mono.block();
		LinhaOnibus[] lista = new Gson().fromJson(linhas, LinhaOnibus[].class);
		return lista;
	}
	
	public Itinerarios listItinerarios(){
		String url = "http://www.poatransporte.com.br/php/facades/process.php?a=nc&p=%&t=o"; //2
		Mono<String> mono = webClient.
			method(HttpMethod.GET).
			uri("/php/facades/process.php?a=il&p=5566")
			.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML). 
			retrieve().bodyToMono(String.class);
		
		
		String linhas = mono.block();
		
		Gson gson = new Gson();
		Type userListType = new TypeToken<Coordenadas>(){}.getType();
		Coordenadas userArray = gson.fromJson(linhas, userListType);
		Itinerarios lista = gson.fromJson(linhas, Itinerarios.class);
		return lista;
	}
	
}
