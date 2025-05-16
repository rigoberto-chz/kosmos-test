package com.example.kosmos.services.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kosmos.models.CitaVO;
import com.example.kosmos.models.DoctorVO;
import com.example.kosmos.models.ConsultorioVO;
import com.example.kosmos.persistence.crud.CitasJpaRepository;
import com.example.kosmos.persistence.crud.DoctoresJpaRepository;
import com.example.kosmos.persistence.crud.ConsultoriosJpaRepository;
import com.example.kosmos.persistence.dao.CitasDao;
import com.example.kosmos.persistence.entity.Cita;
import com.example.kosmos.persistence.entity.Consultorio;
import com.example.kosmos.persistence.entity.Doctor;
import com.example.kosmos.services.CitasService;

@Service
public class CitasServiceImpl implements CitasService {

	@Autowired
	CitasJpaRepository citasJpaRepository;
	
	@Autowired
	DoctoresJpaRepository doctoresJpaRepository;
	
	@Autowired
	ConsultoriosJpaRepository consultoriosJpaRepository;
	
	@Autowired
	CitasDao citasDao;
		
	@Override
	public List<CitaVO> getCitas() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		List<CitaVO> lstCitas = new ArrayList<CitaVO>();
		citasJpaRepository.findAll().forEach(cita -> {
			CitaVO citaVO = new CitaVO();
			citaVO.setIdCita(cita.getIdCita());
			citaVO.setDoctor(new DoctorVO(cita.getDoctor().getIdDoctor(), cita.getDoctor().getApellidoMaterno(), cita.getDoctor().getApellidoPaterno(), cita.getDoctor().getEspecialidad(), cita.getDoctor().getNombre()));
			citaVO.setConsultorio(new ConsultorioVO(cita.getConsultorio().getIdConsultorio(), cita.getConsultorio().getNumeroConsultorio(), cita.getConsultorio().getPiso()));
			citaVO.setHorarioConsulta(dateFormat.format(cita.getHorarioConsulta()));
			citaVO.setNombrePaciente(cita.getNombrePaciente());
			lstCitas.add(citaVO);
		});
		return lstCitas;
	}

	@Override
	public void cancelarCita(int idCita) {
		Cita cita = new Cita();
		cita.setIdCita(idCita);
		citasJpaRepository.delete(cita);
	}

	@Override
	public Integer saveCita(CitaVO citaVO) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");		
		
		Cita cita = new Cita();
		cita.setDoctor(new Doctor());
		cita.getDoctor().setIdDoctor(citaVO.getDoctor().getIdDoctor());
		cita.setConsultorio(new Consultorio());
		cita.getConsultorio().setIdConsultorio(citaVO.getConsultorio().getIdConsultorio());
		cita.setHorarioConsulta(new Timestamp(dateFormat.parse(citaVO.getHorarioConsulta()).getTime()));
		cita.setNombrePaciente(citaVO.getNombrePaciente());
		
		//Un mismo doctor no puede tener más de 8 citas en el día.
		List<Cita> searchs = citasJpaRepository.getCitasDoctorDia(citaVO.getDoctor().getIdDoctor(), new Timestamp(dateFormat.parse(citaVO.getHorarioConsulta()).getTime()));
		if(searchs.size() < 8) {
			//No se puede agendar cita en un mismo consultorio a la misma hora.
			Cita search = citasJpaRepository.getCitasConsultorioHorario(citaVO.getConsultorio().getIdConsultorio(), new Timestamp(dateFormat.parse(citaVO.getHorarioConsulta()).getTime()));
			if(search == null) {
				//No se puede agendar cita para un mismo Dr. a la misma hora.
				search = citasJpaRepository.getCitasDoctorHorario(citaVO.getDoctor().getIdDoctor(), new Timestamp(dateFormat.parse(citaVO.getHorarioConsulta()).getTime()));
				if(search == null) {
					//No se puede agendar cita para un paciente a la una misma hora.
					search = citasJpaRepository.getCitasPacienteHorario(citaVO.getNombrePaciente().toUpperCase().trim(), new Timestamp(dateFormat.parse(citaVO.getHorarioConsulta()).getTime()));
					if(search == null) {
						//No se puede agendar cita para un paciente con menos de 2 horas de diferencia para el mismo día. Es decir, si un paciente tiene 1 cita de 2 a 3pm, solo podría tener otra el mismo día a partir de las 5pm.
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(dateFormat.parse(citaVO.getHorarioConsulta()));
						calendar.add(Calendar.HOUR, - 2);
						search = citasJpaRepository.getCitasPacienteHorarios(citaVO.getNombrePaciente().toUpperCase().trim(), new Timestamp(calendar.getTime().getTime()), new Timestamp(dateFormat.parse(citaVO.getHorarioConsulta()).getTime()));
						if(search == null) {
							cita.setDoctor(doctoresJpaRepository.findById(citaVO.getDoctor().getIdDoctor()));
							cita.setConsultorio(consultoriosJpaRepository.findById(citaVO.getConsultorio().getIdConsultorio()));
							citasJpaRepository.save(cita);
							return cita.getIdCita();
						} else {
							return -3;
						}
					} else {
						return -2;
					}
				} else {
					return -1;
				}
			} else {
				return 0;
			}
		} else {
			return -4;
		}
	}

	@Override
	public List<CitaVO> getCitas(CitaVO citaVO) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		List<CitaVO> lstCitas = new ArrayList<CitaVO>();
		List<Cita> searchs = citasDao.getCitasDoctorConsultorioHorarioPaciente(citaVO.getDoctor().getIdDoctor(), 
				citaVO.getConsultorio().getIdConsultorio(), 
				citaVO.getHorarioConsulta().isEmpty() ? null : new Timestamp (dateFormat.parse(citaVO.getHorarioConsulta()).getTime()),
				citaVO.getNombrePaciente());
		searchs.forEach(cita -> {
			CitaVO vo = new CitaVO();
			vo.setIdCita(cita.getIdCita());
			vo.setDoctor(new DoctorVO(cita.getDoctor().getIdDoctor(), cita.getDoctor().getApellidoMaterno(), cita.getDoctor().getApellidoPaterno(), cita.getDoctor().getEspecialidad(), cita.getDoctor().getNombre()));
			vo.setConsultorio(new ConsultorioVO(cita.getConsultorio().getIdConsultorio(), cita.getConsultorio().getNumeroConsultorio(), cita.getConsultorio().getPiso()));
			vo.setHorarioConsulta(dateTimeFormat.format(cita.getHorarioConsulta().getTime()));
			vo.setNombrePaciente(cita.getNombrePaciente());
			lstCitas.add(vo);
		});
		return lstCitas;
	}

}
