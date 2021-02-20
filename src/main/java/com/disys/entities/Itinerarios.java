package com.disys.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Itinerarios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7161037557448365049L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idlinha;
	
	private String nome;
	
	private String codigo;
	
	@OneToMany(mappedBy="itinerario", cascade = CascadeType.ALL)
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
