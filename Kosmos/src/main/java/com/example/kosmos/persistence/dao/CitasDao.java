package com.example.kosmos.persistence.dao;

import java.sql.Timestamp;
import java.util.List;

import com.example.kosmos.persistence.entity.Cita;

public interface CitasDao {

	public List<Cita> getCitasDoctorConsultorioHorarioPaciente(int idDoctor, int idConsultorio, Timestamp horarioConsulta, String nombrePaciente);
	
}
