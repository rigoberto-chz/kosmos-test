package com.example.kosmos.persistence.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.kosmos.persistence.entity.Cita;
import com.example.kosmos.persistence.entity.Consultorio;
import com.example.kosmos.persistence.entity.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Repository
public class CitasDaoImpl implements CitasDao {

	@Autowired
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cita> getCitasDoctorConsultorioHorarioPaciente(int idDoctor, int idConsultorio, Timestamp horarioConsulta, String nombrePaciente) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cita> cq = cb.createQuery(Cita.class);
		Root<Cita> r = cq.from(Cita.class);
		Join<Cita, Doctor> adJoin = r.join("doctor", JoinType.INNER);
		Join<Cita, Consultorio> amoJoin = r.join("consultorio", JoinType.INNER);
	
		List<Predicate> predicates = new ArrayList<Predicate>();
		if(idDoctor > 0) {
			predicates.add(cb.equal(adJoin.get("idDoctor"), idDoctor));
		}
		if(idConsultorio > 0) {
			predicates.add(cb.equal(amoJoin.get("idConsultorio"), idConsultorio));
		}
		if(!nombrePaciente.isEmpty()) {
			predicates.add(cb.equal(r.get("nombrePaciente"), nombrePaciente));
		}
		if(horarioConsulta != null) {
			predicates.add(cb.equal(cb.function("FORMATDATETIME", Timestamp.class, r.get("horarioConsulta"), cb.literal("dd/MM/yyyy")), 
									cb.function("FORMATDATETIME", Timestamp.class, cb.parameter(Timestamp.class, "horarioConsulta"), cb.literal("dd/MM/yyyy"))));
		}
		
		cq.select(r);	
		cq.where(predicates.toArray(new Predicate[] {}));
		
		Query query = entityManager.createQuery(cq);
		if(horarioConsulta != null) {
			query.setParameter("horarioConsulta", horarioConsulta);
		}
		return query.getResultList();
	}

}
