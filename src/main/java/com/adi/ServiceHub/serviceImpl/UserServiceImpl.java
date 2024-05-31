package com.adi.ServiceHub.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adi.ServiceHub.dao.UserDAO;
import com.adi.ServiceHub.dto.User;
import com.adi.ServiceHub.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public Integer saveOrUpdateUser(User user) {
		return userDAO.save(user).getUserId();
	}

	@Override
	public List<User> getUserByUserName(String userName) {
		return userDAO.findByUsername(userName);
	}

	@Override
	public List<User> getAll() {
		return userDAO.findAll();
	}

	@Override
	public Integer deleteUser(Integer userId) {
		User user = userDAO.findById(userId).get();
		if (user != null) {
			userDAO.deleteById(userId);
			return user.getUserId();
		}
		return null;
	}

	@Override
	public User getUserByFnameAndLnameAndEmail(String fname, String lname, String email) {
		User user = userDAO.findByFnameAndLnameAndEmail(fname, lname, email);
		if (user != null) {
			return user;
		}
		return null;
	}

}
