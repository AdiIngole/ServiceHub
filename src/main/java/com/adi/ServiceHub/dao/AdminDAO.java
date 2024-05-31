package com.adi.ServiceHub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.ServiceHub.dto.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer> {
	List<Admin> findByUsernameAndPassword(String userName, String password);

	List<Admin> findByUsernameAndEmail(String userName, String email);

	List<Admin> findByUsername(String userName);
}
