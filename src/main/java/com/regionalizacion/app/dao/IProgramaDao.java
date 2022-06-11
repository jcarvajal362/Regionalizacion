package com.regionalizacion.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.regionalizacion.app.entity.Programa;

public interface IProgramaDao extends CrudRepository<Programa, Long>{
	

}
