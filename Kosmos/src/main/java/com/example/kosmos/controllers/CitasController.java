package com.example.kosmos.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kosmos.models.CitaVO;
import com.example.kosmos.services.CitasService;
import com.example.kosmos.services.DoctoresService;
import com.example.kosmos.services.ConsultoriosService;

@Controller
public class CitasController {

	@Autowired
	CitasService citasService;
	
	@Autowired
	DoctoresService doctoresService;
	
	@Autowired
	ConsultoriosService consultoriosService;
	
	@RequestMapping(value = {"/", "/citas"}, method = RequestMethod.GET)
	public String citas(Model model) {		
		model.addAttribute("lstCitas", citasService.getCitas());
		return "citas/citas";
	}
	
	@RequestMapping(value = "/cancelarCita", method = RequestMethod.GET)
	public String cancelarCita(@RequestParam("idCita") int idCita, Model model) {
		citasService.cancelarCita(idCita);
		return "redirect:citas";
	}
	
	@RequestMapping(value = "/crearCita", method = RequestMethod.GET)
	public String crearCita(Model model) {
		model.addAttribute("lstDoctores", doctoresService.getDoctores());
		model.addAttribute("lstConsultorios", consultoriosService.getConsultorios());
		return "citas/crear-citas";
	}
	
	@RequestMapping(value = "/agregarCita", method = RequestMethod.POST)
	public String agregarCitas(@Validated CitaVO citaVO, Model model) throws ParseException {
		Integer result = citasService.saveCita(citaVO);
		switch (result) {
			case 0: {
				model.addAttribute("vo", citaVO);
				model.addAttribute("lstDoctores", doctoresService.getDoctores());
				model.addAttribute("lstConsultorios", consultoriosService.getConsultorios());
				model.addAttribute("error", "Consultorio no disponible en el horario seleccionado.");
				return "citas/crear-citas";
			}
			case -1: {
				model.addAttribute("vo", citaVO);
				model.addAttribute("lstDoctores", doctoresService.getDoctores());
				model.addAttribute("lstConsultorios", consultoriosService.getConsultorios());
				model.addAttribute("error", "El doctor no está disponible en el horario seleccionado.");
				return "citas/crear-citas";
			}
			case -2: {
				model.addAttribute("vo", citaVO);
				model.addAttribute("lstDoctores", doctoresService.getDoctores());
				model.addAttribute("lstConsultorios", consultoriosService.getConsultorios());
				model.addAttribute("error", "El paciente ya tiene una cita programada en ese horario.");
				return "citas/crear-citas";
			}
			case -3: {
				model.addAttribute("vo", citaVO);
				model.addAttribute("lstDoctores", doctoresService.getDoctores());
				model.addAttribute("lstConsultorios", consultoriosService.getConsultorios());
				model.addAttribute("error", "Debe esperar al menos 2 horas después de su última cita para agendar una nueva.");
				return "citas/crear-citas";
			}
			case -4: {
				model.addAttribute("vo", citaVO);
				model.addAttribute("lstDoctores", doctoresService.getDoctores());
				model.addAttribute("lstConsultorios", consultoriosService.getConsultorios());
				model.addAttribute("error", "El doctor no tiene disponibilidad para el día de hoy.");
				return "citas/crear-citas";
			}
			default:
				model.addAttribute("lstCitas", citasService.getCitas());
				model.addAttribute("message", "La cita ha sido registrada exitosamente.");
		}
		return "citas/citas";
	}
	
	@RequestMapping(value = "/buscarCitas", method = RequestMethod.GET)
	public String buscarCitas(Model model) {
		model.addAttribute("lstDoctores", doctoresService.getDoctores());
		model.addAttribute("lstConsultorios", consultoriosService.getConsultorios());
		return "citas/buscar-citas";
	}
	
	@RequestMapping(value = "/buscar/citas", method = RequestMethod.POST)
	public String buscarCitas(@Validated CitaVO citaVO, Model model) throws ParseException {
		model.addAttribute("lstDoctores", doctoresService.getDoctores());
		model.addAttribute("lstConsultorios", consultoriosService.getConsultorios());
		if(citaVO.getDoctor().getIdDoctor() > 0 ||
				citaVO.getConsultorio().getIdConsultorio() > 0 ||
				!citaVO.getHorarioConsulta().trim().isEmpty() ||
			    !citaVO.getNombrePaciente().trim().isEmpty()) {
			model.addAttribute("vo", citaVO);
			model.addAttribute("lstCitas", citasService.getCitas(citaVO));
		} else {
			model.addAttribute("error", "Por favor, seleccione al menos un criterio para realizar la búsqueda.");
		}
		return "citas/buscar-citas";
	}
	
}
