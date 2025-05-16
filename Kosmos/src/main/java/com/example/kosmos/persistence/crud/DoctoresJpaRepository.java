package com.example.kosmos.persistence.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.kosmos.persistence.entity.Doctor;

@Repository
public interface DoctoresJpaRepository extends JpaRepository<Doctor, Long> {
	
	@NativeQuery("SELECT * FROM DOCTORES WHERE ID_DOCTOR = :idDoctor")
	public Doctor findById(@Param("idDoctor") int idDoctor);
	
}
