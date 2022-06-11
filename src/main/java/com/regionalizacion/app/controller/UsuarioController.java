package com.regionalizacion.app.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.regionalizacion.app.dao.service.IUsuarioService;
import com.regionalizacion.app.entity.Usuario;

@Controller
@RequestMapping
@SessionAttributes("usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	
	@GetMapping({"/","/login"})
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@RequestMapping(value = "/menu/usuarios/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Usuarios");
		model.addAttribute("usuario", usuarioService.listar());
		model.addAttribute("rol", usuarioService.findAll());
		return "usuario/listar";
	}
	
	@RequestMapping(value = "/menu/usuarios/crud", method = RequestMethod.GET)
	public String crear(Model model) {
		Usuario usuario = new Usuario();
		model.addAttribute("usuario",usuario);
		model.addAttribute("rol", usuarioService.findAll());
		model.addAttribute("titulo", "Formulario Usuarios");
		
		return "usuario/formulario";
	}
	
	@RequestMapping(value = {"/menu/usuarios/crud/{id}"})
	public String editar(@PathVariable (value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		
		Optional<Usuario> usuario = null;
		
		if(id > 0) {
			usuario = usuarioService.listarId(id);
			if (usuario == null) {
				flash.addFlashAttribute("error", "NO EXISTE EN LA BASE DE DATOS");
				return "redirect:/menu/usuarios/listar";
			}
		}else {
			flash.addFlashAttribute("error", "El ID NO PUEDE SER CERO!");
			return "redirect:/menu/usuarios/listar";
		}
		
		model.put("usuario", usuario);
		model.put("rol", usuarioService.findAll());
		model.put("titulo", "Editar Usuarios");
		return "usuario/formulario";
	}
	
	@RequestMapping(value = { "/menu/usuarios/crud" }, method = RequestMethod.POST)
	public String guardar(@Valid Usuario usuario,BindingResult result, Model model, SessionStatus status,RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Usuarios");
			return "usuario/formulario";
		}
		
		String mensajeFlash = (usuario.getId() != null) ? "Usuario Editado con éxito!" : "Usuario Creado con éxito!";
		//model.addAttribute("usuario",usuarioService.save(usuario));
		flash.addFlashAttribute("success", mensajeFlash);
		usuarioService.save(usuario);
		status.setComplete();
		
		return "redirect:/menu/usuarios/listar";
	}
	
	@RequestMapping(value = "/menu/usuarios/eliminar/{id}")
	public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if (id > 0) {
			usuarioService.delete(id);
			flash.addFlashAttribute("success", "Eliminado con éxito!");
		}else{
			flash.addFlashAttribute("error", "No existe en la Base de Datos");
			return "redirect:/menu/usuarios/listar";
		}
		return "redirect:/menu/usuarios/listar";
	}
}
