package com.disys.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.disys.entities.Itinerarios;
import com.disys.repositories.ItinerarioRepository;


@Service
public class ItinerarioService {

	@Autowired
	private ItinerarioRepository itinerarioRepository;
	
	public Itinerarios store(Itinerarios itinerario) {
		List<Itinerarios> itinerarios = itinerarioRepository.findByNome(itinerario.getNome());
		Itinerarios novoItinerario = null;
		if(itinerarios.isEmpty()) {
			itinerario.getCoordenadas().stream().forEach(coordenada -> coordenada.setItinerario(itinerario));
			novoItinerario = itinerarioRepository.save(itinerario);
		}
		
		return novoItinerario;
		
	}
	
	public Itinerarios update(Long id, Itinerarios itinerario) {
		Itinerarios itinerarioExistente = itinerarioRepository.findById(id).orElseGet(null);
		if(itinerarioExistente != null) {
			if(!itinerarioExistente.getIdlinha().equals(itinerario.getIdlinha())){
				return null;
			}
		}
		List<Itinerarios> itinerarios = itinerarioRepository.findByNome(itinerario.getNome());
		Stream<Itinerarios> stream = itinerarios.stream().filter(it -> itinerario.getNome().equals(it.getNome()) && itinerario.getIdlinha() != it.getIdlinha());
		if(stream.findAny().isPresent()) {
			return null;
		}
		itinerario.getCoordenadas().stream().forEach(coordenada -> coordenada.setItinerario(itinerario));
		itinerarioExistente = itinerario;
		itinerarioRepository.save(itinerarioExistente);
		return itinerarioExistente;
		
	}
	
	public Page<Itinerarios> getItinerarios(Pageable paginacao){
		return itinerarioRepository.findAll(paginacao);
	}
	
	public void deleteItinerario(Long id) {
		itinerarioRepository.deleteById(id);
	}
	
	public Itinerarios getItinerario(Long id) {
		return itinerarioRepository.findById(id).orElseGet(null);
	}

	public Page<Itinerarios> getItinerariosByNome(String nome, Pageable paginacao) {
		return itinerarioRepository.findByNomeContainingIgnoreCase(nome, paginacao);
	}
	
}
