package com.juanJoseRondon.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
public class estudiantes {

	@Id
	private String id;
	private String tipoDocumento;
	private String documento;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String direccion;
	private String telefono;
	private String correoElectronico;
	private String clave;
	
	@DocumentReference
	private grado grado;
	@DocumentReference
	private acudiente acudiente;
	
	public grado getGrado() {
		return grado;
	}
	private double matematicas1;
	private double matematicas2;
	private double matematicas3;
	
	private double español1;
	private double español2;
	private double español3;
	
	private double sociales1;
	private double sociales2;
	private double sociales3;
	
	private double emprendimiento1;
	private double emprendimiento2;
	private double emprendimiento3;
	
	private double ingles1;
	private double ingles2;
	private double ingles3;
	
	private double contabilidad1;
	private double contabilidad2;
	private double contabilidad3;
	
	private double informatica1;
	private double informatica2;
	private double informatica3;
	
	private double eduFisica1;
	private double eduFisica2;
	private double eduFisica3;
	
	private double artistica1;
	private double artistica2;
	private double artistica3;
	



	public double getMatematicas1() {
		return matematicas1;
	}
	public void setMatematicas1(double matematicas1) {
		this.matematicas1 = matematicas1;
	}
	public double getMatematicas2() {
		return matematicas2;
	}
	public void setMatematicas2(double matematicas2) {
		this.matematicas2 = matematicas2;
	}
	public double getMatematicas3() {
		return matematicas3;
	}
	public void setMatematicas3(double matematicas3) {
		this.matematicas3 = matematicas3;
	}
	public double getEspañol1() {
		return español1;
	}
	public void setEspañol1(double español1) {
		this.español1 = español1;
	}
	public double getEspañol2() {
		return español2;
	}
	public void setEspañol2(double español2) {
		this.español2 = español2;
	}
	public double getEspañol3() {
		return español3;
	}
	public void setEspañol3(double español3) {
		this.español3 = español3;
	}
	public double getSociales1() {
		return sociales1;
	}
	public void setSociales1(double sociales1) {
		this.sociales1 = sociales1;
	}
	public double getSociales2() {
		return sociales2;
	}
	public void setSociales2(double sociales2) {
		this.sociales2 = sociales2;
	}
	public double getSociales3() {
		return sociales3;
	}
	public void setSociales3(double sociales3) {
		this.sociales3 = sociales3;
	}
	public double getEmprendimiento1() {
		return emprendimiento1;
	}
	public void setEmprendimiento1(double emprendimiento1) {
		this.emprendimiento1 = emprendimiento1;
	}
	public double getEmprendimiento2() {
		return emprendimiento2;
	}
	public void setEmprendimiento2(double emprendimiento2) {
		this.emprendimiento2 = emprendimiento2;
	}
	public double getEmprendimiento3() {
		return emprendimiento3;
	}
	public void setEmprendimiento3(double emprendimiento3) {
		this.emprendimiento3 = emprendimiento3;
	}
	public double getIngles1() {
		return ingles1;
	}
	public void setIngles1(double ingles1) {
		this.ingles1 = ingles1;
	}
	public double getIngles2() {
		return ingles2;
	}
	public void setIngles2(double ingles2) {
		this.ingles2 = ingles2;
	}
	public double getIngles3() {
		return ingles3;
	}
	public void setIngles3(double ingles3) {
		this.ingles3 = ingles3;
	}
	public double getContabilidad1() {
		return contabilidad1;
	}
	public void setContabilidad1(double contabilidad1) {
		this.contabilidad1 = contabilidad1;
	}
	public double getContabilidad2() {
		return contabilidad2;
	}
	public void setContabilidad2(double contabilidad2) {
		this.contabilidad2 = contabilidad2;
	}
	public double getContabilidad3() {
		return contabilidad3;
	}
	public void setContabilidad3(double contabilidad3) {
		this.contabilidad3 = contabilidad3;
	}
	public double getInformatica1() {
		return informatica1;
	}
	public void setInformatica1(double informatica1) {
		this.informatica1 = informatica1;
	}
	public double getInformatica2() {
		return informatica2;
	}
	public void setInformatica2(double informatica2) {
		this.informatica2 = informatica2;
	}
	public double getInformatica3() {
		return informatica3;
	}
	public void setInformatica3(double informatica3) {
		this.informatica3 = informatica3;
	}
	public double getEduFisica1() {
		return eduFisica1;
	}
	public void setEduFisica1(double eduFisica1) {
		this.eduFisica1 = eduFisica1;
	}
	public double getEduFisica2() {
		return eduFisica2;
	}
	public void setEduFisica2(double eduFisica2) {
		this.eduFisica2 = eduFisica2;
	}
	public double getEduFisica3() {
		return eduFisica3;
	}
	public void setEduFisica3(double eduFisica3) {
		this.eduFisica3 = eduFisica3;
	}
	public double getArtistica1() {
		return artistica1;
	}
	public void setArtistica1(double artistica1) {
		this.artistica1 = artistica1;
	}
	public double getArtistica2() {
		return artistica2;
	}
	public void setArtistica2(double artistica2) {
		this.artistica2 = artistica2;
	}
	public double getArtistica3() {
		return artistica3;
	}
	public void setArtistica3(double artistica3) {
		this.artistica3 = artistica3;
	}
	
	

	public void setGrado(grado grado) {
		this.grado = grado;
	}
	public acudiente getAcudiente() {
		return acudiente;
	}
	public void setAcudiente(acudiente acudiente) {
		this.acudiente = acudiente;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	
	
}
