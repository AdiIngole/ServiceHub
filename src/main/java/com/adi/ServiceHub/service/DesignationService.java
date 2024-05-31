package com.adi.ServiceHub.service;

import java.util.List;

import com.adi.ServiceHub.dto.Designation;

public interface DesignationService {

	Integer saveOrUpdateDesignation(Designation designation);

	List<Designation> getAllDesignations();
}
