package com.adi.ServiceHub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.ServiceHub.dto.Appointment;

@Repository
public interface AppointmentDAO extends JpaRepository<Appointment, Integer> {

	List<Appointment> findBySpuname(String spuname);
	
	List<Appointment> findBySpunameAndCunameAndSpemail(String spuname, String cuname, String spemail);
}
