package com.example.kosmos.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kosmos.models.DoctorVO;
import com.example.kosmos.persistence.crud.DoctoresJpaRepository;
import com.example.kosmos.persistence.entity.Doctor;
import com.example.kosmos.services.DoctoresService;

@Service
public class DoctoresServiceImpl implements DoctoresService {

	@Autowired
	DoctoresJpaRepository doctorsJpaRepository;
	
	@Override
	public List<DoctorVO> getDoctores() {
		List<DoctorVO> lstDoctores = new ArrayList<DoctorVO>();
		doctorsJpaRepository.findAll().forEach(doctor -> {
			lstDoctores.add(new DoctorVO(doctor.getIdDoctor(), doctor.getApellidoMaterno(), doctor.getApellidoPaterno(), doctor.getEspecialidad(), doctor.getNombre()));
		});
		return lstDoctores;
	}
	
	@Override
	public void deleteDoctor(int idDoctor) {
		Doctor doctor = new Doctor();
		doctor.setIdDoctor(idDoctor);
		doctorsJpaRepository.delete(doctor);
	}

	@Override
	public Integer saveDoctor(DoctorVO doctorVO) {
		Doctor doctor = new Doctor();
		doctor.setNombre(doctorVO.getNombre().toUpperCase());
		doctor.setApellidoPaterno(doctorVO.getApellidoPaterno().toUpperCase());
		doctor.setApellidoMaterno(doctorVO.getApellidoMaterno().toUpperCase());
		doctor.setEspecialidad(doctorVO.getEspecialidad().toUpperCase());
		doctorsJpaRepository.save(doctor);
		return doctor.getIdDoctor();
	}

}
