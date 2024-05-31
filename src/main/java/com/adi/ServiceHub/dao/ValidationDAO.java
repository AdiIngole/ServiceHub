package com.adi.ServiceHub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.ServiceHub.dto.Validation;

@Repository
public interface ValidationDAO extends JpaRepository<Validation, Integer> {

}
