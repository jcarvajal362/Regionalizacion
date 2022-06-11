package com.regionalizacion.app.dao.service;

import java.util.List;

import com.regionalizacion.app.entity.Facultad;

public interface IFacultadService {

	public List<Facultad> findAll();

	public void save(Facultad facultad);

	public void delete(Long id);

	public Facultad findOne(Long id);
	
}
