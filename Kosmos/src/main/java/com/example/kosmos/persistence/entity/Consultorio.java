package com.example.kosmos.persistence.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the consultorios database table.
 * 
 */
@Entity
@Table(name="consultorios")
@NamedQuery(name="Consultorio.findAll", query="SELECT c FROM Consultorio c")
public class Consultorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CONSULTORIO")
	private int idConsultorio;

	@Column(name="NUMERO_CONSULTORIO")
	private int numeroConsultorio;

	private int piso;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="consultorio")
	private List<Cita> citas;

	public Consultorio() {
	}

	public int getIdConsultorio() {
		return this.idConsultorio;
	}

	public void setIdConsultorio(int idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public int getNumeroConsultorio() {
		return this.numeroConsultorio;
	}

	public void setNumeroConsultorio(int numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}

	public int getPiso() {
		return this.piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setConsultorio(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setConsultorio(null);

		return cita;
	}

}