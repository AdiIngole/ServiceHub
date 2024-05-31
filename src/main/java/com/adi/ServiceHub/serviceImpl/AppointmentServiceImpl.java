package com.adi.ServiceHub.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adi.ServiceHub.dao.AppointmentDAO;
import com.adi.ServiceHub.dto.Appointment;
import com.adi.ServiceHub.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentDAO appointmentDAO;

	@Override
	public Integer saveOrUpdateAppointment(Appointment appointment) {
		List<Appointment> list = appointmentDAO.findBySpunameAndCunameAndSpemail(appointment.getSpuname(), appointment.getCuname(), appointment.getSpemail());
		if (!list.isEmpty()) {
			Appointment a = list.get(0);
			System.out.println("Appointment has been updated Successfully");
			a.setAppointmentDateTime(appointment.getAppointmentDateTime());
			a.setCuname(appointment.getCuname());
			a.setSpemail(appointment.getSpemail());
			a.setSpuname(appointment.getSpuname());
			return appointmentDAO.save(a).getId();
		} else {
			System.out.println("Appointment has been Inserted Successfully");
			return appointmentDAO.save(appointment).getId();
		}
		
	}

	@Override
	public List<Appointment> getAll() {
		return appointmentDAO.findAll();
	}

	@Override
	public Integer deleteAppointment(Integer appointmentId) {
		Appointment appointment = appointmentDAO.findById(appointmentId).get();
		if (appointment != null) {
			appointmentDAO.deleteById(appointmentId);
			return appointment.getId();
		}
		return null;
	}

}
