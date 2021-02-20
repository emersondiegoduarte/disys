package com.disys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disys.entities.Itinerarios;
import com.disys.entities.LinhaOnibus;
import com.disys.services.ItinerarioService;

@RestController
@RequestMapping("/itinerario")
public class ItinerarioController {

	@Autowired
	private ItinerarioService itinerarioService;
	
	@GetMapping("/")
	public ResponseEntity<Page<Itinerarios>> getItinerariosByLinha(@RequestParam int quantidade, 
			@RequestParam int pagina, @RequestParam(required = false) String nome) {
		Pageable paginacao = PageRequest.of(pagina, quantidade);
		Page<Itinerarios> itinerariosPage =  null;
		if(nome != null) {
			itinerariosPage = itinerarioService.getItinerariosByNome(nome, paginacao);
		} else {
			itinerariosPage = itinerarioService.getItinerarios(paginacao);
		}
		if(itinerariosPage.hasContent()) {
			return ResponseEntity.status(HttpStatus.OK).body(itinerariosPage);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		
	}
	
	@PostMapping("/store")
	public ResponseEntity<Itinerarios> store(@RequestBody Itinerarios itinerario) {
		Itinerarios novoItinerario = itinerarioService.store(itinerario);
		if(novoItinerario != null) {
			return ResponseEntity.status(HttpStatus.OK).body(novoItinerario);
		}
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Itinerarios> deleteItinerario(@PathVariable Long id) {
		if (id <= 0) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
		}
		itinerarioService.deleteItinerario(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Itinerarios> update(@PathVariable Long id ,@RequestBody Itinerarios itinerario) {
		Itinerarios novoItinerario = itinerarioService.update(id, itinerario);
		if(novoItinerario != null) {
			return ResponseEntity.status(HttpStatus.OK).body(novoItinerario);
		}
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
		
	}
	
}
