package com.regionalizacion.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.regionalizacion.app.entity.Regional;

public interface IRegionalDao extends CrudRepository<Regional, Long>{
	
}
