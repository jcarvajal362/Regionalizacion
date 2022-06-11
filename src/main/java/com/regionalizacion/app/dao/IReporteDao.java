package com.regionalizacion.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.regionalizacion.app.entity.Reporte;

public interface IReporteDao extends CrudRepository<Reporte, Long>{

	@Query(value="SELECT g.nombre AS regional, SUM(r.cantidad) AS total, r.fecha AS fechas FROM Reporte r INNER JOIN Programa p ON p.id = r.programa INNER JOIN Facultad f ON f.id = p.facultad INNER JOIN Regional g ON g.id = f.regional WHERE r.fecha BETWEEN cast(?1 as date) AND cast(?2 as date) GROUP BY (g.nombre) ORDER BY g.nombre DESC")
	List<Consolidado> findFilter(String fechaI, String fechaF);
	
	//METODO PARA LISTAR EL CONSOLIDADO
	//public List<Reporte> findWithFilter(String fechaInicio, String fechaFinal);
	//public List<Long> findSum(String fechaInicio, String fechaFinal);
	
}
