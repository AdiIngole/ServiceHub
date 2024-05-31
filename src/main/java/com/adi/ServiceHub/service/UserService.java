package com.adi.ServiceHub.service;

import java.util.List;

import com.adi.ServiceHub.dto.User;

public interface UserService {

	Integer saveOrUpdateUser(User user);

	List<User> getUserByUserName(String userName);

	List<User> getAll();

	Integer deleteUser(Integer userId);
	
	User getUserByFnameAndLnameAndEmail(String fname, String lname, String email);
}
