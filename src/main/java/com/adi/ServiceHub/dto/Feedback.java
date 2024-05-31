package com.adi.ServiceHub.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fid;
	private String name;
	private String position;
	private String feedback;
	private String mail;
	private String mob;
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(String name, String position, String feedback, String mail, String mob) {
		super();
		this.name = name;
		this.position = position;
		this.feedback = feedback;
		this.mail = mail;
		this.mob = mob;
	}
	public Feedback(Integer fid, String name, String position, String feedback, String mail, String mob) {
		super();
		this.fid = fid;
		this.name = name;
		this.position = position;
		this.feedback = feedback;
		this.mail = mail;
		this.mob = mob;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	@Override
	public String toString() {
		return "Feedback [fid=" + fid + ", name=" + name + ", position=" + position + ", feedback=" + feedback
				+ ", mail=" + mail + ", mob=" + mob + "]";
	}

}
