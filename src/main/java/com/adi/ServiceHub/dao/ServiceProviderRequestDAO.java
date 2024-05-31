package com.adi.ServiceHub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.ServiceHub.dto.ServiceProviderRequest;

@Repository
public interface ServiceProviderRequestDAO extends JpaRepository<ServiceProviderRequest, Integer> {

	List<ServiceProviderRequest> findByUserName(String userName);

}
