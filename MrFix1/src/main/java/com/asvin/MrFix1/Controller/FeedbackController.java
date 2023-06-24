package com.asvin.MrFix1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.asvin.MrFix1.Model.feedback;
import com.asvin.MrFix1.Service.feedbackService;

@Controller
public class FeedbackController {
       @Autowired
       private feedbackService feedservice;
       
	@GetMapping("/viewfeed")
	public String viewfeedbacks(Model model) {
		feedback feeds=new feedback();
		model.addAttribute("feeds",feeds);
		return "feedback.html";
		
	}
	@PostMapping("/postfeed")
	public String postfeeds(@ModelAttribute("feeds")feedback feeds){
		feedback feedba=feedservice.feedbackService(feeds);
		return "redirect:/viewfeed";
	}
	@GetMapping("/viewfeedbacks/all")
	public String viewallfeeds(Model model){
		List<feedback> all= feedservice.viewall();
		model.addAttribute("listfeeds",all);
		System.out.println("printingfwgregreg"+all);
		return "viewfeeds.html";
	}
	/*
	 * @GetMapping("/adfeedback") public String userfeedback() { return
	 * "viewfeeds.html"; }
	 */
	
}
