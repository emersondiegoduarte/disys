package com.disys.entities;

import java.io.Serializable;

//@Entity
public class LinhaOnibus implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7830352137032581371L;

	private Long id;
	
	private String codigo;
	
	private String nome;
	
	
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	
	

}
