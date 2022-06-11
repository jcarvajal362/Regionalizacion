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

import com.regionalizacion.app.dao.service.IEstdocprogService;
import com.regionalizacion.app.dao.service.IProgramaService;
import com.regionalizacion.app.entity.Estdocprog;

@Controller
@RequestMapping("/menu")
@SessionAttributes("estdocprog")
public class EstdocprogController {
	
	@Autowired
	private IEstdocprogService estdocprogService;
	
	@Autowired
	private IProgramaService programaService;
	
	@RequestMapping(value = "/programas/reporte/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Estudiantes y Docentes por Programa");
		model.addAttribute("estdocprog", estdocprogService.findAll());
		return "cruds/listar-eds";
	}
	
	@RequestMapping(value = "/programas/reporte/crud", method = RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		Estdocprog estdocprog = new Estdocprog();
		model.put("estdocprog", estdocprog);
		model.put("programa", programaService.findAll());
		model.put("titulo", "Formulario de Reporte por Programa");
		return "cruds/crud-eds";
	}

	@RequestMapping(value = { "/programas/reporte/crud/{id}" })
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Estdocprog estdocprog = null;
		if (id > 0) {
			estdocprog = estdocprogService.findOne(id);
			if (estdocprog == null) {
				flash.addFlashAttribute("error", "NO EXISTE EN LA BASE DE DATOS");
				return "redirect:/menu/programas/reporte/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID NO PUEDE SER CERO!");
			return "redirect:/menu/programas/reporte/listar";
		}
		model.put("estdocprog", estdocprog);
		model.put("programa", programaService.findAll());
		model.put("titulo", "Editar Reporte por Programa");
		return "cruds/crud-eds";
	}

	@RequestMapping(value = { "/programas/reporte/crud" }, method = RequestMethod.POST)
	public String guardar(@Valid Estdocprog estdocprog, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Reporte por Programa");
			flash.addFlashAttribute("danger", " Error al digitar los datos");
			return "cruds/crud-eds";
		}
		estdocprogService.save(estdocprog);
		status.setComplete();
		String mensajeFlash = (estdocprog.getId() != null) ? "Usuario Editado con éxito!" : "Usuario Creado con éxito!";
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/menu/programas/reporte/listar";
	}

	@RequestMapping(value = "/programas/reporte/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			estdocprogService.delete(id);
			flash.addFlashAttribute("success", "Eliminado con éxito!");
		}
		return "redirect:/menu/programas/reporte/listar";
	}

}
