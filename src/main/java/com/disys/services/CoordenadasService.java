package com.disys.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disys.entities.Coordenadas;
import com.disys.repositories.CoordenadasRepository;
import com.disys.utils.Haversine;

@Service
public class CoordenadasService {

	
	@Autowired
	private CoordenadasRepository coordenadasRepository;
	
	public List<Coordenadas> findCoordenadasInRange(String latitude, String longitude, int raio) {
		
		List<Coordenadas> lista = coordenadasRepository.findAll();
		List<Coordenadas> newLista = new ArrayList<Coordenadas>();
		if(!lista.isEmpty()) {
			for (Coordenadas coordenada : lista) {
				double distance = new Haversine().distance(Double.valueOf(latitude), Double.valueOf(longitude), Double.valueOf(coordenada.getLatitude()), Double.valueOf(coordenada.getLongitude()));
				if(distance <= raio) {
					newLista.add(coordenada);
				}
			}
		}
		
		return newLista;
	}

}
