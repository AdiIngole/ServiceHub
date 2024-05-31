package com.adi.ServiceHub.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "EmailGenerate")
public class EmailGenerate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String reciption;
	private String message;
	private String subject;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getReciption() {
		return reciption;
	}
	public void setReciption(String reciption) {
		this.reciption = reciption;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public EmailGenerate(Integer id, String reciption, String message, String subject) {
		super();
		this.id = id;
		this.reciption = reciption;
		this.message = message;
		this.subject = subject;
	}
	public EmailGenerate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmailGenerate [id=" + id + ", reciption=" + reciption + ", message=" + message + ", subject=" + subject
				+ "]";
	}
	
	

}
