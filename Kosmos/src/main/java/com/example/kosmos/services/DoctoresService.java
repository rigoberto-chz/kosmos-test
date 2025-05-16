package com.example.kosmos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kosmos.models.DoctorVO;

@Service
public interface DoctoresService {

	public List<DoctorVO> getDoctores();
	public void deleteDoctor(int idDoctor);
	public Integer saveDoctor(DoctorVO doctorVO);
	
}
