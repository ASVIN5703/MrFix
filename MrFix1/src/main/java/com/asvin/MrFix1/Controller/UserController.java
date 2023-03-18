package com.asvin.MrFix1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asvin.MrFix1.Model.User;
import com.asvin.MrFix1.Service.UserService;



@RestController

@RequestMapping("api/users")
public class UserController {
    @Autowired
	private UserService userservice;
	
	@GetMapping("/lo")
	public String users() {
		return "userlogin.html";
	}
	@PostMapping
   public ResponseEntity<User>  userlogin(@RequestBody User user) {
	
	   User savedUser= userservice.createUser(user);
	   return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
   }
}

