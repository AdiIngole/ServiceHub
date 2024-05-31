package com.adi.ServiceHub.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_registration")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String fname;
	private String lname;
	private String mobilenumber;
	private String email;
	private String gender;
	private String address;
	private String city;
	private String tahasil;
	private String district;
	private String state;
	private String dateofbirth;
	private String username;
	private String password;
	private Boolean isAppointmentScheduled;
	private Boolean isRejected;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTahasil() {
		return tahasil;
	}
	public void setTahasil(String tahasil) {
		this.tahasil = tahasil;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
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
	public Boolean getIsAppointmentScheduled() {
		return isAppointmentScheduled;
	}
	public void setIsAppointmentScheduled(Boolean isAppointmentScheduled) {
		this.isAppointmentScheduled = isAppointmentScheduled;
	}
	public Boolean getIsRejected() {
		return isRejected;
	}
	public void setIsRejected(Boolean isRejected) {
		this.isRejected = isRejected;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String fname, String lname, String mobilenumber, String email, String gender,
			String address, String city, String tahasil, String district, String state, String dateofbirth,
			String username, String password, Boolean isAppointmentScheduled, Boolean isRejected) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.mobilenumber = mobilenumber;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.tahasil = tahasil;
		this.district = district;
		this.state = state;
		this.dateofbirth = dateofbirth;
		this.username = username;
		this.password = password;
		this.isAppointmentScheduled = isAppointmentScheduled;
		this.isRejected = isRejected;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", mobilenumber=" + mobilenumber
				+ ", email=" + email + ", gender=" + gender + ", address=" + address + ", city=" + city + ", tahasil="
				+ tahasil + ", district=" + district + ", state=" + state + ", dateofbirth=" + dateofbirth
				+ ", username=" + username + ", password=" + password + ", isAppointmentScheduled="
				+ isAppointmentScheduled + ", isRejected=" + isRejected + "]";
	}
	
	

}
