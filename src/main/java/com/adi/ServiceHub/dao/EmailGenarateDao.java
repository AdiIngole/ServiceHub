package com.adi.ServiceHub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.ServiceHub.dto.EmailGenerate;

@Repository
public interface EmailGenarateDao extends JpaRepository<EmailGenerate, Integer> {

}
