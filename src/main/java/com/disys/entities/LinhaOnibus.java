package com.disys.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LinhaOnibus implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7830352137032581371L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String codigo;
	
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Itinerarios intinerario;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Itinerarios getIntinerario() {
		return intinerario;
	}


	public void setIntinerario(Itinerarios intinerario) {
		this.intinerario = intinerario;
	}
	
	
	

}
