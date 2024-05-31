package com.adi.ServiceHub.serviceImpl;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adi.ServiceHub.dao.AppointmentDAO;
import com.adi.ServiceHub.dao.ServiceProviderFinalDAO;
import com.adi.ServiceHub.dao.ServiceProviderRequestDAO;
import com.adi.ServiceHub.dao.UserDAO;
import com.adi.ServiceHub.dto.Appointment;
import com.adi.ServiceHub.dto.ServiceProviderFinal;
import com.adi.ServiceHub.dto.ServiceProviderRequest;
import com.adi.ServiceHub.dto.User;
import com.adi.ServiceHub.service.ServiceProviderService;

@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

	@Autowired
	ServiceProviderRequestDAO serviceProviderRequestDAO;

	@Autowired
	ServiceProviderFinalDAO serviceProviderFinalDAO;

	@Autowired
	AppointmentDAO appointmentDAO;

	@Autowired
	UserDAO userDAO;

	@Override
	public Integer saveOrUpdateServiceProvider(ServiceProviderRequest p) {
		ServiceProviderRequest serviceProvider = serviceProviderRequestDAO.save(p);
		return serviceProvider.getSp_id();
	}

	@Override
	public List<ServiceProviderFinal> getServiceProvider() {
		return serviceProviderFinalDAO.findAll();
	}

	@Override
	public Blob getSpImage(Integer id) {
		ServiceProviderFinal provider = serviceProviderFinalDAO.findById(id).get();
		byte[] multipartFile = provider.getPhoto();
		return getBlobFromByte(multipartFile);
	}

	@Override
	public Blob getSpAdharImage(Integer id) {
		ServiceProviderFinal provider = serviceProviderFinalDAO.findById(id).get();
		byte[] multipartFile = provider.getAadharImage();
		return getBlobFromByte(multipartFile);
	}

	@Override
	public Blob getSpLicence(Integer id) {
		ServiceProviderFinal provider = serviceProviderFinalDAO.findById(id).get();
		byte[] multipartFile = provider.getLicenceCertificate();
		return getBlobFromByte(multipartFile);
	}

	@Override
	public Blob getSpQualificationImg(Integer id) {
		ServiceProviderFinal provider = serviceProviderFinalDAO.findById(id).get();
		byte[] multipartFile = provider.getQualificationCertificate();
		return getBlobFromByte(multipartFile);
	}

	@Override
	public List<ServiceProviderRequest> getList() {
		return serviceProviderRequestDAO.findAll();
	}

	@Override
	public Blob getspRequestImage(Integer id) {
		ServiceProviderRequest provider = serviceProviderRequestDAO.findById(id).get();
		byte[] multipartFile = provider.getPhoto();
		return getBlobFromByte(multipartFile);
	}

	@Override
	public Blob getspRequestQcertificate(Integer id) {
		ServiceProviderRequest provider = serviceProviderRequestDAO.findById(id).get();
		byte[] multipartFile = provider.getQualificationCertificate();
		return getBlobFromByte(multipartFile);
	}

	@Override
	public Blob getspReqeustlicence(Integer id) {
		ServiceProviderRequest provider = serviceProviderRequestDAO.findById(id).get();
		byte[] multipartFile = provider.getLicenceCertificate();
		return getBlobFromByte(multipartFile);
	}

	@Override
	public Blob getspRequestAddarImage(Integer id) {
		ServiceProviderRequest provider = serviceProviderRequestDAO.findById(id).get();
		byte[] multipartFile = provider.getAadharImage();
		return getBlobFromByte(multipartFile);
	}

	@Override
	public Integer rejectServiceProvider(Integer id) {
		ServiceProviderRequest provider = serviceProviderRequestDAO.findById(id).get();
		if (provider != null) {
			serviceProviderRequestDAO.deleteById(id);
			return provider.getSp_id();
		}
		return null;
	}

	@Override
	public Integer acceptSpRequest(Integer id) {
		ServiceProviderRequest serviceProviderRequest = serviceProviderRequestDAO.findById(id).get();
		ServiceProviderFinal serviceProviderFinal = new ServiceProviderFinal();
		BeanUtils.copyProperties(serviceProviderRequest, serviceProviderFinal);
		serviceProviderFinal = serviceProviderFinalDAO.save(serviceProviderFinal);
		serviceProviderRequestDAO.deleteById(id);
		return serviceProviderFinal.getSp_id();
	}

	@Override
	public Integer deleteSrviceProvider(Integer id) {
		ServiceProviderFinal serviceProvider = serviceProviderFinalDAO.findById(id).get();
		if (serviceProvider != null) {
			serviceProviderFinalDAO.deleteById(id);
			return serviceProvider.getSp_id();
		}
		return null;
	}

	@Override
	public List<ServiceProviderFinal> getDrelatedSp(String designation) {
		return serviceProviderFinalDAO.findByDesignation(designation);
	}

	@Override
	public List<User> getClient(String spuname) {
		List<Appointment> appointments = appointmentDAO.findBySpuname(spuname);
		List<String> cuNames = new ArrayList<String>();
		for (Appointment appointment : appointments) {
			cuNames.add(appointment.getCuname());
		}
		List<User> users = userDAO.findByUsernameInAndIsAppointmentScheduledAndIsRejected(cuNames, false, false);
		return users;
	}

	@Override
	public Integer updateSpPassword(ServiceProviderFinal s) {
		ServiceProviderFinal serviceProviderFinal = serviceProviderFinalDAO.save(s);
		return serviceProviderFinal.getSp_id();
	}

	@Override
	public List<ServiceProviderFinal> getSpProfile(ServiceProviderFinal s) {
		return serviceProviderFinalDAO.findByUserName(s.getUserName());
	}

	@Override
	public Blob getSpImageProfile(ServiceProviderFinal s) {
		ServiceProviderFinal provider = serviceProviderFinalDAO.findByUserName(s.getUserName()).get(0);
		byte[] multipartFile = provider.getPhoto();
		return getBlobFromByte(multipartFile);
	}

	private Blob getBlobFromByte(byte[] myByte) {
		Blob blob = null;
		try {
			blob = new SerialBlob(myByte);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blob;
	}

	@Override
	public ServiceProviderFinal getServiceProviderFinal(Integer id) {
		ServiceProviderFinal serviceProviderFinal = serviceProviderFinalDAO.findById(id).get();
		if (serviceProviderFinal != null) {
			return serviceProviderFinal;
		}
		return null;
	}

	@Override
	public ServiceProviderRequest getServiceProviderRequest(Integer id) {
		ServiceProviderRequest serviceProviderRequest = serviceProviderRequestDAO.findById(id).get();
		if (serviceProviderRequest != null) {
			return serviceProviderRequest;
		}
		return null;
	}

	@Override
	public ServiceProviderFinal getServiceProviderFinalByUserName(String userName) {
		ServiceProviderFinal serviceProviderFinal = serviceProviderFinalDAO.findByUserName(userName).get(0);
		if (serviceProviderFinal != null) {
			return serviceProviderFinal;
		}
		return null;
	}

	@Override
	public ServiceProviderRequest getServiceProviderRequestByUserName(String userName) {
		ServiceProviderRequest serviceProviderRequest = serviceProviderRequestDAO.findByUserName(userName).get(0);
		if (serviceProviderRequest != null) {
			return serviceProviderRequest;
		}
		return null;
	}

}
