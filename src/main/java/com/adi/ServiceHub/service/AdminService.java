package com.adi.ServiceHub.service;

import java.util.List;

import com.adi.ServiceHub.dto.Admin;

public interface AdminService {

	Integer saveOrUpdateAdmin(Admin admin);

	List<Admin> getAll();

	List<Admin> getAdminsByUserName(String userName);

}
