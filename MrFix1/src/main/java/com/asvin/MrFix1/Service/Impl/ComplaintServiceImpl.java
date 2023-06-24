package com.asvin.MrFix1.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvin.MrFix1.Model.Complaint;
import com.asvin.MrFix1.Service.ComplaintService;
import com.asvin.MrFix1.repository.ComplaintRepository;
@Service
public class ComplaintServiceImpl implements ComplaintService {
    
	@Autowired
	private  ComplaintRepository complaintrepo; 
	@Override
	public List<Complaint> getAllcomplaints() {
		  
		return complaintrepo.findAll();
	}
	@Override
	public Complaint saveComplaint(Complaint complaint) {
	  
		return complaintrepo.save(complaint);
	}


}
