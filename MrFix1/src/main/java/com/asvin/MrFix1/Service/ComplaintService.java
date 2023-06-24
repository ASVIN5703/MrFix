package com.asvin.MrFix1.Service;

import java.util.List;

import com.asvin.MrFix1.Model.Complaint;

public interface ComplaintService {

	List<Complaint> getAllcomplaints();

	Complaint saveComplaint(Complaint complaint);
    
}
