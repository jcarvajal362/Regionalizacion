package com.regionalizacion.app.dao.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.regionalizacion.app.dao.IEstdocprogDao;
import com.regionalizacion.app.dao.ReporteS;
import com.regionalizacion.app.dao.service.IEstdocprogService;
import com.regionalizacion.app.entity.Estdocprog;

@Service
public class EstdocprogServiceImpl implements IEstdocprogService {

	@Autowired
	private IEstdocprogDao estdocprogDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Estdocprog> findAll() {
		return (List<Estdocprog>) estdocprogDao.findByOrderByFechaDesc();
	}

	@Override
	@Transactional
	public void save(Estdocprog estdocprog) {
		estdocprogDao.save(estdocprog);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		estdocprogDao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly=true)
	public Estdocprog findOne(Long id) {
		return estdocprogDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Estdocprog> filterSemestral(String fechaI, String fechaF) {
		return estdocprogDao.filterSemestral(fechaI, fechaF);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ReporteS> filterAnual(int anyo) {
		return estdocprogDao.filterAnual(anyo);
	}
	
}
