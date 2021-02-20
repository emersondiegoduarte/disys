package com.disys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disys.entities.Coordenadas;
import com.disys.services.CoordenadasService;

@RestController
@RequestMapping("/coordenadas")
public class CoordenadasController {
	
	@Autowired
	private CoordenadasService coordenadasService;
	
	@GetMapping("/index")
	public ResponseEntity<List<Coordenadas>> findCoordenadasInRange(@RequestParam String latitude, @RequestParam String longitude, @RequestParam int raio){
		List<Coordenadas> coordenadas = coordenadasService.findCoordenadasInRange(latitude,longitude,raio);
		
		return ResponseEntity.status(HttpStatus.OK).body(coordenadas);
	}
	
	
	@PostMapping("/store")
	public ResponseEntity<Coordenadas> store(@RequestBody Coordenadas coordenadas) {
		Coordenadas novaCoordenada = coordenadasService.store(coordenadas);
		if(novaCoordenada != null) {
			return ResponseEntity.status(HttpStatus.OK).body(novaCoordenada);
		}
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
		
	}

}
