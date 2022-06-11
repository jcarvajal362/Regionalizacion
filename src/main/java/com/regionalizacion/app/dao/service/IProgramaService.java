package com.regionalizacion.app.dao.service;

import java.util.List;

import com.regionalizacion.app.entity.Programa;

public interface IProgramaService {

	public List<Programa> findAll();

	public void save(Programa Programa);

	public void delete(Long id);

	public Programa findOne(Long id);

}
