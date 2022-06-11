package com.regionalizacion.app.dao.service;

import java.util.List;

import com.regionalizacion.app.entity.Docente;

public interface IDocenteService {

	public List<Docente> findAll();
	
	public void save(Docente docente);
	
	public void delete(Long id);
	
	public Docente findOne(Long id);
	
}
