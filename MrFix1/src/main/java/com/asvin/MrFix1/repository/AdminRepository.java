package com.asvin.MrFix1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asvin.MrFix1.Model.Admin;
import com.asvin.MrFix1.Model.User;
public interface AdminRepository extends JpaRepository<Admin,Integer>{
	 @Query(value="select * from  admin  where admin_name like %?1", nativeQuery = true)
    public  Admin findByName(String admin_name);
	 @Query(value="select * from  admin  where admin_email like %?1", nativeQuery = true)
	   public Admin findByEmailIdIgnoreCase(String admin_email);
	 @Query(value="select * from admin where verification_code like %?1",nativeQuery=true)
	 public Admin findByCode(String code);
}
