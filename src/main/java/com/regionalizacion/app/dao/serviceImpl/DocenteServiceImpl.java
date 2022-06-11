package com.regionalizacion.app.dao.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.regionalizacion.app.dao.IDocenteDao;
import com.regionalizacion.app.dao.service.IDocenteService;
import com.regionalizacion.app.entity.Docente;

@Service
public class DocenteServiceImpl implements IDocenteService{

	@Autowired
	private IDocenteDao docenteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Docente> findAll() {
		return (List<Docente>) docenteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Docente docente) {
		docenteDao.save(docente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		docenteDao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly=true)
	public Docente findOne(Long id) {
		return docenteDao.findById(id).orElse(null);
	}
}
