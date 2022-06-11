package com.regionalizacion.app.dao.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.regionalizacion.app.dao.IFacultadDao;
import com.regionalizacion.app.dao.service.IFacultadService;
import com.regionalizacion.app.entity.Facultad;

@Service
public class FacultadServiceImpl implements IFacultadService {

	@Autowired
	private IFacultadDao facultadDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Facultad> findAll() {
		return (List<Facultad>) facultadDao.findAll();
	}

	@Override
	@Transactional
	public void save(Facultad facultad) {
		facultadDao.save(facultad);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		facultadDao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly=true)
	public Facultad findOne(Long id) {
		return facultadDao.findById(id).orElse(null);
	}

}
