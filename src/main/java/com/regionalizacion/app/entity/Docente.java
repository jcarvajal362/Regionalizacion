package com.regionalizacion.app.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "docente")
public class Docente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doc_id")
	private Long id;

	@NotNull
	@Column(name = "doc_cedula")
	private Long cedula;

	@NotEmpty
	@Column(name = "doc_nombre")
	private String nombre;
	
	@NotEmpty
	@Column(name = "doc_apellido")
	private String apellido;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doc_prog_id")
	private Programa programa;
	
	
	@NotNull
	@Column(name = "doc_telefono")
	private Long telefono;
	
	@NotEmpty
	@Column(name = "doc_pregrado")
	private String pregrado;
	
	
	@Column(name = "doc_posgrado")
	private Boolean posgrado;
	
	
	@Column(name = "doc_infoposgrado")
	private String infoposgrado;
	
	@NotEmpty
	@Column(name = "doc_contrato")
	private String contrato;
	
	@NotEmpty
	@Column(name = "doc_categoria")
	private String categoria;
	
	@Column(name = "doc_observaciones")
	private String observaciones;
	/*
	@NotEmpty
	private String formato;
	
	
	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}
*/
	
	

	private static final long serialVersionUID = 1L;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getCedula() {
		return cedula;
	}



	public void setCedula(Long cedula) {
		this.cedula = cedula;
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



	public Programa getPrograma() {
		return programa;
	}



	public void setPrograma(Programa programa) {
		this.programa = programa;
	}



	public Long getTelefono() {
		return telefono;
	}



	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}



	public String getPregrado() {
		return pregrado;
	}



	public void setPregrado(String pregrado) {
		this.pregrado = pregrado;
	}
	

	public Boolean getPosgrado() {
		return posgrado;
	}



	public void setPosgrado(Boolean posgrado) {
		this.posgrado = posgrado;
	}



	public String getInfoposgrado() {
		return infoposgrado;
	}



	public void setInfoposgrado(String infoposgrado) {
		this.infoposgrado = infoposgrado;
	}



	public String getContrato() {
		return contrato;
	}



	public void setContrato(String contrato) {
		this.contrato = contrato;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public String getObservaciones() {
		return observaciones;
	}



	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
