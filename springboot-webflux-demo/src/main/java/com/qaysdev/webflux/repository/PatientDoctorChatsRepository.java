package com.qaysdev.webflux.repository;

import com.qaysdev.webflux.entity.PatientDoctorChats;
import com.qaysdev.webflux.entity.PatientDoctorChatsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDoctorChatsRepository extends JpaRepository<PatientDoctorChats, PatientDoctorChatsId> {

}
