package com.example.kosmos.models;

import java.io.Serializable;

public class DoctorVO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idDoctor;
	private String apellidoMaterno;
	private String apellidoPaterno;
	private String especialidad;
	private String nombre;
	
	public DoctorVO() {
		super();
	}

	public DoctorVO(String apellidoMaterno, String apellidoPaterno, String especialidad, String nombre) {
		super();
		this.apellidoMaterno = apellidoMaterno;
		this.apellidoPaterno = apellidoPaterno;
		this.especialidad = especialidad;
		this.nombre = nombre;
	}

	public DoctorVO(int idDoctor, String apellidoMaterno, String apellidoPaterno, String especialidad, String nombre) {
		super();
		this.idDoctor = idDoctor;
		this.apellidoMaterno = apellidoMaterno;
		this.apellidoPaterno = apellidoPaterno;
		this.especialidad = especialidad;
		this.nombre = nombre;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
