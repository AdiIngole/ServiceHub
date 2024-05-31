package com.adi.ServiceHub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adi.ServiceHub.dto.Feedback;

@Repository
public interface FeedbackDAO extends JpaRepository<Feedback, Integer> {

}
