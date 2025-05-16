package com.example.kosmos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kosmos.models.DoctorVO;
import com.example.kosmos.services.DoctoresService;

@Controller
public class DoctoresController {

	@Autowired
	DoctoresService doctoresService;
	
	@RequestMapping(value = {"/doctores"}, method = RequestMethod.GET)
	public String doctores(Model model) {		
		model.addAttribute("lstDoctores", doctoresService.getDoctores());
		return "doctores/doctores";
	}
	
	@RequestMapping(value = "/eliminarDoctor", method = RequestMethod.GET)
	public String eliminarDoctor(@RequestParam("idDoctor") int idDoctor, Model model) {
		doctoresService.deleteDoctor(idDoctor);
		return "redirect:doctores";	
	}
	
	@RequestMapping(value = "/crearDoctor", method = RequestMethod.GET)
	public String crearDoctor(Model model) {
		return "doctores/crear-doctores";
	}
	
	@RequestMapping(value = "/agregarDoctor", method = RequestMethod.POST)
	public String agregarDoctor(@Validated DoctorVO doctorVO, Model model) {
		Integer result = doctoresService.saveDoctor(doctorVO);
		if(result != null) {
			model.addAttribute("lstDoctores", doctoresService.getDoctores());
			model.addAttribute("message", "Registro completo.");
		} else {
			model.addAttribute("error", "Problemas en el registro.");
		}
		return "doctores/doctores";
	
	}
	
	@RequestMapping(value = "/buscarDoctor", method = RequestMethod.GET)
	public String buscarDoctor(Model model) {
		return "doctores/buscar-doctores";
	}
}
