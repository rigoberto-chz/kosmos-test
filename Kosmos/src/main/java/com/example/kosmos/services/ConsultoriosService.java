package com.example.kosmos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kosmos.models.ConsultorioVO;

@Service
public interface ConsultoriosService {

	public List<ConsultorioVO> getConsultorios();
	public void deleteConsultorio(int idConsultorio);
	public Integer saveConsultorio(ConsultorioVO consultorioVO);
	
}
