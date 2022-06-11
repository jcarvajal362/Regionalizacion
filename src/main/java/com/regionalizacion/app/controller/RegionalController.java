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

import com.regionalizacion.app.dao.service.IEstdocprogService;
import com.regionalizacion.app.dao.service.IRegionalService;
import com.regionalizacion.app.entity.Regional;

@Controller
@RequestMapping("/menu")
@SessionAttributes("regional")
public class RegionalController {

	@Autowired
	private IRegionalService regionalService;

	@Autowired
	private IEstdocprogService estdocprogService;

	@RequestMapping(value = "/regionales/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Regionales");
		model.addAttribute("regional", regionalService.findAll());
		// Esta es la pagina listar.html
		return "cruds/listar-regionales";
	}

	@RequestMapping(value = "/regionales/crud", method = RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		Regional regional = new Regional();
		model.put("regional", regional);
		model.put("titulo", "Formulario Regionales");
		// Esta es la pagina crud.html
		return "cruds/crud-regionales";
	}

	@RequestMapping(value = { "/regionales/crud/{id}" })
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Regional regional = null;
		if (id > 0) {
			regional = regionalService.findOne(id);
			if (regional == null) {
				flash.addFlashAttribute("error", "NO EXISTE EN LA BASE DE DATOS");
				// Redirige a la pagina ../listar creada con anterioridad
				return "redirect:/menu/regionales/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID NO PUEDE SER CERO!");
			// Redirige a la pagina ../listar creada con anterioridad
			return "redirect:/menu/regionales/listar";
		}
		model.put("regional", regional);
		model.put("titulo", "Editar Regionales");
		// Carga los datos procesados a la pagina crud.html
		return "cruds/crud-regionales";
	}

	@RequestMapping(value = { "/regionales/crud" }, method = RequestMethod.POST)
	public String guardar(@Valid Regional regional, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash) {
		
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Regionales");
			// Retorna a la pagina crud.html
			return "cruds/crud-regionales";
		}
		regionalService.save(regional);
		status.setComplete();
		String mensajeFlash = (regional.getId() != null) ? "Usuario Editado con éxito!" : "Usuario Creado con éxito!";
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/menu/regionales/listar";
	}

	@RequestMapping(value = "/regionales/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			regionalService.delete(id);
			flash.addFlashAttribute("success", "Eliminado con éxito!");
		}
		return "redirect:/menu/regionales/listar";
	}

	// LISTADO DE LAS REGIONALES

	@RequestMapping(value = "/regionales", method = RequestMethod.GET)
	public String listarReg(Model model) {
		model.addAttribute("titulo", "Listado de Regionales");
		model.addAttribute("regional", regionalService.findAll());
		// Esta es la pagina listar.html
		return "menu/regionales";
	}

	@RequestMapping(value = "/regionales/{regional}", method = RequestMethod.GET)
	public String listarRe(Model model, @PathVariable String regional, @Param("fechaI") String fechaI,@Param("fechaF") String fechaF){
		if (fechaI != null && fechaF != null) {
			model.addAttribute("titulo", regional);
			model.addAttribute("estdocprog", estdocprogService.filterSemestral(fechaI, fechaF));
			model.addAttribute("fechaI", fechaI);
			model.addAttribute("fechaF", fechaF);
			model.addAttribute("success","Filtrado en el semestre del: "+fechaI+" al "+fechaF);
			return "cruds/regionales-listar";
		}
		model.addAttribute("titulo", regional);
		model.addAttribute("estdocprog", estdocprogService.findAll());
		return "cruds/regionales-listar";
	}
	
	//Listado Regionales usuarios
	@RequestMapping(value = "/regional", method = RequestMethod.GET)
	public String listarRegUsu(Model model) {
		model.addAttribute("titulo", "Listado de Regionales");
		return "menu/regional_usuario";
	}
}
