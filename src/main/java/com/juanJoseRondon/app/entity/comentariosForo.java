package com.juanJoseRondon.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
public class comentariosForo {

	@Id
	private String id;
	private String comentarios;
	private String nombreCompleto;
	private String telefono;
	private String rol;
	
	@DocumentReference
	private  foroAcademico foroAcademico;

	public String getId() {
		return id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public foroAcademico getForoAcademico() {
		return foroAcademico;
	}

	public void setForoAcademico(foroAcademico foroAcademico) {
		this.foroAcademico = foroAcademico;
	}
	
	
}
