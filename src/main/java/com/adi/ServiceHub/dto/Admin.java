package com.adi.ServiceHub.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminid;
	private String username;
	private String password;
	private String email;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(Integer adminid, String username, String password, String email) {
		super();
		this.adminid = adminid;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public Admin(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public Integer getAdminid() {
		return adminid;
	}
	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", username=" + username + ", password=" + password + ", email=" + email
				+ "]";
	}

}
