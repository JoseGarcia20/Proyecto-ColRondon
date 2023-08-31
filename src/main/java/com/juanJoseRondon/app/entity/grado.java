package com.juanJoseRondon.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
public class grado {
	
	@Id
	private String id;
	private String grado;
	private int orden;
	
	@DocumentReference
	private docente docente;


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public docente getDocente() {
		return docente;
	}
	public void setDocente(docente docente) {
		this.docente = docente;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	} 
	
	
	

}
