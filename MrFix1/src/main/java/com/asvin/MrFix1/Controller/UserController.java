package com.asvin.MrFix1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asvin.MrFix1.Model.User;
import com.asvin.MrFix1.Service.UserService;





@Controller
//@RequestMapping("api/users")
public class UserController {
    @Autowired
	private UserService userservice;
  	//login page display
	@GetMapping("/userlogin")
	public String users(Model model) {
		User userlo=new User();
		model.addAttribute("userlo", userlo);
		return "userlogin.html";
	}
	 @PostMapping("/userlogin/verify")
	   public String verify(@ModelAttribute("userlo")User userlo) {
		   String user_name=userlo.getUser_name();
		   String user_pass=userlo.getUser_pass();
		boolean  verifylog=userservice.verifylogin(user_name,user_pass);
		   System.out.println(verifylog);
		   if(verifylog==false)return "redirect:/userlogin";
		   
	     	return "dashboard.html";
		   
	   } 
	//adding user data sets DB
	/*@PostMapping
   public ResponseEntity<User>  userlogin(@RequestBody User user) {
	
	   User savedUser= userservice.createUser(user);
	   return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
   }*/
	@PostMapping("/adduser/save")
	public String userlogin(@ModelAttribute("adduser")User adduser) {
		  User exist=userservice.verify(adduser.getUser_email());
		  if(exist==null) {
				 User savedUser= userservice.createUser(adduser);
                 
		  }
		 
		 return "admindashboard.html";
		
	}
	//add users
	   @GetMapping("/addusers")
		public String addusers(Model model) {
		    User adduser=new User();
		    model.addAttribute("adduser", adduser);
			return "adduser.html";
		}
	//get userby id
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id")int userid){
		User  UserById=userservice.getUserById(userid);
		return new ResponseEntity<>(UserById,HttpStatus.OK);	
	}
	@GetMapping("/allusers")
	public  String getAllUsers(Model model){
		List<User> allUsers=userservice.getAlluser();
		for( Object i: allUsers) {
			System.out.println(i);
		}
		model.addAttribute("allUsers", allUsers);
		return "manage.html";
		
	}
	 @GetMapping("/upusers")
		public String updatingusers(Model model) {
		    User updateuser=new User();
		    model.addAttribute("updateuser", updateuser);
			return "updateUser.html";
		}
	 @PostMapping("/updateUser/Data")
	 public String savingUsers(@ModelAttribute("updateuser")User updateuser) {
		  userservice.saveUser(updateuser);
		 return "admindashboard.html";
	 }
	 @GetMapping("/deleteusers/{user_id}")
	 public String delUser(@PathVariable(value = "user_id") int id) {
		 System.out.println("Entered deluser\n"+id);
		  userservice.deleteDoctorById(id);
		 return "admindashboard.html";
	 }
	@GetMapping("/allusers/view")
	public  String getUsers(Model model,@RequestParam("name") String name){
		  User allUsers= userservice.getOneUser(name);
		
		 System.out.println("Entered allusers view\n"+allUsers);
		  
		 model.addAttribute("allUsers", allUsers);
		 
		return "manage.html";
		
	}
	@GetMapping("/userdashboard")
	public String userdashboard() {
		return "dashboard.html";
	}
	@GetMapping("/profile")
	public String userprofile() {
		return "profile.html";
	}
	@GetMapping("/userfeedback")
	public String userfeedback() {
		return "feedback.html";
	}
	
	
	
}

