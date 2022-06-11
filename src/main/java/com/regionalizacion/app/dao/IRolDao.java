package com.regionalizacion.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.regionalizacion.app.entity.Rol;

@Repository
public interface IRolDao extends CrudRepository<Rol, Long> {

}
