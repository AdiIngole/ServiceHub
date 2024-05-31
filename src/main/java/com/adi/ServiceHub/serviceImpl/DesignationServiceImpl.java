package com.adi.ServiceHub.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adi.ServiceHub.dao.DesignationDao;
import com.adi.ServiceHub.dto.Designation;
import com.adi.ServiceHub.service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	DesignationDao designationDao;

	@Override
	public Integer saveOrUpdateDesignation(Designation designation) {
		Designation des = designationDao.findByDesignation(designation.getDesignation());
		if (des != null) {
			return -1;
		}
		Designation designation2 = designationDao.save(designation);
		return designation2.getId();
	}

	@Override
	public List<Designation> getAllDesignations() {
		return designationDao.findAll();
	}

}
