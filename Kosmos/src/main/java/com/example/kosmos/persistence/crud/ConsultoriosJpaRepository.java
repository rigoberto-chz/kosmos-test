package com.example.kosmos.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kosmos.persistence.entity.Consultorio;

@Repository
public interface ConsultoriosJpaRepository extends JpaRepository<Consultorio, Long> {

	@NativeQuery("SELECT * FROM CONSULTORIOS WHERE ID_CONSULTORIO = :idConsultorio")
	public Consultorio findById(@Param("idConsultorio") int idConsultorio);
	
}
