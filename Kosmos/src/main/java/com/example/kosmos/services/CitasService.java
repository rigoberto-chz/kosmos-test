package com.example.kosmos.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kosmos.models.CitaVO;

public interface CitasService {

	public List<CitaVO> getCitas();
	public void cancelarCita(int idCita);
	public Integer saveCita(CitaVO citaVO) throws ParseException;
	public List<CitaVO> getCitas(CitaVO citaVO) throws ParseException;
	
}
