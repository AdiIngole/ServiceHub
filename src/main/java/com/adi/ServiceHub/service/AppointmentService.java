package com.adi.ServiceHub.service;

import java.util.List;

import com.adi.ServiceHub.dto.Appointment;

public interface AppointmentService {

	Integer saveOrUpdateAppointment(Appointment appointment);

	List<Appointment> getAll();

	Integer deleteAppointment(Integer appointmentId);
}
