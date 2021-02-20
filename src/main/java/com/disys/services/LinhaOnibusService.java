package com.disys.services;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.disys.entities.Coordenadas;
import com.disys.entities.Itinerarios;
import com.disys.entities.LinhaOnibus;
import com.disys.repositories.LinhaOnibusRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import reactor.core.publisher.Mono;

@Service
public class LinhaOnibusService {

	@Autowired
	private WebClient webClient;
	
	@Autowired
	private LinhaOnibusRepository linhaOnibusRepository;
	
	@Autowired
	private ItinerarioService itinerarioService;
	
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
	
	public Page<LinhaOnibus> getLinhaOnibusByNome(String nome, Pageable paginacao){
		return linhaOnibusRepository.findByNomeContaining(nome, paginacao);
	}
	
	public LinhaOnibus store(LinhaOnibus linhaOnibus) {
		List<LinhaOnibus> linha = linhaOnibusRepository.findByNome(linhaOnibus.getNome());
		LinhaOnibus novaLinha = null;
		if(linha.isEmpty()) {
			if(linhaOnibus.getIntinerario() != null){
				if(linhaOnibus.getIntinerario().getIdlinha() != null) {
					Itinerarios itinerario = itinerarioService.getItinerario(linhaOnibus.getIntinerario().getIdlinha());
					linhaOnibus.setIntinerario(itinerario);
				} else {
					linhaOnibus.getIntinerario().getCoordenadas().stream().forEach(coordenada -> coordenada.setItinerario(linhaOnibus.getIntinerario()));
				}
			}
			novaLinha = linhaOnibusRepository.save(linhaOnibus);
		}
		
		return novaLinha;
		
	}
	
	public Page<LinhaOnibus> getLinhasOnibus(Pageable paginacao){
		return linhaOnibusRepository.findAll(paginacao);
	}

	public void deleteLinhaOnibus(Long id) {
		linhaOnibusRepository.deleteById(id);
	}
	
}
