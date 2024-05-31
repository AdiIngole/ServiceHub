package com.adi.ServiceHub.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cuname;
	private String spuname;
	private String spemail;
	private LocalDateTime appointmentDateTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCuname() {
		return cuname;
	}
	public void setCuname(String cuname) {
		this.cuname = cuname;
	}
	public String getSpuname() {
		return spuname;
	}
	public void setSpuname(String spuname) {
		this.spuname = spuname;
	}
	public String getSpemail() {
		return spemail;
	}
	public void setSpemail(String spemail) {
		this.spemail = spemail;
	}
	public LocalDateTime getAppointmentDateTime() {
		return appointmentDateTime;
	}
	public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(Integer id, String cuname, String spuname, String spemail, LocalDateTime appointmentDateTime) {
		super();
		this.id = id;
		this.cuname = cuname;
		this.spuname = spuname;
		this.spemail = spemail;
		this.appointmentDateTime = appointmentDateTime;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", cuname=" + cuname + ", spuname=" + spuname + ", spemail=" + spemail
				+ ", appointmentDateTime=" + appointmentDateTime + "]";
	}
	
	

}
