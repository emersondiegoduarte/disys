package com.disys.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Coordenadas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8709220987337630808L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String latitude;
	
	private String longitude;
	
	@JsonIgnore
	@ManyToOne
	private Itinerarios itinerario;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Itinerarios getItinerario() {
		return itinerario;
	}

	public void setItinerario(Itinerarios itinerario) {
		this.itinerario = itinerario;
	}
	
	
	
	
}
