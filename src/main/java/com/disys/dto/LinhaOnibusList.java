package com.disys.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.disys.entities.LinhaOnibus;

public class LinhaOnibusList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1766414625710946011L;
	private List<LinhaOnibus> linhaOnibusList;
	
	public LinhaOnibusList() {
		linhaOnibusList = new ArrayList<LinhaOnibus>();
	}

	public List<LinhaOnibus> getLinhaOnibusList() {
		return linhaOnibusList;
	}

	public void setLinhaOnibusList(List<LinhaOnibus> linhaOnibusList) {
		this.linhaOnibusList = linhaOnibusList;
	}
	
	
	

}
