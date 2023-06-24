package com.asvin.MrFix1.Controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.asvin.MrFix1.Model.Complaint;
import com.asvin.MrFix1.PdfGen.Pdf;
import com.asvin.MrFix1.Service.ComplaintService;

@Controller
public class ComplaintController {
	@Autowired
	private ComplaintService complaintservice;
	@GetMapping("/complaints/all")
	public ResponseEntity<List<Complaint>> getAllComplaints() throws FileNotFoundException{
		 List<Complaint>allcomplaint= complaintservice.getAllcomplaints();
		 Pdf.generatePdf(allcomplaint);
		return new ResponseEntity<>(allcomplaint,HttpStatus.CREATED);
		
	}
	@GetMapping("/report")
	public String generateReport() throws FileNotFoundException{
		 List<Complaint>allcomplaint= complaintservice.getAllcomplaints();
		 Pdf.generatePdf(allcomplaint);
		 return "redirect:/addashboard";
	}
	@GetMapping("/complaints/view")
	public String viewComplaints(Model model) {
		List<Complaint> l=complaintservice.getAllcomplaints();
	
		model.addAttribute("listcomplaints",l);
		///System.out.println("THE complaints are");
	//	for(Object i: complaintservice.getAllcomplaints()) {
	//		System.out.println(i);
		//}
		return "viewcomp.html";
	}
	@GetMapping("/issueadd")
	public String issuepage(Model model) {
		Complaint issue=new Complaint();
		model.addAttribute("issue", issue);
		return "issue-form.html";
	}
	
	@PostMapping("/complaints/save")
	public String saveComplaint(@ModelAttribute("issue") Complaint complaint) {
		Complaint savedcomp=complaintservice.saveComplaint(complaint);
		System.out.println(complaint);
		//System.out.println("The saved complaint is"+ savedcomp);
		return "redirect:/userdashboard";
	}
    
}
