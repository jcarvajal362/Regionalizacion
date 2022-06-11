package com.regionalizacion.app.dao.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.regionalizacion.app.dao.IProgramaDao;
import com.regionalizacion.app.dao.service.IProgramaService;
import com.regionalizacion.app.entity.Programa;


@Service
public class ProgramaServiceImpl implements IProgramaService{

	@Autowired
	private IProgramaDao programaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Programa> findAll() {
		return (List<Programa>) programaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Programa programa) {
		programaDao.save(programa);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		programaDao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly=true)
	public Programa findOne(Long id) {
		return programaDao.findById(id).orElse(null);
	}

}
