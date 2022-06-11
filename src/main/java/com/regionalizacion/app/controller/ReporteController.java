package com.regionalizacion.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.regionalizacion.app.dao.service.IProgramaService;
import com.regionalizacion.app.dao.service.IReporteService;
import com.regionalizacion.app.entity.Reporte;

@Controller
@RequestMapping("/menu")
@SessionAttributes("reporte")
public class ReporteController {

	@Autowired
	private IReporteService reporteService;

	@Autowired
	private IProgramaService programaService;

	@RequestMapping(value = "/estudiantes/Reporte_Estudiantes/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Reportes");
		model.addAttribute("reporte", reporteService.findAll());
		return "cruds/listar-reportes";
	}

	@RequestMapping(value = "/estudiantes/Reporte_Estudiantes/crud", method = RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		Reporte reporte = new Reporte();
		model.put("reporte", reporte);
		model.put("programa", programaService.findAll());
		model.put("titulo", "Formulario de Reportes");
		return "cruds/crud-reportes";
	}

	@RequestMapping(value = { "/estudiantes/Reporte_Estudiantes/crud/{id}" })
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Reporte reporte = null;
		if (id > 0) {
			reporte = reporteService.findOne(id);
			if (reporte == null) {
				flash.addFlashAttribute("error", "NO EXISTE EN LA BASE DE DATOS");
				return "redirect:/menu/estudiantes/Reporte_Estudiantes/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID NO PUEDE SER CERO!");
			return "redirect:/menu/estudiantes/Reporte_Estudiantes/listar";
		}
		model.put("reporte", reporte);
		model.put("programa", programaService.findAll());
		model.put("titulo", "Editar Reportes");
		return "cruds/crud-reportes";
	}

	@RequestMapping(value = { "/estudiantes/Reporte_Estudiantes/crud" }, method = RequestMethod.POST)
	public String guardar(@Valid Reporte reporte, BindingResult result, Model model, SessionStatus status,
			RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Reportes");
			return "cruds/crud-reportes";
		}
		reporteService.save(reporte);
		status.setComplete();
		String mensajeFlash = (reporte.getId() != null) ? "Usuario Editado con éxito!" : "Usuario Creado con éxito!";
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/menu/estudiantes/Reporte_Estudiantes/listar";
	}

	@RequestMapping(value = "/estudiantes/Reporte_Estudiantes/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			reporteService.delete(id);
			flash.addFlashAttribute("success", "Eliminado con éxito!");
		}
		return "redirect:/menu/estudiantes/Reporte_Estudiantes/listar";
	}

	// METODO PARA FILTRAR EL CONSOLIDADO
	@RequestMapping(value = "/estudiantes/Consolidado/listar", method = RequestMethod.GET)
	public String consolidadoL(Model model, @Param("fechaInicio") String fechaInicio,
			@Param("fechaFinal") String fechaFinal) {

		if (fechaInicio != null && fechaFinal != null) {

			model.addAttribute("titulo", "Consolidado");
			model.addAttribute("lista", reporteService.findFilter(fechaInicio, fechaFinal));
			model.addAttribute("fechaInicio", fechaInicio);
			model.addAttribute("fechaFinal", fechaFinal);
			model.addAttribute("reporte", reporteService.findAll());
			model.addAttribute("success", "Consulta realizada en la semana del: " + fechaInicio + " al " + fechaFinal);
			return "cruds/consolidado-listar";

		}
		model.addAttribute("titulo", "Consolidado");
		model.addAttribute("warning", "No ha realizado la Consulta");
		model.addAttribute("reporte", reporteService.findAll());

		return "cruds/consolidado-listar";
	}

}
