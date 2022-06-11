package com.regionalizacion.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
	
	@RequestMapping("/menu/facultades")
	public String facultades() {
		return "menu/facultades";
	}

	@RequestMapping("/menu/programas")
	public String programas() {
		return "menu/programas";
	}

	@RequestMapping("/menu/estudiantes")
	public String estudiantes() {
		return "menu/estudiantes";
	}

}
