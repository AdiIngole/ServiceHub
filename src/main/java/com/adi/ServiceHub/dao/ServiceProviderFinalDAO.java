package com.adi.ServiceHub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.ServiceHub.dto.ServiceProviderFinal;

@Repository
public interface ServiceProviderFinalDAO extends JpaRepository<ServiceProviderFinal, Integer> {

	List<ServiceProviderFinal> findByDesignation(String designation);

	List<ServiceProviderFinal> findByUserName(String userName);

	List<ServiceProviderFinal> findByUserNameAndPassword(String userName, String password);

	List<ServiceProviderFinal> findByUserNameAndEmail(String userName, String email);

}
