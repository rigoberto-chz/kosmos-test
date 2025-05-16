package com.example.kosmos.persistence.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the citas database table.
 * 
 */
@Entity
@Table(name="citas")
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CITA")
	private int idCita;

	@Column(name="HORARIO_CONSULTA")
	private Timestamp horarioConsulta;

	@Column(name="NOMBRE_PACIENTE")
	private String nombrePaciente;

	//bi-directional many-to-one association to Consultorio
	@ManyToOne
	@JoinColumn(name="ID_CONSULTORIO")
	private Consultorio consultorio;

	//bi-directional many-to-one association to Doctor
	@ManyToOne
	@JoinColumn(name="ID_DOCTOR")
	private Doctor doctor;

	public Cita() {
	}

	public int getIdCita() {
		return this.idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public Timestamp getHorarioConsulta() {
		return this.horarioConsulta;
	}

	public void setHorarioConsulta(Timestamp horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}

	public String getNombrePaciente() {
		return this.nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public Consultorio getConsultorio() {
		return this.consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}