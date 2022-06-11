package com.regionalizacion.app.dao.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.regionalizacion.app.dao.Consolidado;
import com.regionalizacion.app.dao.IReporteDao;
import com.regionalizacion.app.dao.service.IReporteService;
import com.regionalizacion.app.entity.Reporte;


@Service
public class ReporteServiceImpl implements IReporteService {

	@Autowired
	private IReporteDao reporteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Reporte> findAll() {
		return (List<Reporte>) reporteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Reporte reporte) {
		reporteDao.save(reporte);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		reporteDao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly=true)
	public Reporte findOne(Long id) {
		return reporteDao.findById(id).orElse(null);
	}

	@Override
	public List<Consolidado> findFilter(String fechaI, String fechaF) {
		return reporteDao.findFilter(fechaI, fechaF);
	}
	

}
