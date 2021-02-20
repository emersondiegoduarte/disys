package com.disys.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disys.entities.Itinerarios;
import com.disys.entities.LinhaOnibus;
import com.disys.services.LinhaOnibusService;

@RestController
@RequestMapping("/onibus")
public class LinhaOnibusController {
	
	@Autowired
	private LinhaOnibusService linhaOnibusService;
	
	@GetMapping("/index")
	public ResponseEntity<LinhaOnibus[]> index(){
		return ResponseEntity.status(HttpStatus.OK).body(linhaOnibusService.index());
	}
	
	@GetMapping("/itinerarios")
	public ResponseEntity<Itinerarios> listItinerarios(){
		return ResponseEntity.status(HttpStatus.OK).body(linhaOnibusService.listItinerarios());
	}
	
	@GetMapping("/linhas")
	public ResponseEntity<Page<LinhaOnibus>> getLinhaOnibusByNome(@RequestParam int quantidade, 
			@RequestParam int pagina, @RequestParam(required = false) String nome) {
		Pageable paginacao = PageRequest.of(pagina, quantidade, Sort.by("id").descending());
		Page<LinhaOnibus> paginas = null;
		if(nome != null) {
			paginas =  linhaOnibusService.getLinhaOnibusByNome(nome,paginacao);
		} else {
			paginas = linhaOnibusService.getLinhasOnibus(paginacao);
		}
		
		if(paginas.hasContent()) {
			return ResponseEntity.status(HttpStatus.OK).body(paginas);
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		
	}
	
	@PostMapping("/linhas")
	public ResponseEntity<LinhaOnibus> store(@RequestBody LinhaOnibus linhaOnibus) {
		LinhaOnibus linha = linhaOnibusService.store(linhaOnibus);
		if(linha != null) {
			return ResponseEntity.status(HttpStatus.OK).body(linha);
		}
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
		
	}
	
	@DeleteMapping("/linhas/{id}")
	public ResponseEntity<LinhaOnibus> deleteLinha(@PathVariable Long id) {
		if (id <= 0) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
		}
		linhaOnibusService.deleteLinhaOnibus(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
		
	}

}
