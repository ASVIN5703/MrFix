package com.asvin.MrFix1.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private int user_id;
	@Column(name="user_name")
    private String username;
	@Column(name="user_pass")
	private String userpass;
	@Column(name="user_email",unique=true)
    private String useremail;
	
	public String getUser_pass() {
		return userpass;
	}
	public void setUser_pass(String userpass) {
		this.userpass = userpass;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return username;
	}
	public void setUser_name(String username) {
		this.username = username;
	}
	public String getUser_email() {
		return useremail;
	}
	public void setUser_email(String useremail) {
		this.useremail = useremail;
	}
	
     		
}
