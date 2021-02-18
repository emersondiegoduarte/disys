package com.disys.entities;

import java.io.Serializable;

public class Coordenadas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8709220987337630808L;
	private String lat;
	private String lng;
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	
	
}
