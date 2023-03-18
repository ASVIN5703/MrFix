package com.asvin.MrFix1.Service.Impl;

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
		if(user!=null)System.out.println(user.toString());
		return  userrepo.save(user);
	}

	

	

}