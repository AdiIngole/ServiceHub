package com.adi.ServiceHub.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adi.ServiceHub.dao.AdminDAO;
import com.adi.ServiceHub.dao.ServiceProviderFinalDAO;
import com.adi.ServiceHub.dao.UserDAO;
import com.adi.ServiceHub.dto.Admin;
import com.adi.ServiceHub.dto.ServiceProviderFinal;
import com.adi.ServiceHub.dto.User;
import com.adi.ServiceHub.dto.Validation;
import com.adi.ServiceHub.service.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {

	@Autowired
	UserDAO userDAO;

	@Autowired
	ServiceProviderFinalDAO serviceProviderFinalDAO;

	@Autowired
	AdminDAO adminDAO;

	@Override
	public int userValidation(Validation v) {
		List<User> users = userDAO.findByUsernameAndPassword(v.getUsername(), v.getPassword());
		return users.size() > 0 ? 1 : 0;
	}

	@Override
	public int serviceProviderValidation(Validation v) {
		List<ServiceProviderFinal> serviceProviderFinals = serviceProviderFinalDAO
				.findByUserNameAndPassword(v.getUsername(), v.getPassword());
		return serviceProviderFinals.size() > 0 ? 1 : 0;
	}

	@Override
	public int adminValidation(Validation v) {
		List<Admin> admins = adminDAO.findByUsernameAndPassword(v.getUsername(), v.getPassword());
		System.out.println(admins.size());
		return admins.size() > 0 ? 1 : 0;
	}

	@Override
	public String getOtp() {
		String otp = "";
		for (int i = 1; i < 7; i++) {
			int a;
			a = (int) (Math.random() * 10);
			otp = otp + a;
		}
		return otp;
	}

	@Override
	public int getValidUserEmail(Validation v) {
		List<User> users = userDAO.findByUsernameAndEmail(v.getUsername(), v.getEmail());
		return users.size() > 0 ? 1 : 0;
	}

	@Override
	public int getValidSpEmailUname(Validation v) {
		List<ServiceProviderFinal> serviceProviderFinals = serviceProviderFinalDAO
				.findByUserNameAndEmail(v.getUsername(), v.getEmail());
		return serviceProviderFinals.size() > 0 ? 1 : 0;
	}

	@Override
	public int getValidAdminEmailUname(Validation v) {
		List<Admin> admins = adminDAO.findByUsernameAndEmail(v.getUsername(), v.getEmail());
		return admins.size() > 0 ? 1 : 0;
	}

}
