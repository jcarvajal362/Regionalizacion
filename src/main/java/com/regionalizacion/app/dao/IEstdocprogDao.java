package com.regionalizacion.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.regionalizacion.app.entity.Estdocprog;

public interface IEstdocprogDao extends JpaRepository<Estdocprog, Long>{
	
	public List<Estdocprog> findByOrderByFechaDesc();
	
	//METODO PARA FILTRAR POR FECHA SEMESTRAL
	@Query(value="SELECT e FROM Estdocprog e WHERE e.fecha BETWEEN cast(?1 as date) AND cast(?2 as date)")
	public List<Estdocprog> filterSemestral(String fechaI, String fechaF);
	
	//METODO PARA FILTRAR POR FECHA ANUAL
	@Query(value="SELECT p.nivel AS nivel, p.nombre AS programas, f.nombre AS facultades, g.nombre AS regionales, AVG(e.ecantidad) AS estudiantes, AVG(e.dcantidad) AS docentes FROM Estdocprog e INNER JOIN Programa p ON p.id = e.programa INNER JOIN Facultad f ON f.id = p.facultad INNER JOIN Regional g ON g.id = f.regional WHERE YEAR(e.fecha)=?1 GROUP BY (p.nombre)")
	public List<ReporteS> filterAnual(int anyo);
	
}
