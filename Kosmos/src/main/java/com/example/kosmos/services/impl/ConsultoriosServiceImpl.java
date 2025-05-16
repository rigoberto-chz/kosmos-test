package com.example.kosmos.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kosmos.models.ConsultorioVO;
import com.example.kosmos.persistence.crud.ConsultoriosJpaRepository;
import com.example.kosmos.persistence.entity.Consultorio;
import com.example.kosmos.services.ConsultoriosService;

@Service
public class ConsultoriosServiceImpl implements ConsultoriosService {

	@Autowired
	ConsultoriosJpaRepository consultoriosJpaRepository;
	
	@Override
	public List<ConsultorioVO> getConsultorios() {
		List<ConsultorioVO> lstConsultorios = new ArrayList<ConsultorioVO>();
		consultoriosJpaRepository.findAll().forEach(consultorio -> {
			lstConsultorios.add(new ConsultorioVO(consultorio.getIdConsultorio(), consultorio.getNumeroConsultorio(), consultorio.getPiso()));
		});
		return lstConsultorios;
	}

	@Override
	public void deleteConsultorio(int idConsultorio) {
		Consultorio consultorio = new Consultorio();
		consultorio.setIdConsultorio(idConsultorio);
		consultoriosJpaRepository.delete(consultorio);
	}

	@Override
	public Integer saveConsultorio(ConsultorioVO consultorioVO) {
		Consultorio consultorio = new Consultorio();
		consultorio.setNumeroConsultorio(consultorioVO.getNumeroConsultorio());
		consultorio.setPiso(consultorioVO.getPiso());
		consultoriosJpaRepository.save(consultorio);
		return consultorio.getIdConsultorio();
	}

}
