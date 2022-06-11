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

import com.regionalizacion.app.dao.service.IFacultadService;
import com.regionalizacion.app.dao.service.IProgramaService;
import com.regionalizacion.app.entity.Programa;

@Controller
@RequestMapping("/menu")
@SessionAttributes("programa")
public class ProgramaController {

	@Autowired
	private IProgramaService programaService;

	@Autowired
	private IFacultadService facultadService;

	@RequestMapping(value = "/programas/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Programas");
		model.addAttribute("programa", programaService.findAll());
		return "cruds/listar-programas";
	}

	//
	@RequestMapping(value = "/programas/crud", method = RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		Programa programa = new Programa();
		model.put("programa", programa);
		model.put("facultad", facultadService.findAll());
		model.put("titulo", "Formulario Programa");
		return "cruds/crud-programas";
	}

	@RequestMapping(value = { "/programas/crud/{id}" })
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Programa programa = null;
		if (id > 0) {
			programa = programaService.findOne(id);
			if (programa == null) {
				flash.addFlashAttribute("error", "NO EXISTE EN LA BASE DE DATOS");
				return "redirect:/menu/programas/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID NO PUEDE SER CERO!");
			return "redirect:/menu/programas/listar";
		}
		model.put("programa", programa);
		model.put("facultad", facultadService.findAll());
		model.put("titulo", "Editar Programas");
		return "cruds/crud-programas";
	}

	@RequestMapping(value = { "/programas/crud" }, method = RequestMethod.POST)
	public String guardar(@Valid Programa programa, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Programas");
			return "cruds/crud-programas";
		}
		programaService.save(programa);
		status.setComplete();
		String mensajeFlash = (programa.getId() != null) ? "Usuario Editado con éxito!" : "Usuario Creado con éxito!";
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/menu/programas/listar";
	}

	@RequestMapping(value = "/programas/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			programaService.delete(id);
			flash.addFlashAttribute("success", "Eliminado con éxito!");
		}
		return "redirect:/menu/programas/listar";
	}
	
	

}
