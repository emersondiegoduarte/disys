package com.disys.entities;

import java.sql.Timestamp;

public class PontoDeTaxi {
	
	private String nomeDoPonto;
	
	private String latitude;
	
	private String longitude;
	
	private String dataCadastro;

	public String getNomeDoPonto() {
		return nomeDoPonto;
	}

	public void setNomeDoPonto(String nomeDoPonto) {
		this.nomeDoPonto = nomeDoPonto;
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

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


}
