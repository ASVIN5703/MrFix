package com.asvin.MrFix1.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.asvin.MrFix1.Model.Admin;
import com.asvin.MrFix1.Service.AdminService;
import com.asvin.MrFix1.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService{
    
	private AdminRepository adminrepo;
	public AdminServiceImpl(AdminRepository adminrepo) {
		
		this.adminrepo = adminrepo;
	}
	
	public Admin check(String email) {
		return adminrepo.findByEmailIdIgnoreCase(email);
	}
	@Override
	public Admin createAdmin(Admin adsignup) {
		Admin check= adminrepo.findByName(adsignup.getAdmin_name());
		 if(check==null)
		  return adminrepo.save(adsignup);
		 else return null;
		
	
	}

  //verify login password
	@Override
	public Admin verify(String admin_name) {
		
		
		return adminrepo.findByName(admin_name);
	}

	@Override
	public void activate(String code) {
		// TODO Auto-generated method stub
		System.out.println(code);
		Admin ad=adminrepo.findByCode(code);
		ad.setEnabled(true);
		adminrepo.save(ad);
	}
    
}
