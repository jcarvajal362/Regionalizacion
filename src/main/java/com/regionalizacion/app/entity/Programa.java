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



@Entity
@Table(name = "programa")
public class Programa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prog_id")
	private Long id;
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(name = "prog_nombre")
	private String nombre;

	@NotEmpty
	@Column(name = "prog_serial")
	private String serial;

	@NotEmpty
	@Column(name = "prog_nivel")
	private String nivel;
	
	@NotEmpty
	@Column(name = "prog_modalidad")
	private String modalidad;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prog_fac_id")
	private Facultad facultad;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	
	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
