package com.disys.entities;

import java.io.Serializable;
import java.util.List;

public class Itinerarios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7161037557448365049L;

	private Long idlinha;
	
	private String nome;
	
	private String codigo;
	
	private List<Coordenadas> coordenadas;
	
	public Long getIdlinha() {
		return idlinha;
	}

	public void setIdlinha(Long idlinha) {
		this.idlinha = idlinha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Coordenadas> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<Coordenadas> coordenadas) {
		this.coordenadas = coordenadas;
	}

	
	
	
	

}
