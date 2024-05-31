package com.adi.ServiceHub.dto;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "sp_final")
public class ServiceProviderFinal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sp_id;
	private String fname;
	private String lname;
	private String mobNumber;
	private String email;
	private String aadharNumber;
	private String gender;
	private String dateofbirth;
	private String specialization;
	private String officeAddress;
	private String city;
	private String tahsil;
	private String district;
	private String state;
	private String highQualification;
	private String universityName;
	private String experiance;

	@Column(nullable = false, columnDefinition = "MediumBlob")
	private byte[] licenceCertificate;

	@Column(nullable = false, columnDefinition = "MediumBlob")
	private byte[] photo;

	@Column(nullable = false, columnDefinition = "MediumBlob")
	private byte[] aadharImage;

	@Column(nullable = false, columnDefinition = "MediumBlob")
	private byte[] qualificationCertificate;
	private String userName;
	private String password;
	private String designation;
	public Integer getSp_id() {
		return sp_id;
	}
	public void setSp_id(Integer sp_id) {
		this.sp_id = sp_id;
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
	public String getMobNumber() {
		return mobNumber;
	}
	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTahsil() {
		return tahsil;
	}
	public void setTahsil(String tahsil) {
		this.tahsil = tahsil;
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
	public String getHighQualification() {
		return highQualification;
	}
	public void setHighQualification(String highQualification) {
		this.highQualification = highQualification;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getExperiance() {
		return experiance;
	}
	public void setExperiance(String experiance) {
		this.experiance = experiance;
	}
	public byte[] getLicenceCertificate() {
		return licenceCertificate;
	}
	public void setLicenceCertificate(byte[] licenceCertificate) {
		this.licenceCertificate = licenceCertificate;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public byte[] getAadharImage() {
		return aadharImage;
	}
	public void setAadharImage(byte[] aadharImage) {
		this.aadharImage = aadharImage;
	}
	public byte[] getQualificationCertificate() {
		return qualificationCertificate;
	}
	public void setQualificationCertificate(byte[] qualificationCertificate) {
		this.qualificationCertificate = qualificationCertificate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public ServiceProviderFinal(Integer sp_id, String fname, String lname, String mobNumber, String email,
			String aadharNumber, String gender, String dateofbirth, String specialization, String officeAddress,
			String city, String tahsil, String district, String state, String highQualification, String universityName,
			String experiance, byte[] licenceCertificate, byte[] photo, byte[] aadharImage,
			byte[] qualificationCertificate, String userName, String password, String designation) {
		super();
		this.sp_id = sp_id;
		this.fname = fname;
		this.lname = lname;
		this.mobNumber = mobNumber;
		this.email = email;
		this.aadharNumber = aadharNumber;
		this.gender = gender;
		this.dateofbirth = dateofbirth;
		this.specialization = specialization;
		this.officeAddress = officeAddress;
		this.city = city;
		this.tahsil = tahsil;
		this.district = district;
		this.state = state;
		this.highQualification = highQualification;
		this.universityName = universityName;
		this.experiance = experiance;
		this.licenceCertificate = licenceCertificate;
		this.photo = photo;
		this.aadharImage = aadharImage;
		this.qualificationCertificate = qualificationCertificate;
		this.userName = userName;
		this.password = password;
		this.designation = designation;
	}
	public ServiceProviderFinal() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ServiceProviderFinal [sp_id=" + sp_id + ", fname=" + fname + ", lname=" + lname + ", mobNumber="
				+ mobNumber + ", email=" + email + ", aadharNumber=" + aadharNumber + ", gender=" + gender
				+ ", dateofbirth=" + dateofbirth + ", specialization=" + specialization + ", officeAddress="
				+ officeAddress + ", city=" + city + ", tahsil=" + tahsil + ", district=" + district + ", state="
				+ state + ", highQualification=" + highQualification + ", universityName=" + universityName
				+ ", experiance=" + experiance + ", licenceCertificate=" + Arrays.toString(licenceCertificate)
				+ ", photo=" + Arrays.toString(photo) + ", aadharImage=" + Arrays.toString(aadharImage)
				+ ", qualificationCertificate=" + Arrays.toString(qualificationCertificate) + ", userName=" + userName
				+ ", password=" + password + ", designation=" + designation + "]";
	}
	
	

}
