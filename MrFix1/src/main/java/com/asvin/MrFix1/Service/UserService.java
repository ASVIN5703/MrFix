package com.asvin.MrFix1.Service;


import java.util.List;


import com.asvin.MrFix1.Model.User;

public interface UserService {
      User createUser(User user);
	  User getUserById(int userid);
	 public User verify(String user_name);
	   List<User> getAlluser();
	boolean verifylogin(String user_name, String user_pass);
	User getOneUser(String name);
	void saveUser(User updateuser);
	void deleteDoctorById(int id);
	
}