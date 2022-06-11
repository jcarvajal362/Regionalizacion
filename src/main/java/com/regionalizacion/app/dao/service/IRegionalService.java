package com.regionalizacion.app.dao.service;

import java.util.List;

import com.regionalizacion.app.entity.Regional;

public interface IRegionalService {

	public List<Regional> findAll();
	
	public void save(Regional regional);
	
	public void delete(Long id);
	
	public Regional findOne(Long id);

}
