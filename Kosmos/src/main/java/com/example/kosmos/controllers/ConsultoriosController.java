package com.example.kosmos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kosmos.models.ConsultorioVO;
import com.example.kosmos.services.ConsultoriosService;

@Controller
public class ConsultoriosController {

	@Autowired
	ConsultoriosService consultoriosService;
	
	@RequestMapping(value = {"/consultorios"}, method = RequestMethod.GET)
	public String consultorios(Model model) {		
		model.addAttribute("lstConsultorios", consultoriosService.getConsultorios());
		return "consultorios/consultorios";
	}

	@RequestMapping(value = "/eliminarConsultorio", method = RequestMethod.GET)
	public String eliminarConsultorio(@RequestParam("idConsultorio") int idConsultorio, Model model) {
		consultoriosService.deleteConsultorio(idConsultorio);
		return "redirect:consultorios";	
	}
	
	@RequestMapping(value = "/crearConsultorio", method = RequestMethod.GET)
	public String crearConsultorio(Model model) {
		return "consultorios/crear-consultorios";
	}
	
	@RequestMapping(value = "/agregarConsultorio", method = RequestMethod.POST)
	public String agregarConsultorio(@Validated ConsultorioVO consultorioVO, Model model) {
		Integer result = consultoriosService.saveConsultorio(consultorioVO);
		if(result != null) {
			model.addAttribute("lstConsultorios", consultoriosService.getConsultorios());
			model.addAttribute("message", "Registro completo.");
		} else {
			model.addAttribute("error", "Problemas en el registro.");
		}
		return "consultorios/consultorios";
	
	}
	
	@RequestMapping(value = "/buscarConsultorios", method = RequestMethod.GET)
	public String buscarConsultorios(Model model) {
		return "consultorios/buscar-consultorios";
	}
}
