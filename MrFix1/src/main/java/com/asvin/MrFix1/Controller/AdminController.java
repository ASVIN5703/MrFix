package com.asvin.MrFix1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asvin.MrFix1.Dto.AdminDto;
import com.asvin.MrFix1.Model.Admin;
import com.asvin.MrFix1.Model.EmailDetails;
import com.asvin.MrFix1.Model.User;
import com.asvin.MrFix1.Service.AdminService;
import com.asvin.MrFix1.Service.EmailService;

@Controller 
public class AdminController {
	@Autowired
	private AdminDto adminDto;
	@Autowired
	private AdminService adminservice;
	@Autowired
	private EmailService  email;
	@GetMapping("/")
	public String home() {
		return "home.html";
	}
	@GetMapping("/adsignup")
	public String adminsignup(Model model) {
		Admin signup=new Admin();
		model.addAttribute("signup",signup);
		return "adminsignup.html";
	}
   @GetMapping("/adminlogin")
   public String admin(Model model) {
	   Admin adminlo=new Admin();
	  model.addAttribute("adminlo",adminlo);
	   return "Adminlogin.html";
   }
  
   @PostMapping("/adminlogin/verify")
   public String verify(@ModelAttribute("adminlo")Admin adminlo) {
	   String admin_name=adminlo.getAdmin_name();
	  
	   Admin verify=adminservice.verify(admin_name);
	   adminDto.setAdmin_id(verify.getAdmin_id());
	   adminDto.setAdmin_email(verify.getAdmin_email());
	   adminDto.setAdmin_pass(verify.getAdmin_pass());
	   adminDto.setAdmin_name(verify.getAdmin_name());
	   if(verify==null)return "redirect:/adminlogin";
     	return "Admindashboard.html";
	   
   } 
   
   
   @PostMapping("/adminlogin/save")
   public String adlogin(Model model,@ModelAttribute("signup")Admin signup) {
	//   System.out.println("the answwe is"+adminlo.getAdmin_name());
	     EmailDetails em=new EmailDetails();
	     em.setSubject("MrFix Account Verification");
	     em.setMsgBody("This is from Asvin");
	     em.setRecipient(signup.getAdmin_email());
	    // System.out.println(em);
	     String senttoken=email.sendSimpleMail(em);
	     System.out.println("The generated token is "+senttoken);
	     signup.setVerificationCode(senttoken);
	     
	    Admin saveAdmin=adminservice.createAdmin(signup);
	    if(saveAdmin==null) {
	    	return "redirect:/adminlogin";
	    }
	   return "checkMail.html";
   }
   @GetMapping("/adminaccount/verify")
   public  String adminenable(Model model, @RequestParam("token") String token) {
	      //System.out.println("got token"+token);
	        adminservice.activate(token);
	   return "activate.html";
   }
   /**update Admin Data**/
 
   @GetMapping("/update/Admin/Data")
	public String addusers(Model model) {
	    
	    model.addAttribute("adminDto", adminDto);
		return "adduser.html";
	}
   @GetMapping("/Manage")
   public String manage() {
	   return "redirect:/allusers";
   }
   @PostMapping("/Manage1")
   public String manageOne() {
	   return "managepage.html";
   }
  
   @GetMapping("/addashboard")
	public String admindashboard() {
		return "admindashboard.html";
	}
	@GetMapping("/adprofile")
	public String userprofile(Model model) {
		System.out.println(adminDto);
		model.addAttribute("adminDto",adminDto);
		return "adminprofile.html";
	}
	
	@GetMapping("/adissue")
	public String userissue() {
		return "adissue-form.html";
	}
}
