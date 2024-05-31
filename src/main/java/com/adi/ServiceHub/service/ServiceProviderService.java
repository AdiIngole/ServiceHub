package com.adi.ServiceHub.service;

import java.sql.Blob;
import java.util.List;

import com.adi.ServiceHub.dto.ServiceProviderFinal;
import com.adi.ServiceHub.dto.ServiceProviderRequest;
import com.adi.ServiceHub.dto.User;

public interface ServiceProviderService {

	// =======insert the service provider registration request Integero the
	// database..
	Integer saveOrUpdateServiceProvider(ServiceProviderRequest p);

	// =====get list of the service provider from data base.
	List<ServiceProviderFinal> getServiceProvider();

	// ====get service provider image list from database..
	Blob getSpImage(Integer id);

	// =====get service provider adhar card image from database..
	Blob getSpAdharImage(Integer id);

	// ===get service provider licence photo from database..
	Blob getSpLicence(Integer id);

	// ===get service provider qualification photo from database..
	Blob getSpQualificationImg(Integer id);

	// =====get the list of service provider registration request list
	List<ServiceProviderRequest> getList();

	// ==get service provider registration request image from database..
	Blob getspRequestImage(Integer id);

	// ==get service provider registartion request qualification certificate image
	// from database...
	Blob getspRequestQcertificate(Integer id);

	// ==get service provider registration request licence image from database...
	Blob getspReqeustlicence(Integer id);

	// ==get service provider registartion request Adhar card image from database...
	Blob getspRequestAddarImage(Integer id);

	// ===Reject service provider registration request from admin...
	Integer rejectServiceProvider(Integer id);

	// ===Accept Service provider registration request from admin...
	Integer acceptSpRequest(Integer id);

	// === delete service provider from database to through admin
	Integer deleteSrviceProvider(Integer id);

	// ==get designation related service provider for user...
	List<ServiceProviderFinal> getDrelatedSp(String designation);

	// ===get client appoIntegerment list for service provider ..
	List<User> getClient(String spuname);

	// get updated password when service provider forget his passowrd
	Integer updateSpPassword(ServiceProviderFinal s);

	// get service provider profile==========================
	List<ServiceProviderFinal> getSpProfile(ServiceProviderFinal s);

	// get service provider image for profile====
	Blob getSpImageProfile(ServiceProviderFinal s);

	ServiceProviderFinal getServiceProviderFinal(Integer id);

	ServiceProviderRequest getServiceProviderRequest(Integer id);

	ServiceProviderFinal getServiceProviderFinalByUserName(String userName);

	ServiceProviderRequest getServiceProviderRequestByUserName(String userName);

}
