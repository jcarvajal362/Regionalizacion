package com.regionalizacion.app.dao.service;

import java.util.List;

import com.regionalizacion.app.dao.Consolidado;
import com.regionalizacion.app.entity.Reporte;

public interface IReporteService {

	public List<Reporte> findAll();

	public void save(Reporte reporte);

	public void delete(Long id);

	public Reporte findOne(Long id);
	
	//CONSOLIDADO
	public List<Consolidado> findFilter(String fechaI, String fechaF);
}
