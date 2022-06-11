package com.regionalizacion.app.dao.service;

import java.util.List;

import com.regionalizacion.app.dao.ReporteS;
import com.regionalizacion.app.entity.Estdocprog;

public interface IEstdocprogService {
	
	public List<Estdocprog> findAll();

	public void save(Estdocprog estdocprog);

	public void delete(Long id);

	public Estdocprog findOne(Long id);
	
	//FILTRO SEMANAL
	public List<Estdocprog> filterSemestral(String fechaI, String fechaF);

	//FILTRO ANUAL
	public List<ReporteS> filterAnual(int anyo);
}
