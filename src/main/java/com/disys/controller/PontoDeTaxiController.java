package com.disys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disys.entities.PontoDeTaxi;
import com.disys.services.PontoDeTaxiService;

@RestController
@RequestMapping("/pontodetaxi")
public class PontoDeTaxiController {
	
	@Autowired
	private PontoDeTaxiService pontoDeTaxiService;
	
	@GetMapping("/index")
	public ResponseEntity<List<PontoDeTaxi>> listaPontoDeTaxi(){
		List<PontoDeTaxi> lista = pontoDeTaxiService.listaPontoDeTaxi();
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}
	
	
	@PostMapping("/store")
	public ResponseEntity<List<PontoDeTaxi>> storePontoDeTaxi(@RequestBody PontoDeTaxi pontoDeTaxi){
		List<PontoDeTaxi> lista = pontoDeTaxiService.inserirPontoDeTaxi(pontoDeTaxi);
		return ResponseEntity.status(HttpStatus.OK).body(lista);
	}

}
