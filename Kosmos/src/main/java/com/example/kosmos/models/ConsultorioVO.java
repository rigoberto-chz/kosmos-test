package com.example.kosmos.models;

import java.io.Serializable;

public class ConsultorioVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idConsultorio;
	private int numeroConsultorio;
	private int piso;
	
	public ConsultorioVO() {
		super();
	}

	public ConsultorioVO(int numeroConsultorio, int piso) {
		super();
		this.numeroConsultorio = numeroConsultorio;
		this.piso = piso;
	}

	public ConsultorioVO(int idConsultorio, int numeroConsultorio, int piso) {
		super();
		this.idConsultorio = idConsultorio;
		this.numeroConsultorio = numeroConsultorio;
		this.piso = piso;
	}

	public int getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public int getNumeroConsultorio() {
		return numeroConsultorio;
	}

	public void setNumeroConsultorio(int numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}
	
}
