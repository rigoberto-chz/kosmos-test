package com.example.kosmos.models;

import java.io.Serializable;

public class CitaVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idCita;
	private DoctorVO doctor;
	private ConsultorioVO consultorio;
	private String horarioConsulta;
	private String nombrePaciente;
	
	public CitaVO() {
		super();
	}

	public CitaVO(DoctorVO doctor, ConsultorioVO consultorio, String horarioConsulta, String nombrePaciente) {
		super();
		this.doctor = doctor;
		this.consultorio = consultorio;
		this.horarioConsulta = horarioConsulta;
		this.nombrePaciente = nombrePaciente;
	}

	public CitaVO(int idCita, DoctorVO doctor, ConsultorioVO consultorio, String horarioConsulta, String nombrePaciente) {
		super();
		this.idCita = idCita;
		this.doctor = doctor;
		this.consultorio = consultorio;
		this.horarioConsulta = horarioConsulta;
		this.nombrePaciente = nombrePaciente;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public DoctorVO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorVO doctor) {
		this.doctor = doctor;
	}

	public ConsultorioVO getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(ConsultorioVO consultorio) {
		this.consultorio = consultorio;
	}

	public String getHorarioConsulta() {
		return horarioConsulta;
	}
	
	public void setHorarioConsulta(String horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	
}
