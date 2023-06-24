package com.asvin.MrFix1.Service.Impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asvin.MrFix1.Model.User;
import com.asvin.MrFix1.Service.UserService;
import com.asvin.MrFix1.repository.UserRepository;


@Service
public class UserImpl implements UserService{
	@Autowired
    private UserRepository userrepo;
	
	public User createUser(User user) {
		//if(user!=null)System.out.println(user.toString());
		return  userrepo.save(user);
	}

	@Override
	public User getUserById(int userid) {
		Optional<User> opusers= userrepo.findById(userid);
		return opusers.get();
	}
	public List<User> getAlluser() {
		// TODO Auto-generated method stub
		return (List<User>) userrepo.findAll();
	}
    
	public User verify(String user_email) {
		return userrepo.findByEmailIdIgnoreCase(user_email);
	}

	@Override
	public boolean verifylogin(String user_name, String user_pass) {
		// TODO Auto-generated method stub
		User u1=userrepo.findByName(user_name);
		User u2=userrepo.findBypass(user_pass);
		if(u1==null||u2==null)return false;
		String uname= u1.getUser_name();
		String upass=u2.getUser_pass();
		if((uname.equals(user_name))&&(upass.equals(user_pass))) {
			return true;
		}
		
		return false;
	}

	@Override
	public User getOneUser(String name) {
		     
              User val=userrepo.findByName(name);
              
           
              System.out.println("UserserviceImpl "+val);
		return  val;
	}

	@Override
	public void saveUser(User updateuser) {
		
		userrepo.save(updateuser);
	}

	@Override
	public void deleteDoctorById(int id) {
		
        userrepo.deleteById(id);		
	}
	

	

}