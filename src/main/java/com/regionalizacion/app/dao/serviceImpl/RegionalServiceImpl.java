package com.regionalizacion.app.dao.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.regionalizacion.app.dao.IRegionalDao;
import com.regionalizacion.app.dao.service.IRegionalService;
import com.regionalizacion.app.entity.Regional;

@Service
public class RegionalServiceImpl implements IRegionalService {

	@Autowired
	private IRegionalDao regionalDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Regional> findAll() {
		return (List<Regional>) regionalDao.findAll();
	}

	@Override
	@Transactional
	public void save(Regional regional) {
		regionalDao.save(regional);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		regionalDao.deleteById(id);	
	}

	@Override
	@Transactional(readOnly=true)
	public Regional findOne(Long id) {
		return regionalDao.findById(id).orElse(null);
	}


}
