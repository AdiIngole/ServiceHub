package com.adi.ServiceHub.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adi.ServiceHub.dao.AdminDAO;
import com.adi.ServiceHub.dto.Admin;
import com.adi.ServiceHub.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO adminDAO;

	@Override
	public Integer saveOrUpdateAdmin(Admin admin) {
		Admin admin2 = adminDAO.save(admin);
		return admin2.getAdminid();
	}

	@Override
	public List<Admin> getAll() {
		return adminDAO.findAll();
	}

	@Override
	public List<Admin> getAdminsByUserName(String userName) {
		List<Admin> admin = adminDAO.findByUsername(userName);
		if (admin != null) {
			return admin;
		}
		return null;
	}

}
