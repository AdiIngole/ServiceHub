package com.adi.ServiceHub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.ServiceHub.dto.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

	List<User> findByUsernameInAndIsAppointmentScheduledAndIsRejected(List<String> usernames, Boolean isAppointmentScheduled, Boolean isRejected);

	List<User> findByUsername(String user_name);

	List<User> findByUsernameAndPassword(String username, String password);

	List<User> findByUsernameAndEmail(String username, String email);
	
	User findByFnameAndLnameAndEmail(String fname, String lname, String email);

}
