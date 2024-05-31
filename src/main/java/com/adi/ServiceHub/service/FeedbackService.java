package com.adi.ServiceHub.service;

import java.util.List;

import com.adi.ServiceHub.dto.Feedback;

public interface FeedbackService {

	Integer saveOrUpdateFeedback(Feedback f);

	List<Feedback> getAllFeedback();

	Integer deleteFeedback(Feedback f);
}
