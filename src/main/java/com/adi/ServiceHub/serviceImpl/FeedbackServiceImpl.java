package com.adi.ServiceHub.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adi.ServiceHub.dao.FeedbackDAO;
import com.adi.ServiceHub.dto.Feedback;
import com.adi.ServiceHub.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	FeedbackDAO feedbackDAO;

	@Override
	public Integer saveOrUpdateFeedback(Feedback f) {
		Feedback feedback = feedbackDAO.save(f);
		return feedback.getFid();
	}

	@Override
	public List<Feedback> getAllFeedback() {
		return feedbackDAO.findAll();
	}

	@Override
	public Integer deleteFeedback(Feedback f) {
		if(f.getFid()!=null) {
			Feedback feedback = feedbackDAO.findById(f.getFid()).get();
			if (feedback != null) {
				feedbackDAO.deleteById(f.getFid());
				return feedback.getFid();
			} else {
				return null;
			}
		} else {
			return null;
		}
		
	}

}
