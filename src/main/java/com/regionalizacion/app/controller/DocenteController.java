package com.regionalizacion.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.regionalizacion.app.dao.service.IDocenteService;
import com.regionalizacion.app.dao.service.IProgramaService;
import com.regionalizacion.app.entity.Docente;

@Controller
@RequestMapping("/menu")
@SessionAttributes("docente")
public class DocenteController {

	@Autowired
	private IDocenteService docenteService;

	@Autowired
	private IProgramaService programaService;

	@RequestMapping(value = "/docentes/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Docentes");
		model.addAttribute("docente", docenteService.findAll());
		return "cruds/listar-docentes";
	}

	@RequestMapping(value = "/docentes/crud", method = RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		Docente docente = new Docente();
		model.put("docente", docente);
		model.put("programa", programaService.findAll());
		model.put("titulo", "Formulario de Docentes");
		return "cruds/crud-docentes";
	}

	@RequestMapping(value = { "/docentes/crud/{id}" })
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Docente docente = null;
		if (id > 0) {
			docente = docenteService.findOne(id);
			if (docente == null) {
				flash.addFlashAttribute("error", "NO EXISTE EN LA BASE DE DATOS");
				return "redirect:/menu/docentes/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID NO PUEDE SER CERO!");
			return "redirect:/menu/docentes/listar";
		}
		model.put("docente", docente);
		model.put("programa", programaService.findAll());
		model.put("titulo", "Editar Docentes");
		return "cruds/crud-docentes";
	}

	@RequestMapping(value = { "/docentes/crud" }, method = RequestMethod.POST)
	public String guardar(@Valid Docente docente, BindingResult result, Model model, SessionStatus status,
			RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Docentes");
			return "cruds/crud-docentes";
		}
		String mensajeFlash = (docente.getId() != null) ? "Docente editado con éxito!" : "Docente creado con éxito!";

		docenteService.save(docente);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/menu/docentes/listar";
	}

	@RequestMapping(value = "/docentes/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			docenteService.delete(id);
			flash.addFlashAttribute("success", "Docente eliminado con éxito!");
		}
		return "redirect:/menu/docentes/listar";
	}
	
	/*
	 // Listar Excel
	@RequestMapping(value = "/docentes/listar/listarExcel", method = RequestMethod.GET)
	public String listarExcel(Model model) {

		model.addAttribute("titulo", "Listado de Docentes");
		model.addAttribute("docente", docenteService.findAll());
		return "listarExcel";
	}
	 */

}
