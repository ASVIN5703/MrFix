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
	@Column(name="user_email")
    private String useremail;
    @Column(name="user_contact")
    private String usercontact;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUsercontact() {
		return usercontact;
	}
	public void setUsercontact(String usercontact) {
		this.usercontact = usercontact;
	}
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
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", userpass=" + userpass + ", useremail="
				+ useremail + ", usercontact=" + usercontact + "]";
	}
	
     		
}
