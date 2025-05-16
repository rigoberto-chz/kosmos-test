package com.example.kosmos.persistence.crud;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kosmos.persistence.entity.Cita;

@Repository
public interface CitasJpaRepository extends JpaRepository<Cita, Long> {
	
	@NativeQuery("SELECT * FROM CITAS WHERE ID_DOCTOR = :idDoctor AND FORMATDATETIME(HORARIO_CONSULTA, 'yyyy-MM-dd') = FORMATDATETIME(:horarioConsulta, 'yyyy-MM-dd')")
	public List<Cita> getCitasDoctorDia(@Param("idDoctor") int idDoctor, @Param("horarioConsulta") Timestamp horarioConsulta);
	
	@NativeQuery("SELECT * FROM CITAS WHERE ID_CONSULTORIO = :idConsultorio AND HORARIO_CONSULTA = :horarioConsulta")
	public Cita getCitasConsultorioHorario(@Param("idConsultorio") int idConsultorio, @Param("horarioConsulta") Timestamp horarioConsulta);
	
	@NativeQuery("SELECT * FROM CITAS WHERE ID_DOCTOR = :idDoctor AND HORARIO_CONSULTA = :horarioConsulta")
	public Cita getCitasDoctorHorario(@Param("idDoctor") int idDoctor, @Param("horarioConsulta") Timestamp horarioConsulta);
	
	@NativeQuery("SELECT * FROM CITAS WHERE NOMBRE_PACIENTE = :nombrePaciente AND HORARIO_CONSULTA = :horarioConsulta")
	public Cita getCitasPacienteHorario(@Param("nombrePaciente") String nombrePaciente, @Param("horarioConsulta") Timestamp horarioConsulta);
	
	@NativeQuery("SELECT * FROM CITAS WHERE NOMBRE_PACIENTE = :nombrePaciente AND HORARIO_CONSULTA BETWEEN :horarioConsulta2 AND :horarioConsulta")
	public Cita getCitasPacienteHorarios(@Param("nombrePaciente") String nombrePaciente, @Param("horarioConsulta2") Timestamp horarioConsulta2, @Param("horarioConsulta") Timestamp horarioConsulta);
	
	@NativeQuery("SELECT * FROM CITAS WHERE ID_DOCTOR = :idDoctor")
	public List<Cita> getCitasDoctor(@Param("idDoctor") int idDoctor);
	
	@NativeQuery("SELECT * FROM CITAS WHERE ID_CITA = :idCita")
	public Cita getCita(@Param("idCita") int idCita);
	
}


