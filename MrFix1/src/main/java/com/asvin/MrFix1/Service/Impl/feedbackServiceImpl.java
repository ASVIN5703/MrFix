package com.asvin.MrFix1.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvin.MrFix1.Model.feedback;
import com.asvin.MrFix1.Service.feedbackService;
import com.asvin.MrFix1.repository.feedbackRepository;
@Service
public class feedbackServiceImpl implements feedbackService{
	@Autowired
	private feedbackRepository feedrepo;
    
	@Override
	public feedback feedbackService(feedback feeds) {
		// TODO Auto-generated method stub
		  return feedrepo.save(feeds);
	}

	@Override
	public List<feedback> viewall() {
	
		return feedrepo.findAll();
	}
 
}
