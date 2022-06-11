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
import com.regionalizacion.app.dao.service.IRegionalService;
import com.regionalizacion.app.entity.Facultad;

@Controller
@RequestMapping("/menu")
@SessionAttributes("facultad")
public class FacultadController {

	@Autowired
	private IFacultadService facultadService;
	
	@Autowired 
	private IRegionalService regionalService;
	
	@Autowired 
	private IProgramaService programaService;

	@RequestMapping(value = "/facultades/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Facultades");
		model.addAttribute("facultad", facultadService.findAll());
		return "cruds/listar-facultades";
	}

	@RequestMapping(value = "/facultades/crud", method = RequestMethod.GET)
	public String crear(Map<String, Object> model) {
		Facultad facultad = new Facultad();
		model.put("facultad", facultad);
		model.put("regional", regionalService.findAll());
		model.put("titulo", "Formulario de Facultades");
		return "cruds/crud-facultades";
	}

	@RequestMapping(value = { "/facultades/crud/{id}" })
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Facultad facultad = null;
		if (id > 0) {
			facultad = facultadService.findOne(id);
			if (facultad == null) {
				flash.addFlashAttribute("error", "NO EXISTE EN LA BASE DE DATOS");
				return "redirect:/menu/facultades/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID NO PUEDE SER CERO!");
			return "redirect:/menu/facultades/listar";
		}
		model.put("facultad", facultad);
		model.put("regional", regionalService.findAll());
		model.put("titulo", "Editar Facultades");
		return "cruds/crud-facultades";
	}

	@RequestMapping(value = { "/facultades/crud" }, method = RequestMethod.POST)
	public String guardar(@Valid Facultad facultad, BindingResult result, Model model, SessionStatus status, RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Facultades");
			return "cruds/crud-facultades";
		}
		facultadService.save(facultad);
		status.setComplete();
		String mensajeFlash = (facultad.getId() != null) ? "Usuario Editado con éxito!" : "Usuario Creado con éxito!";
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:/menu/facultades/listar";
	}

	@RequestMapping(value = "/facultades/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			facultadService.delete(id);
			flash.addFlashAttribute("success", "Eliminado con éxito!");
		}
		return "redirect:/menu/facultades/listar";
	}

	//LISTADO DE LOS PROGRAMAS POR FACULTAD
		
		@RequestMapping(value = "/facultades/{facultad}", method = RequestMethod.GET)
		public String listarBga(Model model, @PathVariable String facultad) {
			model.addAttribute("titulo", facultad);
			model.addAttribute("programa", programaService.findAll());
			//Esta es la pagina listar.html
			return "cruds/facultades-listar";
		}
}
