package com.asvin.MrFix1.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.asvin.MrFix1.Model.User;
@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
	 @Query(value="select * from  users  where user_name like %?1", nativeQuery = true)
	    public  User findByName(String user_name);
	 @Query(value="select * from  users  where user_email like %?1", nativeQuery = true)
	   public User findByEmailIdIgnoreCase(String user_email);
	  @Query(value="select * from users where user_pass  like %?1",nativeQuery=true)
	  public User findBypass(String user_pass);
	 
}
