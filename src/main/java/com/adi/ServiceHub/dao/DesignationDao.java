package com.adi.ServiceHub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.ServiceHub.dto.Designation;

@Repository
public interface DesignationDao extends JpaRepository<Designation, Integer> {

	Designation findByDesignation(String designation);
}
