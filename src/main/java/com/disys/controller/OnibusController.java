package com.disys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disys.entities.Itinerarios;
import com.disys.entities.LinhaOnibus;
import com.disys.services.LinhaOnibusService;

@RestController
@RequestMapping("/onibus")
public class OnibusController {
	
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

}
